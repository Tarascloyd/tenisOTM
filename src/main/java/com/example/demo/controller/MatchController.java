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
import com.example.demo.service.PlayersAbilityService;
import com.example.demo.service.PlayersStatService;

@Controller
@RequestMapping("/match")
public class MatchController {
	private PlayerService playerService;
	private MatchPlay matchPlay;
	
	public MatchController(PlayerService playerService, MatchPlay matchPlay) {
		super();
		this.playerService = playerService;
		this.matchPlay = matchPlay;
	}



	@GetMapping("/play")
	public String playMatch(Model theModel) {
		
		// get players from db
		List<Player> thePlayers = playerService.findAll();
		int[] pair = MatchPlay.getRandomPlayers(thePlayers.size());
		Match theMatch = new Match();
		theMatch.setCourt((int)(Math.random()*4));
		theMatch.setPlay1(thePlayers.get(pair[0]));
		theMatch.setPlay2(thePlayers.get(pair[1]));
		theMatch.setP1(0);
		theMatch.setP2(0);
		matchPlay.startMatch(theMatch);
		playerService.save(theMatch.getPlay1());
		playerService.save(theMatch.getPlay2());
		// add to the spring model
		theModel.addAttribute("match", theMatch);
		
		return "match/play";
	}
	
}
