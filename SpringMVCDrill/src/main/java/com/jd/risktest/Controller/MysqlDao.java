package com.jd.risktest.Controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class MysqlDao {

	private static Map<Integer, String> departments = null;

	static {

		departments = new HashMap<Integer, String>();
		departments.put(101, "zhangfeng");
		departments.put(102, "gaoyuan");
		departments.put(103, "haoyun");
		departments.put(104, "wangwu");

	}

	public Collection<String> getAll() {
		return departments.values();
	}

	public void add(Integer id, String value) {
		departments.put(id, value);
	}

	public String get(Integer id) {
		return departments.get(id);
	}

	public void Delete(Integer id) {
		departments.remove(id);
	}

	public void update(Integer id, String value) throws Exception {
		if (departments.containsKey(id)) {
			departments.put(id, value);
		} else {

			throw new Exception("²»´æÔÚid"+id);
			
		}

	}
}
