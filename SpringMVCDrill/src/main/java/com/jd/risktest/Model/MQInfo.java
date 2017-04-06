package com.jd.risktest.Model;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by cdhaorui on 2017/4/6.
 */
@Entity
public class MQInfo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;

    private String name;

    private String app;
    private String topic;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
