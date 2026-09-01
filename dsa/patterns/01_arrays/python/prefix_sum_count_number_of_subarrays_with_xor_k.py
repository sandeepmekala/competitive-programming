# PrefixSum - Count Number of Subarrays with XOR K
#
# Idea:
# - Use a hashmap to store prefix XOR and its frequency
# - Let XR = xor(0 → i)
# - Let X  = xor(0 → j) where j < i
# - If X ^ XR = k  ⇒  X = XR ^ k
#
# Time: O(n)
# Space: O(n)


def subarray_xor_k(nums, k):
    prefix_xor = 0
    count = 0
    freq = {0: 1}  # prefix_xor -> frequency

    for num in nums:
        prefix_xor ^= num

        # Count subarrays ending here with XOR = k
        count += freq.get(prefix_xor ^ k, 0)

        # Record current prefix XOR
        freq[prefix_xor] = freq.get(prefix_xor, 0) + 1

    return count


# -------------------- TEST --------------------
if __name__ == "__main__":
    nums = [1, 1, 2, 3, 4]
    print(subarray_xor_k(nums, 3))  # Output: 2
