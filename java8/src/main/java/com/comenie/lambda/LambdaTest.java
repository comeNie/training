package com.comenie.lambda;

/**
 * Created by zkp2p-apple on 17/4/6.
 */
public class LambdaTest {

    public static void main(String[] args) {
//        new Thread(() -> System.out.println("hello world")).start();
        testException();
    }

    public static void testException(){
        new Thread(() -> {
            int i = 0;
            i = 1 / i;
        }).start();
    }
}
