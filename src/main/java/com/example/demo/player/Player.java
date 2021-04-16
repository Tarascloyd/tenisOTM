package com.example.demo.player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Player {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotNull
	@Size(min=3, message="Name must be at least 5 characters long")
	private String name;
	
	@NotNull
	@Min(value = 15, message="Invalid age")
	@Max(value = 39, message="Invalid age")
	private int age;
	
	
	@NotNull
	@Min(value = 10, message="Invalid skill")
	@Max(value = 99, message="Invalid skill")
	private int skill;

	public Player() {
		
	}
	public Player(int id, String name, int age, int skill) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.skill = skill;
	}
	public Player(String name, int age, int skill) {
		this.name = name;
		this.age = age;
		this.skill = skill;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSkill() {
		return skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}
	
	
}
