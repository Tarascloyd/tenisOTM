package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.DAO.PlayerAbilityRepository;
import com.example.demo.player.PlayersAbility;

@Service
public class PlayersAbilityServiceImpl implements PlayersAbilityService {

	private PlayerAbilityRepository playersAbilityRepository;
	
	public PlayersAbilityServiceImpl(PlayerAbilityRepository playersAbilityRepository) {
		this.playersAbilityRepository = playersAbilityRepository;
	}



	@Override
	public void save(PlayersAbility thePlayersAbility) {
		playersAbilityRepository.save(thePlayersAbility);

	}

}
