package com.phone.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.phone.core.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> , PagingAndSortingRepository<CustomerEntity,Integer>{

	List<CustomerEntity> findByPhoneStartsWith(String countryCode); 
	
	List<CustomerEntity> findByPhoneContains(String phone);
	
}
