package com.learning.linnyk.cloud.netflixzuulapigatewayserver;

import com.netflix.zuul.ZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class NetflixZuulApiGatewayServerApplication {


    /**
     * Pattern:
     *      http://{zuul-host}:{zuul-port}/{microservice-name}/{rest-uri}
     *
     * Example:
     *      http://localhost:8765/currency-conversion-service/currency-converter-feign/from/USD/to/INR/quantity/1000
     *
     */
    public static void main(String[] args) {
        SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
    }

    @Bean
    public ZuulFilter zuulFilter() {
        return new ZuulLoggingFilter();
    }
}
