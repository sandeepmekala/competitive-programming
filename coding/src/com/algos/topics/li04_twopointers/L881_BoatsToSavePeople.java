package  com.algos.topics.li04_twopointers;

import java.util.Arrays;

public class L881_BoatsToSavePeople {

	public static void main(String[] args) {
		L881_BoatsToSavePeople obj = new L881_BoatsToSavePeople();

		int[] people = new int[] {3,2,2,1};
		System.out.println(obj.numRescueBoats(people, 3));
	}

	/*
	 * Problem: https://leetcode.com/problems/boats-to-save-people/
	 * Companies: Amazon
     * Idea: Sort the wieghts so that you can take min and max weight together
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
