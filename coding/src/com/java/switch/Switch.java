package com.java.switchyield;

public class Switchyield {
    public static void main(String[] args) {

        // Switch with arrow
        String result1 = switch (1) {
            case 1 -> "Case1";
            case 2 -> "Case2";
            default -> "Default";
        };

        System.out.println(result1);

        // Switch with yield
        String result2 = switch (1) {
            case 1 -> {
                yield "Case1";
            }
            case 2 -> {
                yield "Case2";
            }
            default -> {
                yield "Default";
            }
        };

        System.out.println(result2);
    }
}
