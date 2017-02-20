package com.comenie.springboot.actuator.monitor;

import com.google.common.collect.Lists;

import org.springframework.boot.actuate.trace.Trace;
import org.springframework.boot.actuate.trace.TraceRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 波 on 2017/2/20.
 */
@Repository
public class MapTraceRepository implements TraceRepository {

    private List<Trace> list = Lists.newArrayList();
    @Override
    public List<Trace> findAll() {
        return list;
    }

    @Override
    public void add(Map<String, Object> traceInfo) {
        list.add(new Trace(new Date(),traceInfo));
    }
}
