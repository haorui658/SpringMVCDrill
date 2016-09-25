package com.jd.risktest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class IndexController {

	@RequestMapping("/")
	public String toIndex() {
		return "index";
	}
	
	
}
