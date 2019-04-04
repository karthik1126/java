package lambda.example;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PremitiveStreamExample {

	public static void main(String[] args) {
		// intStreamOperations();
		// stringStreamOperations();
		reduceStreamOperation();
	}

	private static void reduceStreamOperation() {
		IntStream intStr = IntStream.of(1, 2, 3, 4);
		OptionalInt opint = intStr.reduce((a, b) -> {
			System.out.println("a : " + a + " b : " + b);
			return a + b;
		});
		System.out.println(opint.getAsInt());

		intStr = IntStream.of(1, 2, 3, 4);
		int opint2 = intStr.reduce(10, (a, b) -> {
			System.out.println("a : " + a + " b : " + b);
			return a + b;
		});
		System.out.println(opint2);

		// combining done as normal stream
		int reducedParams = Stream.of(1, 2, 3, 4).reduce(10, (a, b) -> a + b, (a, b) -> {
			System.out.println("combiner was called");
			return a + b;
		});
		System.out.println("combined as sequential stream : " + reducedParams);

		// combining done as normal stream
		int reducedParallelParams = Stream.of(1, 2, 3, 4).parallel().reduce(10, (a, b) -> {
			int val = a + b;
			System.out.println("accumulator was called" + val);
			return val;
		}, (a, b) -> {
			int val = a + b;
			System.out.println("combiner was called " + val);
			return val;
		});
		System.out.println("combined as sequential stream : " + reducedParallelParams);
	}

	private static void intStreamOperations() {
		IntStream intStr = IntStream.of(1, 2, 3, 5, 4);
		// intStr.forEach(t -> System.out.println(" int value : " + t));
		int sum = intStr.filter(t -> t * 2 < 10).peek(t -> System.out.println(t)).sum();
		System.out.println(sum);
	}

	private static void stringStreamOperations() {
		Stream<String> strStream = Stream.of("a", "b", "c", "d");
		strStream = strStream.map(t -> {
			System.out.println("called ");
			return t + "1";
		});
		boolean yes = strStream.anyMatch(t -> "b".equalsIgnoreCase(t));
		System.out.println(yes);

		List<String> stream = Stream.of("a", "b", "c").filter(t -> !t.equals("b")).collect(Collectors.toList());
		stream.stream().forEach(t -> System.out.println(t));
		// Optional<String> anyElement = stream.findAny();
		// System.out.println(anyElement.get());

		List<String> onceModifiedStream = Stream.of("abcd", "bbcd", "cbcd").skip(1).collect(Collectors.toList());
		onceModifiedStream = onceModifiedStream.stream().map(t -> t + "-Test").collect(Collectors.toList());
		onceModifiedStream.stream().forEach(t -> System.out.println(t));
	}
}
