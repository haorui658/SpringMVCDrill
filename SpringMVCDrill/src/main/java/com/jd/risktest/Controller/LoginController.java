package com.jd.risktest.Controller;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/Login")
	public String toIndex(HttpSession httpSession) {
		return "Login";
	}
	@RequestMapping("/doLogin")
	public String doLogin(String userName, String password,HttpSession httpSession){
		
		if(Objects.equals(userName, "admin")&&Objects.equals(password, "123456")){
			httpSession.setAttribute("user", userName);
			return "redirect:/";	
		}else{
			System.out.println(userName+":"+password);
			return "redirect:Login";	
		}
		
	}
}
