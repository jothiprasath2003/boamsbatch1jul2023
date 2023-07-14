package com.boa.accountapi.facades;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface CustomerFacade {
	String inChannelName="customer-in";
	
	@Input(inChannelName)
	MessageChannel inChannel();

}
