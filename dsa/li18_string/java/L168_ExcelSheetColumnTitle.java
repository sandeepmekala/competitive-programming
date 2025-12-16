
public class L168_ExcelSheetColumnTitle {

	public static void main(String[] args) {
		L168_ExcelSheetColumnTitle obj = new L168_ExcelSheetColumnTitle();

		System.out.println(obj.convertToTitle(27));
	}

	/*
	 * Problem: https://leetcode.com/problems/excel-sheet-column-title/
	 * Idea: As the num is 1 indexed, subtract 1 from it and take reminder from num.
	 * */
	public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while(columnNumber > 0){
            columnNumber--;
            int rem = columnNumber%26;
            sb.append((char)('A'+rem));
            columnNumber = columnNumber/26;
        }

        return sb.reverse().toString();
    }
}
