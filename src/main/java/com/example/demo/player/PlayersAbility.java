package com.example.demo.player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class PlayersAbility {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotNull
	@Min(value = 10, message="Invalid power")
	@Max(value = 99, message="Invalid power")
	private int power;
	
	@NotNull
	@Min(value = 10, message="Invalid speed")
	@Max(value = 99, message="Invalid speed")
	private int speed;
	
	@NotNull
	@Min(value = 10, message="Invalid skill")
	@Max(value = 99, message="Invalid skill")
	private int skill;
	
	@NotNull
	@Min(value = 10, message="Invalid skill")
	@Max(value = 99, message="Invalid skill")
	private int skillOnGrass;
	
	@NotNull
	@Min(value = 10, message="Invalid skill")
	@Max(value = 99, message="Invalid skill")
	private int skillOnHard;
	
	@NotNull
	@Min(value = 10, message="Invalid skill")
	@Max(value = 99, message="Invalid skill")
	private int skillOnClay;
	
	@NotNull
	@Min(value = 10, message="Invalid skill")
	@Max(value = 99, message="Invalid skill")
	private int skillIndoor;
	
	
	public PlayersAbility() {
		
	}
	
	public int getLevel() {
		return (power + speed + skill + (skillOnGrass + skillOnHard + skillOnClay + skillIndoor)/4)/4;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getSkill() {
		return skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

	public int getSkillOnGrass() {
		return skillOnGrass;
	}

	public void setSkillOnGrass(int skillOnGrass) {
		this.skillOnGrass = skillOnGrass;
	}

	public int getSkillOnHard() {
		return skillOnHard;
	}

	public void setSkillOnHard(int skillOnHard) {
		this.skillOnHard = skillOnHard;
	}

	public int getSkillOnClay() {
		return skillOnClay;
	}

	public void setSkillOnClay(int skillOnClay) {
		this.skillOnClay = skillOnClay;
	}

	public int getSkillIndoor() {
		return skillIndoor;
	}

	public void setSkillIndoor(int skillIndoor) {
		this.skillIndoor = skillIndoor;
	}
	
}
