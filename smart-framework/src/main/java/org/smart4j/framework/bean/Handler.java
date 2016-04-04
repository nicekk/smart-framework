/**
 * 
 */
package org.smart4j.framework.bean;

import java.lang.reflect.Method;

/**
 * ��װAction��Ϣ
 *
 * Author: wangkai
 * Edit Time: 2016��4��4��  ����4:33:32 
 */
public class Handler {

	/**
	 * controller��
	 */
	private Class<?> controllerClass;
	
	/**
	 * Action ����
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
