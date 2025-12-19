from collections import defaultdict, deque
from typing import List


"""
Problem:
https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/

Idea:
This is a topological sorting problem using Kahn's algorithm (BFS).

Approach:
1. Treat each recipe as a node.
2. Each ingredient -> recipe forms a directed edge.
3. indeg[recipe] = number of ingredients required.
4. Initialize queue with all available supplies.
5. If an ingredient is available, reduce indegree of dependent recipes.
6. When indegree becomes zero, recipe can be prepared and becomes a new supply.
"""
def find_all_recipes(
    recipes: List[str],
    ingredients: List[List[str]],
    supplies: List[str]
) -> List[str]:

    graph = defaultdict(list)   # ingredient -> recipes that depend on it
    indeg = {}                  # recipe -> remaining required ingredients

    # Build graph and indegree
    for r, recipe in enumerate(recipes):
        indeg[recipe] = len(ingredients[r])
        for ing in ingredients[r]:
            graph[ing].append(recipe)

    q = deque(supplies)
    ans = []

    # Kahn's BFS
    while q:
        item = q.popleft()
        for recipe in graph[item]:
            indeg[recipe] -= 1
            if indeg[recipe] == 0:
                ans.append(recipe)
                q.append(recipe)

    return ans


# one test (same as Java main)
if __name__ == "__main__":
    recipes = ["A", "B", "C", "D"]
    ingredients = [
        ["a", "b"],
        ["b", "c"],
        ["c", "d"],
        ["d", "e"]
    ]
    supplies = ["a", "b", "c", "d", "e"]

    print(find_all_recipes(recipes, ingredients, supplies))
