package  com.algos.li21_greedy;

import java.util.HashSet;

public class L1899_MergeTripletsToFormTargetTriplet {

	public static void main(String[] args) {
		L1899_MergeTripletsToFormTargetTriplet obj = new L1899_MergeTripletsToFormTargetTriplet();
		
		int[][] triplets = new int[][] {{2,5,3},{1,8,4},{1,7,5}};
		int[] target = new int[] {2,7,5};
		System.out.println(obj.mergeTriplets(triplets, target));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/merge-triplets-to-form-target-triplet/
	 * Idea: First eliminate all the triplets which has atleast one position value greater then the corresponding position value of target.
	 * Then check if any of the triples in remaining list have needed target values. If all the positions in target have a matching value in atleast one of the triplet, return true. 
	 * 
	 * */
	public boolean mergeTriplets(int[][] triplets, int[] target) {
        HashSet<Integer> set = new HashSet<>();
        for(int[] triplet: triplets){
            if(triplet[0]<=target[0] && triplet[1]<=target[1] && triplet[2]<=target[2]){
                for(int i=0; i<3; i++){
                    if(triplet[i]==target[i]){
                        set.add(i);
                    }
                }
            }
        }
        return set.size() == 3;
    }

}
