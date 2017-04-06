package com.jd.risktest.Service;

import com.jd.risktest.Model.MQInfo;
import com.jd.risktest.Model.MqInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cdhaorui on 2017/4/6.
 */
@Service
public class MqService {


    @Autowired
    private MqInfoRepository mqDAO;

    public void save(MQInfo info) {
        mqDAO.save(info);
    }

    public void delete(Long id) {
        mqDAO.delete(id);
    }

    public void update(MQInfo info) {
        mqDAO.save(info);
    }

    public Iterable<MQInfo> findAll() {
        return mqDAO.findAll();
    }


}
