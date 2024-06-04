package  com.algos.core.li20_math.revised;

import java.util.HashSet;

public class L202_HappyNumber {

	public static void main(String[] args) {
		L202_HappyNumber obj = new L202_HappyNumber();
		System.out.println(obj.isHappy(19));
	}

    // Problem: https://leetcode.com/problems/happy-number/
    // Idea: Run the while loop until n becomes 1 or you get into a cycle i.e generating old n again.
    // We can use Floyd's cycle detection algo to find the cycle.
	public boolean isHappy(int n) {
        int slow = n, fast = n;
        do{
            slow = getSumOfSquares(slow);
            fast = getSumOfSquares(getSumOfSquares(fast));
            if(fast == 1) return true;
        }while(slow != fast);
        
        return false;
    }
    
    private int getSumOfSquares(int n){
        int num = 0;
        while(n>0){
            int digit = n%10;
            num += (digit*digit);
            n = n/10;
        }
        return num;
    }
}
