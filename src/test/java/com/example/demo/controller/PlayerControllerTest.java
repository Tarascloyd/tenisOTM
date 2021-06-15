package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.player.Player;
import com.example.demo.player.PlayersAbility;
import com.example.demo.player.PlayersStat;
import com.example.demo.service.PlayerService;
import com.example.demo.service.PlayersAbilityService;
import com.example.demo.service.PlayersStatService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(PlayerController.class)
class PlayerControllerTest {

	@MockBean
    private PlayerService playerService;
	
	@MockBean
	private PlayersAbilityService playersAbilityService;
	
	@MockBean
	private PlayersStatService playersStatService;
	
	
    @Autowired
    private MockMvc mvc;
    
    List<Player> allPlayers;
    
    @BeforeEach
    void setUp() {
    	Player thePlayer = new Player();
		thePlayer.setName("Alex");
		thePlayer.setPlayersAbility(new PlayersAbility());
		thePlayer.setPlayersStat(new PlayersStat());
		
	    allPlayers = Arrays.asList(thePlayer);
    }
	
	@Test
	void list() throws Exception {
		
	    
	    when(playerService.findAllSortedByELO()).thenReturn(allPlayers);
	    
	    mvc.perform(get("/players/list"))
        .andExpect(status().isOk())
        .andExpect(model().attributeExists("players"))
        .andExpect(view().name("players/list-players"));
	}

}
