package com.shimh;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = Constant.SERVICE_ID)
public interface EchoService {
    @RequestMapping(value = "/echo/{msg}", method = RequestMethod.GET)
    String echo(@PathVariable("msg") String msg);
}
