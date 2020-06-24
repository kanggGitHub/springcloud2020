package com.kg.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @auther zzyy
 * @create 2020-02-18 17:27
 */
@Configuration
public class ApplicationContextConfig
{
    @Bean
    @LoadBalanced //开启负载均衡
    public RestTemplate restTemplate()
    {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
//        //消息转换器列表
//        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
//        //配置消息转换器StringHttpMessageConverter，并设置utf-8
//        messageConverters.set(1,
//                new StringHttpMessageConverter(StandardCharsets.UTF_8));//支持中文字符集，默认ISO-8859-1，支持utf-8
        return restTemplate;
    }
}
//applicationContext.xml <bean id="" class="">