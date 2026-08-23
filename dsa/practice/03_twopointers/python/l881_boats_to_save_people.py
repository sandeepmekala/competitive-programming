"""
L881 - Boats to Save People
Problem: https://leetcode.com/problems/boats-to-save-people/
Companies: Amazon
Idea: Sort the weights so that you can take min and max weight together
Time: O(n log n)
Space: O(1)
"""

def num_rescue_boats(people, limit):
    """
    Find minimum number of boats needed to save all people.
    
    Args:
        people: List[int] - Array of people weights
        limit: int - Maximum weight capacity per boat
    
    Returns:
        int - Minimum number of boats needed
    """
    people.sort()
    i, j = 0, len(people) - 1
    count = 0
    
    while i <= j:
        if i == j or people[i] + people[j] <= limit:
            count += 1
            i += 1
            j -= 1
        else:
            count += 1
            j -= 1
    
    return count


if __name__ == "__main__":
    people = [3, 2, 2, 1]
    limit = 3
    result = num_rescue_boats(people, limit)
    print(result)  # Expected: 3
