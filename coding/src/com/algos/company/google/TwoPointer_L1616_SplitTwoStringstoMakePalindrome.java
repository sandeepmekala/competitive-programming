package com.algos.company.google;

public class TwoPointer_L1616_SplitTwoStringstoMakePalindrome {
    public static void main(String[] args) {
        TwoPointer_L1616_SplitTwoStringstoMakePalindrome obj = new TwoPointer_L1616_SplitTwoStringstoMakePalindrome();
        System.out.println(obj.checkPalindromeFormation("x", "y"));
        System.out.println(obj.checkPalindromeFormation("abdef", "fecab"));
        System.out.println(obj.checkPalindromeFormation("ulacfd", "jizalu"));
        System.out.println(obj.checkPalindromeFormation("xbdef", "xecab"));
    }

    // Problem: https://leetcode.ca/2018-12-05-1616-Split-Two-Strings-to-Make-Palindrome/
    // Time: O(n)
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    private boolean check(String a, String b) {
        int n = a.length();
        int i = 0;
        int j = n - 1;
        while (i < j && a.charAt(i) == b.charAt(j)) {
            i++;
            j--;
        }
        // check(a, b) -> check if remaining string b is palindrome and vice versa
        return i >= j || isPalindrome(a, i, j) || isPalindrome(b, i, j);
    }

    private boolean isPalindrome(String a, int i, int j) {
        while (i < j && a.charAt(i) == a.charAt(j)) {
            i++;
            j--;
        }
        return i >= j;
    }
}
