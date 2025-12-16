package com.java.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Modern Java 21 Stream API Features
 * Demonstrates the latest stream operations and patterns
 */
public class ModernStreams {

    public static void main(String[] args) {
        var demo = new ModernStreams();
        demo.demonstrateModernStreamFeatures();
    }

    public void demonstrateModernStreamFeatures() {
        System.out.println("=== Modern Stream API Features (Java 9-21) ===");

        // Java 9: takeWhile and dropWhile
        demonstrateTakeWhileDropWhile();

        // Java 9: ofNullable
        demonstrateOfNullable();

        // Java 10: orElseThrow() without parameter
        demonstrateOrElseThrow();

        // Java 16: toList() - more convenient than collect(Collectors.toList())
        demonstrateToList();

        // Java 16: mapMulti
        demonstrateMapMulti();

        // Modern patterns with records
        demonstrateStreamWithRecords();

        // Text blocks with streams
        demonstrateTextBlocksWithStreams();
    }

    // Java 9: takeWhile and dropWhile
    private void demonstrateTakeWhileDropWhile() {
        System.out.println("\n--- takeWhile and dropWhile (Java 9) ---");

        var numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // takeWhile - takes elements while condition is true
        var takeResult = numbers.stream()
                .takeWhile(n -> n < 6)
                .toList();
        System.out.println("takeWhile(n < 6): " + takeResult); // [1, 2, 3, 4, 5]

        // dropWhile - drops elements while condition is true
        var dropResult = numbers.stream()
                .dropWhile(n -> n < 6)
                .toList();
        System.out.println("dropWhile(n < 6): " + dropResult); // [6, 7, 8, 9, 10]

        // Practical example: processing log entries
        var logEntries = List.of(
                "INFO: Application started",
                "DEBUG: Loading configuration",
                "INFO: Database connected",
                "ERROR: Connection failed",
                "INFO: Retrying connection",
                "INFO: Application ready"
        );

        var beforeError = logEntries.stream()
                .takeWhile(entry -> !entry.startsWith("ERROR"))
                .toList();
        System.out.println("Entries before error: " + beforeError);

        var afterError = logEntries.stream()
                .dropWhile(entry -> !entry.startsWith("ERROR"))
                .toList();
        System.out.println("Entries from error onwards: " + afterError);
    }

    // Java 9: ofNullable
    private void demonstrateOfNullable() {
        System.out.println("\n--- Stream.ofNullable (Java 9) ---");

        String nullableValue = null;
        String nonNullValue = "Hello";

        // Old way - had to check for null
        var oldWay = new ArrayList<String>();
        if (nullableValue != null) {
            oldWay.add(nullableValue);
        }
        if (nonNullValue != null) {
            oldWay.add(nonNullValue);
        }

        // New way - Stream.ofNullable
        var newWay = Stream.of(nullableValue, nonNullValue)
                .flatMap(Stream::ofNullable)
                .toList();

        System.out.println("Old way result: " + oldWay);
        System.out.println("New way result: " + newWay);

        // Practical example: filtering configuration values
        record Config(String database, String cache, String logging) {}

        var config = new Config("postgresql://localhost", null, "debug");

        var activeServices = Stream.of(config.database(), config.cache(), config.logging())
                .flatMap(Stream::ofNullable)
                .toList();

        System.out.println("Active services: " + activeServices);
    }

    // Java 10: orElseThrow() without parameter
    private void demonstrateOrElseThrow() {
        System.out.println("\n--- orElseThrow() without parameter (Java 10) ---");

        var numbers = List.of(1, 2, 3, 4, 5);

        // Java 10: cleaner syntax
        var max = numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(); // Throws NoSuchElementException

        System.out.println("Maximum value: " + max);

        // Practical example with custom message
        var emptyList = List.<String>of();
        try {
            var first = emptyList.stream()
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("List cannot be empty"));
        } catch (IllegalStateException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    // Java 16: toList()
    private void demonstrateToList() {
        System.out.println("\n--- toList() method (Java 16) ---");

        var words = List.of("java", "stream", "api", "modern", "features");

        // Old way
        var oldWay = words.stream()
                .filter(word -> word.length() > 3)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        // New way - more concise
        var newWay = words.stream()
                .filter(word -> word.length() > 3)
                .map(String::toUpperCase)
                .toList();

        System.out.println("Old way: " + oldWay);
        System.out.println("New way: " + newWay);
        System.out.println("Results are equal: " + oldWay.equals(newWay));
    }

    // Java 16: mapMulti
    private void demonstrateMapMulti() {
        System.out.println("\n--- mapMulti operation (Java 16) ---");

        var numbers = List.of(1, 2, 3, 4, 5);

        // mapMulti allows you to produce multiple elements for each input element
        var expanded = numbers.stream()
                .<String>mapMulti((number, consumer) -> {
                    consumer.accept("num: " + number);
                    consumer.accept("square: " + (number * number));
                    if (number % 2 == 0) {
                        consumer.accept("even: " + number);
                    }
                })
                .toList();

        System.out.println("Expanded results:");
        expanded.forEach(System.out::println);

        // Practical example: flattening nested structures
        record Department(String name, List<String> employees) {}

        var departments = List.of(
                new Department("Engineering", List.of("Alice", "Bob", "Charlie")),
                new Department("Marketing", List.of("David", "Eve")),
                new Department("Sales", List.of("Frank"))
        );

        var allEmployees = departments.stream()
                .<String>mapMulti((dept, consumer) ->
                    dept.employees().forEach(consumer))
                .toList();

        System.out.println("All employees: " + allEmployees);
    }

    // Modern patterns with records
    private void demonstrateStreamWithRecords() {
        System.out.println("\n--- Streams with Records ---");

        record Employee(String name, String department, int salary, boolean isRemote) {
            public boolean isHighEarner() {
                return salary > 75000;
            }
        }

        var employees = List.of(
                new Employee("Alice", "Engineering", 85000, true),
                new Employee("Bob", "Engineering", 72000, false),
                new Employee("Charlie", "Marketing", 68000, true),
                new Employee("David", "Sales", 78000, false),
                new Employee("Eve", "Engineering", 92000, true)
        );

        // Complex stream operations with records
        var highEarningRemoteEngineers = employees.stream()
                .filter(emp -> "Engineering".equals(emp.department()))
                .filter(Employee::isRemote)
                .filter(Employee::isHighEarner)
                .map(Employee::name)
                .toList();

        System.out.println("High-earning remote engineers: " + highEarningRemoteEngineers);

        // Grouping with records
        var salaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.averagingInt(Employee::salary)
                ));

        System.out.println("Average salary by department:");
        salaryByDepartment.forEach((dept, avgSalary) ->
                System.out.printf("  %s: $%.2f%n", dept, avgSalary));
    }

    // Text blocks with streams
    private void demonstrateTextBlocksWithStreams() {
        System.out.println("\n--- Text Blocks with Streams ---");

        var csvData = """
                name,age,city
                Alice,30,New York
                Bob,25,San Francisco
                Charlie,35,Chicago
                David,28,Boston
                """;

        record Person(String name, int age, String city) {}

        var people = csvData.lines()
                .skip(1) // Skip header
                .filter(line -> !line.trim().isEmpty())
                .map(line -> line.split(","))
                .map(parts -> new Person(
                        parts[0].trim(),
                        Integer.parseInt(parts[1].trim()),
                        parts[2].trim()
                ))
                .toList();

        System.out.println("Parsed people:");
        people.forEach(System.out::println);

        // SQL-like query using text blocks
        var sqlQuery = """
                SELECT name, age, city
                FROM people
                WHERE age > 25
                ORDER BY age DESC
                """;

        System.out.println("SQL Query:");
        System.out.println(sqlQuery);

        // Simulate the query with streams
        var queryResult = people.stream()
                .filter(person -> person.age() > 25)
                .sorted((p1, p2) -> Integer.compare(p2.age(), p1.age()))
                .toList();

        System.out.println("Query result:");
        queryResult.forEach(person ->
                System.out.printf("  %s, %d, %s%n",
                        person.name(), person.age(), person.city()));
    }
}
