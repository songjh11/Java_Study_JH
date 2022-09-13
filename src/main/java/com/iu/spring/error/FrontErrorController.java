package com.iu.spring.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error/*")
public class FrontErrorController {

	@GetMapping("error400")
	public ModelAndView error400() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("errors/error_404");
		return modelAndView;
	}
	
	@GetMapping("error500")
	public ModelAndView error500() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("server Exception 발생");
		modelAndView.setViewName("errors/error_404");
		return modelAndView;
	}
	
}
