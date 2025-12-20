import heapq
from collections import Counter, deque

"""
Problem: https://leetcode.com/problems/task-scheduler/
Idea: We don't need to schedule the tasks but just need to find min time.
Find the freq's of each task so that remaining same task can be scheduled after t+n.
We will schedule most freq tasks first. Hence, insert all the freq in max pq to get max always.
For every time unit schedule one task and track the remaining tasks in separate q which can be scheduled after t+n.
For any time unit if any tasks from q can be loaded to pq, load them by comparing time.
"""
def leastInterval(tasks, n):
    # Count frequency of each task
    freq_map = Counter(tasks)

    # Max heap of frequencies (use negative for max-heap)
    max_heap = [-f for f in freq_map.values()]
    heapq.heapify(max_heap)

    # Queue to hold tasks in cooldown: (ready_time, remaining_freq)
    cooldown = deque()

    time = 0
    while max_heap or cooldown:
        time += 1

        # Execute one task if available
        if max_heap:
            freq = -heapq.heappop(max_heap)
            if freq > 1:
                cooldown.append((time + n, freq - 1))

        # Move tasks back from cooldown to heap if ready
        if cooldown and cooldown[0][0] == time:
            _, f = cooldown.popleft()
            heapq.heappush(max_heap, -f)

    return time


# ---- one test (similar to Java main) ----
if __name__ == "__main__":
    tasks = ["A", "A", "A", "B", "B", "B"]
    n = 2
    print(leastInterval(tasks, n))  # Expected: 8
