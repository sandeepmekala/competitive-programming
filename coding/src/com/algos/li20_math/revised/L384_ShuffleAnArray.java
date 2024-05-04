package  com.algos.li20_math.revised;

import java.util.Arrays;
import java.util.Random;

public class L384_ShuffleAnArray {

	public static void main(String[] args) {
		L384_ShuffleAnArray obj = new L384_ShuffleAnArray(new int[] {1,2,3,4,5});
		
		System.out.println(Arrays.toString(obj.shuffle()));
		System.out.println(Arrays.toString(obj.reset()));
	}

	/*
	 * Problem: https://leetcode.com/problems/shuffle-an-array/
	 * Companies: Amazon	 
     * Idea: Clone the array in shuffle function and use random to generate radome indices and place each element of array.
	 * */
	int[] nums;
    public L384_ShuffleAnArray(int[] nums) {
        this.nums = nums;
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        int[] shuffled = nums.clone();
        int n = shuffled.length;
        Random r = new Random();
        for(int i=0; i<n; i++){
            int randInd = r.nextInt(i+1);
            int temp = shuffled[i];
            shuffled[i] = shuffled[randInd];
            shuffled[randInd] = temp;
        }
        
        return shuffled;
    }
}
