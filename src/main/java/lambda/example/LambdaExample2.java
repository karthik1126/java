package lambda.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lambda.example.utils.Utils;

public class LambdaExample2 {

	public static void main(String[] args) {
		//getTotalListCount();
		//getUniqueNames();
		//returnIfNameFound();
		returnDuplicateCount();
	}

	private static void getTotalListCount() {
		List<String> list = Utils.loadPlayersForTeam("India");
		
		// approach one 
		System.out.println(list.size());
		
		// apporach two
		System.out.println(list.stream().count());
	}
	
	private static void getUniqueNames() {
		List<String> temp = new ArrayList<>(); 
		List<String> list = Utils.buildListWithDuplicates();
		
		// approach one 
		for (String name : list) {
			if (temp.isEmpty() || !temp.contains(name)) {
				temp.add(name);
			}
		}
		System.out.println(temp);
		
		// approach two
		temp = list.stream().distinct().collect(Collectors.toList());
		System.out.println(temp);
	}
	
	private static void returnIfNameFound() { 
		List<String> list = Utils.buildListWithDuplicates();
		String myname = "";
		// approach one 
		for (String name : list) {
			if ("Sreeram".equalsIgnoreCase(name)) {
				myname = name;
				break;
			}
		}
		System.out.println(myname);
		
		// approach two
		myname = (String) list.stream().filter((t) -> "Sreeram".equalsIgnoreCase(t)).toArray()[0];
		System.out.println(myname);
	}
	
	private static void returnDuplicateCount() {
		List<String> temp = new ArrayList<>(); 
		List<String> list = Utils.buildListWithDuplicates();
		final int counter = 0;
		int count = 0;

		// approach one 
		for (String name : list) {
			if (temp.isEmpty() || !temp.contains(name)) {
				temp.add(name);
			} else {
				count = count + 1;
			} 
		}
		System.out.println(count);
		
		// approach two
		
		List<String> Sstream = list.stream().filter((t) -> !temp.contains(t)).collect(Collectors.toList());
		System.out.println(Sstream.size());
		Sstream.forEach(c -> System.out.println("name:"+ c));
		IntStream stream = list.stream().filter((t) -> !temp.contains(t)).
								mapToInt(t -> {
									list.contains(t); 
									return counter+1;
								 });
		System.out.println(counter);
	}
	 
}