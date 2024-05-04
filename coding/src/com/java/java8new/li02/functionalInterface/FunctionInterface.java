package com.java.java8new.li02.functionalInterface;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface sayable {
	// single abstract method
	void say(String msg);

	// It can contain any number of Object class methods.
	int hashCode();

	String toString();

	boolean equals(Object obj);

	// It can contain default method
	default void doIt() {
		System.out.println("Do it now");
	}

	// trying to override Object method gives compile time error as
	// "A default method cannot override a method from java.lang.Object"

	// default String toString(){
	// return "i1";
	// }
}

// it can have object class methods as abstract methods. This won't violate it
// property.
@FunctionalInterface
interface Convert<F, T> {
	T convert(F from);

	int hashCode();
}

public class FunctionInterface implements sayable {
	public void say(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) {
		FunctionInterface fie = new FunctionInterface();
		fie.say("Hello there");
		fie.doIt();

		Convert<String, Integer> converter = (from) -> Integer.parseInt(from);
		Integer integer = converter.convert("123");
		System.out.println(integer);


		// Built-in Functional Interfaces ----------------------------------
		// 1. Predicates - boolean test(arg1)
		// accept one agrument and return boolean
		// interface contains various default methods to compose a complex
		// boolean logic(and, or and negate)
		Predicate<String> predicate = (s) -> s.length() > 0;
		System.out.println(predicate.test("foo"));
		System.out.println(predicate.negate().test("foo"));

		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();

		// 2. Functions - apply
		// takes one/two arg and return one arg
		// default methods can gloue multiple functions together
		Function<String, Integer> stringToInteger = (from) -> Integer.valueOf(from);
		Function<String, String> backToString = stringToInteger.andThen(String::valueOf);
		System.out.println(backToString.apply("233"));

		BiFunction<String, String, String> concat = (s1, s2) -> s1 + s2;
		System.out.println(concat.apply("sandeep", "mekala"));

		// 3. Suppliers - get
		// don't take arg but produce one generic type
		Supplier<Person> supplier = Person::new;
		supplier.get();

		// Consumers - accept
		// consumes given arg
		Consumer<Person> greeter = (p) -> {
			System.out.println("Hello " + p.firstName);
		};
		Person p = new Person("firstName", "lastname");
		greeter.accept(p);

		// Comparators - compare
		// Same as conventional comparator, few default methods added to same
		// interface.
		// Takes two args and compare
		Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);
		System.out.println(comparator.compare(new Person("ABC", "123"), new Person("XYZ", "123")));
		System.out.println(comparator.reversed().compare(new Person("ABC", "123"), new Person("XYZ", "123")));

		// Optionals
		// This is not function interface but a nifty utility to prevent
		// nullpointerexpcetions.
		Optional<String> optional = Optional.of("foo");
		System.out.println(optional.isPresent());
		System.out.println(optional.get());
		System.out.println(optional.orElse("fallback"));
		optional.ifPresent((s) -> System.out.println(s.charAt(0)));

		// Built-in Functional Interfaces ----------------------------------
	}

	static class Person {
		private String firstName;
		private String lastName;

		Person() {
		}

		Person(String firstName) {
			this.firstName = firstName;
		}
		public  Person(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}


	}
}