# Java Basics 2

## Table of Contents

### Part 1 | Java Enum, POJO, and Final Classes
- [1. Java Enum (Enumeration)](#1-java-enum-enumeration)
  - [1.1 Defining an Enum](#11-defining-an-enum)
  - [1.2 Using an Enum in Java](#12-using-an-enum-in-java)
  - [1.3 Enum with Custom Fields and Methods](#13-enum-with-custom-fields-and-methods)
- [2. POJO (Plain Old Java Object)](#2-pojo-plain-old-java-object)
  - [2.1 Characteristics of a POJO](#21-characteristics-of-a-pojo)
  - [2.2 Example of a POJO](#22-example-of-a-pojo)
  - [2.3 POJO vs JavaBean](#23-pojo-vs-javabean)
- [3. Final Classes in Java](#3-final-classes-in-java)
  - [3.1 Declaring a Final Class](#31-declaring-a-final-class)
  - [3.2 Attempting to Extend a Final Class](#32-attempting-to-extend-a-final-class-compilation-error)
  - [3.3 Final Methods](#33-final-methods-prevent-method-overriding)
  - [3.4 Final Variables](#34-final-variables-constants-in-java)
- [4. Summary](#4-summary)
 
### Part 2 | Java Singleton and Immutable Classes
- [1. Singleton Class in Java](#1-singleton-class-in-java)
  - [1.1 Key Features of a Singleton Class](#11-key-features-of-a-singleton-class)
- [2. Implementing a Singleton Class](#2-implementing-a-singleton-class)
  - [2.1 Eager Initialization](#21-eager-initialization-thread-safe)
  - [2.2 Lazy Initialization](#22-lazy-initialization-not-thread-safe)
  - [2.3 Thread-Safe Singleton](#23-thread-safe-singleton-using-synchronized-method)
  - [2.4 Double-Checked Locking](#24-best-approach-double-checked-locking-thread-safe--efficient)
  - [2.5 Singleton Using Enum](#25-singleton-using-enum-best-practice)
- [3. Immutable Class in Java](#3-immutable-class-in-java)
  - [3.1 Key Features of an Immutable Class](#31-key-features-of-an-immutable-class)
- [4. Implementing an Immutable Class](#4-implementing-an-immutable-class)
  - [4.1 Handling Mutable Fields](#41-handling-mutable-fields-using-defensive-copies)
- [5. Singleton vs Immutable Class](#5-singleton-vs-immutable-class)

### Part 3 | Java Interface in Depth
- [1. What is an Interface and How to Define It?](#1-what-is-an-interface-and-how-to-define-it)
- [2. Why Do We Need an Interface?](#2-why-do-we-need-an-interface)
- [3. Methods in an Interface](#3-methods-in-an-interface)
  - [3.1 Abstract Methods](#31-abstract-methods-default)
  - [3.2 Default Methods](#32-default-methods-introduced-in-java-8)
  - [3.3 Static Methods](#33-static-methods-introduced-in-java-8)
  - [3.4 Private Methods](#34-private-methods-introduced-in-java-9)
- [4. Fields in an Interface](#4-fields-in-an-interface)
- [5. Interface Implementation](#5-interface-implementation)
- [6. Nested Interfaces](#6-nested-interfaces)
  - [6.1 Nested Interface Inside Another Interface](#61-nested-interface-inside-another-interface)
- [7. Difference Between Interface and Abstract Class](#7-difference-between-interface-and-abstract-class)

### Part 4 | Default, Static & Private Methods in Interface
- [1. Introduction](#1-introduction)
- [2. Default Methods in Interface (Java 8)](#2-default-methods-in-interface-java-8)
  - [2.1 Overriding a Default Method](#21-overriding-a-default-method)
  - [2.2 Default Methods with Multiple Interfaces](#22-default-methods-with-multiple-interfaces-diamond-problem)
- [3. Static Methods in Interface (Java 8)](#3-static-methods-in-interface-java-8)
  - [3.1 Static Methods Cannot Be Overridden](#31-static-methods-cannot-be-overridden)
- [4. Private Methods in Interface (Java 9)](#4-private-methods-in-interface-java-9)
  - [4.1 Example: Private Method Inside an Interface](#41-example-private-method-inside-an-interface)
- [5. Summary of Java 8 & Java 9 Interface Features](#5-summary-of-java-8--java-9-interface-features)
- [6. Key Takeaways](#6-key-takeaways)

### Part 5 | Functional Interface and Lambda Expression
- [1. What is a Functional Interface?](#1-what-is-a-functional-interface)
- [2. What is a Lambda Expression?](#2-what-is-a-lambda-expression)
- [3. How to Use Functional Interfaces with Lambda Expressions?](#3-how-to-use-functional-interfaces-with-lambda-expressions)
- [4. Advantage of Functional Interfaces](#4-advantage-of-functional-interfaces)
- [5. Types of Functional Interfaces](#5-types-of-functional-interfaces)
  - [5.1 Consumer](#51-consumer-accepts-a-value-returns-nothing)
  - [5.2 Supplier](#52-supplier-returns-a-value-takes-nothing)
  - [5.3 Function](#53-function-takes-input-returns-output)
  - [5.4 Predicate](#54-predicate-takes-input-returns-boolean)
- [6. How to Handle Functional Interface Extending Another Interface?](#6-how-to-handle-functional-interface-extending-another-interface)
  - [6.1 Case 1: Extending a Functional Interface](#case-1-extending-a-functional-interface)
  - [6.2 Case 2: Adding a New Abstract Method](#case-2-adding-a-new-abstract-method-invalid-case)
  - [6.3 Case 3: Extending a Non-Functional Interface](#case-3-extending-a-non-functional-interface)
- [7. Summary](#7-summary)

---

# Java Enum, POJO, and Final Classes Explained with Examples | Java Classes in Depth - Part 3

Java provides different types of classes, including **Enums, POJOs (Plain Old Java Objects), and Final Classes**. This guide will explain each type with **examples**.

---

## 1. Java Enum (Enumeration)

An **enum** is a special type in Java used to **define a fixed set of constants**. It is useful when a variable should have only a limited set of possible values.

### 1.1 Defining an Enum

```java
enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}
```

✔ **Each value inside an enum is a constant (`final` and `static`).**
✔ **By default, enums extend `java.lang.Enum` (cannot extend other classes).**

---

### 1.2 Using an Enum in Java

```java
public class Main {
    public static void main(String[] args) {
        Day today = Day.FRIDAY;
        System.out.println("Today is: " + today);  // Output: Today is: FRIDAY

        // Using Enum in Switch
        switch (today) {
            case MONDAY -> System.out.println("Start of the week!");
            case FRIDAY -> System.out.println("Weekend is near!");
            default -> System.out.println("A regular day.");
        }
    }
}
```

✔ **Enum can be used in `switch` statements.**
✔ **Each enum constant is accessed using `EnumName.CONSTANT`.**

---

### 1.3 Enum with Custom Fields and Methods

Enums can have **fields, constructors, and methods**.

```java
enum Size {
    SMALL(10), MEDIUM(20), LARGE(30);

    private final int value;

    Size(int value) {  // Constructor
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class Main {
    public static void main(String[] args) {
        Size s = Size.MEDIUM;
        System.out.println("Size: " + s + ", Value: " + s.getValue());
        // Output: Size: MEDIUM, Value: 20
    }
}
```

✔ **Each enum constant can hold values (`SMALL(10), MEDIUM(20)`).**
✔ **`getValue()` returns the assigned value.**

---

## 2. POJO (Plain Old Java Object)

A **POJO** is a simple Java class that does not extend or implement special classes/interfaces. It is mainly used to **store and transfer data**.

### 2.1 Characteristics of a POJO

✔ **Private fields with public getter/setter methods.**
✔ **No business logic, just data storage.**
✔ **No special constraints (unlike JavaBeans which require serialization, default constructor, etc.).**

---

### 2.2 Example of a POJO

```java
class Student {
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    // toString() method
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Alice", 22);
        System.out.println(s);  // Output: Student{name='Alice', age=22}
    }
}
```

✔ **Encapsulation: Fields are private, accessed via getters/setters.**
✔ **No special annotations, interfaces, or extensions (Pure POJO).**

---

### 2.3 POJO vs JavaBean

| Feature                     | POJO     | JavaBean           |
| --------------------------- | -------- | ------------------ |
| **Getters/Setters**         | Optional | Required           |
| **Default Constructor**     | Optional | Required           |
| **Implements Serializable** | No       | Yes                |
| **Annotations**             | No       | Sometimes required |

**🔹 JavaBeans are stricter versions of POJOs, often used in frameworks like Spring and Hibernate.**

---

## 3. Final Classes in Java

A **final class** is a class that **cannot be inherited (extended)**. It is used when we want to **prevent modification or extension of a class**.

### 3.1 Declaring a Final Class

```java
final class MathUtils {
    public static int square(int num) {
        return num * num;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(MathUtils.square(5));  // Output: 25
    }
}
```

✔ **`MathUtils` is `final`, so no class can extend it.**
✔ **Useful for utility/helper classes.**

---

### 3.2 Attempting to Extend a Final Class (Compilation Error)

```java
final class Parent {
    void display() {
        System.out.println("Parent class");
    }
}

// This will cause a compilation error!
class Child extends Parent {
    void show() {
        System.out.println("Child class");
    }
}
```

🚨 **Error:** `Cannot inherit from final Parent`.

---

### 3.3 Final Methods (Prevent Method Overriding)

A **final method** prevents subclasses from overriding it.

```java
class Vehicle {
    final void start() {
        System.out.println("Vehicle is starting...");
    }
}

class Car extends Vehicle {
    // This will cause an error!
    // void start() { System.out.println("Car is starting..."); }
}
```

🚨 **Error:** `Cannot override the final method from Vehicle`.

✔ **Useful for methods that should not be modified in subclasses.**

---

### 3.4 Final Variables (Constants in Java)

A **final variable** becomes a constant and **cannot be changed after initialization**.

```java
class Config {
    static final double PI = 3.14159;  // Constant value

    void show() {
        // PI = 3.14;  // Error: Cannot assign a value to final variable 'PI'
        System.out.println("Value of PI: " + PI);
    }
}

public class Main {
    public static void main(String[] args) {
        Config c = new Config();
        c.show();  // Output: Value of PI: 3.14159
    }
}
```

✔ **`final` variables must be initialized at declaration or in the constructor.**
✔ **Once assigned, they cannot be changed.**

---

## 4. Summary

| Feature         | Enum                        | POJO                      | Final Class                |
| --------------- | --------------------------- | ------------------------- | -------------------------- |
| **Purpose**     | Defines constants           | Stores and transfers data | Prevents inheritance       |
| **Fields**      | Constants                   | Private variables         | Any variables              |
| **Methods**     | Can have methods            | Getters/Setters           | Cannot be overridden       |
| **Inheritance** | Cannot extend other classes | Can extend classes        | Cannot be extended         |
| **Example**     | `enum Day {MON, TUE}`       | `class Student {}`        | `final class MathUtils {}` |

---

# Java Singleton and Immutable Class Explained with Examples | Java Classes in Depth - Part 4

In this guide, we will cover **Singleton and Immutable Classes** in Java, their purpose, implementation, and best practices.

---

## 1. Singleton Class in Java

A **Singleton class** ensures that **only one instance** of the class is created and provides a **global point of access** to it.

### 1.1 Key Features of a Singleton Class

✔ **Only one instance is created throughout the application.**
✔ **Provides a global access point using a static method.**
✔ **Constructor is private to prevent external instantiation.**

---

## 2. Implementing a Singleton Class

### 2.1 Eager Initialization (Thread-Safe)

In **Eager Initialization**, the instance is created at the time of class loading.

```java
class Singleton {
    private static final Singleton instance = new Singleton(); // Early creation

    private Singleton() { } // Private constructor

    public static Singleton getInstance() {
        return instance;
    }
}

public class Main {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        System.out.println(obj1 == obj2); // Output: true (same instance)
    }
}
```

✔ **Simple and thread-safe.**
❌ **Instance is created even if not used (memory waste).**

---

### 2.2 Lazy Initialization (Not Thread-Safe)

In **Lazy Initialization**, the instance is created only when `getInstance()` is called.

```java
class Singleton {
    private static Singleton instance;  // No instance created initially

    private Singleton() { }

    public static Singleton getInstance() {
        if (instance == null) { // Instance created only when required
            instance = new Singleton();
        }
        return instance;
    }
}
```

✔ **Instance is created only when needed (better memory usage).**
❌ **Not thread-safe in a multi-threaded environment.**

---

### 2.3 Thread-Safe Singleton Using Synchronized Method

To ensure thread safety, we can use `synchronized` on `getInstance()`.

```java
class Singleton {
    private static Singleton instance;

    private Singleton() { }

    public static synchronized Singleton getInstance() { // Synchronized method
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

✔ **Thread-safe but slower due to method synchronization.**
❌ **Every call to `getInstance()` is synchronized, even when unnecessary.**

---

### 2.4 Best Approach: Double-Checked Locking (Thread-Safe & Efficient)

This improves performance by **synchronizing only when necessary**.

```java
class Singleton {
    private static volatile Singleton instance; // Volatile ensures visibility across threads

    private Singleton() { }

    public static Singleton getInstance() {
        if (instance == null) {  // First check (without synchronization)
            synchronized (Singleton.class) {  // Synchronize block
                if (instance == null) {  // Second check (inside synchronized block)
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

✔ **Thread-safe and optimized for performance.**

---

### 2.5 Singleton Using Enum (Best Practice)

Using **enum** ensures Singleton properties with built-in thread safety and serialization support.

```java
enum Singleton {
    INSTANCE; // Single instance

    public void showMessage() {
        System.out.println("Singleton using Enum!");
    }
}

public class Main {
    public static void main(String[] args) {
        Singleton.INSTANCE.showMessage();
    }
}
```

✔ **Thread-safe, serialization-safe, and simple to implement.**
✔ **Recommended over other Singleton implementations.**

---

## 3. Immutable Class in Java

An **Immutable class** is one whose objects **cannot be modified** after creation.

### 3.1 Key Features of an Immutable Class

✔ **Fields are declared `final`.**
✔ **No setter methods are provided.**
✔ **Objects are created via constructors only.**
✔ **If the class contains mutable objects, defensive copies are made.**

---

## 4. Implementing an Immutable Class

A properly designed **immutable class** in Java:

```java
final class ImmutablePerson {  // Step 1: Declare class as final
    private final String name;  // Step 2: Make fields final
    private final int age;

    public ImmutablePerson(String name, int age) {  // Step 3: Initialize fields via constructor
        this.name = name;
        this.age = age;
    }

    public String getName() {  // Step 4: Only getter methods, no setters
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Main {
    public static void main(String[] args) {
        ImmutablePerson person = new ImmutablePerson("Alice", 25);
        System.out.println(person.getName());  // Output: Alice
    }
}
```

✔ **Class cannot be modified after object creation.**

---

### 4.1 Handling Mutable Fields (Using Defensive Copies)

If an immutable class contains a mutable field (e.g., `List`), **return a copy instead of the original object**.

```java
import java.util.*;

final class ImmutableStudent {
    private final String name;
    private final List<String> subjects;

    public ImmutableStudent(String name, List<String> subjects) {
        this.name = name;
        this.subjects = new ArrayList<>(subjects);  // Defensive copy
    }

    public String getName() {
        return name;
    }

    public List<String> getSubjects() {
        return new ArrayList<>(subjects);  // Defensive copy
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> subjects = new ArrayList<>(Arrays.asList("Math", "Science"));
        ImmutableStudent student = new ImmutableStudent("John", subjects);

        subjects.add("History");  // Modifying original list
        System.out.println(student.getSubjects());  // Output: [Math, Science] (unchanged)
    }
}
```

✔ **`subjects` is protected from external modifications.**
✔ **Returning a new copy prevents mutation.**

---

## 5. Singleton vs Immutable Class

| Feature               | Singleton Class                                       | Immutable Class                         |
| --------------------- | ----------------------------------------------------- | --------------------------------------- |
| **Definition**        | Only one instance exists                              | Object state cannot be changed          |
| **Instance Creation** | Controlled via `getInstance()`                        | Created via constructor                 |
| **Thread Safety**     | Can be ensured using `synchronized`, `volatile`, etc. | Naturally thread-safe                   |
| **Modification**      | Can have mutable state                                | No modifications allowed after creation |
| **Examples**          | Logger, ConfigurationManager                          | `String`, `Integer`, `LocalDate`        |

---

# Java Interface in Depth

## 1. What is an Interface and How to Define It?

An **interface** in Java is a **blueprint** for a class that defines a **set of methods** without providing their implementations. It is used to achieve **abstraction** and **multiple inheritance** in Java.

### Syntax of an Interface

```java
interface Animal {
    void makeSound();  // Abstract method (no implementation)
}
```

✔ **All methods in an interface are abstract by default (until Java 8).**
✔ **An interface cannot have a constructor (cannot create objects).**

---

## 2. Why Do We Need an Interface?

Interfaces help in **decoupling** code, **achieving abstraction**, and **supporting multiple inheritance** in Java.

### Key Benefits of Interfaces:

✔ **Achieves Abstraction**: Hides implementation details.
✔ **Supports Multiple Inheritance**: A class can implement multiple interfaces.
✔ **Promotes Loose Coupling**: Helps in designing flexible applications.
✔ **Defines a Contract**: Ensures that implementing classes follow a common structure.

### Example of Loose Coupling

```java
interface Vehicle {
    void start();
}

class Car implements Vehicle {
    public void start() {
        System.out.println("Car is starting...");
    }
}

class Bike implements Vehicle {
    public void start() {
        System.out.println("Bike is starting...");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle v = new Car();  // Loose coupling
        v.start();  // Output: Car is starting...
    }
}
```

✔ The `Vehicle` interface allows us to create flexible, reusable code.

---

## 3. Methods in an Interface

Before Java 8, **all methods** in an interface were **abstract**. Java 8 introduced **default and static methods**, and Java 9 introduced **private methods**.

### Types of Methods in an Interface

| Method Type         | Modifier                    | Implementation            | Since    |
| ------------------- | --------------------------- | ------------------------- | -------- |
| **Abstract Method** | `public abstract` (default) | No implementation         | Java 1.0 |
| **Default Method**  | `default`                   | Has implementation        | Java 8   |
| **Static Method**   | `static`                    | Has implementation        | Java 8   |
| **Private Method**  | `private`                   | Used inside the interface | Java 9   |

---

### 3.1 Abstract Methods (Default)

```java
interface Animal {
    void eat();  // Abstract method (No body)
}
```

✔ **All interface methods are `public` and `abstract` by default.**

---

### 3.2 Default Methods (Introduced in Java 8)

Allows adding new methods **without breaking existing implementations**.

```java
interface Animal {
    void eat();

    default void sleep() {
        System.out.println("Sleeping...");
    }
}

class Dog implements Animal {
    public void eat() {
        System.out.println("Dog is eating...");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();   // Output: Dog is eating...
        d.sleep(); // Output: Sleeping...
    }
}
```

✔ **`default` methods can be overridden in implementing classes.**

---

### 3.3 Static Methods (Introduced in Java 8)

Static methods belong to the interface and **cannot be overridden**.

```java
interface MathOperations {
    static int square(int x) {
        return x * x;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(MathOperations.square(5)); // Output: 25
    }
}
```

✔ **`static` methods are accessed using `InterfaceName.method()`.**

---

### 3.4 Private Methods (Introduced in Java 9)

Used **only inside the interface** to avoid code duplication.

```java
interface Logger {
    default void logInfo(String message) {
        log("INFO: " + message);
    }

    private void log(String message) {  // Private method
        System.out.println(message);
    }
}

class App implements Logger { }

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.logInfo("Application started!");
        // Output: INFO: Application started!
    }
}
```

✔ **`private` methods are useful for code reuse inside the interface.**

---

## 4. Fields in an Interface

- All fields in an interface are **public, static, and final** by default.
- They **must be initialized** at declaration.

```java
interface Config {
    int MAX_USERS = 100;  // Public, static, and final by default
}
```

✔ **Cannot modify `MAX_USERS` because it is `final`.**

---

## 5. Interface Implementation

A class uses the `implements` keyword to implement an interface.

```java
interface Animal {
    void makeSound();
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Woof Woof!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound();  // Output: Woof Woof!
    }
}
```

✔ **A class must implement all abstract methods of an interface.**

---

## 6. Nested Interfaces

A **nested interface** is an interface inside another interface or class.

### 6.1 Nested Interface Inside Another Interface

```java
interface Outer {
    interface Inner {
        void show();
    }
}

class Test implements Outer.Inner {
    public void show() {
        System.out.println("Nested Interface Implemented!");
    }
}

public class Main {
    public static void main(String[] args) {
        Outer.Inner obj = new Test();
        obj.show();  // Output: Nested Interface Implemented!
    }
}
```

✔ **Used in frameworks and API design.**

---

## 7. Difference Between Interface and Abstract Class

| Feature                  | Interface                                      | Abstract Class                                  |
| ------------------------ | ---------------------------------------------- | ----------------------------------------------- |
| **Definition**           | Blueprint with abstract methods                | Can have both abstract and concrete methods     |
| **Methods**              | Abstract, default, static, and private methods | Abstract and concrete methods                   |
| **Fields**               | Only `public static final` fields              | Can have `static`, `final`, and instance fields |
| **Constructors**         | No constructors                                | Can have constructors                           |
| **Access Modifiers**     | Methods are `public` by default                | Methods can have any access modifier            |
| **Multiple Inheritance** | A class can implement multiple interfaces      | A class can extend only one abstract class      |
| **Performance**          | Slower due to method lookup                    | Faster than interfaces                          |

---

# Default, Static & Private Methods in Interface - Java 8 & Java 9 Features

(📌 *Java Interfaces - Part 2*)

## 1. Introduction

Before **Java 8**, interfaces in Java could only have **abstract methods** (methods without a body). Java 8 introduced **default and static methods**, and Java 9 introduced **private methods**. These enhancements made interfaces more powerful while ensuring backward compatibility.

### Why Were These Features Introduced?

✔ To **add new methods** to interfaces **without breaking existing implementations**.
✔ To **avoid duplicate code** across multiple implementing classes.
✔ To provide **utility methods** inside interfaces using **static methods**.

---

## 2. Default Methods in Interface (Java 8)

A **default method** is a method with a body inside an interface. It provides a **default implementation** for implementing classes.

### Syntax:

```java
interface InterfaceName {
    default void methodName() {
        // method implementation
    }
}
```

### Example: Default Method in Interface

```java
interface Vehicle {
    void start(); // Abstract method

    default void stop() {  // Default method
        System.out.println("Vehicle is stopping...");
    }
}

class Car implements Vehicle {
    public void start() {
        System.out.println("Car is starting...");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.start(); // Output: Car is starting...
        car.stop();  // Output: Vehicle is stopping...
    }
}
```

✔ The `stop()` method **does not need to be implemented** in `Car` because it has a **default** implementation.

---

### 2.1 Overriding a Default Method

If a class needs a **custom implementation**, it can **override** the default method.

```java
class Bike implements Vehicle {
    public void start() {
        System.out.println("Bike is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Bike is stopping...");
    }
}

public class Main {
    public static void main(String[] args) {
        Bike bike = new Bike();
        bike.start(); // Output: Bike is starting...
        bike.stop();  // Output: Bike is stopping... (Overridden method)
    }
}
```

✔ **A default method can be overridden** in the implementing class.

---

### 2.2 Default Methods with Multiple Interfaces (Diamond Problem)

If a class implements **two interfaces** with the **same default method**, it **must override** the method to avoid ambiguity.

```java
interface InterfaceA {
    default void show() {
        System.out.println("InterfaceA show()");
    }
}

interface InterfaceB {
    default void show() {
        System.out.println("InterfaceB show()");
    }
}

class MyClass implements InterfaceA, InterfaceB {
    @Override
    public void show() {
        System.out.println("MyClass show() - Resolving conflict");
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.show(); // Output: MyClass show() - Resolving conflict
    }
}
```

✔ The implementing class must **override the method** to resolve the conflict.

---

## 3. Static Methods in Interface (Java 8)

A **static method** inside an interface **belongs to the interface itself** and **cannot be overridden** by implementing classes.

### Syntax:

```java
interface InterfaceName {
    static void methodName() {
        // method implementation
    }
}
```

### Example: Static Method in Interface

```java
interface Utility {
    static int square(int x) {
        return x * x;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Utility.square(5)); // Output: 25
    }
}
```

✔ **Static methods are accessed using `InterfaceName.method()`.**
✔ **They are not inherited by implementing classes.**

---

### 3.1 Static Methods Cannot Be Overridden

```java
interface Helper {
    static void display() {
        System.out.println("Helper Interface - Static Method");
    }
}

class Test implements Helper {
    // Cannot override static methods from an interface
}

public class Main {
    public static void main(String[] args) {
        Test obj = new Test();
        // obj.display(); // ❌ Error: Cannot access static method from an instance
        Helper.display(); // ✅ Correct way to call it
    }
}
```

✔ **Static methods belong to the interface, not the class implementing it.**

---

## 4. Private Methods in Interface (Java 9)

Java 9 introduced **private methods** in interfaces to **avoid code duplication** inside default and static methods.

### Syntax:

```java
interface InterfaceName {
    private void methodName() {
        // method implementation
    }
}
```

---

### 4.1 Example: Private Method Inside an Interface

```java
interface Logger {
    default void logInfo(String message) {
        log("INFO: " + message);
    }

    default void logError(String message) {
        log("ERROR: " + message);
    }

    private void log(String message) {  // Private method
        System.out.println(message);
    }
}

class App implements Logger { }

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.logInfo("Application started!");
        // Output: INFO: Application started!

        app.logError("Something went wrong!");
        // Output: ERROR: Something went wrong!
    }
}
```

✔ The `log()` method is used by both `logInfo()` and `logError()` **without being exposed** to the implementing class.
✔ **Private methods in an interface cannot be accessed outside the interface.**

---

## 5. Summary of Java 8 & Java 9 Interface Features

| Feature            | Java Version | Access Modifier | Purpose                                                                           |
| ------------------ | ------------ | --------------- | --------------------------------------------------------------------------------- |
| **Default Method** | Java 8       | `default`       | Allows adding new methods to interfaces without breaking existing implementations |
| **Static Method**  | Java 8       | `static`        | Provides utility methods inside interfaces                                        |
| **Private Method** | Java 9       | `private`       | Helps in code reuse inside default and static methods                             |

---

## 6. Key Takeaways

✔ **Default methods** allow interfaces to have method implementations.
✔ **Static methods** belong to the interface and cannot be overridden.
✔ **Private methods** help in **code reuse** inside the interface.
✔ **Default methods solve the problem of API evolution** without breaking existing implementations.
✔ **Diamond problem can arise with default methods** if two interfaces have the same method, requiring explicit overriding.

---

# Functional Interface and Lambda Expression - Java 8 Features

(📌 *Java Interfaces - Part 3*)

## 1. What is a Functional Interface?

A **functional interface** in Java is an interface that contains **exactly one abstract method**. It can have **multiple default and static methods** but must have **only one abstract method**.

### Key Points:

✔ Functional interfaces are introduced in **Java 8**.
✔ They are used for **Lambda Expressions** and **method references**.
✔ Annotated with `@FunctionalInterface` (optional but recommended).

### Example of a Functional Interface

```java
@FunctionalInterface
interface Greeting {
    void sayHello();  // Only one abstract method
}
```

✔ This interface qualifies as a **Functional Interface** because it has exactly **one abstract method**.

---

## 2. What is a Lambda Expression?

A **lambda expression** is a concise way to write **anonymous functions** in Java. It allows you to pass behavior as a parameter.

### Syntax of Lambda Expression:

```java
(parameters) -> { body }
```

---

## 3. How to Use Functional Interfaces with Lambda Expressions?

A **lambda expression** can be used to implement a **functional interface** directly.

### Example: Using a Lambda Expression with a Functional Interface

```java
@FunctionalInterface
interface Greeting {
    void sayHello();
}

public class Main {
    public static void main(String[] args) {
        // Using Lambda Expression
        Greeting greet = () -> System.out.println("Hello, World!");
        greet.sayHello(); // Output: Hello, World!
    }
}
```

✔ The lambda expression `() -> System.out.println("Hello, World!")` replaces the need for a traditional class implementation.

---

## 4. Advantage of Functional Interfaces

| Feature                                   | Benefit                                |
| ----------------------------------------- | -------------------------------------- |
| **Less Boilerplate Code**                 | Eliminates anonymous class syntax      |
| **More Readable Code**                    | Simplifies function definitions        |
| **Used in Streams & Parallel Processing** | Enhances Java functional programming   |
| **Supports Method References**            | Allows passing behavior as a parameter |

---

## 5. Types of Functional Interfaces

Java provides four main functional interfaces in the `java.util.function` package:

### 5.1 Consumer (Accepts a value, returns nothing)

A **Consumer** takes **one input parameter** but **does not return** a value.

```java
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Consumer<String> print = message -> System.out.println("Message: " + message);
        print.accept("Hello Java 8!"); // Output: Message: Hello Java 8!
    }
}
```

✔ **Use Case:** Logging, performing actions without returning values.

---

### 5.2 Supplier (Returns a value, takes nothing)

A **Supplier** does **not take any input** but **returns a value**.

```java
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<Double> getRandom = () -> Math.random();
        System.out.println(getRandom.get()); // Output: Random number
    }
}
```

✔ **Use Case:** Generating values (random numbers, timestamps).

---

### 5.3 Function (Takes input, returns output)

A **Function** takes **one input** and **returns one output**.

```java
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Integer, Integer> square = x -> x * x;
        System.out.println(square.apply(5)); // Output: 25
    }
}
```

✔ **Use Case:** Data transformation, mapping.

---

### 5.4 Predicate (Takes input, returns boolean)

A **Predicate** takes **one input** and **returns a boolean value**.

```java
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(10)); // Output: true
    }
}
```

✔ **Use Case:** Filtering, conditional checks.

---

## 6. How to Handle Functional Interface Extending Another Interface?

A functional interface **can extend another interface**, but it must still have **only one abstract method**.

### Case 1: Extending a Functional Interface

```java
@FunctionalInterface
interface A {
    void methodA();
}

@FunctionalInterface
interface B extends A { // Extends A, no new abstract method
}
```

✔ `B` is still a **valid functional interface** because it inherits `methodA()`.

---

### Case 2: Adding a New Abstract Method (Invalid Case)

```java
@FunctionalInterface
interface A {
    void methodA();
}

@FunctionalInterface
interface B extends A {
    void methodB(); // ❌ Error: More than one abstract method
}
```

❌ This will cause a **compilation error** because `B` now has **two abstract methods**.

---

### Case 3: Extending a Non-Functional Interface

If an interface **extends a non-functional interface**, it can **still be functional** if it introduces only **one abstract method**.

```java
interface A {
    default void defaultMethod() {
        System.out.println("Default method in A");
    }
}

@FunctionalInterface
interface B extends A {
    void methodB(); // Only one abstract method
}
```

✔ `B` is still a **valid functional interface** because it has **only one abstract method**.

---

## 7. Summary

| Feature                             | Explanation                                                      |
| ----------------------------------- | ---------------------------------------------------------------- |
| **Functional Interface**            | An interface with **only one abstract method**                   |
| **Lambda Expression**               | A concise way to write function implementations                  |
| **Consumer**                        | Takes an input, **returns nothing**                              |
| **Supplier**                        | Takes **no input**, returns a **value**                          |
| **Function**                        | Takes an input, returns **a transformed value**                  |
| **Predicate**                       | Takes an input, returns **a boolean result**                     |
| **Extending Functional Interfaces** | The child interface must still have **only one abstract method** |

---
