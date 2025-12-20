# 
#     Idea: Similar like longest increasing subsequence.
#  * 	i	4	6	1	3	8	4	6
#  * 	mxs	4	10	1	4	18	8	14
#  *
def maxSum(input, n):
    max_val = 0
    mxs = [0] * n

    for i in range(n):
        mxs[i] = input[i]

    for i in range(1, n):
        for j in range(i):
            if input[j] < input[i]:
                if mxs[j] + input[i] > mxs[i]:
                    mxs[i] = mxs[j] + input[i]

        if mxs[i] > max_val:
            max_val = mxs[i]

    return max_val


# -------- Test (same as Java main) --------
input_arr = [4, 6, 1, 3, 8, 4, 6]
print(maxSum(input_arr, len(input_arr)))
