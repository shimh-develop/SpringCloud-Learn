package com.shimh.conf;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;


/**
 * 如果只为某一个Ribbon客户端自定义， 则需要将DefaultRibbonConf与Application放到不同的包中
 * 或指定ComponentScan不扫描它，否则所有的Ribbon客户端都会共享该配置
 *
 */
public class DefaultRibbonConf {

    @Bean
    public IRule iRule() {
        return new RandomRule();
    }
}
