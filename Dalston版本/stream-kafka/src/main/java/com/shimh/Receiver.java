package com.shimh;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * @author: shimh
 * @create: 2019年04月
 **/
@EnableBinding({Sink.class,CustomSink.class})
public class Receiver {

    @StreamListener(Sink.INPUT)
    public void receive(Object payload) {
        System.out.println("Sink Received: " + payload);
    }

    @StreamListener(CustomSink.INPUT)
    public void customReceive(Object payload) {
        System.out.println("CustomSink Received: " + payload);
    }

}
