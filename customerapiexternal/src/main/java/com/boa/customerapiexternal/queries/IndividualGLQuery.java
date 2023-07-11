package com.boa.customerapiexternal.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boa.customerapiexternal.models.Individual;
import com.boa.customerapiexternal.services.IndividualService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class IndividualGLQuery implements GraphQLQueryResolver {
	
	@Autowired
	private IndividualService individualService;
	
	public List<Individual> getAllIndividuals(){
		
		return this.individualService.getAllIndividuals();
	}
			
			
			
	public Individual getIndividualById(long customerId) {
		
		return this.individualService.getIndividualById(customerId);
	}
			
	public List<Individual >getIndividualByFirstName(String firstName){
		
		return this.individualService.findAllByFirstName(firstName);
	}

}
