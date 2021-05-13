package com.example.demo.match;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.demo.player.Player;

@Service
public class MatchPlay {
	private Match match;
	private Player play1;
	private Player play2;
	
	 public static float Probability(float rating1, float rating2) { 
		 return 1.0f * 1.0f / (1 + 1.0f * (float)(Math.pow(10, 1.0f * (rating1 - rating2) / 400))); 
	 } 

	 public static int[] getRandomPlayers(int size) {
		 int[] pair = new int[2];
		 Random r=new Random();
		 pair[0] = r.nextInt(size);
		 do {
			 pair[1] = r.nextInt(size);
		 } while (pair[1] == pair[0]);
		 return pair;
	 }
	 
	 public Player startMatch(Match match) {
		 this.match = match;
		 play1 = match.getPlay1();
		 play2 = match.getPlay2();
		 playMatch();
		 return calculateResult();
	 }
	 private Player calculateResult() {
		 float rat1 = play1.getPlayersStat().getELORating();
		 float rat2 = play2.getPlayersStat().getELORating();
		 if (match.getP1()> match.getP1()) { 
			 float prob = Probability(rat1,rat2);
			 play1.getPlayersStat().setTotalWins(play1.getPlayersStat().getTotalWins() + 1);
			 play2.getPlayersStat().setTotalLoses(play2.getPlayersStat().getTotalLoses() + 1);
			 play1.getPlayersStat().setELORating(play1.getPlayersStat().getELORating() + prob*40);
			 play2.getPlayersStat().setELORating(play2.getPlayersStat().getELORating() + prob*-40);
			 return play1;
		  } else {
			 float prob = Probability(rat2,rat1);
			 play2.getPlayersStat().setTotalWins(play2.getPlayersStat().getTotalWins() + 1);
			 play1.getPlayersStat().setTotalLoses(play1.getPlayersStat().getTotalLoses() + 1);
			 play2.getPlayersStat().setELORating(play2.getPlayersStat().getELORating() + prob*40);
			 play1.getPlayersStat().setELORating(play1.getPlayersStat().getELORating() + prob*-40);
			 return play2;
		  }
	 }
	 private void playMatch() {
		 int lvl1=play1.getPlayersAbility().getLevel(match.getCourt());
		 int lvl2=play2.getPlayersAbility().getLevel(match.getCourt());
		 double ver;
		 String score="(";
		 if (lvl1 > lvl2) {
			 ver=100-Math.round((0.5-(lvl1-lvl2)*0.005-(lvl1-lvl2)*0.00875)*100);
		 } else {
			 ver=Math.round((0.5-(lvl2-lvl1)*0.005-(lvl2-lvl1)*0.00875)*100);
		 }
		 if (ver<1) {ver=1;}
		 if (ver>99) {ver=99;}
		 do {
			 score = score + set(ver);
		 } while (match.getP1()<2 && match.getP2()<2);
		 match.setResult(match.getP1() + " - " + match.getP2() + score.substring(0, score.length()-2)+")");
		 System.out.println(match.getResult());
	 }

	 private String set(double probThisMatch) {
		 int g1=0;
		 int g2=0;
		 double probThisGame;
		 Random r=new Random();
		 do {
			 if ((g1 + g2)% 2 == 0) {
				 probThisGame = probThisMatch + 20;
			 } else probThisGame = probThisMatch - 20;
			 if (probThisGame < 1) {probThisGame = 1;}
			 if (probThisGame > 99) {probThisGame = 99;}
			 int kubik = r.nextInt(100);
			 if (kubik < probThisGame) {
				 g1 += 1;
			 } else {g2 += 1;}
		 } while ((g1<6 && g2<6) || (g1-g2==1 || g1-g2==-1 || g1-g2==0) && (g1!=7 && g2!=7));
		 if (g1 > g2) {
			 match.setP1(match.getP1() + 1); 
		 } else {match.setP2(match.getP2() + 1); }
		 return Integer.toString(g1) + " - " + Integer.toString(g2) + ", ";
	 }
}