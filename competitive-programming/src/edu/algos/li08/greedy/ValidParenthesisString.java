package edu.algos.li08.greedy;

public class ValidParenthesisString {

	public static void main(String[] args) {
		ValidParenthesisString obj = new ValidParenthesisString();
		
		String s  = "(*))";
		System.out.println(obj.checkValidString(s));
	}
	/*
	 * Problem: Check if the parenthesis string is valid. * can be ( or ) or "".
	 * Concept: The idea is to track the min and max left parenthesis that can be there in string
	 * Decrease leftMin if you are assuming * as )
	 * Increase leftMax if you are assuming * as (
	 * At the end of string we should have 0 leftMin means, we mapped every ( with )
	 * At any point we should have count("(") >= count(")"). if leftMin goes -ve, means we assumed some where the * as ). In the best case we can have ) which makes leftMin = 0. so reset leftMin to 0. 
	 * At any point we should always have leftMin <= left Max, else return false.
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
