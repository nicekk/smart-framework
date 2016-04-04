/**
 * 
 */
package org.smart4j.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: wangkai
 * 
 * Date: 2016��4��3��  ����12:50:15 
 */
public class StringUtil {

	/**
	 * �ж��ַ����Ƿ�Ϊ��
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str != null) {
			str = str.trim();
		}
		return StringUtils.isEmpty(str);
	}
	
	/**
	 * �ж��ַ����Ƿ�ǿ�
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	
	/**
	 * ת��Ϊ��д
	 * @param str
	 * @return
	 */
	public static String toUpperCase(String str) {
		return str.toUpperCase();
	}
	
	/**
	 * ���ַ����ָ�
	 * @param str
	 * @param sign
	 * @return
	 */
	public static String[] splitString(String str,String sign) {
		return str.split(sign);
	}
}
