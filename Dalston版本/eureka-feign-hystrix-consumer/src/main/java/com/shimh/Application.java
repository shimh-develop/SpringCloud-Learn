package com.shimh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@EnableDiscoveryClient //向注册中心注册
@EnableFeignClients //开启 Feign 客户端
@EnableCircuitBreaker
@SpringBootApplication
public class Application {

    @Autowired
    private TestFeignClient testFeignClient;


    @GetMapping("/port")
    public String port() {
        return testFeignClient.port();
    }

    @GetMapping("/test")
    public String test() {
        return testFeignClient.test(1, "史明辉");
    }

    @GetMapping("/test1")
    public String test1() {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("id", 1);
        parameter.put("username", "史明辉");
        return testFeignClient.test(parameter);
    }

    @GetMapping("/test2")
    public String test2() {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("id", 1);
        parameter.put("username", "史明辉");
        return testFeignClient.test2(parameter);
    }



    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}
