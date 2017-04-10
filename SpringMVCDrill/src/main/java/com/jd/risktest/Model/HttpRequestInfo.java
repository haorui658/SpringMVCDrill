package com.jd.risktest.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Map;

/**
 * Created by gooo on 2017/4/10.
 */
//@Entity
public class HttpRequestInfo {


    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;

    private String name;

    private String category;

    private String url;

    private String method;//get post

    private Map<String,String> parameter;

    private Integer cookieType;

    private String remark;

    private String expectResponse;
}
