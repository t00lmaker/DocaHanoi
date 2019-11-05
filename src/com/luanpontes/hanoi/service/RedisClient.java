package com.luanpontes.hanoi.service;

import redis.clients.jedis.Jedis;

public class RedisClient {
	
	private Jedis redis;

	private final String URL = "localhost";

	public RedisClient(){
		redis = new Jedis(URL);
	}
	
	public String get(String key) {
		return redis.get(key);
	}
	
	public void set(String key, String value) {
		redis.set( key, value);
	}
	
	public String ping() {
		return redis.ping();
	}

}
