package com.comenie.pattern.behavioral.strategy;

/**
 * 
 * DragonSlayer uses different strategies to slay the dragon.
 *
 * strategy context
 * 
 */
public class DragonSlayer {

	private DragonSlayingStrategy strategy;

	public DragonSlayer(DragonSlayingStrategy strategy) {
		this.strategy = strategy;
	}

	public void changeStrategy(DragonSlayingStrategy strategy) {
		this.strategy = strategy;
	}

	public void goToBattle() {
		strategy.execute();
	}
}
