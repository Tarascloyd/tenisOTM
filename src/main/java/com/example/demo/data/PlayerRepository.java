package com.example.demo.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.player.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

	List<Player> findAllByOrderBySkillDesc();
	
	List<Player> findByNameContainsAllIgnoreCase(String theName);
	
	List<Player> findBySkillBetween(int startSkill, int endSkill);

}
