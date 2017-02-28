package com.comenie.pattern.creational.builder;

import org.junit.Test;

/**
 * Created by 波 on 2017/2/4.
 */
public class HeroTest {
    @Test
    public void testBuilder() {
        Hero mage = new Hero.HeroBuilder(Profession.MAGE, "Riobard")
                .withHairColor(HairColor.BLACK).withWeapon(Weapon.DAGGER)
                .build();
        System.out.println(mage);

        Hero warrior = new Hero.HeroBuilder(Profession.WARRIOR, "Amberjill")
                .withHairColor(HairColor.BLOND)
                .withHairType(HairType.LONG_CURLY).withArmor(Armor.CHAIN_MAIL)
                .withWeapon(Weapon.SWORD).build();
        System.out.println(warrior);

        Hero thief = new Hero.HeroBuilder(Profession.THIEF, "Desmond")
                .withHairType(HairType.BALD).withWeapon(Weapon.BOW).build();
        System.out.println(thief);
    }
}