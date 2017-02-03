package com.comenie.pattern.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 波 on 2017/2/3.
 */
public class JDKWizardTowerProxy  implements InvocationHandler{

    private  Object target;

    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target,args);
    }
}
