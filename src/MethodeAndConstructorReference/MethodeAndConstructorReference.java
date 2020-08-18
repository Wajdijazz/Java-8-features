package MethodeAndConstructorReference;

import java.util.function.BiFunction;

public class MethodeAndConstructorReference {

	public static int add(int a, int b) {
		return a + b;
	}

	public static int multipilcation(int a, int b) {
		return a * b;
	}

	public static interface Converter<F, T> {
		T convert(F from);
	}

	public static interface ToUpper<T> {
		T toUpper(T str);
	}

	interface PersonFactory<P extends Person> {
		P create(String firstName, String lastName);
	}

	public static void main(String[] args) {
		// with lambda expression
		Converter<String, Integer> integerConverter1 = (from) -> Integer.valueOf(from);
		Integer converted1 = integerConverter1.convert("123");
		System.out.println(converted1); // result: 123

		ToUpper<String> toUpperCase = (str) -> str.toUpperCase();
		String toUpperCaseStr = toUpperCase.toUpper("wajdi");
		System.out.println(toUpperCaseStr);
		
		// with method reference
		Converter<String, Integer> integerConverter2 = Integer::valueOf;
		Integer converted2 = integerConverter2.convert("123");
		System.out.println(converted2);

		ToUpper<String> toUpperCaseReference = String::toUpperCase;
		String toUpperCaseReferenceStr = toUpperCaseReference.toUpper("wajdi jaziri");
		System.out.println(toUpperCaseReferenceStr);

		BiFunction<Integer, Integer, Integer> adder = MethodeAndConstructorReference::add;
		BiFunction<Integer, Integer, Integer> multipilcation = MethodeAndConstructorReference::multipilcation;
		Integer ad = adder.apply(5, 6);
		System.out.println(ad);
		Integer mult = multipilcation.apply(5, 6);
		System.out.println(mult);

		// With constructor reference
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("Wajdi", "Jaziri");
		System.out.println(person);

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
