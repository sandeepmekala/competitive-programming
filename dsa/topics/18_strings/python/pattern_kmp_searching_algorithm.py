# Idea: We construct longest proper prefix which is also suffixes for the pattern
# so that we don't match already matched prefixes.
# This lps contains the indexes to fallback if there is a miss match.
# These indexes are basically the length of the longest proper prefix which is already compared.
# O(n+m) = O(n)
def kmp_search(text, pattern):
    n = len(text)
    m = len(pattern)
    lps = [0] * m

    construct_lps(lps, pattern, m)
    print(lps)

    i = 0
    j = 0
    while i < n:
        if text[i] == pattern[j]:
            i += 1
            j += 1

            if j == m:
                print("Search found at:", i - j)
                j = lps[j - 1]
        else:
            if j > 0:
                j = lps[j - 1]
            else:
                i += 1


# Idea: Build lps array to store the next index we should jump incase missmatch with input string.
# Start with j=0, i=1
# If, pat[i] and pat[j] match, store lps[i] = j+1.
# This means, till j it matched, in case of missmatch it should fallback to j+1 index.
# Increase i,j
# In case missmatch, we already stored the next ind of pattern with last matched j.
# Switch j to that.(lps[j-1])
# Time: O(m)
def construct_lps(lps, pattern, m):
    j = 0
    i = 1
    lps[0] = 0

    while i < m:
        if pattern[i] == pattern[j]:
            lps[i] = j + 1
            i += 1
            j += 1
        else:
            if j > 0:
                j = lps[j - 1]
            else:
                lps[i] = 0
                i += 1


# ------------------ Test (Same as Java main) ------------------

input_str = "ABABDABACDABABCABAB"
pattern = "ABABCABAB"
kmp_search(input_str, pattern)
