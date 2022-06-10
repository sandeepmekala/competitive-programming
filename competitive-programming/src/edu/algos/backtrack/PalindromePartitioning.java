package edu.algos.backtrack;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public static void main(String[] args) {
		PalindromePartitioning obj = new PalindromePartitioning();
		String s = "aab";
		System.out.println(obj.partition(s));
	}

	public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(s, 0, new ArrayList<String>(), result);
        return result;
    }
    
    private void dfs(String s, int i, List<String> polindromes, List<List<String>> result){
        if(i >= s.length()){
            result.add(new ArrayList<String>(polindromes));
            return;
        }
        
        for(int j=i; j<s.length(); j++){
            if(isPolindrome(s, i, j)){
                polindromes.add(s.substring(i,j+1));
                dfs(s, j+1, polindromes, result);
                polindromes.remove(s.substring(i,j+1));
            }
        }
    }
    
    private boolean isPolindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
