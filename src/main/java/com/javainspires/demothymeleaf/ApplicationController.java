package com.javainspires.demothymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javainspires.demothymeleaf.form.LoginForm;

@Controller
public class ApplicationController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLoginForm(){
		return "login";
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute(name="loginForm") LoginForm loginForm, Model model) 
	{
		
		String username=loginForm.getUsername();
		String password=loginForm.getPassword();
		
		if("fresherpro".equals(username) && "fresherpro".equals(password)) 
		{
			
			return "home";
		}
		
		model.addAttribute("invalidCredentials", true);
		
		return "login";
	}
}
