package edu.algos.li17.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		GenerateParentheses obj = new GenerateParentheses();
		
		System.out.println(obj.generateParenthesis(3));
		
	}

	public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesisRec(list, "", n, 0, 0);
        return list;
    }
	
	public void generateParenthesisRec(List<String> list, String str, int n, int open, int close) {
        if(open == close && open == n){
            list.add(str);
        }
        if(open < n){
            generateParenthesisRec(list, str+"(", n, open+1, close);
        }
        if(close < open){
            generateParenthesisRec(list, str+")", n, open, close+1);
        }
    }
}
