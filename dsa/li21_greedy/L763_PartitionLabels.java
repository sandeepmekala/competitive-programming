package li21_greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L763_PartitionLabels {

	public static void main(String[] args) {
		L763_PartitionLabels obj = new L763_PartitionLabels();

		String s = "ababcbacadefegdehijhklij";
		System.out.println(obj.partitionLabels(s));
	}

	// Problem: https://leetcode.com/problems/partition-labels/
	// Idea: Go greedy, have the last indices of each char.
	// Pass1: While traversing the string char by char, update the lastInd what we have seen for each char if it greater then the current lastInd
	// Pass2: If our current char pointer reaches our lastInd pointer, if means we have traveled all the chars in that partition and lastInd is the max last index of any char in that partion.
	// Once we reach partition end add the current partition size in result, and reset the size to 0 for next partition.
	public List<Integer> partitionLabels(String s) {
        int n=s.length();
        Map<Character, Integer> lastInd = new HashMap<>();
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
