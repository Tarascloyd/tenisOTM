package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.match.Match;
import com.example.demo.match.MatchPlay;
import com.example.demo.player.Player;
import com.example.demo.service.PlayerService;

@Controller
@RequestMapping("/match")
public class MatchController {
	private PlayerService playerService;
	
	public MatchController(PlayerService playerService) {
		super();
		this.playerService = playerService;
	}



	@GetMapping("/play")
	public String playMatch(Model theModel) {
		
		// get players from db
		List<Player> thePlayers = playerService.findAll();
		// play mathces and get it from MatchPlay
		List<Match> theMatches = MatchPlay.playRandomMatches(thePlayers);
		theMatches.stream().forEach(m -> {
			playerService.save(m.getPlay1());
			playerService.save(m.getPlay2());
		});
	
		// add to the spring model
		theModel.addAttribute("matches", theMatches);
		
		return "match/play";
	}
	
}
