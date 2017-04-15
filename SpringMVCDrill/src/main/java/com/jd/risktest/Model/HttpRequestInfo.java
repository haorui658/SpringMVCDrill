package com.jd.risktest.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by gooo on 2017/4/10.
 */
@Entity
public class HttpRequestInfo {


    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    private String name;

    private String url;

    private String method;//get post

    private String parameter;

    private Integer cookieType;

    private String creater;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    private String remark;

    private String latestResult;

    private String latestResponse;

    private String expectResponse;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public Integer getCookieType() {
        return cookieType;
    }

    public void setCookieType(Integer cookieType) {
        this.cookieType = cookieType;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getExpectResponse() {
        return expectResponse;
    }

    public void setExpectResponse(String expectResponse) {
        this.expectResponse = expectResponse;
    }

    public String getLatestResult() {
        return latestResult;
    }

    public void setLatestResult(String latestResult) {
        this.latestResult = latestResult;
    }

    public String getLatestResponse() {
        return latestResponse;
    }

    public void setLatestResponse(String latestResponse) {
        this.latestResponse = latestResponse;
    }
}
