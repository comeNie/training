package com.comenie.pattern.behavioral.visitor;

import org.junit.Test;

/**
 * Created by 波 on 2017/2/6.
 */
public class CommanderTest {
    @Test
    public void testVisitor() {
        Commander commander = new Commander(new Sergeant(new Soldier(),
                new Soldier(), new Soldier()), new Sergeant(new Soldier(),
                new Soldier(), new Soldier()));
        commander.accept(new SoldierVisitor());
        commander.accept(new SergeantVisitor());
        commander.accept(new CommanderVisitor());

    }
}