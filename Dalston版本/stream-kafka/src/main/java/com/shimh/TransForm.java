package com.shimh;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * @author: shimh
 * @create: 2019年04月
 **/
//@EnableBinding(Processor.class)
public class TransForm {

    @ServiceActivator(inputChannel = Processor.INPUT,outputChannel = Processor.OUTPUT)
    public Object transform(Object payload){
        System.out.println("消息中转站："+payload);
        return payload;
    }


}
