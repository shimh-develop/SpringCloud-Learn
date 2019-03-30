package com.shimh;

import com.shimh.conf.FeignConfig;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="EUREKA-CLIENT", configuration = FeignConfig.class)
public interface CustomFeignClient {

    @RequestLine("GET /port")
    public String port();
}
