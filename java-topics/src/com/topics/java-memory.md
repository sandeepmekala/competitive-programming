# Java Memory Management and Garbage Collection in Depth

## Table of Contents

- [Java Memory Management and Garbage Collection in Depth](#java-memory-management-and-garbage-collection-in-depth)
  - [Table of Contents](#table-of-contents)
  - [1. Introduction to Java Memory Management](#1-introduction-to-java-memory-management)
  - [2. Java Memory Structure (JVM Memory Areas)](#2-java-memory-structure-jvm-memory-areas)
    - [🔹 1. Heap Memory](#-1-heap-memory)
    - [🔹 2. Stack Memory](#-2-stack-memory)
    - [🔹 3. Method Area (MetaSpace in Java 8+)](#-3-method-area-metaspace-in-java-8)
    - [🔹 4. Program Counter (PC) Register](#-4-program-counter-pc-register)
    - [🔹 5. Native Method Stack](#-5-native-method-stack)
  - [3. Java Heap Memory Structure (Generations in Heap)](#3-java-heap-memory-structure-generations-in-heap)
    - [(a) Young Generation](#a-young-generation)
    - [(b) Old Generation (Tenured Space)](#b-old-generation-tenured-space)
    - [(c) Permanent Generation (Java 7 and below) / MetaSpace (Java 8+)](#c-permanent-generation-java-7-and-below--metaspace-java-8)
  - [4. Memory Allocation in Java](#4-memory-allocation-in-java)
  - [5. Garbage Collection in Java](#5-garbage-collection-in-java)
  - [6. How Garbage Collection Works?](#6-how-garbage-collection-works)
  - [7. Types of Garbage Collectors in Java](#7-types-of-garbage-collectors-in-java)
    - [(a) Serial Garbage Collector (Single-Threaded)](#a-serial-garbage-collector-single-threaded)
    - [(b) Parallel Garbage Collector (Multi-Threaded)](#b-parallel-garbage-collector-multi-threaded)
    - [(c) CMS (Concurrent Mark-Sweep) Garbage Collector](#c-cms-concurrent-mark-sweep-garbage-collector)
    - [(d) G1 (Garbage-First) Garbage Collector (Default in Java 9+)](#d-g1-garbage-first-garbage-collector-default-in-java-9)
  - [8. Important GC Phases (Mark and Sweep)](#8-important-gc-phases-mark-and-sweep)
  - [9. How to Optimize Memory Management?](#9-how-to-optimize-memory-management)
  - [10. Common Memory Issues in Java](#10-common-memory-issues-in-java)
    - [(a) Memory Leaks](#a-memory-leaks)
    - [(b) OutOfMemoryError (`java.lang.OutOfMemoryError`)](#b-outofmemoryerror-javalangoutofmemoryerror)

---

## 1. Introduction to Java Memory Management

Java handles memory management **automatically** using the **JVM (Java Virtual Machine)**. It manages memory allocation and deallocation efficiently, preventing memory leaks.

**Key Memory Areas in Java:**

1️⃣ **Heap Memory** - Stores objects and class instances.
2️⃣ **Stack Memory** - Stores method calls and local variables.
3️⃣ **Method Area (MetaSpace in Java 8+)** - Stores class metadata, method code, and static variables.
4️⃣ **PC Register** - Keeps track of instruction execution.
5️⃣ **Native Method Stack** - Used for native (non-Java) methods.

---

## 2. Java Memory Structure (JVM Memory Areas)

### 🔹 1. Heap Memory

* **Stores objects** created using `new` keyword.
* **Shared among all threads.**
* **Divided into:**
  * **Young Generation** (Eden + Survivor Spaces)
  * **Old Generation (Tenured Heap)**
  * **Permanent Generation (Before Java 8, replaced with MetaSpace)**

### 🔹 2. Stack Memory

* **Stores method calls and local variables.**
* **Follows LIFO (Last-In-First-Out) order.**
* **Each thread has its own stack.**

### 🔹 3. Method Area (MetaSpace in Java 8+)

* Stores **class metadata, static variables, method code**.
* **Shared among all threads.**
* **MetaSpace (Java 8+) grows dynamically, unlike the fixed-size PermGen in Java 7.**

### 🔹 4. Program Counter (PC) Register

* Stores the **current execution instruction address** of each thread.
* **Each thread has a separate PC Register.**

### 🔹 5. Native Method Stack

* **Used for native (C, C++) method execution.**
* **Each thread has its own native stack.**

---

## 3. Java Heap Memory Structure (Generations in Heap)

The **Heap Memory** is divided into **three main sections**:

### (a) Young Generation

* **Newly created objects are stored here.**
* **Divided into:**
  * **Eden Space** (where objects are first allocated)
  * **Survivor Space S0, S1** (objects that survive garbage collection)

### (b) Old Generation (Tenured Space)

* **Objects that survive multiple garbage collections move here.**
* **Larger objects and long-lived objects are stored here.**

### (c) Permanent Generation (Java 7 and below) / MetaSpace (Java 8+)

* **Stores class metadata, static methods, and constant pool.**
* **Java 8 replaced PermGen with MetaSpace, which dynamically resizes.**

---

## 4. Memory Allocation in Java

Java follows **automatic memory allocation** and **garbage collection** to manage memory efficiently.

**How Objects are Stored in Memory?**

1️⃣ **Primitive data types (int, double, char, etc.)** → Stored in **stack memory**.
2️⃣ **Objects (created using `new`)** → Stored in **heap memory**.
3️⃣ **Static variables** → Stored in **method area (MetaSpace in Java 8+)**.
4️⃣ **Local variables and method calls** → Stored in **stack memory**.

**Example: Memory Allocation**
```java
class Employee {
    String name; // Stored in heap
    int age;     // Stored in heap

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        String message = "Hello"; // Local variable (stored in stack)
        System.out.println(message + ", " + name + " is " + age + " years old.");
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", 30); // Stored in heap
        e1.display();
    }
}
```

✔ **Local variable `message` → Stored in stack**
✔ **Object `e1` → Stored in heap**
✔ **Instance variables `name` & `age` → Stored in heap**

---

## 5. Garbage Collection in Java

Java uses **Garbage Collection (GC)** to automatically remove **unused objects** and free memory.

**Key Features of Garbage Collection**

✔ **Automatic memory management (no manual `free()` like C++)**
✔ **Identifies unused objects and removes them**
✔ **Runs periodically in the background**

---

## 6. How Garbage Collection Works?

Garbage collection works by identifying **objects that are no longer reachable** and freeing the memory they occupy.

**Objects Become Eligible for GC When:**

1️⃣ No **active reference** to the object.
2️⃣ **Explicitly set to `null`** (`obj = null;`).
3️⃣ **Out of scope** (e.g., local variables after method execution).
4️⃣ **Reference is reassigned to another object.**

**Example: Eligible for GC**
```java
class GCExample {
    String data;

    GCExample(String data) {
        this.data = data;
    }

    public static void main(String[] args) {
        GCExample obj1 = new GCExample("Java");
        GCExample obj2 = new GCExample("Python");

        obj1 = obj2;  // Java object becomes unreachable → Eligible for GC
        obj2 = null;  // Python object also becomes unreachable → Eligible for GC

        System.gc();  // Request garbage collection
    }

    @Override
    protected void finalize() {
        System.out.println("Garbage Collected: " + this.data);
    }
}
```

✔ `finalize()` method is called before garbage collection.
✔ `System.gc()` requests GC (not guaranteed to run immediately).

---

## 7. Types of Garbage Collectors in Java

Java provides different **garbage collection algorithms**:

### (a) Serial Garbage Collector (Single-Threaded)

* **Use:** Small applications (default in single-threaded apps).
* **JVM Option:** `-XX:+UseSerialGC`

### (b) Parallel Garbage Collector (Multi-Threaded)

* **Use:** Multi-threaded applications, better performance.
* **JVM Option:** `-XX:+UseParallelGC`

### (c) CMS (Concurrent Mark-Sweep) Garbage Collector

* **Use:** Low-latency applications, minimizes pause time.
* **JVM Option:** `-XX:+UseConcMarkSweepGC`

### (d) G1 (Garbage-First) Garbage Collector (Default in Java 9+)

* **Use:** Large applications with real-time performance.
* **JVM Option:** `-XX:+UseG1GC`

---

## 8. Important GC Phases (Mark and Sweep)

1️⃣ **Mark Phase** → Identifies active (reachable) objects.
2️⃣ **Sweep Phase** → Removes unused objects and reclaims memory.

---

## 9. How to Optimize Memory Management?

✔ **Use `null` to dereference objects (if no longer needed).**
✔ **Use `try-with-resources` for automatic cleanup of resources.**
✔ **Avoid memory leaks (e.g., forgetting to close resources like file streams).**
✔ **Use Weak References (`WeakReference`, `SoftReference`, `PhantomReference`) when needed.**

---

## 10. Common Memory Issues in Java

### (a) Memory Leaks

* Happens when **objects are unintentionally kept in memory** and not garbage collected.
* **Example: Static collections holding unused objects.**

### (b) OutOfMemoryError (`java.lang.OutOfMemoryError`)

* **Occurs when heap memory is exhausted.**

**Solution:** Increase heap size using JVM options:
```bash
java -Xms512m -Xmx2g MyClass
```

* (`-Xms`: Initial heap size, `-Xmx`: Maximum heap size)

---
