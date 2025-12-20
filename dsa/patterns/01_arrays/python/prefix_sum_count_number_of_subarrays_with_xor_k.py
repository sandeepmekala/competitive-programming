"""
PrefixSum - Count Number of Subarrays with XOR K

Idea: Use a map to store prefix sum and its frequency
Same as count sum arrays with sum k
XR: xor(0 -> curr) and y: xor(0 -> j) where j < curr
x ^ k = XR
x = XR ^ k
Time: O(n), Space: O(n)
"""

def subarray_xor_k(nums, k):
    xr = 0
    cnt = 0
    map_freq = {0: 1}
    
    for num in nums:
        xr ^= num
        x = xr ^ k
        if x in map_freq:
            cnt += map_freq[x]
        
        if xr not in map_freq:
            map_freq[xr] = 0
        map_freq[xr] += 1
    
    return cnt


if __name__ == "__main__":
    nums = [1, 1, 2, 3, 4]
    print(subarray_xor_k(nums, 3))
