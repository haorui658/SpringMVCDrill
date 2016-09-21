package com.jd.risktest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloMvcController {
	
	@RequestMapping("/mvc")
	public String helloMvc(Model model) {
		model.addAttribute("qqq", "555");
		return "home";
	}

}
