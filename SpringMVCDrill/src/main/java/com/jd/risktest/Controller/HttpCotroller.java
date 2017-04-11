package com.jd.risktest.Controller;

import com.alibaba.fastjson.JSON;
import com.jd.risktest.Model.HttpRequestInfo;
import com.jd.risktest.Model.MQInfo;
import com.jd.risktest.Service.HttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by cdhaorui on 2017/4/11.
 */
@Controller
@RequestMapping("/http")
public class HttpCotroller {


    @Autowired
    private HttpService service;

    @RequestMapping("/index")
    public String index() {
        return "http/index";
    }

    @RequestMapping("/add")
    public String add() {
        return "http/add";
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(HttpRequestInfo info) {
      System.out.println(JSON.toJSON(info));
       // service.save(info);
        return "http/index";
    }

    @ResponseBody
    @RequestMapping(value = "/query", produces = {"application/json;charset=UTF-8"})
    public String queryMq() {
        return JSON.toJSONString(service.findAll());
    }
}
