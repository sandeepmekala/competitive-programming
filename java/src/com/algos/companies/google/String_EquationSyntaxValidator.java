package com.algos.companies.google;

public class String_EquationSyntaxValidator {

    public static void main(String[] args) {
        // Test cases
        System.out.println(isValidEquation("a + x = b + (c + a)")); // Valid
        System.out.println(isValidEquation("a + x =")); // Invalid
        System.out.println(isValidEquation("a + -x = a + b")); // Invalid
        System.out.println(isValidEquation("()+a+b = a")); // Invalid
        System.out.println(isValidEquation("(a+b)a = a")); // Valid
    }

    // Problem: https://leetcode.com/discuss/interview-question/5031821/Google-or-Phone-or-Senior-Software-Engineer
    public static boolean isValidEquation(String equation) {
        // Check for the presence of exactly one '='
        if (equation.chars().filter(ch -> ch == '=').count() != 1) {
            return false;
        }

        // Split the equation into LHS and RHS
        String[] parts = equation.split("=");
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            return false;
        }

        String lhs = parts[0];
        String rhs = parts[1];

        // Check for valid characters
        if (!equation.matches("[a-z\\+\\-\\(\\)= ]+")) {
            return false;
        }

        // Validate LHS and RHS expressions
        return isValidExpression(lhs) && isValidExpression(rhs);
    }

    private static boolean isValidExpression(String expression) {
        // Check for balanced parentheses
        int balance = 0;
        char prev = ' ';
        for (char ch : expression.toCharArray()) {
            if (ch == ' ') continue;

            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                balance--;
                if (balance < 0) {
                    return false;
                }
            }

            // Check operators placement
            if (ch == '+' || ch == '-') {
                if (prev == '+' || prev == '-' || prev == '(') {
                    return false;
                }
            } else if (Character.isLetter(ch)) {
                if (prev != ' ' && prev != '+' && prev != '-' && prev != '(') {
                    return false;
                }
            }
            prev = ch;
        }

        // Ensure the last character is not an operator
        if (prev == '+' || prev == '-') {
            return false;
        }

        // Check if all parentheses are closed
        return balance == 0;
    }
}
