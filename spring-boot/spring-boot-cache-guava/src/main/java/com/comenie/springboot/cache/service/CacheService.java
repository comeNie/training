package com.comenie.springboot.cache.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;


/**
 * Created by 波 on 2017/2/17.
 */
@Component
public class CacheService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CacheService.class);

    @Cacheable(value = "concurrenmapcache")
    public long getByCache() {
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Timestamp(System.currentTimeMillis()).getTime();
    }

    @CachePut(value = "concurrenmapcache")
    public long save() {
        long timestamp = new Timestamp(System.currentTimeMillis()).getTime();
        LOGGER.warn("进行缓存------：{}" , timestamp);
        return timestamp;
    }

    @CacheEvict(value = "concurrenmapcache")
    public void delete() {
        LOGGER.warn("删除缓存--------");
    }
}
