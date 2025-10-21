package com.java.switch;

public class BasicSwitch {
    public static void main(String[] args) {
        var switchDemo = new BasicSwitch();
        switchDemo.demonstrateModernSwitch();
    }

    public void demonstrateModernSwitch() {
        // Modern switch expressions (Java 14+)
        var result1 = switch (1) {
            case 1 -> "Case1";
            case 2 -> "Case2";
            default -> "Default";
        };
        System.out.println("Arrow syntax: " + result1);

        // Switch with yield (Java 14+)
        var result2 = switch (1) {
            case 1 -> {
                System.out.println("Processing case 1");
                yield "Case1";
            }
            case 2 -> {
                System.out.println("Processing case 2");
                yield "Case2";
            }
            default -> {
                System.out.println("Processing default");
                yield "Default";
            }
        };
        System.out.println("Yield syntax: " + result2);

        // Java 21: Pattern matching with switch
        demonstratePatternMatching();

        // Java 21: Guard conditions in switch
        demonstrateGuardConditions();
    }

    // Java 21: Pattern matching for switch with guard conditions
    public void demonstratePatternMatching() {
        Object obj = "Hello World";

        var result = switch (obj) {
            case String s when s.length() > 5 -> "Long string: " + s;
            case String s -> "Short string: " + s;
            case Integer i when i > 0 -> "Positive integer: " + i;
            case Integer i -> "Non-positive integer: " + i;
            case null -> "Null value";
            default -> "Unknown type: " + obj.getClass().getSimpleName();
        };

        System.out.println("Pattern matching result: " + result);
    }

    // Java 21: Guard conditions in switch with record patterns
    public void demonstrateGuardConditions() {
        record Point(int x, int y) {}

        var point = new Point(3, 4);

        // Using traditional approach for better compatibility
        String quadrant;
        if (point.x() > 0 && point.y() > 0) {
            quadrant = "First quadrant";
        } else if (point.x() < 0 && point.y() > 0) {
            quadrant = "Second quadrant";
        } else if (point.x() < 0 && point.y() < 0) {
            quadrant = "Third quadrant";
        } else if (point.x() > 0 && point.y() < 0) {
            quadrant = "Fourth quadrant";
        } else if (point.x() == 0 && point.y() != 0) {
            quadrant = "On Y-axis";
        } else if (point.x() != 0 && point.y() == 0) {
            quadrant = "On X-axis";
        } else {
            quadrant = "Origin";
        }

        System.out.println("Point " + point + " is in: " + quadrant);
    }
}
