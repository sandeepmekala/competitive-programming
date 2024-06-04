package com.algos.core.li21_greedy.revised;

public class L135_Candy {
    
    public static void main(String[] args) {
        L135_Candy obj = new L135_Candy();
        System.out.println(obj.candy(new int[]{1,0,2}));
    }

    // Problem: https://leetcode.com/problems/candy/
    // Idea: Greedy: Give candy to the child with minimum rating and then to the child with higher rating.
    // Time: O(n)
    public int candy(int[] ratings) {
        int n = ratings.length;

        int sum = 1, i = 1;
        while(i<n){
            if(ratings[i] == ratings[i-1]){
                sum++;
                i++;
                continue;
            }

            int peek = 1;
            while(i<n && ratings[i] > ratings[i-1]){
                peek++;
                sum += peek;
                i++;
            }

            int down = 1;
            while(i<n && ratings[i] < ratings[i-1]){
                sum += down;
                down++;
                i++;
            }
            if(down > peek)
                sum += (down-peek);
        }

        return sum;
    }
}
