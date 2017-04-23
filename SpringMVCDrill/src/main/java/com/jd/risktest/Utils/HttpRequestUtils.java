package com.jd.risktest.Utils;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gooo on 2017/4/23.
 */
public class HttpRequestUtils {

    public static String sendGet(String url, Map<String, String> paramMap) {

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

    public static String sendPost(String url, Map<String, String> paramMap) {
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

    private static CloseableHttpResponse getPostHttpResponse(String url, Map<String, String> paramMap) throws IOException {
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

    private static String getLoginCookie() throws IOException {
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
