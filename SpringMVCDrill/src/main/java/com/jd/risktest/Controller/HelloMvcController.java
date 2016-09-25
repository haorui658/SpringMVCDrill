package com.jd.risktest.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloMvcController {

	private static Logger log = LoggerFactory.getLogger(HelloMvcController.class);

	@RequestMapping("/Request")
	public String helloMvc(@RequestParam("id") Integer id, Model model) {
		log.debug("In viewCourse, courseId = {}", id);
		model.addAttribute("qqq", id);
		return "home";
	}

	@RequestMapping(value = "/Path/{id}", method = RequestMethod.GET)
	public String helloMvc2(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("qqq", id);
		return "home";
	}

	@RequestMapping(value = "/TestModelAndView/{id}", method = RequestMethod.GET)
	public ModelAndView TestModelAndView(@PathVariable("id") Integer id, ModelAndView mv) {
		mv.addObject("qqq", id);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value = "/TestMap", method = RequestMethod.GET)
	public String TestMap(Map<String, Object> map) {
		map.put("testMap", Arrays.asList("Tom","Jerry","Mike"));
		return "testmap";
	}
	
	
	// 传统方式
	@RequestMapping("/Traditional")
	public String helloMvc3(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("qqq", id);
		return "home";
	}

	// http://localhost:8080/hello/admin?add访问
	@RequestMapping(value = "/admin", method = RequestMethod.GET, params = "add")
	public String Admin() {
		return "admin/edit";
	}

	// 提交持久化,如果与name相同可以不用加入@ModelAttribute("descrName")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String Save(@ModelAttribute("descrName") String descVar, Model model) {
		System.out.println(descVar);
		model.addAttribute("qqq", descVar);
		return "home";
	}

}