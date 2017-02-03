package com.comenie.pattern.structural.adapter;

/**
 * Adapter class
 * Created by 波 on 2017/2/3.
 */
public class GnomeEngineer  implements  Engineer{
    private GoblinGlider goblinGlider;

    public GnomeEngineer(){
        this.goblinGlider = new GoblinGlider();
    }

    public void operateDevice() {
        goblinGlider.attachGlider();
        goblinGlider.gainSpeed();
        goblinGlider.takeOff();
    }
}
