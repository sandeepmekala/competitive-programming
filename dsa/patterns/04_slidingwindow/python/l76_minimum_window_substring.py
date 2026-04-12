# L76 - Minimum Window Substring
#
# Problem: https://leetcode.com/problems/minimum-window-substring/
# Idea: Use map to keep track of frequency of characters in t.
# Insert chars of s also in map and decrease the counts.
# Use matched to keep track of number of characters in t that are present in the current window.
# While insert s chars, if char is already positive, means it is inserted by t. So, increase matched.
# Once matched reach m, start shrinking the window from left and decrease matched if any char in t goes out of window(mean freq become +ve).
# Time: O(n)
# Space: O(1) - constant space for ASCII characters

def min_window(s: str, t: str) -> str:
    freq = [0] * 256
    for ch in t:
        freq[ord(ch)] += 1

    left = 0
    matched = 0
    min_len = float("inf")
    start = 0

    for right, ch in enumerate(s):
        # If character is needed (positive count), increment matched
        if freq[ord(ch)] > 0:
            matched += 1
        freq[ord(ch)] -= 1

        # When we have all characters from t in current window
        while matched == len(t):
            # Update minimum window if current is smaller
            if right - left + 1 < min_len:
                min_len = right - left + 1
                start = left

            # Try to shrink window from left
            freq[ord(s[left])] += 1
            if freq[ord(s[left])] > 0:
                matched -= 1
            left += 1

    return "" if min_len == float("inf") else s[start:start + min_len]


if __name__ == "__main__":
    s = "ADOBECODEBANC"
    t = "ABC"
    print(f"Input: s = '{s}', t = '{t}'")
    print(f"Output: '{min_window(s, t)}'")
