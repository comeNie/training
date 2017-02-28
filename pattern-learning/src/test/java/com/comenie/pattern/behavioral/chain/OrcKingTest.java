package com.comenie.pattern.behavioral.chain;

import org.junit.Test;

/**
 * Created by 波 on 2017/2/6.
 */
public class OrcKingTest {

    @Test
    public void testChain() {
        OrcKing king = new OrcKing();
        king.makeRequest(new Request(RequestType.DEFEND_CASTLE, "defend castle"));
        king.makeRequest(new Request(RequestType.TORTURE_PRISONER,
                "torture prisoner"));
        king.makeRequest(new Request(RequestType.COLLECT_TAX, "collect tax"));
    }

}