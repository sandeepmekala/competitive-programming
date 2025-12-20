# Problem: https://leetcode.com/problems/group-anagrams/
# Idea: Create Counter for each str using TreeMap. From TreeMap create a composite key for grouping the strings.
# Each anagram gets same composite key as TreeMap stores the keys in the same order.
def group_anagrams(strs):
    agg_map = {}

    for s in strs:
        freq = {}
        for c in s:
            freq[c] = freq.get(c, 0) + 1

        # TreeMap equivalent: iterate keys in sorted order
        sb = []
        for ch in sorted(freq.keys()):
            sb.append(ch)
            sb.append(str(freq[ch]))
            sb.append(":")

        comp_key = "".join(sb)
        if comp_key not in agg_map:
            agg_map[comp_key] = []
        agg_map[comp_key].append(s)

    return list(agg_map.values())


# ------------------ Test (Same as Java main) ------------------

print(group_anagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))
# Expected (order may vary):
# [['eat', 'tea', 'ate'], ['tan', 'nat'], ['bat']]
