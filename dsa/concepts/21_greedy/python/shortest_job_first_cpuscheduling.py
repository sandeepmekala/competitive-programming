# Problem: https://www.geeksforgeeks.org/program-for-shortest-job-first-or-sjf-cpu-scheduling-set-1-non-preemptive/
# Idea: Greedy: Sort the jobs based on task time. Pick the job with minimum burst time.
# Time: O(nlogn)

def shortestJobFirst(tasks):
    tasks.sort()
    total_wait_time = 0
    wait_time = 0

    for task in tasks:
        total_wait_time += wait_time
        wait_time += task

    return total_wait_time / len(tasks)


# -------- Test --------
tasks = [4, 3, 7, 1, 2]
print(shortestJobFirst(tasks))   # 3.0
