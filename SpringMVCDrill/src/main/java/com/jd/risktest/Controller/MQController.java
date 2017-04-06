package com.jd.risktest.Controller;

import com.jd.risktest.Model.MQInfo;
import com.jd.risktest.Service.MqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by gooo on 2017/4/3.
 */
@Controller
@RequestMapping("/MQ")
public class MQController {

    @Autowired
    private MqService service;

    @RequestMapping("/Index")
    public String index() {
        return "mq";
    }

    @RequestMapping("/add")
    public String addmq() {

        MQInfo info= new MQInfo();
        info.setName("test");
        info.setTopic("testTopic");
        info.setCreateDate(new Date());
        service.save(info);
        return "mq";
    }
}
