package edu.algos.li04.twopointers;

public class LongPressedName {

	public static void main(String[] args) {
		LongPressedName obj = new LongPressedName();
		
		String name = "alex";
		String typed = "aaleex";
		System.out.println(obj.isLongPressedName(name, typed));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/long-pressed-name/
	 * 
	 * */
	public boolean isLongPressedName(String name, String typed) {
        int i=0, j=0,m=name.length(), n=typed.length();
        while(i<m && j<n){
            if(name.charAt(i) != typed.charAt(j))
                return false;
            
            char ch = name.charAt(i);
            while(i<m && j<n && name.charAt(i) == ch){
                if(name.charAt(i) != typed.charAt(j))
                    return false;
                i++;
                j++;
            }
            while(j<n && typed.charAt(j) == ch) j++;
            if((i>=m && j<n) || (i<m && j>=n)) return false;
        }
        return true;
    }
}
