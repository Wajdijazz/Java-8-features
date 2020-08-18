package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Streams {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(new Person("Max", 18), new Person("Peter", 23), new Person("Pamela", 23),
				new Person("Adel", 12));
		List<Person> filtered = persons.stream().filter(p -> p.name.startsWith("P")).collect(Collectors.toList());
		System.out.println(filtered);

		/** The intermediate operation map converts each element into another object **/
		String names = persons.stream().filter(p -> p.age >= 18).map(p -> p.name)
				.collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
		System.out.println(names);

		/**
		 * Match Various matching operations can be used to check whether a certain
		 * predicate matches the stream
		 **/
		boolean anyStartsWithA = persons.stream().anyMatch((p) -> p.name.startsWith("A"));
		System.out.println(anyStartsWithA);

		/**
		 * Reduce This terminal operation performs a reduction on the elements of the
		 * stream with the given function. The result is an Optional holding the reduced
		 * value.
		 **/
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		Optional<String> reduced = stringCollection.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);
		reduced.ifPresent(System.out::println);
		/**
		 * Maps  do not directly support streams. There's no
		 * stream() method available on the Map interface itself
		 **/
		Map<String, String> books = new HashMap<>();
		books.put(
		"978-0201633610", "Design patterns : elements of reusable object-oriented software");
		books.put(
		  "978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");
		books.put("978-0134685991", "Effective Java");
		
		Optional<String> optionalIsbn = books.entrySet().stream()
				  .filter(e -> "Effective Java".equals(e.getValue()))
				  .map(Map.Entry::getKey)
				  .findFirst();
		optionalIsbn.ifPresent(System.out::println);


	}

}

class Person {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return name;
	}
}
