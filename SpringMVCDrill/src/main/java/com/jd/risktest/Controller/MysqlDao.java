package com.jd.risktest.Controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class MysqlDao {

	private static Map<Integer, Employee> employeeMap = null;

	static {

		employeeMap = new HashMap<Integer, Employee>();
		employeeMap.put(1, new Employee("1","zhangsan","1"));
		employeeMap.put(2, new Employee("2","gaoyuan","1"));
		employeeMap.put(3, new Employee("3", "haoyun","1"));
		employeeMap.put(4, new Employee("4", "wangwu","0"));

	}

	public Collection<Employee> getAll() {
		return employeeMap.values();
	}

	public void add(Integer id, Employee value) {
		employeeMap.put(id, value);
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

			throw new Exception("²»´æÔÚid"+id);
			
		}

	}
}
