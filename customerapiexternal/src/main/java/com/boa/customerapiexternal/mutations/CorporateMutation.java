package com.boa.customerapiexternal.mutations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boa.customerapiexternal.models.Corporate;
import com.boa.customerapiexternal.models.FullName;
import com.boa.customerapiexternal.services.CorporateService;
import com.boa.customerapiexternal.vos.CorporateInput;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class CorporateMutation implements GraphQLMutationResolver{
	@Autowired
	private CorporateService corporateService;
	
	public Corporate addCorporate(CorporateInput corporateInput) {
		
		Corporate corporate=Corporate.builder()
				.customerId(corporateInput.getCustomerId())
				.contactNo(corporateInput.getContactNo())
				
				.name(FullName.builder()
						.firstName(corporateInput.getName().getFirstName())
						.lastName(corporateInput.getName().getLastName())
						.middleName(corporateInput.getName().getMiddleName()).build()
						
						)
				.email(corporateInput.getEmail())
				.password(corporateInput.getPassword())
				.companyType(corporateInput.getCompanyType())
				.build();
				
		
		return this.corporateService.addCorporate(corporate);
		
		
	}
	
	  public Corporate updateCorporate(long customerId,String email) {
	  
		  return this.corporateService.updateCorporateEmail(customerId, email);
	  }
	  
	  public boolean deleteCorporate(long customerId){
	  
		  return this.corporateService.deleteCorporateById(customerId);
	  }
	 

}