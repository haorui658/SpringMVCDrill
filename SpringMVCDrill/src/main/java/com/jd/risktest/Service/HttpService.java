package com.jd.risktest.Service;

import com.jd.risktest.Model.HttpRequestInfo;
import com.jd.risktest.Model.MQInfo;
import com.jd.risktest.Repository.HttpRepository;
import com.jd.risktest.Repository.MqInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cdhaorui on 2017/4/6.
 */
@Service
public class HttpService {


    @Autowired
    private HttpRepository HttpDao;

    public void save(HttpRequestInfo info) {
        HttpDao.saveAndFlush(info);
    }

    public void delete(Long id) {
        HttpDao.delete(id);
    }

    public void update(HttpRequestInfo info) {
        HttpDao.save(info);
    }

    public Iterable<HttpRequestInfo> findAll() {
        return HttpDao.findAll();
    }

    public HttpRequestInfo findById(Long id) {
        return HttpDao.findById(id);
    }
}
