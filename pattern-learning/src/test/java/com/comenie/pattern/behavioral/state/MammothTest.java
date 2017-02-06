package com.comenie.pattern.behavioral.state;

import org.junit.Test;

/**
 * Created by 波 on 2017/2/6.
 */
public class MammothTest {
    @Test
    public void testState() {
        Mammoth mammoth = new Mammoth();
        mammoth.observe();
        mammoth.timePasses();
        mammoth.observe();
        mammoth.timePasses();
        mammoth.observe();
    }
}