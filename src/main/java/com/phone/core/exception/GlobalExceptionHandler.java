package com.phone.core.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler{

	@ExceptionHandler(BusinessException.class)
	public ModelAndView handleBusinessException(HttpServletRequest request, Exception ex){
		log.error("Requested URL "+request.getRequestURL());
		log.error("Exception "+ex);
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("errorMessage",ex.getMessage());
	    modelAndView.setViewName("error");
	    return modelAndView;
	}	
		
}
