package com.comenie.pattern.behavioral.iterator;

import org.junit.Test;

/**
 * Created by 波 on 2017/2/7.
 */
public class TreasureChestTest {

    @Test
    public void testIterator() {
        TreasureChest chest = new TreasureChest();

        ItemIterator ringIterator = chest.Iterator(ItemType.RING);
        while (ringIterator.hasNext()) {
            System.out.println(ringIterator.next());
        }

        System.out.println("----------");

        ItemIterator potionIterator = chest.Iterator(ItemType.POTION);
        while (potionIterator.hasNext()) {
            System.out.println(potionIterator.next());
        }

        System.out.println("----------");

        ItemIterator weaponIterator = chest.Iterator(ItemType.WEAPON);
        while (weaponIterator.hasNext()) {
            System.out.println(weaponIterator.next());
        }

        System.out.println("----------");

        ItemIterator it = chest.Iterator(ItemType.ANY);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}