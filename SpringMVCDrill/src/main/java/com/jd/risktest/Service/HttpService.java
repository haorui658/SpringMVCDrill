package com.jd.risktest.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.jd.risktest.Model.HttpRequestInfo;
import com.jd.risktest.Repository.HttpRepository;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by cdhaorui on 2017/4/6.
 */
@Service
public class HttpService {


    @Autowired
    private HttpRepository repository;

    public void save(HttpRequestInfo info) {
        if(info.getId()==null){
            info.setCreateTime(new Date());
        }
        repository.saveAndFlush(info);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public Iterable<HttpRequestInfo> findAll() {
        return repository.findAll();
    }

    public HttpRequestInfo findById(Long id) {
        return repository.findOne(id);
    }
}
