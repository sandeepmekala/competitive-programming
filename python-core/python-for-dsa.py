# Dynamic typing
import heapq
from collections import deque
import math
n = 0
print('n =', n)

n = 'abc'
print('n =', n)

# Multiple assignments
n, m = 1, 2
print('n =', n)
print('m =', m)

# Incrementing a variable
n = n + 1
n += 1
print('n =', n)

# None is null(no value)
n = 0
n = None
print(n)

# If statement
# No parentheses needed around conditions
# Indentation is used to define blocks
# Parentheses are needed for multiple lines
# && is and, || is or, ! is not
n = 1
if (n > 0 and n < 5) or n == -10:
    n += 1
elif n == 0:
    n = 1
else:
    n -= 1

# While loop are same
n = 0
while n < 5:
    print(n)
    n += 1

# For loop with range
# i = 0 to 4
for i in range(5):
    print('i =', i)

# i = 2 to 5
for i in range(2, 6):
    print(i)

# i = 5 to 2 (decrementing)
for i in range(5, 1, -1):
    print(i)

# Division is float by default
print(5/2)

# Integer division
print(5//2)

# It rounds towards negative infinity, not towards zero
print(-3//2)

# Alternative way to get integer division
print(int(-3/2))

# Modulus operator
print(5 % 2)
# Except. result is not -1.
print(-3 % 2)

# Alternative way to get modulus
print(math.fmod(-3, 2))

# More math functions
print(math.ceil(2.3))
print(math.floor(2.7))
print(math.sqrt(16))
print(math.pow(2, 3))

# Max / Min integer values
float('inf')
float('-inf')

# Python number are infinite, so there's no overflow
print(math.pow(2, 1000))

# Array (list) declaration
arr = [1, 2, 3]
print(arr)

# Can be used as a stack
arr.append(4)
print(arr)

arr.pop()
print(arr)

# O(n) to insert or remove from the middle
arr.insert(1, 7)
print(arr)
arr.remove(2)

arr[0] = 10
print(arr)

# Initialize array with fixed size
arr = [0] * 5
print(arr)
print(len(arr))

# Negative indexing
arr = [1, 2, 3, 4, 5]
print(arr[-1])
print(arr[-2])

# Sublist (slicing)
print(arr[1:4])  # from index 1 to index 3

# Unpacking
a, b, c = [1, 2, 3]
print(a, b, c)

# Loop through array
nums = [1, 2, 3, 4, 5]

# Using index
for i in range(len(nums)):
    print(nums[i])

# Without index
for n in nums:
    print(n)

# With index and value
for i, n in enumerate(nums):
    print(i, n)

# Looping through multiple arrays
nums1 = [1, 3, 5]
nums2 = [2, 4, 6]
print(zip(nums1, nums2))
for n1, n2 in zip(nums1, nums2):
    print(n1, n2)

# Reverse a list
nums = [1, 2, 3]
nums.reverse()
print(nums)

# Sort a list
nums = [3, 1, 2]
nums.sort()
print(nums)
nums.sort(reverse=True)
print(nums)

arr = ['bob', 'alice', 'eve']
arr.sort()
print(arr)

arr.sort(key=lambda x: len(x))
print(arr)

# List comprehensions
squares = [i * i for i in range(5)]
print(squares)

# 2D lists
matrix = [[0]*4 for _ in range(3)]
print(matrix)
# Won't work as expected
matrix = [[0] * 4] * 4

# Strings are similar to arrays
s = "hello"
print(s[0:2])

# Strings are immutable. This creates a new string.
s += " world"
print(s)

print(int("12") + int("34"))
print(str(12) + str(34))

# Ord value of a character
print(ord("a"))

# Joining strings
words = ['hello', 'world']
s = " ".join(words)
print(s)

# Queue (double-ended queue)
queue = deque()
queue.append(1)
queue.append(2)
print(queue)

queue.popleft()
print(queue)

queue.appendleft(0)
print(queue)

queue.pop()
print(queue)

# Set
hashset = set()
hashset.add(1)
hashset.add(2)
print(hashset)

hashset.add(2)
print(hashset)

hashset.remove(1)
print(hashset)

print(2 in hashset)
print(3 in hashset)

# list to set
print(set([1, 2, 3]))

# Set comprehensions
squares = {i * i for i in range(5)}
print(squares)

# HashMap (dictionary)
hashmap = {}
hashmap['a'] = 1
hashmap['b'] = 2
print(hashmap)

print(hashmap['a'])
hashmap['a'] = 3
print(hashmap)

hashmap.pop('a')
print(hashmap)

print('b' in hashmap)
print('a' in hashmap)

hashmap = {'x': 10, 'y': 20}
for key in hashmap:
    print(key, hashmap[key])

for val in hashmap.values():
    print(val)

for key, val in hashmap.items():
    print(key, val)

# Dict comprehensions
squares = {i: i * i for i in range(5)}
print(squares)

# Tuples are list arrays but immutable
t = (1, 2, 3)
print(t)
print(t[0])
print(t[-1])

# Unpacking tuples
a, b, c = t
print(a, b, c)

# Won't work
# t[0] = 10

# Can be used as keys in hashmap or elements in hashset
hashmap = {}
hashmap[(1, 2)] = 3
print(hashmap)

hashset = set()
hashset.add((4, 5))
print(hashset)

# Won't work
# hashset.add([4,5])

# Heaps
# Arrays underneath
minheap = []
heapq.heappush(minheap, 3)
heapq.heappush(minheap, 2)
heapq.heappush(minheap, 4)
print(minheap)

print(heapq.heappop(minheap))
print(minheap)

while minheap:
    print(heapq.heappop(minheap))

# No max heap in Python
# Max heap by created by mutating values by -1 on push and pop
maxheap = []
heapq.heappush(maxheap, -3)
heapq.heappush(maxheap, -2)
heapq.heappush(maxheap, -4)
print(maxheap)

while maxheap:
    print(-heapq.heappop(maxheap))

# Build heap from existing array
arr = [3, 1, 4, 2]
heapq.heapify(arr)
print(arr)

while arr:
    print(heapq.heappop(arr))

# Functions


def add(a, b):
    return a + b


print(add(2, 3))

# Easily access outer variables


def outer(a, b):
    c = "c"

    def inner(c):
        return a + b + c
    return inner(c)


print(outer("a", "b"))

# Nonlocal variable
# Can modify objects but not reassign unless declared nonlocal


def double(nums, n):
    def helper():
        for i in range(len(nums)):
            nums[i] *= 2

        nonlocal n
        n *= 2
    helper()
    print(nums, n)


double([1, 2, 3], 5)

# Class


class Dog:
    species = 'Canis familiaris'  # class variable

    def __init__(self, name, age):
        self.name = name  # instance variable
        self.age = age    # instance variable

    def bark(self):
        return f"{self.name} says woof!"


dog1 = Dog("Buddy", 3)
print(dog1.bark())
