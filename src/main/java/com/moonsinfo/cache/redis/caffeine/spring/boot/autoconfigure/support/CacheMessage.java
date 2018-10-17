package com.moonsinfo.cache.redis.caffeine.spring.boot.autoconfigure.support;

import java.io.Serializable;

/**  
 * @author fuwei.deng
 * @date 2018年1月29日 下午1:31:17
 * @version 1.0.0
 */
public class CacheMessage implements Serializable {

	private static final long serialVersionUID = 6987669310662078188L;

	private Object key;
	private String cacheName;

	public CacheMessage() {
	}

	public CacheMessage(String cacheName, Object key) {
		super();
		this.cacheName = cacheName;
		this.key = key;
	}

	public String getCacheName() {
		return cacheName;
	}

	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}

	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}
	
}
