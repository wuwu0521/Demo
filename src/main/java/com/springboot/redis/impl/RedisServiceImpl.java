package com.springboot.redis.impl;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.springboot.redis.RedisService;
@Component
public class RedisServiceImpl<K extends Serializable, V> implements RedisService<K, V>{
	
	@Resource
	private RedisTemplate<Serializable, V> redisTemplate;
	

	@Override
	public void remove(K key) {
		redisTemplate.delete(key);
	}

	@Override
	public boolean exists(K key) {
		return redisTemplate.hasKey(key);
	}

	@Override
	public V getObj(K key) {
		V result = redisTemplate.opsForValue().get(key);//拆分写法，方便调试
		return result;
	}
	
	@Override
	public V getAndSetObj(K key, V value) {
		return redisTemplate.opsForValue().getAndSet(key, value);
	}

	@Override
	public boolean setObj(K key, V value) {
		redisTemplate.opsForValue().set(key, value);
		return true;
	}

	@Override
	public boolean setObj(K key, V value, Long expireTime, TimeUnit t) {
		if (expireTime > 0) {
			redisTemplate.opsForValue().set(key, value, expireTime, t);
			return true;
		}
		return false;
	}

	@Override
	public boolean setnx(K key, V value) {
		return 	redisTemplate.opsForValue().setIfAbsent(key, value);
	}

	@Override
	public boolean expire(K key, Long expireTime, TimeUnit t) {
		if (expireTime > 0) {
			return redisTemplate.expire(key, expireTime, t);
		}
		return false;
	}

	@Override
	public boolean setInxExp(K key, V value, Long expireTime, TimeUnit t) {
        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
            if (expireTime > 0) {
                return redisTemplate.expire(key, expireTime, t);
            } else {
                return true;
            }
        }
        return false;
    }

	
}
