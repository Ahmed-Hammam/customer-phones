package com.phone.core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CountryEnum {

	CAMEROON("Cameroon","237",""),
	ETHIOPIA("Ethiopia","251",""),
	MOROCCO("Morocco","212",""),
	MOZAMBIQUE("Mozambique","258",""),
	UGANDA("Uganda","256","");
	
	@Getter
	private String countryName;
	@Getter
	private String countryCode;
	@Getter
	private String phoneRegex;
	
	/*Cameroon | Country code: +237 | Regex = \(237\)\ ?[2368]\d{7,8}$
			Ethiopia | Country code: +251 | Regex = \(251\)\ ?[1-59]\d{8}$
			Morocco | Country code: +212 | Regex = \(212\)\ ?[5-9]\d{8}$
			Mozambique | Country code: +258 | Regex = \(258\)\ ?[28]\d{7,8}$
			Uganda | Country code: +256 | Regex = \(256\)\ ?\d{9}$*/
}
