package com.jd.risktest.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by gooo on 2017/4/10.
 */
@Entity
public class HttpRequestInfo {


    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;

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

    private String expectResponse;
}
