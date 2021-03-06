/**
 * 
 */
package org.smart4j.framework.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 流操作工具类
 *
 * Author: wangkai
 * Edit Time: 2016年4月4日  下午5:13:02 
 */
public class StreamUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(StreamUtil.class);
	
	/**
	 * 从输入流中获取字符串
	 * @param inputStream
	 * @return
	 */
	public static String getString(InputStream inputStream) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String line;
			while ((line = reader.readLine())!= null) {
				sb.append(line);
			}
		} catch (Exception e) {
			LOGGER.error("get String failure",e);
			throw new RuntimeException(e);
		}
		return sb.toString();
	}
}
