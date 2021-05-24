package com.example.demo.tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.example.demo.match.Match;
import com.example.demo.match.MatchPlay;
import com.example.demo.match.Match.Court;
import com.example.demo.player.Player;
import com.example.demo.tournament.Tournament.Type;

public class TournamentPlay {
	private static Tournament tournament;
	
	
	public static void play(List<Player> list) {
		List<Player> thePlayers = setSeeding(list);
		createTournament(thePlayers);
		start();
	}
	private static void createTournament(List<Player> list) {
		tournament = new Tournament();
		tournament.setCourt(createCourt((int)(Math.random()*4)));
		tournament.setPlayers(list);
		tournament.setTotalplayes(list.size());
		tournament.setType(Type.OTM250);
	}
	private static List<Player> setSeeding(List<Player> list) {
		 List<Player> list2 = list.stream()
		 	.sorted((p1, p2) -> (int)((p2.getPlayersStat().getELORating() - p1.getPlayersStat().getELORating())*1000))
		 	.collect(Collectors.toList());
		 list2.forEach(p -> p.getPlayersStat().setSeeding(list2.indexOf(p)+1));
		 return list2;
	 }
	private static Court createCourt(int number) {
		 switch (number) {
		 	case 0: return Court.GRASS;
		 	case 1: return Court.HARD;
		 	case 2: return Court.CLAY;
		 	case 3: return Court.INDOOR;
		 }
		 return Court.HARD;
	 }
	private static void start() {
	    System.out.println("Tournament on " + tournament.getCourt() + " " + tournament.getType()
	    	+ " (" + tournament.getTotalplayes() + ") is starting");
	    for (int i=0; i < (Math.log(tournament.getTotalplayes()/2) / Math.log(2) + 1); i++) {
	    	System.out.println(tournament.getCurrentstage() + " " + tournament.getPlayers().size());
	    	if (tournament.getCurrentstage()==0) {
	    		stagewithdraw();  
	    	} else {
	    		stagewithoutdraw();
	    	}
	    	tournament.setCurrentstage(tournament.getCurrentstage() + 1);
	    }
	    Player winner = tournament.getPlayers().get(0);
	    System.out.println("Winner of this tournamet " + tournament.getType() + " is " + winner.getName());
	    winner.getPlayersStat().setTotalTitles(winner.getPlayersStat().getTotalTitles() + 1);
	}
	
	private static void stagewithdraw() {
		List<Player> stageplayers = new ArrayList<>();
	    Random r= new Random();
	    List<Integer> draw = new ArrayList<>();
	    var players = tournament.getPlayers();
	    for (int i=0; i < players.size()/2; i++) {
	    	int p1;
	    	do {
	    		p1 = r.nextInt(players.size()/2);
	    	} while (draw.indexOf(p1) >= 0);
	    	draw.add(p1);
	    }
	    for (int i=0; i < players.size()/2; i++) {
	    	Match theMatch = MatchPlay.playOneMatch(players.get(i), players.get(draw.get(i) + players.size()/2), tournament.getCourt());
	    	tournament.getMatches().add(theMatch);
	    	stageplayers.add(theMatch.getWinner() == 1 ? theMatch.getPlay1() : theMatch.getPlay2());
	    }
	    tournament.setPlayers(stageplayers);
	}
	private static void stagewithoutdraw() {
	    List<Player> stageplayers = new ArrayList<>();
	    var players = tournament.getPlayers();
	    for (int i=0; i < players.size()/2; i++) {
	    	Match theMatch = MatchPlay.playOneMatch(players.get(i), players.get(players.size() - i - 1), tournament.getCourt());
	    	tournament.getMatches().add(theMatch);
	    	stageplayers.add(theMatch.getWinner() == 1 ? theMatch.getPlay1() : theMatch.getPlay2());
	    }
	    tournament.setPlayers(stageplayers);
	}
	
	
}
