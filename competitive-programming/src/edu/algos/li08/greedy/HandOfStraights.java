package edu.algos.li08.greedy;

import java.util.HashMap;
import java.util.PriorityQueue;

public class HandOfStraights {

	public static void main(String[] args) {
		HandOfStraights obj = new HandOfStraights();
		
		int[] hand = new int[] {1,2,3,6,2,3,4,7,8};
		System.out.println(obj.isNStraightHand(hand, 3));
	}

	/*
	 * Problem: Check if we can groupt numbers in groups of given size such that numbers in each group are continuously increasing like [1,2,3]
	 * Concept: Everytime get a min number and its corresponding pairs like min+1, min+2.. until group size and see if those numbers existing in the list.
	 * there can be duplicate numbers. Hence maintain a counter for each number and reduce the count as and when the number if considered in a group
	 * to get the min always using priority queue. Remove the number if it is already considered in a groupt and its count become 0 in map.
	 * if expected number is not found the in map and return false
	 * duplicate number will stay on top of the queue until its counter become 0.
	 * if you don't find expect min number of top of the pq, return false.
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
				if (count > 0) {
					counts.put(i, count - 1);
					count = counts.get(i);

					if (count == 0) {
						if (!pq.isEmpty() && pq.peek() == i) {
							pq.remove(i);
						} else {
							return false;
						}
					}
				} else {
					return false;
				}
			}
		}
		return true;
	}
}
