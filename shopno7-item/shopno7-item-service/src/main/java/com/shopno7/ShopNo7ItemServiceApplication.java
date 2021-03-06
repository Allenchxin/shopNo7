package com.shopno7;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * @ClassName ShopNo7ItemServiceApplication
 * @Description TODO
 * @Author Allen·Chen
 * @Date 2019/11/6 23:39
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.shopno7.item.mapper")//mapper层接口包扫描
public class ShopNo7ItemServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopNo7ItemServiceApplication.class, args);
    }
}
