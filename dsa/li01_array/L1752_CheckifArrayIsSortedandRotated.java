package li01_array;

public class L1752_CheckifArrayIsSortedandRotated {

    public static void main(String[] args) {
        L1752_CheckifArrayIsSortedandRotated obj = new L1752_CheckifArrayIsSortedandRotated();
        int[] arr = { 3, 4, 5, 1, 2 };
        System.out.println(obj.check(arr));
    }

    // Problem: https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
    public boolean check(int[] nums){
        int n = nums.length;
        int count = 0;
        if(nums[0] < nums[n-1])
            count++;
        for(int i=1; i<n; i++){
            if(nums[i] < nums[i-1]){
                count++;
            }
        }

        return count <= 1;
    }

}
