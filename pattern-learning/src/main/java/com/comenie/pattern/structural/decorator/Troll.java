package com.comenie.pattern.structural.decorator;

/**
 * Created by 波 on 2017/2/4.
 */
public class Troll implements  Hostile {

    public void attack() {
        System.out.println("The troll swings at you with a club!");
    }

    public int getAttackPower() {
        return 10;
    }

    public void fleeBattle() {
        System.out.println("The troll shrieks in horror and runs away!");
    }
}
