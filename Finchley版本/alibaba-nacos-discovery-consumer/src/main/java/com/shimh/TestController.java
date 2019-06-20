package com.shimh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: shimh
 * @create: 2019年06月
 **/
@RestController
public class TestController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    EchoService echoService;

    @RequestMapping(value = "/echo/{msg}", method = RequestMethod.GET)
    public String echo(@PathVariable String msg) {
        ServiceInstance serviceInstance = loadBalancerClient.choose(Constant.SERVICE_ID);
        String url = serviceInstance.getUri() + "/echo/" + msg;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    @RequestMapping(value = "restTemplate/echo/{msg}", method = RequestMethod.GET)
    public String restTemplateEcho(@PathVariable String msg) {
        String result = restTemplate.getForObject("http://" + Constant.SERVICE_ID + "/echo/" + msg, String.class);
        return result;
    }

    @RequestMapping(value = "feign/echo/{msg}", method = RequestMethod.GET)
    public String feignEcho(@PathVariable String msg) {
        return echoService.echo(msg);
    }


}
