package com.example.xyq.ndp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.example.xyq.ndp")
@EnableDiscoveryClient
public class NacosDemoProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosDemoProjectApplication.class, args);
    }

}
