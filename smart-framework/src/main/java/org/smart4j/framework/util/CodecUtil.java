/**
 * 
 */
package org.smart4j.framework.util;

import java.net.URLDecoder;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ���빤����
 *
 * Author: wangkai
 * Edit Time: 2016��4��4��  ����5:12:46 
 */
public class CodecUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtil.class);
	
	/**
	 * ��URL����
	 * @param source
	 * @return
	 */
	public static String encodeURL (String source) {
		String target;
		try {
			target = URLEncoder.encode(source,"UTF_8");
		} catch (Exception e) {
			LOGGER.error("encode URL failure",e);
			throw new RuntimeException(e);
		}
		return target;
	}

	/**
	 * ��URL����
	 * @param source
	 * @return
	 */
	public static String decodeURL(String source) {
		String target;
		try {
			target = URLDecoder.decode(source,"UTF_8");
		} catch (Exception e) {
			LOGGER.error("encode URL failure",e);
			throw new RuntimeException(e);
		}
		return target;
	}
}
