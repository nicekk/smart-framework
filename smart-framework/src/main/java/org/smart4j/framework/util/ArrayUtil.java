/**
 * 
 */
package org.smart4j.framework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * ���鹤����
 *
 * Author: wangkai
 * Edit Time: 2016��4��3��  ����2:46:21 
 */
public class ArrayUtil {

	/**
	 * �ж������Ƿ�Ϊ��
	 * @param array
	 * @return
	 */
	public static boolean isEmpty(Object[] array) {
		return ArrayUtils.isEmpty(array);
	}
	
	/**
	 * �ж������Ƿ�ǿ�
	 */
	public static boolean isNotEmpty(Object[] array) {
		return !isEmpty(array);
	}
}
