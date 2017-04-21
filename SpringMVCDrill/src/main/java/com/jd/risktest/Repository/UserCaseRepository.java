package com.jd.risktest.Repository;

import com.jd.risktest.Model.HttpRequestInfo;
import com.jd.risktest.Model.UserCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by cdhaorui on 2017/4/6.
 */
public interface UserCaseRepository extends JpaRepository<UserCase, Long> {

    public List<UserCase> findByInfoId(Long id);
}
