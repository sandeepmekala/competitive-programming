import java.util.Arrays;

public class L2149_RearrangeArrayElementsbySign {
    public static void main(String[] args) {
        L2149_RearrangeArrayElementsbySign obj = new L2149_RearrangeArrayElementsbySign();
        int[] nums = { -1, 2, 3, -4, -1, 4 };
        nums = obj.rearrangeArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    // Problem: https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
    // Idea: Traverse the array and put positive numbers at even index and negative numbers at odd index.
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        int[] temp = new int[n];
        int pos = 0, neg = 1;
        for(int i=0; i<n; i++){
            if(nums[i] < 0){
                temp[neg] = nums[i];
                neg += 2;
            }else{
                temp[pos] = nums[i];
                pos += 2;
            }
        }

        return temp;
    }

}
