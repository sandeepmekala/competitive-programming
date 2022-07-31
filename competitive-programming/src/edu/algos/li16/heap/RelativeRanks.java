package edu.algos.li16.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class RelativeRanks {

	public static void main(String[] args) {
		RelativeRanks obj = new RelativeRanks();

		int[] score = new int[] {1,2,3,4,5};
		String[] result = obj.findRelativeRanks(score);
		System.out.println(Arrays.toString(result));
		
	}

	public String[] findRelativeRanks(int[] score) {
		int n = score.length;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		for (int i = 0; i < n; i++) {
			pq.add(new int[] { i, score[i] });
		}

		String[] result = new String[n];
		int rank = 1;
		while (!pq.isEmpty()) {
			int[] top = pq.remove();
			if (rank == 1)
				result[top[0]] = "Gold Medal";
			else if (rank == 2)
				result[top[0]] = "Silver Medal";
			else if (rank == 3)
				result[top[0]] = "Bronze Medal";
			else
				result[top[0]] = String.valueOf(rank);

			rank++;

		}

		return result;
	}
}
