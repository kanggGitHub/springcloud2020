package com.kg.cloud.controller;

import com.kg.springcloud.entities.CommonResult;
import com.kg.springcloud.entities.Payment;
import com.kg.cloud.service.PaymentService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@Api(value="测试类",tags = "测试类")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;



    @Value("${server.port}")
    private String serverPort;


    @ApiOperation(value="插入数据",notes="新增数据保存入库",response=String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serial", value = "内容", required = true, dataType = "String"),
    })
    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果是："+result);
        // 判断是否插入成功
        if (result>0){
            return new CommonResult(200,"插入数据成功,serverPort"+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败,serverPort"+serverPort,null);
        }
    }

    @ApiOperation(value = "列表", notes = "查看列表数据", responseContainer = "List", response = Payment.class)
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "Integer")
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("*****查询结果："+result);
        // 判断是否插入成功
        if (result!=null){
            return new CommonResult(200,"查询成功,serverPort"+serverPort,result);
        }else {
            return new CommonResult(444,"没有对应记录，查询id："+id+"serverPort"+serverPort);
        }
    }


    @GetMapping("/payment/discovery")
    public DiscoveryClient discovery(){
        // 得到所有服务名
        List<String> services = discoveryClient.getServices();
        services.forEach(ele->{
            log.info("***service***"+ele);
        });
        // 得到服务名对应的信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(ele->{
            Map<String, String> metadata = ele.getMetadata();
            String scheme = ele.getScheme();
            log.info(metadata.toString());
            log.info(scheme);
            log.info(ele.getServiceId()+"\t"+ele.getHost()+"\t"+ele.getPort()+"\t"+ele.getUri());
        });
        return discoveryClient;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout()
    {
        // 业务逻辑处理正确，但是需要耗费3秒钟
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return serverPort;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }

//    @GetMapping("/payment/zipkin")
//    public String paymentZipkin(){
//        return "我是 zipkin";
//    }
}
