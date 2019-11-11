package com.shopno7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName ShopNo7UploadApplication
 * @Description TODO
 * @Author Allen·Chen
 * @Date 2019/11/12 1:14
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ShopNo7UploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopNo7UploadApplication.class, args);
    }
}
