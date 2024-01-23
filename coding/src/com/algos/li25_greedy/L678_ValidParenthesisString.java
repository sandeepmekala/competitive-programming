package  com.algos.li25_greedy;

public class L678_ValidParenthesisString {

	public static void main(String[] args) {
		L678_ValidParenthesisString obj = new L678_ValidParenthesisString();
		
		String s  = "(*))";
		System.out.println(obj.checkValidString(s));
	}
	/*
	 * Problem: https://leetcode.com/problems/valid-parenthesis-string/
	 * Idea: The idea is to track the min and max left parenthesis that can be there in string.
	 * Decrease leftMin if you are assuming * as )
	 * Increase leftMax if you are assuming * as (
	 * At the end of the string we should have 0 leftMin means, we mapped every ( with )
	 * At any point we should have count("(") >= count(")"). If leftMin goes -ve, means we assumed somewhere the * as ). In the best case we can have ) which makes leftMin = 0. So reset leftMin to 0. 
	 * At any point we should always have leftMin <= leftMax, else return false.
	 * 
	 * */
	public boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0, n = s.length();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                leftMin++;
                leftMax++;
            }else if(ch == ')'){
                leftMin--;
                leftMax--;
            }else{      //means *
                leftMin--;
                leftMax++;
            }
            
            if(leftMin < 0){
                leftMin = 0;
            }
            if(leftMax < leftMin){
                return false;
            }
        }
        
        return leftMin == 0;
    }

}
