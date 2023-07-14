package com.boa.accountapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.boa.accountapi.facades.CustomerFacade;
import com.boa.accountapi.repositories.CustomerRepo;
import com.boa.accountapi.vos.Customer;

@Service
public class CustomerConsumerService {
	
	@Autowired
	private CustomerRepo customerRepo;



    @StreamListener(target = CustomerFacade.inChannelName)

	public void consumeData(@Payload Customer customer) {
		
    	this.customerRepo.save(customer);
    	
	}

}
