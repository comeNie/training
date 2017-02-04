package com.comenie.pattern.structural.composite;

import org.junit.Test;

/**
 * Created by 波 on 2017/2/4.
 */
public class LetterCompositeTest {
    @Test
    public void testComposite() {
        System.out.println("Message from the orcs: ");

        LetterComposite orcMessage = new Messenger().messageFromOrcs();
        orcMessage.print();

        System.out.println("\n");

        System.out.println("Message from the elves: ");

        LetterComposite elfMessage = new Messenger().messageFromElves();
        elfMessage.print();
    }

}