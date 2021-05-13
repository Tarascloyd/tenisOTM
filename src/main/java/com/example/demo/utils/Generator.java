package com.example.demo.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.example.demo.player.Player;
import com.example.demo.player.PlayersAbility;
import com.example.demo.player.PlayersStat;
import com.example.demo.service.PlayerService;
import com.example.demo.service.PlayersAbilityService;
import com.example.demo.service.PlayersStatService;

@Component
public class Generator {
	private PlayerService playerService;
	private PlayersAbilityService playersAbilityService;
	private PlayersStatService playersStatService;
		
	public Generator(PlayerService playerService, PlayersAbilityService playersAbilityService,
			PlayersStatService playersStatService) {
		this.playerService = playerService;
		this.playersAbilityService = playersAbilityService;
		this.playersStatService = playersStatService;
	}



	public void generate(int count) {
		String line32 = "Mike";
		try {
			File resource = new ClassPathResource(
				      "names.txt").getFile();
			line32 = Files.readAllLines(resource.toPath()).get(33);
			System.out.println(line32);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Player thePlayer = new Player();
		thePlayer.setName(line32);
		thePlayer.setAge((int)(Math.random()*(40-17)+18));
		thePlayer.setPlayersAbility(new PlayersAbility());
		thePlayer.getPlayersAbility().setPower((int)(Math.random()*(100-10)+10));
		thePlayer.getPlayersAbility().setSpeed((int)(Math.random()*(100-10)+10));
		thePlayer.getPlayersAbility().setSkill((int)(Math.random()*(100-10)+10));
		thePlayer.getPlayersAbility().setSkillOnGrass((int)(Math.random()*(100-10)+10));
		thePlayer.getPlayersAbility().setSkillOnHard((int)(Math.random()*(100-10)+10));
		thePlayer.getPlayersAbility().setSkillOnClay((int)(Math.random()*(100-10)+10));
		thePlayer.getPlayersAbility().setSkillIndoor((int)(Math.random()*(100-10)+10));
		thePlayer.setPlayersStat(new PlayersStat());
		playersAbilityService.save(thePlayer.getPlayersAbility());
		playersStatService.save(thePlayer.getPlayersStat());
		playerService.save(thePlayer);
	}
}
