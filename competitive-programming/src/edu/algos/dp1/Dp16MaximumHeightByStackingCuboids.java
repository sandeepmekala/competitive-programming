package edu.algos.dp1;

import java.util.Arrays;
import java.util.Comparator;

public class Dp16MaximumHeightByStackingCuboids {

	public static void main(String[] args) {
		Dp16MaximumHeightByStackingCuboids obj = new Dp16MaximumHeightByStackingCuboids();

//		int[][] boxes = new int[][] {
//				{1,2,4},
//		};

		int[][] boxes = new int[][] { { 36, 46, 41 }, { 15, 100, 100 }, { 75, 91, 59 }, { 13, 82, 64 } };
		System.out.println(obj.maxHeight(boxes));
	}

	/*
	 * Concept: A concept is longest increase subsequence can be applied with i and
	 * j pointers. Update the max of i if it can be places on top of j box. A box
	 * can be rotated. So get all combinations of boxes such that l>w always. Use
	 * these combinations to find the max. time: O(3*n) = O(n) space: O(3*n) = O(n)
	 */
	public int maxHeight(int[][] cuboids) {
		int n = cuboids.length;

		// 36,46,41 -> 36,41,46 mean we prefer to keep the cube in max height way
		for (int[] cube : cuboids) {
			Arrays.sort(cube);
		}

		//sort based on the volume area so that big cuboid is placed at the bottom
		Arrays.sort(cuboids, (c1, c2) -> { return c2[0]*c2[1]*c2[2] - c1[0]*c1[1]*c1[2]; });
		  
		 
		int[] max = new int[n];
		for (int i = 0; i < n; i++) {
			max[i] = cuboids[i][2];
		}

		int maxHeight = cuboids[0][2];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (cuboids[i][0] <= cuboids[j][0] && cuboids[i][1] <= cuboids[j][1] && cuboids[i][2] <= cuboids[j][2]) {
					max[i] = Math.max(max[i], max[j] + cuboids[i][2]);
				}
			}
			if (max[i] > maxHeight) {
				maxHeight = max[i];
			}
		}

		return maxHeight;
	}

}