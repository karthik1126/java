package lambda.example.dto;

import java.util.List;

public class Team {
	private int teamID;

	private String teamName;

	private List<Player> players;

	public Team(int teamId, String teamName) {
		this.teamID = teamId;
		this.teamName = teamName;
	}

	public final int getTeamID() {
		return teamID;
	}

	public final void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	public final String getTeamName() {
		return teamName;
	}

	public final void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public final List<Player> getPlayers() {
		return players;
	}

	public final void setPlayers(List<Player> players) {
		this.players = players;
	}

}