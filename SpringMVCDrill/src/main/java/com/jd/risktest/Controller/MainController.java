package com.jd.risktest.Controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    public HttpSession session;
    
	@RequestMapping("/")
	public String toIndex() {
		return "main";
	}
	
	@RequestMapping("/main")
    public String main(Map<String,Object> map) {
    	String user=(String)session.getAttribute("user");
    	map.put("user", user);
        return "main";
    }
}
