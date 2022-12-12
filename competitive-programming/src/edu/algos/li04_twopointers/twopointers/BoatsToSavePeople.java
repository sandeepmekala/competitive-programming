package edu.algos.li04_twopointers.twopointers;

import java.util.Arrays;

public class BoatsToSavePeople {

	public static void main(String[] args) {
		BoatsToSavePeople obj = new BoatsToSavePeople();
		
		int[] people = new int[] {3,2,2,1};
		System.out.println(obj.numRescueBoats(people, 3));
	}

	/*
	 * Problem: https://leetcode.com/problems/boats-to-save-people/
	 * Companies: Amazon
	 * */
	public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int i=0, j=people.length-1, count = 0;
        while(i<=j){
            if(i==j || people[i]+people[j] <= limit){
                count ++;
                i++;
                j--;
            }else{
                count ++;
                j--;
            }
        }
        
        return count;
    }
}
