package com.leap.jixianceshiboot.mapper;
import com.leap.jixianceshiboot.entity.Policy;
import com.leap.jixianceshiboot.entity.PolicyTypeCount;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface PolicyQueryMapper{
    public List<Policy> getPolicy(String name,String document,String organ,String text);
    List<PolicyTypeCount> findPolicyCountsByType();
    List<Policy> getPolicy1(String type);
}

