package com.jd.risktest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gooo on 2017/4/3.
 */
@Controller
@RequestMapping("/MQ")
public class MQController {

    @RequestMapping("/Index")
    public String index() {
        return "mq";
    }
}
