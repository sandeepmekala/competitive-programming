# 1. Basic Java structure

```java
class Solution {
    
    public int example(int[] nums) {
        return 0;
    }
}
```

Most online coding platforms give you something like this.

For example:

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // your solution
        
        return new int[]{};
    }
}
```

### Main point

You usually write:

```java
class Solution {
    public ReturnType methodName(Parameters...) {
        // solution
    }
}
```

---

# 2. Variables and primitive types

The most common types:

```java
int x = 10;
long count = 100L;
double value = 10.5;
boolean found = false;
char ch = 'a';
```

For DSA, mostly:

```java
int
long
boolean
char
```

### `int` vs `long`

Be careful about overflow.

```java
int a = 100000;
int b = 100000;

long result = (long) a * b;
```

Without casting:

```java
long result = a * b; // overflow can happen before assignment
```

Use:

```java
long result = (long) a * b;
```

This is a common interview mistake.

---

# 3. Arrays

## Declaration

```java
int[] nums = new int[5];
```

Or:

```java
int[] nums = {1, 2, 3, 4, 5};
```

## Access

```java
int x = nums[0];

nums[0] = 10;
```

## Length

```java
int n = nums.length;
```

⚠️ Arrays use:

```java
nums.length
```

Not:

```java
nums.length()
```

---

# 4. Loops

## Normal `for` loop

Most common for DSA:

```java
for (int i = 0; i < nums.length; i++) {
    System.out.println(nums[i]);
}
```

Reverse:

```java
for (int i = nums.length - 1; i >= 0; i--) {
    
}
```

## Enhanced for loop

```java
for (int num : nums) {
    System.out.println(num);
}
```

Very useful when you don't need the index.

Example:

```java
int sum = 0;

for (int num : nums) {
    sum += num;
}
```

## While loop

Very common in two-pointer/sliding-window problems:

```java
int left = 0;
int right = 0;

while (left <= right) {
    // logic
}
```

Example:

```java
while (right < nums.length) {
    // expand window
    right++;
}
```

---

# 5. `if`, `else`, logical operators

```java
if (x > 10) {
    
} else if (x == 10) {
    
} else {
    
}
```

Logical operators:

```java
&&  // AND
||  // OR
!   // NOT
```

Example:

```java
if (left < right && nums[left] + nums[right] == target) {
    
}
```

---

# 6. Strings

Strings are immutable.

```java
String s = "hello";
```

## Length

```java
int n = s.length();
```

⚠️ Unlike arrays:

```java
s.length()
```

## Character access

```java
char ch = s.charAt(0);
```

## Substring

```java
String sub = s.substring(1, 4);
```

This means index `1` through `3`.

## Comparison

❌ Don't use:

```java
if (s1 == s2)
```

Use:

```java
if (s1.equals(s2))
```

Or:

```java
if (s1.equalsIgnoreCase(s2))
```

## Convert String to char array

```java
char[] chars = s.toCharArray();
```

Very useful:

```java
for (char ch : s.toCharArray()) {
    
}
```

---

# 7. StringBuilder ⭐

Very useful because `String` concatenation repeatedly can be inefficient.

```java
StringBuilder sb = new StringBuilder();

sb.append("hello");
sb.append(" world");

String result = sb.toString();
```

Common operations:

```java
sb.append('a');
sb.append("abc");

sb.deleteCharAt(sb.length() - 1);

sb.setLength(0); // clear

sb.reverse();
```

Example:

```java
StringBuilder sb = new StringBuilder();

for (char ch : s.toCharArray()) {
    sb.append(ch);
}

return sb.reverse().toString();
```

---

# 8. Methods

Example:

```java
public int add(int a, int b) {
    return a + b;
}
```

Helper method:

```java
class Solution {

    public boolean isPalindrome(String s) {
        return check(s);
    }

    private boolean check(String s) {
        return true;
    }
}
```

You will frequently use helper methods in:

* DFS
* Backtracking
* Linked Lists
* Trees

---

# 9. Pass-by-value — important Java concept

Java is always **pass-by-value**.

But for objects, the value copied is the reference.

Example:

```java
void modify(int x) {
    x = 100;
}
```

Original integer doesn't change.

For arrays:

```java
void modify(int[] nums) {
    nums[0] = 100;
}
```

The array contents change.

This is useful to remember during recursion and backtracking.

---

# 10. Arrays utility methods

Import:

```java
import java.util.*;
```

## Sort

```java
Arrays.sort(nums);
```

Example:

```java
int[] nums = {5, 2, 8, 1};

Arrays.sort(nums);
```

Result:

```text
[1, 2, 5, 8]
```

## Fill

```java
Arrays.fill(nums, -1);
```

Very common for DP:

```java
int[] dp = new int[n];

Arrays.fill(dp, -1);
```

## Copy

```java
int[] copy = Arrays.copyOf(nums, nums.length);
```

## Print/debug

```java
System.out.println(Arrays.toString(nums));
```

For 2D arrays:

```java
System.out.println(Arrays.deepToString(grid));
```

---

# 11. 2D Arrays / Matrices

Declaration:

```java
int[][] grid = new int[m][n];
```

Example:

```java
int[][] grid = {
    {1, 2, 3},
    {4, 5, 6}
};
```

Access:

```java
grid[0][1];
```

Traversal:

```java
for (int i = 0; i < grid.length; i++) {
    for (int j = 0; j < grid[0].length; j++) {
        // grid[i][j]
    }
}
```

Or:

```java
for (int[] row : grid) {
    for (int value : row) {
        
    }
}
```

---

# 12. Common `Math` operations

```java
Math.max(a, b);
Math.min(a, b);
Math.abs(x);
```

Integer division:

```java
int mid = left + (right - left) / 2;
```

Use this for binary search instead of:

```java
int mid = (left + right) / 2;
```

The first avoids potential integer overflow.

---

# 13. Ternary operator

```java
int max = a > b ? a : b;
```

Equivalent to:

```java
int max;

if (a > b) {
    max = a;
} else {
    max = b;
}
```

Useful, but don't overuse it in interviews.

---

# The syntax cheatsheet I want you to memorize first

```java
// Array
int[] nums = new int[n];
int n = nums.length;

// Loop
for (int i = 0; i < n; i++) {}

for (int x : nums) {}

while (left <= right) {}

// String
String s = "hello";
s.length();
s.charAt(i);
s.substring(start, end);
s.equals(other);
s.toCharArray();

// StringBuilder
StringBuilder sb = new StringBuilder();
sb.append(x);
sb.toString();
sb.reverse();

// Arrays
Arrays.sort(nums);
Arrays.fill(nums, -1);
Arrays.toString(nums);

// Math
Math.max(a, b);
Math.min(a, b);
Math.abs(x);

// Safe binary search mid
int mid = left + (right - left) / 2;
```

Sure. Let's cover **2. HashMap + HashSet, 3. ArrayList + LinkedList, and 4. Stack / Deque / Queue** together.

For DSA, these are the **most important Java collections** to get comfortable with.

Start every LeetCode-style solution with:

```java
import java.util.*;
```

This gives you access to all of them.

---

# 2. HashMap

Use a `HashMap` when you need:

> **key → value**

Typical DSA uses:

* Number → frequency
* Character → frequency
* Number → index
* Node → something
* Prefix sum → index/count

## Create

```java
Map<Integer, Integer> map = new HashMap<>();
```

Example:

```java
Map<Integer, Integer> frequency = new HashMap<>();
```

---

## Put

```java
map.put(1, 100);
```

Means:

```text
key = 1
value = 100
```

Example:

```java
map.put('a', 5);
```

For characters:

```java
Map<Character, Integer> map = new HashMap<>();
```

---

## Get

```java
int value = map.get(key);
```

But be careful:

```java
map.get(key);
```

returns `null` if the key doesn't exist.

For DSA, often use:

```java
int count = map.getOrDefault(key, 0);
```

### Frequency counting ⭐

```java
Map<Integer, Integer> freq = new HashMap<>();

for (int num : nums) {
    freq.put(num, freq.getOrDefault(num, 0) + 1);
}
```

This is one of the most important patterns to memorize.

---

## Check if key exists

```java
map.containsKey(key);
```

Example:

```java
if (map.containsKey(target)) {
    
}
```

---

## Remove

```java
map.remove(key);
```

---

## Two Sum pattern ⭐

```java
public int[] twoSum(int[] nums, int target) {

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {

        int complement = target - nums[i];

        if (map.containsKey(complement)) {
            return new int[]{map.get(complement), i};
        }

        map.put(nums[i], i);
    }

    return new int[]{};
}
```

This pattern is extremely important.

---

## Iterate through HashMap

### Keys

```java
for (int key : map.keySet()) {
    System.out.println(key);
}
```

### Values

```java
for (int value : map.values()) {
    System.out.println(value);
}
```

### Key + Value ⭐

```java
for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    int key = entry.getKey();
    int value = entry.getValue();
}
```

You will use this frequently.

---

# HashSet

Use `HashSet` when you need:

> **Fast lookup + unique values**

## Create

```java
Set<Integer> set = new HashSet<>();
```

## Add

```java
set.add(10);
set.add(20);
set.add(10);
```

Result:

```text
[10, 20]
```

Duplicates are ignored.

---

## Check existence ⭐

```java
if (set.contains(10)) {
    
}
```

Example: duplicate detection.

```java
public boolean containsDuplicate(int[] nums) {

    Set<Integer> seen = new HashSet<>();

    for (int num : nums) {
        if (seen.contains(num)) {
            return true;
        }

        seen.add(num);
    }

    return false;
}
```

---

## Remove

```java
set.remove(10);
```

## Size

```java
set.size();
```

## Iterate

```java
for (int num : set) {
    
}
```

---

# Quick HashMap / HashSet cheat sheet

```java
// HashMap
Map<Integer, Integer> map = new HashMap<>();

map.put(key, value);
map.get(key);
map.getOrDefault(key, 0);
map.containsKey(key);
map.remove(key);

map.keySet();
map.values();
map.entrySet();

// HashSet
Set<Integer> set = new HashSet<>();

set.add(value);
set.contains(value);
set.remove(value);
set.size();
```

---

# 3. ArrayList

Think of `ArrayList` as a **dynamic array**.

Unlike:

```java
int[] nums = new int[5];
```

an `ArrayList` can grow dynamically.

## Create

```java
List<Integer> list = new ArrayList<>();
```

Prefer declaring with the interface:

```java
List<Integer> list = new ArrayList<>();
```

rather than:

```java
ArrayList<Integer> list = new ArrayList<>();
```

---

## Add

```java
list.add(10);
list.add(20);
list.add(30);
```

---

## Access

```java
int value = list.get(0);
```

Unlike arrays:

```java
nums[0]
```

ArrayList uses:

```java
list.get(0)
```

---

## Update

```java
list.set(0, 100);
```

---

## Remove ⚠️

### Remove by index

```java
list.remove(0);
```

Removes the first element.

### Remove by value

For `Integer`, be explicit:

```java
list.remove(Integer.valueOf(10));
```

This removes value `10`.

This distinction is important:

```java
list.remove(1);
```

means remove **index 1**, not necessarily value `1`.

---

## Size

```java
int n = list.size();
```

Not:

```java
list.length
```

---

## Iterate

```java
for (int i = 0; i < list.size(); i++) {
    int value = list.get(i);
}
```

Or:

```java
for (int value : list) {
    
}
```

---

## Convert ArrayList to array

```java
List<Integer> list = new ArrayList<>();

int[] nums = list.stream()
                 .mapToInt(Integer::intValue)
                 .toArray();
```

You won't need this very often in interviews.

---

## Common use: Graph adjacency list

```java
List<List<Integer>> graph = new ArrayList<>();

for (int i = 0; i < n; i++) {
    graph.add(new ArrayList<>());
}

graph.get(0).add(1);
graph.get(0).add(2);
```

This represents:

```text
0 → 1
0 → 2
```

Very important for graph problems.

---

# LinkedList

A `LinkedList` implements both `List` and `Deque`.

But for DSA, an important recommendation:

> **Don't automatically use `LinkedList` as your stack or queue. Prefer `ArrayDeque`.**

For a normal list:

```java
List<Integer> list = new LinkedList<>();
```

You can use:

```java
list.add(10);
list.add(20);

list.get(0);
list.remove(0);
```

But remember:

* `ArrayList` → fast random access
* `LinkedList` → efficient insertion/removal when you already have the position/node

For most array/list-based DSA problems, **ArrayList is more common**.

### Important distinction

Don't confuse Java's:

```java
LinkedList<Integer>
```

with the `ListNode` you typically implement/use in linked-list DSA problems.

For example:

```java
class ListNode {
    int val;
    ListNode next;
}
```

Most interview linked-list problems use `ListNode`, **not** `java.util.LinkedList`.

---

# 4. Stack, Queue and Deque ⭐⭐⭐

This is where Java syntax can confuse people.

My recommendation:

> **Use `Deque` backed by `ArrayDeque` for both Stack and Queue.**

---

# Stack

Old Java class:

```java
Stack<Integer> stack = new Stack<>();
```

You *can* use it:

```java
stack.push(10);
stack.pop();
stack.peek();
stack.isEmpty();
```

But modern Java preference for DSA:

```java
Deque<Integer> stack = new ArrayDeque<>();
```

## Push

```java
stack.push(10);
stack.push(20);
```

Stack:

```text
TOP
20
10
```

## Peek

```java
int top = stack.peek();
```

Returns `20`.

## Pop

```java
int value = stack.pop();
```

Removes and returns `20`.

## Empty

```java
stack.isEmpty();
```

### Typical use

```java
Deque<Character> stack = new ArrayDeque<>();

for (char ch : s.toCharArray()) {

    if (ch == '(') {
        stack.push(ch);
    } else {
        char top = stack.pop();
    }
}
```

Common for:

* Valid Parentheses
* Monotonic Stack
* Expression evaluation
* Next Greater Element

---

# Queue

Use:

```java
Queue<Integer> queue = new ArrayDeque<>();
```

Think:

```text
Front → 10 → 20 → 30 → Back
```

## Add

```java
queue.offer(10);
queue.offer(20);
queue.offer(30);
```

Use `offer()` in interviews.

## Peek

```java
int front = queue.peek();
```

Doesn't remove.

## Remove

```java
int value = queue.poll();
```

Removes from the front.

## Empty

```java
queue.isEmpty();
```

### Typical BFS pattern ⭐

```java
Queue<Integer> queue = new ArrayDeque<>();

queue.offer(start);

while (!queue.isEmpty()) {

    int node = queue.poll();

    // process node

    for (int neighbor : graph.get(node)) {
        queue.offer(neighbor);
    }
}
```

This pattern is essential for BFS.

---

# Deque

`Deque` means **double-ended queue**.

```java
Deque<Integer> deque = new ArrayDeque<>();
```

You can operate at both ends.

## Add first / last

```java
deque.addFirst(10);
deque.addLast(20);
```

Result:

```text
10 → 20
```

## Peek

```java
deque.peekFirst();
deque.peekLast();
```

## Remove

```java
deque.pollFirst();
deque.pollLast();
```

---

## Why `Deque` is powerful

The same object can behave like a stack:

```java
Deque<Integer> stack = new ArrayDeque<>();

stack.push(10);
stack.push(20);

stack.pop();
stack.peek();
```

Or a queue:

```java
Queue<Integer> queue = new ArrayDeque<>();

queue.offer(10);
queue.offer(20);

queue.poll();
queue.peek();
```

---

# Monotonic Deque example

Useful later for Sliding Window Maximum.

```java
Deque<Integer> deque = new ArrayDeque<>();
```

Usually store **indices**, not values:

```java
while (!deque.isEmpty() &&
       nums[deque.peekLast()] < nums[i]) {

    deque.pollLast();
}

deque.offerLast(i);
```

Don't worry about mastering this now. Just recognize the syntax.

---

# One very important distinction: `add/remove` vs `offer/poll`

For DSA, I recommend remembering:

### Queue

```java
queue.offer(x); // add
queue.poll();   // remove
queue.peek();   // see
```

### Stack

```java
stack.push(x);  // add
stack.pop();    // remove
stack.peek();   // see
```

This makes your code easier to read.

---

# Master Cheat Sheet: Topics 2, 3, 4

```java
import java.util.*;

// ==================== HASHMAP ====================

Map<Integer, Integer> map = new HashMap<>();

map.put(key, value);
map.get(key);
map.getOrDefault(key, 0);
map.containsKey(key);
map.remove(key);

for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    int key = entry.getKey();
    int value = entry.getValue();
}


// ==================== HASHSET ====================

Set<Integer> set = new HashSet<>();

set.add(x);
set.contains(x);
set.remove(x);
set.size();


// ==================== ARRAYLIST ====================

List<Integer> list = new ArrayList<>();

list.add(x);
list.get(i);
list.set(i, x);
list.remove(i);
list.size();


// ==================== STACK ====================

Deque<Integer> stack = new ArrayDeque<>();

stack.push(x);
stack.pop();
stack.peek();
stack.isEmpty();


// ==================== QUEUE ====================

Queue<Integer> queue = new ArrayDeque<>();

queue.offer(x);
queue.poll();
queue.peek();
queue.isEmpty();


// ==================== DEQUE ====================

Deque<Integer> deque = new ArrayDeque<>();

deque.offerFirst(x);
deque.offerLast(x);

deque.pollFirst();
deque.pollLast();

deque.peekFirst();
deque.peekLast();
```

## What I want you to remember most

If you remember just these patterns, you're already covered for a huge number of DSA problems:

```java
// Frequency
map.put(x, map.getOrDefault(x, 0) + 1);

// Fast existence check
if (set.contains(x)) {}

// Stack
stack.push(x);
stack.pop();
stack.peek();

// Queue / BFS
queue.offer(x);
int current = queue.poll();

// Dynamic list
list.add(x);
list.get(i);
```

### Next: **5. PriorityQueue (Heap) + 6. Sorting and Comparator**

These two also go very well together and are the next important Java tools for DSA.
Great. These three topics are also closely connected. Let's focus on the **Java syntax and patterns you actually need for DSA interviews**.

# 5. PriorityQueue (Heap) ⭐

In Java, `PriorityQueue` is usually used for heap problems.

```java
import java.util.*;
```

## Default: Min Heap

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

The smallest element has the highest priority.

```java
pq.offer(5);
pq.offer(2);
pq.offer(8);

System.out.println(pq.peek()); // 2
```

### Important operations

```java
pq.offer(x);  // add
pq.poll();    // remove and return smallest
pq.peek();    // see smallest
pq.isEmpty();
pq.size();
```

Example:

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();

pq.offer(5);
pq.offer(2);
pq.offer(8);

while (!pq.isEmpty()) {
    System.out.println(pq.poll());
}
```

Output:

```text
2
5
8
```

---

## Max Heap ⭐

Java does not have a direct `MaxPriorityQueue`.

Use a comparator:

```java
PriorityQueue<Integer> pq =
    new PriorityQueue<>(Collections.reverseOrder());
```

Example:

```java
pq.offer(5);
pq.offer(2);
pq.offer(8);

System.out.println(pq.peek()); // 8
```

Poll order:

```text
8
5
2
```

### Syntax to memorize

```java
// Min Heap
PriorityQueue<Integer> minHeap = new PriorityQueue<>();

// Max Heap
PriorityQueue<Integer> maxHeap =
    new PriorityQueue<>(Collections.reverseOrder());
```

---

## Custom PriorityQueue with Comparator

Suppose we have an array:

```java
int[][] points = {
    {1, 3},
    {-2, 2},
    {5, 8}
};
```

Create a heap based on the first value:

```java
PriorityQueue<int[]> pq =
    new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
```

This is a **min heap based on `a[0]`**.

For max heap:

```java
PriorityQueue<int[]> pq =
    new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
```

### Important: Don't do subtraction

Avoid:

```java
(a, b) -> a[0] - b[0]
```

because subtraction can overflow.

Prefer:

```java
Integer.compare(a[0], b[0])
```

---

## Top K pattern ⭐⭐⭐

One of the most common heap patterns.

Suppose you want the **K largest elements**.

Use a **min heap of size K**:

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();

for (int num : nums) {
    minHeap.offer(num);

    if (minHeap.size() > k) {
        minHeap.poll();
    }
}
```

At the end:

```java
minHeap
```

contains the `k` largest elements.

Why?

```text
Keep K elements
Remove smallest whenever size > K
```

Similarly, for **K smallest elements**, you can use a max heap of size `K`.

---

## Kth Largest Element ⭐

```java
public int findKthLargest(int[] nums, int k) {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int num : nums) {
        minHeap.offer(num);

        if (minHeap.size() > k) {
            minHeap.poll();
        }
    }

    return minHeap.peek();
}
```

This is an important pattern to understand.

---

## Heap of objects

Suppose:

```java
class Task {
    int priority;
    String name;

    Task(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }
}
```

Create a heap:

```java
PriorityQueue<Task> pq =
    new PriorityQueue<>(
        (a, b) -> Integer.compare(a.priority, b.priority)
    );
```

Then:

```java
pq.offer(new Task(2, "Low"));
pq.offer(new Task(1, "High"));

Task task = pq.poll();
```

---

# PriorityQueue Cheat Sheet

```java
// Min Heap
PriorityQueue<Integer> minHeap = new PriorityQueue<>();

// Max Heap
PriorityQueue<Integer> maxHeap =
    new PriorityQueue<>(Collections.reverseOrder());

// Add
pq.offer(x);

// Remove highest priority
pq.poll();

// View highest priority
pq.peek();

// Custom comparator
PriorityQueue<int[]> pq =
    new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
```

---

# 6. Sorting + Comparator ⭐⭐⭐

Sorting is used everywhere in DSA.

## Sort primitive array

```java
int[] nums = {5, 2, 8, 1};

Arrays.sort(nums);
```

Result:

```text
[1, 2, 5, 8]
```

---

## Sort a range

```java
Arrays.sort(nums, fromIndex, toIndex);
```

Example:

```java
Arrays.sort(nums, 1, 4);
```

`toIndex` is exclusive.

---

# Sort ArrayList / List

```java
List<Integer> list = new ArrayList<>();

Collections.sort(list);
```

Or modern syntax:

```java
list.sort(Comparator.naturalOrder());
```

Descending:

```java
list.sort(Comparator.reverseOrder());
```

---

# Sorting primitive arrays in descending order ⚠️

This doesn't work:

```java
Arrays.sort(nums, Collections.reverseOrder());
```

because `int[]` is primitive.

Options:

### Option 1: Use `Integer[]`

```java
Integer[] nums = {5, 2, 8, 1};

Arrays.sort(nums, Collections.reverseOrder());
```

### Option 2: Sort ascending and process backwards

Often better for DSA:

```java
Arrays.sort(nums);

for (int i = nums.length - 1; i >= 0; i--) {
    // descending order
}
```

---

# Sorting 2D arrays ⭐

Very common for intervals.

Example:

```java
int[][] intervals = {
    {1, 3},
    {2, 6},
    {8, 10}
};
```

Sort by start time:

```java
Arrays.sort(
    intervals,
    (a, b) -> Integer.compare(a[0], b[0])
);
```

Sort by end time:

```java
Arrays.sort(
    intervals,
    (a, b) -> Integer.compare(a[1], b[1])
);
```

Descending by first value:

```java
Arrays.sort(
    intervals,
    (a, b) -> Integer.compare(b[0], a[0])
);
```

### Syntax to memorize

```java
Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
```

This will be used repeatedly in interval problems.

---

# Comparator chaining

Suppose we have:

```java
class Person {
    int age;
    String name;
}
```

Sort by age, then name:

```java
people.sort(
    Comparator.comparingInt((Person p) -> p.age)
              .thenComparing(p -> p.name)
);
```

For DSA, you don't need to memorize every comparator API. The lambda form is usually enough:

```java
(a, b) -> Integer.compare(a.value, b.value)
```

---

# 7. Recursion syntax ⭐⭐⭐

This is extremely important before Trees, Graphs, Backtracking and DP.

## Basic recursion

A recursive method calls itself.

```java
public void solve(int n) {

    if (n == 0) {
        return;
    }

    solve(n - 1);
}
```

The two things every recursion needs are:

### 1. Base case

```java
if (n == 0) {
    return;
}
```

### 2. Recursive call

```java
solve(n - 1);
```

---

# Return value recursion

Example: factorial.

```java
public int factorial(int n) {

    if (n <= 1) {
        return 1;
    }

    return n * factorial(n - 1);
}
```

Execution:

```text
factorial(4)
= 4 * factorial(3)
= 4 * 3 * factorial(2)
= 4 * 3 * 2 * factorial(1)
= 24
```

---

# DFS-style recursion template ⭐

You will use this constantly.

```java
private void dfs(Node node) {

    if (node == null) {
        return;
    }

    // Process current node

    dfs(node.left);
    dfs(node.right);
}
```

For a tree, this is preorder traversal.

The general idea:

```java
private void dfs(State state) {

    // 1. Base condition
    if (baseCondition) {
        return;
    }

    // 2. Process current state

    // 3. Recursive calls
    dfs(nextState1);
    dfs(nextState2);
}
```

---

# Recursion with parameters

Example: traverse an array.

```java
private void dfs(int[] nums, int index) {

    if (index == nums.length) {
        return;
    }

    // process
    System.out.println(nums[index]);

    dfs(nums, index + 1);
}
```

---

# Recursion with a shared result

Very common.

```java
class Solution {

    private int max = Integer.MIN_VALUE;

    public int solve(int[] nums) {
        dfs(nums, 0);
        return max;
    }

    private void dfs(int[] nums, int index) {

        if (index == nums.length) {
            return;
        }

        max = Math.max(max, nums[index]);

        dfs(nums, index + 1);
    }
}
```

The field:

```java
private int max;
```

is shared across recursive calls.

You will see this often in tree problems.

---

# Recursion returning a result

Sometimes this is cleaner than a global/shared variable.

```java
private int dfs(int[] nums, int index) {

    if (index == nums.length) {
        return 0;
    }

    return nums[index] + dfs(nums, index + 1);
}
```

Rule of thumb:

### Use `void` when:

The recursion updates something externally.

```java
void dfs(...)
```

### Return a value when:

Each recursive call contributes a result.

```java
int dfs(...)
```

---

# Backtracking syntax ⭐⭐⭐

This is one of the most important recursion patterns.

Example: generate subsets.

```java
class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(
            nums,
            0,
            new ArrayList<>(),
            result
        );

        return result;
    }

    private void backtrack(
            int[] nums,
            int index,
            List<Integer> current,
            List<List<Integer>> result) {

        // Base case
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Choice 1: include
        current.add(nums[index]);

        backtrack(nums, index + 1, current, result);

        // Undo choice ⭐
        current.remove(current.size() - 1);

        // Choice 2: exclude
        backtrack(nums, index + 1, current, result);
    }
}
```

### Most important backtracking pattern

```java
// Make choice
current.add(x);

// Recurse
backtrack(...);

// Undo choice
current.remove(current.size() - 1);
```

Memorize:

> **Choose → Explore → Unchoose**

---

# Copying a list in recursion ⚠️

This is a common Java mistake.

Correct:

```java
result.add(new ArrayList<>(current));
```

Incorrect:

```java
result.add(current);
```

Why?

Because `current` continues changing during backtracking. Without making a copy, all entries can refer to the same list.

---

# Recursion with `StringBuilder`

Also useful for backtracking.

```java
private void dfs(StringBuilder current) {

    // Choose
    current.append('a');

    // Explore
    dfs(current);

    // Undo
    current.deleteCharAt(current.length() - 1);
}
```

Same pattern:

> Choose → Explore → Unchoose

---

# Master Cheat Sheet

## PriorityQueue

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();

PriorityQueue<Integer> maxHeap =
    new PriorityQueue<>(Collections.reverseOrder());

pq.offer(x);
pq.poll();
pq.peek();
```

Custom:

```java
PriorityQueue<int[]> pq =
    new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
```

---

## Sorting

```java
Arrays.sort(nums);

Arrays.sort(
    intervals,
    (a, b) -> Integer.compare(a[0], b[0])
);

list.sort(Comparator.naturalOrder());

list.sort(Comparator.reverseOrder());
```

---

## Recursion

```java
private void dfs(int index) {

    // Base case
    if (index == n) {
        return;
    }

    // Process

    // Recurse
    dfs(index + 1);
}
```

### Backtracking

```java
// Choose
current.add(x);

// Explore
dfs(...);

// Unchoose
current.remove(current.size() - 1);
```

---

Great. These are the last major Java syntax/templates you need before we start solving DSA patterns.

# 8. Linked List (`ListNode`) syntax

In LeetCode, the `ListNode` definition is usually provided:

```java
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
```

You normally don't need to write this yourself.

## Traverse a linked list

```java
ListNode current = head;

while (current != null) {
    // use current.val

    current = current.next;
}
```

This is the most important pattern.

### Example: Sum all values

```java
public int sum(ListNode head) {
    int sum = 0;

    ListNode current = head;

    while (current != null) {
        sum += current.val;
        current = current.next;
    }

    return sum;
}
```

---

## Create a node

```java
ListNode node = new ListNode(10);
```

Set next:

```java
node.next = new ListNode(20);
```

Creates:

```text
10 -> 20 -> null
```

---

## Dummy node ⭐⭐⭐

One of the most useful linked-list patterns.

```java
ListNode dummy = new ListNode(0);
ListNode current = dummy;
```

Then:

```java
current.next = new ListNode(10);
current = current.next;

current.next = new ListNode(20);
current = current.next;
```

Finally:

```java
return dummy.next;
```

Why?

`dummy` makes handling the head node easier.

### Important pattern

```java
ListNode dummy = new ListNode(0);
ListNode tail = dummy;

// Build result
tail.next = new ListNode(value);
tail = tail.next;

return dummy.next;
```

Used in:

* Merge two sorted lists
* Remove elements
* Partition list
* Add two numbers

---

## Reverse a Linked List ⭐⭐⭐

This is one of the most important templates.

```java
public ListNode reverseList(ListNode head) {

    ListNode prev = null;
    ListNode current = head;

    while (current != null) {

        ListNode next = current.next;

        current.next = prev;

        prev = current;
        current = next;
    }

    return prev;
}
```

Memorize the three pointers:

```java
prev
current
next
```

Pattern:

```text
1 -> 2 -> 3 -> null

next = current.next
current.next = prev
prev = current
current = next
```

---

## Fast and Slow pointers ⭐⭐⭐

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
```

Common uses:

* Find middle
* Detect cycle
* Find cycle start

### Find middle

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}

return slow;
```

---

## Cycle detection

```java
public boolean hasCycle(ListNode head) {

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {

        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {
            return true;
        }
    }

    return false;
}
```

Note:

```java
slow == fast
```

is correct because we are comparing **node references**, not node values.

---

# Linked List Cheat Sheet

```java
// Traverse
ListNode current = head;

while (current != null) {
    current = current.next;
}

// Dummy node
ListNode dummy = new ListNode(0);
ListNode tail = dummy;

tail.next = new ListNode(value);
tail = tail.next;

return dummy.next;

// Reverse
ListNode prev = null;
ListNode current = head;

while (current != null) {
    ListNode next = current.next;

    current.next = prev;
    prev = current;
    current = next;
}

return prev;

// Slow/Fast
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
```

---

# 9. Tree (`TreeNode`) syntax

Typical LeetCode definition:

```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
```

Again, this is usually provided.

Example:

```text
       1
      / \
     2   3
    / \
   4   5
```

Access:

```java
root.val
root.left
root.right
```

---

## Recursive DFS ⭐⭐⭐

This is the fundamental tree template:

```java
private void dfs(TreeNode node) {

    if (node == null) {
        return;
    }

    // Process node

    dfs(node.left);
    dfs(node.right);
}
```

---

## Preorder

**Node → Left → Right**

```java
private void dfs(TreeNode node) {

    if (node == null) {
        return;
    }

    // Process before children
    System.out.println(node.val);

    dfs(node.left);
    dfs(node.right);
}
```

---

## Inorder

**Left → Node → Right**

```java
private void dfs(TreeNode node) {

    if (node == null) {
        return;
    }

    dfs(node.left);

    // Process between children
    System.out.println(node.val);

    dfs(node.right);
}
```

For a BST, inorder traversal produces values in sorted order.

---

## Postorder

**Left → Right → Node**

```java
private void dfs(TreeNode node) {

    if (node == null) {
        return;
    }

    dfs(node.left);
    dfs(node.right);

    // Process after children
    System.out.println(node.val);
}
```

---

## Recursion returning a value ⭐⭐⭐

For example, maximum depth:

```java
public int maxDepth(TreeNode root) {
    return dfs(root);
}

private int dfs(TreeNode node) {

    if (node == null) {
        return 0;
    }

    int leftDepth = dfs(node.left);
    int rightDepth = dfs(node.right);

    return 1 + Math.max(leftDepth, rightDepth);
}
```

This is a key pattern:

```java
if (node == null) {
    return BASE_VALUE;
}

Result left = dfs(node.left);
Result right = dfs(node.right);

return combine(left, right);
```

---

## Tree BFS / Level Order ⭐⭐⭐

Use a queue:

```java
public List<List<Integer>> levelOrder(TreeNode root) {

    List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
        return result;
    }

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);

    while (!queue.isEmpty()) {

        int size = queue.size();

        List<Integer> level = new ArrayList<>();

        for (int i = 0; i < size; i++) {

            TreeNode node = queue.poll();

            level.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        result.add(level);
    }

    return result;
}
```

### Most important level-order pattern

```java
while (!queue.isEmpty()) {

    int size = queue.size();

    for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();

        // process this level

        // add children
    }
}
```

The line:

```java
int size = queue.size();
```

captures the number of nodes in the **current level**.

---

# Tree Cheat Sheet

```java
// Recursive DFS
private void dfs(TreeNode node) {

    if (node == null) {
        return;
    }

    dfs(node.left);
    dfs(node.right);
}

// Tree BFS
Queue<TreeNode> queue = new ArrayDeque<>();

queue.offer(root);

while (!queue.isEmpty()) {
    TreeNode node = queue.poll();

    if (node.left != null) {
        queue.offer(node.left);
    }

    if (node.right != null) {
        queue.offer(node.right);
    }
}
```

---

# 10. Graph representation + BFS/DFS templates

There are two main graph representations you should know.

## A. Adjacency List ⭐⭐⭐

Most common in DSA.

Suppose:

```text
0 ---- 1
|
2
```

Represent:

```java
List<List<Integer>> graph = new ArrayList<>();
```

Initialize:

```java
for (int i = 0; i < n; i++) {
    graph.add(new ArrayList<>());
}
```

For edge:

```text
0 -> 1
```

```java
graph.get(0).add(1);
```

For an undirected edge:

```text
0 <-> 1
```

Add both:

```java
graph.get(0).add(1);
graph.get(1).add(0);
```

### Full template

```java
List<List<Integer>> graph = new ArrayList<>();

for (int i = 0; i < n; i++) {
    graph.add(new ArrayList<>());
}

for (int[] edge : edges) {
    int u = edge[0];
    int v = edge[1];

    graph.get(u).add(v);
    graph.get(v).add(u); // only for undirected graph
}
```

---

## B. Adjacency Matrix

Sometimes input is already given like this:

```java
int[][] graph = {
    {0, 1, 1},
    {1, 0, 0},
    {1, 0, 0}
};
```

Here:

```java
graph[i][j] == 1
```

means an edge exists.

Traversal:

```java
for (int neighbor = 0; neighbor < n; neighbor++) {

    if (graph[node][neighbor] == 1) {
        // neighbor exists
    }
}
```

For interviews, adjacency lists are generally more common.

---

# Graph DFS ⭐⭐⭐

Use recursion.

```java
private void dfs(
        int node,
        List<List<Integer>> graph,
        Set<Integer> visited) {

    visited.add(node);

    for (int neighbor : graph.get(node)) {

        if (!visited.contains(neighbor)) {
            dfs(neighbor, graph, visited);
        }
    }
}
```

Instead of a `Set`, if nodes are `0` to `n - 1`, prefer:

```java
boolean[] visited = new boolean[n];
```

Then:

```java
private void dfs(
        int node,
        List<List<Integer>> graph,
        boolean[] visited) {

    visited[node] = true;

    for (int neighbor : graph.get(node)) {

        if (!visited[neighbor]) {
            dfs(neighbor, graph, visited);
        }
    }
}
```

This is the template I recommend memorizing.

---

# Graph BFS ⭐⭐⭐

Use a queue.

```java
private void bfs(
        int start,
        List<List<Integer>> graph,
        boolean[] visited) {

    Queue<Integer> queue = new ArrayDeque<>();

    queue.offer(start);
    visited[start] = true;

    while (!queue.isEmpty()) {

        int node = queue.poll();

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {

                visited[neighbor] = true;
                queue.offer(neighbor);
            }
        }
    }
}
```

### Important: Mark visited when adding to queue

Correct:

```java
visited[neighbor] = true;
queue.offer(neighbor);
```

Do **not** wait until polling in most standard BFS implementations. Otherwise, the same node may be added multiple times.

---

# DFS vs BFS

|                 | DFS                       | BFS                                       |
| --------------- | ------------------------- | ----------------------------------------- |
| Main structure  | Recursion / Stack         | Queue                                     |
| Traversal style | Go deep first             | Level by level                            |
| Common use      | Components, paths, cycles | Shortest path in unweighted graph, levels |
| Java            | Recursive `dfs()`         | `Queue` + loop                            |

---

# Grid = Graph ⭐⭐⭐

Many DSA problems don't explicitly say "graph."

For example:

```java
int[][] grid
```

is often treated as a graph where each cell is a node.

Common directions:

```java
int[][] directions = {
    {1, 0},
    {-1, 0},
    {0, 1},
    {0, -1}
};
```

Then:

```java
for (int[] dir : directions) {

    int newRow = row + dir[0];
    int newCol = col + dir[1];

    if (newRow >= 0 && newRow < rows &&
        newCol >= 0 && newCol < cols) {

        // valid neighbor
    }
}
```

## Grid DFS template

```java
private void dfs(int row, int col, int[][] grid) {

    int rows = grid.length;
    int cols = grid[0].length;

    // Boundary/base case
    if (row < 0 || row >= rows ||
        col < 0 || col >= cols) {
        return;
    }

    // Example: already visited
    if (grid[row][col] == 0) {
        return;
    }

    // Mark visited
    grid[row][col] = 0;

    dfs(row + 1, col, grid);
    dfs(row - 1, col, grid);
    dfs(row, col + 1, grid);
    dfs(row, col - 1, grid);
}
```

This is a very common interview template.

---

# Complete master cheat sheet

## Linked List

```java
ListNode current = head;

while (current != null) {
    current = current.next;
}
```

Reverse:

```java
ListNode prev = null;
ListNode current = head;

while (current != null) {
    ListNode next = current.next;
    current.next = prev;
    prev = current;
    current = next;
}

return prev;
```

---

## Tree DFS

```java
private void dfs(TreeNode node) {

    if (node == null) {
        return;
    }

    dfs(node.left);
    dfs(node.right);
}
```

## Tree BFS

```java
Queue<TreeNode> queue = new ArrayDeque<>();
queue.offer(root);

while (!queue.isEmpty()) {
    TreeNode node = queue.poll();

    if (node.left != null) {
        queue.offer(node.left);
    }

    if (node.right != null) {
        queue.offer(node.right);
    }
}
```

---

## Graph DFS

```java
private void dfs(
        int node,
        List<List<Integer>> graph,
        boolean[] visited) {

    visited[node] = true;

    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) {
            dfs(neighbor, graph, visited);
        }
    }
}
```

## Graph BFS

```java
Queue<Integer> queue = new ArrayDeque<>();

queue.offer(start);
visited[start] = true;

while (!queue.isEmpty()) {

    int node = queue.poll();

    for (int neighbor : graph.get(node)) {

        if (!visited[neighbor]) {
            visited[neighbor] = true;
            queue.offer(neighbor);
        }
    }
}
```

---