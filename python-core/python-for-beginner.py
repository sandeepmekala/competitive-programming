
# Print
import copy
from collections import defaultdict, Counter
from functools import reduce
from collections import deque
import math
print("--------------------------------Print")
print("Hello Python")

print("Hello", "Python")
print("Hello\nPython")

print("Hello", end="!")
print()

print("Hello", "Python", sep="-")

print("Hello", "Python", sep="-", end="!")
print()

print("--------------------------------Strings")
# Strings
s = "Hello Python"
print(s[0])
print(len(s))
print(s[-1])
print(s[0:5])
print(s[6:])
print(s[:])  # whole string
print(s[::2])  # step
print(s[::-1])  # reverse

print(s.lower())
print(s.upper())
print(s.replace("Python", "World"))
print(s.find("P"))
print(s.find("M"))  # -1
print(s.split(" "))
print(s.startswith("Hello"))
print(s.endswith("Python"))
print(s.count("o"))
print(s.isalpha())  # False because of space
print(s.isdigit())  # False because of space

print(" ".join(["Hello", "Python"]))

s = "   Hello Python   "
print(s.strip())

first = 'Sandeep'
last = 'Mekala'
full = f"{first} {last}"
print(full)

# Operators
print("--------------------------------Operators")
# **, *, /, //, %, +
print(2 * 3)
print(10 / 2)   # 5.0 not 5

print(2 ** 3)
print(2 ** 3.)  # 8.0


# Floor Division
print(10 // 2)  # 5
print(6 // 4.)  # 1.0 not 1.5
print(-6 // 4.)  # -2.0 not -1.5

# Math Functions
print("--------------------------------Math")
print(round(2.9))
print(abs(-2.9))
print(max([2, 4, 5, 1]))
print(min([2, 4, 5, 1]))
print(sum([1, 2, 3, 4, 5]))

print(math.ceil(2.1))
print(math.floor(2.9))
print(math.sqrt(16))
print(math.pow(2, 3))

# Type Casting
print("--------------------------------Type Casting")
print(int(2.9))
print(float(2))
print(str(2.9))
print(bool(0))  # False values: 0, 0.0, "", [], {}, None
print(bool(2))


# Input
print("--------------------------------Input")
# age = input("How old are you? ")    # Always str
age = "31"
print(int(age) - 1)

# Comparision Operators
# ==, !=, >, <, >=, <=
print(2 == 2)
print(2 != 2)
print(2 > 2)

age = 22
print(10 <= age < 40)
if (10 <= age < 40):  # Chained Comparison
    print("You are eligible")

# Conditional
print("--------------------------------Conditional")
n = 2
if (n > 5):
    print("You are bigger")
elif (n < 3):
    print("You are smaller")
else:
    print("You are awsome")

age = 22
status = "student" if age < 18 else "adult"  # Ternary Operator
print(status)

# Loops
print("--------------------------------Loops")
# While
n = 5
while (n > 0):
    print(n)
    n -= 1
else:                   # If while loop ends normally, not by break
    print("finish!")

# For
print(range(5))
print(range(2, 5))

for i in range(5):
    if (i == 2):
        continue
    print(i)
    if i == 4:
        break
else:
    print("Done!")  # If for loop ends normally, not by break

# Operators
print("--------------------------------Operators")
# Logical Operators: and, or, not
n = 5
if (n > 3 and n < 10):
    print("n is between 3 and 10")

is_hungry = False
if (not is_hungry):
    print("Not hungry")

# Bitwise Operators: &, |, ^, ~, <<, >>
print(bin(3))
print(bin(5))

print(3 & 5)

# Lists
print("--------------------------------Lists")
nums = [1, 2, 3, 4, 5]
print(nums[0])
print(len(nums))
print(nums[-1])

del nums[0]
print(nums)

nums.append(6)
nums.insert(0, 0)
print(nums)

nums.sort()
nums.sort(reverse=True)
nums.reverse()
print(nums)

for num in nums:
    print(num)

nums2 = nums[0:2]
print(nums2)

nums2 = nums[1:-1]
print(nums2)

nums2 = nums[:]
print(nums2)

del nums2[0:2]
print(nums2)

print(3 in nums)

matrix = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]
print(matrix[0][1])

print(list(range(5)))
print(list("Hello"))
print(list(sorted([3, 1, 4, 2])))
print(list(reversed([1, 2, 3, 4, 5])))


# Sets
print("--------------------------------Sets")
s = {1, 2, 3, 4, 5}
s.add(6)
s.remove(3)
print(s)
print(3 in s)

a = {1, 2, 3}
b = {3, 4, 5}
print(a.union(b))
print(a | b)

print(a.intersection(b))
print(a & b)

print(a.difference(b))
print(a - b)

# Deque
print("--------------------------------Deque")
dq = deque()
dq.append(1)
dq.append(2)
dq.appendleft(0)
print(dq)
dq.pop()
dq.popleft()
print(dq)

# Tuples
print("--------------------------------Tuples")
tuble = (1, 2, 3)
print(tuble)
print(tuble[0])

t = 1, 2, 3
for t in tuble:
    print(t)

t = (1, "Hi", (2, 3))
print(t)

# Dictionaries
print("--------------------------------Dictionaries")
d = {
    "key1": "val1"
}
print(d["key1"])

for key in d.keys():
    print(key)
for val in d.values():
    print(val)
for key, val in d.items():
    print(key, val)

d["key2"] = "val2"
print(d)

d.update({"key3": "val3"})
print(d)

del d["key1"]
print(d)

d.pop("key2")
print(d)

d.popitem()
print(d)

dict2 = d.copy()
print(dict2)

d.clear()
print(d)

# List / Dict / Set Comprehensions
print("--------------------------------Comprehensions")
nums = [1, 2, 3, 4, 5]
squares = [n * n for n in nums]
print(squares)
evens = [n for n in nums if n % 2 == 0]
print(evens)

s = {n * n for n in nums}
print(s)

d = {n: n * n for n in nums}
print(d)


# Iterables
print("--------------------------------Iterable")
for num in range(5):
    print(num)
for item in [1, 2, 3]:
    print(item)
for char in "Python":
    print(char)

# Utils
print("--------------------------------Utils")
print("enumerate", enumerate(['a', 'b', 'c']))
for i, val in enumerate([1, 2, 3]):
    print(i, val)

print("zip", zip([1, 2, 3], ['a', 'b', 'c']))
for num, char in zip([1, 2, 3], ['a', 'b', 'c']):
    print(num, char)

print(any([0, "", None, 5]))  # True if any element is true
print(all([1, 2, 3, 0]))      # True if all elements are true

# Sorting Collections
print("--------------------------------Sorting")
nums = [5, 2, 9, 1, 5, 6]
nums.sort()  # Sorts in place
print(nums)
nums.sort(reverse=True)
print(nums)

nums = [5, 2, 9, 1, 5, 6]
sorted_nums = sorted(nums)  # returns a new sorted list
print(sorted_nums)
sorted_nums_desc = sorted(nums, reverse=True)
print(sorted_nums_desc)

nums = [(1, 2), (3, 4), (0, -1), (5, 1)]
nums.sort(key=lambda x: x[1])  # Sort by second element
print(nums)

nums.sort(key=lambda x: x[1], reverse=True)  # Sort by second element desc
print(nums)

# Functions
print("--------------------------------Functions")


def add(a=0, b=0):
    return a + b        # Default return value is None


print(add(2, 4))
print(add(b=4, a=2))


def print_list(list):
    for num in list:
        print(num)


print_list([2, 2, 4, 6])


def multiply(*nums):  # Variable Number of Arguments
    print("*args", nums)
    total = 1
    for num in nums:    # nums comes as a tuple
        total *= num
    return total


print(multiply(2, 3, 4))


def func(**kwargs):
    print("**kwargs", kwargs)   # {'a': 1, 'b': 2, 'c': 3}


func(a=1, b=2, c=3)  # kwargs comes as a dictionary

# Lambda Functions
print("--------------------------------Lambda Functions")
# add = lambda a, b: a + b
print(add(2, 3))
# Scopes


def func():
    a = 5           # Local scope
    print(a)

# print(a)          # Error


def func():
    global b
    b = 5


func()
print("global: " + str(b))

print("--------------------------------Exceptions")

# Exceptions
try:
    name = 123
    print("Hi " + name)
    raise ValueError("An error occurred")
except TypeError as e:
    print("Type Error occured", e)
except (TypeError, ValueError):
    print("Type or Value Error occured")
except:
    print("Somthing is wrong")
finally:
    print("Execution completed")
print("All done")

n = -4
# assert n > 0, "n should be positive"

# Files
print("--------------------------------Files")
with open("file.txt", "w") as f:
    f.write("Hello Python\n")
    f.write("File Handling ")

with open("file.txt", "r") as f:
    content = f.read()
    print(content)
with open("file.txt", "r") as f:
    for line in f:
        print(line.strip())

# Classes
print("--------------------------------Classes")


class Person:
    def __init__(self, name):
        self.name = name

    def greet(self):
        print("Hello, my name is " + self.name)


p = Person("Sandeep")
p.greet()

# Modules
print("--------------------------------Modules")
# import math
print(math.sqrt(16))

# from math import add
print(add(2, 3))  # only add function

# import dsa.patterns.arrays as arrays
# print(arrays.running_sum([1, 2, 3, 4, 5]))

# Generators & yield
print("--------------------------------Generators & yield")


def count_up_to(n):
    count = 1
    while count <= n:
        yield count
        count += 1


for num in count_up_to(5):
    print(num)


# map, filter, reduce
print("--------------------------------map, filter, reduce")
nums = [1, 2, 3, 4, 5]
# Prefer list comprehension over map, filter
squared = list(map(lambda x: x * x, nums))
print(squared)
evens = list(filter(lambda x: x % 2 == 0, nums))
print(evens)
product = reduce(lambda x, y: x * y, nums)
print(product)

# defaultdict & Counter
print("--------------------------------defaultdict & Counter")
# from collections import defaultdict, Counter
d = defaultdict(int)
d["a"] += 1
print(d)

c = Counter("hello world")
print("counter", c)
print("counter keys", c.keys())
print("counter values", c.values())
print("counter items", c.items())
print("counter most common", c.most_common(2))
print("counter count of l", c['l'])
print("counter count of z", c['z'])

# Deep Copy
print("--------------------------------Deep Copy")
a = [[1, 2, 3], [4, 5, 6]]
a_copy = a[:]
a_copy = copy.copy(a)
deep_copied = copy.deepcopy(a)
a_copy[0][0] = 10
print("original:", a)
print("shallow copy:", a_copy)
print("deep copy:", deep_copied)
