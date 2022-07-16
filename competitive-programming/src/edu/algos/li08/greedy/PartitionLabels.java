package edu.algos.li08.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {

	public static void main(String[] args) {
		PartitionLabels obj = new PartitionLabels();
		
		String s = "ababcbacadefegdehijhklij";
		System.out.println(obj.partitionLabels(s));
	}
	
	/*
	 * Problem: find the lengths of each partition where every char in a partition is unique to that partition only. partitions should not have common chars.
	 * Concept: Go greed, have the last indices of each char
	 * while traversing the string char by char, update the lastInd what we have seen for each char if it greater then the current lastInd
	 * if our current chat pointer reaches out lastInd pointer, if means we have traveled all the chars in that partition and lastInd is the max last index of any char in that partion.
	 * once we reach partition end add the current partition size in result, and reset the size to 0 for next partition.
	 * 
	 * */
	public List<Integer> partitionLabels(String s) {
        int n=s.length();
        HashMap<Character, Integer> lastInd = new HashMap<>();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            lastInd.put(ch, i);
        }
        
        int size = 0, last = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            last = Math.max(last, lastInd.get(ch));
            size++;
            if(i == last){
                list.add(size);
                size = 0;
            }
        }
        
        return list;
    }

}
