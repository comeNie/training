package com.comenie.pattern.other.poisonPill;

/**
 * Endpoint to retrieve {@link Message} from queue
 */
public interface MQSubscribePoint {

	public Message take() throws InterruptedException;
}
