import java.util.ArrayList;
import java.util.List;

public class L22_GenerateParentheses {

	public static void main(String[] args) {
		L22_GenerateParentheses obj = new L22_GenerateParentheses();

		System.out.println(obj.generateParenthesis(3));

	}

    // Problem: https://leetcode.com/problems/generate-parentheses/
    // Idea: Use open and close brackets counts to track how many of them added to str.
    // pass the parenthesys string to recursion by adding "(" or ")" depending on the condition
    // Add "(" if open < n
    // Add ")" if close < open
    // Time: O(2^n) as recursion tree has 2 branches at each level and depth is n
	// Space: O(2*n)
	public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesis(list, "", n, 0, 0);
        return list;
    }

	public void generateParenthesis(List<String> list, String str, int n, int open, int close) {
        if(open == n && close == n){
            list.add(str);
            return;
        }
        if(open < n){
            generateParenthesis(list, str+"(", n, open+1, close);   // "(" added to str and sent, after the call it is just str. Hence, backtracking.
        }
        if(close < open){
            generateParenthesis(list, str+")", n, open, close+1);
        }
    }
}
