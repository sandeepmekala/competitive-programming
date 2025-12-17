# Collections

## Table of Contents

### Part 1 | Java Collections Framework in Depth
- [1. What is Java Collections Framework (JCF)?](#1-what-is-java-collections-framework-jcf)
- [2. Core Interfaces of Java Collections Framework](#2-core-interfaces-of-java-collections-framework)
- [3. Collection vs Collections](#3-collection-vs-collections)
- [4. List Interface (Ordered Collection with Duplicates Allowed)](#4-list-interface-ordered-collection-with-duplicates-allowed)
  - [4.1 ArrayList (Fast Read, Slow Write)](#41-arraylist-fast-read-slow-write)
  - [4.2 LinkedList (Fast Insert/Delete, Slow Read)](#42-linkedlist-fast-insertdelete-slow-read)
  - [4.3 Vector (Thread-Safe, Slower than ArrayList)](#43-vector-thread-safe-slower-than-arraylist)
- [5. Set Interface (No Duplicate Elements, Unordered by Default)](#5-set-interface-no-duplicate-elements-unordered-by-default)
  - [5.1 HashSet (Fastest, Unordered)](#51-hashset-fastest-unordered)
  - [5.2 LinkedHashSet (Insertion Order Preserved)](#52-linkedhashset-insertion-order-preserved)
  - [5.3 TreeSet (Sorted Order, Uses Red-Black Tree)](#53-treeset-sorted-order-uses-red-black-tree)
- [6. Map Interface (Key-Value Pair Storage, No Duplicate Keys)](#6-map-interface-key-value-pair-storage-no-duplicate-keys)
  - [6.1 HashMap (Fastest, No Order)](#61-hashmap-fastest-no-order)
  - [6.2 LinkedHashMap (Maintains Insertion Order)](#62-linkedhashmap-maintains-insertion-order)
  - [6.3 TreeMap (Sorted Order, Uses Red-Black Tree)](#63-treemap-sorted-order-uses-red-black-tree)




- [7. Queue Interface (FIFO Operations)](#7-queue-interface-fifo-operations)
  - [7.1 PriorityQueue (Sorted Order)](#71-priorityqueue-sorted-order)

### Part 2 | Comparator vs Comparable | PriorityQueue
- [1. Comparator vs Comparable in Java](#1-comparator-vs-comparable-in-java)
  - [1.1 Comparable Example (Single Sorting Order - Natural Ordering)](#11-comparable-example-single-sorting-order---natural-ordering)
  - [1.2 Comparator Example (Multiple Sorting Orders)](#12-comparator-example-multiple-sorting-orders)
  - [1.3 Lambda Expression with Comparator (Java 8+)](#13-lambda-expression-with-comparator-java-8)
- [2. PriorityQueue in Java (Min-Heap & Max-Heap Implementation)](#2-priorityqueue-in-java-min-heap--max-heap-implementation)
  - [2.1 Min-Heap (Default Behavior - Smallest Element First)](#21-min-heap-default-behavior---smallest-element-first)
  - [2.2 Max-Heap (Largest Element First)](#22-max-heap-largest-element-first)
  - [2.3 PriorityQueue with Custom Comparator](#23-priorityqueue-with-custom-comparator)

### Part 3 | Deque and List in Depth
- [1. Deque (Double-Ended Queue) in Java](#1-deque-double-ended-queue-in-java)
  - [1.1 Deque Implementations in Java](#11-deque-implementations-in-java)
  - [1.2 Methods in Deque](#12-methods-in-deque)
  - [1.3 Example: Using ArrayDeque for Both Stack & Queue Operations](#13-example-using-arraydeque-for-both-stack--queue-operations)
  - [1.4 Deque as a Stack (LIFO)](#14-deque-as-a-stack-lifo)
  - [1.5 Deque as a Queue (FIFO)](#15-deque-as-a-queue-fifo)
- [2. List in Depth (ArrayList vs LinkedList vs Vector)](#2-list-in-depth-arraylist-vs-linkedlist-vs-vector)
  - [2.1 Types of Lists in Java](#21-types-of-lists-in-java)
  - [2.2 Methods in List](#22-methods-in-list)
  - [2.3 Example: ArrayList (Dynamic Array)](#23-example-arraylist-dynamic-array)
  - [2.4 Example: LinkedList (Doubly Linked List)](#24-example-linkedlist-doubly-linked-list)
  - [2.5 Example: Vector (Thread-Safe List)](#25-example-vector-thread-safe-list)
- [3. Summary: Deque vs List Implementations](#3-summary-deque-vs-list-implementations)
  - [3.1 Deque Summary](#31-deque-summary)
  - [3.2 List Summary](#32-list-summary)

### Part 4 | HashMap Internal Working in Java
- [1. Introduction to HashMap](#1-introduction-to-hashmap)
- [2. HashMap Internal Structure](#2-hashmap-internal-structure)
- [3. How put(K key, V value) Works?](#3-how-putk-key-v-value-works)
- [4. How get(K key) Works?](#4-how-getk-key-works)
- [5. Collision Handling Mechanisms](#5-collision-handling-mechanisms)
- [6. Load Factor & Rehashing](#6-load-factor--rehashing)
- [7. Example: HashMap Internal Operations](#7-example-hashmap-internal-operations)
- [8. Summary](#8-summary)

### Part 5 | LinkedHashMap and TreeMap in Depth
- [1. Introduction](#1-introduction)
- [2. LinkedHashMap in Depth](#2-linkedhashmap-in-depth)
  - [2.1 What is LinkedHashMap?](#21-what-is-linkedhashmap)
  - [2.2 Internal Structure of LinkedHashMap](#22-internal-structure-of-linkedhashmap)
  - [2.3 Example: LinkedHashMap in Action](#23-example-linkedhashmap-in-action)
  - [2.4 Access Order (LRU Cache)](#24-access-order-lru-cache)
- [3. TreeMap in Depth](#3-treemap-in-depth)
  - [3.1 What is TreeMap?](#31-what-is-treemap)
  - [3.2 Internal Structure of TreeMap](#32-internal-structure-of-treemap)
  - [3.3 Example: TreeMap in Action](#33-example-treemap-in-action)
  - [3.4 Custom Sorting using Comparator](#34-custom-sorting-using-comparator)
  - [3.5 HeadMap, TailMap, SubMap (Range Queries)](#35-headmap-tailmap-submap-range-queries)
- [4. Summary: LinkedHashMap vs TreeMap](#4-summary-linkedhashmap-vs-treemap)

### Part 6 | Set in Depth
- [1. Introduction to Set Interface](#1-introduction-to-set-interface)
- [2. Types of Set Implementations in Java](#2-types-of-set-implementations-in-java)
- [3. HashSet in Depth](#3-hashset-in-depth)
  - [3.1 What is HashSet?](#31-what-is-hashset)
  - [3.2 Internal Working of HashSet](#32-internal-working-of-hashset)
  - [3.3 Example of HashSet](#33-example-of-hashset)
- [4. LinkedHashSet in Depth](#4-linkedhashset-in-depth)
  - [4.1 What is LinkedHashSet?](#41-what-is-linkedhashset)
  - [4.2 Example of LinkedHashSet](#42-example-of-linkedhashset)
- [5. TreeSet in Depth](#5-treeset-in-depth)
  - [5.1 What is TreeSet?](#51-what-is-treeset)
  - [5.2 Example of TreeSet](#52-example-of-treeset)
- [6. Custom Sorting in TreeSet](#6-custom-sorting-in-treeset)
- [7. Differences Between HashSet, LinkedHashSet, and TreeSet](#7-differences-between-hashset-linkedhashset-and-treeset)
- [8. Set Operations (Union, Intersection, Difference)](#8-set-operations-union-intersection-difference)
- [9. When to Use Which Set?](#9-when-to-use-which-set)

### Part 7 | Streams in Java 8
- [1. Introduction to Streams in Java 8](#1-introduction-to-streams-in-java-8)
- [2. Creating a Stream in Java](#2-creating-a-stream-in-java)
  - [2.1 From Collections (List, Set, etc.)](#21-from-collections-list-set-etc)
  - [2.2 From Arrays](#22-from-arrays)
  - [2.3 Using Stream.of()](#23-using-streamof)
  - [2.4 Using Stream.generate() (Infinite Stream)](#24-using-streamgenerate-infinite-stream)
  - [2.5 Using Stream.iterate()](#25-using-streamiterate)
- [3. Stream Operations](#3-stream-operations)
- [4. Intermediate Operations in Streams](#4-intermediate-operations-in-streams)
  - [4.1 filter(Predicate) - Filtering Elements](#41-filterpredicate---filtering-elements)
  - [4.2 map(Function) - Transforming Elements](#42-mapfunction---transforming-elements)
  - [4.3 sorted() - Sorting Elements](#43-sorted---sorting-elements)
  - [4.4 distinct() - Removing Duplicates](#44-distinct---removing-duplicates)
  - [4.5 limit(n) - Limiting the Stream](#45-limitn---limiting-the-stream)
- [5. Terminal Operations in Streams](#5-terminal-operations-in-streams)
  - [5.1 forEach() - Iterate Over Stream](#51-foreach---iterate-over-stream)
  - [5.2 collect() - Convert Stream to Collection](#52-collect---convert-stream-to-collection)
  - [5.3 count() - Counting Elements](#53-count---counting-elements)
  - [5.4 reduce() - Aggregate Elements](#54-reduce---aggregate-elements)
- [6. Parallel Streams for Performance](#6-parallel-streams-for-performance)
  - [6.1 Parallel Stream Example](#61-parallel-stream-example)
- [7. Stream vs Collections](#7-stream-vs-collections)
- [8. When to Use Streams?](#8-when-to-use-streams)

### Java 21: Sequenced Collections
- [🔹 What Are Sequenced Collections?](#-what-are-sequenced-collections)
- [🔹 Key Motivation](#-key-motivation)
- [🔹 New Interfaces & Core Methods](#-new-interfaces--core-methods)
- [🔹 Who Implements What?](#-who-implements-what)
- [🔹 Why SequencedSet Was Introduced](#-why-sequencedset-was-introduced)
- [🔹 Unsupported Operations](#-unsupported-operations)
- [🔹 Reverse View](#-reverse-view)
- [🔹 Benefits](#-benefits)
- [🔹 Examples: Unified Usage](#-examples-unified-usage)
- [🧠 Conclusion](#-conclusion)


---

## Part 1 | Java Collections Framework in Depth

### 1. What is Java Collections Framework (JCF)?

The **Java Collections Framework (JCF)** is a set of **classes and interfaces** in Java that **store, manipulate, and manage collections of objects efficiently**.

✔ Provides **predefined data structures** (List, Set, Map, Queue).
✔ Improves **code reusability** and **performance**.
✔ Supports **generics, iteration, and sorting**.

---

### 2. Core Interfaces of Java Collections Framework

| Interface      | Description                            | Key Implementations                   |
| -------------- | -------------------------------------- | ------------------------------------- |
| **Collection** | Root interface for all collections     | -                                     |
| **List**       | Ordered collection (allows duplicates) | `ArrayList`, `LinkedList`, `Vector`   |
| **Set**        | Unordered collection (no duplicates)   | `HashSet`, `LinkedHashSet`, `TreeSet` |
| **Queue**      | FIFO (First-In-First-Out) structure    | `PriorityQueue`, `ArrayDeque`         |
| **Map**        | Key-Value pairs (no duplicate keys)    | `HashMap`, `LinkedHashMap`, `TreeMap` |

✅ **All collections except Map inherit from `Collection` interface**

---

### 3. Collection vs Collections

| Feature     | `Collection`                             | `Collections`                  |
| ----------- | ---------------------------------------- | ------------------------------ |
| **Type**    | Interface                                | Utility Class                  |
| **Purpose** | Parent of List, Set, and Queue           | Provides static helper methods |
| **Example** | `List<String> list = new ArrayList<>();` | `Collections.sort(list);`      |

---

### 4. List Interface (Ordered Collection with Duplicates Allowed)

#### 4.1 `ArrayList` (Fast Read, Slow Write)

✔ **Dynamic array-based** implementation.
✔ Fast **random access** (O(1) time complexity).
✔ Slow **insertion & deletion** (O(n) in worst case).

Example:

```java
import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Mango");
        System.out.println(list); // Output: [Apple, Banana, Mango]
    }
}
```

---

#### 4.2 `LinkedList` (Fast Insert/Delete, Slow Read)

✔ Doubly linked list implementation.
✔ Fast **insertion & deletion** (O(1)).
✔ Slow **random access** (O(n)).

Example:

```java
import java.util.*;

public class LinkedListExample {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list); // Output: [10, 20, 30]
    }
}
```

---

#### 4.3 `Vector` (Thread-Safe, Slower than ArrayList)

✔ **Synchronized version** of `ArrayList`.
✔ Slower performance due to **thread safety**.

Example:

```java
import java.util.*;

public class VectorExample {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("Car");
        vector.add("Bike");
        System.out.println(vector); // Output: [Car, Bike]
    }
}
```

---

### 5. Set Interface (No Duplicate Elements, Unordered by Default)

#### 5.1 `HashSet` (Fastest, Unordered)

✔ Uses **HashMap internally**.
✔ No duplicates, **order not maintained**.
✔ O(1) **insert, delete, search** time complexity.

Example:

```java
import java.util.*;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Apple"); // Duplicate ignored
        System.out.println(set); // Output: [Banana, Apple] (Order not guaranteed)
    }
}
```

---

#### 5.2 `LinkedHashSet` (Insertion Order Preserved)

✔ **Maintains insertion order**.
✔ Uses **LinkedHashMap internally**.

Example:

```java
import java.util.*;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add("Cat");
        set.add("Dog");
        set.add("Elephant");
        System.out.println(set); // Output: [Cat, Dog, Elephant]
    }
}
```

---

#### 5.3 `TreeSet` (Sorted Order, Uses Red-Black Tree)

✔ **Maintains ascending order**.
✔ O(log n) time complexity for operations.

Example:

```java
import java.util.*;

public class TreeSetExample {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(30);
        set.add(10);
        set.add(20);
        System.out.println(set); // Output: [10, 20, 30]
    }
}
```

---

### 6. Map Interface (Key-Value Pair Storage, No Duplicate Keys)

#### 6.1 `HashMap` (Fastest, No Order)

✔ Uses **hashing** for fast lookup.
✔ O(1) time complexity (in ideal cases).

Example:

```java
import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Alice");
        map.put(2, "Bob");
        System.out.println(map); // Output: {1=Alice, 2=Bob}
    }
}
```

---

#### 6.2 `LinkedHashMap` (Maintains Insertion Order)

✔ Same as `HashMap`, but maintains order.

Example:

```java
import java.util.*;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("John", 25);
        map.put("Jane", 30);
        System.out.println(map); // Output: {John=25, Jane=30}
    }
}
```

---

#### 6.3 `TreeMap` (Sorted Order, Uses Red-Black Tree)

✔ **Maintains ascending key order**.
✔ O(log n) operations.

Example:

```java
import java.util.*;

public class TreeMapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<>();
        map.put(3, "Apple");
        map.put(1, "Banana");
        System.out.println(map); // Output: {1=Banana, 3=Apple}
    }
}
```

---

### 7. Queue Interface (FIFO Operations)

#### 7.1 `PriorityQueue` (Sorted Order)

✔ **Min-Heap by default** (smallest element first).
✔ Used in **task scheduling** and **Dijkstra's Algorithm**.

Example:

```java
import java.util.*;

public class PriorityQueueExample {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(30);
        pq.add(10);
        pq.add(20);
        System.out.println(pq.poll()); // Output: 10 (smallest element)
    }
}
```

---

## Part 2 | Comparator vs Comparable | PriorityQueue

---

### 1. Comparator vs Comparable in Java

Both **Comparable** and **Comparator** are used for sorting objects in Java.

| Feature                      | `Comparable`                                        | `Comparator`                                     |
| ---------------------------- | --------------------------------------------------- | ------------------------------------------------ |
| **Purpose**                  | Used to define the **natural ordering** of objects  | Used to define **custom ordering** of objects    |
| **Package**                  | `java.lang`                                         | `java.util`                                      |
| **Method to Implement**      | `compareTo(T obj)`                                  | `compare(T obj1, T obj2)`                        |
| **Number of Sorting Orders** | **Single sorting logic** per class                  | Multiple sorting logics possible                 |
| **Modification Needed?**     | **Yes**, modify the class to implement `Comparable` | **No**, can be defined externally                |
| **Used in**                  | `TreeSet`, `TreeMap`, `PriorityQueue`               | `Collections.sort()`, `PriorityQueue`, `TreeMap` |

---

#### 1.1 Comparable Example (Single Sorting Order - Natural Ordering)

✔ The `compareTo()` method is used to define the **default sorting order**.

Example: Sorting Employees by ID (Ascending Order)

```java
import java.util.*;

class Employee implements Comparable<Employee> {
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Employee other) {
        return this.id - other.id; // Sorting by ID (Ascending Order)
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(3, "John"));
        employees.add(new Employee(1, "Alice"));
        employees.add(new Employee(2, "Bob"));
        Collections.sort(employees); // Uses Comparable
        System.out.println(employees); // Output: [1 - Alice, 2 - Bob, 3 - John]
    }
}
```

---

#### 1.2 Comparator Example (Multiple Sorting Orders)

✔ The `Comparator` interface is used to define **custom sorting orders**.

Example: Sorting Employees by Name (Alphabetically)

```java
import java.util.*;

class Employee {
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

// Comparator for sorting by name
class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.name.compareTo(e2.name); // Alphabetical order
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(3, "John"));
        employees.add(new Employee(1, "Alice"));
        employees.add(new Employee(2, "Bob"));
        Collections.sort(employees, new NameComparator());
        System.out.println(employees); // Output: [1 - Alice, 2 - Bob, 3 - John]
    }
}
```

---

#### 1.3 Lambda Expression with Comparator (Java 8+)

✔ No need to create a separate `Comparator` class.

Example: Sorting by ID in Descending Order

```java
import java.util.*;

public class LambdaComparator {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(3, "John"));
        employees.add(new Employee(1, "Alice"));
        employees.add(new Employee(2, "Bob"));

        // Using Lambda for sorting by ID (Descending Order)
        employees.sort((e1, e2) -> e2.id - e1.id);
        System.out.println(employees); // Output: [3 - John, 2 - Bob, 1 - Alice]
    }
}
```

---

### 2. PriorityQueue in Java (Min-Heap & Max-Heap Implementation)

✔ **PriorityQueue** is part of the Java **Queue** interface.
✔ Stores elements in **sorted order (by priority, not insertion order)**.
✔ **Uses a Min-Heap** by default (smallest element first).
✔ Supports **custom sorting using Comparator**.

---

#### 2.1 Min-Heap (Default Behavior - Smallest Element First)

✔ Default `PriorityQueue` follows **natural ordering**.

Example:

```java
import java.util.*;

public class MinHeapExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(30);
        pq.add(10);
        pq.add(20);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll()); // Output: 10, 20, 30
        }
    }
}
```

---

#### 2.2 Max-Heap (Largest Element First)

✔ Use a **Comparator** to create a Max-Heap.

Example:

```java
import java.util.*;

public class MaxHeapExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(30);
        pq.add(10);
        pq.add(20);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll()); // Output: 30, 20, 10
        }
    }
}
```

---

#### 2.3 PriorityQueue with Custom Comparator

✔ Sorting a `PriorityQueue` using **custom priority**.

Example: Task Scheduling (Priority Order)

```java
import java.util.*;

class Task {
    String name;
    int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return name + " (Priority: " + priority + ")";
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>((t1, t2) -> t2.priority - t1.priority);

        taskQueue.add(new Task("Fix Bug", 2));
        taskQueue.add(new Task("Develop Feature", 1));
        taskQueue.add(new Task("Code Review", 3));

        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }
        // Output: Code Review (Priority: 3), Fix Bug (Priority: 2), Develop Feature (Priority: 1)
    }
}
```

---

## Part 3 | Deque and List in Depth

---

### 1. Deque (Double-Ended Queue) in Java

✔ `Deque` (pronounced "deck") allows **insertion and deletion from both ends**.
✔ Implemented using `ArrayDeque` and `LinkedList`.
✔ More flexible than a `Queue` (FIFO) or a `Stack` (LIFO).

#### 1.1 Deque Implementations in Java

| Implementation | Backed By              | Performance                                                |
| -------------- | ---------------------- | ---------------------------------------------------------- |
| `ArrayDeque`   | **Resizable Array**    | **Faster than `LinkedList`**, no memory overhead for links |
| `LinkedList`   | **Doubly Linked List** | Extra memory for links, slightly slower                    |

---

#### 1.2 Methods in Deque

| Method                            | Description                 |
| --------------------------------- | --------------------------- |
| `addFirst(E e) / offerFirst(E e)` | Adds element at the front   |
| `addLast(E e) / offerLast(E e)`   | Adds element at the back    |
| `removeFirst() / pollFirst()`     | Removes the front element   |
| `removeLast() / pollLast()`       | Removes the back element    |
| `getFirst() / peekFirst()`        | Retrieves the front element |
| `getLast() / peekLast()`          | Retrieves the back element  |

---

#### 1.3 Example: Using `ArrayDeque` for Both Stack & Queue Operations

```java
import java.util.*;

public class DequeExample {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        // Adding elements at both ends
        deque.addFirst(10);
        deque.addLast(20);
        deque.offerFirst(5);
        deque.offerLast(25);

        System.out.println(deque); // Output: [5, 10, 20, 25]

        // Removing elements from both ends
        System.out.println("Removed First: " + deque.removeFirst()); // 5
        System.out.println("Removed Last: " + deque.removeLast());   // 25
        System.out.println(deque); // Output: [10, 20]
    }
}
```

---

#### 1.4 Deque as a Stack (LIFO)

✔ **Deque can be used as a Stack** (similar to `Stack<E>`, but faster).

```java
import java.util.*;

public class DequeAsStack {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(10); // Add element on top
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop()); // 30 (LIFO)
        System.out.println(stack.peek()); // 20 (Top element)
    }
}
```

---

#### 1.5 Deque as a Queue (FIFO)

✔ **Deque can be used as a Queue** (similar to `LinkedList`, but faster).

```java
import java.util.*;

public class DequeAsQueue {
    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println(queue.poll()); // 10 (FIFO)
        System.out.println(queue.peek()); // 20 (Front element)
    }
}
```

---

### 2. List in Depth (ArrayList vs LinkedList vs Vector)

A `List` is an **ordered collection** that allows duplicates and provides **indexed access** to elements.

#### 2.1 Types of Lists in Java

| Implementation | Backed By                         | Performance                                                                   |
| -------------- | --------------------------------- | ----------------------------------------------------------------------------- |
| `ArrayList`    | **Resizable Array**               | **Fast for random access (O(1))**, slow for insert/delete in middle (O(n))    |
| `LinkedList`   | **Doubly Linked List**            | **Fast insert/delete (O(1))**, slow random access (O(n))                      |
| `Vector`       | **Resizable Array (Thread-safe)** | Similar to `ArrayList`, but **synchronized** (slower in single-threaded apps) |

---

#### 2.2 Methods in List

| Method                                      | Description                                  |
| ------------------------------------------- | -------------------------------------------- |
| `add(E e) / add(int index, E e)`            | Adds an element at the end or specific index |
| `remove(int index) / remove(Object o)`      | Removes an element by index or value         |
| `get(int index)`                            | Retrieves an element at the given index      |
| `set(int index, E e)`                       | Replaces an element at a given index         |
| `indexOf(Object o) / lastIndexOf(Object o)` | Finds first/last occurrence index            |

---

#### 2.3 Example: ArrayList (Dynamic Array)

```java
import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Mango");

        System.out.println(list.get(1)); // Banana
        list.set(1, "Orange");
        System.out.println(list); // [Apple, Orange, Mango]
    }
}
```

---

#### 2.4 Example: LinkedList (Doubly Linked List)

✔ **Efficient for frequent insertions/deletions.**

```java
import java.util.*;

public class LinkedListExample {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Blue");
        list.add(1, "Green");

        System.out.println(list); // [Red, Green, Blue]
        list.remove("Green");
        System.out.println(list); // [Red, Blue]
    }
}
```

---

#### 2.5 Example: Vector (Thread-Safe List)

✔ **Slower than `ArrayList`, but useful in multi-threaded environments.**

```java
import java.util.*;

public class VectorExample {
    public static void main(String[] args) {
        List<Integer> vector = new Vector<>();
        vector.add(10);
        vector.add(20);
        vector.add(30);
        System.out.println(vector); // [10, 20, 30]
    }
}
```

---

### 3. Summary: Deque vs List Implementations

#### 3.1 Deque Summary

| Feature         | ArrayDeque                    | LinkedList                         |
| --------------- | ----------------------------- | ---------------------------------- |
| **Performance** | Faster, no overhead for links | Slightly slower, uses extra memory |
| **Usage**       | Stack, Queue, Deque           | Stack, Queue, Deque                |
| **Best For**    | **Stack & Queue operations**  | **Frequent insert/delete**         |

---

#### 3.2 List Summary

| Feature            | ArrayList                    | LinkedList                 | Vector                            |
| ------------------ | ---------------------------- | -------------------------- | --------------------------------- |
| **Data Structure** | **Resizable Array**          | **Doubly Linked List**     | **Resizable Array (Thread-Safe)** |
| **Random Access**  | **Fast (O(1))**              | **Slow (O(n))**            | **Fast (O(1))**                   |
| **Insert/Delete**  | **Slow (O(n))**              | **Fast (O(1))**            | **Slow (O(n))**                   |
| **Thread Safety**  | ❌ No                         | ❌ No                       | ✅ Yes                             |
| **Best For**       | **Frequent read operations** | **Frequent insert/delete** | **Multi-threaded environments**   |

---

## Part 4 | HashMap Internal Working in Java

---

### 1. Introduction to HashMap

`HashMap<K, V>` is a part of the Java Collections Framework that provides **key-value** pair storage. It is implemented using **hashing**, allowing **fast retrieval (O(1) average case, O(n) worst case)**.

✔ **Allows one `null` key and multiple `null` values**
✔ **Unordered collection** (No insertion order maintained)
✔ **Not thread-safe** (Use `ConcurrentHashMap` for thread safety)

---

### 2. HashMap Internal Structure

Internally, `HashMap` is backed by an **array of linked lists (buckets)**, where each index in the array stores a **linked list of key-value pairs (Nodes/Entries)**.

```
HashMap<K, V>

+------------------+
|  Bucket[0] -> (Key1, Value1) -> (Key2, Value2) -> null
|  Bucket[1] -> null
|  Bucket[2] -> (Key3, Value3) -> null
|  ...
|  Bucket[N] -> null
+------------------+
```

**Key Terms:**

* **Bucket:** Each index of the array.
* **Hash Function:** Converts a key into a bucket index.
* **Collision:** When two keys get the same bucket index.
* **Load Factor:** Determines when to resize the HashMap (Default: `0.75f`).
* **Rehashing:** Increasing bucket size when threshold exceeds.

---

### 3. How `put(K key, V value)` Works?

#### Step 1: Compute HashCode

Each key's `hashCode()` is computed, then transformed into a bucket index.

```java
int hashCode = key.hashCode();
int index = (hashCode & 0x7FFFFFFF) % capacity;
```

Example:

```java
"Apple".hashCode() = 123456  →  Index = 123456 % 16 = 0
```

#### Step 2: Check for Collision

* If no existing entry at `index`, insert a new `Node<K, V>`.
* If an entry already exists (**collision**), check keys:
  * If key **matches**, update the value.
  * If key **does not match**, use **Linked List (before Java 8)** or **Balanced Tree (after Java 8, if size > 8)**.

#### Step 3: Store Key-Value Pair

```java
hashMap.put("Apple", 100);
hashMap.put("Orange", 200);
```

Stores:

```
Bucket[0] → ("Apple", 100)
Bucket[1] → ("Orange", 200)
```

---

### 4. How `get(K key)` Works?

1. Compute the `hashCode` and find the index.
2. Search the bucket:
   * If only **one node**, return its value.
   * If **collision exists**, traverse the linked list (or tree after Java 8).
3. Return the value if the key is found, else return `null`.

---

### 5. Collision Handling Mechanisms

Collisions occur when different keys hash to the same bucket. `HashMap` handles this using:

#### A. Separate Chaining (Linked List)

Before Java 8, HashMap stored collided keys as a **linked list**.

```java
Bucket[0] → ("Apple", 100) → ("Mango", 300) → null
```

#### B. Tree-Based Resolution (Java 8+)

If **linked list size > 8**, it is converted into a **Red-Black Tree** for **O(log n) search time**.

```java
Bucket[0] →  TreeNode ("Apple", 100)
                    ↙        ↘
        ("Mango", 300)   ("Banana", 400)
```

---

### 6. Load Factor & Rehashing

The **load factor** defines when the `HashMap` increases its size (default `0.75`).

```java
Initial capacity = 16
Load factor = 0.75
Resize threshold = 16 * 0.75 = 12 elements
```

When the number of entries **exceeds 12**, `HashMap` **doubles its size** and **re-distributes** entries to new buckets.

---

### 7. Example: HashMap Internal Operations

```java
import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Put elements
        map.put("Apple", 100);
        map.put("Banana", 200);
        map.put("Mango", 300);

        // Get elements
        System.out.println("Apple price: " + map.get("Apple")); // 100

        // Check key existence
        System.out.println("Contains 'Banana'? " + map.containsKey("Banana")); // true

        // Remove an element
        map.remove("Mango");
        System.out.println(map); // {Apple=100, Banana=200}
    }
}
```

---

### 8. Summary

| Feature                | Description                                                |
| ---------------------- | ---------------------------------------------------------- |
| **Time Complexity**    | **O(1) average**, O(n) worst case (if collisions exist)    |
| **Load Factor**        | Default: `0.75`, triggers resizing                         |
| **Collision Handling** | **Linked List (pre-Java 8), Red-Black Tree (post-Java 8)** |
| **Null Values**        | One `null` key allowed, multiple `null` values allowed     |
| **Resizing**           | Doubles capacity when load factor threshold is exceeded    |

🚀 **Next Steps:** Would you like a deep dive into `LinkedHashMap` and `TreeMap`? 😊

---

## Part 5 | LinkedHashMap and TreeMap in Depth

### 1. Introduction

Both `LinkedHashMap` and `TreeMap` are implementations of `Map` in Java but with different properties:

| Feature         | `LinkedHashMap`                                             | `TreeMap`                                          |
| --------------- | ----------------------------------------------------------- | -------------------------------------------------- |
| **Ordering**    | Maintains **insertion order**                               | Sorts keys in **ascending order** (by default)     |
| **Null Keys**   | **Allowed (one null key)**                                  | **Not allowed** (throws `NullPointerException`)    |
| **Null Values** | **Allowed**                                                 | **Allowed**                                        |
| **Performance** | Slightly **slower than HashMap** (due to order maintenance) | Slower than `HashMap` but provides **sorted keys** |
| **Sorting**     | No sorting (just preserves insertion order)                 | Uses **natural ordering** or a custom `Comparator` |

---

### 2. LinkedHashMap in Depth

#### 2.1 What is `LinkedHashMap`?

`LinkedHashMap` is a subclass of `HashMap` that maintains **insertion order** using a **doubly linked list**.

✔ **Fast Lookup (`O(1)`) like HashMap**
✔ **Maintains Order**
✔ **Good for LRU Cache Implementation**

#### 2.2 Internal Structure of LinkedHashMap

Internally, `LinkedHashMap` uses:

* A **HashTable (Array of Buckets)** for fast access.
* A **Doubly Linked List** to maintain order.

```
LinkedHashMap<K, V>

+------------+    +------------+    +------------+
| ("A", 100) | -> | ("B", 200) | -> | ("C", 300) |
+------------+    +------------+    +------------+
```

#### 2.3 Example: LinkedHashMap in Action

```java
import java.util.*;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        // Insert elements
        map.put("Apple", 100);
        map.put("Banana", 200);
        map.put("Mango", 300);

        // Retrieve elements
        System.out.println(map); // Maintains Insertion Order
        // Output: {Apple=100, Banana=200, Mango=300}
    }
}
```

---

#### 2.4 Access Order (LRU Cache)

`LinkedHashMap` allows **access order** tracking using:

```java
LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder);
```

✔ `accessOrder = false` → Maintains **insertion order** (default).
✔ `accessOrder = true` → Maintains **access order** (like LRU Cache).

Example: LRU Cache Implementation

```java
import java.util.*;

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true); // true = access order
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity; // Remove least recently used
    }
}

public class LRUExample {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        cache.get(1); // Access 1 → Moves to the end
        cache.put(4, "Four"); // Removes LRU (2)
        System.out.println(cache); // Output: {3=Three, 1=One, 4=Four}
    }
}
```

---

### 3. TreeMap in Depth

#### 3.1 What is `TreeMap`?

`TreeMap` is a **Red-Black Tree** based implementation of `NavigableMap` that keeps keys **sorted in ascending order**.

✔ **Ordered Sorting (O(log n))**
✔ **Efficient Range Queries**
✔ **No `null` keys allowed** (throws `NullPointerException`)

#### 3.2 Internal Structure of TreeMap

Internally, `TreeMap` uses:

* A **Self-Balancing Red-Black Tree** for ordering.
* **Time Complexity:** `O(log n)` for insertion, deletion, and search.

```
TreeMap<K, V>

           50
          /  \
        20    70
       /  \   /  \
     10   30 60  80
```

---

#### 3.3 Example: TreeMap in Action

```java
import java.util.*;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(50, "Apple");
        map.put(10, "Banana");
        map.put(30, "Mango");
        map.put(70, "Orange");

        System.out.println(map); // Output: {10=Banana, 30=Mango, 50=Apple, 70=Orange}
    }
}
```

---

#### 3.4 Custom Sorting using Comparator

By default, `TreeMap` sorts in **natural order**.
We can pass a **custom Comparator** to define a **custom sorting order**.

```java
import java.util.*;

public class TreeMapCustomSort {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());

        map.put(50, "Apple");
        map.put(10, "Banana");
        map.put(30, "Mango");
        map.put(70, "Orange");

        System.out.println(map); // Output: {70=Orange, 50=Apple, 30=Mango, 10=Banana}
    }
}
```

---

#### 3.5 HeadMap, TailMap, SubMap (Range Queries)

`TreeMap` supports **range queries** using `headMap`, `tailMap`, and `subMap`.

```java
TreeMap<Integer, String> map = new TreeMap<>();
map.put(10, "A");
map.put(20, "B");
map.put(30, "C");
map.put(40, "D");

System.out.println(map.headMap(30));   // {10=A, 20=B}
System.out.println(map.tailMap(20));   // {20=B, 30=C, 40=D}
System.out.println(map.subMap(10, 40)); // {10=A, 20=B, 30=C}
```

---

### 4. Summary: LinkedHashMap vs TreeMap

| Feature           | `LinkedHashMap`                         | `TreeMap`                                       |
| ----------------- | --------------------------------------- | ----------------------------------------------- |
| **Ordering**      | Maintains **insertion order**           | **Sorted by keys** (Ascending order by default) |
| **Performance**   | `O(1)` for insert, get, remove          | `O(log n)` for insert, get, remove              |
| **Null Keys**     | **Allowed (one null key)**              | **Not allowed** (throws `NullPointerException`) |
| **Best Use Case** | **LRU Caches, Iteration Order Matters** | **Sorted Data Storage, Range Queries**          |

---

## Part 6 | Set in Depth

---

### 1. Introduction to Set Interface

A `Set` in Java is a **collection of unique elements**, meaning **duplicates are not allowed**. It is a part of the **Java Collections Framework (JCF)** and extends the `Collection` interface.

✔ **No Duplicates Allowed**
✔ **Implements Hashing or Tree-based structure**
✔ **Allows Null values (except `TreeSet`)**
✔ **Supports Iteration and Bulk Operations**

#### Hierarchy of Set Interface

```
          Collection
               │
             Set
    ┌────────┴────────┐
 HashSet        SortedSet
    │                 │
 LinkedHashSet      TreeSet
```

---

### 2. Types of Set Implementations in Java

| Type              | Ordering          | Nulls Allowed?     | Performance                            |
| ----------------- | ----------------- | ------------------ | -------------------------------------- |
| **HashSet**       | ❌ No Order        | ✅ One `null` value | **O(1) average case**, O(n) worst case |
| **LinkedHashSet** | ✅ Insertion Order | ✅ One `null` value | Slightly slower than `HashSet`         |
| **TreeSet**       | ✅ Sorted Order    | ❌ No `null` key    | **O(log n) (Red-Black Tree)**          |

---

### 3. HashSet in Depth

#### 3.1 What is `HashSet`?

* Uses a **HashTable (backed by `HashMap`)** to store elements.
* **No ordering is maintained**.
* **Fastest for lookups (O(1) average case)**.

#### 3.2 Internal Working of HashSet

* `HashSet` uses a **HashMap** internally.
* Each element is stored as a **key** in the `HashMap`, and the **value is a dummy object**.

```java
public class HashSet<E> {
    private transient HashMap<E, Object> map;
    private static final Object PRESENT = new Object();

    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }
}
```

#### 3.3 Example of HashSet

```java
import java.util.*;

public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Apple");
        set.add("Banana");
        set.add("Mango");
        set.add("Apple"); // Duplicate ignored

        System.out.println(set); // Output: [Mango, Apple, Banana] (Order not guaranteed)
    }
}
```

---

### 4. LinkedHashSet in Depth

#### 4.1 What is `LinkedHashSet`?

* A subclass of `HashSet` that **maintains insertion order**.
* Uses **Linked List + HashTable** internally.
* **Performance is slightly slower than `HashSet`** due to order maintenance.

#### 4.2 Example of LinkedHashSet

```java
import java.util.*;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();

        set.add("Apple");
        set.add("Banana");
        set.add("Mango");

        System.out.println(set); // Output: [Apple, Banana, Mango] (Insertion Order)
    }
}
```

---

### 5. TreeSet in Depth

#### 5.1 What is `TreeSet`?

* Implements **SortedSet** and maintains **ascending order**.
* Uses **Red-Black Tree (Self-Balancing Binary Search Tree)**.
* **`O(log n)` time complexity** for insert, delete, search.
* **Does not allow `null` values**.

#### 5.2 Example of TreeSet

```java
import java.util.*;

public class TreeSetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();

        set.add(40);
        set.add(10);
        set.add(30);
        set.add(20);

        System.out.println(set); // Output: [10, 20, 30, 40] (Sorted Order)
    }
}
```

---

### 6. Custom Sorting in TreeSet

We can use a **Comparator** for custom ordering.

```java
import java.util.*;

public class CustomTreeSet {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());

        set.add(40);
        set.add(10);
        set.add(30);
        set.add(20);

        System.out.println(set); // Output: [40, 30, 20, 10] (Descending Order)
    }
}
```

---

### 7. Differences Between HashSet, LinkedHashSet, and TreeSet

| Feature           | `HashSet`                  | `LinkedHashSet`            | `TreeSet`                     |
| ----------------- | -------------------------- | -------------------------- | ----------------------------- |
| **Ordering**      | ❌ No Order                 | ✅ Insertion Order          | ✅ Sorted Order                |
| **Performance**   | **O(1)** (Best for search) | **O(1)** (Slightly slower) | **O(log n)** (Red-Black Tree) |
| **Null Values**   | ✅ Allowed                  | ✅ Allowed                  | ❌ Not Allowed                 |
| **Best Use Case** | **Fast Lookup**            | **Ordered Iteration**      | **Sorted Data Storage**       |

---

### 8. Set Operations (Union, Intersection, Difference)

We can perform **mathematical set operations** using Java's `Set`.

```java
import java.util.*;

public class SetOperations {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6));

        // Union
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union: " + union); // Output: [1, 2, 3, 4, 5, 6]

        // Intersection
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection); // Output: [3, 4]

        // Difference
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("Difference: " + difference); // Output: [1, 2]
    }
}
```

---

### 9. When to Use Which Set?

| Scenario                         | Recommended Set |
| -------------------------------- | --------------- |
| Need fast lookup (`O(1)`)        | `HashSet`       |
| Need to preserve insertion order | `LinkedHashSet` |
| Need sorted data (`O(log n)`)    | `TreeSet`       |
| Need range-based queries         | `TreeSet`       |

---

## Part 7 | Streams in Java 8

---

### 1. Introduction to Streams in Java 8

Java **Streams** (introduced in Java 8) provide a **functional-style** approach to processing collections. It allows operations on large amounts of data in a **declarative, parallelizable, and efficient** manner.

✔ **Declarative (Concise and Readable Code)**
✔ **Efficient (Lazy Evaluation, Parallel Execution)**
✔ **Supports Functional Programming**
✔ **Does NOT modify the original collection**

#### Hierarchy of Stream API

```
Collection
     │
Stream API
     │
     ├── Stream<T> (For Objects)
     ├── IntStream (For int)
     ├── LongStream (For long)
     └── DoubleStream (For double)
```

---

### 2. Creating a Stream in Java

There are multiple ways to create a Stream:

#### 2.1 From Collections (List, Set, etc.)

```java
import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Mango");
        Stream<String> stream = list.stream(); // Convert List to Stream
        stream.forEach(System.out::println);
    }
}
```

#### 2.2 From Arrays

```java
String[] arr = { "A", "B", "C" };
Stream<String> stream = Arrays.stream(arr);
stream.forEach(System.out::println);
```

#### 2.3 Using `Stream.of()`

```java
Stream<Integer> stream = Stream.of(1, 2, 3, 4);
stream.forEach(System.out::println);
```

#### 2.4 Using `Stream.generate()` (Infinite Stream)

```java
Stream<Integer> infiniteStream = Stream.generate(() -> 5);
infiniteStream.limit(5).forEach(System.out::println); // 5, 5, 5, 5, 5
```

#### 2.5 Using `Stream.iterate()`

```java
Stream<Integer> stream = Stream.iterate(1, n -> n + 2);
stream.limit(5).forEach(System.out::println); // 1, 3, 5, 7, 9
```

---

### 3. Stream Operations

Stream API supports **Intermediate** and **Terminal** operations.

| Type                 | Example Methods                                 | Description                               |
| -------------------- | ----------------------------------------------- | ----------------------------------------- |
| **Intermediate**     | `filter()`, `map()`, `sorted()`, `distinct()`   | Transform the stream (Lazy Evaluation)    |
| **Terminal**         | `forEach()`, `collect()`, `count()`, `reduce()` | Produces the result and closes the stream |
| **Short-Circuiting** | `limit()`, `findFirst()`, `findAny()`           | Stops execution early                     |

---

### 4. Intermediate Operations in Streams

#### 4.1 `filter(Predicate)` - Filtering Elements

```java
List<String> names = Arrays.asList("John", "Alex", "Tom", "Amanda");
names.stream()
     .filter(name -> name.startsWith("A"))
     .forEach(System.out::println);  // Output: Alex, Amanda
```

#### 4.2 `map(Function)` - Transforming Elements

```java
List<String> names = Arrays.asList("apple", "banana", "cherry");
names.stream()
     .map(String::toUpperCase)
     .forEach(System.out::println); // APPLE, BANANA, CHERRY
```

#### 4.3 `sorted()` - Sorting Elements

```java
List<Integer> numbers = Arrays.asList(5, 2, 8, 1);
numbers.stream()
       .sorted()
       .forEach(System.out::println); // Output: 1, 2, 5, 8
```

#### 4.4 `distinct()` - Removing Duplicates

```java
List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4);
numbers.stream()
       .distinct()
       .forEach(System.out::println); // Output: 1, 2, 3, 4
```

#### 4.5 `limit(n)` - Limiting the Stream

```java
Stream.of(10, 20, 30, 40, 50)
      .limit(3)
      .forEach(System.out::println); // Output: 10, 20, 30
```

---

### 5. Terminal Operations in Streams

#### 5.1 `forEach()` - Iterate Over Stream

```java
Stream.of("A", "B", "C").forEach(System.out::println);
```

#### 5.2 `collect()` - Convert Stream to Collection

```java
List<String> list = Stream.of("Apple", "Banana", "Cherry")
                          .collect(Collectors.toList());
System.out.println(list); // Output: [Apple, Banana, Cherry]
```

#### 5.3 `count()` - Counting Elements

```java
long count = Stream.of(1, 2, 3, 4, 5).count();
System.out.println(count); // Output: 5
```

#### 5.4 `reduce()` - Aggregate Elements

```java
int sum = Stream.of(1, 2, 3, 4)
                .reduce(0, Integer::sum);
System.out.println(sum); // Output: 10
```

---

### 6. Parallel Streams for Performance

Java Streams can be processed in parallel to **improve performance** on multi-core processors.

#### 6.1 Parallel Stream Example

```java
import java.util.*;
import java.util.stream.*;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.range(1, 10).boxed().collect(Collectors.toList());

        numbers.parallelStream()
               .forEach(num -> System.out.println(Thread.currentThread().getName() + " -> " + num));
    }
}
```

🔹 **Parallel streams can be unpredictable** due to multithreading.

---

### 7. Stream vs Collections

| Feature          | Collections                        | Streams                      |
| ---------------- | ---------------------------------- | ---------------------------- |
| **Modification** | Can modify elements                | Cannot modify original data  |
| **Iteration**    | External Iteration (for-loop)      | Internal Iteration           |
| **Performance**  | Less Efficient (More Memory Usage) | Optimized for Performance    |
| **Execution**    | Sequential                         | Supports Parallel Processing |

---

### 8. When to Use Streams?

✔ When working with **large datasets**
✔ When **performance optimization** is needed
✔ When **functional programming** is preferred
✔ When operations can be **chained together**

---

## Java 21: Sequenced Collections

---

### 🔹 What Are Sequenced Collections?

Java 21 introduced **`SequencedCollection`**, **`SequencedSet`**, and **`SequencedMap`** interfaces to provide a consistent and uniform API for collections that **preserve element order** (typically insertion or sorted order).

---

### 🔹 Key Motivation

Before Java 21:

* Different ordered collections had **inconsistent method names** for common operations:
  * `List`: `get(0)`, `add(0, x)`, `listIterator()`
  * `Deque`: `getFirst()`, `addLast()`, `removeFirst()`
  * `TreeSet`: `first()`, `last()`, `descendingIterator()`

* This created **confusion, verbosity**, and **hard-to-maintain code**.

**Java 21 Solution:**
✅ Introduce **common interfaces** to unify and simplify operations on **ordered collections**.

---

### 🔹 New Interfaces & Core Methods

#### 1. `SequencedCollection<E>`

Adds:
* `getFirst()`, `getLast()`
* `addFirst(E)`, `addLast(E)`
* `removeFirst()`, `removeLast()`
* `reversed()` – returns a reverse view (not a copy)

#### 2. `SequencedSet<E>` extends `SequencedCollection<E>`

* Same methods + **no duplicates**

#### 3. `SequencedMap<K,V>`

Adds:
* `firstEntry()`, `lastEntry()`
* `putFirst(K, V)`, `putLast(K, V)`
* `pollFirstEntry()`, `pollLastEntry()`
* `reversed()` – returns a reverse view

---

### 🔹 Who Implements What?

| Collection Type             | Implements          | Why / Why Not?                |
| --------------------------- | ------------------- | ----------------------------- |
| ArrayList                   | SequencedCollection | Maintains insertion order     |
| LinkedList                  | SequencedCollection | Doubly linked list            |
| `Deque` (e.g. `ArrayDeque`) | SequencedCollection | Order-preserving              |
| LinkedHashSet               | SequencedSet        | Ordered, no duplicates        |
| TreeSet                     | SequencedSet        | Sorted, no duplicates         |
| HashSet                     | ❌                   | Unordered                     |
| PriorityQueue               | ❌                   | Maintains priority, not order |
| LinkedHashMap               | SequencedMap        | Preserves insertion order     |
| TreeMap                     | SequencedMap        | Sorted order                  |
| `HashMap`, `Hashtable`      | ❌                   | Do not preserve order         |

---

### 🔹 Why `SequencedSet` Was Introduced

* `Set` types like `LinkedHashSet` and `TreeSet` maintain order but **disallow duplicates**.
* Hence, `SequencedSet` was needed as a **distinct interface from `SequencedCollection`**, which allows duplicates.

---

### 🔹 Unsupported Operations

* For `SortedSet` and `SortedMap` (e.g., `TreeSet`, `TreeMap`):
  * Methods like `addFirst()`, `addLast()`, `putFirst()`, `putLast()` may throw `UnsupportedOperationException`.
  * These collections auto-sort; insertion order has no meaning.

---

### 🔹 Reverse View

* `reversed()` gives a **read-only reversed view** of the collection or map.
* It does **not mutate** the original collection.

---

### 🔹 Benefits

* **Cleaner code**: Unified method names
* **Reduced boilerplate**: No need for manual indexing or iterators
* Improved readability and maintenance
* Encourages consistent coding practices

---

### 🔹 Examples: Unified Usage

```java
SequencedCollection<String> list = new ArrayList<>(List.of("B", "C", "D"));
list.addFirst("A");
list.addLast("E");
System.out.println(list.getFirst());  // A
System.out.println(list.getLast());   // E
System.out.println(list.reversed());  // [E, D, C, B, A]
```

```java
SequencedMap<Integer, String> map = new LinkedHashMap<>();
map.putFirst(1, "A");
map.putLast(2, "B");
System.out.println(map.firstEntry());  // 1=A
System.out.println(map.lastEntry());   // 2=B
System.out.println(map.reversed());    // {2=B, 1=A}
```

---

### 🧠 Conclusion

Java 21's `Sequenced*` interfaces solve a long-standing inconsistency in the Collection API by:

* Introducing **common access methods**
* Improving **developer ergonomics**
* Reducing code complexity

This feature is a **major API enhancement** that helps standardize how we interact with ordered collections.
