package com.comenie.pattern.creational.singleton;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 波 on 2017/1/22.
 */
public class SingletonTest {
    @Test
    public void testSingleton() {
        Assert.assertTrue(Singleton.getInstance() == Singleton.getInstance());
    }

    @Test
    public void testEnumSingleton() {
        Assert.assertEquals(EnumSingleton.INSTANCE, EnumSingleton.INSTANCE);
    }


}