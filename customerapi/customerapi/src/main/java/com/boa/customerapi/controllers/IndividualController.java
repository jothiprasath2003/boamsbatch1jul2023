package com.boa.customerapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boa.customerapi.models.Individual;
import com.boa.customerapi.services.CustomerPublisher;
import com.boa.customerapi.services.IndividualService;
import com.boa.customerapi.vos.ResponseWrapper;

@RestController
@RequestMapping("/individuals")
public class IndividualController {
	
	@Autowired
	private IndividualService individualService;
	@Autowired
	private CustomerPublisher customerPublisher;
	//add the individual
	
	@SuppressWarnings("rawtypes")
	@PostMapping({"/v1.0/"})
    @CrossOrigin("*")
	public ResponseEntity<ResponseWrapper> addIndividual(@RequestBody Individual individual){
	
		Individual object=this.individualService.addIndividual(individual);
		if(object !=null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<Individual>(object));
			
		}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Customer "
					+ "not created"));
			
		
	}
	
	@GetMapping({"/v1.0/"})
	@CrossOrigin("*")
	public List<Individual> getAllIndividuals(){
	
	   return this.individualService.getAllIndividuals();
		
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping({"/v1.0/{customerId}"})
	@CrossOrigin("*")
	public ResponseEntity<ResponseWrapper>getIndividualById(@PathVariable("customerId") long customerId){
	
		Individual object=this.individualService.getIndividualById(customerId);
		if(object !=null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseWrapper<Individual>(object));
			
		}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Customer "
					+ "not found"));
		
	}
	@SuppressWarnings("rawtypes")
	@GetMapping({"/v1.0/contactno/{contactNo}"})
	@CrossOrigin("*")
	public ResponseEntity<ResponseWrapper>getIndividualByContactNo(@PathVariable("contactNo") long contactNo){
	
		List<Individual> individuals=this.individualService.getIndividualByContactNo(contactNo);
		if(individuals.size()>0) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseWrapper(individuals));
			
		}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Customer "
					+ "not found"));
		
	}
	@SuppressWarnings("rawtypes")
	@GetMapping({"/v1.0/firstname/{firstName}"})
	@CrossOrigin("*")
	public ResponseEntity<ResponseWrapper>getIndividualByfirstName(@PathVariable("firstName") String firstName){
	
		List<Individual> individuals=this.individualService.findAllByFirstName(firstName);
		if(individuals.size()>0) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseWrapper(individuals));
			
		}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Customer "
					+ "not found"));
		
	}
	
	
	@SuppressWarnings("rawtypes")
	@PutMapping({"/v1.0/{customerId}"})
	@CrossOrigin("*")
	public ResponseEntity<ResponseWrapper>updateIndividual(@PathVariable("customerId") long cutsomerId, @RequestParam("email") String email){
	
		Individual individual=this.individualService.updateIndividualEmail(cutsomerId, email);
		if(individual!=null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseWrapper(individual));
			
		}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Customer "
					+ "not updated"));
		
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping({"/v1.0/{customerId}"})
	@CrossOrigin("*")
	public ResponseEntity<ResponseWrapper>deleteIndividual(@PathVariable("customerId") long cutsomerId){
	
	
		if(this.individualService.deleteIndividualById(cutsomerId)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseWrapper("Customer Deleted"));
			
		}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Customer "
					+ "not deleted"));
		
	}
	
	
	@SuppressWarnings("rawtypes")
	@GetMapping({"/v1.0/publish/{customerId}"})
	@CrossOrigin("*")
	public ResponseEntity<ResponseWrapper>getIndividualByIdandPublish(@PathVariable("customerId") long customerId){
	
		Individual object=this.individualService.getIndividualById(customerId);
	
		
		if(	this.customerPublisher.publishCustomerData(object)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body(new ResponseWrapper("Message Published"));
			
		}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Message "
					+ "not published"));
		
	}
}