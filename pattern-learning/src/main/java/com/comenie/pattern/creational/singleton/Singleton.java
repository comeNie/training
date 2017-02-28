package com.comenie.pattern.creational.singleton;

/**
 * Created by 波 on 2017/1/22.
 */
public class Singleton {

    private static  Singleton instance = new Singleton();

    private  Singleton(){

    }

    public  static  Singleton getInstance(){
        return  instance;
    }

}
