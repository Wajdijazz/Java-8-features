package Optional;

import java.util.Optional;

public class OptionalTuto {

	/**
	 * Optionals are not functional interfaces, but nifty utilities to prevent
	 * NullPointerException Optional is a simple container for a value which may be
	 * null or non-null. Think of a method which may return a non-null result but
	 * sometimes return nothing. Instead of returning null you return an Optional in
	 * Java 8.
	 **/

	public static void main(String[] args) {
		Optional<String> optional = Optional.of("bam");

		optional.isPresent(); // true
		optional.get(); // "bam"
		optional.orElse("fallback"); // "bam"

		optional.ifPresent((s) -> System.out.println(s.charAt(0))); // "b"
		
		 test1();
	}

	private static void test1() {
		 Optional.of(new Outer())
         .flatMap(o -> Optional.ofNullable(o.nested))
         .flatMap(n -> Optional.ofNullable(n.inner))
         .flatMap(i -> Optional.ofNullable(i.foo))
         .ifPresent(System.out::println);
		
	}
}

class Outer {
	Nested nested = new Nested();

	public Nested getNested() {
		return nested;
	}
}

class Nested {
	Inner inner = new Inner();

	public Inner getInner() {
		return inner;
	}
}

class Inner {
	String foo = "boo";

	public String getFoo() {
		return foo;
	}
}
