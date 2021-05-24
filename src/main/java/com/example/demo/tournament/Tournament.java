package com.example.demo.tournament;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.example.demo.match.Match;
import com.example.demo.match.Match.Court;
import com.example.demo.player.Player;


@Entity
public class Tournament {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private Type type;
	private Court court;
	private int totalplayes;
	private int currentstage;
	
	@ManyToMany(targetEntity=Player.class)
	private List<Player> players;
	
	@OneToMany(mappedBy="tournament")
	private List<Match> matches = new ArrayList<>();
	
	public static enum Type {
		OTM125, OTM250, OTM500, MAJOR, GRAND;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Court getCourt() {
		return court;
	}

	public void setCourt(Court court) {
		this.court = court;
	}

	public int getTotalplayes() {
		return totalplayes;
	}

	public void setTotalplayes(int totalplayes) {
		this.totalplayes = totalplayes;
	}

	public int getCurrentstage() {
		return currentstage;
	}

	public void setCurrentstage(int currentstage) {
		this.currentstage = currentstage;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}
	
	
	
}
