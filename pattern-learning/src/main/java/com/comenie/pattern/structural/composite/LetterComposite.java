package com.comenie.pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * composite interface
 * Created by 波 on 2017/2/4.
 */
public abstract class LetterComposite {

    private List<LetterComposite> children = new ArrayList<LetterComposite>();

    public void add(LetterComposite letterComposite){
        this.children.add(letterComposite);
    }

    public  int count(){
        return  this.children.size();
    }

    protected abstract void printThisBefore();

    protected abstract void printThisAfter();

    public void print() {
        printThisBefore();
        for (LetterComposite letter : children) {
            letter.print();
        }
        printThisAfter();
    }


}
