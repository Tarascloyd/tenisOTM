package com.example.demo.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

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
		List<String> lines = new ArrayList<>();
		try {
			File resource = new ClassPathResource(
				      "names.txt").getFile();
			lines = Files.readAllLines(resource.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i=0; i < count; i++) {
			Player thePlayer = new Player();
			int rnd = (int)(Math.random()*43950+1);
			String name = lines.size()>0 ? lines.get(rnd % 2 == 1 ? rnd : rnd + 1): "\"Mike\"";
			thePlayer.setName(name.substring(1,name.length()-1));
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
}
