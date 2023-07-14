package com.boa.accountapi.vos;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Corporate {
	 private long customerId;
	    
	    private FullName name;
	   
	    private long contactNo;
	    
	    private String email;
	  
	    private String password;
	    private CompanyType companyType;
}
