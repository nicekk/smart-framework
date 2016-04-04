/**
 * 
 */
package org.smart4j.framework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 数组工具类
 *
 * Author: wangkai
 * Edit Time: 2016年4月3日  下午2:46:21 
 */
public class ArrayUtil {

	/**
	 * 判断数组是否为空
	 * @param array
	 * @return
	 */
	public static boolean isEmpty(Object[] array) {
		return ArrayUtils.isEmpty(array);
	}
	
	/**
	 * 判断数据是否非空
	 */
	public static boolean isNotEmpty(Object[] array) {
		return !isEmpty(array);
	}
}
