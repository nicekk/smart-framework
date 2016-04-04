/**
 * 
 */
package org.smart4j.framework.helper;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.annotation.Service;
import org.smart4j.framework.util.ClassUtil;

/**
 *
 *
 * Author: wangkai Edit Time: 2016年4月3日 下午2:23:12
 */
public class ClassHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClassHelper.class);

	private static final Set<Class<?>> CLASS_SET;

	static {
		String basePackageName = ConfigHelper.getAppBasePackage();
		CLASS_SET = ClassUtil.getClassSet(basePackageName);
		LOGGER.error("class_set=" + CLASS_SET);
	}

	/**
	 * 获取应用包名下的所有类
	 * 
	 * @return
	 */
	public static Set<Class<?>> getClassSet() {
		return CLASS_SET;
	}

	/**
	 * 获取应用包名下的所有service类
	 * 
	 * @return
	 */
	public static Set<Class<?>> getServiceClassSet() {
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		for (Class<?> cls : CLASS_SET) {
			if (cls.isAnnotationPresent(Service.class)) {
				classSet.add(cls);
			}
		}
		return classSet;
	}

	/**
	 * 获取应用包名下的所有controller类
	 * 
	 * @return
	 */
	public static Set<Class<?>> getControllerClassSet() {
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		for (Class<?> cls : CLASS_SET) {
			if (cls.isAnnotationPresent(Controller.class)) {
				classSet.add(cls);
			}
		}
		return classSet;
	}

	/**
	 * 获取所有Bean类(service，controller)
	 * 
	 * @return
	 */
	public static Set<Class<?>> getBeanClassSet() {
		Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
		beanClassSet.addAll(getServiceClassSet());
		beanClassSet.addAll(getControllerClassSet());
		return beanClassSet;
	}

}
