package com.boa.customerapiexternal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boa.customerapiexternal.models.Address;


public interface AddressRepo extends JpaRepository<Address,Long>{

}
