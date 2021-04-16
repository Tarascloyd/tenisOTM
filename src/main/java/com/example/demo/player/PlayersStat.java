package com.example.demo.player;

public class PlayersStat {
	private int points;
	private int totalWins;
	private int totalLoses;
	private int totalTitles;
	private float ELORating;
	private float maxELO;
	private int seeding = 0;
	public PlayersStat(int points, int totalWins, int totalLoses, int totalTitles, float ELORating, float maxELO) {
		super();
		this.points = points;
		this.totalWins = totalWins;
		this.totalLoses = totalLoses;
		this.totalTitles = totalTitles;
		this.ELORating = ELORating;
		this.maxELO = maxELO;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points += points;
	}
	public int getTotalWins() {
		return totalWins;
	}
	public void setTotalWins() {
		this.totalWins ++;
	}
	public int getTotalLoses() {
		return totalLoses;
	}
	public void setTotalLoses() {
		this.totalLoses ++;
	}
	public int getTotalTitles() {
		return totalTitles;
	}
	public void setTotalTitles() {
		this.totalTitles ++;
	}
	public float getELORating() {
		return ELORating;
	}
	public void setELORating(float ELORating) {
		this.ELORating += ELORating;
		if (this.ELORating > this.maxELO) this.maxELO=this.ELORating;
	    if (this.ELORating<100) this.ELORating=100;
	}
	public float getMaxELO() {
		return maxELO;
	}
	public int getSeeding() {
		return seeding;
	}
	public void setSeeding(int seeding) {
		this.seeding = seeding;
	}
	
}
