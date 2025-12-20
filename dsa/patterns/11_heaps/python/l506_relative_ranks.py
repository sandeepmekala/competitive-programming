import heapq

"""
Problem: https://leetcode.com/problems/relative-ranks/
Idea: Insert scores and indices to max q and pop them in decreasing order and assign ranks.
"""
def findRelativeRanks(score):
    n = len(score)

    # Max heap using negative score
    max_heap = [(-score[i], i) for i in range(n)]
    heapq.heapify(max_heap)

    result = [""] * n
    rank = 1

    while max_heap:
        _, idx = heapq.heappop(max_heap)

        if rank == 1:
            result[idx] = "Gold Medal"
        elif rank == 2:
            result[idx] = "Silver Medal"
        elif rank == 3:
            result[idx] = "Bronze Medal"
        else:
            result[idx] = str(rank)

        rank += 1

    return result


# ---- one test (similar to Java main) ----
if __name__ == "__main__":
    score = [1, 2, 3, 4, 5]
    print(findRelativeRanks(score))
