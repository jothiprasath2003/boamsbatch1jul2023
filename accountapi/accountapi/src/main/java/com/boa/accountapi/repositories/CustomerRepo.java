package com.boa.accountapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boa.accountapi.vos.Customer;

public interface CustomerRepo extends MongoRepository<Customer, Long>{

}
