# L3 - Longest Substring Without Repeating Characters
#
# Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
# Idea: Use 2 pointers. You can store the index i+1 with each repeating char in map so that, j can be jumped to that.
# Time: O(n)
# Space: O(min(m,n)) where m is the size of the charset

def length_of_longest_substring(s: str) -> int:
    last_seen = {}  # stores last index + 1 of each character
    left = 0
    max_len = 0

    for right, ch in enumerate(s):
        # Update l pointer until the char is not in set
        if ch in last_seen:
            # abba case. a is seen but not in curr window.
            left = max(left, last_seen[ch]+1)

        max_len = max(max_len, right - left + 1)
        last_seen[ch] = right

    return max_len


if __name__ == "__main__":
    test_input = "aabcbe"
    print(f"Input: s = '{test_input}'")
    print(f"Output: {length_of_longest_substring(test_input)}")
