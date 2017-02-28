package com.comenie.pattern.creational.simpleFactory;

/**
 * Created by 波 on 2017/2/4.
 */
public class ProductFactory {

    public  static Product createProduct(String type){
        if(type.equals("A")){
            return  new AProductImpl();
        }
        if (type.equals("B")){
            return  new BProductImpl();
        }
        return  null;
    }
}
