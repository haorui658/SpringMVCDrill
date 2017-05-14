package com.jd.risktest.Service;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UIMService {

    public String getAuthAddress() {
        return authAddress;
    }

    public void setAuthAddress(String authAddress) {
        this.authAddress = authAddress;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    private String authAddress;
    private String appKey;
    private String token;

    /**
     * 鉴权服务方法名称
     */
    private static final String USERAUTHTICKET = "uim.auth.res.getUserAuthTicket";// 获取用户凭证
//	private static final String AUTHAPPROOTMENUS = "uim.auth.res.getAuthAppChildMenus";// 获取一级菜单
//	private static final String AUTHDATA = "uim.auth.res.getAuthData";// 获取数据权限


    public String getUimResponseText(String reqId) {

        String method = USERAUTHTICKET;
        try {
            UrlEncodedFormEntity entity = getUrlEntity(reqId, method);
            String reponse=sendGet(authAddress,entity);
            return reponse;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }
    private UrlEncodedFormEntity getUrlEntity(String reqId, String method) throws UnsupportedEncodingException {
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("req_path", authAddress));
        formparams.add(new BasicNameValuePair("format", "json"));
        formparams.add(new BasicNameValuePair("req_method", "POST"));
        formparams.add(new BasicNameValuePair("app_key", appKey));
        formparams.add(new BasicNameValuePair("method", method));
        formparams.add(new BasicNameValuePair("token", token));
        formparams.add(new BasicNameValuePair("v", "2.0"));
        formparams.add(new BasicNameValuePair("fields", ""));

        String random = new Random().nextInt(1000000000) + "";
        formparams.add(new BasicNameValuePair("random", random));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String timeStamp = format.format(new Date());
        formparams.add(new BasicNameValuePair("timestamp", timeStamp));
        String sign = generate(appKey, token, timeStamp, random);
        formparams.add(new BasicNameValuePair("sign", sign));
        formparams.add(new BasicNameValuePair("reqId", reqId));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "utf-8");
        return entity;
    }




    public String getUimResponseText(String method, String reqId) throws IOException {
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("req_path", authAddress));
        formparams.add(new BasicNameValuePair("format", "json"));
        formparams.add(new BasicNameValuePair("req_method", "POST"));
        formparams.add(new BasicNameValuePair("app_key", appKey));
        formparams.add(new BasicNameValuePair("method", method));
        formparams.add(new BasicNameValuePair("token", token));
        formparams.add(new BasicNameValuePair("v", "2.0"));
        formparams.add(new BasicNameValuePair("fields", ""));

        String random = new Random().nextInt(1000000000) + "";
        formparams.add(new BasicNameValuePair("random", random));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ;
        String timeStamp = format.format(new Date());
        formparams.add(new BasicNameValuePair("timestamp", timeStamp));
        String sign = generate(appKey, token, timeStamp, random);
        formparams.add(new BasicNameValuePair("sign", sign));
        formparams.add(new BasicNameValuePair("reqId", reqId));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "utf-8");
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(authAddress);
        httppost.setEntity(entity);
        httppost.setHeader("Content-type", "application/x-www-form-urlencoded");
        httppost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        // 添加cookie到头文件
        httppost.addHeader("Cookie", getcookie());
        CloseableHttpResponse httpResponse = httpclient.execute(httppost);

        BufferedReader in = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8"));// 把字节流包装成字符
        String line = null;
        String ReponseText = "";
        while ((line = in.readLine()) != null) {
            ReponseText += line;
        }
        return ReponseText;
    }

    public String getcookie() throws IOException {
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("password", "xinxibu456"));
        formparams.add(new BasicNameValuePair("username", "haorui7"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "utf-8");
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://test.ssa.jd.com/sso/login");
        httppost.setEntity(entity);
        CloseableHttpResponse httpResponse = httpclient.execute(httppost);
        String cookie = httpResponse.getLastHeader("Set-Cookie").getValue();
        System.out.println(cookie);
        return cookie;
    }

    public String generate(String appKey, String token, String timestamp, String random) {
        String[] arrTmp = {appKey, token, timestamp, random};
        Arrays.sort(arrTmp);

        StringBuilder sb = new StringBuilder();
        for (String str : arrTmp) {
            sb.append(str);
        }
        return encryptByMD5(sb.toString());
    }

    public static String encryptByMD5(String data) {
        if ((null == data) || ("".equals(data))) {
            return "";
        }
        char[] chars = data.toCharArray();
        byte[] bytes = new byte[chars.length];

        for (int i = 0; i < chars.length; ++i) {
            bytes[i] = (byte) chars[i];
        }
        StringBuilder result = new StringBuilder();
        byte[] md5Bytes;
        try {
            md5Bytes = MessageDigest.getInstance("MD5").digest(bytes);

            for (int i = 0; i < md5Bytes.length; ++i) {
                int val = md5Bytes[i] & 0xFF;
                if (16 > val) {
                    result.append("0");
                }
                result.append(Integer.toHexString(val));
            }
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result.toString();
    }

    public static String sendGet(String url, UrlEncodedFormEntity urlEntity) throws Exception {

        if (urlEntity != null) {
            url += "?" + EntityUtils.toString(urlEntity, "utf-8");
        }

        HttpGet httpGet = new HttpGet(url);

        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = httpclient.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            httpGet.abort();
            throw new RuntimeException("HttpClient,error status code :" + statusCode);
        }
        HttpEntity entity = response.getEntity();
        String result = null;
        if (entity != null) {
            result = EntityUtils.toString(entity, "utf-8");
            EntityUtils.consume(entity);
            response.close();
            return result;
        } else {
            return null;
        }
    }
}
