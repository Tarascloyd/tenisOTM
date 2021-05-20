package com.example.demo.match;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.demo.player.Player;

@Entity
public class Match {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Court court;
	
	@ManyToOne
	private Player play1;
	
	@ManyToOne
	private Player play2;
	
	private int p1;
	private int p2; 
	private String result;
	
	public static enum Court {
		GRASS, HARD, CLAY, INDOOR;
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
	public Player getPlay1() {
		return play1;
	}
	public void setPlay1(Player play1) {
		this.play1 = play1;
	}
	public Player getPlay2() {
		return play2;
	}
	public void setPlay2(Player play2) {
		this.play2 = play2;
	}
	public int getP1() {
		return p1;
	}
	public void setP1(int p1) {
		this.p1 = p1;
	}
	public int getP2() {
		return p2;
	}
	public void setP2(int p2) {
		this.p2 = p2;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
}
