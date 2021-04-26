package model;

public class Player {

	String name;
	String lastName;
	String age;
	String team;
	String pointsPerGame;
	String reboundsPerGame;
	String assistsPerGame;
	String robberiesPerGame;
	String blocksPerGame;
	
	public Player(String n,String l,String a,String t, String points,String rebounds,String assists,String robberies, String blocks) {
		name = n;
		lastName=l;
		age = a;
		team = t;
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
		return lastName;
	}
	
	public String getAge() {
		return age;
	}
	
	public String getTeam() {
		return team;
	}
	
	public String getPoStrings() {
		return pointsPerGame;
	}
	
	public String getRebounds() {
		return reboundsPerGame;
	}
	
	public String getAssists() {
		return assistsPerGame;
	}
	
	public String getRobberies() {
		return robberiesPerGame;
	}
	
	public String getBlocks() {
		return blocksPerGame;
	}
	
	

}
