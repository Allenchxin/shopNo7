package com.shopno7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName ShopNo7GatewayApplication
 * @Description TODO
 * @Author Allen·Chen
 * @Date 2019/11/6 22:45
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ShopNo7GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopNo7GatewayApplication.class, args);
    }
}
