package com.jd.risktest.Controller;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    public HttpSession session;

    @RequestMapping("/index")
    public String Index() {
        return "index";
    }

    @RequestMapping("/uim")
    public String uim() {
        return "uim";
    }

    @RequestMapping("/Login")
    public String toIndex() {
        return "Login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(String userName, String password) {

        if (Objects.equals(userName, "admin") && Objects.equals(password, "123456")) {
            session.setAttribute("user", userName);
            return "redirect:index";
        } else {
            System.out.println(userName + ":" + password);
            return "redirect:Login";
        }

    }
}
