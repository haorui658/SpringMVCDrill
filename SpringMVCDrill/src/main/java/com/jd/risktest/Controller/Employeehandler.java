package com.jd.risktest.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Employeehandler {

	@Autowired
	private MysqlDao dao;
	@RequestMapping("/list")
	public String listAll(Map<String,Object> map) {
		map.put("emp", dao.getAll());
		return "list";
	}
	
	@RequestMapping("/delete/{id}")
	public String listAll(@PathVariable String id) {
		System.out.println("id====="+id);
		dao.Delete(Integer.parseInt(id));
		return "redirect:/list";
	}
}
