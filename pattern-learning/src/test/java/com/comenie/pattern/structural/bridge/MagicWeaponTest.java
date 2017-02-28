package com.comenie.pattern.structural.bridge;

import org.junit.Test;

/**
 *
 *  In Bridge pattern both abstraction ({@link MagicWeapon}) and implementation
 * ({@link MagicWeaponImpl}) have their own class hierarchies. The interface of the
 * implementations can be changed without affecting the clients.
 * Created by 波 on 2017/2/3.
 */
public class MagicWeaponTest {
    @Test
    public void testBridge() {
        BlindingMagicWeapon blindingMagicWeapon = new BlindingMagicWeapon(
                new Excalibur());
        blindingMagicWeapon.wield();
        blindingMagicWeapon.blind();
        blindingMagicWeapon.swing();
        blindingMagicWeapon.unwield();

        FlyingMagicWeapon flyingMagicWeapon = new FlyingMagicWeapon(
                new Mjollnir());
        flyingMagicWeapon.wield();
        flyingMagicWeapon.fly();
        flyingMagicWeapon.swing();
        flyingMagicWeapon.unwield();

        SoulEatingMagicWeapon soulEatingMagicWeapon = new SoulEatingMagicWeapon(
                new Stormbringer());
        soulEatingMagicWeapon.wield();
        soulEatingMagicWeapon.swing();
        soulEatingMagicWeapon.eatSoul();
        soulEatingMagicWeapon.unwield();
    }

}