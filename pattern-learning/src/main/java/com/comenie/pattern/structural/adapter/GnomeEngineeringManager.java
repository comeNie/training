package com.comenie.pattern.structural.adapter;

/**
 * Created by 波 on 2017/2/3.
 */
public class GnomeEngineeringManager implements  Engineer {
    private Engineer engineer;

    public GnomeEngineeringManager() {
        engineer = new GnomeEngineer();
    }

    public void operateDevice() {
        engineer.operateDevice();
    }
}
