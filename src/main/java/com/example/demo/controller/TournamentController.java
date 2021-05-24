package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.player.Player;
import com.example.demo.service.PlayerService;
import com.example.demo.tournament.TournamentPlay;

@Controller
@RequestMapping("/tournament")
public class TournamentController {
	private PlayerService playerService;
	
	public TournamentController(PlayerService playerService) {
		super();
		this.playerService = playerService;
	}



	@GetMapping("/play")
	public String playTournament(Model theModel) {
		
		// get players from db
		List<Player> thePlayers = playerService.findAll();
		
		TournamentPlay.play(thePlayers);
		thePlayers.stream().forEach(p -> {
			playerService.save(p);
		});
		
		return "redirect:/players/list";
	}
	
}
