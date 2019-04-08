package com.shimh;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shimh.conf.DefaultRibbonConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableDiscoveryClient //向注册中心注册
@EnableCircuitBreaker //或@EnableHystrix 开启断路器支持
@SpringBootApplication
@RibbonClient(name="EUREKA-CLIENT", configuration = DefaultRibbonConf.class) //为服务提供者自定义Ribbon配置 name：服务提供者的名字
public class Application {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "handleError")
    @RequestMapping("/port")
    public String port() {
        //通过服务名调用
        return restTemplate.getForObject("http://EUREKA-CLIENT/port", String.class);
    }

    public String handleError() {
        return "hi i am fallback, something is wrong";
    }



    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}
