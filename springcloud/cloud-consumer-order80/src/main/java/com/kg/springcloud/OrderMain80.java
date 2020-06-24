package com.kg.springcloud;

import com.kg.myrule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @auther zzyy
 * @create 2020-02-18 17:20
 */
@SpringBootApplication
@EnableEurekaClient
//开启自定义负责均衡规则(随机 默认轮询)
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration= MyselfRule.class)
public class OrderMain80
{
    public static void main(String[] args) {
            SpringApplication.run(OrderMain80.class, args);
    }
}
