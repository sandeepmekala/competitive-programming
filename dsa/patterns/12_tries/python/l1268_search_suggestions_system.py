class TrieNode:
    def __init__(self):
        self.children = {}
        self.suggestions = []


"""
Problem: https://leetcode.com/problems/search-suggestions-system/
Companies: Amazon
Idea:
Sort words first as we need to return results in lexicographic order.
While building the trie, maintain up to 3 words at each node.
For each prefix of searchWord, fetch suggestions from the trie.
"""


def suggested_products(products, search_word):
    products.sort()

    root = TrieNode()

    # build trie and store suggestions
    for product in products:
        curr = root
        for ch in product:
            if ch not in curr.children:
                curr.children[ch] = TrieNode()
            curr = curr.children[ch]

            if len(curr.suggestions) < 3:
                curr.suggestions.append(product)

    result = []
    curr = root

    # traverse trie for search word
    for ch in search_word:
        if curr and ch in curr.children:
            curr = curr.children[ch]
            result.append(curr.suggestions)
        else:
            curr = None
            result.append([])

    return result


if __name__ == "__main__":
    products = ["mobile", "mouse", "moneypot", "monitor", "mousepad"]
    search_word = "mouse"

    print(suggested_products(products, search_word))
