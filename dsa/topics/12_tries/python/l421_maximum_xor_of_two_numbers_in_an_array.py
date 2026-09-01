class TrieNode:
    def __init__(self):
        self.children = {}


"""
Problem: https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
Idea:
Build a trie of all numbers bit by bit from MSB to LSB.
For each number, try to find the opposite bit at every level to maximize XOR.
If opposite bit is not available, move with the same bit.
"""


def find_maximum_xor(nums):
    root = TrieNode()

    # insert all numbers into trie
    for num in nums:
        _insert(root, num)

    max_xor = 0
    for num in nums:
        max_xor = max(max_xor, _get_max(root, num))

    return max_xor


def _insert(root, num):
    curr = root
    for i in range(31, -1, -1):
        bit = (num >> i) & 1
        if bit not in curr.children:
            curr.children[bit] = TrieNode()
        curr = curr.children[bit]


def _get_max(root, num):
    curr = root
    xor_val = 0

    for i in range(31, -1, -1):
        bit = (num >> i) & 1
        toggled = 1 - bit

        if toggled in curr.children:
            xor_val |= (1 << i)
            curr = curr.children[toggled]
        else:
            curr = curr.children[bit]

    return xor_val


if __name__ == "__main__":
    nums = [3, 10, 5, 25, 2, 8]
    print(find_maximum_xor(nums))  # 28
