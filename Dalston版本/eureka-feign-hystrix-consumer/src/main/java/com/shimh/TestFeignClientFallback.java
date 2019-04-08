package com.shimh;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author: shimh
 * @create: 2019年04月
 **/
@Component
public class TestFeignClientFallback implements TestFeignClient{

    private String error = "i am fallback something is wrong";

    @Override
    public String port() {
        return error;
    }

    @Override
    public String test(int id, String username) {
        return error;
    }

    @Override
    public String test(Map<String, Object> param) {
        return error;
    }

    @Override
    public String test2(Map<String, Object> param) {
        return error;
    }
}
