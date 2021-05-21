package com.example.demo.tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.demo.player.Player;

public class TournamentPlay {
	private static Tournament tournament;
	
	public static void start() {
	    System.out.println("Tournament on" + tournament.getCourt() + " " + tournament.getType()
	    	+ " (" + tournament.getTotalplayes() + ") is starting");
	    for (int i=1; i<tournament.getTotalplayes()/2; i++) {
	    	if (tournament.getCurrentstage()==0) {
	    		stagewithdraw();  
	    	} else {stagewithoutdraw();}
	    		tournament.setCurrentstage(tournament.getCurrentstage() + 1);
	    }
	    Player winner = tournament.getPlayers().get(0);
	    System.out.println("Winner of this tournamet " + tournament.getType() + " is " + winner.getName());
	    winner.getPlayersStat().setTotalTitles(winner.getPlayersStat().getTotalTitles() + 1);
	}
	//TO DO!!!
	private static void stagewithdraw() {
	    List<Player> stageplayers = new ArrayList<>();
	    Random r= new Random();
	    List<Integer> draw = new ArrayList<>();
	    for (int i=0; i < tournament.getPlayers().size()/2; i++) {
	    	int p1;
	    	do {
	    		p1 = r.nextInt(tournament.getPlayers().size()/2);
	    	} while (draw.indexOf(p1) >= 0);
	    	draw.add(p1);
	    }
	    for (int i=0; i < tournament.getPlayers().size()/2; i++) {
	    	
	    	stageplayers.add(c1.start());
	    }
	    this.players=stageplayers;
	 }
}
