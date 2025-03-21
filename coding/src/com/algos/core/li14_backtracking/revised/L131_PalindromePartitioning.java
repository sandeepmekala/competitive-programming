package  com.algos.core.li14_backtracking.revised;

import java.util.ArrayList;
import java.util.List;

public class L131_PalindromePartitioning {

	public static void main(String[] args) {
		L131_PalindromePartitioning obj = new L131_PalindromePartitioning();
		String s = "aab";
		System.out.println(obj.partition(s));
	}

    // Problem: https://leetcode.com/problems/palindrome-partitioning/
    // Idea: Pass ind as a pointer in str. Starts with 0. 
    // Run a loop i, starts with ind and find a polindrome. And call the recursion to find subsequent polindromes with index as i+1.
	// Time: O(n^n)
	// Space: O(n)
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partition(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void partition(String s, int ind, List<String> polindromes, List<List<String>> result){
        if(ind == s.length()){
            result.add(new ArrayList<>(polindromes));
            return;
        }
        
        for(int i=ind; i<s.length(); i++){
            if(isPolindrome(s, ind, i)){
                polindromes.add(s.substring(ind,i+1));
                partition(s, i+1, polindromes, result);
                polindromes.remove(polindromes.size()-1);
            }   
        }
    }
    
    private boolean isPolindrome(String s, int l, int r){
        while(l<r){
            if(s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}
