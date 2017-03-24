package com.jd.risktest.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Value;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UimTest {

	/** UIM API开放中心地址 */
	@Value("${uim.auth.authAddress}")
	private String authAddress;
	/** appKey */
	@Value("${uim.auth.appKey}")
	private String appKey;
	/** token */
	@Value("${uim.auth.token}")
	private String token;

	/** 鉴权服务方法名称 */
	private static final String USERAUTHTICKET = "uim.auth.res.getUserAuthTicket";// 获取用户凭证
//	private static final String AUTHAPPROOTMENUS = "uim.auth.res.getAuthAppChildMenus";// 获取一级菜单
//	private static final String AUTHDATA = "uim.auth.res.getAuthData";// 获取数据权限

	public boolean PermissionTest(String reqId,String isExistCode) throws Exception {
		String method = USERAUTHTICKET;
		String ReponseText = getUimReponseText(method, reqId);
		//System.out.println(ReponseText);
		JSONObject jsonObject = JSON.parseObject(ReponseText).getJSONObject("authTicket.get.response");
		if (jsonObject.getIntValue("resStatus") == 200) {
			JSONObject jsonObject2 = jsonObject.getJSONObject("authTicket");
			JSONArray jsonArray = jsonObject2.getJSONArray("authCodes");
			for (int i = 0; i < jsonArray.size(); i++) {
				if(isExistCode.equals(jsonArray.get(i))){
					return true;
					//System.out.println("用户"+reqId+"有"+isExistCode+"权限");
				}
			}
		}else
		{
			throw new Exception("UIM调用异常");
		}
		return false;
	}
	public  String getUimReponseText(String reqId){
		String reponse="";
		String method = USERAUTHTICKET;
		try {
			reponse = getUimReponseText(method, reqId);
		}catch (Exception e){
			reponse=e.getMessage();
		}
		return reponse;
	}
	public  String getUimReponseText(String method, String reqId) throws  IOException {
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
		String[] arrTmp = { appKey, token, timestamp, random };
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
}
