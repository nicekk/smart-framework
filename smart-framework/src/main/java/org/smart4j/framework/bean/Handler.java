/**
 * 
 */
package org.smart4j.framework.bean;

import java.lang.reflect.Method;

/**
 * 封装Action信息
 *
 * Author: wangkai
 * Edit Time: 2016年4月4日  下午4:33:32 
 */
public class Handler {

	/**
	 * controller类
	 */
	private Class<?> controllerClass;
	
	/**
	 * Action 方法
	 */
	private Method actionMethod;

	/**
	 * @param controllerClass
	 * @param actionMethod
	 */
	public Handler(Class<?> controllerClass, Method actionMethod) {
		super();
		this.controllerClass = controllerClass;
		this.actionMethod = actionMethod;
	}

	public Class<?> getControllerClass() {
		return controllerClass;
	}

	public void setControllerClass(Class<?> controllerClass) {
		this.controllerClass = controllerClass;
	}

	public Method getActionMethod() {
		return actionMethod;
	}

	public void setActionMethod(Method actionMethod) {
		this.actionMethod = actionMethod;
	}
	
	
}
