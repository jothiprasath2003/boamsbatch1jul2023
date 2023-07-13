package com.boa.customerapi.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.customerapi.models.Individual;
import com.boa.customerapi.repositories.IndividualRepo;

@Service
public class IndividualService {
	
	@Autowired
	private IndividualRepo indRepo;
	@Autowired
	private EntityManager entityManager;
	
	//create
	
	public Individual addIndividual(Individual individual) {
		if(individual !=null) 		
  		 return this.indRepo.save(individual);
		else
			return null;
	}
	
	//retrieve
	public List<Individual> getAllIndividuals(){
		return this.indRepo.findAll();
	}
	
	public Individual getIndividualById(long customerId) {
		return this.indRepo.findById(customerId).orElse(null);
	}
	
	//non primary key
	public List<Individual> findAllByFirstName(String firstName){
    	CriteriaBuilder cb= entityManager.getCriteriaBuilder();
    	AbstractQuery<Individual> cq=cb.createQuery(Individual.class);
    	
    	Root<Individual> individualObject=cq.from(Individual.class);
    	cq.where(cb.equal(individualObject.get("name").<String> get("firstName") ,firstName));
    	
    	CriteriaQuery<Individual> selectResult=((CriteriaQuery<Individual>)cq).select(individualObject);
    	TypedQuery<Individual> tq=entityManager.createQuery(selectResult);
    	return tq.getResultList();
    }

	public List<Individual> getIndividualByContactNo(long contactNo) {
		return this.indRepo.findByContactNo(contactNo);
	}
	
	
	//update
	public Individual updateIndividualEmail(long customerId, String email) {
		 Individual individual=getIndividualById(customerId);
		 if(individual!=null) {
			individual.setEmail(email);
			this.indRepo.save(individual);
			return individual;
		 }
		 else
			 return null;
		 
	}
	
	//delete
	
	public  boolean deleteIndividualById(long customerId) {
		
		boolean status=false;
		if(getIndividualById(customerId)!=null) {
			this.indRepo.deleteById(customerId);
			status=true;
		}
		return status;
	}
	
}
