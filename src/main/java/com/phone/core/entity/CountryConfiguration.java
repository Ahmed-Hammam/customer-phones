package com.phone.core.entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("")
public class CountryConfiguration {

	private Map<String, String> country = new HashMap<>();
	private Map<String, String> code = new HashMap<>();

	public Map<String, String> getCountry() {
		return country;
	}

	public Map<String, String> getCode() {
		return code;
	}
	
}
