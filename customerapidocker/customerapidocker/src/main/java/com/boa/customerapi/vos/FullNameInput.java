package com.boa.customerapi.vos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullNameInput {
	 
		private String firstName;
	    
		private String middleName;
	   
		private String lastName;
}