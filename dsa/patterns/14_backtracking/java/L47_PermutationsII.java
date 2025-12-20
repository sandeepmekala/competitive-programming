import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class L47_PermutationsII {

    public static void main(String[] args) {
        L47_PermutationsII obj = new L47_PermutationsII();
        System.out.println(obj.permuteUnique(new int[] { 1, 1, 2 }));

    }

    // Problem: https://leetcode.com/problems/permutations-ii/
    // Idea: Fix each position once swap each element to that position to generat permutations.
    // Skip duplicate numbers using set. Alternatively, you can sort nums also.
    // Time: O(n!)
	// Space: O(1)
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Arrays.sort(nums);
        permute(nums, 0, result);
        return result;
    }

    public void permute(int[] nums, int ind, List<List<Integer>> result) {
        if (ind == nums.length - 1) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        HashSet<Integer> distinct = new HashSet<>();
        for (int i = ind; i <= nums.length - 1; i++) {
            // if(i>ind && nums[i] == nums[i-1]) continue;
            if (distinct.add(nums[i])) {
                swap(nums, ind, i);
                permute(nums, ind + 1, result);
                swap(nums, ind, i);
            }
        }
    }

    private void swap(int[] nums, int l, int i) {
        int temp = nums[l];
        nums[l] = nums[i];
        nums[i] = temp;
    }

}
