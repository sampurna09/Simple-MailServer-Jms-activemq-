package com.jms.listner;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	
	@JmsListener(destination ="standalone.queus")
	public void consume(String message) {
		System.out.println("Received Message: "+message);
	}
	

}
