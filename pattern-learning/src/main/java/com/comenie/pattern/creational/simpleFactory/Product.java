package com.comenie.pattern.creational.simpleFactory;

/**
 * Created by 波 on 2017/2/4.
 */
public abstract class Product {

    public void commonMethod(){
        System.out.println("common method");
    }

    public  abstract void  method();

}
