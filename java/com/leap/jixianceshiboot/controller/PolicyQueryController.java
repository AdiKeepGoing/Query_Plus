package com.leap.jixianceshiboot.controller;

import com.leap.jixianceshiboot.entity.Policy;
import com.leap.jixianceshiboot.entity.PolicyTypeCount;
import com.leap.jixianceshiboot.service.PolicyQueryService;
import com.leap.jixianceshiboot.util.PageBean;
import com.leap.jixianceshiboot.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policyQuery")
@CrossOrigin
public class PolicyQueryController {
    @Autowired
    private PolicyQueryService policyQueryService;

    @GetMapping
    public Result<PageBean<Policy>> getPolicy(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String document,
            @RequestParam(required = false) String organ,
            @RequestParam(required = false) String text
    ){
        PageBean<Policy> pageBean = policyQueryService.getPolicy(pageNum, pageSize, name, document, organ, text);
        return Result.success(pageBean);
    }
    @GetMapping("/types")
    public ResponseEntity<List<PolicyTypeCount>> getPolicyCountByTypes() {
        List<PolicyTypeCount> counts = policyQueryService.getPolicyCountsByType();
        return ResponseEntity.ok(counts);
    }

    @GetMapping("/Get")
    public Result<PageBean<Policy>> GetPolicy1(
            @RequestParam(required = false) String type
    ){
        Integer pageNum = 1;
        Integer pageSize = 8;
        PageBean<Policy> pageBean = policyQueryService.getPolicy1(pageNum, pageSize, type);
        return Result.success(pageBean);
    }

}