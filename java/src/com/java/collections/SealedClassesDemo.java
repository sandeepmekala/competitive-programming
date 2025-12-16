package com.java.collections;

/**
 * Java 17+ Sealed Classes Demonstration
 * Shows how sealed classes provide better type safety and pattern matching
 */
public class SealedClassesDemo {

    public static void main(String[] args) {
        var demo = new SealedClassesDemo();
        demo.demonstrateSealedClasses();
    }

    public void demonstrateSealedClasses() {
        System.out.println("=== Sealed Classes Demo (Java 17+) ===");

        // Create different shapes
        var circle = new Circle(5.0);
        var rectangle = new Rectangle(4.0, 6.0);
        var triangle = new Triangle(3.0, 4.0, 5.0);

        // Process shapes
        processShape(circle);
        processShape(rectangle);
        processShape(triangle);

        // Demonstrate payment processing
        System.out.println("\n--- Payment Processing ---");
        processPayment(new CreditCard("1234-5678-9012-3456", "John Doe"));
        processPayment(new PayPal("john.doe@email.com"));
        processPayment(new BankTransfer("123456789", "SWIFT123"));

        // Demonstrate result handling
        System.out.println("\n--- Result Handling ---");
        var successResult = new Success<>("Operation completed successfully");
        var errorResult = new Error<String>("Network connection failed");

        handleResult(successResult);
        handleResult(errorResult);
    }

    // Sealed class for shapes - only specific implementations allowed
    public sealed interface Shape
            permits Circle, Rectangle, Triangle {
        double area();
        double perimeter();
    }

    // Permitted implementations
    public static final class Circle implements Shape {
        private final double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }

        @Override
        public double perimeter() {
            return 2 * Math.PI * radius;
        }

        public double radius() {
            return radius;
        }

        @Override
        public String toString() {
            return "Circle[radius=" + radius + "]";
        }
    }

    public static final class Rectangle implements Shape {
        private final double width;
        private final double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double area() {
            return width * height;
        }

        @Override
        public double perimeter() {
            return 2 * (width + height);
        }

        public double width() {
            return width;
        }

        public double height() {
            return height;
        }

        @Override
        public String toString() {
            return "Rectangle[width=" + width + ", height=" + height + "]";
        }
    }

    public static final class Triangle implements Shape {
        private final double a, b, c;

        public Triangle(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public double area() {
            // Using Heron's formula
            double s = perimeter() / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }

        @Override
        public double perimeter() {
            return a + b + c;
        }

        public double sideA() { return a; }
        public double sideB() { return b; }
        public double sideC() { return c; }

        @Override
        public String toString() {
            return "Triangle[a=" + a + ", b=" + b + ", c=" + c + "]";
        }
    }

    // Process shapes with exhaustive pattern matching
    private void processShape(Shape shape) {
        // With sealed classes, the compiler knows all possible types
        // This enables exhaustive pattern matching without default case
        var description = switch (shape) {
            case Circle c -> String.format("Circle with radius %.2f", c.radius());
            case Rectangle r -> String.format("Rectangle %.2f x %.2f", r.width(), r.height());
            case Triangle t -> String.format("Triangle with sides %.2f, %.2f, %.2f",
                                           t.sideA(), t.sideB(), t.sideC());
            // No default case needed - compiler knows all cases are covered
        };

        System.out.printf("%s -> Area: %.2f, Perimeter: %.2f%n",
                         description, shape.area(), shape.perimeter());
    }

    // Sealed class for payment methods
    public sealed interface Payment
            permits CreditCard, PayPal, BankTransfer {
        String getPaymentInfo();
    }

    public static record CreditCard(String number, String holderName) implements Payment {
        @Override
        public String getPaymentInfo() {
            return "Credit Card ending in " + number.substring(number.length() - 4);
        }
    }

    public static record PayPal(String email) implements Payment {
        @Override
        public String getPaymentInfo() {
            return "PayPal account: " + email;
        }
    }

    public static record BankTransfer(String accountNumber, String swiftCode) implements Payment {
        @Override
        public String getPaymentInfo() {
            return "Bank Transfer to account: " + accountNumber;
        }
    }

    private void processPayment(Payment payment) {
        var fee = switch (payment) {
            case CreditCard cc -> 2.9; // 2.9% fee
            case PayPal pp -> 3.5;     // 3.5% fee
            case BankTransfer bt -> 1.0; // $1 flat fee
        };

        System.out.printf("Processing %s (Fee: %.1f%%)%n",
                         payment.getPaymentInfo(), fee);
    }

    // Sealed class for result handling (similar to Rust's Result type)
    public sealed interface Result<T>
            permits Success, Error {
    }

    public static record Success<T>(T value) implements Result<T> {}
    public static record Error<T>(String message) implements Result<T> {}

    private <T> void handleResult(Result<T> result) {
        switch (result) {
            case Success<T> success -> {
                System.out.println("Success: " + success.value());
            }
            case Error<T> error -> {
                System.err.println("Error: " + error.message());
            }
        }
    }

    // Sealed class hierarchy for expression evaluation
    public sealed interface Expression
            permits Constant, Addition, Multiplication {
        int evaluate();
    }

    public static record Constant(int value) implements Expression {
        @Override
        public int evaluate() {
            return value;
        }
    }

    public static record Addition(Expression left, Expression right) implements Expression {
        @Override
        public int evaluate() {
            return left.evaluate() + right.evaluate();
        }
    }

    public static record Multiplication(Expression left, Expression right) implements Expression {
        @Override
        public int evaluate() {
            return left.evaluate() * right.evaluate();
        }
    }

    // Example usage of expression evaluation
    public void demonstrateExpressions() {
        System.out.println("\n--- Expression Evaluation ---");

        // (2 + 3) * 4
        var expr = new Multiplication(
                new Addition(new Constant(2), new Constant(3)),
                new Constant(4)
        );

        System.out.println("Expression result: " + expr.evaluate()); // 20

        // Pretty print expression
        System.out.println("Expression: " + prettyPrint(expr));
    }

    private String prettyPrint(Expression expr) {
        return switch (expr) {
            case Constant c -> String.valueOf(c.value());
            case Addition a -> "(" + prettyPrint(a.left()) + " + " + prettyPrint(a.right()) + ")";
            case Multiplication m -> "(" + prettyPrint(m.left()) + " * " + prettyPrint(m.right()) + ")";
        };
    }
}
