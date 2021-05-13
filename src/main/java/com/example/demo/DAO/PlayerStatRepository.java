package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.player.PlayersStat;

@Repository
public interface PlayerStatRepository extends JpaRepository<PlayersStat, Integer>{

}
