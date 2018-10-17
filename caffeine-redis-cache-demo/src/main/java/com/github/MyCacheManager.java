package com.github;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class MyCacheManager implements CacheManager {

	private MyCache cache;
	private volatile Set<String> cacheNames = new LinkedHashSet<>();

	public MyCacheManager(MyCache cache) {
		this.cache = cache;
		this.cacheNames.add(cache.getName());
	}

	@Override
	public Cache getCache(String name) {
		return this.cache;
	}

	@Override
	public Collection<String> getCacheNames() {
		return this.cacheNames;
	}
}
