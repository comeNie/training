package com.comenie.pattern.creational.singleton;

/**
 * Created by 波 on 2017/2/4.
 */
public class LazySingleton {

    private static LazySingleton instance = null;

    private LazySingleton() {
    }

    public synchronized static LazySingleton getInstance() {
		/*
		 * The instance gets created only when it is called for first time.
		 * Lazy-loading
		 */
        if (instance == null) {
            instance = new LazySingleton();
        }

        return instance;
    }
}
