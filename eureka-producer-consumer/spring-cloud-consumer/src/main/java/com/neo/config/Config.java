package com.neo.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: Kevin
 * @time: 2020/1/2 10:44
 */

@Configuration
public class Config {
 @Bean
 @LoadBalanced
 public RestTemplate restTemplate(RestTemplateBuilder builder){
 return builder.build();
 }

}
