package com.comenie.pattern.creational.abstractFactory;

/**
 * 
 * OrcArmy
 *
 */
public class OrcArmy implements Army {

	static final String DESCRIPTION = "This is the Orc Army!";

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}
