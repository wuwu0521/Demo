package com.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
 * 建议server按需层引用
 * @Author: json
 * @Description:
 * @Date: Created in 15:28 2018/6/12
 * @Modified By:
 */
@Configuration
public class RedisConfig {
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;


    @Bean
    RedisTemplate<?, ?> redisTemplate(){
        RedisTemplate<?, ?> rt = new RedisTemplate<>();
        rt.setConnectionFactory(redisConnectionFactory);
        rt.setKeySerializer(new StringRedisSerializer());
        rt.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        rt.setHashKeySerializer(new StringRedisSerializer());
        rt.setHashValueSerializer(new JdkSerializationRedisSerializer());
        return rt;
    }

}
