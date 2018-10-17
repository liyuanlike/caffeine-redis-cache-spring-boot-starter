package com.github;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableCaching
public class MyCacheConfig {

    @Bean
    public CacheManager cacheManager() {
        MyCache myCache = new MyCache("objectCache");
        return new MyCacheManager(myCache);
    }

}
