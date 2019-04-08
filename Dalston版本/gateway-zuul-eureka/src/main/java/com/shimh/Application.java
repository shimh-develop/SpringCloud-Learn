package com.shimh;


import com.netflix.zuul.ZuulFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class Application {

    @Bean
    public ZuulFallbackProvider zuulFallbackProvider() {
        return new CustomFallbackProvider();
    }

    @Bean
    public ZuulFilter zuulFilter() {
        return new CustomFilter();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }

}
