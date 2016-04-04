/**
 * 
 */
package org.smart4j.framework.bean;

import java.util.Map;

import org.smart4j.framework.util.CastUtil;

/**
 * 请求参数对象
 *
 * Author: wangkai
 * Edit Time: 2016年4月4日  下午4:50:08 
 */
public class Param {

	private Map<String, Object> paramMap;
	
	public Param(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
	}
	
	/**
	 * 根据参数名获取long类型的值
	 * @param name
	 * @return
	 */
	public long getLong(String name) {
		return CastUtil.castLong(paramMap.get(name));
	}
	
	/**
	 * 获取所有字段
	 * @return
	 */
	public Map<String, Object> getMap() {
		return paramMap;
	}
}
