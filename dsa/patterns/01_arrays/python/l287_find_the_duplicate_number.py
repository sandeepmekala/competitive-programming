# L287 - Find The Duplicate Number
#
# Problem: https://leetcode.com/problems/find-the-duplicate-number/
#
# Idea:Create a graph with indexes
# Step 1: Detect cycle using FCD.
# Step 2: Place one pointer at head of LL | Another pointer should be at the point where fast and slow meet.
# Step 3: Move 1st pointer and 2nd pointer by one step each.
# Step 4: Both will meet again at entry point of cycle.


def find_duplicate(nums):
    slow = fast = nums[0]

    # Step 1: Detect cycle
    while True:
        slow = nums[slow]
        fast = nums[nums[fast]]
        if slow == fast:
            break

    # Step 2–4: Find entry point of cycle (duplicate number)
    fast = nums[0]
    while slow != fast:
        slow = nums[slow]
        fast = nums[fast]

    return slow


# -------------------- TEST --------------------
if __name__ == "__main__":
    print(find_duplicate([1, 3, 4, 2, 2]))  # 2
