package com.boa.customerapiexternal.vos;

import java.time.LocalDate;

import com.boa.customerapiexternal.models.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualInput {
	
    private long customerId;
    
    private FullNameInput name;
   
    private long contactNo;
    
    private String email;
  
    private String password;
    
    private LocalDate dob;
    private Gender gender;
}