package edu.algos.li01.array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

	public static void main(String[] args) {
		PascalsTriangleII obj = new PascalsTriangleII();
		
		System.out.println(obj.getRow(3));
	}

	/*
	 * Problem: https://leetcode.com/problems/pascals-triangle-ii/
	 * */
	public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        int numerator = 1, denominator = 1;
        for(int i=0; i<=rowIndex; i++){
            if(i == 0 || i == rowIndex){
                result.add(1);
            }else{
                numerator *= (rowIndex-i+1);
                denominator *= i;
                result.add(numerator/denominator);
            }
        }
        
        return result;
    }
}
