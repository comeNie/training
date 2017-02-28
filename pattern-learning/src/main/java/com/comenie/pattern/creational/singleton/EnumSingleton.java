package com.comenie.pattern.creational.singleton;

/**
 * Created by 波 on 2017/2/4.
 */
public enum EnumSingleton {
    INSTANCE;

    public String toString() {
        return getDeclaringClass().getCanonicalName() + "@" + hashCode();
    }
}
