package com.algos.core.li21_greedy.revised;

public class L860_LemonadeChange {
    public static void main(String[] args) {
        L860_LemonadeChange obj = new L860_LemonadeChange();
        int[] bills = new int[]{5, 5, 5, 10, 20};
        System.out.println(obj.lemonadeChange(bills));
    }

    // Problem: https://leetcode.com/problems/lemonade-change/
    // Idea: Greedy: Give change to the customer with maximum available denominations.
    // Time: O(n)
    public boolean lemonadeChange(int[] bills) {
        int fives = 0, tens = 0;
        for(int bill: bills){
            if(bill == 5){
                fives++;
            }else if(bill == 10){
                if(fives > 0){
                    fives--;
                    tens++;
                }else return false;
            }else{
                if(tens > 0 && fives > 0){  // we be greedy to return max denominations first to keep more fives with us
                    tens--;
                    fives--;
                }else if(fives > 2){
                    fives -= 3;    
                }else return false;
            }
        }

        return true;
    }
}
