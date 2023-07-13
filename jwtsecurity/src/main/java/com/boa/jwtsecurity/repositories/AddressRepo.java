package com.boa.jwtsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boa.jwtsecurity.models.Address;


public interface AddressRepo extends JpaRepository<Address,Long>{

}
