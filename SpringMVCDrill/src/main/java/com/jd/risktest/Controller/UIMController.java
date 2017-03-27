package com.jd.risktest.Controller;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import org.apache.http.annotation.Obsolete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jd.risktest.Service.*;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/UIM")
public class UIMController {
    @Autowired
    UIMService uimService;

    @RequestMapping("/Index")
    public String index() {
        return "uim";
    }

    @Obsolete
    @RequestMapping("/query")
    public String query(String resource, String pin, String codejudge, Map<String, Object> map) {
        String ResponseText = uimService.getUim(resource).getUimResponseText(pin);
        // String ResponseText =String.valueOf(System.currentTimeMillis());
        map.put("uimResponse", ResponseText);
        map.put("resource", resource);
        map.put("pin", pin);
        map.put("codejudge", codejudge);
        return "uim";
    }

    @ResponseBody
    @RequestMapping("/queryCode")
    public String queryCode(String resource, String pin, String codejudge, Map<String, Object> map) {
        String ResponseText = uimService.getUim(resource).getUimResponseText(pin);
        // String ResponseText =String.valueOf(System.currentTimeMillis());
        map.put("uimResponse", ResponseText);
        return JSON.toJSONString(map);
    }
}
