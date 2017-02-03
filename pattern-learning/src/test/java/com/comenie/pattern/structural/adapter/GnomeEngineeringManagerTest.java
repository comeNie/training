package com.comenie.pattern.structural.adapter;

import org.junit.Test;

/**
 * Created by 波 on 2017/2/3.
 */
public class GnomeEngineeringManagerTest {
    @Test
    public void testAdapter() {
        Engineer manager = new GnomeEngineeringManager();
        manager.operateDevice();
    }

}