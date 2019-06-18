package com.shimh;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author: shimh
 * @create: 2019年04月
 **/
public interface CustomSource {
    String OUTPUT = "custom-output";

    @Output(CustomSource.OUTPUT)
    MessageChannel output();
}
