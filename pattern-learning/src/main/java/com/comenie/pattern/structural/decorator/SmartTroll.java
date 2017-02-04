package com.comenie.pattern.structural.decorator;

/**
 * Created by 波 on 2017/2/4.
 */
public class SmartTroll  implements Hostile{

    private Hostile decorated;

    public SmartTroll(Hostile decorated) {
        this.decorated = decorated;
    }

    public void attack() {
        System.out.println("The troll throws a rock at you!");
        decorated.attack();
    }

    public int getAttackPower() {
        // decorated troll power + 20 because it is smart
        return decorated.getAttackPower() + 20;
    }

    public void fleeBattle() {
        System.out.println("The troll calls for help!");
        decorated.fleeBattle();
    }


}
