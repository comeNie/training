package com.comenie.pattern.behavioral.strategy;

import org.junit.Test;

/**
 * Created by 波 on 2017/2/6.
 */
public class DragonSlayerTest {
    @Test
    public void testStrategy() {
        System.out.println("Green dragon spotted ahead!");
        DragonSlayer dragonSlayer = new DragonSlayer(new MeleeStrategy());
        dragonSlayer.goToBattle();
        System.out.println("Red dragon emerges.");
        dragonSlayer.changeStrategy(new ProjectileStrategy());
        dragonSlayer.goToBattle();
        System.out.println("Black dragon lands before you.");
        dragonSlayer.changeStrategy(new SpellStrategy());
        dragonSlayer.goToBattle();
    }

}