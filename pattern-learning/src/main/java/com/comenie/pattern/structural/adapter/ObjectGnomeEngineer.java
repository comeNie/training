package com.comenie.pattern.structural.adapter;

/**
 * Created by 波 on 2017/2/3.
 */
public class ObjectGnomeEngineer extends  GoblinGlider  implements  Engineer {

    public void operateDevice() {
        this.attachGlider();
        this.gainSpeed();
        this.takeOff();
    }
}
