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
 * ������������
 *
 * Author: wangkai
 * Edit Time: 2016��4��4��  ����4:29:24 
 */
public class ControllerHelper {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerHelper.class);

	private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();
	
	static {
		//��ȡ���е�controller��
		Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
		if (CollectionUtil.isNotEmpty(controllerClassSet)) {
			for (Class<?> controllerClass : controllerClassSet) {
				//��ȡcontroller���ж���ķ���
				Method[] methods = controllerClass.getDeclaredMethods();
				if (ArrayUtil.isNotEmpty(methods)) {
					for (Method method : methods) {
						//�жϵ�ǰ�����Ƿ����Actionע��
						if (method.isAnnotationPresent(Action.class)) {
							//��Actionע���л�ȡURLӳ�����
							Action action = method.getAnnotation(Action.class);
							String mapping = action.value();
							//��֤urlӳ�����
							if (mapping.matches("\\w+:/\\w*")) {
								String[] array = mapping.split(":");
								if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
									//��ȡ���󷽷�������·��
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
	 * ��ȡhandler
	 * @param requestMethod
	 * @param requestPath
	 * @return
	 */
	public static Handler getHandler(String requestMethod,String requestPath) {
		Request request = new Request(requestMethod, requestPath);
		return ACTION_MAP.get(request);
	}
}
