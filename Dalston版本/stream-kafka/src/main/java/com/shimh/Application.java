package com.shimh;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class Application {

    @Autowired
    private Sender sender;

    @GetMapping("send")
    public void send(String message) {
        sender.send(message);
    }

    @GetMapping("custom/send")
    public void customSend(String message) {
        sender.customSend(message);
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }

}
