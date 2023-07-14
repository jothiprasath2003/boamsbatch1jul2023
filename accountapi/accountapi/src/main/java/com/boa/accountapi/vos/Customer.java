package com.boa.accountapi.vos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;



public class Customer {
	
    
    private long customerId;
    
    private FullName name;
   
    private long contactNo;
   
    private String email;
  
    private String password;
    
    

}
