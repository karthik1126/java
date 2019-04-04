package lambda.example.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lambda.example.dto.Player;
import lambda.example.dto.Team;

public class Utils {

	public static Map<String, List<String>> loadTeams() {
		Map<String, List<String>> teams = new HashMap<>();
		teams.put("India", loadPlayersForTeam("India"));
		return teams;
	}

	public static List<String> loadPlayersForTeam(String team) {
		List<String> players = new ArrayList<>();
		if ("India".equals(team)) {
			players.add("Sachin");
			players.add("Sehwag");
			players.add("Gangully");
			players.add("Dravid");
		} else {
			players.add("Gilchrist");
			players.add("Haden");
			players.add("Rickey Pointing");
			players.add("Baven");
		}
		return players;
	}
	
	public static List<String> buildListWithDuplicates() {
		List<String> names = new ArrayList<>();
		names.add("Karthik");
		names.add("Shantha");
		names.add("Praveen");
		names.add("Amar");
		names.add("Karthik");
		names.add("Karthik");
		names.add("Praveen");
		names.add("Sreeram");
		names.add("Shantha");
		return names;
	}
	
	public static List<Player> buildPlayerList() {
		List<Player> players = new ArrayList<>();
		players.add(new Player(1, "Karthik", new Team(1, "Spartans")));
		players.add(new Player(2, "Sreeram", new Team(2, "Spartans")));
		players.add(new Player(3, "Praveen", new Team(3, "Chargers")));
		players.add(new Player(4, "Amar", new Team(4, "Chargers")));
		players.add(new Player(5, "Venu", new Team(5, "Chargers")));
		players.add(new Player(6, "Sheshu", new Team(6, "Pilots")));
		players.add(new Player(7, "Murli", new Team(7, "Pilots")));
		return players;
	}
}
