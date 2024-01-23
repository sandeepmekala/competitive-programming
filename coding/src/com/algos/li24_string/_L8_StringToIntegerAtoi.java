package  com.algos.li24_string;

public class _L8_StringToIntegerAtoi {

	public static void main(String[] args) {
		_L8_StringToIntegerAtoi obj = new _L8_StringToIntegerAtoi();
		
		System.out.println(obj.myAtoi("-42"));
	}

	/*
	 * Problem: https://leetcode.com/problems/string-to-integer-atoi/
	 * Companies: Amazon
     * Idea: Use separate loops to check each condition. Track isPositive if it is -ve/+ve.
     * Check num*10 goes above INT_MAX and also check num*10+s[i] goes above Integer range by inversing the match equation.
     * 
	 * */
	public int myAtoi(String s) {
        if(s.isEmpty()) 
            return 0;
        
        char[] chars = s.toCharArray();
        int i=0, n=chars.length, num = 0;
        boolean isPositive = true;
        
        while(i<n && chars[i] == ' ') i++;                  //ignoring whitespaces
        
        if(i<n && (chars[i] == '-' || chars[i] == '+')){    //checking for sign
            if(chars[i++] == '-') isPositive = false; 
        }

        while(i<n && Character.isDigit(chars[i])){
            int intVal = (chars[i] - '0');
            if(num > Integer.MAX_VALUE/10 || num*10 > Integer.MAX_VALUE-intVal) {
                return isPositive? Integer.MAX_VALUE: Integer.MIN_VALUE;
            }

            num *= 10;
            num += intVal;
            i++;
        }

        return isPositive? num: -num;
        
    }
}
