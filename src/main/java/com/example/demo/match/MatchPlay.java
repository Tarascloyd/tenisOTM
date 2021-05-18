package com.example.demo.match;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.demo.player.Player;

public class MatchPlay {
	private static Match match;
	private static Player play1;
	private static Player play2;
	
	private static float Probability(float rating1, float rating2) { 
		 return 1.0f * 1.0f / (1 + 1.0f * (float)(Math.pow(10, 1.0f * (rating1 - rating2) / 400))); 
	 } 

	 private static Set<Integer> getRandomNumbers(int size) {
		 Set<Integer> set = new LinkedHashSet<>();
		 Random r=new Random();
		 int numberOfMatches = 6;
		 if (numberOfMatches % 2 == 1) numberOfMatches++;
		 while (set.size() < numberOfMatches) {
			 set.add(r.nextInt(size));
		 }
		 return set;
	 }
	 public static List<Match> playRandomMatches(List<Player> list){
		 setRunk(list);
		 List<Match> theMatches = new ArrayList<>();
		 Set<Integer> set = getRandomNumbers(list.size());
		 Player playerOne = null;
		 int count = 0;
		 for (Integer n : set) {
			 if (count % 2 == 0) {
				 playerOne = list.get(n);
			 } else {
				 createMatch(playerOne, list.get(n));
				 startMatch();
				 theMatches.add(match);
			 }
			 count++;
		 }
		 
		 return theMatches;
	 }
	 
	 private static void setRunk(List<Player> list) {
		 List<Player> list2 = list.stream()
		 	.sorted((p1, p2) -> (int)((p2.getPlayersStat().getELORating() - p1.getPlayersStat().getELORating())*1000))
		 	.collect(Collectors.toList());
		 list2.forEach(p -> p.getPlayersStat().setSeeding(list2.indexOf(p)+1));
	 }
	 private static void createMatch(Player p1, Player p2) {
		match = new Match();
		match.setCourt((int)(Math.random()*4));
		match.setPlay1(p1);
		match.setPlay2(p2);
		play1 = p1;
		play2 = p2;
		match.setP1(0);
		match.setP2(0);
	 }
	 private static Player startMatch() {
		 playMatch();
		 return calculateResult();
	 }
	 private static Player calculateResult() {
		 float rat1 = play1.getPlayersStat().getELORating();
		 float rat2 = play2.getPlayersStat().getELORating();
		 System.out.println(rat1 + " " + rat2);
		 if (match.getP1() > match.getP2()) { 
			 float prob = Probability(rat1,rat2);
			 play1.getPlayersStat().setTotalWins(play1.getPlayersStat().getTotalWins() + 1);
			 play2.getPlayersStat().setTotalLoses(play2.getPlayersStat().getTotalLoses() + 1);
			 play1.getPlayersStat().setELORating(play1.getPlayersStat().getELORating() + prob*40);
			 play2.getPlayersStat().setELORating(play2.getPlayersStat().getELORating() + prob*-40);
			 System.out.println(prob);
			 System.out.println(match.getResult() + "  Win1");
			 System.out.println(play1.getPlayersStat().getELORating() + " " + play2.getPlayersStat().getELORating());
			 return play1;
		  } else {
			 float prob = Probability(rat2,rat1);
			 play2.getPlayersStat().setTotalWins(play2.getPlayersStat().getTotalWins() + 1);
			 play1.getPlayersStat().setTotalLoses(play1.getPlayersStat().getTotalLoses() + 1);
			 play2.getPlayersStat().setELORating(play2.getPlayersStat().getELORating() + prob*40);
			 play1.getPlayersStat().setELORating(play1.getPlayersStat().getELORating() + prob*-40);
			 System.out.println(prob);
			 System.out.println(match.getResult() + "  Win2");
			 System.out.println(play1.getPlayersStat().getELORating() + " " + play2.getPlayersStat().getELORating());
			 return play2;
		  }
	 }
	 private static  void playMatch() {
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
	 }

	 private static String set(double probThisMatch) {
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