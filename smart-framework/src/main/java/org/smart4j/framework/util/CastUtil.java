/**
 * 
 */
package org.smart4j.framework.util;

/**
 * 转型操作工具类
 * 
 * @author: wangkai
 * 
 * Date: 2016年4月3日  上午12:53:11 
 */
public class CastUtil {

	/**
	 * 转换成string型
	 * 
	 * @param object
	 * @return
	 */
	public static String castString(Object object) {
		return CastUtil.castString(object,"");
	}

	/**
	 * 转换成string型，有默认值
	 * 
	 * @param object
	 * @param string
	 * @return
	 */
	public static String castString(Object object, String defaultValue) {
		return object != null ? String.valueOf(object) : defaultValue;
	}
	
	/**
	 * 转换为double型
	 * @param object
	 * @return
	 */
	public static double castDouble(Object object) {
		return CastUtil.castDouble(object,0);
	}

	/**
	 * 转换为double型，有默认值
	 * @param object
	 * @param i
	 * @return
	 */
	public static double castDouble(Object object, double defaultValue) {
		double value = defaultValue;
		if (object != null) {
			String strValue = castString(object);
			if (StringUtil.isNotEmpty(strValue)) {
				try {
					value = Double.parseDouble(strValue);
				} catch (NumberFormatException e) {
					value = defaultValue;
				}
			}
		}
		return value;
	}
	
	
	/**
	 * 转换为long型
	 * @param object
	 * @return
	 */
	public static long castLong(Object object) {
		return CastUtil.castLong(object,0);
	}

	/**
	 * 转换为long型，有默认值
	 * @param object
	 * @param i
	 * @return
	 */
	public static long castLong(Object object, long defaultValue) {
		long longValue = defaultValue;
		if (object != null) {
			String strValue = castString(object);
			if (StringUtil.isNotEmpty(strValue)) {
				try {
					longValue = Long.parseLong(strValue);
				} catch (NumberFormatException e) {
					longValue = defaultValue;
				}
			}
		}
		return longValue;
	}
	
	/**
	 * 转换成int
	 * @param object
	 * @return
	 */
	public static int castInt(Object object) {
		return CastUtil.castInt(object,0);
	}

	
	/**
	 * 转换成int，有默认值
	 * @param object
	 * @param i
	 * @return
	 */
	private static int castInt(Object object, int defalutValue) {
		int intValue = defalutValue;
		if (object != null) {
			String strValue = castString(object);
			if (StringUtil.isNotEmpty(strValue)) {
				try {
					intValue = Integer.parseInt(strValue);
				} catch (NumberFormatException e) {
					intValue = defalutValue;
				}
			}
		}
		return intValue;
	}
	
	/**
	 * 转换成boolean
	 * @param object
	 * @return
	 */
	public static boolean castBoolean(Object object) {
		return CastUtil.castBoolean(object,false);
	}

	/**
	 * 转换成boolean，有默认值
	 * @param object
	 * @param b
	 * @return
	 */
	public static boolean castBoolean(Object object, boolean defaultValue) {
		boolean booleanValue = defaultValue;
		if (object != null) {
			booleanValue = Boolean.parseBoolean(castString(object));
		}
		return booleanValue;
	}
}
