package edu.algos.li03.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		TwoSum obj = new TwoSum();
		System.out.println(Arrays.toString(obj.twoSum(new int[] {2,7,11,15}, 9)));
	}
	
	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get((target-nums[i])), i};
            }else{
                map.put(nums[i], i);                 
            }
        }
        return new int[]{};
    }

}
