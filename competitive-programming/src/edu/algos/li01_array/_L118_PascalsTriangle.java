	package edu.algos.li01_array;

import java.util.ArrayList;
import java.util.List;

public class _L118_PascalsTriangle {

	public static void main(String[] args) {
		_L118_PascalsTriangle obj = new _L118_PascalsTriangle();
		System.out.println(obj.generate(5));
	}

	/*
	 * Problem: https://leetcode.com/problems/pascals-triangle/
	 * Idea: Track the last row list in a variable
	 * */
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> lastRow = null, row = null;
        for(int i=0; i<numRows; i++){
            row = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j == 0 || j == i){
                    row.add(1);
                }else{
                    row.add(lastRow.get(j-1)+lastRow.get(j));
                }
            }
            result.add(row);
            lastRow = row;
            
        }
        return result;
    }
}
