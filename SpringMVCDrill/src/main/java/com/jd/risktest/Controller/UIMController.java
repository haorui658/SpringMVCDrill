package com.jd.risktest.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import com.jd.risktest.Service.*;

@Controller
@RequestMapping("/UIM")
public class UIMController {
    @Autowired
    UIMService uimService;

    @RequestMapping("/Index")
    public String index(Map<String, Object> map) {
        String reqId = "haorui7";
        String ResponseText = uimService.getUim("risk2").getUimResponseText(reqId);
        map.put("uimResponse", ResponseText);
        return "uim";
    }

    @RequestMapping("/query")
    public String query(String resource, String pin, Map<String, Object> map) {

        map.put("uimResponse", resource + pin);
        return "uim";
    }
}
