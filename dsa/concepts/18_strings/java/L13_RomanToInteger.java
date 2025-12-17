public class L13_RomanToInteger {

	public static void main(String[] args) {
		L13_RomanToInteger obj = new L13_RomanToInteger();

		String s = "MCMXCIV";
		System.out.println(obj.romanToInt(s));
	}

	/*
	 * Problem: https://leetcode.com/problems/roman-to-integer/
     * Idea: Move left to right. For every roman char add its value to num.
     * Incase, roman chars C,X,I check next char, if it is higher then it, then subtract its value from num. I could have V or X as its right char.
	 *
	 * */
	public int romanToInt(String s) {
        int num = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'M') num += 1000;
            else if(ch == 'D') num += 500;
            else if(ch == 'C')
                if(i+1 < s.length() && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M'))
                    num -= 100;
                else
                    num += 100;
            else if(ch == 'L') num += 50;
            else if(ch == 'X')
                if(i+1 < s.length() && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C'))
                    num -= 10;
                else
                    num += 10;
            else if(ch == 'V') num += 5;
            else if(ch == 'I')
                if(i+1 < s.length() && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X'))
                    num -= 1;
                else
                    num += 1;
        }

        return num;
    }

}
