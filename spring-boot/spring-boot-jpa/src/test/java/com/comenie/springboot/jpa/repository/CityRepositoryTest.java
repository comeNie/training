package com.comenie.springboot.jpa.repository;

import com.comenie.springboot.jpa.domain.City;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by 波 on 2017/2/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CityRepositoryTest {
    @Autowired
    CityRepository repository;

    @Test
    public void findsFirstPageOfCities() {

        Page<City> cities = this.repository.findAll(new PageRequest(0, 10));
        assertThat(cities.getTotalElements()).isGreaterThan(20L);
    }
}