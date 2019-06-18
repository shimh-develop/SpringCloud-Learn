package com.shimh;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author: shimh
 * @create: 2019年04月
 **/
public interface CustomSink {
    String INPUT = "custom-sink";

    @Input(CustomSink.INPUT)
    SubscribableChannel input();

}
