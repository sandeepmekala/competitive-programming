package edu.algos.li01_bit;

public class L1342_NumberOfStepsToReduceANumberToZero {

	public static void main(String[] args) {
		L1342_NumberOfStepsToReduceANumberToZero obj = new L1342_NumberOfStepsToReduceANumberToZero();
		
		System.out.println(obj.numberOfSteps(14));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
     * Idea: Run a while loop until num becomes 0.
	 * */
	public int numberOfSteps(int num) {
        int count = 0;
        while(num > 0){
            count++;
            if((num&1) == 0){
                num = num>>1;
            }else{
                num = num-1;
            }
        }
        return count;
    }

}
