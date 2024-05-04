package com.algos.li14_backtracking.revised;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L1239_MaximumLengthofaConcatenatedStringwithUniqueCharacters {
    
    public static void main(String[] args) {
        L1239_MaximumLengthofaConcatenatedStringwithUniqueCharacters obj = new L1239_MaximumLengthofaConcatenatedStringwithUniqueCharacters();
        System.out.println(obj.maxLength(List.of("un","iq","ue"))); 
    }

    public int maxLength(List<String> arr) {
        Set<Character> set = new HashSet<>();
        return maxLength(arr, 0, set);
    }

    public int maxLength(List<String> arr, int ind, Set<Character> set) {
        if(ind == arr.size())
            return set.size();
        
        int pick = 0;
        if(!overlap(set, arr.get(ind))){
            for(char c: arr.get(ind).toCharArray())
                set.add(c);
            pick = maxLength(arr, ind+1, set);
            for(char c: arr.get(ind).toCharArray())
                set.remove(c);
        }
        int notPick = maxLength(arr, ind+1, set);
        return Math.max(pick, notPick);
    }

    private boolean overlap(Set<Character> set, String str){
        Set<Character> strSet = new HashSet<>();
        for(char c: str.toCharArray()){
            if(set.contains(c) || strSet.contains(c))
                return true;
            strSet.add(c);
        }
        return false;
    }
}
