"""
L169 - Majority Element

Problem: https://leetcode.com/problems/majority-element/
Idea: Moore's Voting algorithm
The majority element is the element that appears more than ⌊n/2⌋ times.
Time: O(n)
Space: O(1)
"""

def majority_element(nums):
    candidate = -1
    count = 0
    
    # Phase 1: Find potential candidate
    for num in nums:
        if num == candidate:
            count += 1
        elif count == 0:
            candidate = num
            count = 1
        else:
            count -= 1
    
    return candidate


if __name__ == "__main__":
    test_array = [3, 2, 3]
    print(f"Input: {test_array}")
    print(f"Majority element: {majority_element(test_array)}")
    
    test_cases = [
        [2, 2, 1, 1, 1, 2, 2],
        [1],
        [1, 1, 1, 2, 2],
        [6, 5, 5]
    ]
    
    for i, test in enumerate(test_cases, 1):
        print(f"\nTest case {i}: {test}")
        print(f"Majority element: {majority_element(test)}")
