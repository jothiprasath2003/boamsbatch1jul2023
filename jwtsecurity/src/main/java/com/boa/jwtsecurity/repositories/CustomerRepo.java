package com.boa.jwtsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boa.jwtsecurity.models.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Long>{

}
