package com.jd.risktest.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.jd.risktest.Model.HttpRequestInfo;
import com.jd.risktest.Model.UserCase;
import com.jd.risktest.Repository.UserCaseRepository;
import com.jd.risktest.Utils.HttpRequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by cdhaorui on 2017/4/6.
 */
@Service
public class UserCaseService {


    @Autowired
    private HttpService httpService;

    @Autowired
    private UserCaseRepository repository;

    public void save(UserCase info) {
        if (info.getId() == null) {
            info.setCreateTime(new Date());
        }
        repository.saveAndFlush(info);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public Iterable<UserCase> findAll() {
        return repository.findAll();
    }

    public UserCase findById(Long id) {
        return repository.findOne(id);
    }

    public List<UserCase> findByInfoId(Long id) {
        return repository.findByInfoId(id);
    }

    public String sendRequestByCaseId(Long id) {
        UserCase requestInfo = findById(id);
        HttpRequestInfo info = httpService.findById(requestInfo.getInfoId());
        String latestResponse = "";
        Map<String, String> paramMap = JSON.parseObject(requestInfo.getRequestParameter(), new TypeReference<Map<String, String>>() {
        });
        if (info.getMethod().equals("POST")) {
            latestResponse = HttpRequestUtils.sendPost(info.getUrl(), paramMap).substring(0, 20410);
        }
        if (info.getMethod().equals("GET")) {
            latestResponse = HttpRequestUtils.sendGet(info.getUrl(), paramMap).substring(0, 20410);
        }
        requestInfo.setLatestResponse(latestResponse);
        //设置结果
        if (latestResponse == requestInfo.getExpectResponse()) {
            requestInfo.setLatestResult("PASS");
        } else {
            requestInfo.setLatestResult("Fail");
        }
        save(requestInfo);

        return requestInfo.getLatestResponse();
    }


}
