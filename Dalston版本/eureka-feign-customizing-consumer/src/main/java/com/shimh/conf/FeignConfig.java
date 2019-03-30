package com.shimh.conf;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    /**
     * 契约 可以使用Feign注解
     *
     * @return
     */
    @Bean
    public Contract contract() {
        return new Contract.Default();
    }

    /**
     *
     * 指定Feign客户端的Logger  Feign的日志只对DEBUG级别做出响应 Application.yml
     *
     *Logger.Level.
     *              NONE
     *              BASIC
     *              HEADERS
     *              FULL
     *
     *
     * @return
     */
    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }
}
