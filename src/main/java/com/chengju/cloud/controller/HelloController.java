package com.chengju.cloud.controller;

import com.chengju.cloud.service.JedisClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    JedisClusterService jedisClusterService;

    @RequestMapping("hello")
    public String getJedisCluster(){
        jedisClusterService.set("name","zhangsan");
        String name = jedisClusterService.get("name");
        System.out.println(name);
        return name;
    }


}
