/**
 * 
 */
package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON工具类
 *
 * Author: wangkai
 * Edit Time: 2016年4月4日  下午5:19:13 
 */
public class JSONUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(JSONUtil.class);
	
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	/**
	 * 将POJO转为JSON
	 * @param obj
	 * @return
	 */
	public static <T> String toJson(T obj) {
		String json;
		try {
			json = OBJECT_MAPPER.writeValueAsString(obj);
		} catch (Exception e) {
			LOGGER.error("convert POJO to JSON faiure",e);
			throw new RuntimeException(e);
		}
		return json;
	}
	
	/**
	 * 将JSON转为POJO
	 * @param obj
	 * @return
	 */
	public static <T> T fromJson(String json,Class<T> type) {
		T pojo;
		try {
			pojo = OBJECT_MAPPER.readValue(json, type);
		} catch (Exception e) {
			LOGGER.error("convert POJO to JSON faiure",e);
			throw new RuntimeException(e);
		}
		return pojo;
	}
}
