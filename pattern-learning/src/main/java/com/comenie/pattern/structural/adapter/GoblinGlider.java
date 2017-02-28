package com.comenie.pattern.structural.adapter;

/** adaptee in the pattern.
 * Created by 波 on 2017/2/3.
 */
public class GoblinGlider {

    public void attachGlider() {
        System.out.println("Glider attached.");
    }

    public void gainSpeed() {
        System.out.println("Gaining speed.");
    }

    public void takeOff() {
        System.out.println("Lift-off!");
    }
}
