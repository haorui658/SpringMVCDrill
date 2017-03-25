package com.jd.risktest.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by gooo on 2017/3/25.
 */
public class UIMService {

    public Map<String, Uim> resourceMap;

    public Map<String, Uim> getResourceMap() {
        return resourceMap;
    }

    public void setResourceMap(Map<String, Uim> resourceMap) {
        this.resourceMap = resourceMap;
    }

    public Uim getUim(String key) {
        return resourceMap.get(key);
    }

}