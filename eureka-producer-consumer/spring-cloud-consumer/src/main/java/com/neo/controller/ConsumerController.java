package com.neo.controller;

import com.neo.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ConsumerController {

    @Autowired
    HelloRemote HelloRemote;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello1/{name1}")
    public String index(@PathVariable("name1") String name) {
        return HelloRemote.hello(name);
    }

//http://localhost:9000/he/hello?name=neolo  spring-cloud-producer
    @RequestMapping("/hello2/{name2}")
    public String queryById(@PathVariable("name2") String name2) {
        String url = "http://spring-cloud-producer/he/hello?name=" + name2;
        String str = restTemplate.getForObject(url, String.class);
        return str;
    }

}