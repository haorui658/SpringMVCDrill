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
	public String delete(@PathVariable String id) {
		System.out.println("id====="+id);
		dao.Delete(Integer.parseInt(id));
		return "redirect:/list";
	}
	
	@RequestMapping("/input")
	public String input(Map<String,Object> map) {	
		map.put("addemp",new Employee() );
		return "input";
	}
	
	@RequestMapping("/add")
	public String add(Employee emp) {	
		dao.add(Integer.parseInt(emp.getId()), emp);	
		return "redirect:/list";
	}
}
