package com.comenie.pattern.creational.abstractFactory;

/**
 * 
 * KingdomFactory factory interface.
 * 
 */
public interface KingdomFactory {

	Castle createCastle();

	King createKing();

	Army createArmy();

}
