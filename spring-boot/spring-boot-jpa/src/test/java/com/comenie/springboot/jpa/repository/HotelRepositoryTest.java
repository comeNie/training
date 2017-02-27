package com.comenie.springboot.jpa.repository;

import com.comenie.springboot.jpa.domain.City;
import com.comenie.springboot.jpa.domain.Hotel;
import com.comenie.springboot.jpa.domain.HotelSummary;
import com.comenie.springboot.jpa.domain.Rating;
import com.comenie.springboot.jpa.domain.RatingCount;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by 波 on 2017/2/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelRepositoryTest {
    @Autowired
    CityRepository cityRepository;
    @Autowired
    HotelRepository repository;

    @Test
    public void executesQueryMethodsCorrectly() {
        City city = this.cityRepository
                .findAll(new PageRequest(0, 1, Sort.Direction.ASC, "name")).getContent()
                .get(0);
        assertThat(city.getName()).isEqualTo("Atlanta");

        Page<HotelSummary> hotels = this.repository.findByCity(city,
                new PageRequest(0, 10, Sort.Direction.ASC, "name"));
        Hotel hotel = this.repository.findByCityAndName(city,
                hotels.getContent().get(0).getName());
        assertThat(hotel.getName()).isEqualTo("Doubletree");

        List<RatingCount> counts = this.repository.findRatingCounts(hotel);
        assertThat(counts).hasSize(1);
        assertThat(counts.get(0).getRating()).isEqualTo(Rating.AVERAGE);
        assertThat(counts.get(0).getCount()).isGreaterThan(1L);
    }

}