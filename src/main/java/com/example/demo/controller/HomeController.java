package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.player.Player;
import com.example.demo.service.PlayerService;
import com.example.demo.utils.Generator;

@Controller
public class HomeController {
	
	private Generator gen;
	private PlayerService playerService;
	
			
	public HomeController(Generator gen, PlayerService playerService) {
		this.gen = gen;
		this.playerService = playerService;
	}

	@GetMapping("/")
	public String home() {
		List<Player> thePlayers = playerService.findAll();
		if (thePlayers.size() == 0) {
			gen.generate(32);
		}
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("error", true);
		return "login";
	}
}