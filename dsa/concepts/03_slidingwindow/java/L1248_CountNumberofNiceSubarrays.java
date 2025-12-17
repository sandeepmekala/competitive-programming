
public class L1248_CountNumberofNiceSubarrays {

    public static void main(String[] args) {
        L1248_CountNumberofNiceSubarrays obj = new L1248_CountNumberofNiceSubarrays();

        int[] nums = {1,1,2,1,1};
        int k = 3;
        System.out.println(obj.numberOfSubarrays(nums, k));
    }

    // Problem: https://leetcode.com/problems/count-number-of-nice-subarrays/
    // Idea: It is same as binary subarrays with sum k as you can replace all odd numbers with 1 and even numbers with 0
    public int numberOfSubarrays(int[] nums, int k) {
        return numSubarraysWithSumLessThenOrEqual(nums, k) -
        numSubarraysWithSumLessThenOrEqual(nums, k-1);
    }

    public int numSubarraysWithSumLessThenOrEqual(int[] nums, int k) {
        if(k < 0) return 0;
        int l=0, r=0, sum=0, cnt=0, n=nums.length;
        while(r<n){
            sum += nums[r]%2;
            while(sum > k){
                sum -= nums[l]%2;
                l++;
            }

            if(sum <= k)
                cnt += (r-l+1);
            r++;
        }

        return cnt;
    }
}
