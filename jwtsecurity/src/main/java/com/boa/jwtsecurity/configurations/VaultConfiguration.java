package com.boa.jwtsecurity.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ConfigurationProperties
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaultConfiguration {

	private String username;
	private String password;
	private String key;
}
