package com.boa.customerapiexternal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boa.customerapiexternal.models.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Long>{

}
