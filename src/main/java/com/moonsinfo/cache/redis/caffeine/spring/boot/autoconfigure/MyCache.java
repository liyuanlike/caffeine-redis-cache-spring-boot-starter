package com.moonsinfo.cache.redis.caffeine.spring.boot.autoconfigure;

import org.springframework.cache.Cache;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

public class MyCache implements Cache {

	private final String name;
	private Map<String, Object> cache;

	public MyCache(String name) {
		this.name = name;
		this.cache = new ConcurrentHashMap<>();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Object getNativeCache() {
		return this.cache;
	}

	@Override
	public ValueWrapper get(Object key) {
		return null;
	}

	@Override
	public <T> T get(Object key, Class<T> type) {
		return null;
	}

	@Override
	public <T> T get(Object key, Callable<T> valueLoader) {
		return null;
	}

	@Override
	public void put(Object key, Object value) {

	}

	@Override
	public ValueWrapper putIfAbsent(Object key, Object value) {
		return null;
	}

	@Override
	public void evict(Object key) {

	}

	@Override
	public void clear() {

	}
}
