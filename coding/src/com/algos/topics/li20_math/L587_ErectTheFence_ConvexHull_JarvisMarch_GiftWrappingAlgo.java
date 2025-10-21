package  com.algos.topics.li20_math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class L587_ErectTheFence_ConvexHull_JarvisMarch_GiftWrappingAlgo {

	public static void main(String[] args) {
		L587_ErectTheFence_ConvexHull_JarvisMarch_GiftWrappingAlgo obj = new L587_ErectTheFence_ConvexHull_JarvisMarch_GiftWrappingAlgo();

		int[][] points = new int[][]{
			//{0, 3},{2, 3},{1, 1},{2, 1},{3, 0},{0, 0}
			//{1,1},{2,2},{2,0},{2,4},{3,3},{4,2}
			{0,5},{10,0},{10,10},{0,10},{0,0}
		};

		int[][] result = obj.outerTrees(points);
		for(int[] point: result){
			System.out.println(Arrays.toString(point));
		}
	}

	// Problem: https://leetcode.com/problems/erect-the-fence/
	// Idea: Use Jarvis March or Gift Wrapping algorithm.
	// Start with left most point and go in counter clock wise direction.
	// Find the right most q and use it as next
	public int[][] outerTrees(int[][] trees) {
		Set<int[]> fence = new HashSet<int[]>();
		int start = 0, n = trees.length;
		for (int i = 1; i < n; i++)		// Find the leftmost point
			if (trees[i][0] < trees[start][0])
				start = i;

		// Start from leftmost Point, keep moving counter clock wise until reach the start Point again.
		// This loop runs O(h) times where h is number of Points in result or output.
		int curr = start;
		do {
			fence.add(trees[curr]);

			// Search for a point 'q' such that orientation(p, q, x) is counter clock wise for all points 'x'.
			int next = (curr+1)%n;
			for (int i = 0; i < n; i++) {
				if(i == curr || i == next ) continue;

				// If i is more counter clock wise than current q, then update q
				if (orientation(trees[curr], trees[i], trees[next]) == -1)
					next = i;
			}

			// Handle collinear points
            for (int i = 0; i < n; i++) {
                if(i == curr || i == next ) continue;

				if (orientation(trees[curr], trees[i], trees[next]) == 0)
					fence.add(trees[i]);
			}
			curr = next;
		} while (curr != start && fence.size() != n);

		int[][] result = new int[fence.size()][2];
		int i=0;
		for (int[] point : fence)
			result[i++] = point;

		return result;
	}

    public int orientation(int[] p, int[] q, int[] r) {
		int val = (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]); //slope formula derivation

		if (val == 0)
			return 0; // collinear
		return (val > 0) ? 1 : -1; // clock or counterclock wise
	}
}
