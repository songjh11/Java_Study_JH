package com.iu.spring.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class BackErrorController {
	//ExeptionHandler method만 모임
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView exceptionTest() {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("errors/error_404");
		return modelAndView; 
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionTest2(Exception e) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("errors/error_404");
		return modelAndView; 
	}

}
