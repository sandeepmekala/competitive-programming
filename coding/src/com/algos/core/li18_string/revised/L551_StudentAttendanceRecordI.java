package  com.algos.core.li18_string.revised;

public class L551_StudentAttendanceRecordI {

	public static void main(String[] args) {
		L551_StudentAttendanceRecordI obj = new L551_StudentAttendanceRecordI();
		
		System.out.println(obj.checkRecord("PPALLP"));
	}

	/*
	 * Problem: https://leetcode.com/problems/student-attendance-record-i/
	 * Idea: Use to vars to track absents and lates.
	 * */
	public boolean checkRecord(String s) {
        int absents = 0;
        int lates = 0;
        for(char ch: s.toCharArray()){
            if(ch == 'A') {
                absents++; 
                lates = 0;
                if(absents >= 2) return false;
            } else if(ch == 'L') {
                lates++;
                if(lates >= 3) return false;
            } else lates = 0;
        }
        
        return true;
    }
}
