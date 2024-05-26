package  com.algos.core.li04_twopointers;

import java.util.Arrays;

public class L167_TwoSumIIInputArrayIsSorted {
	public static void main(String args[]) {
		L167_TwoSumIIInputArrayIsSorted obj = new L167_TwoSumIIInputArrayIsSorted();
		System.out.println(Arrays.toString(obj.twoSum(new int[] {2,7,11,15}, 9)));
	}
	
	// Problem: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
	// Idea: One ptr comes from front and another comes from back.
	public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i=0, j=numbers.length-1;
        while(i<j) {
        	if(numbers[i]+numbers[j] == target) {
        		result[0] = i+1;
        		result[1] = j+1;
        		break;
        	}else if(numbers[i]+numbers[j] > target) {
        		j--;
        	}else {
        		i++;
        	}
        }
        return result;
    }
}
