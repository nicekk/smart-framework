/**
 * 
 */
package org.smart4j.framework.util;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

/**
 * @author: wangkai
 * 
 * Date: 2016年4月3日  上午1:11:14 
 */
public class CollectionUtil {

	/**
	 * 集合是否为 空
	 * @param collection
	 * @return
	 */
	public static boolean isEmpty(Collection<?> collection) {
		return CollectionUtils.isEmpty(collection);
	}
	
	/**
	 * 集合是否非空
	 * @param collection
	 * @return
	 */
	public static boolean isNotEmpty(Collection<?> collection) {
		return !isEmpty(collection);
	}
	
	/**
	 * map是否为空
	 * @param map
	 * @return
	 */
	public static boolean isEmpty(Map<?, ?> map) {
		return MapUtils.isEmpty(map);
	}
	
	/**
	 * map是否非空
	 * @param map
	 * @return
	 */
	public static boolean isNotEmpty(Map<?, ?> map) {
		return !isEmpty(map);
	}
}
