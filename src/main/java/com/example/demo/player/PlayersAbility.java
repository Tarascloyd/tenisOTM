package com.example.demo.player;

public class PlayersAbility {
	private int power;
	private int speed;
	private int skill;
	private int skillOnGrass;
	private int skillOnHard;
	private int skillOnClay;
	private int skillIndoor;
	private int averageSkillByCourt;
	public PlayersAbility(int power, int speed, int skill, int skillOnGrass, int skillOnHard, int skillOnClay,
			int skillIndoor) {
		this.power = power;
		this.speed = speed;
		this.skill = skill;
		this.skillOnGrass = skillOnGrass;
		this.skillOnHard = skillOnHard;
		this.skillOnClay = skillOnClay;
		this.skillIndoor = skillIndoor;
		this.averageSkillByCourt = (skillOnGrass + skillOnHard + skillOnClay + skillIndoor) / 4;
		
	}
	public int getPower() {
		return power;
	}
	public void setPower() {
		this.power++;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed() {
		this.speed++;
	}
	public int getSkill() {
		return skill;
	}
	public void setSkill() {
		this.skill++;
	}
	public int getSkillOnGrass() {
		return skillOnGrass;
	}
	public void setSkillOnGrass() {
		this.skillOnGrass++;
	}
	public int getSkillOnHard() {
		return skillOnHard;
	}
	public void setSkillOnHard() {
		this.skillOnHard++;
	}
	public int getSkillOnClay() {
		return skillOnClay;
	}
	public void setSkillOnClay() {
		this.skillOnClay++;
	}
	public int getSkillIndoor() {
		return skillIndoor;
	}
	public void setSkillIndoor() {
		this.skillIndoor++;
	}
	public int getAverageSkillByCourt() {
		return averageSkillByCourt;
	}
}
