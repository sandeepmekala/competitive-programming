import heapq

# Problem: Huffman Coding
# Idea:
# 1. Insert all characters with their frequencies into a min-heap.
# 2. Repeatedly extract two nodes with minimum frequency.
# 3. Create an internal node with frequency = sum of both and push it back.
# 4. Continue until only one node remains — this is the root of Huffman Tree.
# 5. Traverse the tree to generate codes (left = 0, right = 1).
#
# Time: O(n log n)
# Space: O(n)

class HuffmanNode:
    def __init__(self, freq, ch=None, left=None, right=None):
        self.freq = freq
        self.ch = ch
        self.left = left
        self.right = right

    # needed for heap comparison
    def __lt__(self, other):
        return self.freq < other.freq


def build_huffman_tree(chars, freqs):
    heap = []

    # push all characters into min heap
    for ch, fr in zip(chars, freqs):
        heapq.heappush(heap, HuffmanNode(fr, ch))

    # build tree
    while len(heap) > 1:
        min1 = heapq.heappop(heap)
        min2 = heapq.heappop(heap)

        internal = HuffmanNode(
            min1.freq + min2.freq,
            ch='-',
            left=min1,
            right=min2
        )
        heapq.heappush(heap, internal)

    return heap[0]   # root


def print_codes(root, code=""):
    # leaf node
    if root.left is None and root.right is None:
        print(f"{root.ch}: {code}")
        return

    print_codes(root.left, code + "0")
    print_codes(root.right, code + "1")


# -------- Test --------
chars = ['a', 'b', 'c', 'd', 'e', 'f']
freqs = [5, 9, 12, 13, 16, 45]

root = build_huffman_tree(chars, freqs)
print_codes(root)
