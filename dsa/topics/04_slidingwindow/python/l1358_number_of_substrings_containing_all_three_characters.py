# L1358 - Number of Substrings Containing All Three Characters
#
# Problem: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
# Idea: 
# Track the last seen index of each character. If all characters are seen at least once,
# then the number of substrings ending at that index is min of last seen index of all characters + 1
# Time: O(n)
# Space: O(1)

def number_of_substrings(s: str) -> int:
    last_seen = [-1, -1, -1]  # For characters 'a', 'b', 'c'
    count = 0

    for right, ch in enumerate(s):
        last_seen[ord(ch) - ord('a')] = right

        if -1 not in last_seen:
            count += min(last_seen) + 1

    return count


if __name__ == "__main__":
    s = "abcabc"
    print(f"Input: s = '{s}'")
    print(f"Output: {number_of_substrings(s)}")
