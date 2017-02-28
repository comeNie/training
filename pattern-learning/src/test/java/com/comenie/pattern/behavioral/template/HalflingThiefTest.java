package com.comenie.pattern.behavioral.template;

import org.junit.Test;

/**
 * Created by 波 on 2017/2/6.
 */
public class HalflingThiefTest {
    @Test
    public void testTemplate() {
        HalflingThief thief = new HalflingThief(new HitAndRunMethod());
        thief.steal();
        thief.changeMethod(new SubtleMethod());
        thief.steal();
    }
}