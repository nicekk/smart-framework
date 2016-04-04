/**
 * 
 */
package chapter3.service;

import java.util.List;
import java.util.Map;

import chapter3.helper.DataBaseHelper;
import chapter3.model.Customer;

/**
 * @author: wangkai
 * 
 *          Date: 2016��4��3�� ����12:10:30
 */
public class CustomerService {

	/**
	 * ��ȡ�ͻ��б�
	 */
	public List<Customer> getCustomerList() {
		String sql = "SELECT * FROM T_CUSTOMER";
		return DataBaseHelper.queryEntityList(Customer.class, sql);
	}

	/**
	 * ��ȡ�ͻ�
	 * 
	 * @param id
	 * @return
	 */
	public Customer getById(long id) {
		String sql = "SELECT * FROM T_CUSTOMER WHERE ID = ?";
		return DataBaseHelper.queryEntity(Customer.class, sql, id);
	}

	/**
	 * �����ͻ�
	 * 
	 * @param fieldMap
	 * @return
	 */
	public boolean createCustomer(Map<String, Object> fieldMap) {
		return DataBaseHelper.insertEntity(Customer.class, fieldMap);
	}

	/**
	 * ���¿ͻ�
	 * 
	 * @param id
	 * @param fieldMap
	 * @return
	 */
	public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
		return DataBaseHelper.updateEntity(Customer.class, id, fieldMap);
	}

	/**
	 * ɾ���ͻ�
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteCustomer(long id) {
		return DataBaseHelper.deleteEntity(Customer.class, id);
	}

}
