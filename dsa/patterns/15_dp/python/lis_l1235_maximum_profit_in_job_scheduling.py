# Problem: https://leetcode.com/problems/maximum-profit-in-job-scheduling/
# Idea: Use profits tabulation array for jobs
# If job j can be picked before ith job, update the profit of i.
# TODO
def jobScheduling(starts, ends, profits):
    n = len(starts)

    # create jobs as tuples (start, end, profit)
    jobs = []
    for i in range(n):
        jobs.append((starts[i], ends[i], profits[i]))

    # sort jobs based on start time
    jobs.sort(key=lambda x: x[0])

    # profit[i] stores max profit including job i
    profit = [0] * n
    for i in range(n):
        profit[i] = jobs[i][2]

    maxProfit = 0
    for i in range(1, n):
        for j in range(i):
            # if jobs do NOT overlap
            if not (jobs[j][1] > jobs[i][0] and jobs[j][0] < jobs[i][1]):
                profit[i] = max(profit[i], profit[j] + jobs[i][2])

        if profit[i] > maxProfit:
            maxProfit = profit[i]

    return maxProfit


# -------- Test (same as Java main) --------
starts = [1, 2, 3, 3]
ends = [3, 4, 5, 6]
profits = [50, 10, 40, 70]

print(jobScheduling(starts, ends, profits))
