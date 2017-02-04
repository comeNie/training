package com.comenie.pattern.creational.simpleFactory;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 波 on 2017/2/4.
 */
public class ProductFactoryTest {

    @Test
    public void testFactory() {
        Product product = ProductFactory.createProduct("A");
        boolean result = product instanceof  AProductImpl;
        Assert.assertTrue(result);
        Assert.assertFalse(product instanceof BProductImpl);
    }
}