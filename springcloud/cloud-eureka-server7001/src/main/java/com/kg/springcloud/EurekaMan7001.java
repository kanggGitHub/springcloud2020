package com.kg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class EurekaMan7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMan7001.class,args);
    }
}
