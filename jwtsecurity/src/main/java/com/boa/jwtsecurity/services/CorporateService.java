package com.boa.jwtsecurity.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.jwtsecurity.models.Corporate;
import com.boa.jwtsecurity.repositories.CorporateRepo;

@Service
public class CorporateService {
	
	@Autowired
	private CorporateRepo corporateRepo;
	@Autowired
	private EntityManager entityManager;
	
	//create
	
	public Corporate addCorporate(Corporate Corporate) {
		if(Corporate !=null) 		
  		 return this.corporateRepo.save(Corporate);
		else
			return null;
	}
	
	//retrieve
	public List<Corporate> getAllCorporates(){
		return this.corporateRepo.findAll();
	}
	
	public Corporate getCorporateById(long customerId) {
		return this.corporateRepo.findById(customerId).orElse(null);
	}
	
	//non primary key
	public List<Corporate> findAllByFirstName(String firstName){
    	CriteriaBuilder cb= entityManager.getCriteriaBuilder();
    	AbstractQuery<Corporate> cq=cb.createQuery(Corporate.class);
    	
    	Root<Corporate> CorporateObject=cq.from(Corporate.class);
    	cq.where(cb.equal(CorporateObject.get("name").<String> get("firstName") ,firstName));
    	
    	CriteriaQuery<Corporate> selectResult=((CriteriaQuery<Corporate>)cq).select(CorporateObject);
    	TypedQuery<Corporate> tq=entityManager.createQuery(selectResult);
    	return tq.getResultList();
    }

	public List<Corporate> getCorporateByContactNo(long contactNo) {
		return this.corporateRepo.findByContactNo(contactNo);
	}
	
	
	//update
	public Corporate updateCorporateEmail(long customerId, String email) {
		 Corporate Corporate=getCorporateById(customerId);
		 if(Corporate!=null) {
			Corporate.setEmail(email);
			this.corporateRepo.save(Corporate);
			return Corporate;
		 }
		 else
			 return null;
		 
	}
	
	//delete
	
	public  boolean deleteCorporateById(long customerId) {
		
		boolean status=false;
		if(getCorporateById(customerId)!=null) {
			this.corporateRepo.deleteById(customerId);
			status=true;
		}
		return status;
	}
	
}
