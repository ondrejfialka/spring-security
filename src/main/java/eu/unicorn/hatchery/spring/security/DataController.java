package eu.unicorn.hatchery.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import eu.unicorn.hatchery.spring.security.secret.SecretService;

@Controller
public class DataController {
	
	@Autowired
	SecretService secretService;
	
	
	@RequestMapping(value="/publicData")
	public ModelAndView getPublicData() {
		
		System.out.println(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().isUserInRole("USER"));
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("public");
		modelAndView.getModelMap().addAttribute("data", secretService.getPublicData());
		 
		return modelAndView;
	}
	
	@RequestMapping(value="/adminData")
	public ModelAndView getSecretData() {
		
		System.out.println(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().isUserInRole("USER"));
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin");
		modelAndView.getModelMap().addAttribute("data", secretService.getSecretData());
		 
		return modelAndView;
	}

}
