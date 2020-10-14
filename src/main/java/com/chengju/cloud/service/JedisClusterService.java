package com.chengju.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

@Service
public class JedisClusterService {
    @Autowired
    JedisCluster jedisCluster;

    public void set(String key,String value){
        jedisCluster.set(key, value);
    }

    public String get(String key){
        return jedisCluster.get(key);
    }

}
