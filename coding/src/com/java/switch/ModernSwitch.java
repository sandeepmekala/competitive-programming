package com.java.switch;

/**
 * Java 21 Modern Switch Features Demo
 * This file demonstrates the latest switch features available in Java 21
 */
public class ModernSwitch {

    public static void main(String[] args) {
        var demo = new ModernSwitch();
        demo.demonstrateBasicSwitch();
        demo.demonstrateTextBlocks();
        demo.demonstrateRecords();
    }

    // Basic switch expressions (Java 14+)
    public void demonstrateBasicSwitch() {
        System.out.println("=== Basic Switch Expressions ===");

        // Arrow syntax
        var result1 = switch (1) {
            case 1 -> "One";
            case 2 -> "Two";
            default -> "Other";
        };
        System.out.println("Arrow syntax result: " + result1);

        // Yield syntax for complex logic
        var result2 = switch (2) {
            case 1 -> {
                System.out.println("Processing case 1");
                yield "First";
            }
            case 2 -> {
                System.out.println("Processing case 2");
                yield "Second";
            }
            default -> {
                System.out.println("Processing default");
                yield "Default";
            }
        };
        System.out.println("Yield syntax result: " + result2);
    }

    // Text blocks (Java 15+)
    public void demonstrateTextBlocks() {
        System.out.println("\n=== Text Blocks ===");

        var jsonExample = """
                {
                    "name": "John Doe",
                    "age": 30,
                    "city": "New York",
                    "skills": ["Java", "Python", "JavaScript"]
                }
                """;

        System.out.println("JSON Text Block:");
        System.out.println(jsonExample);

        var sqlQuery = """
                SELECT u.name, u.email, p.title
                FROM users u
                JOIN posts p ON u.id = p.user_id
                WHERE u.active = true
                ORDER BY p.created_at DESC
                LIMIT 10
                """;

        System.out.println("SQL Text Block:");
        System.out.println(sqlQuery);
    }

    // Records (Java 14+)
    public void demonstrateRecords() {
        System.out.println("\n=== Records ===");

        // Simple record
        record Person(String name, int age) {
            // Compact constructor for validation
            public Person {
                if (age < 0) {
                    throw new IllegalArgumentException("Age cannot be negative");
                }
            }

            // Additional methods
            public boolean isAdult() {
                return age >= 18;
            }
        }

        var person = new Person("Alice", 25);
        System.out.println("Person: " + person);
        System.out.println("Name: " + person.name());
        System.out.println("Age: " + person.age());
        System.out.println("Is Adult: " + person.isAdult());

        // Record with switch - Java 17 compatible
        var age = person.age();
        var ageCategory = age < 13 ? "Child" :
                         age < 20 ? "Teenager" :
                         age < 65 ? "Adult" : "Senior";
        System.out.println("Age Category: " + ageCategory);
    }
}
