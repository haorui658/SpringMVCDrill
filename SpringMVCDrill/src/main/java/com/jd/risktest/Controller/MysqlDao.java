package com.jd.risktest.Controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class MysqlDao {

	private static Map<Integer, Employee> employeeMap = null;
	private Integer initId = 5;
	static {

		employeeMap = new HashMap<Integer, Employee>();
		employeeMap.put(1, new Employee("1", "zhangsan", "zhang", "1"));
		employeeMap.put(2, new Employee("2", "gaoyuan", "gao", "1"));
		employeeMap.put(3, new Employee("3", "haoyun", "hao", "1"));
		employeeMap.put(4, new Employee("4", "wangwu", "wang", "0"));

	}

	public Collection<Employee> getAll() {
		return employeeMap.values();
	}

	public void save(Employee value) {
		if (value.getId() == null) {
			value.setId((initId++).toString());
		}
		employeeMap.put(Integer.parseInt(value.getId()), value);
	}

	public Employee get(Integer id) {
		return employeeMap.get(id);
	}

	public void Delete(Integer id) {
		employeeMap.remove(id);
	}

	public void update(Integer id, Employee value) throws Exception {
		if (employeeMap.containsKey(id)) {
			employeeMap.put(id, value);
		} else {

			throw new Exception("²»´æÔÚid" + id);

		}

	}
}
