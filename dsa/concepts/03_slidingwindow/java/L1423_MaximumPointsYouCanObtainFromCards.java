public class L1423_MaximumPointsYouCanObtainFromCards {

    public static void main(String[] args) {
        L1423_MaximumPointsYouCanObtainFromCards obj = new L1423_MaximumPointsYouCanObtainFromCards();

        int[] nums = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(obj.maxScore(nums, k));
    }

    // Problem: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
    // Idea: Sliding window
    // Time: O(n)
    public int maxScore(int[] nums, int k) {
        int n = nums.length, sum = 0, maxSum = 0;
        for(int i=0; i<k; i++)
            sum += nums[i];
        maxSum = sum;

        int l=k-1, r=n-1;
        while(l>=0){
            sum -= nums[l];
            sum += nums[r];
            l--; r--;

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
