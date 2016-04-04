/**
 * 
 */
package org.smart4j.framework.bean;

import java.util.Map;

import org.smart4j.framework.util.CastUtil;

/**
 * �����������
 *
 * Author: wangkai
 * Edit Time: 2016��4��4��  ����4:50:08 
 */
public class Param {

	private Map<String, Object> paramMap;
	
	public Param(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
	}
	
	/**
	 * ���ݲ�������ȡlong���͵�ֵ
	 * @param name
	 * @return
	 */
	public long getLong(String name) {
		return CastUtil.castLong(paramMap.get(name));
	}
	
	/**
	 * ��ȡ�����ֶ�
	 * @return
	 */
	public Map<String, Object> getMap() {
		return paramMap;
	}
}
