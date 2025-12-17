public class L678_ValidParenthesisString {

	public static void main(String[] args) {
		L678_ValidParenthesisString obj = new L678_ValidParenthesisString();

        String s  = "()()";
        String s2  = "(()";
		System.out.println(obj.checkValidBasicString(s));
		System.out.println(obj.checkValidBasicString(s2));

		String s3  = "(*))";
		String s4  = ")";
		System.out.println(obj.checkValidString(s3));
		System.out.println(obj.checkValidString(s4));
	}

    // Problem: https://leetcode.com/problems/valid-parenthesis-string/
	// Idea: The idea is to track the min and max left parenthesis that can be there in string.
	// Decrease min if you are assuming * as )
	// Increase max if you are assuming * as (
	// At the end of the string we should have 0 min means, we mapped every ( with )
	// At any point we should have count("(") >= count(")"). If min goes -ve, means we assumed somewhere the * as ). In the best case we can have ) which makes min = 0. So reset min to 0.
	// At any point we should always have min <= max, else return false.
	// Time: O(n), Space: O(1)
    public boolean checkValidString(String s) {
        int min = 0, max = 0, n = s.length();
        for(char ch: s.toCharArray()){
            if(ch == '('){
                min++;
                max++;
            }else if(ch == ')'){
                min--;
                max--;
            }else{      //means *
                min--;
                max++;
            }

            if(min < 0)     // We wrongly assumed some * as (. It is not valid to have -ve number of (.
                min = 0;
            if(max < min)   // max >= min
                return false;
        }

        return min == 0;
    }

    public boolean checkValidBasicString(String s) {
        int open = 0;
        for(char ch: s.toCharArray()){
            if(ch == '('){
                open++;
            }else{
                open--;
            }
            if(open < 0){
                return false;
            }
        }
        return open == 0;
    }
}
