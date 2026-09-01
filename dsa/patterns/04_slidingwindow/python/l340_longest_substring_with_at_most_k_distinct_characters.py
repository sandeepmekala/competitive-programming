# L340 - Longest Substring with At Most K Distinct Characters
#
# Problem: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
# Idea: Use sliding window with hashmap to track character frequencies.
# Expand window by adding characters, shrink when distinct characters exceed k.
# Time: O(n)
# Space: O(k)

def length_of_longest_substring_k_distinct(s: str, k: int) -> int:
    char_freq = {}
    left = 0
    max_len = 0

    for right, ch in enumerate(s):
        char_freq[ch] = char_freq.get(ch, 0) + 1

        if len(char_freq) > k:
            left_char = s[left]
            char_freq[left_char] -= 1
            if char_freq[left_char] == 0:
                del char_freq[left_char]
            left += 1

        # char_freq always has at most k distinct characters here
        max_len = max(max_len, right - left + 1)

    return max_len


if __name__ == "__main__":
    s = "eceba"
    k = 2
    print(f"Input: s = '{s}', k = {k}")
    print(f"Output: {length_of_longest_substring_k_distinct(s, k)}")
