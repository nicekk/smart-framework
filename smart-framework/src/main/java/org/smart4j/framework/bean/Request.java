/**
 * 
 */
package org.smart4j.framework.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * ��װ������Ϣ
 *
 * Author: wangkai
 * Edit Time: 2016��4��4��  ����4:30:20 
 */
public class Request {

	/**
	 * ���󷽷�
	 */
	private String requestMethod;
	
	/**
	 * ����·��
	 */
	private String requestPath;

	/**
	 * @param requestMethod
	 * @param requestPath
	 */
	public Request(String requestMethod, String requestPath) {
		super();
		this.requestMethod = requestMethod;
		this.requestPath = requestPath;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getRequestPath() {
		return requestPath;
	}

	public void setRequestPath(String requestPath) {
		this.requestPath = requestPath;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this,obj);
	}
	
	
}
