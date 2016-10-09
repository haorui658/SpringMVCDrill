package com.jd.risktest.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class Employeehandler {

	@Autowired
	private MysqlDao dao;
	@RequestMapping("/emp")
	public String listAll(Map<String,Object> map) {
		map.put("emp", dao.getAll());
		return "list";
	}
}
