package lambda.example;

import java.util.List;

import lambda.example.interfaces.Players;
import lambda.example.utils.Utils;

/**
 * 
 * @author Karthik
 *
 */
public class LambdaExample1 {

	public static void main(String[] args) {
		// approach one
		usingAnnonymousInnerClass();
		
		// approach two
		usingLambdaExpression();
	}

	private static void usingLambdaExpression() {
		Players players = (t) -> Utils.loadPlayersForTeam(t);
		System.out.println("Approach Two: " + players.getPlayersForTeam("India"));
	}

	private static void usingAnnonymousInnerClass() {
		Players players = new Players() {
			
			@Override
			public List<String> getPlayersForTeam(String team) {
				return Utils.loadPlayersForTeam(team);
			};
		};
		System.out.println("Approach One: " + players.getPlayersForTeam("Australia"));
	}
}

