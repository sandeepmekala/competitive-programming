package com.algos.topics.li15_dp.revised;

public class L91_DecodeWays {

    public static void main(String[] args) {
        L91_DecodeWays obj = new L91_DecodeWays();
        System.out.println(obj.numDecodings("06"));
    }

    // Problem: https://leetcode.com/problems/decode-ways/
    public int numDecodings(String s) {
        int n = s.length();

        if(s.startsWith("0")) return 0;
        if(n == 1) return 1;

        int[] dp = new int[n];
        dp[0] = 1;
        String num = s.substring(0, 2);
        if(s.charAt(1) == '0'){
            if(s.charAt(0) == '1' || s.charAt(0) == '2')
                dp[1] = 1;
            else
                return 0;
        }else if(num.compareTo("26") > 0 || num.compareTo("10") < 0){
            dp[1] = 1;
        }else if(num.compareTo("10") > 0 && num.compareTo("26") <= 0){
            dp[1] = 2;
        }

        for(int i=2; i<n; i++){
            num = s.substring(i-1, i+1);
            if(s.charAt(i) == '0'){
                if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2'){
                    dp[i] = dp[i-2];
                }else{
                    return 0;
                }
            }else if(num.compareTo("26") > 0 || num.compareTo("10") < 0){
                dp[i] = dp[i-1];
            }else if(num.compareTo("10") > 0 && num.compareTo("26") <= 0){
                dp[i] = dp[i-1]+dp[i-2];
            }
        }

        return dp[n-1];
    }
}
