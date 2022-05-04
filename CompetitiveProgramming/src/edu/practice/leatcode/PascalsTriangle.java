package edu.practice.leatcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

	public static void main(String[] args) {
		PascalsTriangle obj = new PascalsTriangle();
		System.out.println(obj.generate(5));
	}

	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            if(i == 0){
                List<Integer> row = new ArrayList<>(Arrays.asList(1));
                result.add(row);
            }else if(i == 1){
                List<Integer> row = new ArrayList<>(Arrays.asList(1,1));
                result.add(row);
            }else{
                List<Integer> lastRow = result.get(i-1);
                List<Integer> newRow = new ArrayList<>();
                for(int j=0; j<=lastRow.size(); j++){
                    if(j == 0 || j == lastRow.size()){
                        newRow.add(1);
                    }else{
                        newRow.add(lastRow.get(j-1)+lastRow.get(j));
                    }
                }
                result.add(newRow);
            }
            
        }
        return result;
    }
}
