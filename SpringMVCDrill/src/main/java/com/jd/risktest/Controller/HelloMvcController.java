package com.jd.risktest.Controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloMvcController {
	
	private static Logger log=LoggerFactory.getLogger(HelloMvcController.class);
	@RequestMapping("/Request")
	public String helloMvc(@RequestParam("id") Integer id,Model model) {
		log.debug("In viewCourse, courseId = {}", id);
		model.addAttribute("qqq", id);
		return "home";
	}
	
	@RequestMapping(value="/Path/{id}",method=RequestMethod.GET)
	public String helloMvc2(@PathVariable("id") Integer id,Model model) {
		model.addAttribute("qqq", id);
		return "home";
	}

	//传统方式
	@RequestMapping("/old")
	public String helloMvc3(HttpServletRequest request) {
		Integer id=Integer.parseInt(request.getParameter("id"));
		request.setAttribute("qqq", id);	
		
		return "home";
	}
}
