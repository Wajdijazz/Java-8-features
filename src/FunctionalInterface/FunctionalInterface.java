package FunctionalInterface;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterface {

	/** Functional interface must have one abstract methode **/
	public static interface Converter<F, T> {
		T convert(F from);
	}

	public static interface Operation<T> {
		T add(T x, T y);
	}

	public static void main(String[] args) {
		Converter<String, Integer> integerConverter1 = (from) -> Integer.valueOf(from);
		Integer converted1 = integerConverter1.convert("123");

		Operation<Integer> addition = (x, y) -> x + y;
		Integer added = addition.add(2, 3);

		/**
		 * Predicates : Predicates are boolean-valued functions of one argument. The
		 * interface contains various default methods for composing predicates to
		 * complex logical terms (and, or, negate)
		 **/

		Predicate<String> predicate = (s) -> s.length() > 0;
		predicate.test("foo"); // true
		predicate.negate().test("foo"); // false

		/**
		 * Functions accept one argument and produce a result. Default methods can be
		 * used to chain multiple functions together (compose, andThen).
		 **/
		Function<String, Integer> toInteger = Integer::valueOf;
		toInteger.apply("123");

		/**
		 * Suppliers produce a result of a given generic type. Unlike Functions,
		 * Suppliers don't accept arguments.
		 **/
		Supplier<Person> personSupplier = Person::new;
		personSupplier.get(); // new Person

		/**
		 * Consumers represent operations to be performed on a single input argument
		 **/
		Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
		greeter.accept(new Person("Luke", "Skywalker"));

		/**
		 * Comparators are well known from older versions of Java. Java 8 adds various
		 * default methods to the interface.
		 **/
		Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

		Person p1 = new Person("John", "Doe");
		Person p2 = new Person("Alice", "Wonderland");

		comparator.compare(p1, p2); // > 0
		comparator.reversed().compare(p1, p2); // < 0

	}

}

class Person {
	String firstName;
	String lastName;

	Person() {
	}

	Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
