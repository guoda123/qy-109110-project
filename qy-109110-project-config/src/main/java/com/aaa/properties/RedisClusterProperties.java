package com.aaa.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:properties/redis_cluster.properties")
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisClusterProperties {

    private String nodes;
    private Integer maxAttempts;
    private Integer commandTimeout;

}