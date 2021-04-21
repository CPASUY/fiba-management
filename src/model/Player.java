package model;

public class Player {

	String name;
	int age;
	String team;
	int pointsPerGame;
	int reboundsPerGame;
	int assistsPerGame;
	int robberiesPerGame;
	int blocksPerGame;
	
	public Player(String name,int age,String team, int points,int rebounds,int assists,int robberies, int blocks) {
		this.name = name;
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
