import java.util.Arrays;
import java.util.PriorityQueue;

public class L506_RelativeRanks {

	public static void main(String[] args) {
		L506_RelativeRanks obj = new L506_RelativeRanks();

		int[] score = new int[] {1,2,3,4,5};
		String[] result = obj.findRelativeRanks(score);
		System.out.println(Arrays.toString(result));
	}

	// Problem: https://leetcode.com/problems/relative-ranks/
	// Idea: Insert scores and indices to max q and pop then in decreasing order and assign ranks.
	public String[] findRelativeRanks(int[] score) {
		int n = score.length;
		PriorityQueue<int[]> pq = new PriorityQueue<>((s1, s2) -> s2[1] - s1[1]);
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
