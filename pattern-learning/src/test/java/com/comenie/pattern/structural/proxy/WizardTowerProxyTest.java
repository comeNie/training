package com.comenie.pattern.structural.proxy;

import org.junit.Test;

/**
 * Created by 波 on 2017/2/3.
 */
public class WizardTowerProxyTest {
    @Test
    public void enter() throws Exception {
        WizardTowerProxy wizardTowerProxy = new WizardTowerProxy();
        wizardTowerProxy.enter(new Wizard("test"));
    }

}