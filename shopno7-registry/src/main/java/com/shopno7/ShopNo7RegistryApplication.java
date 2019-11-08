package com.shopno7.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName ShopNo7RegistryApplication
 * @Description 启动类
 * @Author Allen·Chen
 * @Date 2019/11/6 22:30
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class ShopNo7RegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopNo7RegistryApplication.class, args);
    }
}
