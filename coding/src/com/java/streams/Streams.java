package com.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.StringJoiner;
import java.util.UUID;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Different kind of streams
// Processing Order
// Why order matters
// Reusing Streams
// Advanced Operations:
// 		Collect
// 		FlatMap
// 		Reduce
// Parallel Streams
public class Streams {
	public static void main(String args[]) {
		Streams streams = new Streams();
		streams.start();
	}

	public void start() {
		// Operations pipeline are non-interfearing and stateless
		List<String> list = Arrays.asList("a1", "a2", "b1", "c2", "c1");

		list
			.stream()
			.filter(s -> s.startsWith("c"))
			.map(String::toUpperCase)
			.sorted()
			.forEach(System.out::println);

		// Start: Different kind of streams ------------------------------
		// We don't have to create collection to work with streams.
		// Streams can be created from a bunch of object references
		Arrays.asList("a1", "a2", "a3")
				.stream()
				.findFirst()
				.ifPresent(System.out::println); // a1

		Stream.of("a1", "a2", "a3")
				.findFirst()
				.ifPresent(System.out::println); // a1

		// Primitive streams
		// Works with specialized lambda expressions like IntFunction, IntPredicate etc
		// Supports addition terminal aggregation functions like sum, average etc.
		printBorder();
		IntStream.range(1, 4)
				.forEach(System.out::println);

		printBorder();
		// Average
		Arrays.stream(new int[] { 1, 2, 3 })
				.map(n -> 2 * n + 1)
				.average()
				.ifPresent(System.out::println); // 5.0

		// Map object steam to int stream
		Stream.of("a1", "a2", "a3")
				.map(s -> s.substring(1))
				.mapToInt(Integer::parseInt)
				.max()
				.ifPresent(System.out::println); // 3

		// Map int steam to object stream
		IntStream.range(1, 4)
				.mapToObj(i -> "a" + i)
				.forEach(System.out::println);

		// Double stream -> int stream -> object stream
		Stream.of(1.0, 2.0, 3.0)
				.mapToInt(Double::intValue)
				.mapToObj(i -> "a" + i)
				.forEach(System.out::println);

		// End: Different kind of streams ------------------------------

		// Start: Processing Order ------------------------------
		// Intermediate operations are lazy. They are executed only when terminal
		// operation is present.
		printBorder();
		Stream.of("d2", "a2", "b1", "b3", "c")
				.filter(s -> {
					System.out.println("filter: " + s);
					return true;
				});

		// Each element moves along the chain vertically instead of executing operations
		// horizontally on all elements
		Stream.of("d2", "a2", "b1", "b3", "c")
				.filter(s -> {
					System.out.println("filter: " + s);
					return true;
				})
				.forEach(s -> System.out.println("forEach: " + s));

		printBorder();
		// This behavoiur reduces the actual number of operations performed on each
		// element
		Stream.of("d2", "a2", "b1", "b3", "c")
				.map(s -> {
					System.out.println("map: " + s);
					return s.toUpperCase();
				})
				.anyMatch(s -> {
					System.out.println("anyMatch: " + s);
					return s.startsWith("A");
				});
		// End: Processing Order ------------------------------

		// Start: Why order matters ------------------------------
		printBorder();
		Stream.of("d2", "a2", "b1", "b3", "c")
				.map(s -> {
					System.out.println("map: " + s);
					return s.toUpperCase();
				})
				.filter(s -> {
					System.out.println("filter: " + s);
					return s.startsWith("A");
				})
				.forEach(s -> System.out.println("forEach: " + s));

		// By changing the order of chain operations(filter and map) reduces the
		// executions
		printBorder();
		Stream.of("d2", "a2", "b1", "b3", "c")
				.filter(s -> {
					System.out.println("filter: " + s);
					return s.startsWith("a");
				})
				.map(s -> {
					System.out.println("map: " + s);
					return s.toUpperCase();
				})
				.forEach(s -> System.out.println("forEach: " + s));

		// Adding another intermediate operation sorted
		printBorder();
		// Sorted is stateful operation as it while sorting elements
		// It executes horizontally on the entire collection
		Stream.of("d2", "a2", "b1", "b3", "c")
				.sorted((s1, s2) -> {
					System.out.printf("sort: %s; %s\n", s1, s2);
					return s1.compareTo(s2);
				})
				.filter(s -> {
					System.out.println("filter: " + s);
					return s.startsWith("a");
				})
				.map(s -> {
					System.out.println("map: " + s);
					return s.toUpperCase();
				})
				.forEach(s -> System.out.println("forEach: " + s));

		printBorder();
		// Moving sorted down the chain
		Stream.of("d2", "a2", "b1", "b3", "c")
				.filter(s -> {
					System.out.println("filter: " + s);
					return s.startsWith("a");
				})
				.sorted((s1, s2) -> {
					System.out.printf("sort: %s; %s\n", s1, s2);
					return s1.compareTo(s2);
				})
				.map(s -> {
					System.out.println("map: " + s);
					return s.toUpperCase();
				})
				.forEach(s -> System.out.println("forEach: " + s));
		// End: Why order matters ------------------------------

		// Start: Reusing Streams ------------------------------
		// Streams can not be re-used. As soon as you call any terminal operation,
		// stream will be closed
		Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c")
				.filter(s -> s.startsWith("a"));

		stream.anyMatch(s -> true); // ok
		// stream.noneMatch(s -> true); // exception

		// To overcome this we could create a stream supplier to construct a new stream
		// with all intermediate operations already set up.
		// Each call to get() constructs a new stream
		Supplier<Stream<String>> streamSupplier = () -> Stream.of("d2", "a2", "b1", "b3", "c")
				.filter(s -> s.startsWith("a"));

		streamSupplier.get().anyMatch(s -> true); // ok
		streamSupplier.get().noneMatch(s -> true); // ok
		// End: Reusing Streams ------------------------------

		// Start: Advanced Operations ------------------------------
		printBorder();
		List<Person> persons = Arrays.asList(
				new Person("Max", 18),
				new Person("Peter", 23),
				new Person("Pamela", 23),
				new Person("David", 12));

		// Collect
		List<Person> filtered = persons
				.stream()
				.filter(p -> p.name.startsWith("P"))
				.collect(Collectors.toList());

		System.out.println(filtered); // [Peter, Pamela]

		// groupingBy
		Map<Integer, List<Person>> personsByAge = persons
				.stream()
				.collect(Collectors.groupingBy(p -> p.age));

		personsByAge
				.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

		// Averaging
		Double averageAge = persons
				.stream()
				.collect(Collectors.averagingInt(p -> p.age));

		System.out.println(averageAge); // 19.0

		// summarizingInt
		IntSummaryStatistics ageSummary = persons
				.stream()
				.collect(Collectors.summarizingInt(p -> p.age));

		System.out.println(ageSummary);

		// joining
		String phrase = persons
				.stream()
				.filter(p -> p.age >= 18)
				.map(p -> p.name)
				.collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

		System.out.println(phrase);

		// toMap
		Map<Integer, String> map = persons
				.stream()
				.collect(Collectors.toMap(
						p -> p.age,
						p -> p.name,
						(name1, name2) -> name1 + ";" + name2));

		System.out.println(map);

		// customer collector
		Collector<Person, StringJoiner, String> personNameCollector = Collector.of(
				() -> new StringJoiner(" | "), // supplier
				(j, p) -> j.add(p.name.toUpperCase()), // accumulator
				(j1, j2) -> j1.merge(j2), // combiner
				StringJoiner::toString); // finisher

		String names = persons
				.stream()
				.collect(personNameCollector);

		System.out.println(names); // MAX | PETER | PAMELA | DAVID

		printBorder();
		// FlatMap
		// Transforms each element of the stream into a stream of other objects
		List<Foo> foos = new ArrayList<>();

		// create foos
		IntStream
				.range(1, 4)
				.forEach(i -> foos.add(new Foo("Foo" + i)));

		// create bars
		foos.forEach(f -> IntStream
				.range(1, 4)
				.forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));

		foos.stream()
				.flatMap(f -> f.bars.stream())
				.forEach(b -> System.out.println(b.name));

		// simplified version of above code
		//  IntStream.range(1, 4)
		//  .mapToObj(i -> new Foo("Foo" + i))
		//  .peek(f -> IntStream.range(1, 4)
		//  .mapToObj(i -> new Bar("Bar" + i + " <- " f.name))
		//  .forEach(f.bars::add))
		//  .flatMap(f -> f.bars.stream())
		//  .forEach(b -> System.out.println(b.name));


		// FlatMap is also available for the Optional
		// nasty way to access foo with multiple null checks
		Outer outer = new Outer();
		if (outer != null && outer.nested != null && outer.nested.inner != null) {
			System.out.println(outer.nested.inner.foo);
		}
		// Better way using flatMap
		Optional.of(outer)
				.flatMap(o -> Optional.ofNullable(o.nested))
				.flatMap(n -> Optional.ofNullable(n.inner))
				.flatMap(i -> Optional.ofNullable(i.foo))
				.ifPresent(System.out::println);

		printBorder();
		// Reduce
		// Three types of reduce operations are there
		// First type
		persons
				.stream()
				.reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
				.ifPresent(System.out::println); // Pamela

		// Second type
		Person result = persons
				.stream()
				.reduce(new Person("", 0), (p1, p2) -> {
					p1.age += p2.age;
					p1.name += p2.name;
					return p1;
				});

		System.out.format("name=%s; age=%s", result.name, result.age);
		System.out.println();
		// Third type
		// Identity type can be any thing
		Integer ageSum = persons
				.stream()
				.reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);

		System.out.println(ageSum); // 76

		// But why both accumulator and combiner
		// Combiner is never called
		Integer ageSum2 = persons
				.stream()
				.reduce(0,
						(sum, p) -> {
							System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
							return sum += p.age;
						},
						(sum1, sum2) -> {
							System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
							return sum1 + sum2;
						});
		System.out.println(ageSum2);
		// Combiner will be used when called in parallel to combine multiple accumulor
		// values
		Integer ageSum3 = persons
				.parallelStream()
				.reduce(0,
						(sum, p) -> {
							System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
							return sum += p.age;
						},
						(sum1, sum2) -> {
							System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
							return sum1 + sum2;
						});
		System.out.println(ageSum3);
		// End: Advanced Operations ------------------------------

		printBorder();
		// Start: Parallel Streams ------------------------------
		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		System.out.println(commonPool.getParallelism()); // 3

		Arrays.asList("a1", "a2", "b1", "c2", "c1")
				.parallelStream()
				.filter(s -> {
					System.out.format("filter: %s [%s]\n",
							s, Thread.currentThread().getName());
					return true;
				})
				.map(s -> {
					System.out.format("map: %s [%s]\n",
							s, Thread.currentThread().getName());
					return s.toUpperCase();
				})
				.forEach(s -> System.out.format("forEach: %s [%s]\n",
						s, Thread.currentThread().getName()));

		printBorder();
		// Extend stream operation with sort
		// Sort looks like executed on a single thread
		// But in parallel stream sort uses Arrays.parallelSort()
		// parallelSort method decides based on the length of the array whether to use
		// sequential sort or parallel sort
		Arrays.asList("a1", "a2", "b1", "c2", "c1")
				.parallelStream()
				.filter(s -> {
					System.out.format("filter: %s [%s]\n",
							s, Thread.currentThread().getName());
					return true;
				})
				.map(s -> {
					System.out.format("map: %s [%s]\n",
							s, Thread.currentThread().getName());
					return s.toUpperCase();
				})
				.sorted((s1, s2) -> {
					System.out.format("sort: %s <> %s [%s]\n",
							s1, s2, Thread.currentThread().getName());
					return s1.compareTo(s2);
				})
				.forEach(s -> System.out.format("forEach: %s [%s]\n",
						s, Thread.currentThread().getName()));
		// End: Parallel Streams ------------------------------



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
		Set<String> set = stringCollection.stream().collect(Collectors.toSet());
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

	}

	private void printBorder() {
		System.out.println("--------------------------------------------------------");
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

class Foo {
	String name;
	List<Bar> bars = new ArrayList<>();

	Foo(String name) {
		this.name = name;
	}
}

class Bar {
	String name;

	Bar(String name) {
		this.name = name;
	}
}

class Outer {
	Nested nested;
}

class Nested {
	Inner inner;
}

class Inner {
	String foo;
}
