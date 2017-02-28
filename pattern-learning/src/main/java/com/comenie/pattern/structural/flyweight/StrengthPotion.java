package com.comenie.pattern.structural.flyweight;

/**
 * 
 * StrengthPotion
 *
 */
public class StrengthPotion implements Potion {

	@Override
	public void drink() {
		System.out.println("You feel strong. (Potion="
				+ System.identityHashCode(this) + ")");
	}
}
