package com.jd.risktest.Controller;

import java.util.Map;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIMController {
	@RequestMapping("/uim")
    public String uim(Map<String,Object> map) {
    	map.put("user", "dsda");
        return "uim";
    }
}
