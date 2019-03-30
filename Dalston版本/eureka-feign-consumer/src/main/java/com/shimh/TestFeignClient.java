package com.shimh;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name="EUREKA-CLIENT")
public interface TestFeignClient {

    @GetMapping("/port")
    public String port();


    @GetMapping("/test")
    public String test(@RequestParam("id") int id, @RequestParam("username") String username);

    @GetMapping("/test1")
    public String test(@RequestParam Map<String, Object> param);

    @PostMapping("/test2")
    public String test2(@RequestBody Map<String, Object> param);
}
