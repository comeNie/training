package com.comenie.pattern.structural.facade;

import org.junit.Test;

/**
 * Created by 波 on 2017/2/4.
 */
public class DwarvenGoldmineFacadeTest {
    @Test
    public void testFacade() {
        DwarvenGoldmineFacade facade = new DwarvenGoldmineFacade();
        facade.startNewDay();
        facade.digOutGold();
        facade.endDay();
    }

}