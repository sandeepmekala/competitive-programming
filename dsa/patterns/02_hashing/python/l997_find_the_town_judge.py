"""
L997 - Find the Town Judge

Problem: https://leetcode.com/problems/find-the-town-judge/
Idea: From the trust array maintain the count of each truster and trustee.
Judge will have n-1 trustee's and 0 truster's.
Time: O(n)
Space: O(n)
"""

def find_judge(n, trust):
    truster = [0] * (n + 1)
    trustee = [0] * (n + 1)
    
    for t in trust:
        truster[t[0]] += 1
        trustee[t[1]] += 1
    
    for i in range(1, n + 1):
        if trustee[i] == n - 1 and truster[i] == 0:
            return i
    
    return -1


if __name__ == "__main__":
    n = 3
    trust = [[1, 3], [2, 3]]
    print(f"Input: n = {n}, trust = {trust}")
    print(f"Town judge: {find_judge(n, trust)}")
