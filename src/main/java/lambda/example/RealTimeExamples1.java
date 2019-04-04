package lambda.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lambda.example.dto.Player;
import lambda.example.dto.Team;
import lambda.example.utils.Utils;

public class RealTimeExamples1 {

	public static void main(String[] args) {
		groupPlayersByTeam();
		addPlayersToListIfNotPresent();
	}

	private static void addPlayersToListIfNotPresent() {
		System.out.println(" ----------- Adding player to TEAM ----------- ");
		List<Player> players = Utils.buildPlayerList();
		Player player1 = new Player(1, "Karthik", new Team(1, "Spartans"));
		Player player2 = new Player(8, "Harish", new Team(1, "Spartans"));

		addPlayer(players, player1);
		addPlayer(players, player2);
	}

	private static void addPlayer(List<Player> players, Player playerToAdd) {
		final List<Player> playersOne = new ArrayList<>(); 
		players.stream()
			.filter(player -> !(player.getPlayerID() == playerToAdd.getPlayerID()))
			.map(player -> {
				return player;
			}).peek(player -> System.out.println(player.toString()))
			.collect(Collectors.toCollection(() -> playersOne));
		playersOne.stream().peek(player -> System.out.println(player.toString()));
	}

	private static void groupPlayersByTeam() {
		System.out.println(" ----------- Grouping player by TEAM ----------- ");
		List<Player> players = Utils.buildPlayerList();

		// group players by team
		Map<String, List<Player>> playersGrp = players.stream().collect(Collectors.groupingBy(player -> {
			return player.getTeam().getTeamName();
		}));
		for (String team : playersGrp.keySet()) {
			System.out.println(" -> " + team);
			playersGrp.get(team).stream().forEach(player -> System.out.println(player.getPlayerName()));
		}
	}

}
