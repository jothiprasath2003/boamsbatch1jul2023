package com.boa.accountapi.vos;


import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customers")
public class Customer {
	
    @BsonId
    private long customerId;
    
    private FullName name;
   
    private long contactNo;
   
    private String email;
  
    private String password;
    
    

}
