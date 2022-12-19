package edu.algos.li23_math;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		ExcelSheetColumnTitle obj = new ExcelSheetColumnTitle();
		
		System.out.println(obj.convertToTitle(27));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/excel-sheet-column-title/
	 *  
	 * */
	public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while(columnNumber > 0){
            columnNumber--;
            int reminder = columnNumber%26;
            columnNumber = columnNumber/26;
            sb.insert(0, (char)('A'+reminder));
        }
        
        return sb.toString();
    }
}
