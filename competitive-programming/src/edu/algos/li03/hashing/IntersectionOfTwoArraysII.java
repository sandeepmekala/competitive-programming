package edu.algos.li03.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArraysII {

	public static void main(String[] args) {
		IntersectionOfTwoArraysII obj = new IntersectionOfTwoArraysII();
		
		int[] result = obj.intersect(new int[] {1,2,2,1}, new int[] {2,2});
		System.out.println(Arrays.toString(result));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/intersection-of-two-arrays-ii/
	 * Companies: Google
	 * */
	public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num: nums1)
            map.put(num, map.getOrDefault(num, 0)+1);
        
        for(int num: nums2){
            if(map.containsKey(num) && map.getOrDefault(num, 0)>0){
                map.put(num, map.get(num)-1);
                list.add(num);
            }
        }
        
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        
        return result;
    }

}
