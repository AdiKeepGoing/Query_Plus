package com.leap.jixianceshiboot.entity;
import lombok.Data;

@Data
public class PolicyTypeCount {
    private String type;
    private long count;
    public PolicyTypeCount(String type, long count) {
        this.type = type;
        this.count = count;
    }
}