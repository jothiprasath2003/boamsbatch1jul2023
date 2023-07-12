package com.boa.resilience4jdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.resilience4jdemo.services.ResilienceService;

@RestController
public class ResilienceController {
	@Autowired
	private ResilienceService resilienceService;
	@GetMapping("/")
	public String getResilienceResponse() {
		return this.resilienceService.getResponse();
	}

}
