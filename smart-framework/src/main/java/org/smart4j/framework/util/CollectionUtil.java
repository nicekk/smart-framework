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
 * Date: 2016��4��3��  ����1:11:14 
 */
public class CollectionUtil {

	/**
	 * �����Ƿ�Ϊ ��
	 * @param collection
	 * @return
	 */
	public static boolean isEmpty(Collection<?> collection) {
		return CollectionUtils.isEmpty(collection);
	}
	
	/**
	 * �����Ƿ�ǿ�
	 * @param collection
	 * @return
	 */
	public static boolean isNotEmpty(Collection<?> collection) {
		return !isEmpty(collection);
	}
	
	/**
	 * map�Ƿ�Ϊ��
	 * @param map
	 * @return
	 */
	public static boolean isEmpty(Map<?, ?> map) {
		return MapUtils.isEmpty(map);
	}
	
	/**
	 * map�Ƿ�ǿ�
	 * @param map
	 * @return
	 */
	public static boolean isNotEmpty(Map<?, ?> map) {
		return !isEmpty(map);
	}
}
