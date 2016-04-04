/**
 * 
 */
package org.smart4j.framework.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.smart4j.framework.util.ReflectionUtil;


/**
 * Bean助手
 *
 * Author: wangkai
 * Edit Time: 2016年4月3日  下午2:37:04 
 */
public class BeanHelper {

	private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>,Object>();
	
	static {
		Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
		for (Class<?> cls : beanClassSet) {
			Object obj = ReflectionUtil.newInstance(cls);
			BEAN_MAP.put(cls, obj);
		}
	}
	
	/**
	 * 获取beanmap
	 * @return
	 */
	public static Map<Class<?>, Object> getBeanMap()  {
		return BEAN_MAP;
	}
	
	/**
	 * 获取Bean实例
	 * 
	 * @param cls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<?> cls) {
		if (!BEAN_MAP.containsKey(cls)) {
			throw new RuntimeException("can not get bean class " + cls);
		}
		return (T) BEAN_MAP.get(cls);
	}
	
}
