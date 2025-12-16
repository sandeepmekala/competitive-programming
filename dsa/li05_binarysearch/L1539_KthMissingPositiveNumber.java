package li05_binarysearch;

public class L1539_KthMissingPositiveNumber {

    public static void main(String[] args) {
        L1539_KthMissingPositiveNumber obj = new L1539_KthMissingPositiveNumber();
        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(obj.findKthPositive(arr, k));
    }

    // Problem: https://leetcode.com/problems/kth-missing-positive-number/
    // Idea: Number of missing nums at each index will be increasing. That will be search space.
    // 2,3,4,7,11
    // 1,1,1,3,6
    // Time: O(logn)
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (low+high)/2;
            int missing = arr[mid] - (mid + 1);
            if(missing < k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return low + k;
    }
}
