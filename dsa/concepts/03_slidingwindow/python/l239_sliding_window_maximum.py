"""
L239 - Sliding Window Maximum

Problem: https://leetcode.com/problems/sliding-window-maximum/
Idea: Use monotonically decreasing deque. Maintain the nums in decreasing order in deque.
first <- 5, 4, 3 <- last
Take the left most to take the max for that window.
Remove the left most if it goes out of window.
Time: O(n)
Space: O(k)
"""

from collections import deque

def max_sliding_window(nums, k):
    n = len(nums)
    ans = [0] * (n - k + 1)
    
    l, r = 0, 0
    dq = deque()  # stores indices
    
    while r < n:
        # Remove elements from back while current element is larger
        while dq and nums[dq[-1]] < nums[r]:
            dq.pop()
        
        dq.append(r)  # add current element index
        
        # Remove elements that are out of current window
        if dq[0] < l:
            dq.popleft()
        
        # If we have processed at least k elements
        if r + 1 >= k:
            ans[l] = nums[dq[0]]  # front of deque has max element
            l += 1
        
        r += 1
    
    return ans


if __name__ == "__main__":
    nums = [1, 3, -1, -3, 5, 3, 6, 7]
    k = 3
    print(f"Input: nums = {nums}, k = {k}")
    print(f"Output: {max_sliding_window(nums, k)}")
