/**
 * 
 */
package org.smart4j.framework.helper;

import java.util.Properties;

import org.smart4j.framework.ConfigConstant;
import org.smart4j.framework.util.PropsUtil;

/**
 * 属性文件助手类
 *
 * Author: wangkai Edit Time: 2016年4月3日 下午1:06:16
 */
public class ConfigHelper {

	private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);
	
	/**
	 * 获得jdbc驱动
	 * @return
	 */
	public static String getJdbcDriver() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
	}
	
	/**
	 * 获得jdbc url
	 * @return
	 */
	public static String getJdbcUrl() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
	}
	
	/**
	 * 获得jdbc userName
	 * @return
	 */
	public static String getJdbcUserName() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
	}
	
	/**
	 * 获得jdbc password
	 * @return
	 */
	public static String getJdbcPassword() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
	}
	
	/**
	 * 获取应用基础包名
	 * @return
	 */
	public static String getAppBasePackage() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
	}
	
	/**
	 * 获取jsp文件路径
	 * @return
	 */
	public static String getAppJspPath() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH, "/WEB-INF/view/");
	}
	
	/**
	 * 获取静态资源路径
	 * @return
	 */
	public static String getAppAssetPath() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH, "/asset/");
	}
}
