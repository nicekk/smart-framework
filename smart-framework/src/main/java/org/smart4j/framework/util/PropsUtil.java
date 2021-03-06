/**
 * 
 */
package org.smart4j.framework.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 属性文件读取工具类
 * 
 * @author: wangkai
 * 
 *          Date: 2016年4月3日 上午12:39:50
 */
public class PropsUtil {

	public static final Logger log = LoggerFactory.getLogger(PropsUtil.class);

	/**
	 * 加载配置文件
	 * 
	 * @param fileName
	 * @return
	 */
	public static Properties loadProps(String fileName) {
		Properties props = null;
		InputStream is = null;
		try {
			is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
			if (is == null) {
				throw new FileNotFoundException(fileName + "file is not found");
			}
			props = new Properties();
			props.load(is);
		} catch (IOException e) {
			log.error("load property fils failure", e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					log.error("close input stream failure", e);
				}
			}
		}
		return props;
	}

	/**
	 * 获取字符串类型的属性
	 * @param props
	 * @param key
	 * @return
	 */
	public static String getString(Properties props, String key) {
		return getString(props, key, "");
	}

	/**
	 * 获取字符串类型的属性，有默认值
	 * @param props
	 * @param key
	 * @param string
	 * @return
	 */
	public static String getString(Properties props, String key, String defaultValue) {
		String value = defaultValue;
		if (props.containsKey(key)) {
			value = props.getProperty(key);
		}
		return value;
	}
	
	/**
	 * 获取int类型的属性
	 * @param props
	 * @param key
	 * @return
	 */
	public static int getInt(Properties props,String key) {
		return getInt(props, key,0);
	}

	/**
	 * 获取int型的属性，有默认值
	 * @param props
	 * @param key
	 * @param i
	 * @return
	 */
	public static int getInt(Properties props, String key, int defaultValue) {
		int value = defaultValue;
		if (props.containsKey(key)) {
			value = CastUtil.castInt(props.getProperty(key));
		}
		return value;
	}
	
	/**
	 * 获取boolean类型的属性
	 * @param props
	 * @param key
	 * @return
	 */
	public static boolean getBoolean(Properties props,String key) {
		return getBoolean(props,key,false);
	}

	/** 获取boolean类型的属性，有默认值
	 * @param props
	 * @param key
	 * @param b
	 * @return
	 */
	public static boolean getBoolean(Properties props, String key, boolean defaultValue) {
		boolean value = defaultValue;
		if (props.containsKey(key)) {
			value = CastUtil.castBoolean(props.getProperty(key));
		}
		return value;
	}

}
