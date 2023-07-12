package com.boa.customerapiexternal.vos;

import lombok.Data;


@Data
public class ResponseWrapper<T> {
	
	private T payload;
	private String message;
	
	public ResponseWrapper(T payload) {
		this.payload=payload;
	}
	
	public ResponseWrapper(String message) {
		this.message=message;
	}

}