/**
 * 
 */
package org.smart4j.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: wangkai
 * 
 * Date: 2016年4月3日  上午12:50:15 
 */
public class StringUtil {

	/**
	 * 判断字符串是否为空
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
	 * 判断字符串是否非空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	
	/**
	 * 转换为大写
	 * @param str
	 * @return
	 */
	public static String toUpperCase(String str) {
		return str.toUpperCase();
	}
	
	/**
	 * 将字符串分割
	 * @param str
	 * @param sign
	 * @return
	 */
	public static String[] splitString(String str,String sign) {
		return str.split(sign);
	}
}
