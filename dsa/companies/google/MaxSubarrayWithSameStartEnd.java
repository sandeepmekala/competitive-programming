
import java.util.HashMap;
import java.util.Map;

public class MaxSubarrayWithSameStartEnd {

    //Problem: https://leetcode.com/discuss/interview-question/4929501/Google-onsite-Interview
    public int[] maxSubarrayWithEqualStartEnd(int[] nums) {
        // Map to store the prefix sum for each number encountered
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        // Map to store the first occurrence index of each number
        Map<Integer, Integer> firstIndexMap = new HashMap<>();

        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int start = -1;
        int end = -1;

        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            currentSum += nums[i];

            if (firstIndexMap.containsKey(nums[i])) {
                int firstIndex = firstIndexMap.get(nums[i]);
                int previousPrefixSum = prefixSumMap.get(nums[i]);

                int subarraySum = currentSum - previousPrefixSum;

                if (subarraySum > maxSum) {
                    maxSum = subarraySum;
                    start = firstIndex;
                    end = i;
                }

                // Update prefix sum to the minimum value encountered so far
                prefixSumMap.put(nums[i], Math.min(previousPrefixSum, currentSum));
            } else {
                firstIndexMap.put(nums[i], i);
                prefixSumMap.put(nums[i], currentSum);
            }
        }

        return new int[] {start, end};
    }

        public static void main(String[] args) {
            MaxSubarrayWithSameStartEnd sol = new MaxSubarrayWithSameStartEnd();
            int[] nums = {1, 3, 5, 6, 3, -6, 3};
            int[] result = sol.maxSubarrayWithEqualStartEnd(nums);
            System.out.println("Start index: " + result[0] + ", End index: " + result[1]);
        }
    }
