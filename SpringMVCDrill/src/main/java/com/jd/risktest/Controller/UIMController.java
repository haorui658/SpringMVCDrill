package com.jd.risktest.Controller;

import java.util.Map;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import com.jd.risktest.Service.*;
@Controller
@RequestMapping("/UIM")
public class UIMController {
    @RequestMapping("/Index")
    public String index(Map<String, Object> map) {
        String reqId = "haorui7";
        UimTest ut=new UimTest();
        String ReponseText = ut.getUimReponseText(reqId);
        map.put("uimResponse", ReponseText);
        return "uim";
    }

    @RequestMapping("/query")
    public String query(String resource, String pin,Map<String, Object> map) {

        map.put("uimResponse", resource+pin);
        return "uim";
    }
}
