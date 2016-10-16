package com.jd.risktest.Controller;

import java.lang.reflect.Method;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Employeehandler {

	@Autowired
	private MysqlDao dao;

	/*
	 * 所有方法之前执行，key值必须是类名的小写开头字符串
	 * 
	 */
	@ModelAttribute
	public void getEmployee(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
		if (id != null) {
			map.put("employee", dao.get(id));
			System.out.println("获取id");
		}
		System.out.println("modelAttr调用");
	}
	@RequestMapping(value = "list/{id}", method = RequestMethod.PUT)
	public String EditSave(Employee emp) {
		dao.save(emp);
		return "redirect:/list";
	}
	
	
	
	@RequestMapping("/list")
	public String listAll(Map<String, Object> map) {
		map.put("emp", dao.getAll());
		return "list";
	}

	@RequestMapping(value = "list/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Integer id) {
		System.out.println("id=====" + id);
		dao.Delete(id);
		return "redirect:/list";
	}

	@RequestMapping("/input")
	public String input(Map<String, Object> map) {
		map.put("addemp", new Employee());
		return "input";
	}

	@RequestMapping("/add")
	public String add(Employee emp) {
		dao.save(emp);
		return "redirect:/list";
	}

	@RequestMapping(value = "/input/{id}", method = RequestMethod.GET)
	public String input(@PathVariable Integer id, Map<String, Object> map) {
		map.put("addemp", dao.get(id));
		return "input";
	}

}
