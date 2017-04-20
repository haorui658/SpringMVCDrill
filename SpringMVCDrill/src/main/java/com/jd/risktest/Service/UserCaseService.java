package com.jd.risktest.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.jd.risktest.Model.HttpRequestInfo;
import com.jd.risktest.Model.UserCase;
import com.jd.risktest.Repository.UserCaseRepository;
import org.apache.http.NameValuePair;
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
import java.util.*;

/**
 * Created by cdhaorui on 2017/4/6.
 */
@Service
public class UserCaseService {


    @Autowired
    private UserCaseRepository repository;

    public void save(UserCase info) {
        if(info.getId()==null){
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

    public String sendRequestById(Long id) {
        UserCase requestInfo = findById(id);
        String reponse = "";
        Map<String, String> paramMap = JSON.parseObject(requestInfo.getRequestParameter(), new TypeReference<Map<String, String>>() {
        });
//        if (requestInfo.getMethod() == "POST") {
//            requestInfo.setLatestResult(sendPost(requestInfo.getUrl(), paramMap));
//        }
//        if (requestInfo.getMethod() == "GET") {
//            requestInfo.setLatestResult(sendGet(requestInfo.getUrl(), paramMap));
//        }
//        //设置结果
//        if (reponse == requestInfo.getExpectResponse()) {
//            requestInfo.setLatestResult("PASS");
//        } else {
//            requestInfo.setLatestResult("Fail");
//        }
//        save(requestInfo);
//
//        return requestInfo.getLatestResponse();
        return "";
    }


    private static String sendGet(String url, Map<String, String> paramMap) {

        String reponseText = "";

        try {
            if (paramMap != null && paramMap.size() != 0) {
                List<NameValuePair> formParams = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> e : paramMap.entrySet()) {
                    formParams.add(new BasicNameValuePair(e.getKey(), e.getValue()));
                }
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, "utf-8");
                url += "?" + EntityUtils.toString(entity, "utf-8");
            }

            HttpGet httpGet = new HttpGet(url);
            CloseableHttpClient httpclient = HttpClients.createDefault();
            CloseableHttpResponse response = httpclient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpGet.abort();
                //throw new RuntimeException("HttpClient,error status code :" + statusCode);
                return "HttpClient,error status code :" + statusCode;
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));// 把字节流包装成字符
            String line = null;
            reponseText = "";
            while ((line = in.readLine()) != null) {
                reponseText += line;
            }
        } catch (Exception e) {
            return e.getMessage();
        }

        return reponseText;
    }

    private String sendPost(String url, Map<String, String> paramMap) {
        String reponseText = "";

        try {
            CloseableHttpResponse httpResponse = getPostHttpResponse(url, paramMap);
            BufferedReader in = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8"));// 把字节流包装成字符
            String line = null;

            while ((line = in.readLine()) != null) {
                reponseText += line;
            }
        } catch (Exception e) {
            return e.getMessage();
        }

        return reponseText;
    }

    private CloseableHttpResponse getPostHttpResponse(String url, Map<String, String> paramMap) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);
        if (paramMap != null && paramMap.size() != 0) {
            List<NameValuePair> formParams = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> e : paramMap.entrySet()) {
                formParams.add(new BasicNameValuePair(e.getKey(), e.getValue()));
            }
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, "utf-8");
            httppost.setEntity(entity);
        }
        httppost.setHeader("Content-type", "application/x-www-form-urlencoded");
        httppost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        // 添加cookie到头文件
        httppost.addHeader("Cookie", getLoginCookie());
        return httpClient.execute(httppost);
    }

    private String getLoginCookie() throws IOException {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("password", "xinxibu456");
        paramMap.put("username", "haorui7");
        String url = "http://test.ssa.jd.com/sso/login";
        CloseableHttpResponse httpResponse = getPostHttpResponse(url, paramMap);
        String cookie = httpResponse.getLastHeader("Set-Cookie").getValue();
        System.out.println(cookie);
        return cookie;
    }
}
