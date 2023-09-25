package com.jspiders.cardekho_case_study_mvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.cardekho_case_study_mvc.pojo.AdminPOJO;
import com.jspiders.cardekho_case_study_mvc.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService service ;
	
	//Create Account Page Controller
		@GetMapping("/createAccount") 
		public String createAccountPage(ModelMap map) {
		
			com.jspiders.cardekho_case_study_mvc.pojo.AdminPOJO pojo = service.getAdmin() ;
			if(pojo != null) {
				map.addAttribute("msg", "Account already exists...!!!");
				return "Login";
			}
			return "CreateAccount";
		}
		
		//Create Account Controller
		@PostMapping("/createAccount")
		public String createAccount(@RequestParam String username, @RequestParam String password, ModelMap map) {
			
			AdminPOJO pojo = service.createAccount(username,password) ;
			if(pojo !=null) {
				map.addAttribute("msg", "Account created Successfully...!!") ;
				return "Login" ;
				
			}
			map.addAttribute("msg", "Account not created...!!") ;
			return "Login";
		}
		
		// Login Controller 
		@PostMapping("/login")
		public String login(@RequestParam String username, @RequestParam String password, ModelMap map,
							HttpSession session) {
			
			AdminPOJO pojo = service.login(username,password) ;
			if(pojo != null) {
				session.setAttribute("login", pojo);
				session.setMaxInactiveInterval(60) ;
				return "Home" ;
			}
			map.addAttribute("msg", "Invalid Username or Password") ;
			return "Login" ;
		}
		// Logout Controller
			@GetMapping("/logout")
			public String logout(ModelMap map, HttpSession session) {
				map.addAttribute("msg", "Logged out Successfully...!!") ;
				session.invalidate() ;
				return "Login";
			}


}
