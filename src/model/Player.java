package model;

public class Player {

	String name;
	String last_name;
	int age;
	String team;
	int pointsPerGame;
	int reboundsPerGame;
	int assistsPerGame;
	int robberiesPerGame;
	int blocksPerGame;
	
	public Player(String name,String last_name,int age,String team, int points,int rebounds,int assists,int robberies, int blocks) {
		this.name = name;
		this.last_name=last_name;
		this.age = age;
		this.team = team;
		pointsPerGame = points;
		reboundsPerGame = rebounds;
		assistsPerGame = assists;
		robberiesPerGame = robberies;
		blocksPerGame = blocks;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLast_Name() {
		return last_name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getTeam() {
		return team;
	}
	
	public int getPoints() {
		return pointsPerGame;
	}
	
	public int getRebounds() {
		return reboundsPerGame;
	}
	
	public int getAssists() {
		return assistsPerGame;
	}
	
	public int getRobberies() {
		return robberiesPerGame;
	}
	
	public int getBlocks() {
		return blocksPerGame;
	}
	
	

}
