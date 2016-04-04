/**
 * 
 */
package org.smart4j.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 *
 * Author: wangkai
 * Edit Time: 2016年4月3日  下午2:19:45 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {
	
	/**
	 * 请求类型与路径
	 */
	String value();
}
