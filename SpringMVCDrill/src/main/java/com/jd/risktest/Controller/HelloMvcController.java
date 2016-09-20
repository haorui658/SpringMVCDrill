package com.jd.risktest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloMvcController {
	
	@RequestMapping("/mvc")
	public String helloMvc() {
		
		// ”Õº‰÷»æ£¨/WEB-INF/jsps/home.jsp
		return "home";
	}

}
