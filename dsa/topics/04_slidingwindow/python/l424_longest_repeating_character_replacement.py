# L424 - Longest Repeating Character Replacement
#
# Problem: https://leetcode.com/problems/longest-repeating-character-replacement/
# Idea:
# In a substring we will try to replace all characters except the max frequency chars to get longest.
# window_length - max_freq is the number of characters we need to replace at max
# Constraint: (window length) - (max frequency in window) ≤ k
#
# Ideally, max_freq need to reduced after every window shrink. But there is no point in reducing max_freq.
# Because increased max_freq will give us better max_len. Reducing will not help. Hence, we are not reducing max_freq.
# Time: O(n)
# Space: O(1)

def character_replacement(s: str, k: int) -> int:
    freq = {}
    left = 0
    max_len = 0
    max_freq = 0

    for right, ch in enumerate(s):
        freq[ch] = freq.get(ch, 0) + 1
        max_freq = max(max_freq, freq[ch])

        if (right - left + 1) - max_freq > k:
            freq[s[left]] -= 1  # not updating max_freq
            left += 1

        # window is always valid here
        max_len = max(max_len, right - left + 1)

    return max_len


if __name__ == "__main__":
    # s = "AABABBA"
    s = "BBBAAC"
    k = 2
    print(f"Input: s = '{s}', k = {k}")
    print(f"Output: {character_replacement(s, k)}")
