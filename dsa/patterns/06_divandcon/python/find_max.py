"""
Find Maximum using Divide & Conquer (Recursive)

Time Complexity: O(n)
Space Complexity: O(n) due to recursion stack
"""

def find_max(numbers, index, n):
    # Base case: stop at last two elements
    if index >= n - 2:
        if numbers[index] > numbers[index + 1]:
            return numbers[index]
        else:
            return numbers[index + 1]

    max_from_rest = find_max(numbers, index + 1, n)

    if numbers[index] > max_from_rest:
        return numbers[index]
    else:
        return max_from_rest


# Driver code
if __name__ == "__main__":
    numbers = [70, 250, 50, 80, 140, 12, 14]
    print(find_max(numbers, 0, len(numbers)))  # 250
