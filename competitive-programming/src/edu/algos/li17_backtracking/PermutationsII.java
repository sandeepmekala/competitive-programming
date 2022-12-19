package edu.algos.li17_backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationsII {

	public static void main(String[] args) {
		PermutationsII obj = new PermutationsII();
		System.out.println(obj.permute(new int[] {1,2,3}));

	}
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, nums.length-1, result);
        return result;
    }
    
    public void permute(int[] nums, int l, int r, List<List<Integer>> result) {
        if(l == r){
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0; i<nums.length; i++){
                list.add(nums[i]);
            }
            result.add(list);
        }
        for(int i=l; i<=r; i++){
            swap(nums, l, i);
            permute(nums, l+1, r, result);
            swap(nums, l, i);
        }
        
    }
    
    private void swap(int[] nums, int l, int index){
        int temp = nums[l];
        nums[l] = nums[index];
        nums[index] = temp;
    }

}
