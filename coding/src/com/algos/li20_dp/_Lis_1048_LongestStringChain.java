package  com.algos.li20_dp;

import java.util.Arrays;

public class _Lis_1048_LongestStringChain {
    public static void main(String[] args) {
        _Lis_1048_LongestStringChain obj = new _Lis_1048_LongestStringChain();

        String[] words = new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"};
        System.out.println(obj.longestStrChain(words));
    }

    // Problem: https://leetcode.com/problems/longest-string-chain/
    // Idea: Similar like lis, and lds. Instead of checking for increasbility/divisibility check chain validity.
    public int longestStrChain(String[] words) {
        int n = words.length;
        if(n <= 1) return n;
        
        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());
        int[] lsc = new int[n];
        for(int i=0; i<n; i++)
            lsc[i] = 1;
        int max = 0;
        for(int i=1; i<n; i++){
            for(int j=0;j<i; j++){
                if(checkPossible(words[i], words[j])){
                    if(lsc[j]+1 > lsc[i]){
                        lsc[i] = 1+lsc[j];
                    }
                }
            }
            if(lsc[i] > max){
                max = lsc[i];
            }
        }

        return max;
    }

    private boolean checkPossible(String w1, String w2) {
        if(w1.length() != w2.length()+1) return false;

        int i=0, j=0;
        while(i<w1.length()){
            if(j<w2.length() && w1.charAt(i) == w2.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        return i==w1.length() && j==w2.length();
    }
}
