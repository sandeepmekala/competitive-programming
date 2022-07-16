package edu.algos.li08.greedy;

import java.util.HashSet;

public class MergeTripletsToFormTargetTriplet {

	public static void main(String[] args) {
		MergeTripletsToFormTargetTriplet obj = new MergeTripletsToFormTargetTriplet();
		
		int[][] triplets = new int[][] {{2,5,3},{1,8,4},{1,7,5}};
		int[] target = new int[] {2,7,5};
		System.out.println(obj.mergeTriplets(triplets, target));
	}
	
	/*
	 * Problem: check is we can form a target triplet from given triplets with a max operation
	 * Concept: first eliminate all the triplets which has atleast one position value greater then the corresponding position value of target
	 * then check if any of the triples in remaining list have needed target values. if all the positions in target have a matching valye in atleast one of the triplet, return true. 
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
