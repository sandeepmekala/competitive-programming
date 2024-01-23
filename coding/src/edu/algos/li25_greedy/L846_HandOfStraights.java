package edu.algos.li25_greedy;

import java.util.HashMap;
import java.util.PriorityQueue;

public class L846_HandOfStraights {

	public static void main(String[] args) {
		L846_HandOfStraights obj = new L846_HandOfStraights();
		
		int[] hand = new int[] {1,2,3,6,2,3,4,7,8};
		System.out.println(obj.isNStraightHand(hand, 3));
	}

	/*
	 * Problem: https://leetcode.com/problems/hand-of-straights/
	 * Idea: Everytime get a min number and its corresponding pairs like min+1, min+2.. until group size and see if those numbers existing in the list.
	 * There can be duplicate numbers. Hence maintain a counter for each number and reduce the count as and when the number if considered in a group
	 * To get the min always using priority queue. Remove the number if it is already considered in a group and its count become 0 in map.
	 * If expected number is not found the in map and return false
	 * Duplicate number will stay on top of the queue until its counter become 0.
	 * If you don't find expect min number of top of the pq, return false.
	 * */
	public boolean isNStraightHand(int[] hand, int groupSize) {
		if (hand.length % groupSize != 0) {
			return false;
		}

		HashMap<Integer, Integer> counts = new HashMap<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int num : hand) {
			if (!counts.containsKey(num)) {
				pq.add(num);
			}
			counts.put(num, counts.getOrDefault(num, 0) + 1);
		}

		while (!pq.isEmpty()) {
			int min = pq.peek();
			for (int i = min; i < min + groupSize; i++) {
				int count = counts.getOrDefault(i, -1);
				if (count <= 0) 
					return false;

				counts.put(i, count - 1);
				count = counts.get(i);
				if (count == 0) {
					if (!pq.isEmpty() && pq.peek() == i) {
						pq.remove(i);
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}
}
