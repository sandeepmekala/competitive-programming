# Java Basics 3

## Table of Contents

### Part 1 | Java Reflection in Depth
- [1. Introduction to Java Reflection](#1-introduction-to-java-reflection)
- [2. Getting Class Object Using Reflection](#2-getting-class-object-using-reflection)
  - [2.1 Ways to Get Class Object](#ways-to-get-class-object)
- [3. Getting All Methods of a Class](#3-getting-all-methods-of-a-class)
  - [3.1 Example: Get All Methods of a Class](#example-get-all-methods-of-a-class)
- [4. Getting All Fields of a Class](#4-getting-all-fields-of-a-class)
  - [4.1 Example: Get All Fields](#example-get-all-fields)
- [5. Getting Return Type of a Method](#5-getting-return-type-of-a-method)
  - [5.1 Example: Get Return Type](#example-get-return-type)
- [6. Getting Modifiers of a Class](#6-getting-modifiers-of-a-class)
  - [6.1 Example: Get Class Modifiers](#example-get-class-modifiers)
- [7. Getting Implemented Interfaces](#7-getting-implemented-interfaces)
  - [7.1 Example: Get Implemented Interfaces](#example-get-implemented-interfaces)
- [8. Changing Private and Public Field Values](#8-changing-private-and-public-field-values)
  - [8.1 Example: Changing Field Value](#example-changing-field-value)
- [9. Calling Private Methods Using Reflection](#9-calling-private-methods-using-reflection)
  - [9.1 Example: Invoke a Private Method](#example-invoke-a-private-method)
- [10. Summary](#10-summary)
- [11. When to Use Reflection (And When Not To)](#11-when-to-use-reflection-and-when-not-to)

### Part 2 | Java Annotations - Complete Guide
- [1. What are Java Annotations?](#1-what-are-java-annotations)
- [2. Built-in Java Annotations](#2-built-in-java-annotations)
  - [2.1 Compiler Annotations (Checked at Compile Time)](#a-compiler-annotations-checked-at-compile-time)
  - [2.2 Runtime Annotations (Available at Runtime)](#b-runtime-annotations-available-at-runtime)
- [3. Creating Custom Annotations](#3-creating-custom-annotations)
  - [3.1 Example: Custom Annotation](#example-custom-annotation)
- [4. Retrieving Annotations Using Reflection](#4-retrieving-annotations-using-reflection)
  - [4.1 Example: Reading Custom Annotation at Runtime](#example-reading-custom-annotation-at-runtime)
- [5. Meta-Annotations in Java](#5-meta-annotations-in-java)
  - [5.1 Example: Using Meta-Annotations](#example-using-meta-annotations)
- [6. Built-in Java 8+ Annotations](#6-built-in-java-8-annotations)
  - [6.1 @Repeatable Annotation](#a-repeatable-annotation-multiple-instances-of-same-annotation)
  - [6.2 Java 8 Type Annotations](#b-java-8-type-annotations-targetelementtypetype_use)
- [7. Real-World Applications of Annotations](#7-real-world-applications-of-annotations)
  - [7.1 Annotations in JUnit](#a-annotations-in-junit)
  - [7.2 Annotations in Spring](#b-annotations-in-spring-dependency-injection)
- [8. Summary](#8-summary)

### Part 3 | Exception Handling in Java
- [1. What is Exception Handling in Java?](#1-what-is-exception-handling-in-java)
- [2. Types of Exceptions in Java](#2-types-of-exceptions-in-java)
  - [2.1 Checked Exceptions](#a-checked-exceptions-compile-time-exceptions)
  - [2.2 Unchecked Exceptions](#b-unchecked-exceptions-runtime-exceptions)
  - [2.3 Errors](#c-errors-serious-issues)
- [3. Java Exception Hierarchy](#3-java-exception-hierarchy)
- [4. Exception Handling Mechanisms](#4-exception-handling-mechanisms)
  - [4.1 Using try-catch Block](#a-using-try-catch-block)
  - [4.2 Using Multiple Catch Blocks](#b-using-multiple-catch-blocks)
  - [4.3 Using finally Block](#c-using-finally-block-always-executes)
  - [4.4 Using throw Keyword](#d-using-throw-keyword-manually-throw-exception)
  - [4.5 Using throws Keyword](#e-using-throws-keyword-method-level-exception-handling)
- [5. Custom Exceptions](#5-custom-exceptions)
  - [5.1 Example: Creating a Custom Exception](#example-creating-a-custom-exception)
- [6. Best Practices for Exception Handling](#6-best-practices-for-exception-handling)
- [7. Summary](#7-summary)

### Part 4 | Operators in Java
- [1. What are Operators in Java?](#1-what-are-operators-in-java)
- [2. Types of Operators in Java](#2-types-of-operators-in-java)
- [3. Arithmetic Operators](#3-arithmetic-operators-perform-mathematical-operations)
  - [3.1 Example: Arithmetic Operators](#example-arithmetic-operators)
- [4. Relational (Comparison) Operators](#4-relational-comparison-operators)
  - [4.1 Example: Relational Operators](#example-relational-operators)
- [5. Logical Operators](#5-logical-operators)
  - [5.1 Example: Logical Operators](#example-logical-operators)
- [6. Bitwise Operators](#6-bitwise-operators-work-on-bits)
- [7. Assignment Operators](#7-assignment-operators)
  - [7.1 Example: Assignment Operators](#example-assignment-operators)
- [8. Unary Operators](#8-unary-operators)
- [9. Ternary Operator](#9-ternary-operator-condition--truevalue--falsevalue)
- [10. instanceof Operator](#10-instanceof-operator)
- [11. Type Cast Operator](#11-type-cast-operator)
- [12. Operator Precedence Table in Java](#12-operator-precedence-table-in-java)

### Part 5 | Control Flow Statements in Java
- [1. Decision-Making Statements](#1-decision-making-statements)
  - [1.1 if-else Statement](#11-if-else-statement)
  - [1.2 if-else-if Ladder](#12-if-else-if-ladder)
  - [1.3 Switch Statement](#13-switch-statement)
- [2. Looping Statements](#2-looping-statements)
  - [2.1 for Loop](#21-for-loop)
  - [2.2 while Loop](#22-while-loop)
  - [2.3 do-while Loop](#23-do-while-loop)
- [3. Branching Statements](#3-branching-statements)
  - [3.1 break Statement](#31-break-statement)
  - [3.2 continue Statement](#32-continue-statement)
  - [3.3 return Statement](#33-return-statement)

### Part 6 | Lombok Features in Java
- [1. val and var](#-1-val-and-var)
- [2. @NonNull](#-2-nonnull)
- [3. @Getter and @Setter](#-3-getter-and-setter)
- [4. @ToString](#-4-tostring)
- [5. @NoArgsConstructor, @AllArgsConstructor, @RequiredArgsConstructor](#-5-noargsconstructor-allargsconstructor-requiredargsconstructor)
- [6. @EqualsAndHashCode](#-6-equalsandhashcode)
- [7. @Data](#-7-data)
- [8. @Value](#-8-value)
- [9. @Builder](#-9-builder)
- [10. @Cleanup](#-10-cleanup)

### Part 7 | Java 17: Sealed Classes and Interfaces
- [🔑 Key Concept](#-key-concept)
- [🚀 How It Works](#-how-it-works)
- [⚖️ Rules for Subclasses](#️-rules-for-subclasses)
- [📌 Important Conditions](#-important-conditions)
- [🧩 Example Hierarchy](#-example-hierarchy)
- [✅ Benefits](#-benefits)

---

# Java Reflection in Depth (With Examples)

## 1. Introduction to Java Reflection

Java **Reflection** is a powerful feature that allows us to **inspect and manipulate classes, methods, fields, and constructors at runtime**. It is part of the **`java.lang.reflect`** package.

### Why Use Reflection?

✔ Used in **frameworks** (Spring, Hibernate, JUnit, etc.)
✔ Helps in **analyzing classes, methods, and fields** dynamically
✔ Useful for **dependency injection and debugging**
✔ Allows accessing **private fields and methods**

---

## 2. Getting Class Object Using Reflection

Before using Reflection, we need to get the `Class` object of a class.

### Ways to Get `Class` Object

```java
class Example { }

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1. Using Class.forName()
        Class<?> c1 = Class.forName("Example");

        // 2. Using .class
        Class<?> c2 = Example.class;

        // 3. Using getClass() method on an object
        Example obj = new Example();
        Class<?> c3 = obj.getClass();

        System.out.println(c1 == c2); // true
        System.out.println(c2 == c3); // true
    }
}
```

✔ **All three approaches return the same `Class` object.**

---

## 3. Getting All Methods of a Class

We can use `getDeclaredMethods()` or `getMethods()` to retrieve methods of a class.

### Example: Get All Methods of a Class

```java
import java.lang.reflect.Method;

class Example {
    public void method1() {}
    private void method2() {}
}

public class Main {
    public static void main(String[] args) {
        Class<?> clazz = Example.class;
        Method[] methods = clazz.getDeclaredMethods(); // Gets all methods (public + private)

        System.out.println("Methods in Example class:");
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}
```

✔ `getDeclaredMethods()` gets **all methods** (including private ones).
✔ `getMethods()` gets **only public methods**, including inherited ones.

---

## 4. Getting All Fields of a Class

We can inspect all fields (variables) of a class using `getDeclaredFields()`.

### Example: Get All Fields

```java
import java.lang.reflect.Field;

class Example {
    public int publicField;
    private String privateField;
}

public class Main {
    public static void main(String[] args) {
        Class<?> clazz = Example.class;
        Field[] fields = clazz.getDeclaredFields();

        System.out.println("Fields in Example class:");
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }
}
```

✔ `getDeclaredFields()` returns **all fields**, including private ones.
✔ `getFields()` returns **only public fields**.

---

## 5. Getting Return Type of a Method

The return type of a method can be determined using `getReturnType()`.

### Example: Get Return Type

```java
import java.lang.reflect.Method;

class Example {
    public String getMessage() { return "Hello"; }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Example.class;
        Method method = clazz.getDeclaredMethod("getMessage");

        System.out.println("Return Type: " + method.getReturnType().getName());
    }
}
```

✔ The `getReturnType()` method returns the **return type** of the method.

---

## 6. Getting Modifiers of a Class

The **modifiers** (public, private, abstract, final, etc.) of a class can be determined using `getModifiers()`.

### Example: Get Class Modifiers

```java
import java.lang.reflect.Modifier;

abstract class Example { }

public class Main {
    public static void main(String[] args) {
        Class<?> clazz = Example.class;
        int modifiers = clazz.getModifiers();

        System.out.println("Is Abstract? " + Modifier.isAbstract(modifiers));
        System.out.println("Is Public? " + Modifier.isPublic(modifiers));
    }
}
```

✔ `Modifier.isAbstract(modifiers)` checks if the class is **abstract**.
✔ `Modifier.isPublic(modifiers)` checks if the class is **public**.

---

## 7. Getting Implemented Interfaces

We can get the list of interfaces implemented by a class using `getInterfaces()`.

### Example: Get Implemented Interfaces

```java
interface A { }
interface B { }

class Example implements A, B { }

public class Main {
    public static void main(String[] args) {
        Class<?> clazz = Example.class;
        Class<?>[] interfaces = clazz.getInterfaces();

        System.out.println("Implemented Interfaces:");
        for (Class<?> i : interfaces) {
            System.out.println(i.getName());
        }
    }
}
```

✔ `getInterfaces()` returns an array of **interfaces implemented by the class**.

---

## 8. Changing Private and Public Field Values

We can **modify public and private fields** using `setAccessible(true)`.

### Example: Changing Field Value

```java
import java.lang.reflect.Field;

class Example {
    private String secret = "Initial Value";
}

public class Main {
    public static void main(String[] args) throws Exception {
        Example obj = new Example();
        Class<?> clazz = obj.getClass();

        Field field = clazz.getDeclaredField("secret");
        field.setAccessible(true);  // Allow access to private field

        System.out.println("Before: " + field.get(obj));
        field.set(obj, "New Value"); // Changing value
        System.out.println("After: " + field.get(obj));
    }
}
```

✔ **`setAccessible(true)` allows access to private fields.**
✔ This technique is commonly used in **unit testing** and **serialization frameworks**.

---

## 9. Calling Private Methods Using Reflection

We can invoke private methods using `setAccessible(true)`.

### Example: Invoke a Private Method

```java
import java.lang.reflect.Method;

class Example {
    private void displaySecret() {
        System.out.println("Private Method Invoked!");
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Example obj = new Example();
        Class<?> clazz = obj.getClass();

        Method method = clazz.getDeclaredMethod("displaySecret");
        method.setAccessible(true); // Allow access to private method
        method.invoke(obj); // Call method
    }
}
```

✔ This allows **private methods to be accessed dynamically**.

---

## 10. Summary

| Feature                   | Reflection Method                                                |
| ------------------------- | ---------------------------------------------------------------- |
| Get class object          | `Class.forName("ClassName")`, `.class`, `obj.getClass()`         |
| Get methods               | `getDeclaredMethods()`, `getMethods()`                           |
| Get fields                | `getDeclaredFields()`, `getFields()`                             |
| Get return type of method | `method.getReturnType()`                                         |
| Get class modifiers       | `Modifier.isPublic(modifiers)`, `Modifier.isAbstract(modifiers)` |
| Get interfaces            | `getInterfaces()`                                                |
| Change field value        | `field.setAccessible(true)`, `field.set(obj, value)`             |
| Call private method       | `method.setAccessible(true)`, `method.invoke(obj)`               |

---

## 11. When to Use Reflection (And When Not To)

### ✔ When to Use:

✅ **Frameworks** (Spring, Hibernate)
✅ **Unit Testing** (Mocking private fields)
✅ **Serialization/Deserialization**

### ❌ When to Avoid:

🚫 Performance overhead (Reflection is **slower** than direct method calls)
🚫 Breaks encapsulation (Accessing **private fields/methods**)
🚫 Security risks (Bypassing access control)

---

# Java Annotations - Complete Guide with Examples

## 1. What are Java Annotations?

Annotations in Java provide **metadata** about the code but **do not change its behavior**. They are used by compilers, frameworks, and runtime environments to perform different operations.

### Why Use Annotations?

✔ Reduce boilerplate code
✔ Provide additional information to the compiler
✔ Enable **dependency injection, serialization, testing**, and more
✔ Used in **frameworks like Spring, Hibernate, JUnit**

---

## 2. Built-in Java Annotations

Java provides several built-in annotations categorized into three types:

### A. Compiler Annotations (Checked at Compile Time)

| Annotation          | Description                                         |
| ------------------- | --------------------------------------------------- |
| `@Override`         | Ensures that a method overrides a superclass method |
| `@Deprecated`       | Marks a method or class as outdated                 |
| `@SuppressWarnings` | Suppresses compiler warnings                        |

### Example of `@Override`

```java
class Parent {
    void show() {
        System.out.println("Parent class method");
    }
}

class Child extends Parent {
    @Override
    void show() {
        System.out.println("Overridden method in Child");
    }
}
```

✔ Ensures that `show()` correctly **overrides** the parent class method.

---

### Example of `@Deprecated`

```java
class Example {
    @Deprecated
    void oldMethod() {
        System.out.println("This method is deprecated.");
    }
}

public class Main {
    public static void main(String[] args) {
        Example obj = new Example();
        obj.oldMethod();  // Compiler will warn about usage
    }
}
```

✔ Marks `oldMethod()` as **deprecated**.
✔ The compiler warns against its usage.

---

### Example of `@SuppressWarnings`

```java
public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        java.util.List rawList = new java.util.ArrayList(); // Warning suppressed
        rawList.add("Hello");
    }
}
```

✔ Suppresses **unchecked type warnings**.

---

### B. Runtime Annotations (Available at Runtime)

| Annotation    | Description                                        |
| ------------- | -------------------------------------------------- |
| `@Retention`  | Specifies how long the annotation is retained      |
| `@Target`     | Specifies where the annotation can be applied      |
| `@Inherited`  | Allows an annotation to be inherited by subclasses |
| `@Documented` | Includes annotation in the JavaDoc                 |

---

## 3. Creating Custom Annotations

We can define our own annotations using the `@interface` keyword.

### Example: Custom Annotation

```java
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.METHOD) // Used on methods only
@interface MyAnnotation {
    String value();
    int count() default 1;
}

class Example {
    @MyAnnotation(value = "Hello", count = 3)
    public void testMethod() {
        System.out.println("Executing testMethod...");
    }
}
```

✔ `@Retention(RetentionPolicy.RUNTIME)`: Keeps annotation available at **runtime**.
✔ `@Target(ElementType.METHOD)`: Can be applied **only on methods**.

---

## 4. Retrieving Annotations Using Reflection

We can **access annotation values at runtime** using Reflection.

### Example: Reading Custom Annotation at Runtime

```java
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Example.class;
        Method method = clazz.getMethod("testMethod");

        // Check if annotation is present
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            System.out.println("Value: " + annotation.value());
            System.out.println("Count: " + annotation.count());
        }
    }
}
```

✔ **Reflection** allows accessing annotation values dynamically.

---

## 5. Meta-Annotations in Java

Meta-annotations are **annotations that define other annotations**.

| Meta-Annotation | Description                                  |
| --------------- | -------------------------------------------- |
| `@Retention`    | Specifies how long an annotation is retained |
| `@Target`       | Specifies where an annotation can be applied |
| `@Inherited`    | Allows a subclass to inherit an annotation   |
| `@Documented`   | Includes annotation in JavaDocs              |

### Example: Using Meta-Annotations

```java
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target({ElementType.METHOD, ElementType.TYPE}) // Can be applied to classes and methods
@interface MyMetaAnnotation { }
```

✔ `@Target(ElementType.TYPE)`: Can be used on **classes**.
✔ `@Target(ElementType.METHOD)`: Can be used on **methods**.

---

## 6. Built-in Java 8+ Annotations

Java 8 introduced **repeatable annotations** and **type annotations**.

### A. `@Repeatable` Annotation (Multiple Instances of Same Annotation)

```java
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(MyAnnotations.class) // Allows multiple annotations
@interface MyAnnotation {
    String value();
}

// Container annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotations {
    MyAnnotation[] value();
}

class Example {
    @MyAnnotation("First")
    @MyAnnotation("Second")
    public void testMethod() {
    }
}
```

✔ `@Repeatable(MyAnnotations.class)`: Allows multiple instances of `@MyAnnotation`.

---

### B. Java 8 Type Annotations (`@Target(ElementType.TYPE_USE)`)

```java
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@interface NonNull { }

class Example {
    public void display(@NonNull String message) {
        System.out.println(message);
    }
}
```

✔ **`ElementType.TYPE_USE`** allows annotations to be used **on variables, return types, and parameters**.

---

## 7. Real-World Applications of Annotations

### A. Annotations in JUnit

JUnit uses annotations for testing.

```java
import org.junit.jupiter.api.*;

public class TestExample {
    @BeforeEach
    void setup() {
        System.out.println("Setup before each test");
    }

    @Test
    void testMethod() {
        System.out.println("Running test");
    }
}
```

✔ `@BeforeEach` runs **before every test method**.
✔ `@Test` marks a method as a **test case**.

---

### B. Annotations in Spring (Dependency Injection)

Spring uses annotations like `@Autowired` to **inject dependencies**.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class Car {
    void drive() { System.out.println("Driving a car..."); }
}

@Component
class Person {
    @Autowired
    private Car car;

    void startJourney() { car.drive(); }
}
```

✔ **`@Autowired`** injects `Car` into `Person`.
✔ **`@Component`** marks classes as Spring components.

---

## 8. Summary

| Feature                   | Description                                           |
| ------------------------- | ----------------------------------------------------- |
| **Built-in Annotations**  | `@Override`, `@Deprecated`, `@SuppressWarnings`       |
| **Runtime Annotations**   | `@Retention`, `@Target`, `@Inherited`, `@Documented`  |
| **Custom Annotations**    | `@interface MyAnnotation {}`                          |
| **Accessing Annotations** | `method.getAnnotation(MyAnnotation.class)`            |
| **Java 8+ Features**      | `@Repeatable`, `@Target(ElementType.TYPE_USE)`        |
| **Used In**               | **JUnit, Spring, Hibernate, Logging, ORM frameworks** |

---

# Exception Handling in Java - Complete Guide with Examples

## 1. What is Exception Handling in Java?

Exception handling in Java is a mechanism that allows us to **handle runtime errors** to ensure the normal flow of execution.

### Why Exception Handling?

✔ Prevents program crashes due to unexpected errors
✔ Helps debug and maintain code easily
✔ Provides a mechanism to **gracefully handle runtime issues**

---

## 2. Types of Exceptions in Java

Java exceptions are categorized into two main types:

### A. Checked Exceptions (Compile-time exceptions)

- These exceptions are **checked at compile time**.
- The compiler forces us to handle them using `try-catch` or `throws`.
- Examples:
  - `IOException`
  - `SQLException`
  - `FileNotFoundException`

### Example: Checked Exception (Handling `IOException`)

```java
import java.io.*;

public class CheckedExceptionExample {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("nonexistent.txt"); // File not found
            BufferedReader br = new BufferedReader(file);
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
```

✔ **Without handling, this would cause a compile-time error.**

---

### B. Unchecked Exceptions (Runtime Exceptions)

- These exceptions occur at **runtime** and **are not checked** at compile time.
- They usually occur due to **logical errors in the program**.
- Examples:
  - `NullPointerException`
  - `ArrayIndexOutOfBoundsException`
  - `ArithmeticException`

### Example: Unchecked Exception (`ArithmeticException`)

```java
public class UncheckedExceptionExample {
    public static void main(String[] args) {
        int a = 10, b = 0;
        int result = a / b; // Causes ArithmeticException (division by zero)
        System.out.println(result);
    }
}
```

✔ **No compile-time error, but crashes at runtime.**

---

### C. Errors (Serious Issues)

- Errors are **not exceptions**, but serious problems beyond program control.
- Examples:
  - `StackOverflowError` (infinite recursion)
  - `OutOfMemoryError` (insufficient memory)

### Example: `StackOverflowError`

```java
public class StackOverflowExample {
    public static void recursiveMethod() {
        recursiveMethod(); // Infinite recursion
    }

    public static void main(String[] args) {
        recursiveMethod();
    }
}
```

✔ **Program crashes due to infinite recursion.**

---

## 3. Java Exception Hierarchy

```
Throwable
│
├── Exception (Checked Exceptions)
│   ├── IOException
│   ├── SQLException
│   ├── ClassNotFoundException
│
├── RuntimeException (Unchecked Exceptions)
│   ├── NullPointerException
│   ├── ArithmeticException
│   ├── IndexOutOfBoundsException
│
└── Error (Serious Issues)
    ├── StackOverflowError
    ├── OutOfMemoryError
```

---

## 4. Exception Handling Mechanisms

Java provides several ways to handle exceptions:

### A. Using try-catch Block

```java
public class TryCatchExample {
    public static void main(String[] args) {
        try {
            int num = 10 / 0; // Causes ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        System.out.println("Program continues...");
    }
}
```

✔ **Catches the exception and prevents the program from crashing.**

---

### B. Using Multiple Catch Blocks

```java
public class MultipleCatchExample {
    public static void main(String[] args) {
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); // IndexOutOfBoundsException
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught.");
        }
        System.out.println("Program continues...");
    }
}
```

✔ **Different catch blocks handle different exception types.**

---

### C. Using finally Block (Always Executes)

```java
public class FinallyExample {
    public static void main(String[] args) {
        try {
            System.out.println("Inside try block");
        } catch (Exception e) {
            System.out.println("Exception caught");
        } finally {
            System.out.println("Finally block always executes.");
        }
    }
}
```

✔ **`finally` executes whether an exception occurs or not.**

---

### D. Using throw Keyword (Manually Throw Exception)

```java
public class ThrowExample {
    public static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above.");
        }
        System.out.println("Valid age.");
    }

    public static void main(String[] args) {
        checkAge(16); // Throws exception
    }
}
```

✔ **Throws an exception manually when age is invalid.**

---

### E. Using throws Keyword (Method-Level Exception Handling)

```java
import java.io.*;

public class ThrowsExample {
    public static void readFile() throws IOException {
        FileReader file = new FileReader("nonexistent.txt"); // May throw IOException
    }

    public static void main(String[] args) {
        try {
            readFile();
        } catch (IOException e) {
            System.out.println("Handled IOException: " + e.getMessage());
        }
    }
}
```

✔ **Delegates exception handling to the caller method.**

---

## 5. Custom Exceptions

We can create our own exceptions by extending the `Exception` class.

### Example: Creating a Custom Exception

```java
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above.");
        }
    }

    public static void main(String[] args) {
        try {
            validateAge(16);
        } catch (InvalidAgeException e) {
            System.out.println("Caught Custom Exception: " + e.getMessage());
        }
    }
}
```

✔ **Custom exception provides meaningful error messages.**

---

## 6. Best Practices for Exception Handling

✅ Catch **specific exceptions** instead of `Exception`.
✅ Always use `finally` to **release resources** like database connections.
✅ Avoid **empty catch blocks** (hides errors).
✅ Use **custom exceptions** for better error clarity.
✅ Do not use exceptions for **flow control** (e.g., `try-catch` for loops).

---

## 7. Summary

| Feature                  | Description                                                          |
| ------------------------ | -------------------------------------------------------------------- |
| **Checked Exceptions**   | Compile-time errors (e.g., `IOException`, `SQLException`)            |
| **Unchecked Exceptions** | Runtime errors (e.g., `NullPointerException`, `ArithmeticException`) |
| **Errors**               | System-level issues (`StackOverflowError`, `OutOfMemoryError`)       |
| **Handling Exceptions**  | `try-catch`, `finally`, `throw`, `throws`                            |
| **Custom Exceptions**    | Extending `Exception` class                                          |
| **Best Practices**       | Catch specific exceptions, use finally, avoid empty catch blocks     |

---

# Operators in Java - Complete Guide with Examples

## 1. What are Operators in Java?

Operators in Java are **special symbols** used to perform operations on variables and values.

### Why Use Operators?

✔ Perform arithmetic operations
✔ Compare values
✔ Assign values
✔ Manipulate bits
✔ Control program flow

---

## 2. Types of Operators in Java

Java provides different types of operators:

1. **Arithmetic Operators** (`+`, `-`, `*`, `/`, `%`)
2. **Relational (Comparison) Operators** (`==`, `!=`, `>`, `<`, `>=`, `<=`)
3. **Logical Operators** (`&&`, `||`, `!`)
4. **Bitwise Operators** (`&`, `|`, `^`, `~`, `<<`, `>>`, `>>>`)
5. **Assignment Operators** (`=`, `+=`, `-=`, `*=`, `/=`, `%=`)
6. **Unary Operators** (`+`, `-`, `++`, `--`, `~`, `!`)
7. **Ternary Operator** (`condition ? trueValue : falseValue`)
8. **Instanceof Operator** (`object instanceof ClassName`)
9. **Type Cast Operator** (`(dataType) value`)

---

## 3. Arithmetic Operators (Perform Mathematical Operations)

| Operator | Meaning             | Example |
| -------- | ------------------- | ------- |
| `+`      | Addition            | `a + b` |
| `-`      | Subtraction         | `a - b` |
| `*`      | Multiplication      | `a * b` |
| `/`      | Division            | `a / b` |
| `%`      | Modulus (Remainder) | `a % b` |

### Example: Arithmetic Operators

```java
public class ArithmeticExample {
    public static void main(String[] args) {
        int a = 10, b = 3;
        System.out.println("Addition: " + (a + b)); // 13
        System.out.println("Subtraction: " + (a - b)); // 7
        System.out.println("Multiplication: " + (a * b)); // 30
        System.out.println("Division: " + (a / b)); // 3
        System.out.println("Modulus: " + (a % b)); // 1
    }
}
```

---

## 4. Relational (Comparison) Operators

Used to compare two values, returning `true` or `false`.

| Operator | Meaning                  | Example (`a=10`, `b=20`) | Result  |
| -------- | ------------------------ | ------------------------ | ------- |
| `==`     | Equal to                 | `a == b`                 | `false` |
| `!=`     | Not equal to             | `a != b`                 | `true`  |
| `>`      | Greater than             | `a > b`                  | `false` |
| `<`      | Less than                | `a < b`                  | `true`  |
| `>=`     | Greater than or equal to | `a >= b`                 | `false` |
| `<=`     | Less than or equal to    | `a <= b`                 | `true`  |

### Example: Relational Operators

```java
public class RelationalExample {
    public static void main(String[] args) {
        int a = 10, b = 20;
        System.out.println("a == b: " + (a == b)); // false
        System.out.println("a != b: " + (a != b)); // true
        System.out.println("a > b: " + (a > b)); // false
        System.out.println("a < b: " + (a < b)); // true
    }
}
```

---

## 5. Logical Operators

Used for logical operations, returning `true` or `false`.

| Operator | Meaning | Example (`a=true`, `b=false`) | Result  |
| -------- | ------- | ----------------------------- | ------- |
| `&&`     | AND     | `a && b`                      | `false` |
| `||`     | OR      | `a || b`                      | `true`  |
| `!`      | NOT     | `!a`                          | `false` |

### Example: Logical Operators

```java
public class LogicalExample {
    public static void main(String[] args) {
        boolean a = true, b = false;
        System.out.println("a && b: " + (a && b)); // false
        System.out.println("a || b: " + (a || b)); // true
        System.out.println("!a: " + (!a)); // false
    }
}
```

---

## 6. Bitwise Operators (Work on Bits)

Used for bit-level manipulations.

| Operator | Meaning               | Example    |
| -------- | --------------------- | ---------- |
| `&`      | Bitwise AND           | `a & b`    |
| `|`      | Bitwise OR            | `a | b`    |
| `^`      | Bitwise XOR           | `a ^ b`    |
| `~`      | Bitwise Complement    | `~a`       |
| `<<`     | Left Shift            | `a << 2`   |
| `>>`     | Right Shift           | `a >> 2`   |
| `>>>`    | Zero-fill Right Shift | `a >>> 2`  |

---

## 7. Assignment Operators

Used to assign values to variables.

| Operator | Example  | Equivalent to |
| -------- | -------- | ------------- |
| `=`      | `a = b`  | `a = b`       |
| `+=`     | `a += b` | `a = a + b`   |
| `-=`     | `a -= b` | `a = a - b`   |
| `*=`     | `a *= b` | `a = a * b`   |
| `/=`     | `a /= b` | `a = a / b`   |

### Example: Assignment Operators

```java
public class AssignmentExample {
    public static void main(String[] args) {
        int a = 10;
        a += 5; // a = a + 5
        System.out.println("a: " + a); // 15
    }
}
```

---

## 8. Unary Operators

| Operator | Meaning   | Example        |
| -------- | --------- | -------------- |
| `+`      | Positive  | `+a`           |
| `-`      | Negative  | `-a`           |
| `++`     | Increment | `a++` or `++a` |
| `--`     | Decrement | `a--` or `--a` |

---

## 9. Ternary Operator (`condition ? trueValue : falseValue`)

```java
public class TernaryExample {
    public static void main(String[] args) {
        int a = 10, b = 20;
        int min = (a < b) ? a : b;
        System.out.println("Minimum: " + min);
    }
}
```

---

## 10. instanceof Operator

Checks if an object is an instance of a class.

```java
class Animal { }
class Dog extends Animal { }

public class InstanceofExample {
    public static void main(String[] args) {
        Dog d = new Dog();
        System.out.println(d instanceof Animal); // true
    }
}
```

---

## 11. Type Cast Operator

Used to convert data types.

```java
public class TypeCastingExample {
    public static void main(String[] args) {
        int num = 100;
        double d = (double) num; // Explicit Casting
        System.out.println(d);
    }
}
```

---

## 12. Operator Precedence Table in Java

Operators are listed from **highest to lowest** precedence.

| Precedence      | Operator                                                               | Description                                 | Associativity        |
| --------------- | ---------------------------------------------------------------------- | ------------------------------------------- | -------------------- |
| **1** (Highest) | `()`, `[]`, `.`                                                        | Parentheses, Array access, Member selection | **Left to Right**    |
| **2**           | `++`, `--`, `~`, `!`, `(type)`                                         | Unary operators                             | **Right to Left**    |
| **3**           | `*`, `/`, `%`                                                          | Multiplication, Division, Modulus           | **Left to Right**    |
| **4**           | `+`, `-`                                                               | Addition, Subtraction                       | **Left to Right**    |
| **5**           | `<<`, `>>`, `>>>`                                                      | Bitwise shift operators                     | **Left to Right**    |
| **6**           | `<`, `<=`, `>`, `>=`, `instanceof`                                     | Relational operators                        | **Left to Right**    |
| **7**           | `==`, `!=`                                                             | Equality operators                          | **Left to Right**    |
| **8**           | `&`                                                                    | Bitwise AND                                 | **Left to Right**    |
| **9**           | `^`                                                                    | Bitwise XOR                                 | **Left to Right**    |
| **10**          | `|`                                                                    | Bitwise OR                                  | **Left to Right**    |
| **11**          | `&&`                                                                   | Logical AND                                 | **Left to Right**    |
| **12**          | `||`                                                                   | Logical OR                                  | **Left to Right**    |
| **13**          | `?:`                                                                   | Ternary Operator                            | **Right to Left**    |
| **14**          | `=`, `+=`, `-=`, `*=`, `/=`, `%=`, `<<=`, `>>=`, `>>>=`, `&=`, `^=`, `|=` | Assignment operators                        | **Right to Left**    |
| **15** (Lowest) | `,`                                                                    | Comma operator (used in loops)              | **Left to Right**    |

---

# Control Flow Statements in Java

Control flow statements **determine the execution order** of instructions in a Java program. Java provides:

✔ **Decision-Making Statements** (if-else, switch)
✔ **Looping Statements** (for, while, do-while)
✔ **Branching Statements** (break, continue, return)

---

## 1. Decision-Making Statements

Decision-making statements allow the program to **execute different blocks of code** based on conditions.

### 1.1 if-else Statement

Used to execute a block of code **only if a condition is true**.

#### Syntax:

```java
if (condition) {
    // Code executes if condition is true
} else {
    // Code executes if condition is false
}
```

#### Example:

```java
public class IfElseExample {
    public static void main(String[] args) {
        int number = 10;
        if (number > 0) {
            System.out.println("Positive Number");
        } else {
            System.out.println("Negative Number");
        }
    }
}
```

✅ **Output:** `Positive Number`

---

### 1.2 if-else-if Ladder

Used when there are **multiple conditions**.

#### Syntax:

```java
if (condition1) {
    // Code block 1
} else if (condition2) {
    // Code block 2
} else {
    // Default block
}
```

#### Example:

```java
public class IfElseIfExample {
    public static void main(String[] args) {
        int marks = 85;
        if (marks >= 90) {
            System.out.println("Grade A");
        } else if (marks >= 75) {
            System.out.println("Grade B");
        } else {
            System.out.println("Grade C");
        }
    }
}
```

✅ **Output:** `Grade B`

---

### 1.3 Switch Statement

Used when we have **multiple possible values** for a variable.

#### Syntax:

```java
switch (expression) {
    case value1:
        // Code block 1
        break;
    case value2:
        // Code block 2
        break;
    default:
        // Default block
}
```

#### Example:

```java
public class SwitchExample {
    public static void main(String[] args) {
        int day = 3;
        switch (day) {
            case 1: System.out.println("Monday"); break;
            case 2: System.out.println("Tuesday"); break;
            case 3: System.out.println("Wednesday"); break;
            default: System.out.println("Invalid Day");
        }
    }
}
```

✅ **Output:** `Wednesday`

**🚀 Java 14+: Switch with Multiple Cases & Arrow Syntax**

```java
public class SwitchNewSyntax {
    public static void main(String[] args) {
        int day = 3;
        String result = switch (day) {
            case 1, 2, 3 -> "Weekday";
            case 4, 5 -> "Weekend";
            default -> "Invalid";
        };
        System.out.println(result);
    }
}
```

✅ **Output:** `Weekday`

---

## 2. Looping Statements

Loops **repeat** a block of code **multiple times** until a condition is false.

| Loop         | When to Use                                 |
| ------------ | ------------------------------------------- |
| **for**      | When the number of iterations is known      |
| **while**    | When the number of iterations is unknown    |
| **do-while** | Ensures the loop executes **at least once** |

---

### 2.1 for Loop

Executes code **a fixed number of times**.

#### Syntax:

```java
for (initialization; condition; increment/decrement) {
    // Code block
}
```

#### Example:

```java
public class ForLoopExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration: " + i);
        }
    }
}
```

✅ **Output:**
```
Iteration: 1
Iteration: 2
Iteration: 3
Iteration: 4
Iteration: 5
```

**🚀 Enhanced for Loop (for-each)** Used to iterate over arrays and collections.

```java
public class ForEachExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        for (int num : numbers) {
            System.out.println(num);
        }
    }
}
```

---

### 2.2 while Loop

Executes code **as long as a condition is true**.

#### Syntax:

```java
while (condition) {
    // Code block
}
```

#### Example:

```java
public class WhileLoopExample {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 5) {
            System.out.println("Count: " + i);
            i++;
        }
    }
}
```

✅ **Output:** `Count: 1, Count: 2, Count: 3, Count: 4, Count: 5`

---

### 2.3 do-while Loop

Executes code **at least once**, then continues based on condition.

#### Syntax:

```java
do {
    // Code block
} while (condition);
```

#### Example:

```java
public class DoWhileExample {
    public static void main(String[] args) {
        int i = 1;
        do {
            System.out.println("Number: " + i);
            i++;
        } while (i <= 5);
    }
}
```

✅ **Output:** `Number: 1, Number: 2, Number: 3, Number: 4, Number: 5`

---

## 3. Branching Statements

Branching statements **change the normal execution flow**.

| Statement    | Description                                       |
| ------------ | ------------------------------------------------- |
| **break**    | Exits a loop/switch immediately                   |
| **continue** | Skips the current iteration and moves to the next |
| **return**   | Exits from the method                             |

---

### 3.1 break Statement

Used to **exit a loop or switch** immediately.

#### Example:

```java
public class BreakExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                break;  // Loop stops at i = 3
            }
            System.out.println(i);
        }
    }
}
```

✅ **Output:** `1, 2`

---

### 3.2 continue Statement

Used to **skip** the current iteration and continue with the next.

#### Example:

```java
public class ContinueExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue;  // Skip i = 3
            }
            System.out.println(i);
        }
    }
}
```

✅ **Output:** `1, 2, 4, 5`

---

### 3.3 return Statement

Used to **exit a method** and return a value.

#### Example:

```java
public class ReturnExample {
    public static void main(String[] args) {
        System.out.println(sum(5, 10));
    }

    static int sum(int a, int b) {
        return a + b;  // Return sum
    }
}
```

✅ **Output:** `15`

---

# Lombok Features in Java

Lombok is a Java library that reduces boilerplate code by generating commonly used methods like getters, setters, constructors, etc., during compilation.

---

## 📌 1. `val` and `var`

- `val`: Immutable local variable (like `final`)
- `var`: Mutable local variable
- Type is inferred by the compiler.

```java
val name = "John";  // becomes final String name = "John";
var count = 10;     // becomes int count = 10;
```

✅ Helps reduce verbosity when declaring variables.

---

## 📌 2. `@NonNull`

- Automatically adds null checks in constructors or methods.
- Throws `NullPointerException` if the value is null.

```java
public class Person {
    public Person(@NonNull String name) {
        this.name = name;
    }
}
```

✅ Avoids writing manual null checks.

---

## 📌 3. `@Getter` and `@Setter`

- Automatically generates getter and setter methods.

```java
@Getter
@Setter
private String name;
```

- You can annotate at **class level** (for all fields) or **field level**.

✅ Reduces boilerplate method generation.

---

## 📌 4. `@ToString`

- Generates a readable `toString()` method.
- Can exclude fields: `@ToString(exclude = "password")`

```java
@ToString
public class User {
    private String name;
    private String email;
}
```

---

## 📌 5. `@NoArgsConstructor`, `@AllArgsConstructor`, `@RequiredArgsConstructor`

- `@NoArgsConstructor`: No-arg constructor.
- `@AllArgsConstructor`: Constructor with all fields.
- `@RequiredArgsConstructor`: Only `final` or `@NonNull` fields.

```java
@RequiredArgsConstructor
public class Student {
    private final String name;
    private int age;
}
```

---

## 📌 6. `@EqualsAndHashCode`

- Generates `equals()` and `hashCode()` based on fields.
- Can exclude fields too.

```java
@EqualsAndHashCode
public class Book {
    private String title;
    private String author;
}
```

---

## 📌 7. `@Data`

- Combines:
  - `@ToString`
  - `@EqualsAndHashCode`
  - `@Getter`/`@Setter`
  - `@RequiredArgsConstructor`

```java
@Data
public class Product {
    private final String id;
    private String name;
}
```

✅ Ideal for POJOs.

---

## 📌 8. `@Value`

- Immutable version of `@Data`.
- All fields are `private` and `final`.
- No setters generated.

```java
@Value
public class Config {
    String host;
    int port;
}
```

---

## 📌 9. `@Builder`

- Enables fluent API for object creation.
- Useful for creating immutable or complex objects.

```java
@Builder
public class Order {
    private String item;
    private int quantity;
}
```

```java
Order order = Order.builder().item("Book").quantity(2).build();
```

---

## 📌 10. `@Cleanup`

- Automatically closes resources like streams, readers, etc.

```java
@Cleanup InputStream in = new FileInputStream("file.txt");
```

✅ Ensures `close()` is called, even in case of exceptions.

---

# Java 17: Sealed Classes and Interfaces

---

## 🔑 Key Concept

- **Problem before Sealed Classes**:
  - No control over inheritance hierarchy.
  - Any class could implement an interface or extend a class.
  - Leads to unpredictable subclasses, forcing developers to add `default` cases in `switch` or `if-else` handling.
  - Silent code breaks could occur if a new subclass was introduced unintentionally.

- **Solution**: **Sealed Classes & Interfaces (Java 17)**
  - Introduce `sealed` keyword + `permits` clause.
  - Restricts which classes or interfaces can directly extend/implement a type.
  - Provides controlled inheritance.

---

## 🚀 How It Works

**Syntax Example**:

```java
public sealed interface Shape permits Circle, Rectangle {}
```

- `Shape` can only be implemented by `Circle` and `Rectangle`.
- Any other class (e.g., `Triangle`) is **not allowed**.

---

## ⚖️ Rules for Subclasses

Every permitted subclass must declare **one of three modifiers**:

1. **final** → No further subclassing allowed.
   ```java
   final class Circle implements Shape {}
   ```

2. **sealed** → Can be subclassed, but only by explicitly permitted types.
   ```java
   sealed class AbstractShape implements Shape permits Rectangle, Triangle {}
   ```

3. **non-sealed** → Open for extension by any number of subclasses.
   ```java
   non-sealed interface Polygon extends Shape {}
   ```

---

## 📌 Important Conditions

- **Permitted types must be direct subclasses** of the sealed type.
- **Permitted subclasses must declare themselves as final, sealed, or non-sealed**.
- **All permitted subclasses must exist at compile time** (future hypothetical classes not allowed).

---

## 🧩 Example Hierarchy

```java
// Sealed Interface
public sealed interface Shape permits Circle, Polygon, AbstractShape {}

// Circle - No further subclass
public final class Circle implements Shape {}

// Polygon - Open branch
public non-sealed interface Polygon extends Shape {}

// AbstractShape - Restricted to Rectangle & Triangle
public sealed abstract class AbstractShape implements Shape permits Rectangle, Triangle {}

// Rectangle - Closed branch
public final class Rectangle extends AbstractShape {}

// Triangle - Open branch
public non-sealed class Triangle extends AbstractShape {}
```

---

## ✅ Benefits

- Enforces **controlled inheritance**.
- Reduces **unexpected child classes**.
- Improves **readability and maintainability** of code.
- Compiler can perform **exhaustive checks** in `switch` expressions (no need for unnecessary `default`).
