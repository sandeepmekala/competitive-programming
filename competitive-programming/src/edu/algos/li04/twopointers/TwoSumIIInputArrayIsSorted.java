package edu.algos.li04.twopointers;

import java.util.Arrays;

public class TwoSumIIInputArrayIsSorted {
	public static void main(String args[]) {
		TwoSumIIInputArrayIsSorted obj = new TwoSumIIInputArrayIsSorted();
		System.out.println(Arrays.toString(obj.twoSum(new int[] {2,7,11,15}, 9)));
	}
	
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
