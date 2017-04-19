package com.jd.risktest.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jd.risktest.Model.HttpRequestInfo;
import com.jd.risktest.Model.MQInfo;
import com.jd.risktest.Service.HttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

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

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Map<String, Object> map) {
        HttpRequestInfo info = service.findById(id);
        map.put("editInfo", info);
        return "http/add";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(HttpRequestInfo info) {
        System.out.println(JSON.toJSON(info));

        try {
            service.save(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "http/index";
    }

    @ResponseBody
    @RequestMapping(value = "/del/{id}", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public String delete(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return "删除成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public String queryMq() {

        return JSON.toJSONString(service.findAll(), SerializerFeature.WriteNullStringAsEmpty);
    }
}
