package com.springapp.mvc.Controller;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springapp.mvc.model.UserForm;

@Controller
public class RegisterationController {
   
@RequestMapping(value = "/reg", method = RequestMethod.GET) 
	 public String showRegistrationPage(final ModelMap model) {
	     final UserForm account = new UserForm(); 
	     model.addAttribute("user", account); 
	     return "registration"; 
	 }
}