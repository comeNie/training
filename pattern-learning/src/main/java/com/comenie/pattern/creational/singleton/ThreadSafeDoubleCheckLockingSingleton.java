package com.comenie.pattern.creational.singleton;

/**
 * Double check locking
 * <p>
 * http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
 * <p>
 * Created by 波 on 2017/2/4.
 */
public class ThreadSafeDoubleCheckLockingSingleton {

    private  static volatile  ThreadSafeDoubleCheckLockingSingleton instance;

    private ThreadSafeDoubleCheckLockingSingleton(){
        if (null != instance){
            throw  new IllegalStateException("already initalized");
        }
    }

    public  static  ThreadSafeDoubleCheckLockingSingleton getInstance(){
        ThreadSafeDoubleCheckLockingSingleton result = instance;
        if(null == result){
            synchronized (ThreadSafeDoubleCheckLockingSingleton.class){
                result = instance;
                if(null == result){
                    instance = result = new ThreadSafeDoubleCheckLockingSingleton();
                }
            }
        }
        return  result;
    }

}
