package com.boa.resilience4jdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class ResilienceService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${serviceUrl}")
    private String serviceUrl;
	@Value("${alternativeServiceUrl}")
	private String alternativeUrl;
	
	@CircuitBreaker(name = "gatewayCircuitBreaker", fallbackMethod = "getFallbackResponse")
    @Retry(name = "gatewayRetry")
	public String getResponse() {
		return restTemplate.getForObject(serviceUrl, String.class);
	}
	
	
	public String getFallbackResponse(Exception e)  {
		return restTemplate.getForObject(alternativeUrl, String.class);
	}
	
}
