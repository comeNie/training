package com.comenie.pattern.behavioral.observer;

import com.comenie.pattern.behavioral.observer.generic.GHobbits;
import com.comenie.pattern.behavioral.observer.generic.GOrcs;
import com.comenie.pattern.behavioral.observer.generic.GWeather;

import org.junit.Test;

/**
 * Created by 波 on 2017/2/6.
 */
public class WeatherTest {

    @Test
    public void testObserver() {
        Weather weather = new Weather();
        weather.addObserver(new Orcs());
        weather.addObserver(new Hobbits());

        weather.timePasses();
        weather.timePasses();
        weather.timePasses();
        weather.timePasses();

        // Generic observer inspired by Java Generics and Collection by Naftalin & Wadler
        System.out.println("\n--Running generic version--");
        GWeather gWeather = new GWeather();
        gWeather.addObserver(new GOrcs());
        gWeather.addObserver(new GHobbits());

        gWeather.timePasses();
        gWeather.timePasses();
        gWeather.timePasses();
        gWeather.timePasses();
    }
}