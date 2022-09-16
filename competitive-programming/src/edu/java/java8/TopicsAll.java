package edu.java.java8;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

//Default Methods for Interfaces
//Lambda expressions
//Functional Interfaces
//Method and Constructor References
//Lamda scopes
//Built-in Functional Interfaces
//Streams
//Parallel Streams
//Map
//Date API
public class TopicsAll {
	static int outerstaticnum;
	int outernum;

	public static void main(String arge[]) {
		TopicsAll java8 = new TopicsAll();
		java8.java();
	}

	private void java() {
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
		greeter.accept(new Person("Abc", "123"));

		// Comparators
		// same as conventional comparator, few default methods added to same
		// interface
		// take two args and compare
		Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);
		System.out.println(comparator.compare(new Person("ABC", "123"), new Person("XYZ", "123")));
		System.out.println(comparator.reversed().compare(new Person("ABC", "123"), new Person("XYZ", "123")));

		// Optionals
		// This is not function interface but a nifty utility to prevent
		// nullpointerexpcetions
		Optional<String> optional = Optional.of("foo");
		System.out.println(optional.isPresent());
		System.out.println(optional.get());
		System.out.println(optional.orElse("fallback"));
		optional.ifPresent((s) -> System.out.println(s.charAt(0)));

		// Built-in Functional Interfaces ----------------------------------

		// Streams ---------------------------------------------------------
		// Collection interface in java8 extended to create stream
		List<String> stringCollection = new ArrayList<String>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");

		// Match - terminal
		// returns boolean based on the match
		boolean anyStartsWith = stringCollection.stream().anyMatch((s) -> s.startsWith("a"));
		System.out.println(anyStartsWith);

		boolean allStartsWithA = stringCollection.stream().allMatch((s) -> s.startsWith("a"));
		System.out.println(allStartsWithA);

		boolean noneStartsWithZ = stringCollection.stream().noneMatch((s) -> s.startsWith("s"));
		System.out.println(noneStartsWithZ);

		// Count - terminal
		// returns count of stream
		long count = stringCollection.stream().count();
		System.out.println(count);

		// Reduce - terminal
		// perform some aggregation operation on the stream
		// Returns optional
		Optional<String> reduced = stringCollection.stream().reduce((s1, s2) -> s1 + "#" + s2);
		reduced.ifPresent(System.out::println);

		// foreach - terminal
		stringCollection.stream().forEach(System.out::println);

		// collect - terminal
		Set set = stringCollection.stream().collect(Collectors.toSet());
		System.out.println(set);

		// Filter - intermediate
		stringCollection.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println);

		// Sorted - intermediate
		// it doesn't modify the base collection
		stringCollection.stream().sorted().forEach(System.out::println);

		// custom sorter
		stringCollection.stream().sorted((s1, s2) -> -1 * s1.compareTo(s2)).forEach(System.out::println);
		;

		// Map - intermediate
		// converts each element to another object/type by a given function
		// map returns a new stream
		stringCollection.stream().map(String::toUpperCase).forEach(System.out::println);
		stringCollection.stream().map(String::length).forEach(System.out::println);

		// Streams ---------------------------------------------------------

		// Parallel Streams ------------------------------------------------

		int max = 1000000;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}

		// Sequential Sort
		long t0 = System.currentTimeMillis();
		long count2 = values.stream().sorted().count();
		System.out.println(count2);
		long t1 = System.currentTimeMillis();
		long millis = t1 - t0;
		System.out.printf("Sequence sorting: %d ms", millis);

		// Parallel Sort
		long t2 = System.currentTimeMillis();
		long count3 = values.parallelStream().sorted().count();
		System.out.println(count3);
		long t3 = System.currentTimeMillis();
		long millis2 = t3 - t2;
		System.out.printf("Parallel sort: %d ms", millis2);

		// Parallel Streams ------------------------------------------------

		// Map -------------------------------------------------------------
		// maps don't support streams but added many useful methods
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "San");
		for (int i = 0; i < 10; i++) {
			map.putIfAbsent(i, "val" + i);
		}
		map.forEach((id, value) -> {
			System.out.println(value);
		});

		map.computeIfPresent(3, (key, val) -> val + key);
		System.out.println(map.get(3));

		map.computeIfPresent(9, (key, val) -> null);
		System.out.println(map.containsKey(9));

		map.computeIfAbsent(23, (key) -> "val" + key);
		System.out.println(map.containsKey(23));

		map.computeIfAbsent(3, (key) -> "foo");
		System.out.println(map.get(3));

		map.remove(3, "val3");
		System.out.println(map.get(3));

		map.remove(3, "val33");
		System.out.println(map.get(3));

		System.out.println(map.getOrDefault(42, "not found"));

		// this is extremely useful for counting
		map.merge(9, "val9", (value, newvalue) -> value.concat(newvalue));
		System.out.println(map.get(9));

		map.merge(9, "newvalue", (value, newvalue) -> value.concat(newvalue));
		System.out.println(map.get(9));

		// Map -------------------------------------------------------------

		// Date API --------------------------------------------------------
		Clock clock = Clock.systemDefaultZone();
		long millis3 = clock.millis();
		System.out.println("Millis: " + millis3);

		Instant instant = clock.instant();
		System.out.println("Instant: " + instant);
		Date legacyDate = Date.from(instant);
		System.out.println("Date: " + legacyDate);

		System.out.println(ZoneId.getAvailableZoneIds());
		ZoneId zone1 = ZoneId.of("Europe/Berlin");
		ZoneId zone2 = ZoneId.of("Brazil/East");
		System.out.println(zone1.getRules());
		System.out.println(zone2.getRules());

		LocalTime now1 = LocalTime.now(zone1);
		LocalTime now2 = LocalTime.now(zone2);
		System.out.println(now1.isBefore(now2));

		long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
		System.out.println(hoursBetween);
		long minutsBetween = ChronoUnit.MINUTES.between(now1, now2);
		System.out.println(minutsBetween);

		LocalTime localTime = LocalTime.of(23, 59, 59);
		System.out.println(localTime);

		DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)
				.withLocale(Locale.GERMAN);
		LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
		System.out.println(leetTime);

		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
		LocalDate yesterday = tomorrow.minusDays(2);
		System.out.println(yesterday);

		LocalDate independenceDay = LocalDate.of(2014, Month.AUGUST, 15);
		DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
		System.out.println(dayOfWeek);

		DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
				.withLocale(Locale.GERMAN);
		LocalDate xmas = LocalDate.parse("24.12.2014", dateTimeFormatter2);
		System.out.println(xmas);

		LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
		DayOfWeek dayOfWeek2 = sylvester.getDayOfWeek();
		System.out.println(dayOfWeek2);
		Month month = sylvester.getMonth();
		System.out.println(month);
		long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
		System.out.println(minuteOfDay);

		Instant instant2 = sylvester.atZone(ZoneId.systemDefault()).toInstant();
		Date legacyDate2 = Date.from(instant2);
		System.out.println(legacyDate2);

		DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("MMM dd, yyyy - HH:mm");
		LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", dateTimeFormatter3);
		String string = dateTimeFormatter3.format(parsed);
		System.out.println(string);

		// Date API --------------------------------------------------------
	}

	interface Formula {
		double calculate(int a);

		default double sqrt(int a) {
			return Math.sqrt(a);
		}
	}

	class Person {
		private String firstName;
		private String lastName;

		Person() {
		}

		Person(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

	}

}
