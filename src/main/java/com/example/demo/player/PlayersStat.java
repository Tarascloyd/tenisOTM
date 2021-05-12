package com.example.demo.player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlayersStat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int points = 0;
	private int totalWins = 0;
	private int totalLoses = 0;
	private int totalTitles = 0;
	private float ELORating = 1000;
	private float maxELO = 0;
	private int seeding = 0;
	
	
	public PlayersStat() {
		
	}


	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}


	public int getTotalWins() {
		return totalWins;
	}


	public void setTotalWins(int totalWins) {
		this.totalWins = totalWins;
	}


	public int getTotalLoses() {
		return totalLoses;
	}


	public void setTotalLoses(int totalLoses) {
		this.totalLoses = totalLoses;
	}


	public int getTotalTitles() {
		return totalTitles;
	}


	public void setTotalTitles(int totalTitles) {
		this.totalTitles = totalTitles;
	}


	public float getELORating() {
		return ELORating;
	}


	public void setELORating(float eLORating) {
		ELORating = eLORating;
	}


	public float getMaxELO() {
		return maxELO;
	}


	public void setMaxELO(float maxELO) {
		this.maxELO = maxELO;
	}


	public int getSeeding() {
		return seeding;
	}


	public void setSeeding(int seeding) {
		this.seeding = seeding;
	}
	
	
}
