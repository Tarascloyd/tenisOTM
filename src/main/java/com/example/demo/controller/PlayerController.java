package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.player.Player;
import com.example.demo.service.PlayerService;

@Controller
@RequestMapping("/players")
public class PlayerController {
	
	private PlayerService playerService;
	
	public PlayerController(PlayerService thePlayerService) {
		playerService = thePlayerService;
	}
	
	@GetMapping("/list")
	public String listPlayers(Model theModel) {
		
		// get players from db
		List<Player> thePlayers = playerService.findAll();
		
		// add to the spring model
		theModel.addAttribute("players", thePlayers);
		
		return "players/list-players";
	}
		
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("player", new Player());
		return "players/add";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("playerId") int theId,
									Model theModel) {
		
		// get the player from the service
		Player thePlayer = playerService.findById(theId);
		
		// set player as a model attribute to pre-populate the form
		theModel.addAttribute("player", thePlayer);
		
		// send over to our form
		return "players/add";			
	}
	
	@PostMapping("/save")
	public String savePlayer(
			@ModelAttribute("player") @Valid Player thePlayer,
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "players/add";
		}
		else {		
			// save the player
			playerService.save(thePlayer);
			
			// use a redirect to prevent duplicate submissions
			return "redirect:/players/list";
		}
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("playerId") int theId) {
		
		// delete the player
		playerService.deleteById(theId);
		
		// redirect to /players/list
		return "redirect:/players/list";
		
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("name") String theName, Model theModel) {
		
		// check name, if empty then just give list of all players

		if (theName.trim().isEmpty()) {
			return "redirect:/players/list";
		}
		else {
			// else, search by name
			List<Player> thePlayers =
					playerService.searchBy(theName);
			
			// add to the spring model
			theModel.addAttribute("players", thePlayers);
			
			// send to list-employees
			return "players/list-players";
		}
		
	}
}