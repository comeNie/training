package com.comenie.pattern.behavioral.template;

/**
 * 
 * StealingMethod defines skeleton for the algorithm.  abstract Template method.
 * 
 */
public abstract class StealingMethod {

	protected abstract String pickTarget();

	protected abstract void confuseTarget(String target);

	protected abstract void stealTheItem(String target);

	public void steal() {
		String target = pickTarget();
		System.out.println("The target has been chosen as " + target + ".");
		confuseTarget(target);
		stealTheItem(target);
	}
}
