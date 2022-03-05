package com.phone.core.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.phone.core.service.CustomerService;

@Controller
public class CustomerController {

	List<String> countries;
	
	@Autowired
	private CustomerService customerService;

	@ModelAttribute
	 public void preLoad(Model model){
		countries = Arrays.asList("Cameroon","Ethiopia","Morocco","Mozambique","Uganda");
	 }
	
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("countries", countries);
		model.addAttribute("customers", customerService.getCustomers(0, 0, null, null, null));
		return "customers"; // view
	}

	@GetMapping("/search")
	public String mainWithParam(String country, String code, String phone, Model model) {
		model.addAttribute("countries", countries);
		model.addAttribute("customers", customerService.getCustomers(0, 0, code, country, phone));
		return "customers"; // view
	}

}
