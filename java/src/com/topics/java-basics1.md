# Java Basics

## Table of Contents

### Part 1 | OOP Concepts in Java
- [1. Encapsulation](#1-encapsulation)
- [2. Inheritance](#2-inheritance)
- [3. Polymorphism](#3-polymorphism)
- [4. Abstraction](#4-abstraction)
- [Summary](#summary)

### Part 2 | How Java Program Works and its 3 Important Components
- [How a Java Program Works?](#how-a-java-program-works)
  - [Example: Simple Java Program](#example-simple-java-program)
  - [Execution Flow](#execution-flow)
- [3 Important Components of Java](#3-important-components-of-java)
  - [1. JVM (Java Virtual Machine)](#1-jvm-java-virtual-machine)
  - [2. JRE (Java Runtime Environment)](#2-jre-java-runtime-environment)
  - [3. JDK (Java Development Kit)](#3-jdk-java-development-kit)
- [JVM vs. JRE vs. JDK – Quick Comparison](#jvm-vs-jre-vs-jdk--quick-comparison)

### Part 3 | Java Variables - Part 1 | Primitive Data Types in Depth
- [1. What is a Variable in Java?](#1-what-is-a-variable-in-java)
- [2. Java Primitive Data Types](#2-java-primitive-data-types)
- [3. Understanding Each Primitive Type in Depth](#3-understanding-each-primitive-type-in-depth)
  - [🔹 Integer Data Types](#-integer-data-types)
  - [🔹 Floating-Point Data Types (Decimal Numbers)](#-floating-point-data-types-decimal-numbers)
  - [🔹 Character Data Type](#-character-data-type)
  - [🔹 Boolean Data Type](#-boolean-data-type)
- [4. Default Values of Primitive Data Types](#4-default-values-of-primitive-data-types)
- [5. Type Conversion & Type Casting](#5-type-conversion--type-casting)
- [6. Wrapper Classes for Primitive Data Types](#6-wrapper-classes-for-primitive-data-types)

### Part 4 | How FLOAT and DOUBLE Numbers are Stored in Memory? | IEEE 754 Representation
- [1. Introduction to Floating-Point Representation](#1-introduction-to-floating-point-representation)
- [2. IEEE 754 Floating-Point Format](#2-ieee-754-floating-point-format)
- [3. Example: Storing a Floating-Point Number (Step-by-Step)](#3-example-storing-a-floating-point-number-step-by-step)
- [4. IEEE 754 Double Precision (64-bit) Example](#4-ieee-754-double-precision-64-bit-example)
- [5. Special Cases in IEEE 754](#5-special-cases-in-ieee-754)
- [6. Precision and Rounding Errors](#6-precision-and-rounding-errors)
- [7. Comparison: `float` vs `double`](#7-comparison-float-vs-double)

### Part 5 | Java Variables - Part 2 | Reference (Non-Primitive) Data Types in Depth
- [1. Introduction to Reference Data Types](#1-introduction-to-reference-data-types)
- [2. Types of Reference (Non-Primitive) Data Types](#2-types-of-reference-non-primitive-data-types)
- [3. Reference Data Types in Detail](#3-reference-data-types-in-detail)
  - [🔹 1. Class Type (`String`, Wrapper Classes, and Objects)](#-1-class-type-string-wrapper-classes-and-objects)
  - [🔹 2. Array Type (Fixed-Size Collections)](#-2-array-type-fixed-size-collections)
  - [🔹 3. Interface Type (`List`, `Map`, `Set`)](#-3-interface-type-list-map-set)
  - [🔹 4. User-Defined Objects (Instances of a Class)](#-4-user-defined-objects-instances-of-a-class)
- [4. Default Values of Reference Data Types](#4-default-values-of-reference-data-types)
- [5. Difference Between Primitive and Reference Data Types](#5-difference-between-primitive-and-reference-data-types)
- [6. Memory Allocation: Stack vs Heap](#6-memory-allocation-stack-vs-heap)
- [7. Garbage Collection & `null` References](#7-garbage-collection--null-references)

### Part 6 | Java Methods in Depth | Different Types of Methods with Examples
- [1. What is a Method in Java?](#1-what-is-a-method-in-java)
- [2. Method Syntax in Java](#2-method-syntax-in-java)
- [3. Types of Methods in Java](#3-types-of-methods-in-java)
- [4. Predefined (Built-in) Methods](#4-predefined-built-in-methods)
- [5. User-Defined Methods](#5-user-defined-methods)
- [6. Static vs Non-Static Methods](#6-static-vs-non-static-methods)
- [7. Method Overloading (Same Name, Different Parameters)](#7-method-overloading-same-name-different-parameters)
- [8. Method Overriding (Same Signature, Different Behavior)](#8-method-overriding-same-signature-different-behavior)
- [9. Recursive Method (A Method Calling Itself)](#9-recursive-method-a-method-calling-itself)
- [10. Pass-by-Value in Java Methods](#10-pass-by-value-in-java-methods)
- [11. Return Types and `void`](#11-return-types-and-void)

### Part 7 | Java Constructor in Depth | Different Types of Constructors with Examples
- [1. What is a Constructor in Java?](#1-what-is-a-constructor-in-java)
- [2. Syntax of a Constructor](#2-syntax-of-a-constructor)
- [3. Types of Constructors in Java](#3-types-of-constructors-in-java)
- [4. Default (No-Argument) Constructor](#4-default-no-argument-constructor)
- [5. Parameterized Constructor](#5-parameterized-constructor)
- [6. Copy Constructor](#6-copy-constructor)
- [7. Constructor Overloading](#7-constructor-overloading)
- [8. Constructor Chaining](#8-constructor-chaining)
- [9. Super Constructor (`super()`)](#9-super-constructor-super)
- [10. Private Constructor (Singleton Design Pattern)](#10-private-constructor-singleton-design-pattern)
- [11. Difference Between Constructor and Method](#11-difference-between-constructor-and-method)

### Part 8 | Java Classes in Depth - Part 1: Nested Class, Concrete, Abstract, Object, Super and Sub Class
- [1. What is a Class in Java?](#1-what-is-a-class-in-java)
- [2. Objects in Java](#2-objects-in-java)
- [3. Concrete Class in Java](#3-concrete-class-in-java)
- [4. Abstract Class in Java](#4-abstract-class-in-java)
- [5. Super and Sub Classes](#5-super-and-sub-classes)
  - [5.1 Superclass (Parent Class)](#51-superclass-parent-class)
  - [5.2 Subclass (Child Class)](#52-subclass-child-class)
- [6. Nested Classes in Java](#6-nested-classes-in-java)
  - [6.1 Static Nested Class](#61-static-nested-class)
  - [6.2 Non-Static (Inner) Class](#62-non-static-inner-class)
  - [6.3 Local Inner Class](#63-local-inner-class)
  - [6.4 Anonymous Inner Class](#64-anonymous-inner-class)
- [7. Summary](#7-summary)

### Part 9 | Java Generic Classes | Java Classes in Depth - Part 2
- [1. Introduction to Java Generics](#1-introduction-to-java-generics)
- [2. Generic Classes in Java](#2-generic-classes-in-java)
  - [2.1 Creating a Generic Class](#21-creating-a-generic-class)
  - [2.2 Multiple Type Parameters in a Generic Class](#22-multiple-type-parameters-in-a-generic-class)
- [3. Generic Methods in Java](#3-generic-methods-in-java)
  - [3.1 Creating a Generic Method](#31-creating-a-generic-method)
- [4. Bounded Type Parameters in Generics](#4-bounded-type-parameters-in-generics)
  - [4.1 Using Upper Bounded Wildcards (`extends`)](#41-using-upper-bounded-wildcards-extends)
- [5. Wildcards in Generics](#5-wildcards-in-generics)
  - [5.1 Unbounded Wildcard (`<?>`)](#51-unbounded-wildcard-)
  - [5.2 Upper Bounded Wildcard (`<? extends Type>`)](#52-upper-bounded-wildcard--extends-type)
- [6. Generic Interfaces](#6-generic-interfaces)
  - [6.1 Creating a Generic Interface](#61-creating-a-generic-interface)
- [7. Summary](#7-summary-1)

---

# OOP Concepts in Java

In Java, **Object-Oriented Programming (OOP)** is a programming paradigm that is based on the concept of **objects**. It allows developers to model real-world entities using objects. OOP in Java is centered around four main pillars:

## 1. Encapsulation

Encapsulation is the mechanism of wrapping data (variables) and methods (functions) together as a single unit. It restricts direct access to certain components of an object and provides controlled access through methods. This is often implemented using **private** variables with **public** getter and setter methods.

**Example:**

```java
class Student {
    private String name;
    private int age;

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        if(age > 0) {
            this.age = age;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("John");
        student.setAge(21);
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
    }
}
```

**Output:**
```
Name: John
Age: 21
```

**Explanation:** Here, the `name` and `age` variables are private, so they cannot be accessed directly. We use public getter and setter methods to access and modify them, providing controlled access.

## 2. Inheritance

Inheritance allows a class to inherit properties and methods from another class. The class that inherits is called the **subclass** or **child class**, and the class from which it inherits is called the **superclass** or **parent class**. Inheritance promotes **code reusability**.

**Example:**

```java
class Animal {
    void eat() {
        System.out.println("This animal eats food.");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("The dog barks.");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();  // Inherited method
        dog.bark(); // Child class method
    }
}
```

**Output:**
```
This animal eats food.
The dog barks.
```

**Explanation:** The `Dog` class inherits the `eat` method from the `Animal` class and has its own method `bark`.

## 3. Polymorphism

Polymorphism allows objects to be treated as instances of their parent class rather than their actual class. There are two types of polymorphism in Java:

* **Compile-time polymorphism** (Method Overloading)
* **Runtime polymorphism** (Method Overriding)

**Example of Method Overloading:**

```java
class MathUtils {
    // Overloaded method with two parameters
    int add(int a, int b) {
        return a + b;
    }

    // Overloaded method with three parameters
    int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        MathUtils math = new MathUtils();
        System.out.println("Sum (2 params): " + math.add(5, 10));
        System.out.println("Sum (3 params): " + math.add(5, 10, 15));
    }
}
```

**Output:**
```
Sum (2 params): 15
Sum (3 params): 30
```

**Example of Method Overriding:**

```java
class Vehicle {
    void move() {
        System.out.println("The vehicle is moving");
    }
}

class Car extends Vehicle {
    @Override
    void move() {
        System.out.println("The car is driving");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        myCar.move(); // Calls the overridden method in Car class
    }
}
```

**Output:**
```
The car is driving
```

**Explanation:** In method overriding, the `move` method in the `Car` class overrides the `move` method in the `Vehicle` class.

## 4. Abstraction

Abstraction is the process of hiding implementation details and showing only essential features of an object. In Java, abstraction is achieved using **abstract classes** and **interfaces**.

**Example using Abstract Class:**

```java
abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

public class Main {
    public static void main(String[] args) {
        Shape shape = new Circle();
        shape.draw();
    }
}
```

**Output:**
```
Drawing a circle
```

**Example using Interface:**

```java
interface Drawable {
    void draw();
}

class Rectangle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

public class Main {
    public static void main(String[] args) {
        Drawable drawable = new Rectangle();
        drawable.draw();
    }
}
```

**Output:**
```
Drawing a rectangle
```

**Explanation:** The `Shape` class is abstract, so it cannot be instantiated. The `draw` method is implemented by its subclass `Circle`. Similarly, the `Drawable` interface defines the `draw` method, which is implemented by the `Rectangle` class.

## Summary

* **Encapsulation**: Bundling of data and methods together; controlled access.
* **Inheritance**: Code reuse through class hierarchy.
* **Polymorphism**: One interface, multiple implementations (overloading and overriding).
* **Abstraction**: Hiding implementation details, exposing only essential features.

These principles form the backbone of OOP in Java, allowing for flexible, maintainable, and reusable code.

---

# How Java Program Works and its 3 Important Components (JVM, JRE and JDK) with Example

![][image1]

Here are clear and concise notes on **How a Java Program Works** and its **3 Important Components: JVM, JRE, and JDK** with an example.

---

## How a Java Program Works?

A Java program goes through **three main steps** before execution:

1. **Writing Code:**
   * The developer writes Java source code (`.java` file).
2. **Compilation:**
   * The Java Compiler (`javac`) converts the `.java` file into **bytecode** (`.class` file).
3. **Execution:**
   * The Java Virtual Machine (JVM) interprets the bytecode and runs the program.

### Example: Simple Java Program

```java
// HelloWorld.java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

### Execution Flow:

**Compilation:**
```bash
javac HelloWorld.java
```
1. Produces `HelloWorld.class` (bytecode).

**Execution:**
```bash
java HelloWorld
```
2. JVM interprets `HelloWorld.class` and prints:
```
Hello, World!
```

---

## 3 Important Components of Java

### 1. JVM (Java Virtual Machine)

**Definition:**
JVM is an engine that **executes Java bytecode** by converting it into machine code (specific to the OS).

**Key Responsibilities of JVM:**

✅ **Loads** bytecode (.class files).
✅ **Verifies** bytecode for security.
✅ **Interprets** or **compiles** the code using Just-In-Time (JIT) Compilation.
✅ **Manages memory** via Garbage Collection (GC).

**JVM is OS-dependent**

Each OS (Windows, Linux, Mac) has its own JVM implementation.

---

### 2. JRE (Java Runtime Environment)

**Definition:**
JRE is a package that **contains JVM + essential libraries** needed to run Java applications.

**What JRE Includes?**

✔ **JVM** (to run bytecode)
✔ **Core Libraries** (e.g., `java.lang`, `java.util`)
✔ **Runtime Components** (memory management, garbage collection)

**Use Case:**

JRE is needed **only to run Java programs**, not to develop them.

---

### 3. JDK (Java Development Kit)

**Definition:**
JDK is a full software development kit that includes **JRE + development tools** (compiler, debugger, etc.).

**What JDK Includes?**

✔ **JRE** (JVM + Libraries)
✔ **Compiler (`javac`)** - Converts `.java` to `.class`
✔ **Debugger (`jdb`)** - Debugging tool
✔ **Other Tools** - `jar`, `javadoc`, etc.

**Use Case:**

JDK is needed **to develop and run Java programs**.

---

## JVM vs. JRE vs. JDK – Quick Comparison

| Feature                      | JVM | JRE | JDK |
| ---------------------------- | --- | --- | --- |
| Contains JVM?                | ✅   | ✅   | ✅   |
| Contains Core Libraries?     | ❌   | ✅   | ✅   |
| Contains Compiler (`javac`)? | ❌   | ❌   | ✅   |
| Needed for Development?      | ❌   | ❌   | ✅   |
| Needed for Running Java?     | ✅   | ✅   | ✅   |

---

# Java Variables - Part 1 | Primitive Data Types in Depth

## 1. What is a Variable in Java?

A **variable** in Java is a **named memory location** used to store data. Every variable has:

* **Type** (data type)
* **Name** (identifier)
* **Value** (assigned data)

**Example: Declaring Variables**
```java
int age = 25;        // age stores an integer value
double price = 99.99; // price stores a decimal value
```

---

## 2. Java Primitive Data Types

Java has **8 primitive data types**, categorized as **Numeric, Character, and Boolean**.

| Data Type | Size              | Default Value   | Example Value          | Category       |
| --------- | ----------------- | --------------- | ---------------------- | -------------- |
| `byte`    | 1 byte (8 bits)   | `0`             | `127`                  | Integer        |
| `short`   | 2 bytes (16 bits) | `0`             | `32767`                | Integer        |
| `int`     | 4 bytes (32 bits) | `0`             | `2147483647`           | Integer        |
| `long`    | 8 bytes (64 bits) | `0L`            | `9223372036854775807L` | Integer        |
| `float`   | 4 bytes (32 bits) | `0.0f`          | `3.14f`                | Floating-point |
| `double`  | 8 bytes (64 bits) | `0.0d`          | `3.141592653589793`    | Floating-point |
| `char`    | 2 bytes (16 bits) | `\u0000` (null) | `'A'`, `'9'`, `'#'`    | Character      |
| `boolean` | 1 bit (varies)    | `false`         | `true`, `false`        | Boolean        |

---

## 3. Understanding Each Primitive Type in Depth

### 🔹 Integer Data Types

#### 1️⃣ byte (8-bit)

* Stores small integers (-128 to 127).
* Useful for memory-efficient applications.

```java
byte smallNumber = 100;
```

#### 2️⃣ short (16-bit)

* Stores integers (-32,768 to 32,767).
* Rarely used, except for memory optimization.

```java
short shortNum = 32000;
```

#### 3️⃣ int (32-bit)

* Most commonly used integer type (-2^31 to 2^31 - 1).

```java
int num = 100000;
```

#### 4️⃣ long (64-bit)

* Used when `int` is not enough (-2^63 to 2^63 - 1).
* Requires `L` or `l` at the end.

```java
long bigNumber = 9223372036854775807L;
```

---

### 🔹 Floating-Point Data Types (Decimal Numbers)

#### 5️⃣ float (32-bit)

* Stores decimal numbers with less precision.
* Requires `f` or `F` at the end.

```java
float pi = 3.14f;
```

#### 6️⃣ double (64-bit)

* More precise than `float`.
* Default for decimal values.

```java
double price = 99.99;
```

✅ **Why Use `double` Over `float`?**

* `double` provides **higher precision** than `float`.
* **Use `float` only when memory is a concern**.

---

### 🔹 Character Data Type

#### 7️⃣ char (16-bit)

* Stores **a single character** (Unicode-based).
* Uses **single quotes `' '`**.

```java
char letter = 'A';
char digit = '9';
char symbol = '#';
char unicodeChar = '\u20AC'; // Unicode for €
```

---

### 🔹 Boolean Data Type

#### 8️⃣ boolean (1-bit)

* Stores **only `true` or `false`**.

```java
boolean isJavaFun = true;
boolean isCold = false;
```

---

## 4. Default Values of Primitive Data Types

If a primitive variable is not assigned a value, Java assigns a **default value**:

```java
class DefaultValues {
    byte b;      // Default: 0
    short s;     // Default: 0
    int i;       // Default: 0
    long l;      // Default: 0L
    float f;     // Default: 0.0f
    double d;    // Default: 0.0d
    char c;      // Default: '\u0000' (null)
    boolean bool;// Default: false

    void showDefaults() {
        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char: [" + c + "]");
        System.out.println("boolean: " + bool);
    }

    public static void main(String[] args) {
        DefaultValues obj = new DefaultValues();
        obj.showDefaults();
    }
}
```

🔹 **Output:**

```
byte: 0
short: 0
int: 0
long: 0
float: 0.0
double: 0.0
char: []
boolean: false
```

✅ **Key Takeaways:**

* **Numeric types default to `0` or `0.0`**.
* **`char` defaults to `'\u0000'` (null character).**
* **`boolean` defaults to `false`**.

---

## 5. Type Conversion & Type Casting

### Implicit (Widening) Type Conversion

* **Small → Large data type (Automatic)**

```java
int num = 100;
double bigNum = num;  // int → double (automatic)
System.out.println(bigNum);  // 100.0
```

### Explicit (Narrowing) Type Casting

* **Large → Small data type (Manual, data loss possible)**

```java
double pi = 3.14159;
int approxPi = (int) pi;  // double → int (manual)
System.out.println(approxPi);  // 3
```

---

## 6. Wrapper Classes for Primitive Data Types

Primitive types **don't have methods**, but Java provides **Wrapper Classes** in `java.lang` package.

| Primitive | Wrapper Class |
| --------- | ------------- |
| `byte`    | `Byte`        |
| `short`   | `Short`       |
| `int`     | `Integer`     |
| `long`    | `Long`        |
| `float`   | `Float`       |
| `double`  | `Double`      |
| `char`    | `Character`   |
| `boolean` | `Boolean`     |

**Example: Using Wrapper Classes**
```java
int num = 10;
Integer obj = num;  // Auto-boxing
int newNum = obj;   // Unboxing
System.out.println(obj + " " + newNum);
```

✅ **Auto-boxing:** Converting primitive to object.
✅ **Unboxing:** Converting object to primitive.

---

# How FLOAT and DOUBLE Numbers are Stored in Memory? | IEEE 754 Representation

## 1. Introduction to Floating-Point Representation

In Java, `float` and `double` data types store **decimal numbers** using **IEEE 754 Floating-Point Standard**.

* `float` (4 bytes = 32 bits) → **Single Precision (IEEE 754 32-bit)**
* `double` (8 bytes = 64 bits) → **Double Precision (IEEE 754 64-bit)**

**Key Points:**

✔ **Floating-point numbers use binary representation (0s and 1s).**
✔ **They are stored in three parts: Sign, Exponent, and Mantissa (Fraction).**
✔ **Uses scientific notation for efficient storage.**

---

## 2. IEEE 754 Floating-Point Format

A floating-point number is stored as:

**Value = (-1)^Sign Bit × 2^(Exponent - Bias) × (1 + Fraction)**

### IEEE 754 Structure:

| Data Type  | Bits | Sign Bit | Exponent | Fraction (Mantissa) |
| ---------- | ---- | -------- | -------- | ------------------- |
| **float**  | 32   | 1        | 8        | 23                  |
| **double** | 64   | 1        | 11       | 52                  |

✅ **Sign Bit (1 bit)**

* `0` → Positive number
* `1` → Negative number

✅ **Exponent (8 bits for float, 11 bits for double)**

* Represents **the power of 2**.
* Stored using **"Bias" method** (Bias = 127 for `float`, 1023 for `double`).

✅ **Fraction/Mantissa (23 bits for float, 52 bits for double)**

* Stores the **significant digits** of the number.

---

## 3. Example: Storing a Floating-Point Number (Step-by-Step)

Let's store **9.625** in **IEEE 754 32-bit format** (`float`).

### Step 1: Convert to Binary

Convert **9.625 (Decimal) → Binary**:

```
9.625₁₀ = 1001.101₂
```

### Step 2: Normalize to Scientific Notation

Shift the decimal point to get **1.001101 × 2³**

* **1.001101** → Mantissa
* **3 (Exponent in Decimal)**

### Step 3: Convert Exponent to IEEE 754 Format

* **Bias for `float` = 127**
* **Stored Exponent** = `Exponent + Bias = 3 + 127 = 130`
* Convert `130` to **Binary**: `10000010` (8 bits)

### Step 4: Store the IEEE 754 Components

| Component    | Value                     |
| ------------ | ------------------------- |
| **Sign Bit** | `0` (Positive)            |
| **Exponent** | `10000010` (130)          |
| **Mantissa** | `00110100000000000000000` |

✅ **Final IEEE 754 32-bit Representation (Binary):**

```
0 10000010 00110100000000000000000
```

✅ **Final IEEE 754 32-bit Representation (Hex):**

```
0x411A0000
```

---

## 4. IEEE 754 Double Precision (64-bit) Example

For **9.625 in IEEE 754 64-bit (`double`)**, the steps are the same:

* Bias = **1023**
* Exponent = `3 + 1023 = 1026` → **Binary: `10000000010`**
* Mantissa expands to **52 bits**

**Final IEEE 754 64-bit Representation:**

```
0 10000000010 0011010000000000000000000000000000000000000000000000
```

---

## 5. Special Cases in IEEE 754

| Case           | Sign   | Exponent   | Mantissa                  | Meaning                        |
| -------------- | ------ | ---------- | ------------------------- | ------------------------------ |
| `0.0`          | 0      | `00000000` | `00000000000000000000000` | Zero                           |
| `Infinity`     | 0 or 1 | `11111111` | `00000000000000000000000` | ±∞                             |
| `NaN`          | 0 or 1 | `11111111` | `Non-zero Mantissa`       | Not-a-Number (NaN)             |
| `Denormalized` | 0 or 1 | `00000000` | `Non-zero Mantissa`       | Subnormal (very small numbers) |

---

## 6. Precision and Rounding Errors

* `float` (32-bit) can represent **only 7–8 decimal digits**.
* `double` (64-bit) can represent **15–16 decimal digits**.
* Some decimal numbers **can't be represented exactly in binary**, leading to precision errors.

### Example of Precision Loss
```java
public class PrecisionTest {
    public static void main(String[] args) {
        float f = 0.1f + 0.2f;  // Expected: 0.3
        double d = 0.1 + 0.2;    // Expected: 0.3

        System.out.println("float result: " + f);  // Output: 0.30000001
        System.out.println("double result: " + d); // Output: 0.30000000000000004
    }
}
```

🔹 **Why?** Some decimal numbers **can't be exactly represented in binary**, causing rounding errors.

✅ **Solution:** Use **BigDecimal** for precise calculations.

```java
import java.math.BigDecimal;

public class BigDecimalExample {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.2");
        BigDecimal sum = a.add(b);
        System.out.println("Accurate Sum: " + sum);  // Output: 0.3
    }
}
```

---

## 7. Comparison: `float` vs `double`

| Feature           | `float` (32-bit)          | `double` (64-bit)             |
| ----------------- | ------------------------- | ----------------------------- |
| **Size**          | 4 bytes                   | 8 bytes                       |
| **Precision**     | ~7 decimal digits         | ~15 decimal digits            |
| **Exponent Bits** | 8 bits                    | 11 bits                       |
| **Mantissa Bits** | 23 bits                   | 52 bits                       |
| **Use Case**      | Graphics, Low Memory Apps | Scientific Computing, Finance |

✅ **When to Use `float`?**

* When memory is limited (e.g., **embedded systems, graphics**).
* When precision isn't critical.

✅ **When to Use `double`?**

* When **higher precision** is needed (**scientific computing, finance**).

---

# Java Variables - Part 2 | Reference (Non-Primitive) Data Types in Depth

## 1. Introduction to Reference Data Types

Unlike **primitive data types**, reference (or **non-primitive**) data types store **memory addresses** that reference objects instead of directly storing data.

**Key Characteristics of Reference Data Types:**

✔ **Stores a memory reference (address) to the actual object.**
✔ **Created using the `new` keyword (except for `String`, which can also be assigned directly).**
✔ **Can have built-in methods and properties.**
✔ **Default value is `null` if not initialized.**

---

## 2. Types of Reference (Non-Primitive) Data Types

Java has **several types** of reference data types:

1️⃣ **Class Types** (`String`, `Integer`, `Scanner`, `Date`, etc.)
2️⃣ **Array Types** (`int[]`, `String[]`, `double[][]`, etc.)
3️⃣ **Interface Types** (`List`, `Map`, `Runnable`, etc.)
4️⃣ **User-Defined Objects** (Objects of classes)

---

## 3. Reference Data Types in Detail

### 🔹 1. Class Type (`String`, Wrapper Classes, and Objects)

#### `String` Class (Immutable Object)

* `String` is a **reference type**, not a primitive, but behaves like one.
* Can be created using **String literals** (stored in **String Pool**) or using `new`.

```java
public class StringExample {
    public static void main(String[] args) {
        String s1 = "Java";   // Stored in String Pool
        String s2 = new String("Java"); // Stored in Heap
        System.out.println(s1.equals(s2)); // true (checks content)
        System.out.println(s1 == s2); // false (checks reference)
    }
}
```

✅ **Key Notes:**

* `String` objects are **immutable** (cannot be changed once created).
* **`==` compares references, `.equals()` compares content**.

#### Wrapper Classes (Auto-Boxing & Unboxing)

Java provides **wrapper classes** for primitive types, allowing them to be used as objects.

```java
Integer num = 100;  // Auto-boxing (int → Integer)
int newNum = num;   // Unboxing (Integer → int)
System.out.println(num + " " + newNum);
```

---

### 🔹 2. Array Type (Fixed-Size Collections)

* Arrays store **multiple values of the same type** in contiguous memory locations.
* Arrays are **reference types** because they store the memory address of the first element.

```java
int[] numbers = {10, 20, 30};  // Array of integers
String[] names = new String[3]; // Array of Strings (default: null)
```

✅ **Key Notes:**

* Arrays **must have a fixed size**.
* Default values depend on the element type (e.g., `int[]` defaults to `0`, `String[]` defaults to `null`).

---

### 🔹 3. Interface Type (`List`, `Map`, `Set`)

* Java **interfaces** define methods but do not implement them.
* Objects of interface types **must be assigned an instance of a class** implementing them.

```java
import java.util.*;

public class InterfaceExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(); // Interface reference
        list.add("Java");
        list.add("Python");
        System.out.println(list);
    }
}
```

✅ **Key Notes:**

* `List` is an **interface**, but `ArrayList` is a **class that implements it**.
* Interfaces allow **polymorphism** and **loose coupling**.

---

### 🔹 4. User-Defined Objects (Instances of a Class)

Java allows **creating objects from custom classes**.

```java
class Person {
    String name;
    int age;

    // Constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println(name + " is " + age + " years old.");
    }
}

public class ObjectExample {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 25);
        p1.display();  // Output: Alice is 25 years old.
    }
}
```

✅ **Key Notes:**

* `p1` is a **reference variable** storing the address of the `Person` object.
* Multiple reference variables **can point to the same object**.

```java
Person p2 = p1;  // p2 now references the same object as p1
```

---

## 4. Default Values of Reference Data Types

If reference variables are **not initialized**, they default to `null`.

```java
String str;
Person p;
System.out.println(str); // null
System.out.println(p);   // null
```

**⚠ NullPointerException (NPE) occurs if we call methods on `null` references.**

---

## 5. Difference Between Primitive and Reference Data Types

| Feature           | Primitive Data Types                           | Reference Data Types                   |
| ----------------- | ---------------------------------------------- | -------------------------------------- |
| **Storage**       | Stored in **stack**                            | Stored in **heap**, reference in stack |
| **Memory Size**   | Fixed (depends on type)                        | Varies (depends on object)             |
| **Default Value** | Numeric: `0`, Boolean: `false`, Char: `\u0000` | `null`                                 |
| **Methods**       | No methods available                           | Methods available                      |
| **Examples**      | `int`, `char`, `boolean`                       | `String`, `Arrays`, `Objects`, `List`  |

✅ **When to Use Primitive vs Reference?**

* **Use primitives** for efficiency (e.g., `int`, `double`).
* **Use references** for complex objects (`String`, `List`, `Map`).

---

## 6. Memory Allocation: Stack vs Heap

Java uses **stack** and **heap memory** for storing variables.

### 1️⃣ **Stack Memory (Method Execution & Primitive Variables)**

* Stores **method calls, local variables, and primitive data types**.
* **Fast access** but limited in size.

### 2️⃣ **Heap Memory (Objects & Reference Variables)**

* Stores **objects created using `new`**.
* Larger but **slower than stack**.
* Requires **Garbage Collection** for memory management.

**Example: Stack vs Heap Memory**
```java
class Demo {
    int x = 10;  // Instance variable (Heap)

    public static void main(String[] args) {
        int a = 5;  // Stored in Stack
        Demo d = new Demo();  // d is in Stack, but object in Heap
    }
}
```

---

## 7. Garbage Collection & `null` References

* Objects **not referenced by any variable** are **eligible for garbage collection**.
* `System.gc();` **requests** garbage collection (not guaranteed).

```java
class Example {
    void show() {
        System.out.println("Hello");
    }
}

public class GarbageDemo {
    public static void main(String[] args) {
        Example obj = new Example();
        obj = null;  // Eligible for GC
    }
}
```

✅ **Key Notes:**

* `null` means **no reference** to an object.
* Objects without references are **garbage collected automatically**.

---

# Java Methods in Depth | Different Types of Methods with Examples

## 1. What is a Method in Java?

A **method** in Java is a **block of code** that performs a specific task. Methods improve **code reusability**, **readability**, and **modularity**.

**Key Characteristics of Methods:**

✔ **Defined inside a class**.
✔ Can **return a value** or be `void`.
✔ Can take **parameters (inputs)**.
✔ Can be called multiple times (**reusability**).

---

## 2. Method Syntax in Java

```java
returnType methodName(parameters) {
    // method body
    return value; // if returnType is not void
}
```

**Example: Simple Method**
```java
public class MethodExample {
    static void greet() {
        System.out.println("Hello, welcome to Java!");
    }

    public static void main(String[] args) {
        greet(); // Calling the method
    }
}
```

✔ **`static`** → Allows calling method without creating an object.
✔ **`void`** → No return value.

---

## 3. Types of Methods in Java

Java methods are broadly classified into:

1️⃣ **Predefined (Built-in) Methods**
2️⃣ **User-Defined Methods**
3️⃣ **Parameterized vs Non-Parameterized Methods**
4️⃣ **Static vs Non-Static Methods**
5️⃣ **Method Overloading**
6️⃣ **Method Overriding**
7️⃣ **Recursive Methods**

---

## 4. Predefined (Built-in) Methods

Java provides many **built-in methods** from standard libraries like `Math`, `String`, etc.

**Example: Using Built-in Methods**
```java
public class BuiltInMethods {
    public static void main(String[] args) {
        int max = Math.max(10, 20);  // Returns maximum value
        double sqrt = Math.sqrt(16); // Returns square root
        String s = "Java".toLowerCase(); // Converts to lowercase

        System.out.println(max);  // 20
        System.out.println(sqrt); // 4.0
        System.out.println(s);    // java
    }
}
```

---

## 5. User-Defined Methods

**Methods created by programmers** to perform specific tasks.

### (a) Non-Parameterized Method (No Input)
```java
public class UserDefinedMethods {
    static void sayHello() {
        System.out.println("Hello, Java!");
    }

    public static void main(String[] args) {
        sayHello(); // Calling the method
    }
}
```

---

### (b) Parameterized Method (With Inputs)
```java
public class ParameterizedExample {
    static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int result = add(5, 10);
        System.out.println("Sum: " + result);
    }
}
```

✔ Takes **two parameters** `a` and `b`.
✔ **Returns a value** (`int`).

---

## 6. Static vs Non-Static Methods

**Static methods** belong to the **class** and can be called without an object.
**Non-static methods** require an object to be called.

### (a) Static Method
```java
class StaticExample {
    static void display() {
        System.out.println("This is a static method.");
    }

    public static void main(String[] args) {
        display(); // Called without an object
    }
}
```

---

### (b) Non-Static Method
```java
class NonStaticExample {
    void show() {
        System.out.println("This is a non-static method.");
    }

    public static void main(String[] args) {
        NonStaticExample obj = new NonStaticExample();
        obj.show(); // Called using an object
    }
}
```

✔ **Static → Called directly**
✔ **Non-static → Needs an object**

---

## 7. Method Overloading (Same Name, Different Parameters)

Method Overloading allows **multiple methods with the same name but different parameters**.

**Example: Method Overloading**
```java
class OverloadExample {
    // Method with one parameter
    static int multiply(int a) {
        return a * a;
    }

    // Method with two parameters
    static int multiply(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        System.out.println(multiply(5));     // 25
        System.out.println(multiply(5, 3));  // 15
    }
}
```

✔ Same **method name** but **different number/type of parameters**.
✔ **Compile-time polymorphism** (resolved at compile time).

---

## 8. Method Overriding (Same Signature, Different Behavior)

Method Overriding allows **a subclass to provide a different implementation** of a method from its parent class.

**Example: Method Overriding**
```java
class Parent {
    void show() {
        System.out.println("Parent class method");
    }
}

class Child extends Parent {
    @Override
    void show() {
        System.out.println("Child class method (Overridden)");
    }
}

public class OverrideExample {
    public static void main(String[] args) {
        Parent obj = new Child(); // Dynamic Method Dispatch
        obj.show();  // Child class method
    }
}
```

✔ **Same method name and parameters, but different implementation in subclass.**
✔ **Runtime polymorphism** (resolved at runtime).
✔ **`@Override` annotation ensures correct overriding.**

---

## 9. Recursive Method (A Method Calling Itself)

Recursion is when a method **calls itself** to solve a problem.

**Example: Factorial Using Recursion**
```java
class RecursionExample {
    static int factorial(int n) {
        if (n == 1) return 1;  // Base case
        return n * factorial(n - 1); // Recursive call
    }

    public static void main(String[] args) {
        System.out.println(factorial(5)); // Output: 120
    }
}
```

✔ **Base case (`n == 1`) stops recursion.**
✔ **Recursive case calls itself (`factorial(n - 1)`).**

---

## 10. Pass-by-Value in Java Methods

Java **always passes arguments by value**.

**Example: Pass-by-Value**
```java
class PassByValue {
    static void modify(int x) {
        x = 10;  // Changes local copy, not original variable
    }

    public static void main(String[] args) {
        int num = 5;
        modify(num);
        System.out.println(num); // Output: 5 (unchanged)
    }
}
```

✔ **Primitive types (`int`, `double`) → Passed by value (copy is modified).**
✔ **Reference types (`String`, `Objects`) → Reference is passed, but objects can be modified.**

---

## 11. Return Types and `void`

* `void` methods **do not return anything**.
* Methods **with a return type** must return a value.

**Example: Returning a Value**
```java
public class ReturnExample {
    static int square(int n) {
        return n * n;
    }

    public static void main(String[] args) {
        int result = square(4);
        System.out.println(result); // Output: 16
    }
}
```

---

# Java Constructor in Depth | Different Types of Constructors with Examples

## 1. What is a Constructor in Java?

A **constructor** is a **special method** in Java used to **initialize objects**. It is called **automatically** when an object is created.

**Key Characteristics of Constructors:**

✔ **Same name as the class**
✔ **No return type (not even `void`)**
✔ **Called automatically when an object is created**
✔ **Used for object initialization**

---

## 2. Syntax of a Constructor

```java
class ClassName {
    // Constructor
    ClassName() {
        // Initialization code
    }
}
```

**Example: Basic Constructor**
```java
class Car {
    Car() {  // Constructor
        System.out.println("Car object created!");
    }

    public static void main(String[] args) {
        Car myCar = new Car();  // Constructor is called automatically
    }
}
```

✔ **No return type**
✔ **Called when `new Car()` is executed**

---

## 3. Types of Constructors in Java

Java has **three types** of constructors:

1️⃣ **Default (No-Argument) Constructor**
2️⃣ **Parameterized Constructor**
3️⃣ **Copy Constructor**

---

## 4. Default (No-Argument) Constructor

A **default constructor** is automatically created if no constructor is defined.

**Example: Default Constructor**
```java
class Person {
    String name;

    // Default Constructor
    Person() {
        name = "Unknown";
    }

    void display() {
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        Person p1 = new Person();  // Calls default constructor
        p1.display();  // Output: Name: Unknown
    }
}
```

✔ **No parameters**
✔ **Initializes instance variables with default values**

---

## 5. Parameterized Constructor

A **constructor with parameters** allows passing values during object creation.

**Example: Parameterized Constructor**
```java
class Student {
    String name;
    int age;

    // Parameterized Constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println(name + " is " + age + " years old.");
    }

    public static void main(String[] args) {
        Student s1 = new Student("Alice", 20);
        Student s2 = new Student("Bob", 22);
        s1.display(); // Output: Alice is 20 years old.
        s2.display(); // Output: Bob is 22 years old.
    }
}
```

✔ **Accepts parameters**
✔ **Uses `this` keyword to differentiate instance variables**

---

## 6. Copy Constructor

A **copy constructor** creates a new object by copying values from another object.

**Example: Copy Constructor**
```java
class Book {
    String title;
    int pages;

    // Parameterized Constructor
    Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    // Copy Constructor
    Book(Book b) {
        this.title = b.title;
        this.pages = b.pages;
    }

    void display() {
        System.out.println("Book: " + title + ", Pages: " + pages);
    }

    public static void main(String[] args) {
        Book b1 = new Book("Java Programming", 500);
        Book b2 = new Book(b1); // Copy constructor is called
        b2.display();  // Output: Book: Java Programming, Pages: 500
    }
}
```

✔ **Copies values from an existing object**
✔ **Used for creating duplicates**

---

## 7. Constructor Overloading

Java allows **multiple constructors with different parameters**.

**Example: Constructor Overloading**
```java
class Employee {
    String name;
    int age;

    // Constructor 1 (No parameters)
    Employee() {
        name = "Unknown";
        age = 0;
    }

    // Constructor 2 (One parameter)
    Employee(String name) {
        this.name = name;
        this.age = 0;
    }

    // Constructor 3 (Two parameters)
    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Employee: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee("John");
        Employee e3 = new Employee("Alice", 25);

        e1.display();  // Output: Employee: Unknown, Age: 0
        e2.display();  // Output: Employee: John, Age: 0
        e3.display();  // Output: Employee: Alice, Age: 25
    }
}
```

✔ **Multiple constructors with different parameter lists**
✔ **Allows flexible object initialization**

---

## 8. Constructor Chaining

Calling **one constructor from another** in the same class.

**Example: Constructor Chaining**
```java
class Product {
    String name;
    double price;

    // Constructor 1
    Product() {
        this("Unknown", 0.0); // Calls Constructor 2
    }

    // Constructor 2
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void display() {
        System.out.println("Product: " + name + ", Price: $" + price);
    }

    public static void main(String[] args) {
        Product p1 = new Product(); // Calls Constructor 1, then Constructor 2
        p1.display();  // Output: Product: Unknown, Price: $0.0
    }
}
```

✔ **`this()` is used to call another constructor**
✔ **Avoids duplicate initialization logic**

---

## 9. Super Constructor (`super()`)

Used to **call the constructor of the parent class**.

**Example: Using `super()`**
```java
class Animal {
    Animal() {
        System.out.println("Animal constructor called");
    }
}

class Dog extends Animal {
    Dog() {
        super();  // Calls parent class constructor
        System.out.println("Dog constructor called");
    }
}

public class SuperConstructor {
    public static void main(String[] args) {
        Dog d = new Dog();
    }
}
```

✔ **`super()` calls the parent class constructor**
✔ **Ensures the superclass is initialized first**

---

## 10. Private Constructor (Singleton Design Pattern)

A **private constructor** restricts object creation outside the class.

**Example: Singleton Pattern**
```java
class Singleton {
    private static Singleton instance;  // Single instance

    // Private Constructor
    private Singleton() {}

    // Method to get the single instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

public class SingletonExample {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);  // Output: true (Same instance)
    }
}
```

✔ **Only one instance of the class exists**
✔ **Prevents multiple object creation**

---

## 11. Difference Between Constructor and Method

| Feature         | Constructor                                    | Method                      |
| --------------- | ---------------------------------------------- | --------------------------- |
| **Purpose**     | Initializes an object                          | Performs an operation       |
| **Name**        | Same as class name                             | Any valid name              |
| **Return Type** | No return type (not even `void`)               | Can have any return type    |
| **Call Time**   | Called automatically when an object is created | Called manually when needed |

---

# Java Classes in Depth - Part 1: Nested Class, Concrete, Abstract, Object, Super and Sub Class

Java is an **object-oriented programming (OOP) language**, and **classes** are the core building blocks of Java programs. This guide will cover various types of classes in Java, including **nested classes, concrete classes, abstract classes, objects, superclasses, and subclasses.**

---

## 1. What is a Class in Java?

A **class** is a blueprint for creating objects. It defines **fields (variables) and methods (functions)** that describe an object's behavior.

**Example: Simple Java Class**
```java
class Car {
    String brand;
    int speed;

    void accelerate() {
        speed += 10;
        System.out.println(brand + " is now at " + speed + " km/h");
    }
}
```

✔ **`Car` is a class (blueprint).**
✔ **It has two fields (`brand`, `speed`).**
✔ **It has a method `accelerate()` to modify `speed`.**

---

## 2. Objects in Java

An **object** is an instance of a class. It represents **real-world entities**.

**Example: Creating an Object**
```java
public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();  // Creating an object
        myCar.brand = "Tesla";
        myCar.speed = 50;
        myCar.accelerate();  // Output: Tesla is now at 60 km/h
    }
}
```

✔ **Objects store data and perform operations defined in the class.**
✔ **We use the `new` keyword to create objects.**

---

## 3. Concrete Class in Java

A **concrete class** is a class that provides complete implementation for all methods.

**Example: Concrete Class**
```java
class Dog {
    void bark() {
        System.out.println("Woof! Woof!");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.bark();  // Output: Woof! Woof!
    }
}
```

✔ **`Dog` is a concrete class since it provides full method implementations.**
✔ **Concrete classes can be instantiated (objects can be created).**

---

## 4. Abstract Class in Java

An **abstract class** cannot be instantiated and may contain **abstract methods** (methods without implementation).

**Example: Abstract Class**
```java
abstract class Animal {
    abstract void makeSound();  // Abstract method (no implementation)

    void sleep() {  // Concrete method (with implementation)
        System.out.println("Sleeping...");
    }
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("Meow! Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
        Cat c = new Cat();
        c.makeSound();  // Output: Meow! Meow!
        c.sleep();  // Output: Sleeping...
    }
}
```

✔ **`Animal` is an abstract class (cannot be instantiated).**
✔ **`makeSound()` is an abstract method (subclasses must implement it).**
✔ **`Cat` provides the actual implementation of `makeSound()`.**

---

## 5. Super and Sub Classes

### 5.1 Superclass (Parent Class)

A **superclass** is a class that is inherited by another class.

### 5.2 Subclass (Child Class)

A **subclass** is a class that extends a superclass and inherits its properties.

**Example: Superclass & Subclass**
```java
class Animal {  // Superclass
    void eat() {
        System.out.println("This animal eats food.");
    }
}

class Dog extends Animal {  // Subclass
    void bark() {
        System.out.println("Barking...");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();  // Output: This animal eats food. (Inherited from superclass)
        d.bark();  // Output: Barking...
    }
}
```

✔ **`Animal` is a superclass, `Dog` is a subclass.**
✔ **`Dog` inherits the `eat()` method from `Animal`.**
✔ **It also has its own method `bark()`.**

---

## 6. Nested Classes in Java

A **nested class** is a class defined within another class. Java provides four types:

### 6.1 Static Nested Class

A static nested class is associated with the outer class but does not require an instance of the outer class.

```java
class Outer {
    static class Nested {
        void display() {
            System.out.println("Static Nested Class");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Outer.Nested obj = new Outer.Nested();
        obj.display();  // Output: Static Nested Class
    }
}
```

✔ **Accessed using `Outer.Nested` because it's static.**

---

### 6.2 Non-Static (Inner) Class

An inner class requires an instance of the outer class.

```java
class Outer {
    class Inner {
        void show() {
            System.out.println("Inner Class");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner(); // Creating an instance of inner class
        inner.show();  // Output: Inner Class
    }
}
```

✔ **Inner class object is created using an outer class object.**

---

### 6.3 Local Inner Class

A local inner class is defined inside a method.

```java
class Outer {
    void display() {
        class Local {
            void show() {
                System.out.println("Local Inner Class");
            }
        }
        Local obj = new Local();
        obj.show();
    }
}

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.display();  // Output: Local Inner Class
    }
}
```

✔ **Local class exists only inside `display()` method.**

---

### 6.4 Anonymous Inner Class

An **anonymous inner class** has no name and is defined at object creation.

```java
abstract class Person {
    abstract void speak();
}

public class Main {
    public static void main(String[] args) {
        Person p = new Person() {  // Anonymous class
            void speak() {
                System.out.println("Speaking...");
            }
        };
        p.speak();  // Output: Speaking...
    }
}
```

✔ **Used for quick, one-time use.**

---

## 7. Summary

| Type               | Description                                                     |
| ------------------ | --------------------------------------------------------------- |
| **Concrete Class** | Fully implemented class. Objects can be created.                |
| **Abstract Class** | Contains abstract and concrete methods. Cannot be instantiated. |
| **Super Class**    | A class that is extended by another class.                      |
| **Sub Class**      | A class that inherits from a superclass.                        |
| **Nested Class**   | A class inside another class (Static, Inner, Local, Anonymous). |

---

# Java Generic Classes | Java Classes in Depth - Part 2

## 1. Introduction to Java Generics

Generics in Java allow us to **define classes, interfaces, and methods with type parameters**. This enables **type safety, reusability, and flexibility** while writing code.

**Why Use Generics?**

✔ **Type Safety** – Avoids `ClassCastException`.
✔ **Code Reusability** – A single generic class can handle multiple data types.
✔ **Compile-time Checking** – Errors are caught at compile time instead of runtime.

---

## 2. Generic Classes in Java

A **generic class** allows the use of a placeholder type (`T`, `E`, `K`, `V`, etc.), which gets replaced with an actual type when an object is created.

### 2.1 Creating a Generic Class
```java
// Defining a generic class with type parameter <T>
class Box<T> {
    private T item;  // Type T acts as a placeholder for any type

    void setItem(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }
}

public class Main {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();  // Box for Strings
        stringBox.setItem("Hello Generics");
        System.out.println(stringBox.getItem());  // Output: Hello Generics

        Box<Integer> intBox = new Box<>();  // Box for Integers
        intBox.setItem(100);
        System.out.println(intBox.getItem());  // Output: 100
    }
}
```

✔ **`Box<T>` is a generic class where `T` can be any data type.**
✔ **We created `Box<String>` and `Box<Integer>` without modifying the class.**

---

### 2.2 Multiple Type Parameters in a Generic Class

You can define a **generic class with multiple type parameters**.

```java
class Pair<K, V> {
    private K key;
    private V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    K getKey() { return key; }
    V getValue() { return value; }
}

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> student = new Pair<>("Alice", 90);
        System.out.println("Name: " + student.getKey() + ", Marks: " + student.getValue());

        Pair<Integer, String> data = new Pair<>(101, "Data Science");
        System.out.println("ID: " + data.getKey() + ", Course: " + data.getValue());
    }
}
```

✔ **The `Pair<K, V>` class stores two different generic types (`K` and `V`).**
✔ **`Pair<String, Integer>` holds a name and marks.**
✔ **`Pair<Integer, String>` holds an ID and course name.**

---

## 3. Generic Methods in Java

A **generic method** allows a method to work with different data types without changing its definition.

### 3.1 Creating a Generic Method
```java
class Utility {
    // Generic method with type parameter <T>
    public static <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4};
        String[] strArray = {"A", "B", "C"};

        Utility.printArray(intArray);  // Output: 1 2 3 4
        Utility.printArray(strArray);  // Output: A B C
    }
}
```

✔ **`printArray()` is a generic method that prints elements of any type array.**
✔ **It works with `Integer[]` and `String[]` without modification.**

---

## 4. Bounded Type Parameters in Generics

Sometimes, we want to **restrict the generic type to specific classes (e.g., only `Number` types)**.

### 4.1 Using Upper Bounded Wildcards (`extends`)

We can specify that **T must be a subclass of a certain type**.

```java
class MathUtil<T extends Number> {  // T must be a subclass of Number
    private T num;

    MathUtil(T num) {
        this.num = num;
    }

    double square() {
        return num.doubleValue() * num.doubleValue();
    }
}

public class Main {
    public static void main(String[] args) {
        MathUtil<Integer> intObj = new MathUtil<>(5);
        System.out.println(intObj.square());  // Output: 25.0

        MathUtil<Double> doubleObj = new MathUtil<>(5.5);
        System.out.println(doubleObj.square());  // Output: 30.25
    }
}
```

✔ **`T extends Number` ensures that `T` is a subclass of `Number`.**
✔ **Allows `Integer`, `Double`, `Float`, but not `String`.**

---

## 5. Wildcards in Generics

Wildcards (`?`) make generics **more flexible** by allowing unknown types.

### 5.1 Unbounded Wildcard (`<?>`)

Useful when we don't know the type in advance.

```java
import java.util.*;

class Printer {
    static void printList(List<?> list) {  // `?` allows any type
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<String> strList = Arrays.asList("A", "B", "C");

        Printer.printList(intList);  // Output: 1 2 3
        Printer.printList(strList);  // Output: A B C
    }
}
```

✔ **Wildcard `<?>` allows `List<Integer>`, `List<String>`, etc.**
✔ **This provides flexibility when working with collections of unknown types.**

---

### 5.2 Upper Bounded Wildcard (`<? extends Type>`)

Restricts the wildcard to accept **only subtypes** of a certain class.

```java
import java.util.*;

class SumUtil {
    static double sum(List<? extends Number> list) {
        double sum = 0.0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        System.out.println("Sum: " + SumUtil.sum(numbers));  // Output: 10.0
    }
}
```

✔ **`List<? extends Number>` allows `Integer`, `Double`, etc.**
✔ **Ensures the list only contains `Number` or its subclasses.**

---

## 6. Generic Interfaces

Interfaces can also be **generic**, just like classes.

### 6.1 Creating a Generic Interface
```java
interface Container<T> {
    void add(T item);
    T retrieve();
}

class Storage<T> implements Container<T> {
    private T item;

    public void add(T item) {
        this.item = item;
    }

    public T retrieve() {
        return item;
    }
}

public class Main {
    public static void main(String[] args) {
        Container<String> stringStorage = new Storage<>();
        stringStorage.add("Generic Interface Example");
        System.out.println(stringStorage.retrieve());  // Output: Generic Interface Example
    }
}
```

✔ **Interfaces can have generic types (`Container<T>`).**
✔ **Classes implementing the interface define the actual type (`Storage<String>`).**

---

## 7. Summary

| Feature                      | Description                                                          |
| ---------------------------- | -------------------------------------------------------------------- |
| **Generic Class**            | A class that takes type parameters (`class Box<T> {}`).              |
| **Generic Method**           | A method with type parameters (`public <T> void method(T t) {}`).    |
| **Bounded Type (`extends`)** | Restricts the type to a certain class/subclass (`T extends Number`). |
| **Wildcards (`?`)**          | Allows unknown types (`List<?>`, `List<? extends Number>`).          |
| **Generic Interface**        | Interfaces that support generics (`interface Container<T> {}`).      |

---
[image1]: <data:image/png;base64,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>
