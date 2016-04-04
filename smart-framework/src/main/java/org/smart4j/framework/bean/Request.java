/**
 * 
 */
package org.smart4j.framework.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * 封装请求信息
 *
 * Author: wangkai
 * Edit Time: 2016年4月4日  下午4:30:20 
 */
public class Request {

	/**
	 * 请求方法
	 */
	private String requestMethod;
	
	/**
	 * 请求路径
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
