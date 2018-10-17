package com.moonsinfo.cache.redis.caffeine.spring.boot.autoconfigure;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.Collection;
import java.util.concurrent.Callable;

public class MyCacheManager implements CacheManager {

	@Override
	public Cache getCache(String name) {
		return null;
	}

	@Override
	public Collection<String> getCacheNames() {
		return null;
	}
}
