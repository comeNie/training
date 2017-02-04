package com.comenie.pattern.creational.builder;

/**
 * 
 * Weapon enumeration
 *
 */
public enum Weapon {

	DAGGER, SWORD, AXE, WARHAMMER, BOW;

	@Override
	public String toString() {
		return name().toLowerCase();
	}

}
