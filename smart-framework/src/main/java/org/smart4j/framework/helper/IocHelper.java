/**
 * 
 */
package org.smart4j.framework.helper;

import java.lang.reflect.Field;
import java.util.Map;

import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.CollectionUtil;
import org.smart4j.framework.util.ReflectionUtil;

/**
 *
 *
 * Author: wangkai
 * Edit Time: 2016年4月3日  下午2:44:28 
 */
public class IocHelper {

	static {
		//获取beanMap
		Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
		if (CollectionUtil.isNotEmpty(beanMap)) {
			for(Map.Entry<Class<?>, Object> beanEntry:beanMap.entrySet()) {
				Class<?> beanClass = beanEntry.getKey();
				Object beanInstance = beanEntry.getValue();
				Field[] beanFields = beanClass.getDeclaredFields();
				if (ArrayUtil.isNotEmpty(beanFields)) {
					//遍历每个Bean的所有属性，如果有Inject注解的，那么通过反射实例化，并赋值
					for (Field beanField : beanFields) {
						if (beanField.isAnnotationPresent(Inject.class)) {
							Class<?> beanFieldClass = beanField.getType();
							Object beanFieldInstance = beanMap.get(beanFieldClass);
							if (beanFieldInstance != null) {
								ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
							}
						}
					}
				}
			}
		}
	}
}
