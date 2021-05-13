package com.example.demo.service;

import java.util.List;

import com.example.demo.player.Player;

public interface PlayerService {
	public List<Player> findAllSortedByLevel();
	
	public List<Player> findAll();
	
	public Player findById(int theId);
	
	public void save(Player thePlayer);
	
	public void deleteById(int theId);
	
	public List<Player> searchBy(String theName);
}
