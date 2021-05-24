package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.utils.Generator;

@Controller
public class HomeController {
	
	Generator gen;
	
	
		
	public HomeController(Generator gen) {
		this.gen = gen;
	}

	@GetMapping("/")
	public String home() {
		gen.generate(32);
		return "home";
	}
}