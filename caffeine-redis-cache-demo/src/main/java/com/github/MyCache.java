package com.github;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

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
		return new SimpleValueWrapper(cache.get(key));
	}

	@Override
	public <T> T get(Object key, Class<T> type) {
		return (T) cache.get(key);
	}

	@Override
	public <T> T get(Object key, Callable<T> valueLoader) {
		Object value = cache.get(key);
		if (value == null) {
			try {
				value = valueLoader.call();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return (T) value;
	}

	@Override
	public void put(Object key, Object value) {
		this.cache.put((String) key, value);
	}

	@Override
	public ValueWrapper putIfAbsent(Object key, Object value) {
		return new SimpleValueWrapper(this.cache.putIfAbsent((String) key, value));
	}

	@Override
	public void evict(Object key) {
		this.cache.remove(key);
	}

	@Override
	public void clear() {
		this.cache.clear();
	}
}
