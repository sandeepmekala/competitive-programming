package edu.algos.math;

import java.util.HashSet;

public class HappyNumber {

	public static void main(String[] args) {
		HappyNumber obj = new HappyNumber();
		System.out.println(obj.isHappy(19));
	}

	public boolean isHappy(int n) {
        HashSet<Integer> visited = new HashSet<Integer>();
        while(!visited.contains(n)){
            visited.add(n);
            n = newNum(n);
            if(n == 1){
                return true;
            }
        }
        return false;
    }
    
    private int newNum(int n){
        int newNum = 0;
        while(n>0){
            int digit = n%10;
            n = n/10;
            newNum += Math.pow(digit, 2);
        }
        return newNum;
    }
}
