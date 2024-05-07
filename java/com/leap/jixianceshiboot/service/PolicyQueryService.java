package com.leap.jixianceshiboot.service;

import com.leap.jixianceshiboot.entity.Policy;
import com.leap.jixianceshiboot.entity.PolicyTypeCount;
import com.leap.jixianceshiboot.util.PageBean;

import java.util.List;

public interface PolicyQueryService {
    public PageBean<Policy> getPolicy(Integer pageNum, Integer pageSize, String name,String document,String organ,String text);

    public PageBean<Policy> getPolicy1(Integer pageNum, Integer pageSize, String type);

    List<PolicyTypeCount> getPolicyCountsByType();
}
