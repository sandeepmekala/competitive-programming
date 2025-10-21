# Oops Concepts in Java

In Java, **Object-Oriented Programming (OOP)** is a programming paradigm that is based on the concept of **objects**. It allows developers to model real-world entities using objects. OOP in Java is centered around four main pillars:

**1\. Encapsulation**

Encapsulation is the mechanism of wrapping data (variables) and methods (functions) together as a single unit. It restricts direct access to certain components of an object and provides controlled access through methods. This is often implemented using **private** variables with **public** getter and setter methods.

**Example:**

java  
Copy code

| class Student {    private String name;    private int age;    // Getter for name    public String getName() {        return name;    }    // Setter for name    public void setName(String name) {        this.name \= name;    }    // Getter for age    public int getAge() {        return age;    }    // Setter for age    public void setAge(int age) {        if(age \> 0\) {            this.age \= age;        }    }}public class Main {    public static void main(String\[\] args) {        Student student \= new Student();        student.setName("John");        student.setAge(21);        System.out.println("Name: " \+ student.getName());        System.out.println("Age: " \+ student.getAge());    }} |
| :---- |

**Output:**

makefile  
Copy code  
`Name: John`  
`Age: 21`

**Explanation:** Here, the `name` and `age` variables are private, so they cannot be accessed directly. We use public getter and setter methods to access and modify them, providing controlled access.

**2\. Inheritance**

Inheritance allows a class to inherit properties and methods from another class. The class that inherits is called the **subclass** or **child class**, and the class from which it inherits is called the **superclass** or **parent class**. Inheritance promotes **code reusability**.

**Example:**

java  
Copy code

| class Animal {    void eat() {        System.out.println("This animal eats food.");    }}class Dog extends Animal {    void bark() {        System.out.println("The dog barks.");    }}public class Main {    public static void main(String\[\] args) {        Dog dog \= new Dog();        dog.eat();  // Inherited method        dog.bark(); // Child class method    }} |
| :---- |

**Output:**

Copy code  
`This animal eats food.`  
`The dog barks.`

**Explanation:** The `Dog` class inherits the `eat` method from the `Animal` class and has its own method `bark`.

**3\. Polymorphism**

Polymorphism allows objects to be treated as instances of their parent class rather than their actual class. There are two types of polymorphism in Java:

* **Compile-time polymorphism** (Method Overloading)  
* **Runtime polymorphism** (Method Overriding)

**Example of Method Overloading:**

java  
Copy code

| class MathUtils {    // Overloaded method with two parameters    int add(int a, int b) {        return a \+ b;    }    // Overloaded method with three parameters    int add(int a, int b, int c) {        return a \+ b \+ c;    }}public class Main {    public static void main(String\[\] args) {        MathUtils math \= new MathUtils();        System.out.println("Sum (2 params): " \+ math.add(5, 10));        System.out.println("Sum (3 params): " \+ math.add(5, 10, 15));    }} |
| :---- |

**Output:**

csharp  
Copy code  
`Sum (2 params): 15`  
`Sum (3 params): 30`

**Example of Method Overriding:**

java  
Copy code

| class Vehicle {    void move() {        System.out.println("The vehicle is moving");    }}class Car extends Vehicle {    @Override    void move() {        System.out.println("The car is driving");    }}public class Main {    public static void main(String\[\] args) {        Vehicle myCar \= new Car();        myCar.move(); // Calls the overridden method in Car class    }} |
| :---- |

**Output:**

csharp  
Copy code  
`The car is driving`

**Explanation:** In method overriding, the `move` method in the `Car` class overrides the `move` method in the `Vehicle` class.

**4\. Abstraction**

Abstraction is the process of hiding implementation details and showing only essential features of an object. In Java, abstraction is achieved using **abstract classes** and **interfaces**.

**Example using Abstract Class:**

java  
Copy code

| abstract class Shape {    abstract void draw();}class Circle extends Shape {    @Override    void draw() {        System.out.println("Drawing a circle");    }}public class Main {    public static void main(String\[\] args) {        Shape shape \= new Circle();        shape.draw();    }} |
| :---- |

**Output:**

arduino  
Copy code  
`Drawing a circle`

**Example using Interface:**

java  
Copy code

| interface Drawable {    void draw();}class Rectangle implements Drawable {    @Override    public void draw() {        System.out.println("Drawing a rectangle");    }}public class Main {    public static void main(String\[\] args) {        Drawable drawable \= new Rectangle();        drawable.draw();    }} |
| :---- |

**Output:**

css  
Copy code  
`Drawing a rectangle`

**Explanation:** The `Shape` class is abstract, so it cannot be instantiated. The `draw` method is implemented by its subclass `Circle`. Similarly, the `Drawable` interface defines the `draw` method, which is implemented by the `Rectangle` class.

Summary

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

**How a Java Program Works?**

A Java program goes through **three main steps** before execution:

1. **Writing Code:**  
   * The developer writes Java source code (`.java` file).  
2. **Compilation:**  
   * The Java Compiler (`javac`) converts the `.java` file into **bytecode** (`.class` file).  
3. **Execution:**  
   * The Java Virtual Machine (JVM) interprets the bytecode and runs the program.

Example: Simple Java Program  
java  
CopyEdit

| // HelloWorld.javapublic class HelloWorld {    public static void main(String\[\] args) {        System.out.println("Hello, World\!");    }} |
| :---- |

Execution Flow:  
**Compilation:**  
 nginx  
CopyEdit  
`javac HelloWorld.java`

1. Produces `HelloWorld.class` (bytecode).

**Execution:**  
 nginx  
CopyEdit  
`java HelloWorld`

2. JVM interprets `HelloWorld.class` and prints:  
    CopyEdit  
   `Hello, World!`

---

3 Important Components of Java  
1\. JVM (Java Virtual Machine)

**Definition:**  
 JVM is an engine that **executes Java bytecode** by converting it into machine code (specific to the OS).

Key Responsibilities of JVM:

✅ **Loads** bytecode (.class files).  
 ✅ **Verifies** bytecode for security.  
 ✅ **Interprets** or **compiles** the code using Just-In-Time (JIT) Compilation.  
 ✅ **Manages memory** via Garbage Collection (GC).

JVM is OS-dependent

Each OS (Windows, Linux, Mac) has its own JVM implementation.

---

2\. JRE (Java Runtime Environment)

**Definition:**  
 JRE is a package that **contains JVM \+ essential libraries** needed to run Java applications.

What JRE Includes?

✔ **JVM** (to run bytecode)  
 ✔ **Core Libraries** (e.g., `java.lang`, `java.util`)  
 ✔ **Runtime Components** (memory management, garbage collection)

Use Case:

JRE is needed **only to run Java programs**, not to develop them.

---

3\. JDK (Java Development Kit)

**Definition:**  
 JDK is a full software development kit that includes **JRE \+ development tools** (compiler, debugger, etc.).

What JDK Includes?

✔ **JRE** (JVM \+ Libraries)  
 ✔ **Compiler (`javac`)** \- Converts `.java` to `.class`  
 ✔ **Debugger (`jdb`)** \- Debugging tool  
 ✔ **Other Tools** \- `jar`, `javadoc`, etc.

Use Case:

JDK is needed **to develop and run Java programs**.

---

JVM vs. JRE vs. JDK – Quick Comparison

| Feature | JVM | JRE | JDK |
| ----- | ----- | ----- | ----- |
| Contains JVM? | ✅ | ✅ | ✅ |
| Contains Core Libraries? | ❌ | ✅ | ✅ |
| Contains Compiler (`javac`)? | ❌ | ❌ | ✅ |
| Needed for Development? | ❌ | ❌ | ✅ |
| Needed for Running Java? | ✅ | ✅ | ✅ |

---

# Java Variables \- Part 1 | Primitive Data Types in Depth

1\. What is a Variable in Java?

A **variable** in Java is a **named memory location** used to store data. Every variable has:

* **Type** (data type)  
* **Name** (identifier)  
* **Value** (assigned data)

Example: Declaring Variables  
java  
CopyEdit  
`int age = 25;        // age stores an integer value`  
`double price = 99.99; // price stores a decimal value`

---

2\. Java Primitive Data Types

Java has **8 primitive data types**, categorized as **Numeric, Character, and Boolean**.

| Data Type | Size | Default Value | Example Value | Category |
| ----- | ----- | ----- | ----- | ----- |
| `byte` | 1 byte (8 bits) | `0` | `127` | Integer |
| `short` | 2 bytes (16 bits) | `0` | `32767` | Integer |
| `int` | 4 bytes (32 bits) | `0` | `2147483647` | Integer |
| `long` | 8 bytes (64 bits) | `0L` | `9223372036854775807L` | Integer |
| `float` | 4 bytes (32 bits) | `0.0f` | `3.14f` | Floating-point |
| `double` | 8 bytes (64 bits) | `0.0d` | `3.141592653589793` | Floating-point |
| `char` | 2 bytes (16 bits) | `\u0000` (null) | `'A'`, `'9'`, `'#'` | Character |
| `boolean` | 1 bit (varies) | `false` | `true`, `false` | Boolean |

---

3\. Understanding Each Primitive Type in Depth

🔹 Integer Data Types

1️⃣ byte (8-bit)

* Stores small integers (-128 to 127).  
* Useful for memory-efficient applications.

java  
CopyEdit  
`byte smallNumber = 100;`  

2️⃣ short (16-bit)

* Stores integers (-32,768 to 32,767).  
* Rarely used, except for memory optimization.

java  
CopyEdit  
`short shortNum = 32000;`

3️⃣ int (32-bit)

* Most commonly used integer type (-2^31 to 2^31 \- 1).

java  
CopyEdit  
`int num = 100000;`  

4️⃣ long (64-bit)

* Used when `int` is not enough (-2^63 to 2^63 \- 1).  
* Requires `L` or `l` at the end.

java  
CopyEdit  
`long bigNumber = 9223372036854775807L;`

---

🔹 Floating-Point Data Types (Decimal Numbers)

5️⃣ float (32-bit)

* Stores decimal numbers with less precision.  
* Requires `f` or `F` at the end.

java  
CopyEdit  
`float pi = 3.14f;`

6️⃣ double (64-bit)

* More precise than `float`.  
* Default for decimal values.

java  
CopyEdit  
`double price = 99.99;`

✅ **Why Use `double` Over `float`?**

* `double` provides **higher precision** than `float`.  
* **Use `float` only when memory is a concern**.

---

🔹 Character Data Type

7️⃣ char (16-bit)

* Stores **a single character** (Unicode-based).  
* Uses **single quotes `' '`**.

java  
CopyEdit  
`char letter = 'A';`  
`char digit = '9';`  
`char symbol = '#';`  
`char unicodeChar = '\u20AC'; // Unicode for €`

---

🔹 Boolean Data Type

8️⃣ boolean (1-bit)

* Stores **only `true` or `false`**.

java  
CopyEdit

| boolean isJavaFun \= true;boolean isCold \= false; |
| :---- |

---

4\. Default Values of Primitive Data Types

If a primitive variable is not assigned a value, Java assigns a **default value**:

java  
CopyEdit

| class DefaultValues {    byte b;      // Default: 0    short s;     // Default: 0    int i;       // Default: 0    long l;      // Default: 0L    float f;     // Default: 0.0f    double d;    // Default: 0.0d    char c;      // Default: '\\u0000' (null)    boolean bool;// Default: false    void showDefaults() {        System.out.println("byte: " \+ b);        System.out.println("short: " \+ s);        System.out.println("int: " \+ i);        System.out.println("long: " \+ l);        System.out.println("float: " \+ f);        System.out.println("double: " \+ d);        System.out.println("char: \[" \+ c \+ "\]");        System.out.println("boolean: " \+ bool);    }    public static void main(String\[\] args) {        DefaultValues obj \= new DefaultValues();        obj.showDefaults();    }} |
| :---- |

🔹 **Output:**

arduino  
CopyEdit  
`byte: 0`  
`short: 0`  
`int: 0`  
`long: 0`  
`float: 0.0`  
`double: 0.0`  
`char: []`  
`boolean: false`

✅ **Key Takeaways:**

* **Numeric types default to `0` or `0.0`**.  
* **`char` defaults to `'\u0000'` (null character).**  
* **`boolean` defaults to `false`**.

---

5\. Type Conversion & Type Casting

Implicit (Widening) Type Conversion

* **Small → Large data type (Automatic)**

java  
CopyEdit

| int num \= 100;double bigNum \= num;  // int → double (automatic)System.out.println(bigNum);  // 100.0 |
| :---- |

Explicit (Narrowing) Type Casting

* **Large → Small data type (Manual, data loss possible)**

java  
CopyEdit

| double pi \= 3.14159;int approxPi \= (int) pi;  // double → int (manual)System.out.println(approxPi);  // 3 |
| :---- |

---

6\. Wrapper Classes for Primitive Data Types

Primitive types **don’t have methods**, but Java provides **Wrapper Classes** in `java.lang` package.

| Primitive | Wrapper Class |
| ----- | ----- |
| `byte` | `Byte` |
| `short` | `Short` |
| `int` | `Integer` |
| `long` | `Long` |
| `float` | `Float` |
| `double` | `Double` |
| `char` | `Character` |
| `boolean` | `Boolean` |

Example: Using Wrapper Classes  
java  
CopyEdit

| int num \= 10;Integer obj \= num;  // Auto-boxingint newNum \= obj;   // UnboxingSystem.out.println(obj \+ " " \+ newNum); |
| :---- |

✅ **Auto-boxing:** Converting primitive to object.  
 ✅ **Unboxing:** Converting object to primitive.

---

# How FLOAT and DOUBLE Numbers are Stored in Memory? | IEEE 754 Representation

1\. Introduction to Floating-Point Representation

In Java, `float` and `double` data types store **decimal numbers** using **IEEE 754 Floating-Point Standard**.

* `float` (4 bytes \= 32 bits) → **Single Precision (IEEE 754 32-bit)**  
* `double` (8 bytes \= 64 bits) → **Double Precision (IEEE 754 64-bit)**

Key Points:

✔ **Floating-point numbers use binary representation (0s and 1s).**  
 ✔ **They are stored in three parts: Sign, Exponent, and Mantissa (Fraction).**  
 ✔ **Uses scientific notation for efficient storage.**

---

2\. IEEE 754 Floating-Point Format

A floating-point number is stored as:

Value=(−1)Sign Bit×2Exponent \- Bias×(1+Fraction)\\text{Value} \= (-1)^{\\text{Sign Bit}} \\times 2^{\\text{Exponent \- Bias}} \\times (1 \+ \\text{Fraction})Value=(−1)Sign Bit×2Exponent \- Bias×(1+Fraction)

IEEE 754 Structure:

| Data Type | Bits | Sign Bit | Exponent | Fraction (Mantissa) |
| ----- | ----- | ----- | ----- | ----- |
| **float** | 32 | 1 | 8 | 23 |
| **double** | 64 | 1 | 11 | 52 |

✅ **Sign Bit (1 bit)**

* `0` → Positive number  
* `1` → Negative number

✅ **Exponent (8 bits for float, 11 bits for double)**

* Represents **the power of 2**.  
* Stored using **"Bias" method** (Bias \= 127 for `float`, 1023 for `double`).

✅ **Fraction/Mantissa (23 bits for float, 52 bits for double)**

* Stores the **significant digits** of the number.

---

3\. Example: Storing a Floating-Point Number (Step-by-Step)

Let's store **9.625** in **IEEE 754 32-bit format** (`float`).

Step 1: Convert to Binary

Convert **9.625 (Decimal) → Binary**:

yaml  
CopyEdit  
`9.625₁₀ = 1001.101₂`

Step 2: Normalize to Scientific Notation

Shift the decimal point to get **1.001101 × 2³**

* **1.001101** → Mantissa  
* **3 (Exponent in Decimal)**

Step 3: Convert Exponent to IEEE 754 Format

* **Bias for `float` \= 127**  
* **Stored Exponent** \= `Exponent + Bias = 3 + 127 = 130`  
* Convert `130` to **Binary**: `10000010` (8 bits)

Step 4: Store the IEEE 754 Components

| Component | Value |
| ----- | ----- |
| **Sign Bit** | `0` (Positive) |
| **Exponent** | `10000010` (130) |
| **Mantissa** | `00110100000000000000000` |

✅ **Final IEEE 754 32-bit Representation (Binary):**

CopyEdit  
`0 10000010 00110100000000000000000`

✅ **Final IEEE 754 32-bit Representation (Hex):**

CopyEdit  
`0x411A0000`

---

4\. IEEE 754 Double Precision (64-bit) Example

For **9.625 in IEEE 754 64-bit (`double`)**, the steps are the same:

* Bias \= **1023**  
* Exponent \= `3 + 1023 = 1026` → **Binary: `10000000010`**  
* Mantissa expands to **52 bits**

Final IEEE 754 64-bit Representation:

CopyEdit  
`0 10000000010 0011010000000000000000000000000000000000000000000000`

---

5\. Special Cases in IEEE 754

| Case | Sign | Exponent | Mantissa | Meaning |
| ----- | ----- | ----- | ----- | ----- |
| `0.0` | 0 | `00000000` | `00000000000000000000000` | Zero |
| `Infinity` | 0 or 1 | `11111111` | `00000000000000000000000` | ±∞ |
| `NaN` | 0 or 1 | `11111111` | `Non-zero Mantissa` | Not-a-Number (NaN) |
| `Denormalized` | 0 or 1 | `00000000` | `Non-zero Mantissa` | Subnormal (very small numbers) |

---

6\. Precision and Rounding Errors

* `float` (32-bit) can represent **only 7–8 decimal digits**.  
* `double` (64-bit) can represent **15–16 decimal digits**.  
* Some decimal numbers **can’t be represented exactly in binary**, leading to precision errors.

Example of Precision Loss  
java  
CopyEdit

| public class PrecisionTest {    public static void main(String\[\] args) {        float f \= 0.1f \+ 0.2f;  // Expected: 0.3        double d \= 0.1 \+ 0.2;    // Expected: 0.3                System.out.println("float result: " \+ f);  // Output: 0.30000001        System.out.println("double result: " \+ d); // Output: 0.30000000000000004    }} |
| :---- |

🔹 **Why?** Some decimal numbers **can't be exactly represented in binary**, causing rounding errors.

✅ **Solution:** Use **BigDecimal** for precise calculations.

java  
CopyEdit

| import java.math.BigDecimal;public class BigDecimalExample {    public static void main(String\[\] args) {        BigDecimal a \= new BigDecimal("0.1");        BigDecimal b \= new BigDecimal("0.2");        BigDecimal sum \= a.add(b);        System.out.println("Accurate Sum: " \+ sum);  // Output: 0.3    }} |
| :---- |

---

7\. Comparison: `float` vs `double`

| Feature | `float` (32-bit) | `double` (64-bit) |
| ----- | ----- | ----- |
| **Size** | 4 bytes | 8 bytes |
| **Precision** | \~7 decimal digits | \~15 decimal digits |
| **Exponent Bits** | 8 bits | 11 bits |
| **Mantissa Bits** | 23 bits | 52 bits |
| **Use Case** | Graphics, Low Memory Apps | Scientific Computing, Finance |

✅ **When to Use `float`?**

* When memory is limited (e.g., **embedded systems, graphics**).  
* When precision isn’t critical.

✅ **When to Use `double`?**

* When **higher precision** is needed (**scientific computing, finance**).

---

# Java Variables \- Part 2 | Reference (Non-Primitive) Data Types in Depth

1\. Introduction to Reference Data Types

Unlike **primitive data types**, reference (or **non-primitive**) data types store **memory addresses** that reference objects instead of directly storing data.

Key Characteristics of Reference Data Types:

✔ **Stores a memory reference (address) to the actual object.**  
 ✔ **Created using the `new` keyword (except for `String`, which can also be assigned directly).**  
 ✔ **Can have built-in methods and properties.**  
 ✔ **Default value is `null` if not initialized.**

---

2\. Types of Reference (Non-Primitive) Data Types

Java has **several types** of reference data types:

1️⃣ **Class Types** (`String`, `Integer`, `Scanner`, `Date`, etc.)  
 2️⃣ **Array Types** (`int[]`, `String[]`, `double[][]`, etc.)  
 3️⃣ **Interface Types** (`List`, `Map`, `Runnable`, etc.)  
 4️⃣ **User-Defined Objects** (Objects of classes)

---

3\. Reference Data Types in Detail

🔹 1\. Class Type (`String`, Wrapper Classes, and Objects)

`String` Class (Immutable Object)

* `String` is a **reference type**, not a primitive, but behaves like one.  
* Can be created using **String literals** (stored in **String Pool**) or using `new`.

java

CopyEdit

| public class StringExample {    public static void main(String\[\] args) {        String s1 \= "Java";   // Stored in String Pool        String s2 \= new String("Java"); // Stored in Heap        System.out.println(s1.equals(s2)); // true (checks content)        System.out.println(s1 \== s2); // false (checks reference)    }} |
| :---- |

✅ **Key Notes:**

* `String` objects are **immutable** (cannot be changed once created).  
* **`==` compares references, `.equals()` compares content**.

Wrapper Classes (Auto-Boxing & Unboxing)

Java provides **wrapper classes** for primitive types, allowing them to be used as objects.

java

CopyEdit

`Integer num = 100;  // Auto-boxing (int → Integer)`

`int newNum = num;   // Unboxing (Integer → int)`

`System.out.println(num + " " + newNum);`

---

🔹 2\. Array Type (Fixed-Size Collections)

* Arrays store **multiple values of the same type** in contiguous memory locations.  
* Arrays are **reference types** because they store the memory address of the first element.

java

CopyEdit

`int[] numbers = {10, 20, 30};  // Array of integers`

`String[] names = new String[3]; // Array of Strings (default: null)`

✅ **Key Notes:**

* Arrays **must have a fixed size**.  
* Default values depend on the element type (e.g., `int[]` defaults to `0`, `String[]` defaults to `null`).

---

🔹 3\. Interface Type (`List`, `Map`, `Set`)

* Java **interfaces** define methods but do not implement them.  
* Objects of interface types **must be assigned an instance of a class** implementing them.

java

CopyEdit

`import java.util.*;`

`public class InterfaceExample {`

    `public static void main(String[] args) {`

        `List<String> list = new ArrayList<>(); // Interface reference`

        `list.add("Java");`

        `list.add("Python");`

        `System.out.println(list);`

    `}`

`}`

✅ **Key Notes:**

* `List` is an **interface**, but `ArrayList` is a **class that implements it**.  
* Interfaces allow **polymorphism** and **loose coupling**.

---

🔹 4\. User-Defined Objects (Instances of a Class)

Java allows **creating objects from custom classes**.

java

CopyEdit

`class Person {`

    `String name;`

    `int age;`

    `// Constructor`

    `Person(String name, int age) {`

        `this.name = name;`

        `this.age = age;`

    `}`

    `void display() {`

        `System.out.println(name + " is " + age + " years old.");`

    `}`

`}`

`public class ObjectExample {`

    `public static void main(String[] args) {`

        `Person p1 = new Person("Alice", 25);`

        `p1.display();  // Output: Alice is 25 years old.`

    `}`

`}`

✅ **Key Notes:**

* `p1` is a **reference variable** storing the address of the `Person` object.  
* Multiple reference variables **can point to the same object**.

java

CopyEdit

`Person p2 = p1;  // p2 now references the same object as p1`

---

4\. Default Values of Reference Data Types

If reference variables are **not initialized**, they default to `null`.

java

CopyEdit

`String str;`

`Person p;`

`System.out.println(str); // null`

`System.out.println(p);   // null`

**⚠ NullPointerException (NPE) occurs if we call methods on `null` references.**

---

5\. Difference Between Primitive and Reference Data Types

| Feature | Primitive Data Types | Reference Data Types |
| ----- | ----- | ----- |
| **Storage** | Stored in **stack** | Stored in **heap**, reference in stack |
| **Memory Size** | Fixed (depends on type) | Varies (depends on object) |
| **Default Value** | Numeric: `0`, Boolean: `false`, Char: `\u0000` | `null` |
| **Methods** | No methods available | Methods available |
| **Examples** | `int`, `char`, `boolean` | `String`, `Arrays`, `Objects`, `List` |

✅ **When to Use Primitive vs Reference?**

* **Use primitives** for efficiency (e.g., `int`, `double`).  
* **Use references** for complex objects (`String`, `List`, `Map`).

---

6\. Memory Allocation: Stack vs Heap

Java uses **stack** and **heap memory** for storing variables.

1️⃣ **Stack Memory (Method Execution & Primitive Variables)**

* Stores **method calls, local variables, and primitive data types**.  
* **Fast access** but limited in size.

2️⃣ **Heap Memory (Objects & Reference Variables)**

* Stores **objects created using `new`**.  
* Larger but **slower than stack**.  
* Requires **Garbage Collection** for memory management.

Example: Stack vs Heap Memory  
java

CopyEdit

`class Demo {`

    `int x = 10;  // Instance variable (Heap)`

    `public static void main(String[] args) {`

        `int a = 5;  // Stored in Stack`

        `Demo d = new Demo();  // d is in Stack, but object in Heap`

    `}`

`}`

---

7\. Garbage Collection & `null` References

* Objects **not referenced by any variable** are **eligible for garbage collection**.  
* `System.gc();` **requests** garbage collection (not guaranteed).

java

CopyEdit

`class Example {`

    `void show() {`

        `System.out.println("Hello");`

    `}`

`}`

`public class GarbageDemo {`

    `public static void main(String[] args) {`

        `Example obj = new Example();`

        `obj = null;  // Eligible for GC`

    `}`

`}`

✅ **Key Notes:**

* `null` means **no reference** to an object.  
* Objects without references are **garbage collected automatically**.

---

# Java Methods in Depth | Different Types of Methods with Examples

1\. What is a Method in Java?

A **method** in Java is a **block of code** that performs a specific task. Methods improve **code reusability**, **readability**, and **modularity**.

Key Characteristics of Methods:

✔ **Defined inside a class**.  
 ✔ Can **return a value** or be `void`.  
 ✔ Can take **parameters (inputs)**.  
 ✔ Can be called multiple times (**reusability**).

---

2\. Method Syntax in Java

java

CopyEdit

`returnType methodName(parameters) {`

    `// method body`

    `return value; // if returnType is not void`

`}`

Example: Simple Method  
java

CopyEdit

`public class MethodExample {`

    `static void greet() {`

        `System.out.println("Hello, welcome to Java!");`

    `}`

    `public static void main(String[] args) {`

        `greet(); // Calling the method`

    `}`

`}`

✔ **`static`** → Allows calling method without creating an object.  
 ✔ **`void`** → No return value.

---

3\. Types of Methods in Java

Java methods are broadly classified into:

1️⃣ **Predefined (Built-in) Methods**  
 2️⃣ **User-Defined Methods**  
 3️⃣ **Parameterized vs Non-Parameterized Methods**  
 4️⃣ **Static vs Non-Static Methods**  
 5️⃣ **Method Overloading**  
 6️⃣ **Method Overriding**  
 7️⃣ **Recursive Methods**

---

4\. Predefined (Built-in) Methods

Java provides many **built-in methods** from standard libraries like `Math`, `String`, etc.

Example: Using Built-in Methods  
java

CopyEdit

`public class BuiltInMethods {`

    `public static void main(String[] args) {`

        `int max = Math.max(10, 20);  // Returns maximum value`

        `double sqrt = Math.sqrt(16); // Returns square root`

        `String s = "Java".toLowerCase(); // Converts to lowercase`

        `System.out.println(max);  // 20`

        `System.out.println(sqrt); // 4.0`

        `System.out.println(s);    // java`

    `}`

`}`

---

5\. User-Defined Methods

**Methods created by programmers** to perform specific tasks.

(a) Non-Parameterized Method (No Input)  
java

CopyEdit

`public class UserDefinedMethods {`

    `static void sayHello() {`

        `System.out.println("Hello, Java!");`

    `}`

    `public static void main(String[] args) {`

        `sayHello(); // Calling the method`

    `}`

`}`

---

(b) Parameterized Method (With Inputs)  
java

CopyEdit

`public class ParameterizedExample {`

    `static int add(int a, int b) {`

        `return a + b;`

    `}`

    `public static void main(String[] args) {`

        `int result = add(5, 10);`

        `System.out.println("Sum: " + result);`

    `}`

`}`

✔ Takes **two parameters** `a` and `b`.  
 ✔ **Returns a value** (`int`).

---

6\. Static vs Non-Static Methods

**Static methods** belong to the **class** and can be called without an object.  
 **Non-static methods** require an object to be called.

(a) Static Method  
java

CopyEdit

`class StaticExample {`

    `static void display() {`

        `System.out.println("This is a static method.");`

    `}`

    `public static void main(String[] args) {`

        `display(); // Called without an object`

    `}`

`}`

---

(b) Non-Static Method  
java

CopyEdit

`class NonStaticExample {`

    `void show() {`

        `System.out.println("This is a non-static method.");`

    `}`

    `public static void main(String[] args) {`

        `NonStaticExample obj = new NonStaticExample();`

        `obj.show(); // Called using an object`

    `}`

`}`

✔ **Static → Called directly**  
 ✔ **Non-static → Needs an object**

---

7\. Method Overloading (Same Name, Different Parameters)

Method Overloading allows **multiple methods with the same name but different parameters**.

Example: Method Overloading  
java

CopyEdit

`class OverloadExample {`

    `// Method with one parameter`

    `static int multiply(int a) {`

        `return a * a;`

    `}`

    `// Method with two parameters`

    `static int multiply(int a, int b) {`

        `return a * b;`

    `}`

    `public static void main(String[] args) {`

        `System.out.println(multiply(5));     // 25`

        `System.out.println(multiply(5, 3));  // 15`

    `}`

`}`

✔ Same **method name** but **different number/type of parameters**.  
 ✔ **Compile-time polymorphism** (resolved at compile time).

---

8\. Method Overriding (Same Signature, Different Behavior)

Method Overriding allows **a subclass to provide a different implementation** of a method from its parent class.

Example: Method Overriding  
java

CopyEdit

`class Parent {`

    `void show() {`

        `System.out.println("Parent class method");`

    `}`

`}`

`class Child extends Parent {`

    `@Override`

    `void show() {`

        `System.out.println("Child class method (Overridden)");`

    `}`

`}`

`public class OverrideExample {`

    `public static void main(String[] args) {`

        `Parent obj = new Child(); // Dynamic Method Dispatch`

        `obj.show();  // Child class method`

    `}`

`}`

✔ **Same method name and parameters, but different implementation in subclass.**  
 ✔ **Runtime polymorphism** (resolved at runtime).  
 ✔ **`@Override` annotation ensures correct overriding.**

---

9\. Recursive Method (A Method Calling Itself)

Recursion is when a method **calls itself** to solve a problem.

Example: Factorial Using Recursion  
java

CopyEdit

`class RecursionExample {`

    `static int factorial(int n) {`

        `if (n == 1) return 1;  // Base case`

        `return n * factorial(n - 1); // Recursive call`

    `}`

    `public static void main(String[] args) {`

        `System.out.println(factorial(5)); // Output: 120`

    `}`

`}`

✔ **Base case (`n == 1`) stops recursion.**  
 ✔ **Recursive case calls itself (`factorial(n - 1)`).**

---

10\. Pass-by-Value in Java Methods

Java **always passes arguments by value**.

Example: Pass-by-Value  
java

CopyEdit

`class PassByValue {`

    `static void modify(int x) {`

        `x = 10;  // Changes local copy, not original variable`

    `}`

    `public static void main(String[] args) {`

        `int num = 5;`

        `modify(num);`

        `System.out.println(num); // Output: 5 (unchanged)`

    `}`

`}`

✔ **Primitive types (`int`, `double`) → Passed by value (copy is modified).**  
 ✔ **Reference types (`String`, `Objects`) → Reference is passed, but objects can be modified.**

---

11\. Return Types and `void`

* `void` methods **do not return anything**.  
* Methods **with a return type** must return a value.

Example: Returning a Value  
java

CopyEdit

`public class ReturnExample {`

    `static int square(int n) {`

        `return n * n;`

    `}`

    `public static void main(String[] args) {`

        `int result = square(4);`

        `System.out.println(result); // Output: 16`

    `}`

`}`

---

# Java Constructor in Depth | Different Types of Constructors with Examples

1\. What is a Constructor in Java?

A **constructor** is a **special method** in Java used to **initialize objects**. It is called **automatically** when an object is created.

Key Characteristics of Constructors:

✔ **Same name as the class**  
 ✔ **No return type (not even `void`)**  
 ✔ **Called automatically when an object is created**  
 ✔ **Used for object initialization**

---

2\. Syntax of a Constructor

java

CopyEdit

`class ClassName {`

    `// Constructor`

    `ClassName() {`

        `// Initialization code`

    `}`

`}`

Example: Basic Constructor  
java

CopyEdit

`class Car {`

    `Car() {  // Constructor`

        `System.out.println("Car object created!");`

    `}`

    `public static void main(String[] args) {`

        `Car myCar = new Car();  // Constructor is called automatically`

    `}`

`}`

✔ **No return type**  
 ✔ **Called when `new Car()` is executed**

---

3\. Types of Constructors in Java

Java has **three types** of constructors:

1️⃣ **Default (No-Argument) Constructor**  
 2️⃣ **Parameterized Constructor**  
 3️⃣ **Copy Constructor**

---

4\. Default (No-Argument) Constructor

A **default constructor** is automatically created if no constructor is defined.

Example: Default Constructor  
java

CopyEdit

`class Person {`

    `String name;`

    `// Default Constructor`

    `Person() {`

        `name = "Unknown";`

    `}`

    `void display() {`

        `System.out.println("Name: " + name);`

    `}`

    `public static void main(String[] args) {`

        `Person p1 = new Person();  // Calls default constructor`

        `p1.display();  // Output: Name: Unknown`

    `}`

`}`

✔ **No parameters**  
 ✔ **Initializes instance variables with default values**

---

5\. Parameterized Constructor

A **constructor with parameters** allows passing values during object creation.

Example: Parameterized Constructor  
java

CopyEdit

`class Student {`

    `String name;`

    `int age;`

    `// Parameterized Constructor`

    `Student(String name, int age) {`

        `this.name = name;`

        `this.age = age;`

    `}`

    `void display() {`

        `System.out.println(name + " is " + age + " years old.");`

    `}`

    `public static void main(String[] args) {`

        `Student s1 = new Student("Alice", 20);`

        `Student s2 = new Student("Bob", 22);`

        `s1.display(); // Output: Alice is 20 years old.`

        `s2.display(); // Output: Bob is 22 years old.`

    `}`

`}`

✔ **Accepts parameters**  
 ✔ **Uses `this` keyword to differentiate instance variables**

---

6\. Copy Constructor

A **copy constructor** creates a new object by copying values from another object.

Example: Copy Constructor  
java

CopyEdit

`class Book {`

    `String title;`

    `int pages;`

    `// Parameterized Constructor`

    `Book(String title, int pages) {`

        `this.title = title;`

        `this.pages = pages;`

    `}`

    `// Copy Constructor`

    `Book(Book b) {`

        `this.title = b.title;`

        `this.pages = b.pages;`

    `}`

    `void display() {`

        `System.out.println("Book: " + title + ", Pages: " + pages);`

    `}`

    `public static void main(String[] args) {`

        `Book b1 = new Book("Java Programming", 500);`

        `Book b2 = new Book(b1); // Copy constructor is called`

        `b2.display();  // Output: Book: Java Programming, Pages: 500`

    `}`

`}`

✔ **Copies values from an existing object**  
 ✔ **Used for creating duplicates**

---

7\. Constructor Overloading

Java allows **multiple constructors with different parameters**.

Example: Constructor Overloading  
java

CopyEdit

`class Employee {`

    `String name;`

    `int age;`

    `// Constructor 1 (No parameters)`

    `Employee() {`

        `name = "Unknown";`

        `age = 0;`

    `}`

    `// Constructor 2 (One parameter)`

    `Employee(String name) {`

        `this.name = name;`

        `this.age = 0;`

    `}`

    `// Constructor 3 (Two parameters)`

    `Employee(String name, int age) {`

        `this.name = name;`

        `this.age = age;`

    `}`

    `void display() {`

        `System.out.println("Employee: " + name + ", Age: " + age);`

    `}`

    `public static void main(String[] args) {`

        `Employee e1 = new Employee();`

        `Employee e2 = new Employee("John");`

        `Employee e3 = new Employee("Alice", 25);`

        `e1.display();  // Output: Employee: Unknown, Age: 0`

        `e2.display();  // Output: Employee: John, Age: 0`

        `e3.display();  // Output: Employee: Alice, Age: 25`

    `}`

`}`

✔ **Multiple constructors with different parameter lists**  
 ✔ **Allows flexible object initialization**

---

8\. Constructor Chaining

Calling **one constructor from another** in the same class.

Example: Constructor Chaining  
java

CopyEdit

`class Product {`

    `String name;`

    `double price;`

    `// Constructor 1`

    `Product() {`

        `this("Unknown", 0.0); // Calls Constructor 2`

    `}`

    `// Constructor 2`

    `Product(String name, double price) {`

        `this.name = name;`

        `this.price = price;`

    `}`

    `void display() {`

        `System.out.println("Product: " + name + ", Price: $" + price);`

    `}`

    `public static void main(String[] args) {`

        `Product p1 = new Product(); // Calls Constructor 1, then Constructor 2`

        `p1.display();  // Output: Product: Unknown, Price: $0.0`

    `}`

`}`

✔ **`this()` is used to call another constructor**  
 ✔ **Avoids duplicate initialization logic**

---

9\. Super Constructor (`super()`)

Used to **call the constructor of the parent class**.

Example: Using `super()`  
java

CopyEdit

`class Animal {`

    `Animal() {`

        `System.out.println("Animal constructor called");`

    `}`

`}`

`class Dog extends Animal {`

    `Dog() {`

        `super();  // Calls parent class constructor`

        `System.out.println("Dog constructor called");`

    `}`

`}`

`public class SuperConstructor {`

    `public static void main(String[] args) {`

        `Dog d = new Dog();`

    `}`

`}`

✔ **`super()` calls the parent class constructor**  
 ✔ **Ensures the superclass is initialized first**

---

10\. Private Constructor (Singleton Design Pattern)

A **private constructor** restricts object creation outside the class.

Example: Singleton Pattern  
java

CopyEdit

`class Singleton {`

    `private static Singleton instance;  // Single instance`

    `// Private Constructor`

    `private Singleton() {}`

    `// Method to get the single instance`

    `public static Singleton getInstance() {`

        `if (instance == null) {`

            `instance = new Singleton();`

        `}`

        `return instance;`

    `}`

`}`

`public class SingletonExample {`

    `public static void main(String[] args) {`

        `Singleton s1 = Singleton.getInstance();`

        `Singleton s2 = Singleton.getInstance();`

        `System.out.println(s1 == s2);  // Output: true (Same instance)`

    `}`

`}`

✔ **Only one instance of the class exists**  
 ✔ **Prevents multiple object creation**

---

11\. Difference Between Constructor and Method

| Feature | Constructor | Method |
| ----- | ----- | ----- |
| **Purpose** | Initializes an object | Performs an operation |
| **Name** | Same as class name | Any valid name |
| **Return Type** | No return type (not even `void`) | Can have any return type |
| **Call Time** | Called automatically when an object is created | Called manually when needed |

---

# Java Memory Management and Garbage Collection in Depth

1\. Introduction to Java Memory Management

Java handles memory management **automatically** using the **JVM (Java Virtual Machine)**. It manages memory allocation and deallocation efficiently, preventing memory leaks.

Key Memory Areas in Java:

1️⃣ **Heap Memory** \- Stores objects and class instances.  
 2️⃣ **Stack Memory** \- Stores method calls and local variables.  
 3️⃣ **Method Area (MetaSpace in Java 8+)** \- Stores class metadata, method code, and static variables.  
 4️⃣ **PC Register** \- Keeps track of instruction execution.  
 5️⃣ **Native Method Stack** \- Used for native (non-Java) methods.

---

2\. Java Memory Structure (JVM Memory Areas)

🔹 1\. Heap Memory

* **Stores objects** created using `new` keyword.  
* **Shared among all threads.**  
* **Divided into:**  
  * **Young Generation** (Eden \+ Survivor Spaces)  
  * **Old Generation (Tenured Heap)**  
  * **Permanent Generation (Before Java 8, replaced with MetaSpace)**

🔹 2\. Stack Memory

* **Stores method calls and local variables.**  
* **Follows LIFO (Last-In-First-Out) order.**  
* **Each thread has its own stack.**

🔹 3\. Method Area (MetaSpace in Java 8+)

* Stores **class metadata, static variables, method code**.  
* **Shared among all threads.**  
* **MetaSpace (Java 8+) grows dynamically, unlike the fixed-size PermGen in Java 7\.**

🔹 4\. Program Counter (PC) Register

* Stores the **current execution instruction address** of each thread.  
* **Each thread has a separate PC Register.**

🔹 5\. Native Method Stack

* **Used for native (C, C++) method execution.**  
* **Each thread has its own native stack.**

---

3\. Java Heap Memory Structure (Generations in Heap)

The **Heap Memory** is divided into **three main sections**:

(a) Young Generation

* **Newly created objects are stored here.**  
* **Divided into:**  
  * **Eden Space** (where objects are first allocated)  
  * **Survivor Space S0, S1** (objects that survive garbage collection)

(b) Old Generation (Tenured Space)

* **Objects that survive multiple garbage collections move here.**  
* **Larger objects and long-lived objects are stored here.**

(c) Permanent Generation (Java 7 and below) / MetaSpace (Java 8+)

* **Stores class metadata, static methods, and constant pool.**  
* **Java 8 replaced PermGen with MetaSpace, which dynamically resizes.**

---

4\. Memory Allocation in Java

Java follows **automatic memory allocation** and **garbage collection** to manage memory efficiently.

How Objects are Stored in Memory?

1️⃣ **Primitive data types (int, double, char, etc.)** → Stored in **stack memory**.  
 2️⃣ **Objects (created using `new`)** → Stored in **heap memory**.  
 3️⃣ **Static variables** → Stored in **method area (MetaSpace in Java 8+)**.  
 4️⃣ **Local variables and method calls** → Stored in **stack memory**.

Example: Memory Allocation  
java

CopyEdit

`class Employee {`

    `String name; // Stored in heap`

    `int age;     // Stored in heap`

    `Employee(String name, int age) {`

        `this.name = name;`

        `this.age = age;`

    `}`

    `void display() {`

        `String message = "Hello"; // Local variable (stored in stack)`

        `System.out.println(message + ", " + name + " is " + age + " years old.");`

    `}`

    `public static void main(String[] args) {`

        `Employee e1 = new Employee("Alice", 30); // Stored in heap`

        `e1.display();`

    `}`

`}`

✔ **Local variable `message` → Stored in stack**  
 ✔ **Object `e1` → Stored in heap**  
 ✔ **Instance variables `name` & `age` → Stored in heap**

---

5\. Garbage Collection in Java

Java uses **Garbage Collection (GC)** to automatically remove **unused objects** and free memory.

Key Features of Garbage Collection

✔ **Automatic memory management (no manual `free()` like C++)**  
 ✔ **Identifies unused objects and removes them**  
 ✔ **Runs periodically in the background**

---

6\. How Garbage Collection Works?

Garbage collection works by identifying **objects that are no longer reachable** and freeing the memory they occupy.

Objects Become Eligible for GC When:

1️⃣ No **active reference** to the object.  
 2️⃣ **Explicitly set to `null`** (`obj = null;`).  
 3️⃣ **Out of scope** (e.g., local variables after method execution).  
 4️⃣ **Reference is reassigned to another object.**

Example: Eligible for GC  
java

CopyEdit

`class GCExample {`

    `String data;`

    `GCExample(String data) {`

        `this.data = data;`

    `}`

    `public static void main(String[] args) {`

        `GCExample obj1 = new GCExample("Java");`

        `GCExample obj2 = new GCExample("Python");`

        `obj1 = obj2;  // Java object becomes unreachable → Eligible for GC`

        `obj2 = null;  // Python object also becomes unreachable → Eligible for GC`

        `System.gc();  // Request garbage collection`

    `}`

    `@Override`

    `protected void finalize() {`

        `System.out.println("Garbage Collected: " + this.data);`

    `}`

`}`

✔ `finalize()` method is called before garbage collection.  
 ✔ `System.gc()` requests GC (not guaranteed to run immediately).

---

7\. Types of Garbage Collectors in Java

Java provides different **garbage collection algorithms**:

(a) Serial Garbage Collector (Single-Threaded)

* **Use:** Small applications (default in single-threaded apps).  
* **JVM Option:** `-XX:+UseSerialGC`

(b) Parallel Garbage Collector (Multi-Threaded)

* **Use:** Multi-threaded applications, better performance.  
* **JVM Option:** `-XX:+UseParallelGC`

(c) CMS (Concurrent Mark-Sweep) Garbage Collector

* **Use:** Low-latency applications, minimizes pause time.  
* **JVM Option:** `-XX:+UseConcMarkSweepGC`

(d) G1 (Garbage-First) Garbage Collector (Default in Java 9+)

* **Use:** Large applications with real-time performance.  
* **JVM Option:** `-XX:+UseG1GC`

---

8\. Important GC Phases (Mark and Sweep)

1️⃣ **Mark Phase** → Identifies active (reachable) objects.  
 2️⃣ **Sweep Phase** → Removes unused objects and reclaims memory.

---

9\. How to Optimize Memory Management?

✔ **Use `null` to dereference objects (if no longer needed).**  
 ✔ **Use `try-with-resources` for automatic cleanup of resources.**  
 ✔ **Avoid memory leaks (e.g., forgetting to close resources like file streams).**  
 ✔ **Use Weak References (`WeakReference`, `SoftReference`, `PhantomReference`) when needed.**

---

10\. Common Memory Issues in Java

(a) Memory Leaks

* Happens when **objects are unintentionally kept in memory** and not garbage collected.  
* **Example: Static collections holding unused objects.**

(b) OutOfMemoryError (`java.lang.OutOfMemoryError`)

* **Occurs when heap memory is exhausted.**

**Solution:** Increase heap size using JVM options:  
 sh  
CopyEdit  
`java -Xms512m -Xmx2g MyClass`

*  (`-Xms`: Initial heap size, `-Xmx`: Maximum heap size)

---

# Java Classes in Depth \- Part 1: Nested Class, Concrete, Abstract, Object, Super and Sub Class

Java is an **object-oriented programming (OOP) language**, and **classes** are the core building blocks of Java programs. This guide will cover various types of classes in Java, including **nested classes, concrete classes, abstract classes, objects, superclasses, and subclasses.**

---

1\. What is a Class in Java?

A **class** is a blueprint for creating objects. It defines **fields (variables) and methods (functions)** that describe an object’s behavior.

Example: Simple Java Class  
java

CopyEdit

`class Car {`

    `String brand;`

    `int speed;`

    `void accelerate() {`

        `speed += 10;`

        `System.out.println(brand + " is now at " + speed + " km/h");`

    `}`

`}`

✔ **`Car` is a class (blueprint).**  
 ✔ **It has two fields (`brand`, `speed`).**  
 ✔ **It has a method `accelerate()` to modify `speed`.**

---

2\. Objects in Java

An **object** is an instance of a class. It represents **real-world entities**.

Example: Creating an Object  
java

CopyEdit

`public class Main {`

    `public static void main(String[] args) {`

        `Car myCar = new Car();  // Creating an object`

        `myCar.brand = "Tesla";`

        `myCar.speed = 50;`

        `myCar.accelerate();  // Output: Tesla is now at 60 km/h`

    `}`

`}`

✔ **Objects store data and perform operations defined in the class.**  
 ✔ **We use the `new` keyword to create objects.**

---

3\. Concrete Class in Java

A **concrete class** is a class that provides complete implementation for all methods.

Example: Concrete Class  
java

CopyEdit

`class Dog {`

    `void bark() {`

        `System.out.println("Woof! Woof!");`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Dog d = new Dog();`

        `d.bark();  // Output: Woof! Woof!`

    `}`

`}`

✔ **`Dog` is a concrete class since it provides full method implementations.**  
 ✔ **Concrete classes can be instantiated (objects can be created).**

---

4\. Abstract Class in Java

An **abstract class** cannot be instantiated and may contain **abstract methods** (methods without implementation).

Example: Abstract Class  
java

CopyEdit

`abstract class Animal {`

    `abstract void makeSound();  // Abstract method (no implementation)`

    `void sleep() {  // Concrete method (with implementation)`

        `System.out.println("Sleeping...");`

    `}`

`}`

`class Cat extends Animal {`

    `void makeSound() {`

        `System.out.println("Meow! Meow!");`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Cat c = new Cat();`

        `c.makeSound();  // Output: Meow! Meow!`

        `c.sleep();  // Output: Sleeping...`

    `}`

`}`

✔ **`Animal` is an abstract class (cannot be instantiated).**  
 ✔ **`makeSound()` is an abstract method (subclasses must implement it).**  
 ✔ **`Cat` provides the actual implementation of `makeSound()`.**

---

5\. Super and Sub Classes  
5.1 Superclass (Parent Class)

A **superclass** is a class that is inherited by another class.

5.2 Subclass (Child Class)

A **subclass** is a class that extends a superclass and inherits its properties.

Example: Superclass & Subclass  
java

CopyEdit

`class Animal {  // Superclass`

    `void eat() {`

        `System.out.println("This animal eats food.");`

    `}`

`}`

`class Dog extends Animal {  // Subclass`

    `void bark() {`

        `System.out.println("Barking...");`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Dog d = new Dog();`

        `d.eat();  // Output: This animal eats food. (Inherited from superclass)`

        `d.bark();  // Output: Barking...`

    `}`

`}`

✔ **`Animal` is a superclass, `Dog` is a subclass.**  
 ✔ **`Dog` inherits the `eat()` method from `Animal`.**  
 ✔ **It also has its own method `bark()`.**

---

6\. Nested Classes in Java

A **nested class** is a class defined within another class. Java provides four types:

6.1 Static Nested Class

A static nested class is associated with the outer class but does not require an instance of the outer class.

java

CopyEdit

`class Outer {`

    `static class Nested {`

        `void display() {`

            `System.out.println("Static Nested Class");`

        `}`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Outer.Nested obj = new Outer.Nested();`

        `obj.display();  // Output: Static Nested Class`

    `}`

`}`

✔ **Accessed using `Outer.Nested` because it's static.**

---

6.2 Non-Static (Inner) Class

An inner class requires an instance of the outer class.

java

CopyEdit

`class Outer {`

    `class Inner {`

        `void show() {`

            `System.out.println("Inner Class");`

        `}`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Outer outer = new Outer();`

        `Outer.Inner inner = outer.new Inner(); // Creating an instance of inner class`

        `inner.show();  // Output: Inner Class`

    `}`

`}`

✔ **Inner class object is created using an outer class object.**

---

6.3 Local Inner Class

A local inner class is defined inside a method.

java

CopyEdit

`class Outer {`

    `void display() {`

        `class Local {`

            `void show() {`

                `System.out.println("Local Inner Class");`

            `}`

        `}`

        `Local obj = new Local();`

        `obj.show();`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Outer outer = new Outer();`

        `outer.display();  // Output: Local Inner Class`

    `}`

`}`

✔ **Local class exists only inside `display()` method.**

---

6.4 Anonymous Inner Class

An **anonymous inner class** has no name and is defined at object creation.

java

CopyEdit

`abstract class Person {`

    `abstract void speak();`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Person p = new Person() {  // Anonymous class`

            `void speak() {`

                `System.out.println("Speaking...");`

            `}`

        `};`

        `p.speak();  // Output: Speaking...`

    `}`

`}`

✔ **Used for quick, one-time use.**

---

7\. Summary

| Type | Description |
| ----- | ----- |
| **Concrete Class** | Fully implemented class. Objects can be created. |
| **Abstract Class** | Contains abstract and concrete methods. Cannot be instantiated. |
| **Super Class** | A class that is extended by another class. |
| **Sub Class** | A class that inherits from a superclass. |
| **Nested Class** | A class inside another class (Static, Inner, Local, Anonymous). |

---

# Java Generic Classes | Java Classes in Depth \- Part 2

1\. Introduction to Java Generics

Generics in Java allow us to **define classes, interfaces, and methods with type parameters**. This enables **type safety, reusability, and flexibility** while writing code.

Why Use Generics?

✔ **Type Safety** – Avoids `ClassCastException`.  
 ✔ **Code Reusability** – A single generic class can handle multiple data types.  
 ✔ **Compile-time Checking** – Errors are caught at compile time instead of runtime.

---

2\. Generic Classes in Java

A **generic class** allows the use of a placeholder type (`T`, `E`, `K`, `V`, etc.), which gets replaced with an actual type when an object is created.

2.1 Creating a Generic Class  
java

CopyEdit

`// Defining a generic class with type parameter <T>`

`class Box<T> {`

    `private T item;  // Type T acts as a placeholder for any type`

    `void setItem(T item) {`

        `this.item = item;`

    `}`

    `T getItem() {`

        `return item;`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Box<String> stringBox = new Box<>();  // Box for Strings`

        `stringBox.setItem("Hello Generics");`

        `System.out.println(stringBox.getItem());  // Output: Hello Generics`

        `Box<Integer> intBox = new Box<>();  // Box for Integers`

        `intBox.setItem(100);`

        `System.out.println(intBox.getItem());  // Output: 100`

    `}`

`}`

✔ **`Box<T>` is a generic class where `T` can be any data type.**  
 ✔ **We created `Box<String>` and `Box<Integer>` without modifying the class.**

---

2.2 Multiple Type Parameters in a Generic Class

You can define a **generic class with multiple type parameters**.

java

CopyEdit

`class Pair<K, V> {`

    `private K key;`

    `private V value;`

    `Pair(K key, V value) {`

        `this.key = key;`

        `this.value = value;`

    `}`

    `K getKey() { return key; }`

    `V getValue() { return value; }`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Pair<String, Integer> student = new Pair<>("Alice", 90);`

        `System.out.println("Name: " + student.getKey() + ", Marks: " + student.getValue());`

        `Pair<Integer, String> data = new Pair<>(101, "Data Science");`

        `System.out.println("ID: " + data.getKey() + ", Course: " + data.getValue());`

    `}`

`}`

✔ **The `Pair<K, V>` class stores two different generic types (`K` and `V`).**  
 ✔ **`Pair<String, Integer>` holds a name and marks.**  
 ✔ **`Pair<Integer, String>` holds an ID and course name.**

---

3\. Generic Methods in Java

A **generic method** allows a method to work with different data types without changing its definition.

3.1 Creating a Generic Method  
java

CopyEdit

`class Utility {`

    `// Generic method with type parameter <T>`

    `public static <T> void printArray(T[] array) {`

        `for (T item : array) {`

            `System.out.print(item + " ");`

        `}`

        `System.out.println();`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Integer[] intArray = {1, 2, 3, 4};`

        `String[] strArray = {"A", "B", "C"};`

        `Utility.printArray(intArray);  // Output: 1 2 3 4`

        `Utility.printArray(strArray);  // Output: A B C`

    `}`

`}`

✔ **`printArray()` is a generic method that prints elements of any type array.**  
 ✔ **It works with `Integer[]` and `String[]` without modification.**

---

4\. Bounded Type Parameters in Generics

Sometimes, we want to **restrict the generic type to specific classes (e.g., only `Number` types)**.

4.1 Using Upper Bounded Wildcards (`extends`)

We can specify that **T must be a subclass of a certain type**.

java

CopyEdit

`class MathUtil<T extends Number> {  // T must be a subclass of Number`

    `private T num;`

    `MathUtil(T num) {`

        `this.num = num;`

    `}`

    `double square() {`

        `return num.doubleValue() * num.doubleValue();`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `MathUtil<Integer> intObj = new MathUtil<>(5);`

        `System.out.println(intObj.square());  // Output: 25.0`

        `MathUtil<Double> doubleObj = new MathUtil<>(5.5);`

        `System.out.println(doubleObj.square());  // Output: 30.25`

    `}`

`}`

✔ **`T extends Number` ensures that `T` is a subclass of `Number`.**  
 ✔ **Allows `Integer`, `Double`, `Float`, but not `String`.**

---

5\. Wildcards in Generics

Wildcards (`?`) make generics **more flexible** by allowing unknown types.

5.1 Unbounded Wildcard (`<?>`)

Useful when we don’t know the type in advance.

java

CopyEdit

`class Printer {`

    ``static void printList(List<?> list) {  // `?` allows any type``

        `for (Object obj : list) {`

            `System.out.print(obj + " ");`

        `}`

        `System.out.println();`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `List<Integer> intList = Arrays.asList(1, 2, 3);`

        `List<String> strList = Arrays.asList("A", "B", "C");`

        `Printer.printList(intList);  // Output: 1 2 3`

        `Printer.printList(strList);  // Output: A B C`

    `}`

`}`

✔ **Wildcard `<?>` allows `List<Integer>`, `List<String>`, etc.**  
 ✔ **This provides flexibility when working with collections of unknown types.**

---

5.2 Upper Bounded Wildcard (`<? extends Type>`)

Restricts the wildcard to accept **only subtypes** of a certain class.

java

CopyEdit

`class SumUtil {`

    `static double sum(List<? extends Number> list) {`

        `double sum = 0.0;`

        `for (Number num : list) {`

            `sum += num.doubleValue();`

        `}`

        `return sum;`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `List<Integer> numbers = Arrays.asList(1, 2, 3, 4);`

        `System.out.println("Sum: " + SumUtil.sum(numbers));  // Output: 10.0`

    `}`

`}`

✔ **`List<? extends Number>` allows `Integer`, `Double`, etc.**  
 ✔ **Ensures the list only contains `Number` or its subclasses.**

---

6\. Generic Interfaces

Interfaces can also be **generic**, just like classes.

6.1 Creating a Generic Interface  
java

CopyEdit

`interface Container<T> {`

    `void add(T item);`

    `T retrieve();`

`}`

`class Storage<T> implements Container<T> {`

    `private T item;`

    `public void add(T item) {`

        `this.item = item;`

    `}`

    `public T retrieve() {`

        `return item;`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Container<String> stringStorage = new Storage<>();`

        `stringStorage.add("Generic Interface Example");`

        `System.out.println(stringStorage.retrieve());  // Output: Generic Interface Example`

    `}`

`}`

✔ **Interfaces can have generic types (`Container<T>`).**  
 ✔ **Classes implementing the interface define the actual type (`Storage<String>`).**

---

7\. Summary

| Feature | Description |
| ----- | ----- |
| **Generic Class** | A class that takes type parameters (`class Box<T> {}`). |
| **Generic Method** | A method with type parameters (`public <T> void method(T t) {}`). |
| **Bounded Type (`extends`)** | Restricts the type to a certain class/subclass (`T extends Number`). |
| **Wildcards (`?`)** | Allows unknown types (`List<?>`, `List<? extends Number>`). |
| **Generic Interface** | Interfaces that support generics (`interface Container<T> {}`). |

---

# Java Enum, POJO, and Final Classes Explained with Examples | Java Classes in Depth \- Part 3

Java provides different types of classes, including **Enums, POJOs (Plain Old Java Objects), and Final Classes**. This guide will explain each type with **examples**.

---

1\. Java Enum (Enumeration)

An **enum** is a special type in Java used to **define a fixed set of constants**. It is useful when a variable should have only a limited set of possible values.

1.1 Defining an Enum  
java

CopyEdit

`enum Day {`

    `SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;`

`}`

✔ **Each value inside an enum is a constant (`final` and `static`).**  
 ✔ **By default, enums extend `java.lang.Enum` (cannot extend other classes).**

---

1.2 Using an Enum in Java  
java

CopyEdit

`public class Main {`

    `public static void main(String[] args) {`

        `Day today = Day.FRIDAY;`

        `System.out.println("Today is: " + today);  // Output: Today is: FRIDAY`

        `// Using Enum in Switch`

        `switch (today) {`

            `case MONDAY -> System.out.println("Start of the week!");`

            `case FRIDAY -> System.out.println("Weekend is near!");`

            `default -> System.out.println("A regular day.");`

        `}`

    `}`

`}`

✔ **Enum can be used in `switch` statements.**  
 ✔ **Each enum constant is accessed using `EnumName.CONSTANT`.**

---

1.3 Enum with Custom Fields and Methods

Enums can have **fields, constructors, and methods**.

java

CopyEdit

`enum Size {`

    `SMALL(10), MEDIUM(20), LARGE(30);`

    

    `private final int value;`

    `Size(int value) {  // Constructor`

        `this.value = value;`

    `}`

    `public int getValue() {`

        `return value;`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Size s = Size.MEDIUM;`

        `System.out.println("Size: " + s + ", Value: " + s.getValue());`  

        `// Output: Size: MEDIUM, Value: 20`

    `}`

`}`

✔ **Each enum constant can hold values (`SMALL(10), MEDIUM(20)`).**  
 ✔ **`getValue()` returns the assigned value.**

---

2\. POJO (Plain Old Java Object)

A **POJO** is a simple Java class that does not extend or implement special classes/interfaces. It is mainly used to **store and transfer data**.

2.1 Characteristics of a POJO

✔ **Private fields with public getter/setter methods.**  
 ✔ **No business logic, just data storage.**  
 ✔ **No special constraints (unlike JavaBeans which require serialization, default constructor, etc.).**

---

2.2 Example of a POJO  
java

CopyEdit

`class Student {`

    `private String name;`

    `private int age;`

    `// Constructor`

    `public Student(String name, int age) {`

        `this.name = name;`

        `this.age = age;`

    `}`

    `// Getters and Setters`

    `public String getName() { return name; }`

    `public void setName(String name) { this.name = name; }`

    `public int getAge() { return age; }`

    `public void setAge(int age) { this.age = age; }`

    `// toString() method`

    `@Override`

    `public String toString() {`

        `return "Student{name='" + name + "', age=" + age + "}";`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Student s = new Student("Alice", 22);`

        `System.out.println(s);  // Output: Student{name='Alice', age=22}`

    `}`

`}`

✔ **Encapsulation: Fields are private, accessed via getters/setters.**  
 ✔ **No special annotations, interfaces, or extensions (Pure POJO).**

---

2.3 POJO vs JavaBean

| Feature | POJO | JavaBean |
| ----- | ----- | ----- |
| **Getters/Setters** | Optional | Required |
| **Default Constructor** | Optional | Required |
| **Implements Serializable** | No | Yes |
| **Annotations** | No | Sometimes required |

**🔹 JavaBeans are stricter versions of POJOs, often used in frameworks like Spring and Hibernate.**

---

3\. Final Classes in Java

A **final class** is a class that **cannot be inherited (extended)**. It is used when we want to **prevent modification or extension of a class**.

3.1 Declaring a Final Class  
java

CopyEdit

`final class MathUtils {`

    `public static int square(int num) {`

        `return num * num;`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `System.out.println(MathUtils.square(5));  // Output: 25`

    `}`

`}`

✔ **`MathUtils` is `final`, so no class can extend it.**  
 ✔ **Useful for utility/helper classes.**

---

3.2 Attempting to Extend a Final Class (Compilation Error)  
java

CopyEdit

`final class Parent {`

    `void display() {`

        `System.out.println("Parent class");`

    `}`

`}`

`// This will cause a compilation error!`

`class Child extends Parent {` 

    `void show() {`

        `System.out.println("Child class");`

    `}`

`}`

🚨 **Error:** `Cannot inherit from final Parent`.

---

3.3 Final Methods (Prevent Method Overriding)

A **final method** prevents subclasses from overriding it.

java

CopyEdit

`class Vehicle {`

    `final void start() {`

        `System.out.println("Vehicle is starting...");`

    `}`

`}`

`class Car extends Vehicle {`

    `// This will cause an error!`

    `// void start() { System.out.println("Car is starting..."); }`

`}`

🚨 **Error:** `Cannot override the final method from Vehicle`.

✔ **Useful for methods that should not be modified in subclasses.**

---

3.4 Final Variables (Constants in Java)

A **final variable** becomes a constant and **cannot be changed after initialization**.

java

CopyEdit

`class Config {`

    `static final double PI = 3.14159;  // Constant value`

    `void show() {`

        `// PI = 3.14;  // Error: Cannot assign a value to final variable 'PI'`

        `System.out.println("Value of PI: " + PI);`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Config c = new Config();`

        `c.show();  // Output: Value of PI: 3.14159`

    `}`

`}`

✔ **`final` variables must be initialized at declaration or in the constructor.**  
 ✔ **Once assigned, they cannot be changed.**

---

4\. Summary

| Feature | Enum | POJO | Final Class |
| ----- | ----- | ----- | ----- |
| **Purpose** | Defines constants | Stores and transfers data | Prevents inheritance |
| **Fields** | Constants | Private variables | Any variables |
| **Methods** | Can have methods | Getters/Setters | Cannot be overridden |
| **Inheritance** | Cannot extend other classes | Can extend classes | Cannot be extended |
| **Example** | `enum Day {MON, TUE}` | `class Student {}` | `final class MathUtils {}` |

---

# Java Singleton and Immutable Class Explained with Examples | Java Classes in Depth \- Part 4

In this guide, we will cover **Singleton and Immutable Classes** in Java, their purpose, implementation, and best practices.

---

1\. Singleton Class in Java

A **Singleton class** ensures that **only one instance** of the class is created and provides a **global point of access** to it.

1.1 Key Features of a Singleton Class

✔ **Only one instance is created throughout the application.**  
 ✔ **Provides a global access point using a static method.**  
 ✔ **Constructor is private to prevent external instantiation.**

---

2\. Implementing a Singleton Class

2.1 Eager Initialization (Thread-Safe)

In **Eager Initialization**, the instance is created at the time of class loading.

java

CopyEdit

`class Singleton {`

    `private static final Singleton instance = new Singleton(); // Early creation`

    `private Singleton() { } // Private constructor`

    `public static Singleton getInstance() {`

        `return instance;`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Singleton obj1 = Singleton.getInstance();`

        `Singleton obj2 = Singleton.getInstance();`

        `System.out.println(obj1 == obj2); // Output: true (same instance)`

    `}`

`}`

✔ **Simple and thread-safe.**  
 ❌ **Instance is created even if not used (memory waste).**

---

2.2 Lazy Initialization (Not Thread-Safe)

In **Lazy Initialization**, the instance is created only when `getInstance()` is called.

java

CopyEdit

`class Singleton {`

    `private static Singleton instance;  // No instance created initially`

    `private Singleton() { }`

    `public static Singleton getInstance() {`

        `if (instance == null) { // Instance created only when required`

            `instance = new Singleton();`

        `}`

        `return instance;`

    `}`

`}`

✔ **Instance is created only when needed (better memory usage).**  
 ❌ **Not thread-safe in a multi-threaded environment.**

---

2.3 Thread-Safe Singleton Using Synchronized Method

To ensure thread safety, we can use `synchronized` on `getInstance()`.

java

CopyEdit

`class Singleton {`

    `private static Singleton instance;`

    `private Singleton() { }`

    `public static synchronized Singleton getInstance() { // Synchronized method`

        `if (instance == null) {`

            `instance = new Singleton();`

        `}`

        `return instance;`

    `}`

`}`

✔ **Thread-safe but slower due to method synchronization.**  
 ❌ **Every call to `getInstance()` is synchronized, even when unnecessary.**

---

2.4 Best Approach: Double-Checked Locking (Thread-Safe & Efficient)

This improves performance by **synchronizing only when necessary**.

java

CopyEdit

`class Singleton {`

    `private static volatile Singleton instance; // Volatile ensures visibility across threads`

    `private Singleton() { }`

    `public static Singleton getInstance() {`

        `if (instance == null) {  // First check (without synchronization)`

            `synchronized (Singleton.class) {  // Synchronize block`

                `if (instance == null) {  // Second check (inside synchronized block)`

                    `instance = new Singleton();`

                `}`

            `}`

        `}`

        `return instance;`

    `}`

`}`

✔ **Thread-safe and optimized for performance.**

---

2.5 Singleton Using Enum (Best Practice)

Using **enum** ensures Singleton properties with built-in thread safety and serialization support.

java

CopyEdit

`enum Singleton {`

    `INSTANCE; // Single instance`

    `public void showMessage() {`

        `System.out.println("Singleton using Enum!");`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Singleton.INSTANCE.showMessage();`

    `}`

`}`

✔ **Thread-safe, serialization-safe, and simple to implement.**  
 ✔ **Recommended over other Singleton implementations.**

---

3\. Immutable Class in Java

An **Immutable class** is one whose objects **cannot be modified** after creation.

3.1 Key Features of an Immutable Class

✔ **Fields are declared `final`.**  
 ✔ **No setter methods are provided.**  
 ✔ **Objects are created via constructors only.**  
 ✔ **If the class contains mutable objects, defensive copies are made.**

---

4\. Implementing an Immutable Class

A properly designed **immutable class** in Java:

java

CopyEdit

`final class ImmutablePerson {  // Step 1: Declare class as final`

    `private final String name;  // Step 2: Make fields final`

    `private final int age;`

    `public ImmutablePerson(String name, int age) {  // Step 3: Initialize fields via constructor`

        `this.name = name;`

        `this.age = age;`

    `}`

    `public String getName() {  // Step 4: Only getter methods, no setters`

        `return name;`

    `}`

    `public int getAge() {`

        `return age;`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `ImmutablePerson person = new ImmutablePerson("Alice", 25);`

        `System.out.println(person.getName());  // Output: Alice`

    `}`

`}`

✔ **Class cannot be modified after object creation.**

---

4.1 Handling Mutable Fields (Using Defensive Copies)

If an immutable class contains a mutable field (e.g., `List`), **return a copy instead of the original object**.

java

CopyEdit

`import java.util.*;`

`final class ImmutableStudent {`

    `private final String name;`

    `private final List<String> subjects;`

    `public ImmutableStudent(String name, List<String> subjects) {`

        `this.name = name;`

        `this.subjects = new ArrayList<>(subjects);  // Defensive copy`

    `}`

    `public String getName() {`

        `return name;`

    `}`

    `public List<String> getSubjects() {`

        `return new ArrayList<>(subjects);  // Defensive copy`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `List<String> subjects = new ArrayList<>(Arrays.asList("Math", "Science"));`

        `ImmutableStudent student = new ImmutableStudent("John", subjects);`

        `subjects.add("History");  // Modifying original list`

        `System.out.println(student.getSubjects());  // Output: [Math, Science] (unchanged)`

    `}`

`}`

✔ **`subjects` is protected from external modifications.**  
 ✔ **Returning a new copy prevents mutation.**

---

5\. Singleton vs Immutable Class

| Feature | Singleton Class | Immutable Class |
| ----- | ----- | ----- |
| **Definition** | Only one instance exists | Object state cannot be changed |
| **Instance Creation** | Controlled via `getInstance()` | Created via constructor |
| **Thread Safety** | Can be ensured using `synchronized`, `volatile`, etc. | Naturally thread-safe |
| **Modification** | Can have mutable state | No modifications allowed after creation |
| **Examples** | Logger, ConfigurationManager | `String`, `Integer`, `LocalDate` |

---

# Java Interface in Depth

1\. What is an Interface and How to Define It?

An **interface** in Java is a **blueprint** for a class that defines a **set of methods** without providing their implementations. It is used to achieve **abstraction** and **multiple inheritance** in Java.

Syntax of an Interface

java

CopyEdit

`interface Animal {`

    `void makeSound();  // Abstract method (no implementation)`

`}`

✔ **All methods in an interface are abstract by default (until Java 8).**  
 ✔ **An interface cannot have a constructor (cannot create objects).**

---

2\. Why Do We Need an Interface?

Interfaces help in **decoupling** code, **achieving abstraction**, and **supporting multiple inheritance** in Java.

Key Benefits of Interfaces:

✔ **Achieves Abstraction**: Hides implementation details.  
 ✔ **Supports Multiple Inheritance**: A class can implement multiple interfaces.  
 ✔ **Promotes Loose Coupling**: Helps in designing flexible applications.  
 ✔ **Defines a Contract**: Ensures that implementing classes follow a common structure.

Example of Loose Coupling

java

CopyEdit

`interface Vehicle {`

    `void start();`

`}`

`class Car implements Vehicle {`

    `public void start() {`

        `System.out.println("Car is starting...");`

    `}`

`}`

`class Bike implements Vehicle {`

    `public void start() {`

        `System.out.println("Bike is starting...");`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Vehicle v = new Car();  // Loose coupling`

        `v.start();  // Output: Car is starting...`

    `}`

`}`

✔ The `Vehicle` interface allows us to create flexible, reusable code.

---

3\. Methods in an Interface

Before Java 8, **all methods** in an interface were **abstract**. Java 8 introduced **default and static methods**, and Java 9 introduced **private methods**.

Types of Methods in an Interface

| Method Type | Modifier | Implementation | Since |
| ----- | ----- | ----- | ----- |
| **Abstract Method** | `public abstract` (default) | No implementation | Java 1.0 |
| **Default Method** | `default` | Has implementation | Java 8 |
| **Static Method** | `static` | Has implementation | Java 8 |
| **Private Method** | `private` | Used inside the interface | Java 9 |

---

3.1 Abstract Methods (Default)

java

CopyEdit

`interface Animal {`

    `void eat();  // Abstract method (No body)`

`}`

✔ **All interface methods are `public` and `abstract` by default.**

---

3.2 Default Methods (Introduced in Java 8\)

Allows adding new methods **without breaking existing implementations**.

java

CopyEdit

`interface Animal {`

    `void eat();`

    `default void sleep() {`

        `System.out.println("Sleeping...");`

    `}`

`}`

`class Dog implements Animal {`

    `public void eat() {`

        `System.out.println("Dog is eating...");`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Dog d = new Dog();`

        `d.eat();   // Output: Dog is eating...`

        `d.sleep(); // Output: Sleeping...`

    `}`

`}`

✔ **`default` methods can be overridden in implementing classes.**

---

3.3 Static Methods (Introduced in Java 8\)

Static methods belong to the interface and **cannot be overridden**.

java

CopyEdit

`interface MathOperations {`

    `static int square(int x) {`

        `return x * x;`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `System.out.println(MathOperations.square(5)); // Output: 25`

    `}`

`}`

✔ **`static` methods are accessed using `InterfaceName.method()`.**

---

3.4 Private Methods (Introduced in Java 9\)

Used **only inside the interface** to avoid code duplication.

java

CopyEdit

`interface Logger {`

    `default void logInfo(String message) {`

        `log("INFO: " + message);`

    `}`

    `private void log(String message) {  // Private method`

        `System.out.println(message);`

    `}`

`}`

`class App implements Logger { }`

`public class Main {`

    `public static void main(String[] args) {`

        `App app = new App();`

        `app.logInfo("Application started!");`  

        `// Output: INFO: Application started!`

    `}`

`}`

✔ **`private` methods are useful for code reuse inside the interface.**

---

4\. Fields in an Interface

* All fields in an interface are **public, static, and final** by default.  
* They **must be initialized** at declaration.

java

CopyEdit

`interface Config {`

    `int MAX_USERS = 100;  // Public, static, and final by default`

`}`

✔ **Cannot modify `MAX_USERS` because it is `final`.**

---

5\. Interface Implementation

A class uses the `implements` keyword to implement an interface.

java

CopyEdit

`interface Animal {`

    `void makeSound();`

`}`

`class Dog implements Animal {`

    `public void makeSound() {`

        `System.out.println("Woof Woof!");`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Animal dog = new Dog();`

        `dog.makeSound();  // Output: Woof Woof!`

    `}`

`}`

✔ **A class must implement all abstract methods of an interface.**

---

6\. Nested Interfaces

A **nested interface** is an interface inside another interface or class.

6.1 Nested Interface Inside Another Interface

java

CopyEdit

`interface Outer {`

    `interface Inner {`

        `void show();`

    `}`

`}`

`class Test implements Outer.Inner {`

    `public void show() {`

        `System.out.println("Nested Interface Implemented!");`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Outer.Inner obj = new Test();`

        `obj.show();  // Output: Nested Interface Implemented!`

    `}`

`}`

✔ **Used in frameworks and API design.**

---

7\. Difference Between Interface and Abstract Class

| Feature | Interface | Abstract Class |
| ----- | ----- | ----- |
| **Definition** | Blueprint with abstract methods | Can have both abstract and concrete methods |
| **Methods** | Abstract, default, static, and private methods | Abstract and concrete methods |
| **Fields** | Only `public static final` fields | Can have `static`, `final`, and instance fields |
| **Constructors** | No constructors | Can have constructors |
| **Access Modifiers** | Methods are `public` by default | Methods can have any access modifier |
| **Multiple Inheritance** | A class can implement multiple interfaces | A class can extend only one abstract class |
| **Performance** | Slower due to method lookup | Faster than interfaces |

---

# Default, Static & Private Methods in Interface \- Java 8 & Java 9 Features

(📌 *Java Interfaces \- Part 2*)

1\. Introduction

Before **Java 8**, interfaces in Java could only have **abstract methods** (methods without a body). Java 8 introduced **default and static methods**, and Java 9 introduced **private methods**. These enhancements made interfaces more powerful while ensuring backward compatibility.

Why Were These Features Introduced?

✔ To **add new methods** to interfaces **without breaking existing implementations**.  
 ✔ To **avoid duplicate code** across multiple implementing classes.  
 ✔ To provide **utility methods** inside interfaces using **static methods**.

---

2\. Default Methods in Interface (Java 8\)

A **default method** is a method with a body inside an interface. It provides a **default implementation** for implementing classes.

Syntax:  
java

CopyEdit

`interface InterfaceName {`

    `default void methodName() {`

        `// method implementation`

    `}`

`}`

Example: Default Method in Interface  
java

CopyEdit

`interface Vehicle {`

    `void start(); // Abstract method`

    `default void stop() {  // Default method`

        `System.out.println("Vehicle is stopping...");`

    `}`

`}`

`class Car implements Vehicle {`

    `public void start() {`

        `System.out.println("Car is starting...");`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Car car = new Car();`

        `car.start(); // Output: Car is starting...`

        `car.stop();  // Output: Vehicle is stopping...`

    `}`

`}`

✔ The `stop()` method **does not need to be implemented** in `Car` because it has a **default** implementation.

---

2.1 Overriding a Default Method

If a class needs a **custom implementation**, it can **override** the default method.

java

CopyEdit

`class Bike implements Vehicle {`

    `public void start() {`

        `System.out.println("Bike is starting...");`

    `}`

    `@Override`

    `public void stop() {`

        `System.out.println("Bike is stopping...");`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Bike bike = new Bike();`

        `bike.start(); // Output: Bike is starting...`

        `bike.stop();  // Output: Bike is stopping... (Overridden method)`

    `}`

`}`

✔ **A default method can be overridden** in the implementing class.

---

2.2 Default Methods with Multiple Interfaces (Diamond Problem)

If a class implements **two interfaces** with the **same default method**, it **must override** the method to avoid ambiguity.

java

CopyEdit

`interface InterfaceA {`

    `default void show() {`

        `System.out.println("InterfaceA show()");`

    `}`

`}`

`interface InterfaceB {`

    `default void show() {`

        `System.out.println("InterfaceB show()");`

    `}`

`}`

`class MyClass implements InterfaceA, InterfaceB {`

    `@Override`

    `public void show() {`

        `System.out.println("MyClass show() - Resolving conflict");`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `MyClass obj = new MyClass();`

        `obj.show(); // Output: MyClass show() - Resolving conflict`

    `}`

`}`

✔ The implementing class must **override the method** to resolve the conflict.

---

3\. Static Methods in Interface (Java 8\)

A **static method** inside an interface **belongs to the interface itself** and **cannot be overridden** by implementing classes.

Syntax:  
java

CopyEdit

`interface InterfaceName {`

    `static void methodName() {`

        `// method implementation`

    `}`

`}`

Example: Static Method in Interface  
java

CopyEdit

`interface Utility {`

    `static int square(int x) {`

        `return x * x;`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `System.out.println(Utility.square(5)); // Output: 25`

    `}`

`}`

✔ **Static methods are accessed using `InterfaceName.method()`.**  
 ✔ **They are not inherited by implementing classes.**

---

3.1 Static Methods Cannot Be Overridden  
java

CopyEdit

`interface Helper {`

    `static void display() {`

        `System.out.println("Helper Interface - Static Method");`

    `}`

`}`

`class Test implements Helper {`

    `// Cannot override static methods from an interface`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Test obj = new Test();`

        `// obj.display(); // ❌ Error: Cannot access static method from an instance`

        `Helper.display(); // ✅ Correct way to call it`

    `}`

`}`

✔ **Static methods belong to the interface, not the class implementing it.**

---

4\. Private Methods in Interface (Java 9\)

Java 9 introduced **private methods** in interfaces to **avoid code duplication** inside default and static methods.

Syntax:  
java

CopyEdit

`interface InterfaceName {`

    `private void methodName() {`

        `// method implementation`

    `}`

`}`

---

4.1 Example: Private Method Inside an Interface  
java

CopyEdit

`interface Logger {`

    `default void logInfo(String message) {`

        `log("INFO: " + message);`

    `}`

    `default void logError(String message) {`

        `log("ERROR: " + message);`

    `}`

    `private void log(String message) {  // Private method`

        `System.out.println(message);`

    `}`

`}`

`class App implements Logger { }`

`public class Main {`

    `public static void main(String[] args) {`

        `App app = new App();`

        `app.logInfo("Application started!");`  

        `// Output: INFO: Application started!`

        

        `app.logError("Something went wrong!");`  

        `// Output: ERROR: Something went wrong!`

    `}`

`}`

✔ The `log()` method is used by both `logInfo()` and `logError()` **without being exposed** to the implementing class.  
 ✔ **Private methods in an interface cannot be accessed outside the interface.**

---

5\. Summary of Java 8 & Java 9 Interface Features

| Feature | Java Version | Access Modifier | Purpose |
| ----- | ----- | ----- | ----- |
| **Default Method** | Java 8 | `default` | Allows adding new methods to interfaces without breaking existing implementations |
| **Static Method** | Java 8 | `static` | Provides utility methods inside interfaces |
| **Private Method** | Java 9 | `private` | Helps in code reuse inside default and static methods |

---

6\. Key Takeaways

✔ **Default methods** allow interfaces to have method implementations.  
 ✔ **Static methods** belong to the interface and cannot be overridden.  
 ✔ **Private methods** help in **code reuse** inside the interface.  
 ✔ **Default methods solve the problem of API evolution** without breaking existing implementations.  
 ✔ **Diamond problem can arise with default methods** if two interfaces have the same method, requiring explicit overriding.

---

# Functional Interface and Lambda Expression \- Java 8 Features

(📌 *Java Interfaces \- Part 3*)

1\. What is a Functional Interface?

A **functional interface** in Java is an interface that contains **exactly one abstract method**. It can have **multiple default and static methods** but must have **only one abstract method**.

Key Points:

✔ Functional interfaces are introduced in **Java 8**.  
 ✔ They are used for **Lambda Expressions** and **method references**.  
 ✔ Annotated with `@FunctionalInterface` (optional but recommended).

Example of a Functional Interface  
java

CopyEdit

`@FunctionalInterface`

`interface Greeting {`

    `void sayHello();  // Only one abstract method`

`}`

✔ This interface qualifies as a **Functional Interface** because it has exactly **one abstract method**.

---

2\. What is a Lambda Expression?

A **lambda expression** is a concise way to write **anonymous functions** in Java. It allows you to pass behavior as a parameter.

Syntax of Lambda Expression:  
java

CopyEdit

`(parameters) -> { body }`

---

3\. How to Use Functional Interfaces with Lambda Expressions?

A **lambda expression** can be used to implement a **functional interface** directly.

Example: Using a Lambda Expression with a Functional Interface  
java

CopyEdit

`@FunctionalInterface`

`interface Greeting {`

    `void sayHello();`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `// Using Lambda Expression`

        `Greeting greet = () -> System.out.println("Hello, World!");`

        `greet.sayHello(); // Output: Hello, World!`

    `}`

`}`

✔ The lambda expression `() -> System.out.println("Hello, World!")` replaces the need for a traditional class implementation.

---

4\. Advantage of Functional Interfaces

| Feature | Benefit |
| ----- | ----- |
| **Less Boilerplate Code** | Eliminates anonymous class syntax |
| **More Readable Code** | Simplifies function definitions |
| **Used in Streams & Parallel Processing** | Enhances Java functional programming |
| **Supports Method References** | Allows passing behavior as a parameter |

---

5\. Types of Functional Interfaces

Java provides four main functional interfaces in the `java.util.function` package:

5.1 Consumer (Accepts a value, returns nothing)

A **Consumer** takes **one input parameter** but **does not return** a value.

java

CopyEdit

`import java.util.function.Consumer;`

`public class Main {`

    `public static void main(String[] args) {`

        `Consumer<String> print = message -> System.out.println("Message: " + message);`

        `print.accept("Hello Java 8!"); // Output: Message: Hello Java 8!`

    `}`

`}`

✔ **Use Case:** Logging, performing actions without returning values.

---

5.2 Supplier (Returns a value, takes nothing)

A **Supplier** does **not take any input** but **returns a value**.

java

CopyEdit

`import java.util.function.Supplier;`

`public class Main {`

    `public static void main(String[] args) {`

        `Supplier<Double> getRandom = () -> Math.random();`

        `System.out.println(getRandom.get()); // Output: Random number`

    `}`

`}`

✔ **Use Case:** Generating values (random numbers, timestamps).

---

5.3 Function (Takes input, returns output)

A **Function** takes **one input** and **returns one output**.

java

CopyEdit

`import java.util.function.Function;`

`public class Main {`

    `public static void main(String[] args) {`

        `Function<Integer, Integer> square = x -> x * x;`

        `System.out.println(square.apply(5)); // Output: 25`

    `}`

`}`

✔ **Use Case:** Data transformation, mapping.

---

5.4 Predicate (Takes input, returns boolean)

A **Predicate** takes **one input** and **returns a boolean value**.

java

CopyEdit

`import java.util.function.Predicate;`

`public class Main {`

    `public static void main(String[] args) {`

        `Predicate<Integer> isEven = num -> num % 2 == 0;`

        `System.out.println(isEven.test(10)); // Output: true`

    `}`

`}`

✔ **Use Case:** Filtering, conditional checks.

---

6\. How to Handle Functional Interface Extending Another Interface?

A functional interface **can extend another interface**, but it must still have **only one abstract method**.

Case 1: Extending a Functional Interface  
java

CopyEdit

`@FunctionalInterface`

`interface A {`

    `void methodA();`

`}`

`@FunctionalInterface`

`interface B extends A { // Extends A, no new abstract method`

`}`

✔ `B` is still a **valid functional interface** because it inherits `methodA()`.

---

Case 2: Adding a New Abstract Method (Invalid Case)  
java

CopyEdit

`@FunctionalInterface`

`interface A {`

    `void methodA();`

`}`

`@FunctionalInterface`

`interface B extends A {`

    `void methodB(); // ❌ Error: More than one abstract method`

`}`

❌ This will cause a **compilation error** because `B` now has **two abstract methods**.

---

Case 3: Extending a Non-Functional Interface

If an interface **extends a non-functional interface**, it can **still be functional** if it introduces only **one abstract method**.

java

CopyEdit

`interface A {`

    `default void defaultMethod() {`

        `System.out.println("Default method in A");`

    `}`

`}`

`@FunctionalInterface`

`interface B extends A {`

    `void methodB(); // Only one abstract method`

`}`

✔ `B` is still a **valid functional interface** because it has **only one abstract method**.

---

7\. Summary

| Feature | Explanation |
| ----- | ----- |
| **Functional Interface** | An interface with **only one abstract method** |
| **Lambda Expression** | A concise way to write function implementations |
| **Consumer** | Takes an input, **returns nothing** |
| **Supplier** | Takes **no input**, returns a **value** |
| **Function** | Takes an input, returns **a transformed value** |
| **Predicate** | Takes an input, returns **a boolean result** |
| **Extending Functional Interfaces** | The child interface must still have **only one abstract method** |

---

# Java Reflection in Depth (With Examples)

1\. Introduction to Java Reflection

Java **Reflection** is a powerful feature that allows us to **inspect and manipulate classes, methods, fields, and constructors at runtime**. It is part of the **`java.lang.reflect`** package.

Why Use Reflection?

✔ Used in **frameworks** (Spring, Hibernate, JUnit, etc.)  
 ✔ Helps in **analyzing classes, methods, and fields** dynamically  
 ✔ Useful for **dependency injection and debugging**  
 ✔ Allows accessing **private fields and methods**

---

2\. Getting Class Object Using Reflection

Before using Reflection, we need to get the `Class` object of a class.

Ways to Get `Class` Object  
java

CopyEdit

`class Example { }`

`public class Main {`

    `public static void main(String[] args) throws ClassNotFoundException {`

        `// 1. Using Class.forName()`

        `Class<?> c1 = Class.forName("Example");`

        

        `// 2. Using .class`

        `Class<?> c2 = Example.class;`

        `// 3. Using getClass() method on an object`

        `Example obj = new Example();`

        `Class<?> c3 = obj.getClass();`

        `System.out.println(c1 == c2); // true`

        `System.out.println(c2 == c3); // true`

    `}`

`}`

✔ **All three approaches return the same `Class` object.**

---

3\. Getting All Methods of a Class

We can use `getDeclaredMethods()` or `getMethods()` to retrieve methods of a class.

Example: Get All Methods of a Class  
java

CopyEdit

`import java.lang.reflect.Method;`

`class Example {`

    `public void method1() {}`

    `private void method2() {}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Class<?> clazz = Example.class;`

        `Method[] methods = clazz.getDeclaredMethods(); // Gets all methods (public + private)`

        `System.out.println("Methods in Example class:");`

        `for (Method method : methods) {`

            `System.out.println(method.getName());`

        `}`

    `}`

`}`

✔ `getDeclaredMethods()` gets **all methods** (including private ones).  
 ✔ `getMethods()` gets **only public methods**, including inherited ones.

---

4\. Getting All Fields of a Class

We can inspect all fields (variables) of a class using `getDeclaredFields()`.

Example: Get All Fields  
java

CopyEdit

`import java.lang.reflect.Field;`

`class Example {`

    `public int publicField;`

    `private String privateField;`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Class<?> clazz = Example.class;`

        `Field[] fields = clazz.getDeclaredFields();`

        `System.out.println("Fields in Example class:");`

        `for (Field field : fields) {`

            `System.out.println(field.getName());`

        `}`

    `}`

`}`

✔ `getDeclaredFields()` returns **all fields**, including private ones.  
 ✔ `getFields()` returns **only public fields**.

---

5\. Getting Return Type of a Method

The return type of a method can be determined using `getReturnType()`.

Example: Get Return Type  
java

CopyEdit

`import java.lang.reflect.Method;`

`class Example {`

    `public String getMessage() { return "Hello"; }`

`}`

`public class Main {`

    `public static void main(String[] args) throws Exception {`

        `Class<?> clazz = Example.class;`

        `Method method = clazz.getDeclaredMethod("getMessage");`

        

        `System.out.println("Return Type: " + method.getReturnType().getName());`

    `}`

`}`

✔ The `getReturnType()` method returns the **return type** of the method.

---

6\. Getting Modifiers of a Class

The **modifiers** (public, private, abstract, final, etc.) of a class can be determined using `getModifiers()`.

Example: Get Class Modifiers  
java

CopyEdit

`import java.lang.reflect.Modifier;`

`abstract class Example { }`

`public class Main {`

    `public static void main(String[] args) {`

        `Class<?> clazz = Example.class;`

        `int modifiers = clazz.getModifiers();`

        `System.out.println("Is Abstract? " + Modifier.isAbstract(modifiers));`

        `System.out.println("Is Public? " + Modifier.isPublic(modifiers));`

    `}`

`}`

✔ `Modifier.isAbstract(modifiers)` checks if the class is **abstract**.  
 ✔ `Modifier.isPublic(modifiers)` checks if the class is **public**.

---

7\. Getting Implemented Interfaces

We can get the list of interfaces implemented by a class using `getInterfaces()`.

Example: Get Implemented Interfaces  
java

CopyEdit

`interface A { }`

`interface B { }`

`class Example implements A, B { }`

`public class Main {`

    `public static void main(String[] args) {`

        `Class<?> clazz = Example.class;`

        `Class<?>[] interfaces = clazz.getInterfaces();`

        `System.out.println("Implemented Interfaces:");`

        `for (Class<?> i : interfaces) {`

            `System.out.println(i.getName());`

        `}`

    `}`

`}`

✔ `getInterfaces()` returns an array of **interfaces implemented by the class**.

---

8\. Changing Private and Public Field Values

We can **modify public and private fields** using `setAccessible(true)`.

Example: Changing Field Value  
java

CopyEdit

`import java.lang.reflect.Field;`

`class Example {`

    `private String secret = "Initial Value";`

`}`

`public class Main {`

    `public static void main(String[] args) throws Exception {`

        `Example obj = new Example();`

        `Class<?> clazz = obj.getClass();`

        

        `Field field = clazz.getDeclaredField("secret");`

        `field.setAccessible(true);  // Allow access to private field`

        `System.out.println("Before: " + field.get(obj));`

        `field.set(obj, "New Value"); // Changing value`

        `System.out.println("After: " + field.get(obj));`

    `}`

`}`

✔ **`setAccessible(true)` allows access to private fields.**  
 ✔ This technique is commonly used in **unit testing** and **serialization frameworks**.

---

9\. Calling Private Methods Using Reflection

We can invoke private methods using `setAccessible(true)`.

Example: Invoke a Private Method  
java

CopyEdit

`import java.lang.reflect.Method;`

`class Example {`

    `private void displaySecret() {`

        `System.out.println("Private Method Invoked!");`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) throws Exception {`

        `Example obj = new Example();`

        `Class<?> clazz = obj.getClass();`

        

        `Method method = clazz.getDeclaredMethod("displaySecret");`

        `method.setAccessible(true); // Allow access to private method`

        `method.invoke(obj); // Call method`

    `}`

`}`

✔ This allows **private methods to be accessed dynamically**.

---

10\. Summary

| Feature | Reflection Method |
| ----- | ----- |
| Get class object | `Class.forName("ClassName")`, `.class`, `obj.getClass()` |
| Get methods | `getDeclaredMethods()`, `getMethods()` |
| Get fields | `getDeclaredFields()`, `getFields()` |
| Get return type of method | `method.getReturnType()` |
| Get class modifiers | `Modifier.isPublic(modifiers)`, `Modifier.isAbstract(modifiers)` |
| Get interfaces | `getInterfaces()` |
| Change field value | `field.setAccessible(true)`, `field.set(obj, value)` |
| Call private method | `method.setAccessible(true)`, `method.invoke(obj)` |

---

11\. When to Use Reflection (And When Not To)

✔ **When to Use:**  
 ✅ **Frameworks** (Spring, Hibernate)  
 ✅ **Unit Testing** (Mocking private fields)  
 ✅ **Serialization/Deserialization**

❌ **When to Avoid:**  
 🚫 Performance overhead (Reflection is **slower** than direct method calls)  
 🚫 Breaks encapsulation (Accessing **private fields/methods**)  
 🚫 Security risks (Bypassing access control)

---

# Java Annotations \- Complete Guide with Examples

1\. What are Java Annotations?

Annotations in Java provide **metadata** about the code but **do not change its behavior**. They are used by compilers, frameworks, and runtime environments to perform different operations.

Why Use Annotations?

✔ Reduce boilerplate code  
 ✔ Provide additional information to the compiler  
 ✔ Enable **dependency injection, serialization, testing**, and more  
 ✔ Used in **frameworks like Spring, Hibernate, JUnit**

---

2\. Built-in Java Annotations

Java provides several built-in annotations categorized into three types:

A. Compiler Annotations (Checked at Compile Time)

| Annotation | Description |
| ----- | ----- |
| `@Override` | Ensures that a method overrides a superclass method |
| `@Deprecated` | Marks a method or class as outdated |
| `@SuppressWarnings` | Suppresses compiler warnings |

Example of `@Override`

java

CopyEdit

`class Parent {`

    `void show() {`

        `System.out.println("Parent class method");`

    `}`

`}`

`class Child extends Parent {`

    `@Override`

    `void show() {`

        `System.out.println("Overridden method in Child");`

    `}`

`}`

✔ Ensures that `show()` correctly **overrides** the parent class method.

---

Example of `@Deprecated`

java

CopyEdit

`class Example {`

    `@Deprecated`

    `void oldMethod() {`

        `System.out.println("This method is deprecated.");`

    `}`

`}`

`public class Main {`

    `public static void main(String[] args) {`

        `Example obj = new Example();`

        `obj.oldMethod();  // Compiler will warn about usage`

    `}`

`}`

✔ Marks `oldMethod()` as **deprecated**.  
 ✔ The compiler warns against its usage.

---

Example of `@SuppressWarnings`

java

CopyEdit

`public class Main {`

    `@SuppressWarnings("unchecked")`

    `public static void main(String[] args) {`

        `java.util.List rawList = new java.util.ArrayList(); // Warning suppressed`

        `rawList.add("Hello");`

    `}`

`}`

✔ Suppresses **unchecked type warnings**.

---

B. Runtime Annotations (Available at Runtime)

| Annotation | Description |
| ----- | ----- |
| `@Retention` | Specifies how long the annotation is retained |
| `@Target` | Specifies where the annotation can be applied |
| `@Inherited` | Allows an annotation to be inherited by subclasses |
| `@Documented` | Includes annotation in the JavaDoc |

---

3\. Creating Custom Annotations

We can define our own annotations using the `@interface` keyword.

Example: Custom Annotation  
java

CopyEdit

`import java.lang.annotation.*;`

`@Retention(RetentionPolicy.RUNTIME) // Available at runtime`

`@Target(ElementType.METHOD) // Used on methods only`

`@interface MyAnnotation {`

    `String value();`

    `int count() default 1;`

`}`

`class Example {`

    `@MyAnnotation(value = "Hello", count = 3)`

    `public void testMethod() {`

        `System.out.println("Executing testMethod...");`

    `}`

`}`

✔ `@Retention(RetentionPolicy.RUNTIME)`: Keeps annotation available at **runtime**.  
 ✔ `@Target(ElementType.METHOD)`: Can be applied **only on methods**.

---

4\. Retrieving Annotations Using Reflection

We can **access annotation values at runtime** using Reflection.

Example: Reading Custom Annotation at Runtime  
java

CopyEdit

`import java.lang.reflect.Method;`

`public class Main {`

    `public static void main(String[] args) throws Exception {`

        `Class<?> clazz = Example.class;`

        `Method method = clazz.getMethod("testMethod");`

        `// Check if annotation is present`

        `if (method.isAnnotationPresent(MyAnnotation.class)) {`

            `MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);`

            `System.out.println("Value: " + annotation.value());`

            `System.out.println("Count: " + annotation.count());`

        `}`

    `}`

`}`

✔ **Reflection** allows accessing annotation values dynamically.

---

5\. Meta-Annotations in Java

Meta-annotations are **annotations that define other annotations**.

| Meta-Annotation | Description |
| ----- | ----- |
| `@Retention` | Specifies how long an annotation is retained |
| `@Target` | Specifies where an annotation can be applied |
| `@Inherited` | Allows a subclass to inherit an annotation |
| `@Documented` | Includes annotation in JavaDocs |

Example: Using Meta-Annotations  
java

CopyEdit

`import java.lang.annotation.*;`

`@Retention(RetentionPolicy.RUNTIME) // Available at runtime`

`@Target({ElementType.METHOD, ElementType.TYPE}) // Can be applied to classes and methods`

`@interface MyMetaAnnotation { }`

✔ `@Target(ElementType.TYPE)`: Can be used on **classes**.  
 ✔ `@Target(ElementType.METHOD)`: Can be used on **methods**.

---

6\. Built-in Java 8+ Annotations

Java 8 introduced **repeatable annotations** and **type annotations**.

A. `@Repeatable` Annotation (Multiple Instances of Same Annotation)  
java

CopyEdit

`import java.lang.annotation.*;`

`@Retention(RetentionPolicy.RUNTIME)`

`@Target(ElementType.METHOD)`

`@Repeatable(MyAnnotations.class) // Allows multiple annotations`

`@interface MyAnnotation {`

    `String value();`

`}`

`// Container annotation`

`@Retention(RetentionPolicy.RUNTIME)`

`@Target(ElementType.METHOD)`

`@interface MyAnnotations {`

    `MyAnnotation[] value();`

`}`

`class Example {`

    `@MyAnnotation("First")`

    `@MyAnnotation("Second")`

    `public void testMethod() {`

    `}`

`}`

✔ `@Repeatable(MyAnnotations.class)`: Allows multiple instances of `@MyAnnotation`.

---

B. Java 8 Type Annotations (`@Target(ElementType.TYPE_USE)`)  
java

CopyEdit

`import java.lang.annotation.*;`

`@Retention(RetentionPolicy.RUNTIME)`

`@Target(ElementType.TYPE_USE)`

`@interface NonNull { }`

`class Example {`

    `public void display(@NonNull String message) {`

        `System.out.println(message);`

    `}`

`}`

✔ **`ElementType.TYPE_USE`** allows annotations to be used **on variables, return types, and parameters**.

---

7\. Real-World Applications of Annotations

A. Annotations in JUnit

JUnit uses annotations for testing.

java

CopyEdit

`import org.junit.jupiter.api.*;`

`public class TestExample {`

    `@BeforeEach`

    `void setup() {`

        `System.out.println("Setup before each test");`

    `}`

    `@Test`

    `void testMethod() {`

        `System.out.println("Running test");`

    `}`

`}`

✔ `@BeforeEach` runs **before every test method**.  
 ✔ `@Test` marks a method as a **test case**.

---

B. Annotations in Spring (Dependency Injection)

Spring uses annotations like `@Autowired` to **inject dependencies**.

java

CopyEdit

`import org.springframework.beans.factory.annotation.Autowired;`

`import org.springframework.stereotype.Component;`

`@Component`

`class Car {`

    `void drive() { System.out.println("Driving a car..."); }`

`}`

`@Component`

`class Person {`

    `@Autowired`

    `private Car car;`

    `void startJourney() { car.drive(); }`

`}`

✔ **`@Autowired`** injects `Car` into `Person`.  
 ✔ **`@Component`** marks classes as Spring components.

---

8\. Summary

| Feature | Description |
| ----- | ----- |
| **Built-in Annotations** | `@Override`, `@Deprecated`, `@SuppressWarnings` |
| **Runtime Annotations** | `@Retention`, `@Target`, `@Inherited`, `@Documented` |
| **Custom Annotations** | `@interface MyAnnotation {}` |
| **Accessing Annotations** | `method.getAnnotation(MyAnnotation.class)` |
| **Java 8+ Features** | `@Repeatable`, `@Target(ElementType.TYPE_USE)` |
| **Used In** | **JUnit, Spring, Hibernate, Logging, ORM frameworks** |

---

# Exception Handling in Java \- Complete Guide with Examples

1\. What is Exception Handling in Java?

Exception handling in Java is a mechanism that allows us to **handle runtime errors** to ensure the normal flow of execution.

Why Exception Handling?

✔ Prevents program crashes due to unexpected errors  
 ✔ Helps debug and maintain code easily  
 ✔ Provides a mechanism to **gracefully handle runtime issues**

---

2\. Types of Exceptions in Java

Java exceptions are categorized into two main types:

A. Checked Exceptions (Compile-time exceptions)

* These exceptions are **checked at compile time**.  
* The compiler forces us to handle them using `try-catch` or `throws`.  
* Examples:  
  * `IOException`  
  * `SQLException`  
  * `FileNotFoundException`

Example: Checked Exception (Handling `IOException`)

java

CopyEdit

`import java.io.*;`

`public class CheckedExceptionExample {`

    `public static void main(String[] args) {`

        `try {`

            `FileReader file = new FileReader("nonexistent.txt"); // File not found`

            `BufferedReader br = new BufferedReader(file);`

            `System.out.println(br.readLine());`

        `} catch (IOException e) {`

            `System.out.println("File not found: " + e.getMessage());`

        `}`

    `}`

`}`

✔ **Without handling, this would cause a compile-time error.**

---

B. Unchecked Exceptions (Runtime Exceptions)

* These exceptions occur at **runtime** and **are not checked** at compile time.  
* They usually occur due to **logical errors in the program**.  
* Examples:  
  * `NullPointerException`  
  * `ArrayIndexOutOfBoundsException`  
  * `ArithmeticException`

Example: Unchecked Exception (`ArithmeticException`)

java

CopyEdit

`public class UncheckedExceptionExample {`

    `public static void main(String[] args) {`

        `int a = 10, b = 0;`

        `int result = a / b; // Causes ArithmeticException (division by zero)`

        `System.out.println(result);`

    `}`

`}`

✔ **No compile-time error, but crashes at runtime.**

---

C. Errors (Serious Issues)

* Errors are **not exceptions**, but serious problems beyond program control.  
* Examples:  
  * `StackOverflowError` (infinite recursion)  
  * `OutOfMemoryError` (insufficient memory)

Example: `StackOverflowError`

java

CopyEdit

`public class StackOverflowExample {`

    `public static void recursiveMethod() {`

        `recursiveMethod(); // Infinite recursion`

    `}`

    `public static void main(String[] args) {`

        `recursiveMethod();`

    `}`

`}`

✔ **Program crashes due to infinite recursion.**

---

3\. Java Exception Hierarchy

php

CopyEdit

`Throwable`

`│`

`├── Exception (Checked Exceptions)`

`│   ├── IOException`

`│   ├── SQLException`

`│   ├── ClassNotFoundException`

`│`

`├── RuntimeException (Unchecked Exceptions)`

`│   ├── NullPointerException`

`│   ├── ArithmeticException`

`│   ├── IndexOutOfBoundsException`

`│`

`└── Error (Serious Issues)`

    `├── StackOverflowError`

    `├── OutOfMemoryError`

---

4\. Exception Handling Mechanisms

Java provides several ways to handle exceptions:

A. Using try-catch Block  
java

CopyEdit

`public class TryCatchExample {`

    `public static void main(String[] args) {`

        `try {`

            `int num = 10 / 0; // Causes ArithmeticException`

        `} catch (ArithmeticException e) {`

            `System.out.println("Exception caught: " + e.getMessage());`

        `}`

        `System.out.println("Program continues...");`

    `}`

`}`

✔ **Catches the exception and prevents the program from crashing.**

---

B. Using Multiple Catch Blocks  
java

CopyEdit

`public class MultipleCatchExample {`

    `public static void main(String[] args) {`

        `try {`

            `int[] arr = {1, 2, 3};`

            `System.out.println(arr[5]); // IndexOutOfBoundsException`

        `} catch (ArithmeticException e) {`

            `System.out.println("ArithmeticException caught.");`

        `} catch (ArrayIndexOutOfBoundsException e) {`

            `System.out.println("ArrayIndexOutOfBoundsException caught.");`

        `}`

        `System.out.println("Program continues...");`

    `}`

`}`

✔ **Different catch blocks handle different exception types.**

---

C. Using finally Block (Always Executes)  
java

CopyEdit

`public class FinallyExample {`

    `public static void main(String[] args) {`

        `try {`

            `System.out.println("Inside try block");`

        `} catch (Exception e) {`

            `System.out.println("Exception caught");`

        `} finally {`

            `System.out.println("Finally block always executes.");`

        `}`

    `}`

`}`

✔ **`finally` executes whether an exception occurs or not.**

---

D. Using throw Keyword (Manually Throw Exception)  
java

CopyEdit

`public class ThrowExample {`

    `public static void checkAge(int age) {`

        `if (age < 18) {`

            `throw new IllegalArgumentException("Age must be 18 or above.");`

        `}`

        `System.out.println("Valid age.");`

    `}`

    `public static void main(String[] args) {`

        `checkAge(16); // Throws exception`

    `}`

`}`

✔ **Throws an exception manually when age is invalid.**

---

E. Using throws Keyword (Method-Level Exception Handling)  
java

CopyEdit

`import java.io.*;`

`public class ThrowsExample {`

    `public static void readFile() throws IOException {`

        `FileReader file = new FileReader("nonexistent.txt"); // May throw IOException`

    `}`

    `public static void main(String[] args) {`

        `try {`

            `readFile();`

        `} catch (IOException e) {`

            `System.out.println("Handled IOException: " + e.getMessage());`

        `}`

    `}`

`}`

✔ **Delegates exception handling to the caller method.**

---

5\. Custom Exceptions

We can create our own exceptions by extending the `Exception` class.

Example: Creating a Custom Exception  
java

CopyEdit

`class InvalidAgeException extends Exception {`

    `public InvalidAgeException(String message) {`

        `super(message);`

    `}`

`}`

`public class CustomExceptionExample {`

    `public static void validateAge(int age) throws InvalidAgeException {`

        `if (age < 18) {`

            `throw new InvalidAgeException("Age must be 18 or above.");`

        `}`

    `}`

    `public static void main(String[] args) {`

        `try {`

            `validateAge(16);`

        `} catch (InvalidAgeException e) {`

            `System.out.println("Caught Custom Exception: " + e.getMessage());`

        `}`

    `}`

`}`

✔ **Custom exception provides meaningful error messages.**

---

6\. Best Practices for Exception Handling

✅ Catch **specific exceptions** instead of `Exception`.  
 ✅ Always use `finally` to **release resources** like database connections.  
 ✅ Avoid **empty catch blocks** (hides errors).  
 ✅ Use **custom exceptions** for better error clarity.  
 ✅ Do not use exceptions for **flow control** (e.g., `try-catch` for loops).

---

7\. Summary

| Feature | Description |
| ----- | ----- |
| **Checked Exceptions** | Compile-time errors (e.g., `IOException`, `SQLException`) |
| **Unchecked Exceptions** | Runtime errors (e.g., `NullPointerException`, `ArithmeticException`) |
| **Errors** | System-level issues (`StackOverflowError`, `OutOfMemoryError`) |
| **Handling Exceptions** | `try-catch`, `finally`, `throw`, `throws` |
| **Custom Exceptions** | Extending `Exception` class |
| **Best Practices** | Catch specific exceptions, use finally, avoid empty catch blocks |

---

# Operators in Java \- Complete Guide with Examples

1\. What are Operators in Java?

Operators in Java are **special symbols** used to perform operations on variables and values.

Why Use Operators?

✔ Perform arithmetic operations  
 ✔ Compare values  
 ✔ Assign values  
 ✔ Manipulate bits  
 ✔ Control program flow

---

2\. Types of Operators in Java

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

3\. Arithmetic Operators (Perform Mathematical Operations)

| Operator | Meaning | Example |
| ----- | ----- | ----- |
| `+` | Addition | `a + b` |
| `-` | Subtraction | `a - b` |
| `*` | Multiplication | `a * b` |
| `/` | Division | `a / b` |
| `%` | Modulus (Remainder) | `a % b` |

Example: Arithmetic Operators  
java

CopyEdit

`public class ArithmeticExample {`

    `public static void main(String[] args) {`

        `int a = 10, b = 3;`

        `System.out.println("Addition: " + (a + b)); // 13`

        `System.out.println("Subtraction: " + (a - b)); // 7`

        `System.out.println("Multiplication: " + (a * b)); // 30`

        `System.out.println("Division: " + (a / b)); // 3`

        `System.out.println("Modulus: " + (a % b)); // 1`

    `}`

`}`

---

4\. Relational (Comparison) Operators

Used to compare two values, returning `true` or `false`.

| Operator | Meaning | Example (`a=10`, `b=20`) | Result |
| ----- | ----- | ----- | ----- |
| `==` | Equal to | `a == b` | `false` |
| `!=` | Not equal to | `a != b` | `true` |
| `>` | Greater than | `a > b` | `false` |
| `<` | Less than | `a < b` | `true` |
| `>=` | Greater than or equal to | `a >= b` | `false` |
| `<=` | Less than or equal to | `a <= b` | `true` |

Example: Relational Operators  
java

CopyEdit

`public class RelationalExample {`

    `public static void main(String[] args) {`

        `int a = 10, b = 20;`

        `System.out.println("a == b: " + (a == b)); // false`

        `System.out.println("a != b: " + (a != b)); // true`

        `System.out.println("a > b: " + (a > b)); // false`

        `System.out.println("a < b: " + (a < b)); // true`

    `}`

`}`

---

5\. Logical Operators

Used for logical operations, returning `true` or `false`.

| Operator | Meaning | Example (`a=true`, `b=false`) | Result |
| ----- | ----- | ----- | ----- |
| `&&` | AND | `a && b` | `false` |
| \` |  | \` | OR |
| `!` | NOT | `!a` | `false` |

Example: Logical Operators  
java

CopyEdit

`public class LogicalExample {`

    `public static void main(String[] args) {`

        `boolean a = true, b = false;`

        `System.out.println("a && b: " + (a && b)); // false`

        `System.out.println("a || b: " + (a || b)); // true`

        `System.out.println("!a: " + (!a)); // false`

    `}`

`}`

---

6\. Bitwise Operators (Work on Bits)

Used for bit-level manipulations.

| Operator | Meaning | Example |
| ----- | ----- | ----- |
| `&` | Bitwise AND | `a & b` |
| \` | \` | Bitwise OR |
| `^` | Bitwise XOR | `a ^ b` |
| `~` | Bitwise Complement | `~a` |
| `<<` | Left Shift | `a << 2` |
| `>>` | Right Shift | `a >> 2` |
| `>>>` | Zero-fill Right Shift | `a >>> 2` |

---

7\. Assignment Operators

Used to assign values to variables.

| Operator | Example | Equivalent to |
| ----- | ----- | ----- |
| `=` | `a = b` | `a = b` |
| `+=` | `a += b` | `a = a + b` |
| `-=` | `a -= b` | `a = a - b` |
| `*=` | `a *= b` | `a = a * b` |
| `/=` | `a /= b` | `a = a / b` |

Example: Assignment Operators  
java

CopyEdit

`public class AssignmentExample {`

    `public static void main(String[] args) {`

        `int a = 10;`

        `a += 5; // a = a + 5`

        `System.out.println("a: " + a); // 15`

    `}`

`}`

---

8\. Unary Operators

| Operator | Meaning | Example |
| ----- | ----- | ----- |
| `+` | Positive | `+a` |
| `-` | Negative | `-a` |
| `++` | Increment | `a++` or `++a` |
| `--` | Decrement | `a--` or `--a` |

---

9\. Ternary Operator (`condition ? trueValue : falseValue`)

java

CopyEdit

`public class TernaryExample {`

    `public static void main(String[] args) {`

        `int a = 10, b = 20;`

        `int min = (a < b) ? a : b;`

        `System.out.println("Minimum: " + min);`

    `}`

`}`

---

10\. instanceof Operator

Checks if an object is an instance of a class.

java

CopyEdit

`class Animal { }`

`class Dog extends Animal { }`

`public class InstanceofExample {`

    `public static void main(String[] args) {`

        `Dog d = new Dog();`

        `System.out.println(d instanceof Animal); // true`

    `}`

`}`

---

11\. Type Cast Operator

Used to convert data types.

java

CopyEdit

`public class TypeCastingExample {`

    `public static void main(String[] args) {`

        `int num = 100;`

        `double d = (double) num; // Explicit Casting`

        `System.out.println(d);`

    `}`

`}`

---

Operator Precedence Table in Java

Operators are listed from **highest to lowest** precedence.

| Precedence | Operator | Description | Associativity |
| ----- | ----- | ----- | ----- |
| **1** (Highest) | `()`, `[]`, `.` | Parentheses, Array access, Member selection | **Left to Right** |
| **2** | `++`, `--`, `~`, `!`, `(type)` | Unary operators | **Right to Left** |
| **3** | `*`, `/`, `%` | Multiplication, Division, Modulus | **Left to Right** |
| **4** | `+`, `-` | Addition, Subtraction | **Left to Right** |
| **5** | `<<`, `>>`, `>>>` | Bitwise shift operators | **Left to Right** |
| **6** | `<`, `<=`, `>`, `>=`, `instanceof` | Relational operators | **Left to Right** |
| **7** | `==`, `!=` | Equality operators | **Left to Right** |
| **8** | `&` | Bitwise AND | **Left to Right** |
| **9** | `^` | Bitwise XOR | **Left to Right** |
| **10** | `|` | Bitwise OR | **Left to Right** |
| **11** | `&&` | Logical AND | **Left to Right** |
| **12** | `||` | Logical OR | **Left to Right** |
| **13** | `?:` | Ternary Operator | **Right to Left** |
| **14** | `=`, `+=`, `-=`, `*=`, `/=`, `%=`, `<<=`, `>>=`, `>>>=`, `&=`, `^=`, `|=` | Assignment operators | **Right to Left** |
| **15** (Lowest) | `,` | Comma operator (used in loops) | **Left to Right** |

---

# Control Flow Statements in Java

Control flow statements **determine the execution order** of instructions in a Java program. Java provides:

✔ **Decision-Making Statements** (if-else, switch)  
 ✔ **Looping Statements** (for, while, do-while)  
 ✔ **Branching Statements** (break, continue, return)

---

1\. Decision-Making Statements

Decision-making statements allow the program to **execute different blocks of code** based on conditions.

1.1 if-else Statement

Used to execute a block of code **only if a condition is true**.

Syntax:

java

CopyEdit

`if (condition) {`

    `// Code executes if condition is true`

`} else {`

    `// Code executes if condition is false`

`}`

Example:

java

CopyEdit

`public class IfElseExample {`

    `public static void main(String[] args) {`

        `int number = 10;`

        `if (number > 0) {`

            `System.out.println("Positive Number");`

        `} else {`

            `System.out.println("Negative Number");`

        `}`

    `}`

`}`

✅ **Output:** `Positive Number`

---

1.2 if-else-if Ladder

Used when there are **multiple conditions**.

Syntax:

java

CopyEdit

`if (condition1) {`

    `// Code block 1`

`} else if (condition2) {`

    `// Code block 2`

`} else {`

    `// Default block`

`}`

Example:

java

CopyEdit

`public class IfElseIfExample {`

    `public static void main(String[] args) {`

        `int marks = 85;`

        `if (marks >= 90) {`

            `System.out.println("Grade A");`

        `} else if (marks >= 75) {`

            `System.out.println("Grade B");`

        `} else {`

            `System.out.println("Grade C");`

        `}`

    `}`

`}`

✅ **Output:** `Grade B`

---

1.3 Switch Statement

Used when we have **multiple possible values** for a variable.

Syntax:

java

CopyEdit

`switch (expression) {`

    `case value1:`

        `// Code block 1`

        `break;`

    `case value2:`

        `// Code block 2`

        `break;`

    `default:`

        `// Default block`

`}`

Example:

java

CopyEdit

`public class SwitchExample {`

    `public static void main(String[] args) {`

        `int day = 3;`

        `switch (day) {`

            `case 1: System.out.println("Monday"); break;`

            `case 2: System.out.println("Tuesday"); break;`

            `case 3: System.out.println("Wednesday"); break;`

            `default: System.out.println("Invalid Day");`

        `}`

    `}`

`}`

✅ **Output:** `Wednesday`

**🚀 Java 14+: Switch with Multiple Cases & Arrow Syntax**

java

CopyEdit

`public class SwitchNewSyntax {`

    `public static void main(String[] args) {`

        `int day = 3;`

        `String result = switch (day) {`

            `case 1, 2, 3 -> "Weekday";`

            `case 4, 5 -> "Weekend";`

            `default -> "Invalid";`

        `};`

        `System.out.println(result);`

    `}`

`}`

✅ **Output:** `Weekday`

---

2\. Looping Statements

Loops **repeat** a block of code **multiple times** until a condition is false.

| Loop | When to Use |
| ----- | ----- |
| **for** | When the number of iterations is known |
| **while** | When the number of iterations is unknown |
| **do-while** | Ensures the loop executes **at least once** |

---

2.1 for Loop

Executes code **a fixed number of times**.

Syntax:

java

CopyEdit

`for (initialization; condition; increment/decrement) {`

    `// Code block`

`}`

Example:

java

CopyEdit

`public class ForLoopExample {`

    `public static void main(String[] args) {`

        `for (int i = 1; i <= 5; i++) {`

            `System.out.println("Iteration: " + i);`

        `}`

    `}`

`}`

✅ **Output:**

makefile

CopyEdit

`Iteration: 1`  

`Iteration: 2`  

`Iteration: 3`  

`Iteration: 4`  

`Iteration: 5`


**🚀 Enhanced for Loop (for-each)** Used to iterate over arrays and collections.

java

CopyEdit

`public class ForEachExample {`

    `public static void main(String[] args) {`

        `int[] numbers = {1, 2, 3, 4, 5};`

        `for (int num : numbers) {`

            `System.out.println(num);`

        `}`

    `}`

`}`

---

2.2 while Loop

Executes code **as long as a condition is true**.

Syntax:

java

CopyEdit

`while (condition) {`

    `// Code block`

`}`

Example:

java

CopyEdit

`public class WhileLoopExample {`

    `public static void main(String[] args) {`

        `int i = 1;`

        `while (i <= 5) {`

            `System.out.println("Count: " + i);`

            `i++;`

        `}`

    `}`

`}`

✅ **Output:** `Count: 1, Count: 2, Count: 3, Count: 4, Count: 5`

---

2.3 do-while Loop

Executes code **at least once**, then continues based on condition.

Syntax:

java

CopyEdit

`do {`

    `// Code block`

`} while (condition);`

Example:

java

CopyEdit

`public class DoWhileExample {`

    `public static void main(String[] args) {`

        `int i = 1;`

        `do {`

            `System.out.println("Number: " + i);`

            `i++;`

        `} while (i <= 5);`

    `}`

`}`

✅ **Output:** `Number: 1, Number: 2, Number: 3, Number: 4, Number: 5`

---

3\. Branching Statements

Branching statements **change the normal execution flow**.

| Statement | Description |
| ----- | ----- |
| **break** | Exits a loop/switch immediately |
| **continue** | Skips the current iteration and moves to the next |
| **return** | Exits from the method |

---

3.1 break Statement

Used to **exit a loop or switch** immediately.

Example:

java

CopyEdit

`public class BreakExample {`

    `public static void main(String[] args) {`

        `for (int i = 1; i <= 5; i++) {`

            `if (i == 3) {`

                `break;  // Loop stops at i = 3`

            `}`

            `System.out.println(i);`

        `}`

    `}`

`}`

✅ **Output:** `1, 2`

---

3.2 continue Statement

Used to **skip** the current iteration and continue with the next.

Example:

java

CopyEdit

`public class ContinueExample {`

    `public static void main(String[] args) {`

        `for (int i = 1; i <= 5; i++) {`

            `if (i == 3) {`

                `continue;  // Skip i = 3`

            `}`

            `System.out.println(i);`

        `}`

    `}`

`}`

✅ **Output:** `1, 2, 4, 5`

---

3.3 return Statement

Used to **exit a method** and return a value.

Example:

java

CopyEdit

`public class ReturnExample {`

    `public static void main(String[] args) {`

        `System.out.println(sum(5, 10));`

    `}`

    `static int sum(int a, int b) {`

        `return a + b;  // Return sum`

    `}`

`}`

✅ **Output:** `15`

---

# Collections

## Part 1 | Java Collections Framework in Depth

1\. What is Java Collections Framework (JCF)?

The **Java Collections Framework (JCF)** is a set of **classes and interfaces** in Java that **store, manipulate, and manage collections of objects efficiently**.

✔ Provides **predefined data structures** (List, Set, Map, Queue).  
 ✔ Improves **code reusability** and **performance**.  
 ✔ Supports **generics, iteration, and sorting**.

---

2\. Core Interfaces of Java Collections Framework

| Interface | Description | Key Implementations |
| ----- | ----- | ----- |
| **Collection** | Root interface for all collections | \- |
| **List** | Ordered collection (allows duplicates) | `ArrayList`, `LinkedList`, `Vector` |
| **Set** | Unordered collection (no duplicates) | `HashSet`, `LinkedHashSet`, `TreeSet` |
| **Queue** | FIFO (First-In-First-Out) structure | `PriorityQueue`, `ArrayDeque` |
| **Map** | Key-Value pairs (no duplicate keys) | `HashMap`, `LinkedHashMap`, `TreeMap` |

✅ **All collections except Map inherit from `Collection` interface**

---

3\. Collection vs Collections

| Feature | `Collection` | `Collections` |
| ----- | ----- | ----- |
| **Type** | Interface | Utility Class |
| **Purpose** | Parent of List, Set, and Queue | Provides static helper methods |
| **Example** | `List<String> list = new ArrayList<>();` | `Collections.sort(list);` |

---

4\. List Interface (Ordered Collection with Duplicates Allowed)

4.1 `ArrayList` (Fast Read, Slow Write)

✔ **Dynamic array-based** implementation.  
 ✔ Fast **random access** (O(1) time complexity).  
 ✔ Slow **insertion & deletion** (O(n) in worst case).

Example:

java

CopyEdit

`import java.util.*;`

`public class ArrayListExample {`

    `public static void main(String[] args) {`

        `List<String> list = new ArrayList<>();`

        `list.add("Apple");`

        `list.add("Banana");`

        `list.add("Mango");`

        `System.out.println(list); // Output: [Apple, Banana, Mango]`

    `}`

`}`

---

4.2 `LinkedList` (Fast Insert/Delete, Slow Read)

✔ Doubly linked list implementation.  
 ✔ Fast **insertion & deletion** (O(1)).  
 ✔ Slow **random access** (O(n)).

Example:

java

CopyEdit

`import java.util.*;`

`public class LinkedListExample {`

    `public static void main(String[] args) {`

        `List<Integer> list = new LinkedList<>();`

        `list.add(10);`

        `list.add(20);`

        `list.add(30);`

        `System.out.println(list); // Output: [10, 20, 30]`

    `}`

`}`

---

4.3 `Vector` (Thread-Safe, Slower than ArrayList)

✔ **Synchronized version** of `ArrayList`.  
 ✔ Slower performance due to **thread safety**.

Example:

java

CopyEdit

`import java.util.*;`

`public class VectorExample {`

    `public static void main(String[] args) {`

        `Vector<String> vector = new Vector<>();`

        `vector.add("Car");`

        `vector.add("Bike");`

        `System.out.println(vector); // Output: [Car, Bike]`

    `}`

`}`

---

5\. Set Interface (No Duplicate Elements, Unordered by Default)

5.1 `HashSet` (Fastest, Unordered)

✔ Uses **HashMap internally**.  
 ✔ No duplicates, **order not maintained**.  
 ✔ O(1) **insert, delete, search** time complexity.

Example:

java

CopyEdit

`import java.util.*;`

`public class HashSetExample {`

    `public static void main(String[] args) {`

        `Set<String> set = new HashSet<>();`

        `set.add("Apple");`

        `set.add("Banana");`

        `set.add("Apple"); // Duplicate ignored`

        `System.out.println(set); // Output: [Banana, Apple] (Order not guaranteed)`

    `}`

`}`

---

5.2 `LinkedHashSet` (Insertion Order Preserved)

✔ **Maintains insertion order**.  
 ✔ Uses **LinkedHashMap internally**.

Example:

java

CopyEdit

`import java.util.*;`

`public class LinkedHashSetExample {`

    `public static void main(String[] args) {`

        `Set<String> set = new LinkedHashSet<>();`

        `set.add("Cat");`

        `set.add("Dog");`

        `set.add("Elephant");`

        `System.out.println(set); // Output: [Cat, Dog, Elephant]`

    `}`

`}`

---

5.3 `TreeSet` (Sorted Order, Uses Red-Black Tree)

✔ **Maintains ascending order**.  
 ✔ O(log n) time complexity for operations.

Example:

java

CopyEdit

`import java.util.*;`

`public class TreeSetExample {`

    `public static void main(String[] args) {`

        `Set<Integer> set = new TreeSet<>();`

        `set.add(30);`

        `set.add(10);`

        `set.add(20);`

        `System.out.println(set); // Output: [10, 20, 30]`

    `}`

`}`

---

6\. Map Interface (Key-Value Pair Storage, No Duplicate Keys)

6.1 `HashMap` (Fastest, No Order)

✔ Uses **hashing** for fast lookup.  
 ✔ O(1) time complexity (in ideal cases).

Example:

java

CopyEdit

`import java.util.*;`

`public class HashMapExample {`

    `public static void main(String[] args) {`

        `Map<Integer, String> map = new HashMap<>();`

        `map.put(1, "Alice");`

        `map.put(2, "Bob");`

        `System.out.println(map); // Output: {1=Alice, 2=Bob}`

    `}`

`}`

---

6.2 `LinkedHashMap` (Maintains Insertion Order)

✔ Same as `HashMap`, but maintains order.

Example:

java

CopyEdit

`import java.util.*;`

`public class LinkedHashMapExample {`

    `public static void main(String[] args) {`

        `Map<String, Integer> map = new LinkedHashMap<>();`

        `map.put("John", 25);`

        `map.put("Jane", 30);`

        `System.out.println(map); // Output: {John=25, Jane=30}`

    `}`

`}`

---

6.3 `TreeMap` (Sorted Order, Uses Red-Black Tree)

✔ **Maintains ascending key order**.  
 ✔ O(log n) operations.

Example:

java

CopyEdit

`import java.util.*;`

`public class TreeMapExample {`

    `public static void main(String[] args) {`

        `Map<Integer, String> map = new TreeMap<>();`

        `map.put(3, "Apple");`

        `map.put(1, "Banana");`

        `System.out.println(map); // Output: {1=Banana, 3=Apple}`

    `}`

`}`

---

7\. Queue Interface (FIFO Operations)

7.1 `PriorityQueue` (Sorted Order)

✔ **Min-Heap by default** (smallest element first).  
 ✔ Used in **task scheduling** and **Dijkstra’s Algorithm**.

Example:

java

CopyEdit

`import java.util.*;`

`public class PriorityQueueExample {`

    `public static void main(String[] args) {`

        `Queue<Integer> pq = new PriorityQueue<>();`

        `pq.add(30);`

        `pq.add(10);`

        `pq.add(20);`

        `System.out.println(pq.poll()); // Output: 10 (smallest element)`

    `}`

`}`

---

## Part 2 | Comparator vs Comparable | PriorityQueue

---

1\. Comparator vs Comparable in Java

Both **Comparable** and **Comparator** are used for sorting objects in Java.

| Feature | `Comparable` | `Comparator` |
| ----- | ----- | ----- |
| **Purpose** | Used to define the **natural ordering** of objects | Used to define **custom ordering** of objects |
| **Package** | `java.lang` | `java.util` |
| **Method to Implement** | `compareTo(T obj)` | `compare(T obj1, T obj2)` |
| **Number of Sorting Orders** | **Single sorting logic** per class | Multiple sorting logics possible |
| **Modification Needed?** | **Yes**, modify the class to implement `Comparable` | **No**, can be defined externally |
| **Used in** | `TreeSet`, `TreeMap`, `PriorityQueue` | `Collections.sort()`, `PriorityQueue`, `TreeMap` |

---

1.1 Comparable Example (Single Sorting Order \- Natural Ordering)

✔ The `compareTo()` method is used to define the **default sorting order**.

Example: Sorting Employees by ID (Ascending Order)

java

CopyEdit

`import java.util.*;`

`class Employee implements Comparable<Employee> {`

    `int id;`

    `String name;`

    `public Employee(int id, String name) {`

        `this.id = id;`

        `this.name = name;`

    `}`

    `@Override`

    `public int compareTo(Employee other) {`

        `return this.id - other.id; // Sorting by ID (Ascending Order)`

    `}`

    `@Override`

    `public String toString() {`

        `return id + " - " + name;`

    `}`

`}`

`public class ComparableExample {`

    `public static void main(String[] args) {`

        `List<Employee> employees = new ArrayList<>();`

        `employees.add(new Employee(3, "John"));`

        `employees.add(new Employee(1, "Alice"));`

        `employees.add(new Employee(2, "Bob"));`

        `Collections.sort(employees); // Uses Comparable`

        `System.out.println(employees); // Output: [1 - Alice, 2 - Bob, 3 - John]`

    `}`

`}`

---

1.2 Comparator Example (Multiple Sorting Orders)

✔ The `Comparator` interface is used to define **custom sorting orders**.

Example: Sorting Employees by Name (Alphabetically)

java

CopyEdit

`import java.util.*;`

`class Employee {`

    `int id;`

    `String name;`

    `public Employee(int id, String name) {`

        `this.id = id;`

        `this.name = name;`

    `}`

    `@Override`

    `public String toString() {`

        `return id + " - " + name;`

    `}`

`}`

`// Comparator for sorting by name`

`class NameComparator implements Comparator<Employee> {`

    `@Override`

    `public int compare(Employee e1, Employee e2) {`

        `return e1.name.compareTo(e2.name); // Alphabetical order`

    `}`

`}`

`public class ComparatorExample {`

    `public static void main(String[] args) {`

        `List<Employee> employees = new ArrayList<>();`

        `employees.add(new Employee(3, "John"));`

        `employees.add(new Employee(1, "Alice"));`

        `employees.add(new Employee(2, "Bob"));`

        `Collections.sort(employees, new NameComparator());`

        `System.out.println(employees); // Output: [1 - Alice, 2 - Bob, 3 - John]`

    `}`

`}`

---

1.3 Lambda Expression with Comparator (Java 8+)

✔ No need to create a separate `Comparator` class.

Example: Sorting by ID in Descending Order

java

CopyEdit

`import java.util.*;`

`public class LambdaComparator {`

    `public static void main(String[] args) {`

        `List<Employee> employees = new ArrayList<>();`

        `employees.add(new Employee(3, "John"));`

        `employees.add(new Employee(1, "Alice"));`

        `employees.add(new Employee(2, "Bob"));`

        `// Using Lambda for sorting by ID (Descending Order)`

        `employees.sort((e1, e2) -> e2.id - e1.id);`

        `System.out.println(employees); // Output: [3 - John, 2 - Bob, 1 - Alice]`

    `}`

`}`

---

2\. PriorityQueue in Java (Min-Heap & Max-Heap Implementation)

✔ **PriorityQueue** is part of the Java **Queue** interface.  
 ✔ Stores elements in **sorted order (by priority, not insertion order)**.  
 ✔ **Uses a Min-Heap** by default (smallest element first).  
 ✔ Supports **custom sorting using Comparator**.

---

2.1 Min-Heap (Default Behavior \- Smallest Element First)

✔ Default `PriorityQueue` follows **natural ordering**.

Example:

java

CopyEdit

`import java.util.*;`

`public class MinHeapExample {`

    `public static void main(String[] args) {`

        `PriorityQueue<Integer> pq = new PriorityQueue<>();`

        `pq.add(30);`

        `pq.add(10);`

        `pq.add(20);`

        `while (!pq.isEmpty()) {`

            `System.out.println(pq.poll()); // Output: 10, 20, 30`

        `}`

    `}`

`}`

---

2.2 Max-Heap (Largest Element First)

✔ Use a **Comparator** to create a Max-Heap.

Example:

java

CopyEdit

`import java.util.*;`

`public class MaxHeapExample {`

    `public static void main(String[] args) {`

        `PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());`

        `pq.add(30);`

        `pq.add(10);`

        `pq.add(20);`

        `while (!pq.isEmpty()) {`

            `System.out.println(pq.poll()); // Output: 30, 20, 10`

        `}`

    `}`

`}`

---

2.3 PriorityQueue with Custom Comparator

✔ Sorting a `PriorityQueue` using **custom priority**.

Example: Task Scheduling (Priority Order)

java

CopyEdit

`import java.util.*;`

`class Task {`

    `String name;`

    `int priority;`

    `public Task(String name, int priority) {`

        `this.name = name;`

        `this.priority = priority;`

    `}`

    `@Override`

    `public String toString() {`

        `return name + " (Priority: " + priority + ")";`

    `}`

`}`

`public class TaskScheduler {`

    `public static void main(String[] args) {`

        `PriorityQueue<Task> taskQueue = new PriorityQueue<>((t1, t2) -> t2.priority - t1.priority);`

        

        `taskQueue.add(new Task("Fix Bug", 2));`

        `taskQueue.add(new Task("Develop Feature", 1));`

        `taskQueue.add(new Task("Code Review", 3));`

        `while (!taskQueue.isEmpty()) {`

            `System.out.println(taskQueue.poll());` 

        `}`

        `// Output: Code Review (Priority: 3), Fix Bug (Priority: 2), Develop Feature (Priority: 1)`

    `}`

`}`

---

## Part 3 | Deque and List in Depth

---

1\. Deque (Double-Ended Queue) in Java

✔ `Deque` (pronounced "deck") allows **insertion and deletion from both ends**.  
 ✔ Implemented using `ArrayDeque` and `LinkedList`.  
 ✔ More flexible than a `Queue` (FIFO) or a `Stack` (LIFO).

1.1 Deque Implementations in Java

| Implementation | Backed By | Performance |
| ----- | ----- | ----- |
| `ArrayDeque` | **Resizable Array** | **Faster than `LinkedList`**, no memory overhead for links |
| `LinkedList` | **Doubly Linked List** | Extra memory for links, slightly slower |

---

1.2 Methods in Deque

| Method | Description |
| ----- | ----- |
| `addFirst(E e) / offerFirst(E e)` | Adds element at the front |
| `addLast(E e) / offerLast(E e)` | Adds element at the back |
| `removeFirst() / pollFirst()` | Removes the front element |
| `removeLast() / pollLast()` | Removes the back element |
| `getFirst() / peekFirst()` | Retrieves the front element |
| `getLast() / peekLast()` | Retrieves the back element |

---

1.3 Example: Using `ArrayDeque` for Both Stack & Queue Operations  
java

CopyEdit

`import java.util.*;`

`public class DequeExample {`

    `public static void main(String[] args) {`

        `Deque<Integer> deque = new ArrayDeque<>();`

        `// Adding elements at both ends`

        `deque.addFirst(10);`

        `deque.addLast(20);`

        `deque.offerFirst(5);`

        `deque.offerLast(25);`

        `System.out.println(deque); // Output: [5, 10, 20, 25]`

        `// Removing elements from both ends`

        `System.out.println("Removed First: " + deque.removeFirst()); // 5`

        `System.out.println("Removed Last: " + deque.removeLast());   // 25`

        `System.out.println(deque); // Output: [10, 20]`

    `}`

`}`

---

1.4 Deque as a Stack (LIFO)

✔ **Deque can be used as a Stack** (similar to `Stack<E>`, but faster).

java

CopyEdit

`import java.util.*;`

`public class DequeAsStack {`

    `public static void main(String[] args) {`

        `Deque<Integer> stack = new ArrayDeque<>();`

        `stack.push(10); // Add element on top`

        `stack.push(20);`

        `stack.push(30);`

        `System.out.println(stack.pop()); // 30 (LIFO)`

        `System.out.println(stack.peek()); // 20 (Top element)`

    `}`

`}`

---

1.5 Deque as a Queue (FIFO)

✔ **Deque can be used as a Queue** (similar to `LinkedList`, but faster).

java

CopyEdit

`import java.util.*;`

`public class DequeAsQueue {`

    `public static void main(String[] args) {`

        `Deque<Integer> queue = new ArrayDeque<>();`

        `queue.offer(10);`

        `queue.offer(20);`

        `queue.offer(30);`

        `System.out.println(queue.poll()); // 10 (FIFO)`

        `System.out.println(queue.peek()); // 20 (Front element)`

    `}`

`}`

---

2\. List in Depth (ArrayList vs LinkedList vs Vector)

A `List` is an **ordered collection** that allows duplicates and provides **indexed access** to elements.

2.1 Types of Lists in Java

| Implementation | Backed By | Performance |
| ----- | ----- | ----- |
| `ArrayList` | **Resizable Array** | **Fast for random access (O(1))**, slow for insert/delete in middle (O(n)) |
| `LinkedList` | **Doubly Linked List** | **Fast insert/delete (O(1))**, slow random access (O(n)) |
| `Vector` | **Resizable Array (Thread-safe)** | Similar to `ArrayList`, but **synchronized** (slower in single-threaded apps) |

---

2.2 Methods in List

| Method | Description |
| ----- | ----- |
| `add(E e) / add(int index, E e)` | Adds an element at the end or specific index |
| `remove(int index) / remove(Object o)` | Removes an element by index or value |
| `get(int index)` | Retrieves an element at the given index |
| `set(int index, E e)` | Replaces an element at a given index |
| `indexOf(Object o) / lastIndexOf(Object o)` | Finds first/last occurrence index |

---

2.3 Example: ArrayList (Dynamic Array)  
java

CopyEdit

`import java.util.*;`

`public class ArrayListExample {`

    `public static void main(String[] args) {`

        `List<String> list = new ArrayList<>();`

        `list.add("Apple");`

        `list.add("Banana");`

        `list.add("Mango");`

        `System.out.println(list.get(1)); // Banana`

        `list.set(1, "Orange");`

        `System.out.println(list); // [Apple, Orange, Mango]`

    `}`

`}`

---

2.4 Example: LinkedList (Doubly Linked List)

✔ **Efficient for frequent insertions/deletions.**

java

CopyEdit

`import java.util.*;`

`public class LinkedListExample {`

    `public static void main(String[] args) {`

        `List<String> list = new LinkedList<>();`

        `list.add("Red");`

        `list.add("Blue");`

        `list.add(1, "Green");`

        `System.out.println(list); // [Red, Green, Blue]`

        `list.remove("Green");`

        `System.out.println(list); // [Red, Blue]`

    `}`

`}`

---

2.5 Example: Vector (Thread-Safe List)

✔ **Slower than `ArrayList`, but useful in multi-threaded environments.**

java

CopyEdit

`import java.util.*;`

`public class VectorExample {`

    `public static void main(String[] args) {`

        `List<Integer> vector = new Vector<>();`

        `vector.add(10);`

        `vector.add(20);`

        `vector.add(30);`

        `System.out.println(vector); // [10, 20, 30]`

    `}`

`}`

---

3\. Summary: Deque vs List Implementations

3.1 Deque Summary

| Feature | ArrayDeque | LinkedList |
| ----- | ----- | ----- |
| **Performance** | Faster, no overhead for links | Slightly slower, uses extra memory |
| **Usage** | Stack, Queue, Deque | Stack, Queue, Deque |
| **Best For** | **Stack & Queue operations** | **Frequent insert/delete** |

---

3.2 List Summary

| Feature | ArrayList | LinkedList | Vector |
| ----- | ----- | ----- | ----- |
| **Data Structure** | **Resizable Array** | **Doubly Linked List** | **Resizable Array (Thread-Safe)** |
| **Random Access** | **Fast (O(1))** | **Slow (O(n))** | **Fast (O(1))** |
| **Insert/Delete** | **Slow (O(n))** | **Fast (O(1))** | **Slow (O(n))** |
| **Thread Safety** | ❌ No | ❌ No | ✅ Yes |
| **Best For** | **Frequent read operations** | **Frequent insert/delete** | **Multi-threaded environments** |

---

## Part 4 | HashMap Internal Working in Java

---

1\. Introduction to HashMap

`HashMap<K, V>` is a part of the Java Collections Framework that provides **key-value** pair storage. It is implemented using **hashing**, allowing **fast retrieval (O(1) average case, O(n) worst case)**.

✔ **Allows one `null` key and multiple `null` values**  
 ✔ **Unordered collection** (No insertion order maintained)  
 ✔ **Not thread-safe** (Use `ConcurrentHashMap` for thread safety)

---

2\. HashMap Internal Structure

Internally, `HashMap` is backed by an **array of linked lists (buckets)**, where each index in the array stores a **linked list of key-value pairs (Nodes/Entries)**.

rust

CopyEdit

`HashMap<K, V>`

`+------------------+`

`|  Bucket[0] -> (Key1, Value1) -> (Key2, Value2) -> null`

`|  Bucket[1] -> null`

`|  Bucket[2] -> (Key3, Value3) -> null`

`|  ...`

`|  Bucket[N] -> null`

`+------------------+`

**Key Terms:**

* **Bucket:** Each index of the array.  
* **Hash Function:** Converts a key into a bucket index.  
* **Collision:** When two keys get the same bucket index.  
* **Load Factor:** Determines when to resize the HashMap (Default: `0.75f`).  
* **Rehashing:** Increasing bucket size when threshold exceeds.

---

3\. How `put(K key, V value)` Works?

Step 1: Compute HashCode

Each key’s `hashCode()` is computed, then transformed into a bucket index.

java

CopyEdit

`int hashCode = key.hashCode();`

`int index = (hashCode & 0x7FFFFFFF) % capacity;`

Example:

java

CopyEdit

`"Apple".hashCode() = 123456  →  Index = 123456 % 16 = 0`

Step 2: Check for Collision

* If no existing entry at `index`, insert a new `Node<K, V>`.  
* If an entry already exists (**collision**), check keys:  
  * If key **matches**, update the value.  
  * If key **does not match**, use **Linked List (before Java 8\)** or **Balanced Tree (after Java 8, if size \> 8\)**.

Step 3: Store Key-Value Pair

java

CopyEdit

`hashMap.put("Apple", 100);`

`hashMap.put("Orange", 200);`

Stores:

less

CopyEdit

`Bucket[0] → ("Apple", 100)`

`Bucket[1] → ("Orange", 200)`

---

4\. How `get(K key)` Works?

1. Compute the `hashCode` and find the index.  
2. Search the bucket:  
   * If only **one node**, return its value.  
   * If **collision exists**, traverse the linked list (or tree after Java 8).  
3. Return the value if the key is found, else return `null`.

---

5\. Collision Handling Mechanisms

Collisions occur when different keys hash to the same bucket. `HashMap` handles this using:

A. Separate Chaining (Linked List)

Before Java 8, HashMap stored collided keys as a **linked list**.

java

CopyEdit

`Bucket[0] → ("Apple", 100) → ("Mango", 300) → null`

B. Tree-Based Resolution (Java 8+)

If **linked list size \> 8**, it is converted into a **Red-Black Tree** for **O(log n) search time**.

java

CopyEdit

`Bucket[0] →  TreeNode ("Apple", 100)`

                    `↙        ↘`

        `("Mango", 300)   ("Banana", 400)`

---

6\. Load Factor & Rehashing

The **load factor** defines when the `HashMap` increases its size (default `0.75`).

java

CopyEdit

`Initial capacity = 16`

`Load factor = 0.75`

`Resize threshold = 16 * 0.75 = 12 elements`

When the number of entries **exceeds 12**, `HashMap` **doubles its size** and **re-distributes** entries to new buckets.

---

7\. Example: HashMap Internal Operations

java

CopyEdit

`import java.util.HashMap;`

`public class HashMapDemo {`

    `public static void main(String[] args) {`

        `HashMap<String, Integer> map = new HashMap<>();`

        `// Put elements`

        `map.put("Apple", 100);`

        `map.put("Banana", 200);`

        `map.put("Mango", 300);`

        `// Get elements`

        `System.out.println("Apple price: " + map.get("Apple")); // 100`

        `// Check key existence`

        `System.out.println("Contains 'Banana'? " + map.containsKey("Banana")); // true`

        `// Remove an element`

        `map.remove("Mango");`

        `System.out.println(map); // {Apple=100, Banana=200}`

    `}`

`}`

---

8\. Summary

| Feature | Description |
| ----- | ----- |
| **Time Complexity** | **O(1) average**, O(n) worst case (if collisions exist) |
| **Load Factor** | Default: `0.75`, triggers resizing |
| **Collision Handling** | **Linked List (pre-Java 8), Red-Black Tree (post-Java 8\)** |
| **Null Values** | One `null` key allowed, multiple `null` values allowed |
| **Resizing** | Doubles capacity when load factor threshold is exceeded |

🚀 **Next Steps:** Would you like a deep dive into `LinkedHashMap` and `TreeMap`? 😊

---

## Part 5 | LinkedHashMap and TreeMap in Depth

1\. Introduction

Both `LinkedHashMap` and `TreeMap` are implementations of `Map` in Java but with different properties:

| Feature | `LinkedHashMap` | `TreeMap` |
| ----- | ----- | ----- |
| **Ordering** | Maintains **insertion order** | Sorts keys in **ascending order** (by default) |
| **Null Keys** | **Allowed (one null key)** | **Not allowed** (throws `NullPointerException`) |
| **Null Values** | **Allowed** | **Allowed** |
| **Performance** | Slightly **slower than HashMap** (due to order maintenance) | Slower than `HashMap` but provides **sorted keys** |
| **Sorting** | No sorting (just preserves insertion order) | Uses **natural ordering** or a custom `Comparator` |

---

2\. LinkedHashMap in Depth

2.1 What is `LinkedHashMap`?

`LinkedHashMap` is a subclass of `HashMap` that maintains **insertion order** using a **doubly linked list**.

✔ **Fast Lookup (`O(1)`) like HashMap**  
 ✔ **Maintains Order**  
 ✔ **Good for LRU Cache Implementation**

2.2 Internal Structure of LinkedHashMap

Internally, `LinkedHashMap` uses:

* A **HashTable (Array of Buckets)** for fast access.  
* A **Doubly Linked List** to maintain order.

lua

CopyEdit

`LinkedHashMap<K, V>`

`+------------+    +------------+    +------------+`

`| ("A", 100) | -> | ("B", 200) | -> | ("C", 300) |`

`+------------+    +------------+    +------------+`

2.3 Example: LinkedHashMap in Action

java

CopyEdit

`import java.util.*;`

`public class LinkedHashMapDemo {`

    `public static void main(String[] args) {`

        `LinkedHashMap<String, Integer> map = new LinkedHashMap<>();`

        `// Insert elements`

        `map.put("Apple", 100);`

        `map.put("Banana", 200);`

        `map.put("Mango", 300);`

        `// Retrieve elements`

        `System.out.println(map); // Maintains Insertion Order`

        `// Output: {Apple=100, Banana=200, Mango=300}`

    `}`

`}`

---

2.4 Access Order (LRU Cache)

`LinkedHashMap` allows **access order** tracking using:

java

CopyEdit

`LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder);`

✔ `accessOrder = false` → Maintains **insertion order** (default).  
 ✔ `accessOrder = true` → Maintains **access order** (like LRU Cache).

Example: LRU Cache Implementation

java

CopyEdit

`import java.util.*;`

`class LRUCache<K, V> extends LinkedHashMap<K, V> {`

    `private final int capacity;`

    `public LRUCache(int capacity) {`

        `super(capacity, 0.75f, true); // true = access order`

        `this.capacity = capacity;`

    `}`

    `@Override`

    `protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {`

        `return size() > capacity; // Remove least recently used`

    `}`

`}`

`public class LRUExample {`

    `public static void main(String[] args) {`

        `LRUCache<Integer, String> cache = new LRUCache<>(3);`

        `cache.put(1, "One");`

        `cache.put(2, "Two");`

        `cache.put(3, "Three");`

        `cache.get(1); // Access 1 → Moves to the end`

        `cache.put(4, "Four"); // Removes LRU (2)`

        `System.out.println(cache); // Output: {3=Three, 1=One, 4=Four}`

    `}`

`}`

---

3\. TreeMap in Depth

3.1 What is `TreeMap`?

`TreeMap` is a **Red-Black Tree** based implementation of `NavigableMap` that keeps keys **sorted in ascending order**.

✔ **Ordered Sorting (O(log n))**  
 ✔ **Efficient Range Queries**  
 ✔ **No `null` keys allowed** (throws `NullPointerException`)

3.2 Internal Structure of TreeMap

Internally, `TreeMap` uses:

* A **Self-Balancing Red-Black Tree** for ordering.  
* **Time Complexity:** `O(log n)` for insertion, deletion, and search.

mathematica

CopyEdit

`TreeMap<K, V>`

           `50`

          `/  \`

        `20    70`

       `/  \   /  \`

     `10   30 60  80`

---

3.3 Example: TreeMap in Action

java

CopyEdit

`import java.util.*;`

`public class TreeMapDemo {`

    `public static void main(String[] args) {`

        `TreeMap<Integer, String> map = new TreeMap<>();`

        `map.put(50, "Apple");`

        `map.put(10, "Banana");`

        `map.put(30, "Mango");`

        `map.put(70, "Orange");`

        `System.out.println(map); // Output: {10=Banana, 30=Mango, 50=Apple, 70=Orange}`

    `}`

`}`

---

3.4 Custom Sorting using Comparator

By default, `TreeMap` sorts in **natural order**.  
 We can pass a **custom Comparator** to define a **custom sorting order**.

java

CopyEdit

`import java.util.*;`

`public class TreeMapCustomSort {`

    `public static void main(String[] args) {`

        `TreeMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());`

        `map.put(50, "Apple");`

        `map.put(10, "Banana");`

        `map.put(30, "Mango");`

        `map.put(70, "Orange");`

        `System.out.println(map); // Output: {70=Orange, 50=Apple, 30=Mango, 10=Banana}`

    `}`

`}`

---

3.5 HeadMap, TailMap, SubMap (Range Queries)

`TreeMap` supports **range queries** using `headMap`, `tailMap`, and `subMap`.

java

CopyEdit

`TreeMap<Integer, String> map = new TreeMap<>();`

`map.put(10, "A");`

`map.put(20, "B");`

`map.put(30, "C");`

`map.put(40, "D");`

`System.out.println(map.headMap(30));   // {10=A, 20=B}`

`System.out.println(map.tailMap(20));   // {20=B, 30=C, 40=D}`

`System.out.println(map.subMap(10, 40)); // {10=A, 20=B, 30=C}`

---

4\. Summary: LinkedHashMap vs TreeMap

| Feature | `LinkedHashMap` | `TreeMap` |
| ----- | ----- | ----- |
| **Ordering** | Maintains **insertion order** | **Sorted by keys** (Ascending order by default) |
| **Performance** | `O(1)` for insert, get, remove | `O(log n)` for insert, get, remove |
| **Null Keys** | **Allowed (one null key)** | **Not allowed** (throws `NullPointerException`) |
| **Best Use Case** | **LRU Caches, Iteration Order Matters** | **Sorted Data Storage, Range Queries** |

---

## Part 6 | Set in Depth

---

1\. Introduction to Set Interface

A `Set` in Java is a **collection of unique elements**, meaning **duplicates are not allowed**. It is a part of the **Java Collections Framework (JCF)** and extends the `Collection` interface.

✔ **No Duplicates Allowed**  
 ✔ **Implements Hashing or Tree-based structure**  
 ✔ **Allows Null values (except `TreeSet`)**  
 ✔ **Supports Iteration and Bulk Operations**

Hierarchy of Set Interface

javascript

CopyEdit

          `Collection`

               `│`

             `Set`

    `┌────────┴────────┐`

 `HashSet        SortedSet`

    `│                 │`

 `LinkedHashSet      TreeSet`

---

2\. Types of Set Implementations in Java

| Type | Ordering | Nulls Allowed? | Performance |
| ----- | ----- | ----- | ----- |
| **HashSet** | ❌ No Order | ✅ One `null` value | **O(1) average case**, O(n) worst case |
| **LinkedHashSet** | ✅ Insertion Order | ✅ One `null` value | Slightly slower than `HashSet` |
| **TreeSet** | ✅ Sorted Order | ❌ No `null` key | **O(log n) (Red-Black Tree)** |

---

3\. HashSet in Depth

3.1 What is `HashSet`?

* Uses a **HashTable (backed by `HashMap`)** to store elements.  
* **No ordering is maintained**.  
* **Fastest for lookups (O(1) average case)**.

3.2 Internal Working of HashSet

* `HashSet` uses a **HashMap** internally.  
* Each element is stored as a **key** in the `HashMap`, and the **value is a dummy object**.

java

CopyEdit

`public class HashSet<E> {`

    `private transient HashMap<E, Object> map;`

    `private static final Object PRESENT = new Object();`

    `public boolean add(E e) {`

        `return map.put(e, PRESENT) == null;`

    `}`

`}`

3.3 Example of HashSet

java

CopyEdit

`import java.util.*;`

`public class HashSetDemo {`

    `public static void main(String[] args) {`

        `Set<String> set = new HashSet<>();`

        `set.add("Apple");`

        `set.add("Banana");`

        `set.add("Mango");`

        `set.add("Apple"); // Duplicate ignored`

        `System.out.println(set); // Output: [Mango, Apple, Banana] (Order not guaranteed)`

    `}`

`}`

---

4\. LinkedHashSet in Depth

4.1 What is `LinkedHashSet`?

* A subclass of `HashSet` that **maintains insertion order**.  
* Uses **Linked List \+ HashTable** internally.  
* **Performance is slightly slower than `HashSet`** due to order maintenance.

4.2 Example of LinkedHashSet

java

CopyEdit

`import java.util.*;`

`public class LinkedHashSetDemo {`

    `public static void main(String[] args) {`

        `Set<String> set = new LinkedHashSet<>();`

        `set.add("Apple");`

        `set.add("Banana");`

        `set.add("Mango");`

        `System.out.println(set); // Output: [Apple, Banana, Mango] (Insertion Order)`

    `}`

`}`

---

5\. TreeSet in Depth

5.1 What is `TreeSet`?

* Implements **SortedSet** and maintains **ascending order**.  
* Uses **Red-Black Tree (Self-Balancing Binary Search Tree)**.  
* **`O(log n)` time complexity** for insert, delete, search.  
* **Does not allow `null` values**.

5.2 Example of TreeSet

java

CopyEdit

`import java.util.*;`

`public class TreeSetDemo {`

    `public static void main(String[] args) {`

        `Set<Integer> set = new TreeSet<>();`

        `set.add(40);`

        `set.add(10);`

        `set.add(30);`

        `set.add(20);`

        `System.out.println(set); // Output: [10, 20, 30, 40] (Sorted Order)`

    `}`

`}`

---

6\. Custom Sorting in TreeSet

We can use a **Comparator** for custom ordering.

java

CopyEdit

`import java.util.*;`

`public class CustomTreeSet {`

    `public static void main(String[] args) {`

        `Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());`

        `set.add(40);`

        `set.add(10);`

        `set.add(30);`

        `set.add(20);`

        `System.out.println(set); // Output: [40, 30, 20, 10] (Descending Order)`

    `}`

`}`

---

7\. Differences Between HashSet, LinkedHashSet, and TreeSet

| Feature | `HashSet` | `LinkedHashSet` | `TreeSet` |
| ----- | ----- | ----- | ----- |
| **Ordering** | ❌ No Order | ✅ Insertion Order | ✅ Sorted Order |
| **Performance** | **O(1)** (Best for search) | **O(1)** (Slightly slower) | **O(log n)** (Red-Black Tree) |
| **Null Values** | ✅ Allowed | ✅ Allowed | ❌ Not Allowed |
| **Best Use Case** | **Fast Lookup** | **Ordered Iteration** | **Sorted Data Storage** |

---

8\. Set Operations (Union, Intersection, Difference)

We can perform **mathematical set operations** using Java’s `Set`.

java

CopyEdit

`import java.util.*;`

`public class SetOperations {`

    `public static void main(String[] args) {`

        `Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));`

        `Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6));`

        `// Union`

        `Set<Integer> union = new HashSet<>(set1);`

        `union.addAll(set2);`

        `System.out.println("Union: " + union); // Output: [1, 2, 3, 4, 5, 6]`

        `// Intersection`

        `Set<Integer> intersection = new HashSet<>(set1);`

        `intersection.retainAll(set2);`

        `System.out.println("Intersection: " + intersection); // Output: [3, 4]`

        `// Difference`

        `Set<Integer> difference = new HashSet<>(set1);`

        `difference.removeAll(set2);`

        `System.out.println("Difference: " + difference); // Output: [1, 2]`

    `}`

`}`

---

9\. When to Use Which Set?

| Scenario | Recommended Set |
| ----- | ----- |
| Need fast lookup (`O(1)`) | `HashSet` |
| Need to preserve insertion order | `LinkedHashSet` |
| Need sorted data (`O(log n)`) | `TreeSet` |
| Need range-based queries | `TreeSet` |

---

## Part 7 | Streams in Java 8

---

1\. Introduction to Streams in Java 8

Java **Streams** (introduced in Java 8\) provide a **functional-style** approach to processing collections. It allows operations on large amounts of data in a **declarative, parallelizable, and efficient** manner.

✔ **Declarative (Concise and Readable Code)**  
 ✔ **Efficient (Lazy Evaluation, Parallel Execution)**  
 ✔ **Supports Functional Programming**  
 ✔ **Does NOT modify the original collection**

Hierarchy of Stream API

arduino

CopyEdit

`Collection`

     `│`

`Stream API`

     `│`

     `├── Stream<T> (For Objects)`

     `├── IntStream (For int)`

     `├── LongStream (For long)`

     `└── DoubleStream (For double)`

---

2\. Creating a Stream in Java

There are multiple ways to create a Stream:

2.1 From Collections (List, Set, etc.)

java

CopyEdit

`import java.util.*;`

`import java.util.stream.*;`

`public class StreamExample {`

    `public static void main(String[] args) {`

        `List<String> list = Arrays.asList("Apple", "Banana", "Mango");`

        `Stream<String> stream = list.stream(); // Convert List to Stream`

        `stream.forEach(System.out::println);`

    `}`

`}`

2.2 From Arrays

java

CopyEdit

`String[] arr = { "A", "B", "C" };`

`Stream<String> stream = Arrays.stream(arr);`

`stream.forEach(System.out::println);`

2.3 Using `Stream.of()`

java

CopyEdit

`Stream<Integer> stream = Stream.of(1, 2, 3, 4);`

`stream.forEach(System.out::println);`

2.4 Using `Stream.generate()` (Infinite Stream)

java

CopyEdit

`Stream<Integer> infiniteStream = Stream.generate(() -> 5);`

`infiniteStream.limit(5).forEach(System.out::println); // 5, 5, 5, 5, 5`

2.5 Using `Stream.iterate()`

java

CopyEdit

`Stream<Integer> stream = Stream.iterate(1, n -> n + 2);`

`stream.limit(5).forEach(System.out::println); // 1, 3, 5, 7, 9`

---

3\. Stream Operations

Stream API supports **Intermediate** and **Terminal** operations.

| Type | Example Methods | Description |
| ----- | ----- | ----- |
| **Intermediate** | `filter()`, `map()`, `sorted()`, `distinct()` | Transform the stream (Lazy Evaluation) |
| **Terminal** | `forEach()`, `collect()`, `count()`, `reduce()` | Produces the result and closes the stream |
| **Short-Circuiting** | `limit()`, `findFirst()`, `findAny()` | Stops execution early |

---

4\. Intermediate Operations in Streams

4.1 `filter(Predicate)` \- Filtering Elements

java

CopyEdit

`List<String> names = Arrays.asList("John", "Alex", "Tom", "Amanda");`

`names.stream()`

     `.filter(name -> name.startsWith("A"))`

     `.forEach(System.out::println);  // Output: Alex, Amanda`

4.2 `map(Function)` \- Transforming Elements

java

CopyEdit

`List<String> names = Arrays.asList("apple", "banana", "cherry");`

`names.stream()`

     `.map(String::toUpperCase)`

     `.forEach(System.out::println); // APPLE, BANANA, CHERRY`

4.3 `sorted()` \- Sorting Elements

java

CopyEdit

`List<Integer> numbers = Arrays.asList(5, 2, 8, 1);`

`numbers.stream()`

       `.sorted()`

       `.forEach(System.out::println); // Output: 1, 2, 5, 8`

4.4 `distinct()` \- Removing Duplicates

java

CopyEdit

`List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4);`

`numbers.stream()`

       `.distinct()`

       `.forEach(System.out::println); // Output: 1, 2, 3, 4`

4.5 `limit(n)` \- Limiting the Stream

java

CopyEdit

`Stream.of(10, 20, 30, 40, 50)`

      `.limit(3)`

      `.forEach(System.out::println); // Output: 10, 20, 30`

---

5\. Terminal Operations in Streams

5.1 `forEach()` \- Iterate Over Stream

java

CopyEdit

`Stream.of("A", "B", "C").forEach(System.out::println);`

5.2 `collect()` \- Convert Stream to Collection

java

CopyEdit

`List<String> list = Stream.of("Apple", "Banana", "Cherry")`

                          `.collect(Collectors.toList());`

`System.out.println(list); // Output: [Apple, Banana, Cherry]`

5.3 `count()` \- Counting Elements

java

CopyEdit

`long count = Stream.of(1, 2, 3, 4, 5).count();`

`System.out.println(count); // Output: 5`

5.4 `reduce()` \- Aggregate Elements

java

CopyEdit

`int sum = Stream.of(1, 2, 3, 4)`

                `.reduce(0, Integer::sum);`

`System.out.println(sum); // Output: 10`

---

6\. Parallel Streams for Performance

Java Streams can be processed in parallel to **improve performance** on multi-core processors.

6.1 Parallel Stream Example

java

CopyEdit

`import java.util.*;`

`import java.util.stream.*;`

`public class ParallelStreamExample {`

    `public static void main(String[] args) {`

        `List<Integer> numbers = IntStream.range(1, 10).boxed().collect(Collectors.toList());`

        `numbers.parallelStream()`

               `.forEach(num -> System.out.println(Thread.currentThread().getName() + " -> " + num));`

    `}`

`}`

🔹 **Parallel streams can be unpredictable** due to multithreading.

---

7\. Stream vs Collections

| Feature | Collections | Streams |
| ----- | ----- | ----- |
| **Modification** | Can modify elements | Cannot modify original data |
| **Iteration** | External Iteration (for-loop) | Internal Iteration |
| **Performance** | Less Efficient (More Memory Usage) | Optimized for Performance |
| **Execution** | Sequential | Supports Parallel Processing |

---

8\. When to Use Streams?

✔ When working with **large datasets**  
 ✔ When **performance optimization** is needed  
 ✔ When **functional programming** is preferred  
 ✔ When operations can be **chained together**

---

## Java 21: Sequenced Collections

---

🔹 What Are Sequenced Collections?

Java 21 introduced **`SequencedCollection`**, **`SequencedSet`**, and **`SequencedMap`** interfaces to provide a consistent and uniform API for collections that **preserve element order** (typically insertion or sorted order).

---

🔹 Key Motivation

Before Java 21:

* Different ordered collections had **inconsistent method names** for common operations:

  * `List`: `get(0)`, `add(0, x)`, `listIterator()`

  * `Deque`: `getFirst()`, `addLast()`, `removeFirst()`

  * `TreeSet`: `first()`, `last()`, `descendingIterator()`

* This created **confusion, verbosity**, and **hard-to-maintain code**.

**Java 21 Solution:**  
 ✅ Introduce **common interfaces** to unify and simplify operations on **ordered collections**.

---

🔹 New Interfaces & Core Methods

1\. `SequencedCollection<E>`

Adds:

* `getFirst()`, `getLast()`

* `addFirst(E)`, `addLast(E)`

* `removeFirst()`, `removeLast()`

* `reversed()` – returns a reverse view (not a copy)

2\. `SequencedSet<E>` extends `SequencedCollection<E>`

* Same methods \+ **no duplicates**

3\. `SequencedMap<K,V>`

Adds:

* `firstEntry()`, `lastEntry()`

* `putFirst(K, V)`, `putLast(K, V)`

* `pollFirstEntry()`, `pollLastEntry()`

* `reversed()` – returns a reverse view

---

🔹 Who Implements What?

| Collection Type | Implements | Why / Why Not? |
| ----- | ----- | ----- |
| ArrayList | SequencedCollection | Maintains insertion order |
| LinkedList | SequencedCollection | Doubly linked list |
| `Deque` (e.g. `ArrayDeque`) | SequencedCollection | Order-preserving |
| LinkedHashSet | SequencedSet | Ordered, no duplicates |
| TreeSet | SequencedSet | Sorted, no duplicates |
| HashSet | ❌ | Unordered |
| PriorityQueue | ❌ | Maintains priority, not order |
| LinkedHashMap | SequencedMap | Preserves insertion order |
| TreeMap | SequencedMap | Sorted order |
| `HashMap`, `Hashtable` | ❌ | Do not preserve order |

---

🔹 Why `SequencedSet` Was Introduced

* `Set` types like `LinkedHashSet` and `TreeSet` maintain order but **disallow duplicates**.

* Hence, `SequencedSet` was needed as a **distinct interface from `SequencedCollection`**, which allows duplicates.

---

🔹 Unsupported Operations

* For `SortedSet` and `SortedMap` (e.g., `TreeSet`, `TreeMap`):

  * Methods like `addFirst()`, `addLast()`, `putFirst()`, `putLast()` may throw `UnsupportedOperationException`.

  * These collections auto-sort; insertion order has no meaning.

---

🔹 Reverse View

* `reversed()` gives a **read-only reversed view** of the collection or map.

* It does **not mutate** the original collection.

---

🔹 Benefits

* **Cleaner code**: Unified method names

* **Reduced boilerplate**: No need for manual indexing or iterators

* Improved readability and maintenance

* Encourages consistent coding practices

---

🔹 Examples: Unified Usage

java

CopyEdit

SequencedCollection\<String\> list \= new ArrayList\<\>(List.of("B", "C", "D"));

list.addFirst("A");

list.addLast("E");

System.out.println(list.getFirst());  // A

System.out.println(list.getLast());   // E

System.out.println(list.reversed());  // \[E, D, C, B, A\]

java

CopyEdit

SequencedMap\<Integer, String\> map \= new LinkedHashMap\<\>();

map.putFirst(1, "A");

map.putLast(2, "B");

System.out.println(map.firstEntry());  // 1=A

System.out.println(map.lastEntry());   // 2=B

System.out.println(map.reversed());    // {2=B, 1=A}

---

🧠 Conclusion

Java 21’s `Sequenced*` interfaces solve a long-standing inconsistency in the Collection API by:

* Introducing **common access methods**

* Improving **developer ergonomics**

* Reducing code complexity

This feature is a **major API enhancement** that helps standardize how we interact with ordered collections.

# 

# Multithreading and Concurrency

## Part 1 | Threads, Processes, and Their Memory Model in Depth

---

![][image2]

1\. Introduction to Multithreading & Concurrency

Multithreading in Java allows **multiple threads** to run **concurrently**, enabling parallel execution and efficient CPU utilization.

✔ **Thread \= Lightweight process**  
 ✔ **Concurrency \= Multiple tasks appear to run simultaneously**  
 ✔ **Parallelism \= True simultaneous execution on multi-core CPUs**

Why Use Multithreading?

✔ **Better CPU Utilization** \- Uses idle CPU time efficiently.  
 ✔ **Faster Execution** \- Parallel execution speeds up computations.  
 ✔ **Better Responsiveness** \- UI applications remain responsive.  
 ✔ **Supports Asynchronous Processing** \- Useful for I/O and network operations.

---

2\. Process vs. Thread

| Feature | Process | Thread |
| ----- | ----- | ----- |
| **Definition** | A self-contained execution unit | A lightweight execution unit within a process |
| **Memory Sharing** | Each process has its own memory space | Threads share memory within a process |
| **Communication** | Inter-process communication (IPC) is slow | Threads communicate faster via shared memory |
| **Context Switching** | More expensive | Less expensive |
| **Creation Time** | More time-consuming | Faster to create |

🔹 **Java applications run as a single process, and threads run inside that process.**

---

3\. Java Memory Model (JMM)

How Threads Interact with Memory?

* Each **Thread** has its own **working memory (cache)**.  
* All threads share the **main memory (Heap, Method Area, Static Memory, etc.).**  
* **JMM ensures proper synchronization of shared memory**.

Java Memory Areas

rust

CopyEdit

`┌──────────────────────────┐`

`│         Heap Memory      │  -> Shared memory for objects (accessible by all threads)`

`├──────────────────────────┤`

`│      Method Area         │  -> Stores class structures, static variables`

`├──────────────────────────┤`

`│   Stack Memory (Thread)  │  -> Each thread has its own stack`

`├──────────────────────────┤`

`│   PC Register (Thread)   │  -> Stores address of current instruction`

`├──────────────────────────┤`

`│    Native Method Stack   │  -> Native (non-Java) methods execution`

`└──────────────────────────┘`

🔹 **Each thread has a separate Stack & PC Register, but shares the Heap.**

---

4\. Creating Threads in Java

There are **two main ways** to create threads in Java:

4.1 Extending the `Thread` Class

java

CopyEdit

`class MyThread extends Thread {`

    `public void run() {`

        `System.out.println("Thread is running: " + Thread.currentThread().getName());`

    `}`

    `public static void main(String[] args) {`

        `MyThread t1 = new MyThread();`

        `t1.start(); // Starts a new thread`

    `}`

`}`

✔ **Easy to implement**  
 ❌ **Cannot extend another class**

4.2 Implementing `Runnable` Interface (Preferred)

java

CopyEdit

`class MyRunnable implements Runnable {`

    `public void run() {`

        `System.out.println("Thread is running: " + Thread.currentThread().getName());`

    `}`

    `public static void main(String[] args) {`

        `Thread t1 = new Thread(new MyRunnable());`

        `t1.start();`

    `}`

`}`

✔ **More flexible (can extend another class)**  
 ✔ **Better for resource sharing**

---

5\. Thread Lifecycle in Java

markdown

CopyEdit

        `NEW`

          `↓`

       `RUNNABLE`

      `↗       ↘`

 `WAITING   TIMED_WAITING`

      `↘       ↙`

      `BLOCKED`

          `↓`

     `TERMINATED`

Thread States

| State | Description |
| ----- | ----- |
| **NEW** | Created but not started (`new Thread()`) |
| **RUNNABLE** | Eligible for execution (`start()`) |
| **BLOCKED** | Waiting for a monitor lock |
| **WAITING** | Waiting indefinitely for another thread (`wait()`) |
| **TIMED\_WAITING** | Waiting for a fixed time (`sleep(1000)`) |
| **TERMINATED** | Thread execution is finished |

---

6\. Thread Methods

| Method | Description |
| ----- | ----- |
| `start()` | Starts the thread (calls `run()`) |
| `run()` | Code executed by the thread |
| `sleep(ms)` | Pauses execution for `ms` milliseconds |
| `join()` | Waits for another thread to complete |
| `yield()` | Suggests thread scheduler to switch execution |
| `isAlive()` | Checks if thread is still running |

Example of `sleep()` and `join()`

java

CopyEdit

`class Example extends Thread {`

    `public void run() {`

        `try {`

            `Thread.sleep(1000);`

            `System.out.println("Thread running: " + Thread.currentThread().getName());`

        `} catch (InterruptedException e) {`

            `e.printStackTrace();`

        `}`

    `}`

    `public static void main(String[] args) throws InterruptedException {`

        `Example t1 = new Example();`

        `t1.start();`

        `t1.join(); // Main thread waits for t1 to complete`

        `System.out.println("Main thread finished");`

    `}`

`}`

---

7\. Multithreading Issues & Synchronization

7.1 Race Condition (Shared Data Problem)

When multiple threads modify a shared resource simultaneously, unexpected results can occur.

java

CopyEdit

`class Counter {`

    `int count = 0;`

    `void increment() {`

        `count++; // Not thread-safe!`

    `}`

`}`

`public class RaceConditionDemo {`

    `public static void main(String[] args) {`

        `Counter counter = new Counter();`

        `Thread t1 = new Thread(() -> { for (int i = 0; i < 1000; i++) counter.increment(); });`

        `Thread t2 = new Thread(() -> { for (int i = 0; i < 1000; i++) counter.increment(); });`

        `t1.start();`

        `t2.start();`

        `System.out.println(counter.count); // May give unpredictable output!`

    `}`

`}`

7.2 Synchronization to Fix Race Condition

java

CopyEdit

`class Counter {`

    `int count = 0;`

    `synchronized void increment() { // Ensures thread safety`

        `count++;`

    `}`

`}`

✔ **Ensures one thread at a time modifies `count`**  
 ✔ **Prevents race conditions**

---

8\. Volatile Keyword

* Ensures **visibility** of updates to variables across threads.  
* Prevents **caching of variables** in thread-local memory.

java

CopyEdit

`class Example {`

    `private volatile boolean running = true;`

    `void stop() {`

        `running = false; // Change is immediately visible to all threads`

    `}`

`}`

✔ **Useful for flags and state variables**  
 ❌ **Does NOT guarantee atomicity**

---

9\. Summary

✔ **Threads allow parallel execution in Java**  
 ✔ **Java Memory Model ensures proper synchronization**  
 ✔ **Use `Thread` or `Runnable` to create threads**  
 ✔ **Synchronization & `volatile` prevent concurrency issues**

---

## Part 2 | Thread Creation, Thread Lifecycle, and Inter-Thread Communication

---

1\. Creating Threads in Java

There are **three main ways** to create a thread in Java:

1.1 Extending the `Thread` Class

java

CopyEdit

`class MyThread extends Thread {`

    `public void run() {  // Override run() method`

        `System.out.println("Thread running: " + Thread.currentThread().getName());`

    `}`

    `public static void main(String[] args) {`

        `MyThread t1 = new MyThread();`

        `t1.start();  // Starts a new thread`

    `}`

`}`

✔ **Simple implementation**  
 ❌ **Cannot extend another class (Java does not support multiple inheritance)**

---

1.2 Implementing `Runnable` Interface (Preferred)

java

CopyEdit

`class MyRunnable implements Runnable {`

    `public void run() {`

        `System.out.println("Thread running: " + Thread.currentThread().getName());`

    `}`

    `public static void main(String[] args) {`

        `Thread t1 = new Thread(new MyRunnable());`

        `t1.start();`

    `}`

`}`

✔ **More flexible (can extend another class)**  
 ✔ **Better for resource sharing**

---

1.3 Using `Callable` and `Future` (Returns a Result)

java

CopyEdit

`import java.util.concurrent.*;`

`class MyCallable implements Callable<Integer> {`

    `public Integer call() {`

        `return 42;  // Thread returns a result`

    `}`

    `public static void main(String[] args) throws Exception {`

        `ExecutorService executor = Executors.newSingleThreadExecutor();`

        `Future<Integer> future = executor.submit(new MyCallable());`

        `System.out.println("Result: " + future.get()); // Waits for result`

        `executor.shutdown();`

    `}`

`}`

✔ **Can return results**  
 ✔ **Can throw checked exceptions**

---

2\. Thread Lifecycle in Java

markdown

CopyEdit

        `NEW`

          `↓`

       `RUNNABLE`

      `↗       ↘`

 `WAITING   TIMED_WAITING`

      `↘       ↙`

      `BLOCKED`

          `↓`

     `TERMINATED`

Thread States and Transitions

| State | Description |
| ----- | ----- |
| **NEW** | Created but not started (`new Thread()`) |
| **RUNNABLE** | Eligible for execution (`start()`) |
| **BLOCKED** | Waiting for a monitor lock |
| **WAITING** | Waiting indefinitely for another thread (`wait()`) |
| **TIMED\_WAITING** | Waiting for a fixed time (`sleep(1000)`) |
| **TERMINATED** | Thread execution is finished |

Example of Lifecycle Methods

java

CopyEdit

`class LifecycleExample extends Thread {`

    `public void run() {`

        `try {`

            `Thread.sleep(2000); // TIMED_WAITING`

            `System.out.println(Thread.currentThread().getName() + " is running");`

        `} catch (InterruptedException e) {`

            `e.printStackTrace();`

        `}`

    `}`

    `public static void main(String[] args) throws InterruptedException {`

        `LifecycleExample t1 = new LifecycleExample();`

        `System.out.println("Thread State: " + t1.getState()); // NEW`

        `t1.start();`

        `System.out.println("Thread State: " + t1.getState()); // RUNNABLE`

        `Thread.sleep(100);`

        `System.out.println("Thread State: " + t1.getState()); // TIMED_WAITING`

    `}`

`}`

---

3\. Inter-Thread Communication in Java

Threads can communicate using **`wait()`, `notify()`, and `notifyAll()`**.

3.1 `wait()` and `notify()` Example

java

CopyEdit

`class SharedResource {`

    `private int value = 0;`

    `private boolean available = false;`

    `public synchronized void produce(int newValue) {`

        `while (available) { // Wait if value is not consumed`

            `try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }`

        `}`

        `value = newValue;`

        `available = true;`

        `System.out.println("Produced: " + value);`

        `notify(); // Notify consumer`

    `}`

    `public synchronized void consume() {`

        `while (!available) { // Wait if no value is produced`

            `try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }`

        `}`

        `System.out.println("Consumed: " + value);`

        `available = false;`

        `notify(); // Notify producer`

    `}`

`}`

`class Producer extends Thread {`

    `private SharedResource resource;`

    `Producer(SharedResource r) { this.resource = r; }`

    `public void run() {`

        `for (int i = 1; i <= 5; i++) {`

            `resource.produce(i);`

        `}`

    `}`

`}`

`class Consumer extends Thread {`

    `private SharedResource resource;`

    `Consumer(SharedResource r) { this.resource = r; }`

    `public void run() {`

        `for (int i = 1; i <= 5; i++) {`

            `resource.consume();`

        `}`

    `}`

`}`

`public class InterThreadCommunication {`

    `public static void main(String[] args) {`

        `SharedResource resource = new SharedResource();`

        `new Producer(resource).start();`

        `new Consumer(resource).start();`

    `}`

`}`

Explanation

✔ `wait()` makes the thread **release lock and wait**.  
 ✔ `notify()` wakes up **one waiting thread**.  
 ✔ `notifyAll()` wakes up **all waiting threads**.

---

4\. Thread Methods for Communication

| Method | Description |
| ----- | ----- |
| `wait()` | Makes a thread wait (releases lock) |
| `notify()` | Wakes up a single waiting thread |
| `notifyAll()` | Wakes up all waiting threads |
| `join()` | Makes one thread wait for another to finish |

---

5\. Deadlock in Multithreading

A **deadlock** occurs when two or more threads are **waiting for each other's lock**, resulting in an infinite wait.

Example of Deadlock

java

CopyEdit

`class DeadlockExample {`

    `static final Object resource1 = new Object();`

    `static final Object resource2 = new Object();`

    `public static void main(String[] args) {`

        `Thread t1 = new Thread(() -> {`

            `synchronized (resource1) {`

                `System.out.println("Thread 1 locked resource1");`

                `try { Thread.sleep(100); } catch (InterruptedException e) {}`

                `synchronized (resource2) {`

                    `System.out.println("Thread 1 locked resource2");`

                `}`

            `}`

        `});`

        `Thread t2 = new Thread(() -> {`

            `synchronized (resource2) {`

                `System.out.println("Thread 2 locked resource2");`

                `try { Thread.sleep(100); } catch (InterruptedException e) {}`

                `synchronized (resource1) {`

                    `System.out.println("Thread 2 locked resource1");`

                `}`

            `}`

        `});`

        `t1.start();`

        `t2.start();`

    `}`

`}`

🔹 **Avoid deadlocks by acquiring locks in a consistent order.**

---

6\. Summary

✔ **Threads can be created using `Thread`, `Runnable`, and `Callable`.**  
 ✔ **Thread lifecycle includes NEW, RUNNABLE, WAITING, TIMED\_WAITING, BLOCKED, and TERMINATED states.**  
 ✔ **Inter-thread communication is achieved using `wait()`, `notify()`, and `notifyAll()`.**  
 ✔ **Deadlocks occur when multiple threads hold locks in an inconsistent order.**

---

## Part 3 | Thread Joining, Daemon Thread, and Thread Priority

---

1\. Thread Joining in Java (`join()` Method)

In Java, the `join()` method allows one thread to **wait for another thread to finish execution** before continuing.

1.1 Basic Example of `join()`

java

CopyEdit

`class MyThread extends Thread {`

    `public void run() {`

        `for (int i = 1; i <= 5; i++) {`

            `System.out.println(Thread.currentThread().getName() + " - " + i);`

            `try {`

                `Thread.sleep(500); // Simulating some work`

            `} catch (InterruptedException e) {`

                `e.printStackTrace();`

            `}`

        `}`

    `}`

    `public static void main(String[] args) throws InterruptedException {`

        `MyThread t1 = new MyThread();`

        `MyThread t2 = new MyThread();`

        `t1.start();`

        `t1.join();  // Main thread waits until t1 finishes`

        `t2.start();`

        `t2.join();  // Main thread waits until t2 finishes`

        `System.out.println("Main thread execution completed!");`

    `}`

`}`

Explanation

✔ `join()` makes the calling thread **wait** until the target thread completes.  
 ✔ **Without `join()`**, threads may run in unpredictable order.  
 ✔ Can use `join(time_in_ms)` to wait for a fixed time.

1.2 Using `join(time_in_ms)`

java

CopyEdit

`t1.join(1000); // Main thread waits for 1 second or until t1 finishes`

---

2\. Daemon Threads in Java

A **Daemon Thread** is a background thread that **runs indefinitely** but automatically terminates when all user threads finish execution.

2.1 Creating a Daemon Thread

java

CopyEdit

`class DaemonThreadExample extends Thread {`

    `public void run() {`

        `while (true) {`

            `System.out.println("Daemon Thread running...");`

            `try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }`

        `}`

    `}`

    `public static void main(String[] args) {`

        `DaemonThreadExample daemon = new DaemonThreadExample();`

        `daemon.setDaemon(true); // Setting the thread as Daemon`

        `daemon.start();`

        `try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }`

        `System.out.println("Main thread finished execution!");`

    `}`

`}`

Explanation

✔ **Set daemon mode using `setDaemon(true)`** before `start()`.  
 ✔ **Daemon threads run in the background**, usually for tasks like garbage collection, log monitoring, etc.  
 ✔ If all user threads finish, **daemon threads terminate automatically**.

2.2 Key Differences Between User & Daemon Threads

| User Thread | Daemon Thread |
| ----- | ----- |
| Runs until execution is completed | Terminates when all user threads finish |
| Used for main application logic | Used for background tasks (e.g., garbage collection) |
| Does not stop automatically | Stops automatically when JVM exits |

---

3\. Thread Priority in Java

Every thread in Java has a **priority between 1 and 10**:

* **MIN\_PRIORITY \= 1**  
* **NORM\_PRIORITY \= 5 (default)**  
* **MAX\_PRIORITY \= 10**

Threads with **higher priority** get more CPU time, but **scheduling is still OS-dependent**.

3.1 Setting and Getting Thread Priority

java

CopyEdit

`class PriorityExample extends Thread {`

    `public void run() {`

        `System.out.println(Thread.currentThread().getName() + " Priority: " + Thread.currentThread().getPriority());`

    `}`

    `public static void main(String[] args) {`

        `PriorityExample t1 = new PriorityExample();`

        `PriorityExample t2 = new PriorityExample();`

        `PriorityExample t3 = new PriorityExample();`

        `t1.setPriority(Thread.MIN_PRIORITY);  // 1`

        `t2.setPriority(Thread.NORM_PRIORITY); // 5 (default)`

        `t3.setPriority(Thread.MAX_PRIORITY);  // 10`

        `t1.start();`

        `t2.start();`

        `t3.start();`

    `}`

`}`

3.2 Does Priority Guarantee Execution Order?

❌ **No\!** Thread priority **affects scheduling but does not guarantee order**.  
 ✔ **The actual scheduling depends on the OS and JVM.**

---

4\. Summary

✔ `join()` makes a thread **wait until another thread finishes execution**.  
 ✔ **Daemon threads run in the background** and stop automatically when user threads finish.  
 ✔ **Thread priority affects scheduling** but does not guarantee execution order.

---

## Part 4 | Locks and Conditions in Java |(🔒 ReentrantLock, ReadWriteLock, StampedLock, Semaphore)

---

1\. Why Use Locks Instead of `synchronized`?

Java's `synchronized` keyword provides **implicit locking**, but it has limitations:  
 ❌ **Blocking:** A thread acquiring a lock **blocks others** until it releases it.  
 ❌ **No Try-Lock Mechanism:** No way to check if a lock is available before acquiring.  
 ❌ **No Fairness Control:** No guarantee which waiting thread will acquire the lock next.

✅ **Java `Lock` API (java.util.concurrent.locks)** solves these issues by providing **explicit locking with more control**.

---

2\. ReentrantLock (Basic Locking)

A **ReentrantLock** is similar to `synchronized`, but with additional features:  
 ✔ Can attempt to acquire a lock **without blocking (`tryLock()`)**  
 ✔ Supports **fairness policy** (FIFO scheduling)  
 ✔ Allows **interruptible locks**

2.1 ReentrantLock Example

java

CopyEdit

`import java.util.concurrent.locks.*;`

`class SharedResource {`

    `private final ReentrantLock lock = new ReentrantLock();`

    `public void accessResource(String threadName) {`

        `lock.lock();  // Acquire the lock`

        `try {`

            `System.out.println(threadName + " accessing resource...");`

            `Thread.sleep(1000);`

        `} catch (InterruptedException e) {`

            `e.printStackTrace();`

        `} finally {`

            `lock.unlock();  // Release the lock`

        `}`

    `}`

`}`

`class MyThread extends Thread {`

    `SharedResource resource;`

    `MyThread(SharedResource resource, String name) {`

        `super(name);`

        `this.resource = resource;`

    `}`

    `public void run() {`

        `resource.accessResource(Thread.currentThread().getName());`

    `}`

`}`

`public class ReentrantLockExample {`

    `public static void main(String[] args) {`

        `SharedResource resource = new SharedResource();`

        `MyThread t1 = new MyThread(resource, "Thread-1");`

        `MyThread t2 = new MyThread(resource, "Thread-2");`

        `t1.start();`

        `t2.start();`

    `}`

`}`

🔹 **Key Features:**  
 ✔ **Explicit Locking** → `lock.lock()` and `lock.unlock()`  
 ✔ **Ensures only one thread enters the critical section**  
 ✔ **Supports fairness:** `new ReentrantLock(true)` enables FIFO order

---

3\. ReadWriteLock (Optimized for Read-Heavy Operations)

A **ReadWriteLock** allows multiple **readers** at the same time, but only **one writer**.  
 Useful in scenarios where **read operations are frequent but writes are rare**.

3.1 ReadWriteLock Example

java

CopyEdit

`import java.util.concurrent.locks.*;`

`class SharedData {`

    `private final ReadWriteLock lock = new ReentrantReadWriteLock();`

    `private int data = 0;`

    `public void readData(String threadName) {`

        `lock.readLock().lock();`

        `try {`

            `System.out.println(threadName + " reading data: " + data);`

            `Thread.sleep(500);`

        `} catch (InterruptedException e) {`

            `e.printStackTrace();`

        `} finally {`

            `lock.readLock().unlock();`

        `}`

    `}`

    `public void writeData(String threadName, int value) {`

        `lock.writeLock().lock();`

        `try {`

            `System.out.println(threadName + " writing data: " + value);`

            `data = value;`

            `Thread.sleep(500);`

        `} catch (InterruptedException e) {`

            `e.printStackTrace();`

        `} finally {`

            `lock.writeLock().unlock();`

        `}`

    `}`

`}`

`public class ReadWriteLockExample {`

    `public static void main(String[] args) {`

        `SharedData resource = new SharedData();`

        `// Multiple readers`

        `new Thread(() -> resource.readData("Reader-1")).start();`

        `new Thread(() -> resource.readData("Reader-2")).start();`

        

        `// Single writer`

        `new Thread(() -> resource.writeData("Writer", 100)).start();`

    `}`

`}`

🔹 **Key Features:**  
 ✔ **Multiple threads can read at the same time (`readLock()`)**  
 ✔ **Only one thread can write at a time (`writeLock()`)**  
 ✔ **Improves performance for read-heavy applications**

---

4\. StampedLock (Improved ReadWriteLock)

StampedLock is an **advanced version of ReadWriteLock**, optimized for performance:  
 ✔ Supports **optimistic reading** (does not block writers if data is unchanged)  
 ✔ **More efficient than ReadWriteLock** in high-performance applications

4.1 StampedLock Example

java

CopyEdit

`import java.util.concurrent.locks.*;`

`class SharedStampedData {`

    `private final StampedLock lock = new StampedLock();`

    `private int data = 0;`

    `public void readData(String threadName) {`

        `long stamp = lock.tryOptimisticRead();`

        `int readValue = data;`

        `if (!lock.validate(stamp)) {  // Check if the value changed`

            `stamp = lock.readLock();`

            `try { readValue = data; } finally { lock.unlockRead(stamp); }`

        `}`

        `System.out.println(threadName + " read: " + readValue);`

    `}`

    `public void writeData(String threadName, int value) {`

        `long stamp = lock.writeLock();`

        `try {`

            `data = value;`

            `System.out.println(threadName + " wrote: " + value);`

        `} finally {`

            `lock.unlockWrite(stamp);`

        `}`

    `}`

`}`

`public class StampedLockExample {`

    `public static void main(String[] args) {`

        `SharedStampedData resource = new SharedStampedData();`

        `new Thread(() -> resource.readData("Reader-1")).start();`

        `new Thread(() -> resource.writeData("Writer", 200)).start();`

    `}`

`}`

🔹 **Key Features:**  
 ✔ **Optimistic Read → Faster than normal `readLock()`**  
 ✔ **Good for scenarios where reads are frequent and writes are rare**

---

5\. Semaphore (Thread Synchronization Control)

A **Semaphore** is used to control the number of threads that can access a resource simultaneously.

5.1 Semaphore Example

java

CopyEdit

`import java.util.concurrent.*;`

`class SharedPrinter {`

    `private final Semaphore semaphore = new Semaphore(2); // Only 2 threads can access at a time`

    `public void print(String threadName) {`

        `try {`

            `semaphore.acquire();  // Acquire a permit`

            `System.out.println(threadName + " is printing...");`

            `Thread.sleep(1000);`

        `} catch (InterruptedException e) {`

            `e.printStackTrace();`

        `} finally {`

            `System.out.println(threadName + " finished printing.");`

            `semaphore.release();  // Release the permit`

        `}`

    `}`

`}`

`public class SemaphoreExample {`

    `public static void main(String[] args) {`

        `SharedPrinter printer = new SharedPrinter();`

        `for (int i = 1; i <= 5; i++) {`

            `final int id = i;`

            `new Thread(() -> printer.print("Thread-" + id)).start();`

        `}`

    `}`

`}`

🔹 **Key Features:**  
 ✔ **Limits concurrent access to a resource**  
 ✔ **Prevents too many threads from using a shared resource at the same time**

---

6\. Summary

| Lock Type | Best Use Case | Key Features |
| ----- | ----- | ----- |
| **ReentrantLock** | General synchronization | `lock()` & `unlock()`, fairness policy |
| **ReadWriteLock** | Read-heavy applications | `readLock()` (multiple), `writeLock()` (one at a time) |
| **StampedLock** | Optimized read-heavy apps | Optimistic reading (faster), `validate()` method |
| **Semaphore** | Limit concurrent access | Controls no. of threads accessing a resource |

---

## Part 5 | Lock-Free Concurrency, Compare-and-Swap, Atomic & Volatile Variables

Lock-based synchronization mechanisms (e.g., `synchronized`, `ReentrantLock`) can cause **performance issues** due to blocking and context switching. **Lock-free concurrency** techniques help improve efficiency by avoiding traditional locks.

---

1\. Volatile Variables in Java

🔹 **What is `volatile`?**  
 A `volatile` variable in Java **ensures visibility** of updates across threads **but does not provide atomicity**.

1.1 Problem Without `volatile` (Visibility Issue)

java

CopyEdit

`class SharedResource {`

    `private boolean flag = false; // Not volatile`

    `public void setFlag() {`

        `flag = true;`

    `}`

    `public boolean getFlag() {`

        `return flag;`

    `}`

`}`

`public class VolatileIssueExample {`

    `public static void main(String[] args) {`

        `SharedResource resource = new SharedResource();`

        `new Thread(() -> {`

            `while (!resource.getFlag()) { }  // Loop may not exit due to caching`

            `System.out.println("Flag detected as true!");`

        `}).start();`

        `try { Thread.sleep(2000); } catch (InterruptedException e) { }`

        `resource.setFlag();  // Another thread updates flag`

    `}`

`}`

🔹 **Why is there a problem?**  
 ✔ The **JVM may cache** the `flag` variable, and other threads may **not see updates immediately**.

1.2 Using `volatile` to Fix the Issue

java

CopyEdit

`class SharedResource {`

    `private volatile boolean flag = false; // Volatile ensures visibility`

    `public void setFlag() {`

        `flag = true;`

    `}`

    `public boolean getFlag() {`

        `return flag;`

    `}`

`}`

✔ **Ensures all threads see the latest value of `flag`**.  
 ❌ **Does NOT guarantee atomicity for compound actions (`flag++` is NOT atomic\!).**

---

2\. Compare-And-Swap (CAS) & Atomic Variables

2.1 What is CAS?

CAS (**Compare-And-Swap**) is a **lock-free** technique that:  
 1️⃣ Reads a value from memory.  
 2️⃣ Compares it with an expected value.  
 3️⃣ If the value is unchanged, updates it.  
 4️⃣ If changed, retries the operation.

🔹 Used in **Java’s `java.util.concurrent.atomic` package** to provide **atomic operations without locking**.

---

3\. Atomic Variables (Using `java.util.concurrent.atomic` Package)

Java provides **Atomic classes** to perform atomic operations using **CAS instead of locks**.

3.1 AtomicInteger Example

java

CopyEdit

`import java.util.concurrent.atomic.*;`

`class AtomicCounter {`

    `private AtomicInteger count = new AtomicInteger(0);`

    `public void increment() {`

        `count.incrementAndGet(); // Atomic operation`

    `}`

    `public int getValue() {`

        `return count.get();`

    `}`

`}`

`public class AtomicExample {`

    `public static void main(String[] args) {`

        `AtomicCounter counter = new AtomicCounter();`

        `Runnable task = () -> {`

            `for (int i = 0; i < 1000; i++) {`

                `counter.increment();`

            `}`

        `};`

        `Thread t1 = new Thread(task);`

        `Thread t2 = new Thread(task);`

        `t1.start();`

        `t2.start();`

        `try {`

            `t1.join();`

            `t2.join();`

        `} catch (InterruptedException e) { e.printStackTrace(); }`

        `System.out.println("Final count: " + counter.getValue()); // Always 2000`

    `}`

`}`

✔ **Ensures thread safety without using `synchronized` or `ReentrantLock`**.

---

4\. Other Atomic Classes in Java

| Atomic Class | Description |
| ----- | ----- |
| `AtomicInteger` | Integer with atomic operations (`incrementAndGet()`, `decrementAndGet()`) |
| `AtomicLong` | Long type atomic operations |
| `AtomicBoolean` | Boolean type atomic operations |
| `AtomicReference<V>` | Atomic operations for an object reference |

4.1 AtomicReference Example

java

CopyEdit

`import java.util.concurrent.atomic.*;`

`class SharedData {`

    `private AtomicReference<String> message = new AtomicReference<>("Hello");`

    `public void updateMessage(String newMsg) {`

        `message.set(newMsg);`

    `}`

    `public String getMessage() {`

        `return message.get();`

    `}`

`}`

`public class AtomicReferenceExample {`

    `public static void main(String[] args) {`

        `SharedData data = new SharedData();`

        `new Thread(() -> data.updateMessage("New Message")).start();`

        `new Thread(() -> System.out.println("Message: " + data.getMessage())).start();`

    `}`

`}`

✔ **Ensures safe updates to an object reference in multithreading**.

---

5\. CAS (Compare-And-Swap) in Action

5.1 Using `compareAndSet()`

java

CopyEdit

`import java.util.concurrent.atomic.*;`

`class CASCounter {`

    `private AtomicInteger count = new AtomicInteger(0);`

    `public void safeIncrement() {`

        `int oldValue, newValue;`

        `do {`

            `oldValue = count.get();  // Read current value`

            `newValue = oldValue + 1; // Calculate new value`

        `} while (!count.compareAndSet(oldValue, newValue)); // If unchanged, update`

    `}`

    `public int getValue() {`

        `return count.get();`

    `}`

`}`

`public class CASExample {`

    `public static void main(String[] args) {`

        `CASCounter counter = new CASCounter();`

        `Runnable task = () -> {`

            `for (int i = 0; i < 1000; i++) {`

                `counter.safeIncrement();`

            `}`

        `};`

        `Thread t1 = new Thread(task);`

        `Thread t2 = new Thread(task);`

        `t1.start();`

        `t2.start();`

        `try {`

            `t1.join();`

            `t2.join();`

        `} catch (InterruptedException e) { e.printStackTrace(); }`

        `System.out.println("Final count: " + counter.getValue()); // Always 2000`

    `}`

`}`

🔹 **How it works:**  
 ✔ **Reads value, calculates new value, then swaps if no other thread modified it.**  
 ✔ **Retry mechanism** if another thread modified the value before the update.

---

6\. Summary

| Concept | Usage | Provides Thread Safety? |
| ----- | ----- | ----- |
| `volatile` | Ensures visibility across threads | ✅ Yes (but NOT atomicity) |
| `AtomicInteger` | Atomic operations for integers | ✅ Yes (via CAS) |
| `AtomicReference` | Atomic updates for objects | ✅ Yes (via CAS) |
| `compareAndSet()` | Lock-free atomic update mechanism | ✅ Yes (via CAS) |

---

## Part 6 | Thread Pools in Java | ThreadPoolExecutor Framework

Thread creation is **expensive**, especially in applications requiring frequent task execution. Instead of creating a new thread each time, we use **Thread Pools**, which manage a fixed number of reusable threads.

---

1\. What is a Thread Pool?

A **Thread Pool** is a pool of pre-instantiated, reusable threads that execute tasks, improving **performance** and **resource management**.

🔹 **Advantages of Thread Pools:**  
 ✔ Reduces overhead of creating/destroying threads.  
 ✔ Optimizes CPU utilization.  
 ✔ Prevents system resource exhaustion.  
 ✔ Efficient task execution by managing concurrent threads.

---

2\. Creating Thread Pools in Java

Java provides the `ExecutorService` interface and `ThreadPoolExecutor` class to manage thread pools.

2.1 Creating a Thread Pool using `Executors`

Java provides a factory class `Executors` to create different types of thread pools.

java

CopyEdit

`import java.util.concurrent.*;`

`public class FixedThreadPoolExample {`

    `public static void main(String[] args) {`

        `ExecutorService executor = Executors.newFixedThreadPool(3); // Pool of 3 threads`

        `for (int i = 1; i <= 5; i++) {`

            `final int taskId = i;`

            `executor.submit(() -> {`

                `System.out.println("Executing Task " + taskId + " by " + Thread.currentThread().getName());`

                `try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }`

            `});`

        `}`

        `executor.shutdown(); // Shutdown the pool after task execution`

    `}`

`}`

Output Example  
arduino

CopyEdit

`Executing Task 1 by pool-1-thread-1`

`Executing Task 2 by pool-1-thread-2`

`Executing Task 3 by pool-1-thread-3`

`Executing Task 4 by pool-1-thread-1`

`Executing Task 5 by pool-1-thread-2`

🔹 **How it works?**

* **Creates a thread pool of size 3\.**  
* **Executes 5 tasks using available threads.**  
* **Reuses threads when a task is completed.**

---

3\. Types of Thread Pools in Java (`Executors` Factory Methods)

| Method | Description |
| ----- | ----- |
| `Executors.newFixedThreadPool(n)` | Fixed-size thread pool with `n` threads. |
| `Executors.newCachedThreadPool()` | Creates threads dynamically as needed but reuses idle threads. |
| `Executors.newSingleThreadExecutor()` | Single-threaded executor (executes tasks sequentially). |
| `Executors.newScheduledThreadPool(n)` | Fixed-size pool for scheduled tasks (like `cron` jobs). |

3.1 `newCachedThreadPool()` Example (Dynamic Thread Management)  
java

CopyEdit

`ExecutorService executor = Executors.newCachedThreadPool();`

✔ Creates threads as needed, but **reuses idle threads** for new tasks.  
 ✔ Suitable for **short-lived, high-volume tasks**.

---

4\. ThreadPoolExecutor \- Custom Thread Pool

For **fine-grained control**, use `ThreadPoolExecutor` instead of `Executors`.

java

CopyEdit

`import java.util.concurrent.*;`

`public class CustomThreadPool {`

    `public static void main(String[] args) {`

        `ThreadPoolExecutor executor = new ThreadPoolExecutor(`

            `2,  // Core pool size`

            `4,  // Maximum pool size`

            `60, // Time before excess idle threads are terminated`

            `TimeUnit.SECONDS,`

            `new LinkedBlockingQueue<>(2) // Task queue (capacity 2)`

        `);`

        `for (int i = 1; i <= 6; i++) {`

            `final int taskId = i;`

            `executor.execute(() -> {`

                `System.out.println("Executing Task " + taskId + " by " + Thread.currentThread().getName());`

                `try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }`

            `});`

        `}`

        `executor.shutdown();`

    `}`

`}`

🔹 **Key Parameters:**

* `corePoolSize`: Minimum number of threads in the pool.  
* `maximumPoolSize`: Maximum number of threads.  
* `keepAliveTime`: Time an idle thread waits before termination.  
* `BlockingQueue<Runnable>`: Task queue for holding tasks before execution.

---

5\. Handling Task Rejections (`RejectedExecutionHandler`)

If a thread pool’s task queue is full, tasks **may be rejected**.  
 Java provides `RejectedExecutionHandler` to define custom rejection handling.

5.1 Example: Custom Rejection Policy  
java

CopyEdit

`class CustomRejectionHandler implements RejectedExecutionHandler {`

    `@Override`

    `public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {`

        `System.out.println("Task rejected: " + r.toString());`

    `}`

`}`

`public class RejectedExecutionExample {`

    `public static void main(String[] args) {`

        `ThreadPoolExecutor executor = new ThreadPoolExecutor(`

            `2, 2, 0L, TimeUnit.MILLISECONDS,`

            `new ArrayBlockingQueue<>(2), // Small queue (2 tasks)`

            `new CustomRejectionHandler()`

        `);`

        `for (int i = 1; i <= 5; i++) {`

            `final int taskId = i;`

            `executor.execute(() -> {`

                `System.out.println("Executing Task " + taskId + " by " + Thread.currentThread().getName());`

                `try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }`

            `});`

        `}`

        `executor.shutdown();`

    `}`

`}`

✔ **Custom handler logs rejected tasks.**

---

6\. Scheduled Thread Pool (`ScheduledThreadPoolExecutor`)

For tasks that need to be **executed periodically**, use `ScheduledThreadPoolExecutor`.

6.1 Example: Scheduling a Task  
java

CopyEdit

`import java.util.concurrent.*;`

`public class ScheduledThreadPoolExample {`

    `public static void main(String[] args) {`

        `ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);`

        `Runnable task = () -> System.out.println("Scheduled Task Executed: " + System.currentTimeMillis());`

        

        `// Execute task after an initial delay of 2 seconds, then every 3 seconds`

        `scheduler.scheduleAtFixedRate(task, 2, 3, TimeUnit.SECONDS);`

        `// Stop after 10 seconds`

        `try { Thread.sleep(10000); } catch (InterruptedException e) { e.printStackTrace(); }`

        `scheduler.shutdown();`

    `}`

`}`

🔹 **Use Cases:**  
 ✔ Running **cron jobs** (e.g., **data backups, log rotation**).  
 ✔ **Polling external APIs** periodically.

---

7\. Summary

| Feature | FixedThreadPool | CachedThreadPool | ScheduledThreadPool | SingleThreadExecutor |
| ----- | ----- | ----- | ----- | ----- |
| **Thread Count** | Fixed (`n` threads) | Dynamic (grows/shrinks as needed) | Fixed (`n` threads) | Single thread |
| **Task Execution** | Handles multiple tasks concurrently | Reuses existing threads | Executes tasks with delay or at fixed rate | One task at a time |
| **Use Case** | Fixed workload | High volume short tasks | Periodic tasks | Sequential execution |

---

8\. Key Takeaways

✅ Use `ExecutorService` instead of manually creating threads.  
 ✅ Choose the right thread pool based on workload:

* **FixedThreadPool**: Constant number of threads.  
* **CachedThreadPool**: Scales dynamically.  
* **ScheduledThreadPool**: Periodic tasks.  
* **SingleThreadExecutor**: One thread execution.  
   ✅ Use `ThreadPoolExecutor` for **fine-grained control**.  
   ✅ Handle **task rejections** using `RejectedExecutionHandler`.

---

## Part 7 | Java 8 CompletableFuture | Future and Callable in Java

---

1\. Introduction to Asynchronous Programming in Java

In Java, when a task takes a long time (e.g., I/O operations, API calls), executing it **synchronously** (blocking the main thread) can degrade performance.

To solve this, Java provides:  
 ✔ **Future and Callable** (Java 5\) – Basic async tasks.  
 ✔ **CompletableFuture** (Java 8\) – Advanced async programming.

---

2\. Future and Callable (Java 5\)

Java introduced **Callable** and **Future** in Java 5 to execute tasks asynchronously and get results.

2.1 Callable Interface

* `Callable<V>` is like `Runnable`, but **returns a result** and **can throw checked exceptions**.  
* Used with `ExecutorService.submit()`, which returns a `Future<V>` object.

java

CopyEdit

`import java.util.concurrent.*;`

`public class CallableExample {`

    `public static void main(String[] args) throws Exception {`

        `ExecutorService executor = Executors.newFixedThreadPool(2);`

        `Callable<Integer> task = () -> {`

            `System.out.println("Task started by " + Thread.currentThread().getName());`

            `Thread.sleep(2000); // Simulate delay`

            `return 42;`

        `};`

        `Future<Integer> future = executor.submit(task); // Submit callable task`

        `System.out.println("Doing other work while waiting...");`

        `Integer result = future.get(); // Blocks until result is available`

        `System.out.println("Result: " + result);`

        `executor.shutdown();`

    `}`

`}`

Output

arduino

CopyEdit

`Doing other work while waiting...`

`Task started by pool-1-thread-1`

`Result: 42`

🔹 **Limitations of Future**  
 ❌ **Blocking** (`future.get()` blocks execution).  
 ❌ No **chaining** (hard to combine multiple tasks).  
 ❌ Cannot **manually complete** a `Future`.

---

3\. CompletableFuture (Java 8\)

Java 8 introduced `CompletableFuture` to **overcome Future's limitations** by providing:  
 ✔ **Non-blocking programming** (`thenApply`, `thenAccept`).  
 ✔ **Chaining multiple tasks** (`thenCompose`, `thenCombine`).  
 ✔ **Combining multiple futures** (`allOf`, `anyOf`).

3.1 Creating a CompletableFuture

java

CopyEdit

`import java.util.concurrent.*;`

`public class CompletableFutureExample {`

    `public static void main(String[] args) throws Exception {`

        `CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {`

            `System.out.println("Task started by " + Thread.currentThread().getName());`

            `try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }`

            `return 42;`

        `});`

        `System.out.println("Doing other work...");`

        `Integer result = future.get(); // Blocking`

        `System.out.println("Result: " + result);`

    `}`

`}`

Output

vbnet

CopyEdit

`Doing other work...`

`Task started by ForkJoinPool.commonPool-worker-1`

`Result: 42`

🔹 **Key Features:**

* `supplyAsync()` → Runs task asynchronously and returns a `CompletableFuture<V>`.  
* Uses **ForkJoinPool** (default pool) but can be customized.

---

4\. Chaining Async Calls (`thenApply`, `thenAccept`)

Instead of blocking, use **chaining**.

java

CopyEdit

`CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10)`

        `.thenApply(num -> num * 2) // Transforms result (10 → 20)`

        `.thenApply(num -> num + 5); // 20 → 25`

`System.out.println("Result: " + future.get()); // 25`

🔹 **Methods:**  
 ✔ `thenApply(fn)` → Transforms result.  
 ✔ `thenAccept(consumer)` → Consumes result without returning anything.

---

5\. Combining Multiple Futures

5.1 `thenCompose()` (Dependent Async Calls)

When one async task **depends** on another.

java

CopyEdit

`CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10)`

        `.thenCompose(num -> CompletableFuture.supplyAsync(() -> num * 2));`

`System.out.println("Result: " + future.get()); // 20`

✔ **Use when the second task depends on the first one.**

---

5.2 `thenCombine()` (Independent Async Calls)

When two independent tasks **need to be combined**.

java

CopyEdit

`CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);`

`CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);`

`CompletableFuture<Integer> result = future1.thenCombine(future2, Integer::sum);`

`System.out.println("Result: " + result.get()); // 30`

✔ **Use when both tasks run independently but need a combined result.**

---

6\. Running Multiple Futures in Parallel

6.1 `allOf()` (Wait for All Futures)

java

CopyEdit

`CompletableFuture<Void> allFutures = CompletableFuture.allOf(`

    `CompletableFuture.runAsync(() -> System.out.println("Task 1")),`

    `CompletableFuture.runAsync(() -> System.out.println("Task 2"))`

`);`

`allFutures.get(); // Blocks until all tasks finish`

✔ Used when all futures **must complete before proceeding**.

---

6.2 `anyOf()` (Wait for First Completed Future)

java

CopyEdit

`CompletableFuture<Object> firstDone = CompletableFuture.anyOf(`

    `CompletableFuture.supplyAsync(() -> "Task A"),`

    `CompletableFuture.supplyAsync(() -> "Task B")`

`);`

`System.out.println("First completed: " + firstDone.get());`

✔ Returns **result of the first completed future**.

---

7\. Exception Handling in CompletableFuture

Use `exceptionally()` or `handle()` to catch exceptions.

java

CopyEdit

`CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {`

    `if (true) throw new RuntimeException("Error occurred!");`

    `return 10;`

`}).exceptionally(ex -> {`

    `System.out.println("Exception: " + ex.getMessage());`

    `return 0;`

`});`

`System.out.println("Result: " + future.get()); // 0`

✔ `exceptionally()` → Handles exceptions and **provides a fallback value**.

---

8\. Custom Thread Pool in CompletableFuture

By default, `CompletableFuture` uses **ForkJoinPool**.  
 To use a **custom thread pool**, provide an `ExecutorService`.

java

CopyEdit

`ExecutorService executor = Executors.newFixedThreadPool(3);`

`CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {`

    `System.out.println("Running in: " + Thread.currentThread().getName());`

    `return 42;`

`}, executor);`

`System.out.println("Result: " + future.get());`

`executor.shutdown();`

✔ Ensures **better control over threading**.

---

9\. Summary

| Feature | Future & Callable | CompletableFuture |
| ----- | ----- | ----- |
| Async Execution | ✅ Yes | ✅ Yes |
| Blocking | ❌ Yes (`future.get()`) | ✅ Non-blocking (`thenApply`, `thenAccept`) |
| Task Chaining | ❌ No | ✅ Yes (`thenCompose`, `thenCombine`) |
| Multiple Futures | ❌ No | ✅ Yes (`allOf`, `anyOf`) |
| Exception Handling | ❌ No | ✅ Yes (`exceptionally`, `handle`) |

✅ **Use `Future` for basic async tasks.**  
 ✅ **Use `CompletableFuture` for advanced, non-blocking programming.**

---

## Java Thread Pools and ForkJoinPool

1\. Introduction to Thread Pools

Thread pools are used to efficiently manage and reuse a fixed number of worker threads instead of creating and destroying threads manually.

Why Use Thread Pools?

✔ **Improves performance** by reusing threads.  
 ✔ **Reduces resource consumption** by avoiding frequent thread creation/destruction.  
 ✔ **Prevents system overload** by limiting the number of concurrent threads.  
 ✔ **Efficient task scheduling** and management.

---

2\. Types of Thread Pools in Java (`ExecutorService`)

Java provides various thread pools using `Executors` class:

2.1 FixedThreadPool

* **Fixed number of threads** (best for predictable workloads).  
* **If all threads are busy, tasks wait in a queue** until a thread is available.

Example

java

CopyEdit

`import java.util.concurrent.*;`

`public class FixedThreadPoolExample {`

    `public static void main(String[] args) {`

        `ExecutorService executor = Executors.newFixedThreadPool(3); // 3 threads`

        `for (int i = 1; i <= 5; i++) {`

            `final int taskId = i;`

            `executor.submit(() -> {`

                `System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());`

            `});`

        `}`

        `executor.shutdown(); // Shutdown the executor`

    `}`

`}`

🔹 **Use Case:** Best for CPU-bound tasks (fixed worker threads).

---

2.2 CachedThreadPool

* **Creates new threads as needed but reuses old ones**.  
* **Unused threads are terminated after 60 seconds**.  
* **Best for short-lived tasks with varying workloads**.

Example

java

CopyEdit

`ExecutorService executor = Executors.newCachedThreadPool();`

`for (int i = 1; i <= 5; i++) {`

    `final int taskId = i;`

    `executor.submit(() -> System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName()));`

`}`

`executor.shutdown();`

🔹 **Use Case:** Best for **I/O-bound tasks** where task execution time varies.

---

2.3 SingleThreadExecutor

* **Only one thread** to execute tasks sequentially.  
* **Ensures task execution order is maintained**.

Example

java

CopyEdit

`ExecutorService executor = Executors.newSingleThreadExecutor();`

`for (int i = 1; i <= 5; i++) {`

    `final int taskId = i;`

    `executor.submit(() -> System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName()));`

`}`

`executor.shutdown();`

🔹 **Use Case:** Best for tasks that must be executed sequentially (e.g., logging, database writes).

---

2.4 ScheduledThreadPool

* **Executes tasks after a delay or at fixed intervals**.  
* **Best for scheduling periodic tasks (like Cron jobs)**.

Example

java

CopyEdit

`ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);`

`executor.schedule(() -> System.out.println("Task executed after 3 seconds"), 3, TimeUnit.SECONDS);`

`executor.shutdown();`

🔹 **Use Case:** Best for **periodic and delayed tasks** (e.g., sending reminders, polling services).

---

3\. ForkJoinPool (Work-Stealing Pool)

Java 7 introduced **ForkJoinPool** to efficiently execute **divide-and-conquer** tasks using **work-stealing**.

3.1 How ForkJoinPool Works?

✔ Uses **multiple worker threads (parallelism)**.  
 ✔ **Divides large tasks into smaller sub-tasks**.  
 ✔ **Idle threads "steal" uncompleted tasks** from busy threads.

---

3.2 ForkJoin Example

Example: Sum of an Array using ForkJoinPool

java

CopyEdit

`import java.util.concurrent.*;`

`class SumTask extends RecursiveTask<Integer> {`

    `private final int[] array;`

    `private final int start, end;`

    `public SumTask(int[] array, int start, int end) {`

        `this.array = array;`

        `this.start = start;`

        `this.end = end;`

    `}`

    `@Override`

    `protected Integer compute() {`

        `if (end - start <= 2) { // Base case`

            `int sum = 0;`

            `for (int i = start; i < end; i++) sum += array[i];`

            `return sum;`

        `}`

        

        `int mid = (start + end) / 2;`

        `SumTask leftTask = new SumTask(array, start, mid);`

        `SumTask rightTask = new SumTask(array, mid, end);`

        `leftTask.fork(); // Execute left task asynchronously`

        `int rightResult = rightTask.compute(); // Compute right task synchronously`

        `int leftResult = leftTask.join(); // Wait for left task result`

        `return leftResult + rightResult;`

    `}`

`}`

`public class ForkJoinExample {`

    `public static void main(String[] args) {`

        `ForkJoinPool pool = new ForkJoinPool();`

        `int[] array = {1, 2, 3, 4, 5, 6, 7, 8};`

        `SumTask task = new SumTask(array, 0, array.length);`

        `int result = pool.invoke(task);`

        `System.out.println("Total Sum: " + result);`

    `}`

`}`

🔹 **Output:**

mathematica

CopyEdit

`Total Sum: 36`

✔ ForkJoinPool automatically **distributes work across available processors**.  
 ✔ Uses **RecursiveTask** for returning results and **RecursiveAction** for void tasks.

---

4\. WorkStealingPool

* Java 8 introduced `Executors.newWorkStealingPool()`, which internally uses **ForkJoinPool**.  
* **Efficiently balances work** among threads by **stealing** unfinished tasks.  
* Uses **parallelism based on available CPU cores**.

Example

java

CopyEdit

`ExecutorService executor = Executors.newWorkStealingPool();`

`for (int i = 1; i <= 5; i++) {`

    `final int taskId = i;`

    `executor.submit(() -> System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName()));`

`}`

`executor.shutdown();`

🔹 **Use Case:** Best for **parallel processing of independent tasks**.

---

5\. Comparing Thread Pools

| Pool Type | Thread Management | Best For |
| ----- | ----- | ----- |
| **FixedThreadPool** | Fixed-size threads | CPU-bound tasks |
| **CachedThreadPool** | Creates new threads as needed | I/O-bound tasks |
| **SingleThreadExecutor** | One thread, sequential execution | Tasks that must run in order |
| **ScheduledThreadPool** | Scheduled execution of tasks | Timers, cron jobs |
| **ForkJoinPool** | Work-stealing, divides tasks | Parallel processing |
| **WorkStealingPool** | Work-stealing using ForkJoinPool | Large task distribution |

---

6\. Conclusion

✅ **Use `FixedThreadPool` for predictable workloads**.  
 ✅ **Use `CachedThreadPool` for unpredictable workloads**.  
 ✅ **Use `SingleThreadExecutor` for sequential execution**.  
 ✅ **Use `ScheduledThreadPool` for periodic tasks**.  
 ✅ **Use `ForkJoinPool` for parallel processing**.  
 ✅ **Use `WorkStealingPool` for dynamic task distribution**.

---

## Java ScheduledThreadPoolExecutor and Thread Termination

1\. Introduction to ScheduledThreadPoolExecutor

`ScheduledThreadPoolExecutor` is a specialized thread pool that allows scheduling tasks **at a fixed rate, after a delay, or periodically**.

🔹 **Main Features:**  
 ✔ Executes **one-time** tasks after a delay.  
 ✔ Executes **periodic** tasks at **fixed rate** or **fixed delay**.  
 ✔ Supports **graceful shutdown** with `shutdown()` and `awaitTermination()`.

---

2\. Creating a ScheduledThreadPoolExecutor

Use **`Executors.newScheduledThreadPool()`** to create a pool with a fixed number of threads.

java

CopyEdit

`import java.util.concurrent.*;`

`public class ScheduledThreadPoolExample {`

    `public static void main(String[] args) {`

        `ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);`

        `Runnable task = () -> System.out.println("Executing task at " + System.currentTimeMillis());`

        `// Schedule task to run after 3 seconds`

        `scheduler.schedule(task, 3, TimeUnit.SECONDS);`

        `scheduler.shutdown();`

    `}`

`}`

🔹 **Output:**

scss

CopyEdit

`Executing task at 1710349423000 (timestamp)`

---

3\. Scheduling Periodic Tasks

3.1 scheduleAtFixedRate()

Executes a task **at a fixed rate** (start time is constant).

java

CopyEdit

`scheduler.scheduleAtFixedRate(task, 1, 3, TimeUnit.SECONDS);`

🔹 **Behavior:**

* Executes every **3 seconds** after initial **1-second delay**.  
* If a task takes longer than the interval, **next execution starts immediately**.

---

3.2 scheduleWithFixedDelay()

Executes a task **after a fixed delay** between the **end of one execution and the start of the next**.

java

CopyEdit

`scheduler.scheduleWithFixedDelay(task, 1, 3, TimeUnit.SECONDS);`

🔹 **Behavior:**

* Executes every **3 seconds after previous task completes**.  
* If a task takes longer, **next execution is delayed accordingly**.

---

4\. Shutting Down Thread Pools

4.1 shutdown()

* **Stops accepting new tasks** but allows **running tasks to finish**.  
* Already scheduled tasks **continue executing**.  
* New task submissions throw **RejectedExecutionException**.

java

CopyEdit

`scheduler.shutdown();`

---

4.2 shutdownNow()

* **Attempts to stop all running tasks immediately**.  
* **Returns a list of unexecuted tasks**.  
* **Interrupts worker threads** but does not guarantee instant termination.

java

CopyEdit

`List<Runnable> unexecutedTasks = scheduler.shutdownNow();`

`System.out.println("Unexecuted tasks: " + unexecutedTasks.size());`

---

4.3 awaitTermination()

* **Waits for all tasks to finish execution** before shutting down.  
* If tasks don’t finish within the specified time, it **forcefully terminates the executor**.

java

CopyEdit

`scheduler.shutdown();`

`try {`

    `if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {`

        `scheduler.shutdownNow(); // Force shutdown`

    `}`

`} catch (InterruptedException e) {`

    `scheduler.shutdownNow();`

`}`

---

5\. shutdown() vs shutdownNow() vs awaitTermination()

| Method | What it does? | Can tasks complete? | Accepts new tasks? |
| ----- | ----- | ----- | ----- |
| **shutdown()** | Initiates shutdown, running tasks continue | ✅ Yes | ❌ No |
| **shutdownNow()** | Attempts immediate shutdown, interrupts tasks | ❌ No (may interrupt running tasks) | ❌ No |
| **awaitTermination()** | Waits for termination before proceeding | ✅ Yes (if tasks complete in time) | ❌ No |

---

6\. Complete Example

java

CopyEdit

`import java.util.concurrent.*;`

`public class ScheduledThreadPoolExecutorExample {`

    `public static void main(String[] args) {`

        `ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);`

        `Runnable task = () -> System.out.println("Task executed at " + System.currentTimeMillis());`

        `// Schedule task at fixed rate`

        `scheduler.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);`

        `// Wait 10 seconds before shutting down`

        `try {`

            `Thread.sleep(10000);`

        `} catch (InterruptedException e) {`

            `e.printStackTrace();`

        `}`

        `scheduler.shutdown();`

        `try {`

            `if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {`

                `scheduler.shutdownNow(); // Force shutdown`

            `}`

        `} catch (InterruptedException e) {`

            `scheduler.shutdownNow();`

        `}`

    `}`

`}`

🔹 **Key Takeaways:**  
 ✅ **Use `scheduleAtFixedRate()` for precise scheduling.**  
 ✅ **Use `scheduleWithFixedDelay()` for flexible delays.**  
 ✅ **Use `shutdown()` for graceful shutdown.**  
 ✅ **Use `shutdownNow()` to cancel tasks immediately.**  
 ✅ **Use `awaitTermination()` to wait for completion.**

---

## Java Virtual Threads vs Normal Threads | ThreadLocal in Java

1\. Introduction to Java Virtual Threads (JDK 19/21)

Java **Virtual Threads** (introduced in Java 19 as a preview and finalized in Java 21\) provide lightweight, high-performance concurrency by decoupling **threads from OS threads**.

🔹 **Why Virtual Threads?**  
 ✔ **Reduce memory footprint** (Lower cost per thread).  
 ✔ **Better scalability** (Can create millions of threads).  
 ✔ **Ideal for I/O-bound tasks** (e.g., network calls, database queries).

---

2\. Normal Threads vs Virtual Threads

2.1 Normal Threads (Platform Threads)

✔ **Each Java thread maps to an OS thread** (heavy).  
 ✔ **Context switching is expensive**.  
 ✔ **Good for CPU-bound tasks** but **poor for high-concurrency I/O-bound workloads**.

Example: Normal Thread Creation

java

CopyEdit

`public class NormalThreadExample {`

    `public static void main(String[] args) {`

        `Runnable task = () -> System.out.println("Executed by " + Thread.currentThread());`

        `Thread thread = new Thread(task);`

        `thread.start();`

    `}`

`}`

🔹 **Issues with Normal Threads:**

* Limited number of OS threads.  
* **Blocking I/O** leads to **thread starvation**.  
* **Context switching is expensive**.

---

2.2 Virtual Threads (Java 21\)

✔ **Thousands or millions of Virtual Threads can run on few OS threads**.  
 ✔ **No expensive context switching**.  
 ✔ **Best for I/O-bound applications** (e.g., web servers, microservices).

Example: Creating Virtual Threads

java

CopyEdit

`public class VirtualThreadExample {`

    `public static void main(String[] args) {`

        `Runnable task = () -> System.out.println("Executed by " + Thread.currentThread());`

        `Thread.startVirtualThread(task); // Virtual Thread creation`

    `}`

`}`

✔ Runs **millions of threads without system overhead**.

---

2.3 Benchmark: Creating 100,000 Threads

Using Normal Threads

java

CopyEdit

`public class NormalThreadBenchmark {`

    `public static void main(String[] args) {`

        `for (int i = 0; i < 100000; i++) {`

            `new Thread(() -> {}).start();`

        `}`

    `}`

`}`

🔹 **Issues:**  
 ❌ **High CPU & Memory usage**.  
 ❌ **May crash due to OS thread limits**.

---

Using Virtual Threads

java

CopyEdit

`public class VirtualThreadBenchmark {`

    `public static void main(String[] args) {`

        `for (int i = 0; i < 100000; i++) {`

            `Thread.startVirtualThread(() -> {});`

        `}`

    `}`

`}`

✅ **Runs efficiently with minimal memory usage**.

---

3\. Virtual Threads in ExecutorService

Java 21 introduced **`Executors.newVirtualThreadPerTaskExecutor()`**, which creates an ExecutorService using **virtual threads**.

java

CopyEdit

`ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();`

`for (int i = 0; i < 10000; i++) {`

    `executor.submit(() -> {`

        `System.out.println(Thread.currentThread());`

    `});`

`}`

`executor.shutdown();`

✔ **Perfect for web servers and database calls**.

---

4\. When to Use Normal vs Virtual Threads?

| Feature | Normal Threads | Virtual Threads |
| ----- | ----- | ----- |
| **Best for** | CPU-bound tasks | I/O-bound tasks |
| **Thread per request** | ❌ Not scalable | ✅ Highly scalable |
| **Memory footprint** | High | Low |
| **Context Switching** | Expensive | Cheap |
| **Parallelism** | Uses OS threads | Uses lightweight user-mode threads |

🚀 **Use Virtual Threads for web servers, API calls, microservices, and database queries.**

---

5\. ThreadLocal in Java

`ThreadLocal` is a mechanism that **stores variables per thread**, ensuring **thread safety** without synchronization.

5.1 ThreadLocal Example

java

CopyEdit

`public class ThreadLocalExample {`

    `private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);`

    `public static void main(String[] args) {`

        `Runnable task = () -> {`

            `threadLocal.set((int) (Math.random() * 100));`

            `System.out.println(Thread.currentThread().getName() + " -> " + threadLocal.get());`

        `};`

        `Thread t1 = new Thread(task);`

        `Thread t2 = new Thread(task);`

        `t1.start();`

        `t2.start();`

    `}`

`}`

🔹 **Each thread gets its own independent variable.**

---

5.2 ThreadLocal vs Virtual Threads

`ThreadLocal` **stores variables per thread**, but **Virtual Threads don't retain thread affinity**.

* **Using ThreadLocal in Virtual Threads is discouraged** since virtual threads are reused.

🚀 **Use `ScopedValues` (Java 21\) instead of ThreadLocal in Virtual Threads\!**

---

6\. Summary

| Feature | Normal Threads | Virtual Threads |
| ----- | ----- | ----- |
| **Use Cases** | CPU-bound tasks | I/O-bound tasks |
| **Scalability** | Limited | Millions of threads |
| **Memory Overhead** | High | Low |
| **ThreadLocal Support** | ✅ Yes | ❌ No (Use ScopedValues) |

🚀 **Use Virtual Threads for web servers, database calls, and async processing\!**  
 🔥 **Use ThreadLocal only in traditional threads, not Virtual Threads.**

---

# Lombok Features in Java

Lombok is a Java library that reduces boilerplate code by generating commonly used methods like getters, setters, constructors, etc., during compilation.

---

📌 1\. `val` and `var`

* `val`: Immutable local variable (like `final`)

* `var`: Mutable local variable

* Type is inferred by the compiler.

java

CopyEdit

`val name = "John";  // becomes final String name = "John";`

`var count = 10;     // becomes int count = 10;`

✅ Helps reduce verbosity when declaring variables.

---

📌 2\. `@NonNull`

* Automatically adds null checks in constructors or methods.

* Throws `NullPointerException` if the value is null.

java

CopyEdit

`public class Person {`

    `public Person(@NonNull String name) {`

        `this.name = name;`

    `}`

`}`

✅ Avoids writing manual null checks.

---

📌 3\. `@Getter` and `@Setter`

* Automatically generates getter and setter methods.

java

CopyEdit

`@Getter`

`@Setter`

`private String name;`

* You can annotate at **class level** (for all fields) or **field level**.

✅ Reduces boilerplate method generation.

---

📌 4\. `@ToString`

* Generates a readable `toString()` method.

* Can exclude fields: `@ToString(exclude = "password")`

java

CopyEdit

`@ToString`

`public class User {`

    `private String name;`

    `private String email;`

`}`

---

📌 5\. `@NoArgsConstructor`, `@AllArgsConstructor`, `@RequiredArgsConstructor`

* `@NoArgsConstructor`: No-arg constructor.

* `@AllArgsConstructor`: Constructor with all fields.

* `@RequiredArgsConstructor`: Only `final` or `@NonNull` fields.

java

CopyEdit

`@RequiredArgsConstructor`

`public class Student {`

    `private final String name;`

    `private int age;`

`}`

---

📌 6\. `@EqualsAndHashCode`

* Generates `equals()` and `hashCode()` based on fields.

* Can exclude fields too.

java

CopyEdit

`@EqualsAndHashCode`

`public class Book {`

    `private String title;`

    `private String author;`

`}`

---

📌 7\. `@Data`

* Combines:

  * `@ToString`

  * `@EqualsAndHashCode`

  * `@Getter`/`@Setter`

  * `@RequiredArgsConstructor`

java

CopyEdit

`@Data`

`public class Product {`

    `private final String id;`

    `private String name;`

`}`

✅ Ideal for POJOs.

---

📌 8\. `@Value`

* Immutable version of `@Data`.

* All fields are `private` and `final`.

* No setters generated.

java

CopyEdit

`@Value`

`public class Config {`

    `String host;`

    `int port;`

`}`

---

📌 9\. `@Builder`

* Enables fluent API for object creation.

* Useful for creating immutable or complex objects.

java

CopyEdit

`@Builder`

`public class Order {`

    `private String item;`

    `private int quantity;`

`}`

java

CopyEdit

`Order order = Order.builder().item("Book").quantity(2).build();`

---

📌 10\. `@Cleanup`

* Automatically closes resources like streams, readers, etc.

java

CopyEdit

`@Cleanup InputStream in = new FileInputStream("file.txt");`

✅ Ensures `close()` is called, even in case of exceptions.

---

# Java 17: Sealed Classes and Interfaces

---

🔑 Key Concept

* **Problem before Sealed Classes**:

  * No control over inheritance hierarchy.

  * Any class could implement an interface or extend a class.

  * Leads to unpredictable subclasses, forcing developers to add `default` cases in `switch` or `if-else` handling.

  * Silent code breaks could occur if a new subclass was introduced unintentionally.

* **Solution**: **Sealed Classes & Interfaces (Java 17\)**

  * Introduce `sealed` keyword \+ `permits` clause.

  * Restricts which classes or interfaces can directly extend/implement a type.

  * Provides controlled inheritance.

---

🚀 How It Works

**Syntax Example**:

 `public sealed interface Shape permits Circle, Rectangle {}`

*   
  * `Shape` can only be implemented by `Circle` and `Rectangle`.

  * Any other class (e.g., `Triangle`) is **not allowed**.

---

⚖️ Rules for Subclasses

Every permitted subclass must declare **one of three modifiers**:

**final** → No further subclassing allowed.

 `final class Circle implements Shape {}`

1. 

**sealed** → Can be subclassed, but only by explicitly permitted types.

 `sealed class AbstractShape implements Shape permits Rectangle, Triangle {}`

2. 

**non-sealed** → Open for extension by any number of subclasses.

 `non-sealed interface Polygon extends Shape {}`

3. 

---

📌 Important Conditions

* **Permitted types must be direct subclasses** of the sealed type.

* **Permitted subclasses must declare themselves as final, sealed, or non-sealed**.

* **All permitted subclasses must exist at compile time** (future hypothetical classes not allowed).

---

🧩 Example Hierarchy

`// Sealed Interface`

`public sealed interface Shape permits Circle, Polygon, AbstractShape {}`

`// Circle - No further subclass`

`public final class Circle implements Shape {}`

`// Polygon - Open branch`

`public non-sealed interface Polygon extends Shape {}`

`// AbstractShape - Restricted to Rectangle & Triangle`

`public sealed abstract class AbstractShape implements Shape permits Rectangle, Triangle {}`

`// Rectangle - Closed branch`

`public final class Rectangle extends AbstractShape {}`

`// Triangle - Open branch`

`public non-sealed class Triangle extends AbstractShape {}`

---

✅ Benefits

* Enforces **controlled inheritance**.

* Reduces **unexpected child classes**.

* Improves **readability and maintainability** of code.

* Compiler can perform **exhaustive checks** in `switch` expressions (no need for unnecessary `default`).

---

# Questions

# 

# 

# 

# 

# 

## Bit:

* **\>\>\>** operator is the same as the signed right shift, but the vacant leftmost position is filled with 0 instead of the sign bit.

## Math:

* Random  
  * Random r \= new Random();  
  * int randInd \= r.nextInt(i+1);  
  * int pIndex \= r.nextInt(end-start) \+ start;

## Wrapper Classes:

* Integer.bitCount(num)  
* Integer.compare(6, mid);	//-1, 0, 1

## Arrays:

* Arrays.toString(\<array\>)  
* Arrays.copyOf(\<array\>, \<new len\>)  
* Convert array of strings to arraylist of strings  
  * Arrays.*asList*(str.split("")));  
* Convert array of int to List\<Integer\>  
  * Arrays.*stream*(a).boxed().collect(Collectors.toList());  
* Convert List to Integer\[\]  
  * Integer\[\] arr \= list.toArray(new Integer\[list.size()\]);  
* Convert List to int\[\]  
  * list.stream().mapToInt(i-\>i).toArray();

## Interface:

* All the variables declared in an interface are by default **public static final** even if you don’t specify the public static final.

  interface Interface {

  	String str \= "name";

  }

  public class Test implements Interface {

  	public static void main(String\[\] args) {

  		System.out.println(Interface.str);

  	}

  }

## Strings:

* Use **StringBuffer** to concatenate strings as **String** creates lot of constants in string constant pool  
* String.join() joins the elements with a delimiter  
  ArrayList\<String\> arr \= new ArrayList\<String\>();  
  System.out.println(String.join(",", arr));  
    
* String\[\] words \= paragraph.split(" ");  
* Character.toUpperCase(s.charAt(i))

## IO:	

* Use **BufferedReader** over **Scanner** class:   
  * BufferedReader is a bit faster as compared to scanner because scanner does parsing of input data and BufferedReader simply reads a sequence of characters.  
* 

## Collection:

* LinkedList\<Integer\>\[\] list \= new LinkedList\[size\];  
  * list.set(1, 10);  
  * list.removeIf(pair \-\> pair.getKey() \== key);  
  * int max \= list.stream().max((x,y)-\>Integer.compare(x, y)).get();  
* Looping the hashmap  
  * for(java.util.Map.Entry\<String, String\> entry : map.entrySet()){

              System.out.println(entry.getKey()+" "+entry.getValue());

          }

* for(String key : map.keySet()){  
              System.out.println(key);  
          }  
* for(String value: map.values()){  
              System.out.println(value);  
          }  
       }  
* map.containsKey(key)  
* map.containsValue(tch))  
*  Pair\<Integer, Integer\> pair \= new Pair\<\>(point\[0\], point\[1\]);  
  * pair.getKey()  
  * pair.getValue()  
* Queue\<Integer\> q \= new ArrayDeque\<\>();  
  * q.add();  
  * q.peek()  
  * q.remove();  
* Deque\<Integer\> dq \= new ArrayDeque\<\>();  
  * dq.addFirst() / dq.add()  
  * dq.addFirst()  
  * dq.peekFirst()  
  * dq.peekLast()  
  * dq.removeFirst()  
  * dq.removeLast()  
    

## Variables:

* By default variable are passed by value in java and objects are passed by reference

## Polymorphism:

* Accessing child class methods using parent class reference  
  class Animal{ }

	Dog extends Animal{  
	public void digHole(){  
sop(“Dig hole”);  
}  
}

Animal dog \= new Dog();  
//Below line gives compilation error as Animal doesn’t know about digHole;  
dog.digHole();  
//Below way works fine  
(Dog)dog.digHole();

* Diamond problem:   
  Interface I{  
  	Public void x();  
  }  
  Interface J{  
  	Public void x();  
  }  
  Class C implements I, J  
* Pass by value and ref:  
  Class C{  
  	main(){  
  		Int index \= 10;

  fun1(index);  
  sop(index);  
    
  list.add(index)  
  fun2(list);  
  sop(index);  
  sop(list.get(0));  
  	}

  Void fun1(int index){  
  		index++;

  }

  Void fun2(List\<Integer\> list){  
  		//increase the index from list

  }

}

[image1]: <data:image/png;base64,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>

[image2]: <data:image/png;base64,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>