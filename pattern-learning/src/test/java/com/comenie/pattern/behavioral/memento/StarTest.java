package com.comenie.pattern.behavioral.memento;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by 波 on 2017/2/6.
 */
public class StarTest {

    @Test
    public void testMemento() {
        Stack<StarMemento> states = new Stack<StarMemento>();

        Star star = new Star(StarType.SUN, 10000000, 500000);
        System.out.println(star);
        states.add(star.getMemento());
        star.timePasses();
        System.out.println(star);
        states.add(star.getMemento());
        star.timePasses();
        System.out.println(star);
        states.add(star.getMemento());
        star.timePasses();
        System.out.println(star);
        states.add(star.getMemento());
        star.timePasses();
        System.out.println(star);
        while (states.size() > 0) {
            star.setMemento(states.pop());
            System.out.println(star);
        }
    }

}