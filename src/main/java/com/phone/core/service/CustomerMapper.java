package com.phone.core.service;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.phone.core.dto.CustomerDto;
import com.phone.core.entity.CountryConfiguration;
import com.phone.core.entity.CustomerEntity;

@Component
public class CustomerMapper implements Function<CustomerEntity,CustomerDto>{

	@Autowired
	private CountryConfiguration countryConfiguration;
	
	@Override
	public CustomerDto apply(CustomerEntity t) {
		return CustomerDto.builder()
				.customerName(t.getName())
				.countryCode(t.getPhone().substring(1, 4))
				.country(countryConfiguration.getCode().get(t.getPhone().subSequence(1, 4)))
				.phone(t.getPhone().substring(5, t.getPhone().length()))
				.build();
	}

}
