package com.kodnest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

	@GetMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(value="/registration")
	public String registration() {
		return "registration";
		
	}
	
	@GetMapping(value="/addsong")
	public String song() {
		return "song";
		
	}
}
