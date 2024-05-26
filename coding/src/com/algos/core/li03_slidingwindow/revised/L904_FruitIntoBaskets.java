package com.algos.core.li03_slidingwindow.revised;

import java.util.HashMap;
import java.util.Map;

public class L904_FruitIntoBaskets {
    
    public static void main(String[] args) {
        L904_FruitIntoBaskets obj = new L904_FruitIntoBaskets();

        int[] fruits = {1,2,3,2,2};
        System.out.println(obj.totalFruit(fruits));
    }

    // Problem: https://leetcode.com/problems/fruit-into-baskets/
    // Idea: Problem can be reframed as find the longest subarray with at most 2 distinct elements
    // Time: O(n)
    public int totalFruit(int[] fruits) {
        int l=0, r=0, maxLen=0, n=fruits.length, k=2;
        Map<Integer, Integer> map = new HashMap<>();
        while(r<n){
            map.put(fruits[r], map.getOrDefault(fruits[r], 0)+1);
            if(map.size() > k){
                map.put(fruits[l], map.get(fruits[l])-1);
                if(map.get(fruits[l]) == 0)
                    map.remove(fruits[l]);
                l++;
            }

            if(map.size() <= k)
                maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}
