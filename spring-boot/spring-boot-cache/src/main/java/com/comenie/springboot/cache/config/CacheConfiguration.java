package com.comenie.springboot.cache.config;

import com.google.common.cache.CacheBuilder;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Created by 波 on 2017/2/17.
 */
@Configuration
@EnableCaching
public class CacheConfiguration {

    @Bean
    public CacheManager getCacheManager(){
        GuavaCacheManager  cacheManager = new GuavaCacheManager();
        cacheManager.setCacheBuilder(CacheBuilder.newBuilder().expireAfterWrite(10, TimeUnit.SECONDS).maximumSize(10));
        return  cacheManager;
    }
}
