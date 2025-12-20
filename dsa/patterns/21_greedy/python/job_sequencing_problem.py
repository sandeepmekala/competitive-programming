# Problem: Job Sequencing Problem
# Idea: Sort jobs by profit in descending order, then for each job find the latest free slot before its deadline
# Delay the jobs as late as possible to leave first slots for other jobs
# Time: O(n * max_deadline)
# Space: O(max_deadline)

def job_sequencing(jobs):
    # jobs = [(jobId, deadline, profit), ...]
    
    # sort jobs by profit descending
    jobs.sort(key=lambda x: x[2], reverse=True)

    # find maximum deadline
    max_deadline = 0
    for _, d, _ in jobs:
        max_deadline = max(max_deadline, d)

    # slot array to track occupied time slots
    slots = [-1] * (max_deadline + 1)

    job_count = 0
    total_profit = 0

    for job_id, deadline, profit in jobs:
        # try to place job at latest possible slot
        for t in range(deadline, 0, -1):
            if slots[t] == -1:
                slots[t] = job_id
                job_count += 1
                total_profit += profit
                break

    return job_count, total_profit


# -------- Test --------
jobs = [
    (1, 4, 20),
    (2, 1, 10),
    (3, 2, 40),
    (4, 2, 30)
]

count, profit = job_sequencing(jobs)
print(count, profit)   # Expected: 3 90
