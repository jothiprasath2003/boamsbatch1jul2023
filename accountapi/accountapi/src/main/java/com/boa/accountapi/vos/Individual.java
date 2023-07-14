package com.boa.accountapi.vos;

import java.time.LocalDate;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Individual {
	
    private long customerId;
    
    private FullName name;
   
    private long contactNo;
    
    private String email;
  
    private String password;
    
    private LocalDate dob;
    private Gender gender;
}
