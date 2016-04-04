/**
 * 
 */
package org.smart4j.framework.helper;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.bean.Handler;
import org.smart4j.framework.bean.Request;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.CollectionUtil;

/**
 * 控制器帮助类
 *
 * Author: wangkai
 * Edit Time: 2016年4月4日  下午4:29:24 
 */
public class ControllerHelper {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerHelper.class);

	private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();
	
	static {
		//获取所有的controller类
		Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
		if (CollectionUtil.isNotEmpty(controllerClassSet)) {
			for (Class<?> controllerClass : controllerClassSet) {
				//获取controller类中定义的方法
				Method[] methods = controllerClass.getDeclaredMethods();
				if (ArrayUtil.isNotEmpty(methods)) {
					for (Method method : methods) {
						//判断当前方法是否带有Action注解
						if (method.isAnnotationPresent(Action.class)) {
							//从Action注解中获取URL映射规则
							Action action = method.getAnnotation(Action.class);
							String mapping = action.value();
							//验证url映射规则
							if (mapping.matches("\\w+:/\\w*")) {
								String[] array = mapping.split(":");
								if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
									//获取请求方法与请求路径
									String requestMethod = array[0];
									String requestPath = array[1];
									Request request = new Request(requestMethod, requestPath);	
									Handler handler = new Handler(controllerClass, method);
									ACTION_MAP.put(request, handler);
								}
							}
						}
					}
				}
			}
		}
		LOGGER.error("controllerMap:" + ACTION_MAP);
	}
	
	/**
	 * 获取handler
	 * @param requestMethod
	 * @param requestPath
	 * @return
	 */
	public static Handler getHandler(String requestMethod,String requestPath) {
		Request request = new Request(requestMethod, requestPath);
		return ACTION_MAP.get(request);
	}
}
