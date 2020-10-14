package com.chengju.cloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class JedisClusterConfig {
    @Autowired
    private Environment env;

    @Bean
    public JedisCluster jedisCluster(){
        String[] serversArray = env.getProperty("redis.cluster.servers")
                .split(",");
        Set<HostAndPort> nodes = new HashSet<>();
        for(String ipPort : serversArray){
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(),Integer.valueOf(ipPortPair[1].trim())));
        }
        return new JedisCluster(nodes,Integer.valueOf(env.getProperty("redis.cluster.commandTimeout")));
    }


}
