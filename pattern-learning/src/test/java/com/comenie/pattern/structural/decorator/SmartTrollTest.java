package com.comenie.pattern.structural.decorator;

import org.junit.Test;

/**
 * Created by 波 on 2017/2/4.
 */
public class SmartTrollTest {


    @Test
    public void testDecorator() {

        // simple troll
        System.out.println("A simple looking troll approaches.");
        Hostile troll = new Troll();
        troll.attack();
        troll.fleeBattle();
        System.out.printf("Simple troll power %d.\n", troll.getAttackPower());

        // change the behavior of the simple troll by adding a decorator
        System.out.println("\nA smart looking troll surprises you.");
        Hostile smart = new SmartTroll(troll);
        smart.attack();
        smart.fleeBattle();
        System.out.printf("Smart troll power %d.\n", smart.getAttackPower());
    }
}