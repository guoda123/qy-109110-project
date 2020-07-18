package com.aaa.config;

import com.aaa.properties.RedisClusterProperties;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

//@Configuration
public class RedisClusterConfig {
    @Autowired
    private RedisClusterProperties redisClusterProperties;

//    @Bean
    public JedisCluster getJedisCluster() {
        String nodes = redisClusterProperties.getNodes();
        String[] split = nodes.split(",");
        Set<redis.clients.jedis.HostAndPort> hostAndPortSet = new HashSet<redis.clients.jedis.HostAndPort>();
        for(String hostPort : split) {
            String[] split1 = hostPort.split(":");// 0:ip 1:port
            redis.clients.jedis.HostAndPort hostAndPort = new HostAndPort(split1[0], Integer.parseInt(split1[1]));
            hostAndPortSet.add(hostAndPort);
        }
        return new JedisCluster(hostAndPortSet, redisClusterProperties.getCommandTimeout(), redisClusterProperties.getMaxAttempts());
    }

}
