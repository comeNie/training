package com.comenie.springboot.actuator.monitor;

import com.google.common.base.Throwables;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 波 on 2017/2/20.
 */
@Component
public class TestHealth implements HealthIndicator{

    @Override
    public Health health() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            RestTemplate rest = new RestTemplate();
            rest.getForObject("http://www.amazon.com", String.class);
            return Health.up().build();
        } catch (Exception e) {
            return Health.down().withDetail("reason",Throwables.getStackTraceAsString(e)).build();
        }
    }
}
