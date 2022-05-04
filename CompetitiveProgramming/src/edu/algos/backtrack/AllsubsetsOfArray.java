package edu.algos.backtrack;
import java.util.ArrayList;

public class AllsubsetsOfArray {

	public static void main(String[] args) {
		int[] set = new int[]{1,2,3};
		allsubsets(set, new ArrayList<Integer>(), 0);
	}
	private static void allsubsets(int set[], ArrayList<Integer> subset, int index){
		if(index == set.length){
			System.out.println(subset);
		}else{
			allsubsets(set,new ArrayList<Integer>(subset), index+1);
			subset.add(set[index]);
			allsubsets(set,new ArrayList<Integer>(subset),  index+1);
		}
			
	}
}