package com.comenie.springboot.cache.controller;

import com.comenie.springboot.cache.service.CacheService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 波 on 2017/2/17.
 */
@RestController
@RequestMapping("/cache")
public class CacheController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CacheController.class);

    @Autowired
    private CacheService cacheService;

    /**
     * 查询方法
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getByCache() {
        Long startTime = System.currentTimeMillis();
        long timestamp = this.cacheService.getByCache();
        Long endTime = System.currentTimeMillis();
        LOGGER.warn("get by cache----------- 耗时: {}" ,(endTime - startTime));
        return timestamp+"";
    }

    /**
     * 保存方法
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void save() {
        this.cacheService.save();
    }

    /**
     * 删除方法
     */
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public void delete() {
        this.cacheService.delete();
    }

}
