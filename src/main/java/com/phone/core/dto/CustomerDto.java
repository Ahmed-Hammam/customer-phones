package com.phone.core.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDto {

	private String customerName;
	private String country;
	private String countryCode;
	private String phone;
}
