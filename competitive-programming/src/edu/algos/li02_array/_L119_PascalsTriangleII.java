package edu.algos.li02_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _L119_PascalsTriangleII {

	public static void main(String[] args) {
		_L119_PascalsTriangleII obj = new _L119_PascalsTriangleII();
		
		System.out.println(obj.getRow(3));
	}

	/*
	 * Problem: https://leetcode.com/problems/pascals-triangle-ii/
     * Idea: Calculate the next row from the current row from right to left
	 * */
	public List<Integer> getRow(int rowIndex) {
        Integer[] rowArr = new Integer[rowIndex+1];
        Arrays.fill(rowArr, 0);
        rowArr[0] = 1;
        
        for(int i=1; i<=rowIndex; i++){
            for(int j=i; j>0; j--){
                rowArr[j] = rowArr[j]+rowArr[j-1];
            }
        }
        
        return Arrays.asList(rowArr);
    }

    // Idea: value at index k = nCk
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        long numerator = 1, denominator = 1;
        for(int i=0; i<=rowIndex; i++){
            if(i == 0 || i == rowIndex){
                result.add(1);
            }else{
                numerator *= (rowIndex-i+1);
                denominator *= i;
                result.add((int)(numerator/denominator));
            }
        }
        
        return result;
    }
}
