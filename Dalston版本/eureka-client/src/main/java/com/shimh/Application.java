package com.shimh;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class Application {

    @Value("${server.port}")
    private int port;

    @RequestMapping("/")
    public String home() {
        return "Hello world";
    }


    @RequestMapping("/port")
    public String port() {
        return "this is from: " + port;
    }

    @GetMapping("/test")
    public String test(@RequestParam("id") int id, @RequestParam("username") String username){
        return String.format("method: test message: id: %s username: %s", id, username);
    }

    @GetMapping("/test1")
    public String test(@RequestParam Map<String, Object> param){
        return String.format("method: test1 message: %s", param);
    }

    @PostMapping("/test2")
    public String test2(@RequestBody Map<String, Object> param){
        return String.format("method: test2 message: %s", param);
    }


    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}
