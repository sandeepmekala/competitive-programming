
import java.util.Arrays;

public class L452_MinimumNumberofArrowstoBurstBalloons {

	public static void main(String[] args) {
		L452_MinimumNumberofArrowstoBurstBalloons obj = new L452_MinimumNumberofArrowstoBurstBalloons();

		//int[][] points = new int[][]{{10,16},{2,8},{1,6},{7,12}};
		int[][] points = new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
		System.out.println(obj.findMinArrowShots(points));
	}

	// Problem: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
	// Idea: This is similar to Activity Selection problem. All the overlapping balloons can be bursted with one Arrow. So the count will be count of non overlapping balloons.
	// Sort the activities/balloons based on finish time and start pickining activities/balloons if start of that activity >= end time of previous activity.
	public int findMinArrowShots(int[][] points) {
		int n = points.length;
		Arrays.sort(points, (a1, a2) ->  Integer.compare(a1[1], a2[1]));

		int cnt = 1;
        int lastEnd = points[0][1];
        for(int i = 1; i < n; i++) {
            if(points[i][0] >= lastEnd) {
                cnt++;
                lastEnd = points[i][1];
            }
        }

		return cnt;
	}
}
