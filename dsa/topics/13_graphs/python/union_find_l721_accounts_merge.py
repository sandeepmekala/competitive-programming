from typing import List
from collections import defaultdict


class UnionFind:
    def __init__(self, n: int):
        self.parent = list(range(n))
        self.rank = [0] * n

    def find(self, x: int) -> int:
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x: int, y: int) -> None:
        px, py = self.find(x), self.find(y)
        if px == py:
            return

        if self.rank[px] < self.rank[py]:
            self.parent[px] = py
        elif self.rank[px] > self.rank[py]:
            self.parent[py] = px
        else:
            self.parent[py] = px
            self.rank[px] += 1


"""
Problem: Accounts Merge
https://leetcode.com/problems/accounts-merge/

Idea:
- Treat each account index as a node.
- If two accounts share the same email, union their indices.
- Use a map to track which email belongs to which account.
- After unions, group emails by their root parent.
- Sort emails and prepend account name.

Time Complexity:
O(N * α(N)) + sorting emails

Space Complexity:
O(N)
"""
def accounts_merge(accounts: List[List[str]]) -> List[List[str]]:
    n = len(accounts)
    uf = UnionFind(n)

    mail_to_node = {}

    # Step 1: Union accounts sharing the same email
    for i in range(n):
        for mail in accounts[i][1:]:
            if mail not in mail_to_node:
                mail_to_node[mail] = i
            else:
                uf.union(mail_to_node[mail], i)

    # Step 2: Collect emails by parent node
    merged = defaultdict(set)
    for mail, node in mail_to_node.items():
        parent = uf.find(node)
        merged[parent].add(mail)

    # Step 3: Build final result
    result = []
    for parent, mails in merged.items():
        temp = [accounts[parent][0]] + sorted(mails)
        result.append(temp)

    return result


# ---------------- test (same as Java main) ----------------
if __name__ == "__main__":
    accounts = [
        ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
        ["John", "johnsmith@mail.com", "john00@mail.com"],
        ["Mary", "mary@mail.com"],
        ["John", "johnnybravo@mail.com"]
    ]

    print(accounts_merge(accounts))
