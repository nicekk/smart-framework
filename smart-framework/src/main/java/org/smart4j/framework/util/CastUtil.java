/**
 * 
 */
package org.smart4j.framework.util;

/**
 * ת�Ͳ���������
 * 
 * @author: wangkai
 * 
 * Date: 2016��4��3��  ����12:53:11 
 */
public class CastUtil {

	/**
	 * ת����string��
	 * 
	 * @param object
	 * @return
	 */
	public static String castString(Object object) {
		return CastUtil.castString(object,"");
	}

	/**
	 * ת����string�ͣ���Ĭ��ֵ
	 * 
	 * @param object
	 * @param string
	 * @return
	 */
	public static String castString(Object object, String defaultValue) {
		return object != null ? String.valueOf(object) : defaultValue;
	}
	
	/**
	 * ת��Ϊdouble��
	 * @param object
	 * @return
	 */
	public static double castDouble(Object object) {
		return CastUtil.castDouble(object,0);
	}

	/**
	 * ת��Ϊdouble�ͣ���Ĭ��ֵ
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
	 * ת��Ϊlong��
	 * @param object
	 * @return
	 */
	public static long castLong(Object object) {
		return CastUtil.castLong(object,0);
	}

	/**
	 * ת��Ϊlong�ͣ���Ĭ��ֵ
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
	 * ת����int
	 * @param object
	 * @return
	 */
	public static int castInt(Object object) {
		return CastUtil.castInt(object,0);
	}

	
	/**
	 * ת����int����Ĭ��ֵ
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
	 * ת����boolean
	 * @param object
	 * @return
	 */
	public static boolean castBoolean(Object object) {
		return CastUtil.castBoolean(object,false);
	}

	/**
	 * ת����boolean����Ĭ��ֵ
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
