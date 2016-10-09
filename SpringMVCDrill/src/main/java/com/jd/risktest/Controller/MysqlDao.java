package com.jd.risktest.Controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class MysqlDao {

	private static Map<Integer, Employee> departments = null;

	static {

		departments = new HashMap<Integer, Employee>();
		departments.put(101, new Employee("1","zhangsan","1"));
		departments.put(102, new Employee("1","gaoyuan","1"));
		departments.put(103, new Employee("1", "haoyun","1"));
		departments.put(104, new Employee("1", "wangwu","0"));

	}

	public Collection<Employee> getAll() {
		return departments.values();
	}

	public void add(Integer id, Employee value) {
		departments.put(id, value);
	}

	public Employee get(Integer id) {
		return departments.get(id);
	}

	public void Delete(Integer id) {
		departments.remove(id);
	}

	public void update(Integer id, Employee value) throws Exception {
		if (departments.containsKey(id)) {
			departments.put(id, value);
		} else {

			throw new Exception("²»´æÔÚid"+id);
			
		}

	}
}
