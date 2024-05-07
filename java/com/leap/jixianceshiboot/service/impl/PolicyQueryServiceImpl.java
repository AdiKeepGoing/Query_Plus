package com.leap.jixianceshiboot.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leap.jixianceshiboot.entity.Policy;
import com.leap.jixianceshiboot.entity.PolicyTypeCount;
import com.leap.jixianceshiboot.mapper.PolicyQueryMapper;
import com.leap.jixianceshiboot.service.PolicyQueryService;
import com.leap.jixianceshiboot.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PolicyQueryServiceImpl implements PolicyQueryService {
    @Autowired
    private PolicyQueryMapper policyQueryMapper;

    @Override
    public PageBean<Policy> getPolicy(Integer pageNum, Integer pageSize, String name,String document,String organ,String text) {
        PageBean<Policy> pageBean = new PageBean<>();

        //开启分页查询PageHelper
        PageHelper.startPage(pageNum,pageSize);
        List<Policy> list = policyQueryMapper.getPolicy(name,document,organ,text);
        Page<Policy> p = (Page<Policy>) list;

        pageBean.setTotal(p.getTotal());
        pageBean.setItems(p.getResult());
        return pageBean;
    }

    @Override
    public PageBean<Policy> getPolicy1(Integer pageNum, Integer pageSize, String type) {
        PageBean<Policy> pageBean = new PageBean<>();

        //开启分页查询PageHelper
        PageHelper.startPage(pageNum,pageSize);
        List<Policy> list = policyQueryMapper.getPolicy1(type);
        Page<Policy> p = (Page<Policy>) list;

        pageBean.setTotal(p.getTotal());
        pageBean.setItems(p.getResult());
        return pageBean;
    }
    @Override
    public List<PolicyTypeCount> getPolicyCountsByType() {
        return policyQueryMapper.findPolicyCountsByType();
    }
}
