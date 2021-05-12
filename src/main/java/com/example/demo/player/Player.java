package com.example.demo.player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Player {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotNull
	@Size(min=3, message="Name must be at least 5 characters long")
	private String name;
	
	@NotNull
	@Min(value = 15, message="Invalid age")
	@Max(value = 39, message="Invalid age")
	private int age;
	
	
	@OneToOne
	private PlayersAbility playersAbility;

	@OneToOne
	private PlayersStat playersStat;

	public Player() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public PlayersAbility getPlayersAbility() {
		return playersAbility;
	}

	public void setPlayersAbility(PlayersAbility playersAbility) {
		this.playersAbility = playersAbility;
	}

	public PlayersStat getPlayersStat() {
		return playersStat;
	}

	public void setPlayersStat(PlayersStat playersStat) {
		this.playersStat = playersStat;
	}
	
	
}
