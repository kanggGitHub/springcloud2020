package com.kg.springcloud.controller;


import com.kg.springcloud.entities.CommonResult;
import com.kg.springcloud.entities.Payment;
import com.kg.springcloud.service.OrderService;
import io.micrometer.shaded.org.pcollections.OrderedPSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Priority;
import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return orderService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        return orderService.paymentFeignTimeout();
    }

}
