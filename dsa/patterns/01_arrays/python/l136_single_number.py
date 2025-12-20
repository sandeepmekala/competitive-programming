"""
L136 - Single Number

Problem: https://leetcode.com/problems/single-number/
Idea: XOR all the nums. All the duplicate nums will get nullified leaving only unique num.
Time: O(n)
Space: O(1)
"""

def single_number(nums):
    xor_result = 0
    for num in nums:
        xor_result ^= num
    return xor_result


if __name__ == "__main__":
    test_array = [2, 2, 1]
    print(f"Input: {test_array}")
    print(f"Single number: {single_number(test_array)}")
    
    test_cases = [
        [4, 1, 2, 1, 2],
        [1],
        [1, 0, 1],
        [7, 3, 5, 3, 5, 7, 9]
    ]
    
    for i, test in enumerate(test_cases, 1):
        print(f"\nTest case {i}: {test}")
        result = single_number(test)
        print(f"Single number: {result}")
