package edu.algos.li24_bit;

public class NumberOfStepsToReduceANumberToZero {

	public static void main(String[] args) {
		NumberOfStepsToReduceANumberToZero obj = new NumberOfStepsToReduceANumberToZero();
		
		System.out.println(obj.numberOfSteps(14));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
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
