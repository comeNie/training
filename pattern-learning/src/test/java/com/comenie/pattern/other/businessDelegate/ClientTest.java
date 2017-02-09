package com.comenie.pattern.other.businessDelegate;

import org.junit.Test;

/**
 * Created by 波 on 2017/2/9.
 */
public class ClientTest {

    @Test
    public void testDelegate() {
        BusinessDelegate businessDelegate = new BusinessDelegate();
        businessDelegate.setServiceType(ServiceType.EJB);

        Client client = new Client(businessDelegate);
        client.doTask();

        businessDelegate.setServiceType(ServiceType.JMS);
        client.doTask();
    }

}