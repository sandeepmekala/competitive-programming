# Print
print("Hello Python")

print("Hello", "Python")
print("Hello\nPython")

print("Hello", end="!")
print()

print("Hello", "Python", sep="-")

print("Hello", "Python", sep="-", end="!")
print()

# Operators
# **, *, /, //, %, +
print(2 ** 3)
print(2 ** 3.)  # 8.0

print(2 * 3)
print(10 / 2)   # 5.0 not 5

# Floor Division
print(10 // 2)  # 5
print(6 // 4.)  # 1.0 not 1.5
print(-6 // 4.)  # -2.0 not -1.5

# Input
# age = input("How old are you? ")    # Always str
age = "31"
print(int(age) - 1)

# Comparision Operators
# ==, !=, >, <, >=, <=
print(2 == 2)
print(2 != 2)
print(2 > 2)

# Conditional
n = 2;
if (n > 5):
    print("You are bigger")
elif (n < 3):
    print("You are smaller")
else:
    print("You are awsome")
    
# Loops
# While
n = 5
while (n > 0):
    print(n)
    n -= 1
else:
    print("finish!")
    
# For
print(range(5))
print(range(2, 5))

for i in range(5):
    if(i == 2):
        continue
    print(i)
    if i == 4:
        break
    
# Operators

# Logical Operators: and, or, not
n = 5
if( n > 3 and n < 10):
    print("n is between 3 and 10")
    
is_hungry = False
if(not is_hungry):
    print("Not hungry")

# Bitwise Operators: &, |, ^, ~, <<, >>
print(bin(3))
print(bin(5))

print(3 & 5)

# Lists
nums = [1, 2, 3, 4, 5]
print(nums[0])
print(len(nums))
print(nums[-1])
del nums[0]
print(nums)