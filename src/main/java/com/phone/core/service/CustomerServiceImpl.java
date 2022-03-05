package com.phone.core.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.phone.core.dto.CustomerDto;
import com.phone.core.entity.CountryConfiguration;
import com.phone.core.entity.CustomerEntity;
import com.phone.core.exception.BusinessException;
import com.phone.core.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Autowired
	private CountryConfiguration countryConfiguration;
	
	@Override
	public List<CustomerEntity> getAllCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public List<CustomerEntity> getAllCustomersForCountry(String countryCode) {
		return customerRepo.findByPhoneStartsWith(countryCode);
	}

	@Override
	public List<CustomerDto> getCustomers(int pageNo, int pageSize, String code, String name, String phone) {
		// All customers case
		if(!StringUtils.hasText(code) && !StringUtils.hasText(name) && !StringUtils.hasText(phone))
			return getAllCustomers().stream().map(e -> customerMapper.apply(e)).collect(Collectors.toList());
		
		// Country code filter case
		if(StringUtils.hasText(code) && !StringUtils.hasText(name) && !StringUtils.hasText(phone)) {
			List<CustomerEntity> customers = this.getAllCustomersForCountry("("+code+")");
			if(customers.isEmpty())
				throw new BusinessException("No customers available for the following code");
			return customers.stream().map(e -> customerMapper.apply(e)).collect(Collectors.toList());
		}
		
		// Country name filter case
		if(!StringUtils.hasText(code) && StringUtils.hasText(name) && !StringUtils.hasText(phone)) {
			String countryCode = countryConfiguration.getCountry().get(name);
			if(Objects.isNull(countryCode))
				throw new BusinessException("No customers available for the selected country");
			return this.getAllCustomersForCountry("("+countryConfiguration.getCountry().get(name)+")")
					.stream().map(e -> customerMapper.apply(e)).collect(Collectors.toList());
		}
		
		// phone no filter case
		if(!StringUtils.hasText(code) && !StringUtils.hasText(name) && StringUtils.hasText(phone)) {
			List<CustomerEntity> customers = customerRepo.findByPhoneContains(phone);
			if(customers.isEmpty())
				throw new BusinessException("No customers available with the following phone");
			List<CustomerDto> dtos = customers.stream().map(e -> customerMapper.apply(e)).collect(Collectors.toList());
			dtos = dtos.stream().filter(c -> !c.getCountryCode().contains(phone)).collect(Collectors.toList());
			return dtos;
		}
		
		// Country code & phone filter case
		if(StringUtils.hasText(code) && !StringUtils.hasText(name) && StringUtils.hasText(phone)) {
			List<CustomerEntity> customers = this.getAllCustomersForCountry("("+code+")");
			if(customers.isEmpty())
				throw new BusinessException("No customers available with the following country code & phone");
			List<CustomerDto> dtos = customers.stream().map(e -> customerMapper.apply(e)).collect(Collectors.toList());
			dtos = dtos.stream().filter(c -> c.getPhone().contains(phone)).collect(Collectors.toList());
			return dtos;
		}
		
		// Country name & phone filter case
		if(!StringUtils.hasText(code) && StringUtils.hasText(name) && StringUtils.hasText(phone)) {
			String countryCode = countryConfiguration.getCountry().get(name);
			if(Objects.isNull(countryCode))
				throw new BusinessException("No customers available for the selected country & phone");
			List<CustomerDto> dtos = this.getAllCustomersForCountry("("+countryConfiguration.getCountry().get(name)+")")
					.stream().map(e -> customerMapper.apply(e)).collect(Collectors.toList());
			dtos = dtos.stream().filter(c -> c.getPhone().contains(phone)).collect(Collectors.toList());
			return dtos;
		}
		return getAllCustomers().stream().map(e -> customerMapper.apply(e)).collect(Collectors.toList());
	}

}
