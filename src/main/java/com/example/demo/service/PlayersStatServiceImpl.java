package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.DAO.PlayerStatRepository;
import com.example.demo.player.PlayersStat;

@Service
public class PlayersStatServiceImpl implements PlayersStatService {

	private PlayerStatRepository playersStatRepository;
	
	public PlayersStatServiceImpl(PlayerStatRepository playersStatRepository) {
		this.playersStatRepository = playersStatRepository;
	}

	@Override
	public void save(PlayersStat thePlayersStat) {
		playersStatRepository.save(thePlayersStat);

	}

}
