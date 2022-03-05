package com.phone.core.service;

import java.util.List;

import com.phone.core.dto.CustomerDto;
import com.phone.core.entity.CustomerEntity;

public interface CustomerService {

	public List<CustomerDto> getCustomers(int pageNo, int pageSize, String code, String name, String phone);
	public List<CustomerEntity> getAllCustomers();
	public List<CustomerEntity> getAllCustomersForCountry(String countryCode);
}
