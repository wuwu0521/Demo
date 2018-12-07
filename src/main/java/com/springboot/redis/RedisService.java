package com.springboot.redis;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * redisService 基本redis操作封装
 * @author YTGHTGHS
 * @date 2018年1月4日
 * @description 
 * @param <K>
 * @param <V>
 */
public interface RedisService<K extends Serializable, V> {
	
	/**
	 * 移除某个对象
	 * @param key
	 */
	void remove(final K key);
	
	/**
	 * 判断是否存在该key
	 * @param key
	 * @return
	 */
	boolean exists(final K key);
	
	/**
	 * 获取缓存对象
	 * @param key
	 * @return
	 */
	V getObj(final K key);
	
	/**
	 * 获取并重置原始对象
	 * @param key
	 * @param value
	 * @return
	 */
	V getAndSetObj(final K key, V value);
	
	/**
	 * 添加缓存对象
	 * @param key
	 * @param value
	 * @return
	 */
	boolean setObj(final K key, V value);
	
	/**
	 * 添加缓存对象，设置超时时间，单位S（秒）
	 * @param  key
	 * @param  value
	 * @param  expireTime
	 * @param  t
	 * @return boolean  
	 * @author litao
	 * @date 2018年5月15日
	 */
	public boolean setObj(K key, V value, Long expireTime, TimeUnit t) ;
	
	/**
	 * 添加缓存对象，仅当键不存在时
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean setnx(final K key,V value);
	
	/**
	 * 对缓存对象，设置过期时间，单位S（秒）
	 * @param key
	 * @param expireTime
	 * @param t
	 * @return
	 */
	public boolean expire(K key, Long expireTime, TimeUnit t);
	
	/**
	 * 添加缓存对象且设置过期时间，仅当键不存在时
	 * @param key
	 * @param value
	 * @param expireTime
	 * @param t
	 * @return
	 */
	public boolean setInxExp(final K key, V value, Long expireTime, TimeUnit t);
}
