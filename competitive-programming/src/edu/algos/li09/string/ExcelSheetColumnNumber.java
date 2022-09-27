package edu.algos.li09.string;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		ExcelSheetColumnNumber obj = new ExcelSheetColumnNumber();
		
		System.out.println(obj.titleToNumber("AB"));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/excel-sheet-column-number/
	 * Companies: Google
	 * */
	public int titleToNumber(String columnTitle) {
        int result = 0;
        int i=0;
        while(i<columnTitle.length()){
            char chr = columnTitle.charAt(i++);
            result *= 26;
            result += chr-'A'+1;
        }
        
        return result;
    }

}
