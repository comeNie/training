package com.comenie.pattern.structural.proxy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 波 on 2017/2/3.
 */
public class JDKWizardTowerProxyTest {
    @Test
    public void bind() throws Exception {
        WizardTower wizardTower = new WizardTowerImpl();
        Object bind = new JDKWizardTowerProxy().bind(wizardTower);
        Assert.assertTrue(bind instanceof WizardTower);
        ((WizardTower)bind).enter(new Wizard("test"));
    }

}