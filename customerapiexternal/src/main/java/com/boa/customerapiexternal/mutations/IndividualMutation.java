package com.boa.customerapiexternal.mutations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boa.customerapiexternal.models.FullName;
import com.boa.customerapiexternal.models.Individual;
import com.boa.customerapiexternal.services.IndividualService;
import com.boa.customerapiexternal.vos.IndividualInput;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class IndividualMutation implements GraphQLMutationResolver{
	@Autowired
	private IndividualService individualService;
	
	public Individual addIndividual(IndividualInput individualInput) {
		
		Individual individual=Individual.builder()
				.customerId(individualInput.getCustomerId())
				.contactNo(individualInput.getContactNo())
				.dob(individualInput.getDob())
				.name(FullName.builder()
						.firstName(individualInput.getName().getFirstName())
						.lastName(individualInput.getName().getLastName())
						.middleName(individualInput.getName().getMiddleName()).build()
						
						)
				.email(individualInput.getEmail())
				.password(individualInput.getPassword())
				.gender(individualInput.getGender())
				.build();
				
		
		return this.individualService.addIndividual(individual);
		
		
	}
	
	  public Individual updateIndividual(long customerId,String email) {
	  
		  return this.individualService.updateIndividualEmail(customerId, email);
	  }
	  
	  public boolean deleteIndividual(long customerId){
	  
		  return this.individualService.deleteIndividualById(customerId);
	  }
	 

}