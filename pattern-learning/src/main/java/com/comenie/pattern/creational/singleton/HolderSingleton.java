package com.comenie.pattern.creational.singleton;

/**
 * Created by 波 on 2017/2/4.
 */
public class HolderSingleton {

    private HolderSingleton(){
    }

    private static  class HelperHolder{
        public  static  final HolderSingleton instance = new HolderSingleton();
    }

    public  HolderSingleton getInstance(){
        return  HelperHolder.instance;
    }
}
