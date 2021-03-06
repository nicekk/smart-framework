/**
 * 
 */
package org.smart4j.framework;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.smart4j.framework.bean.Data;
import org.smart4j.framework.bean.Handler;
import org.smart4j.framework.bean.Param;
import org.smart4j.framework.bean.View;
import org.smart4j.framework.helper.BeanHelper;
import org.smart4j.framework.helper.ConfigHelper;
import org.smart4j.framework.helper.ControllerHelper;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.CodecUtil;
import org.smart4j.framework.util.JSONUtil;
import org.smart4j.framework.util.ReflectionUtil;
import org.smart4j.framework.util.StreamUtil;
import org.smart4j.framework.util.StringUtil;

/**
 * 请求转发器
 *
 * Author: wangkai
 * Edit Time: 2016年4月4日  下午4:55:54 
 */
@WebServlet(urlPatterns="/*",loadOnStartup= 0)
public class DispatcherServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6668915447714025956L;

	@Override
	public void init() throws ServletException {
		//初始化相关类
		HelperLoader.init();
		//获取servletContext对象，用于注册servlet
		ServletContext servletContext = getServletConfig().getServletContext();
		//注册处理JSP的servlet
		ServletRegistration jspServlet=  servletContext.getServletRegistration("jsp");
		jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");
		//注册处理默认静态资源的servlet
		ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
		defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求方法与请求路径
		String requestMethod = req.getMethod().toLowerCase();
		String requestPath  = req.getPathInfo();
		//获取Action处理器
		Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
		if (handler != null) {
			//获取controller类及其Bean实例
			Class<?> controllerClass = handler.getControllerClass();
			Object controllerBean = BeanHelper.getBean(controllerClass);
			//创建请求参数对象
			Map<String, Object> paramMap = new HashMap<String, Object>();
			Enumeration<String> paramNames = req.getParameterNames();
			while (paramNames.hasMoreElements()) {
				String paramName = (String) paramNames.nextElement();
				String paramValue = req.getParameter(paramName);
				paramMap.put(paramName, paramValue);
			}
			String body = CodecUtil.decodeURL(StreamUtil.getString(req.getInputStream()));
			if (StringUtil.isNotEmpty(body)) {
				String[] params = StringUtil.splitString(body, "&");
				if (ArrayUtil.isNotEmpty(params)) {
					for (String param:params) {
						String[] array = StringUtil.splitString(param, "=");
						if (ArrayUtil.isNotEmpty(array) & array.length == 2) {
							String paramName = array[0];
							String paramValue = array[1];
							paramMap.put(paramName, paramValue);
						}
					}
				}
			}
			Param param = new Param(paramMap);
			//调用Action方法
			Method actionMethod  = handler.getActionMethod();
			Object result  = ReflectionUtil.invokeMethod(controllerBean, actionMethod, param);
			if (result instanceof View) {
				//返回JSP页面
				View view = (View) result;
				String path = view.getPath();
				if (StringUtil.isNotEmpty(path)) {
					if (path.startsWith("/")) {
						resp.sendRedirect(req.getContextPath() + path);
					} else {
						Map<String , Object> model = view.getModel();
						for (Map.Entry<String, Object> entry : model.entrySet()) {
							req.setAttribute(entry.getKey(), entry.getValue());
						}
						req.getRequestDispatcher(ConfigHelper.getAppJspPath() +path).forward(req, resp);
					}
				}
			} else if (result instanceof Data) {
				//返回JSON数据
				Data data = (Data)result;
				Object model = data.getModel();
				if (model != null) {
					resp.setContentType("application/json");
					resp.setCharacterEncoding("UTF-8");
					PrintWriter writer = resp.getWriter();
					String json = JSONUtil.toJson(model);
					writer.write(json);
					writer.flush();
					writer.close();
				}
			}
		}
	}
	
	

	
}
