package com.jd.risktest.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jd.risktest.Model.HttpRequestInfo;
import com.jd.risktest.Model.UserCase;
import com.jd.risktest.Service.UserCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by cdhaorui on 2017/4/20.
 */
@Controller
@RequestMapping("/http/userCase")
public class UserCaseController {

    @Autowired
    private UserCaseService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String index(@PathVariable("id") Long id, Map<String, Object> map) {
        map.put("id", id);
        return "http/userCaseIndex";
    }

    @RequestMapping("/add/{id}")
    public String add(@PathVariable("id") Long id, Map<String, Object> map) {
        map.put("httpId", id);
        UserCase uc=new UserCase();
        uc.setInfoId(id);
        map.put("editInfo", uc);
        return "http/addCase";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(UserCase info, Map<String, Object> map) {
        System.out.println(JSON.toJSON(info));

        try {
            service.save(info);
            map.put("id", info.getInfoId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "http/userCaseIndex";
    }

    @ResponseBody
    @RequestMapping(value = "/query/{id}", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public String queryMq(@PathVariable("id") Long id) {

        return JSON.toJSONString(service.findByInfoId(id), SerializerFeature.WriteNullStringAsEmpty);
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Map<String, Object> map) {
        UserCase info = service.findById(id);
        map.put("editInfo", info);
        return "http/addCase";
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
    @RequestMapping(value = "/request/{id}", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public String SendRequest(@PathVariable("id") Long id) {
        try {
            return  service.sendRequestByCaseId(id);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
