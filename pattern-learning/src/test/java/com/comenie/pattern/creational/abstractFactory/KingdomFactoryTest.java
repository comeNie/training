package com.comenie.pattern.creational.abstractFactory;

/**
 * Created by 波 on 2017/2/4.
 */
public class KingdomFactoryTest {

    private King king;
    private Castle castle;
    private Army army;

    /**
     * Creates kingdom
     * @param factory
     */
    public void createKingdom(final KingdomFactory factory) {
        setKing(factory.createKing());
        setCastle(factory.createCastle());
        setArmy(factory.createArmy());
    }

    ElfKingdomFactory getElfKingdomFactory() {
        return new ElfKingdomFactory();
    }

    OrcKingdomFactory getOrcKingdomFactory() {
        return new OrcKingdomFactory();
    }

    King getKing(final KingdomFactory factory) {
        return factory.createKing();
    }

    Castle getCastle(final KingdomFactory factory) {
        return factory.createCastle();
    }

    Army getArmy(final KingdomFactory factory) {
        return factory.createArmy();
    }

    public King getKing() {
        return king;
    }

    private void setKing(final King king) {
        this.king = king;
    }

    public Castle getCastle() {
        return castle;
    }

    private void setCastle(final Castle castle) {
        this.castle = castle;
    }

    public Army getArmy() {
        return army;
    }

    private void setArmy(final Army army) {
        this.army = army;
    }
}