package  com.algos.topics.li18_string.revised;

public class L171_ExcelSheetColumnNumber {

	public static void main(String[] args) {
		L171_ExcelSheetColumnNumber obj = new L171_ExcelSheetColumnNumber();

		System.out.println(obj.titleToNumber("AA"));
	}

	/*
	 * Problem: https://leetcode.com/problems/excel-sheet-column-number/
	 * Companies: Google
     * Idea: Move left to right. Mulitiply the result by 26 to shift it right, then add curr char num.
	 * */
	public int titleToNumber(String columnTitle) {
        int result = 0;
        for(char ch: columnTitle.toCharArray()){
            result *= 26;
            result += ch-'A'+1;
        }

        return result;
    }

}
