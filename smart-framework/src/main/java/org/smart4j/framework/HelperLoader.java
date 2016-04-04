/**
 * 
 */
package org.smart4j.framework;

import org.smart4j.framework.helper.BeanHelper;
import org.smart4j.framework.helper.ClassHelper;
import org.smart4j.framework.helper.ControllerHelper;
import org.smart4j.framework.helper.IocHelper;
import org.smart4j.framework.util.ClassUtil;

/**
 * ������Ӧ��helper��
 *
 * Author: wangkai
 * Edit Time: 2016��4��4��  ����4:45:20 
 */
public class HelperLoader {

	public static void init() {
		Class<?>[] classList = {ClassHelper.class,BeanHelper.class,IocHelper.class,ControllerHelper.class};
		for (Class<?> cls : classList) {
			ClassUtil.loadClass(cls.getName());
		}
	}
}
