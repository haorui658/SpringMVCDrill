package com.jd.risktest.Controller;

import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    public HttpSession session;

    @RequestMapping("/Login")
    public String toIndex() {
        return "Login";
    }
    @RequestMapping("/logout")
    public String logout() {
    	session.removeAttribute("user");
    	return "redirect:Login";
    }
    @RequestMapping("/doLogin")
    public String doLogin(String userName, String password) {

        if (Objects.equals(userName, "admin") && Objects.equals(password, "123456")) {
            session.setAttribute("user", userName);
            return "redirect:/main";
        } else {
            System.out.println(userName + ":" + password);
            return "redirect:Login";
        }

    }
}
