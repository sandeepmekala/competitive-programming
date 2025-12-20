class TrieNode:
    def __init__(self):
        self.children = {}


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, num: int):
        curr = self.root
        for i in range(31, -1, -1):
            bit = (num >> i) & 1
            if bit not in curr.children:
                curr.children[bit] = TrieNode()
            curr = curr.children[bit]

    def find_max(self, num: int) -> int:
        curr = self.root
        max_xor = 0
        for i in range(31, -1, -1):
            bit = (num >> i) & 1
            if 1 - bit in curr.children:
                max_xor |= (1 << i)
                curr = curr.children[1 - bit]
            else:
                curr = curr.children.get(bit)
        return max_xor


"""
Problem: https://leetcode.com/problems/maximum-xor-with-an-element-from-array/description/
Idea:
Insert all numbers in trie from MSB to LSB (31 → 0), but only those numbers which are ≤ mi.
Process queries offline by sorting them based on mi.
For each query, find max xor by trying to take the opposite bit at every level of the trie.
"""


def maximize_xor(nums, queries):
    nums.sort()

    # store queries as (mi, xi, original_index)
    offline_queries = [(q[1], q[0], i) for i, q in enumerate(queries)]
    offline_queries.sort()

    trie = Trie()
    ans = [-1] * len(queries)

    idx = 0
    n = len(nums)

    for mi, xi, qi in offline_queries:
        while idx < n and nums[idx] <= mi:
            trie.insert(nums[idx])
            idx += 1

        if idx > 0:
            ans[qi] = trie.find_max(xi)
        else:
            ans[qi] = -1

    return ans


if __name__ == "__main__":
    nums = [0, 1, 2, 3, 4]
    queries = [[3, 1], [1, 3], [5, 6]]
    print(maximize_xor(nums, queries))
