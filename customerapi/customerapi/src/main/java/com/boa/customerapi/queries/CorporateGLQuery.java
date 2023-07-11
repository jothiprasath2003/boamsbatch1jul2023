package com.boa.customerapi.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boa.customerapi.models.Corporate;
import com.boa.customerapi.services.CorporateService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class CorporateGLQuery implements GraphQLQueryResolver{
	@Autowired
	private CorporateService corporateService;
	
	public List<Corporate> getAllCorporates(){
		
		return this.corporateService.getAllCorporates();
	}
			
			
			
	public Corporate getCorporateById(long customerId) {
		
		return this.corporateService.getCorporateById(customerId);
	}
			
	public List<Corporate >getCorporateByFirstName(String firstName){
		
		return this.corporateService.findAllByFirstName(firstName);
	}
}
