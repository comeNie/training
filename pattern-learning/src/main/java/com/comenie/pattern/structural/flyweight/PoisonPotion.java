package com.comenie.pattern.structural.flyweight;

/**
 * 
 * PoisonPotion
 *
 */
public class PoisonPotion implements Potion {

	public void drink() {
		System.out.println("Urgh! This is poisonous. (Potion="
				+ System.identityHashCode(this) + ")");
	}

}
