package java8;
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
public class Java8 {
	static int outerstaticnum;
	int outernum;

	public static void main(String arge[]) {
		Java8 java8 = new Java8();
		java8.java();
	}

	private void java() {
		
		// Default Methods for Interfaces ----------------------------------		
		System.out.println(formula.calculate(100));
		System.out.println(formula.sqrt(16));		
		// Default Methods for Interfaces ----------------------------------
		
		// Lambda expressions ----------------------------------------------
		List<String> list = Arrays.asList("a", "x", "b");

		// anonymous comparator
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String a, String b) {
				return a.compareTo(b);
			}
		});
		System.out.println(list);

		// lamda expression
		// all functional intefaces can be replaces with lamda expressions
		Collections.sort(list, (String a, String b) -> {
			return a.compareTo(b);
		});

		// if body is single line, we don't need to add return and flower
		// brackets
		Collections.sort(list, (String a, String b) -> a.compareTo(b));

		// compiler is already aware of the parameter types, you can even ignore
		// them
		Collections.sort(list, (a, b) -> a.compareTo(b));
		
		// Lambda expressions ----------------------------------------------

		// Functional Interfaces -------------------------------------------
		
		Convert<String, Integer> converter = (from) -> Integer.parseInt(from);
		Integer integer = converter.convert("123");
		System.out.println(integer);
		
		// Functional Interfaces -------------------------------------------

		// Method and Constructor References -------------------------------
		// static method reference
		Convert<String, Integer> converter2 = Integer::parseInt;
		Integer integer2 = converter2.convert("123");
		System.out.println(integer2);

		// object reference
		Something something = new Something();
		Convert<String, String> converter3 = something::startsWith;
		String start = converter3.convert("sandeep");
		System.out.println(start);

		// constructor reference
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("Sandeep", "Mekala");
		System.out.println(person.firstName);// bug

		// Method and Constructor References -------------------------------
		
		// Lamda scopes ----------------------------------------------------
		// lamda can access local final variables, instance variables, static
		// variables
		// even if final keyword is not used, it should be effectively final
		final int num = 1;
		Convert<Integer, String> converter4 = (from) -> String.valueOf(num);
		// num =3;

		// same applies for anonymous objects
		int num2 = 2;
		Formula formula = new Formula() {

			@Override
			public double calculate(int a) {
				return a * num2;
			}
		};
		// num2 = 3;

		// Even modify from outer static variables
		Convert<Integer, String> convert4 = (from) -> {
			outerstaticnum = 12;
			return String.valueOf(from);
		};

		// Even modify from outer instance variables
		Convert<Integer, String> convert5 = (from) -> {
			outernum = 12;
			return String.valueOf(from);
		};

		// default methods can not be access from lamda expression but can be
		// accessed from anonymous objects
		// This gives compilation error
		// Formula formula2 = (a) -> sqrt(a);

		// This works fine
		Formula formula2 = new Formula() {

			@Override
			public double calculate(int a) {
				return sqrt(a);
			}
		};
		// Lamda scopes ----------------------------------------------------
		
		// Built-in Functional Interfaces ----------------------------------
		// Predicates - boolean test(arg1)
		// accept one agrument and return boolean
		// interface contains various default methods to compose a complex
		// boolean logic(and, or and negate)
		Predicate<String> predicate = (s) -> s.length() > 0;
		System.out.println(predicate.test("foo"));
		System.out.println(predicate.negate().test("foo"));
		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();

		// Functions - apply
		// takes one/two arg and return one arg
		// default methods can gloue multiple functions together
		Function<String, Integer> stringToInteger = (from) -> Integer.valueOf(from);
		Function<String, String> backToString = stringToInteger.andThen(String::valueOf);
		System.out.println(backToString.apply("233"));

		BiFunction<String, String, String> concat = (s1, s2) -> s1 + s2;
		System.out.println(concat.apply("sandeep", "mekala"));

		// Suppliers - get
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
		
		DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);
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

	// Default Methods for Interfaces --------------------------------------
	// default method
	interface Formula {
		double calculate(int a);

		default double sqrt(int a) {
			return Math.sqrt(a);
		}
	}

	// anonymous object/class
	Formula formula = new Formula() {

		@Override
		public double calculate(int a) {
			return sqrt(a);
		}
	};

	// Default Methods for Interfaces --------------------------------------
	
	// Functional Interfaces --------------------------------------------------
	// function interface
	@FunctionalInterface
	interface Convert<F, T> {
		T convert(F from);
	}

	// Functional Interfaces --------------------------------------------------
	
	// Method and Constructor References --------------------------------------
	// object reference
	class Something {
		public String startsWith(String s) {
			return String.valueOf(s.charAt(0));
		}
	}

	// constructor reference
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

	interface PersonFactory<P extends Person> {
		P create(String firstName, String lastName);
	}
	// Method and Constructor References --------------------------------------
}
