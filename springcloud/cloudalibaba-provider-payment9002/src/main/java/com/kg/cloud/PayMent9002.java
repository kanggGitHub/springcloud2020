package com.kg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PayMent9002 {
    public static void main(String[] args) {
        SpringApplication.run(PayMent9002.class,args);
    }
}
