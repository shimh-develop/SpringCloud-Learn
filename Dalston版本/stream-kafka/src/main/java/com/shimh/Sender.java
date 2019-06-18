package com.shimh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;

/**
 * @author: shimh
 * @create: 2019年04月
 **/
@EnableBinding({Source.class, CustomSource.class})
public class Sender {

    @Autowired
    private Source source;

    @Autowired
    private CustomSource customSource;

    public void send(String message) {
        source.output().send(MessageBuilder.withPayload(message).build());
    }

    public void customSend(String message) {
        customSource.output().send(MessageBuilder.withPayload(message).build());
    }
}
