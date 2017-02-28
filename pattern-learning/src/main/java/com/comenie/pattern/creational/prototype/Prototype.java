package com.comenie.pattern.creational.prototype;

/**
 * 
 * Prototype
 *
 */
public abstract class Prototype implements Cloneable {

	@Override
	public abstract Object clone() throws CloneNotSupportedException;

}
