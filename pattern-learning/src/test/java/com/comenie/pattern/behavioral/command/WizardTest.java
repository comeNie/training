package com.comenie.pattern.behavioral.command;

import org.junit.Test;

/**
 * Created by 波 on 2017/2/6.
 */
public class WizardTest {

    @Test
    public void testCommand() {
        Wizard wizard = new Wizard();
        Goblin goblin = new Goblin();

        goblin.printStatus();

        wizard.castSpell(new ShrinkSpell(), goblin);
        goblin.printStatus();

        wizard.castSpell(new InvisibilitySpell(), goblin);
        goblin.printStatus();

        wizard.undoLastSpell();
        goblin.printStatus();

        wizard.undoLastSpell();
        goblin.printStatus();

        wizard.redoLastSpell();
        goblin.printStatus();

        wizard.redoLastSpell();
        goblin.printStatus();
    }

}