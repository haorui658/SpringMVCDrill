package com.jd.risktest.Controller;

import java.util.Map;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/UIM")
public class UIMController {
    @RequestMapping("/Index")
    public String index() {
        return "uim";
    }
    @RequestMapping("/query")
    public String query(Map<String,Object> map) {
        map.put("uimResponse", "uimResponseText");
        return "uim";
    }
}
