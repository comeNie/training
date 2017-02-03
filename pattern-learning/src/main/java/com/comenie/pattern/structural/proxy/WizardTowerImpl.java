package com.comenie.pattern.structural.proxy;

/**
 * 
 * The object to be proxyed.
 * 
 */
public class WizardTowerImpl implements WizardTower {

	public void enter(Wizard wizard) {
		System.out.println(wizard + " enters the tower.");
	}

}
