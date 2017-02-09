package com.comenie.pattern.other.businessDelegate;

/**
 * 
 * Service JMS implementation
 *
 */
public class JmsService implements BusinessService {

	@Override
	public void doProcessing() {
		System.out.println("JmsService is now processing");
	}
}
