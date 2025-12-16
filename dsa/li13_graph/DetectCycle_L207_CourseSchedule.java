package li13_graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycle_L207_CourseSchedule {

	public static void main(String[] args) {
		DetectCycle_L207_CourseSchedule obj = new DetectCycle_L207_CourseSchedule();

		int numCourses = 3;
		// int[][] prerequisites = new int[][] {{1,0}}; //true
		// int[][] prerequisites = new int[][] { { 1, 0 }, { 0, 1 } };
		int[][] prerequisites = new int[][] { { 1, 0 }, { 2, 0 } };
		System.out.println(obj.canFinish(numCourses, prerequisites));
	}

	// Problem: https://leetcode.com/problems/course-schedule/
	// Idea: It forms directed graph with edges
	// Detect cyclic dependecy to check if there is a deadlock to finish the cources.
	public boolean canFinish(int n, int[][] prerequisites) {
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<>());
		for (int[] prer : prerequisites)
			adj.get(prer[1]).add(prer[0]);		// [crs, prer] = prer->crs

		int[] vis = new int[n];
		int[] pathVis = new int[n];
		for (int i = 0; i < n; i++) {
			if(vis[i] != 1){
				if (dfs(adj, i, pathVis, vis) == false)
					return false;
			}
		}

		return true;
	}

	private boolean dfs(List<List<Integer>> adj, int prer, int[] pathVis,
			int[] vis) {
		vis[prer] = 1;
		pathVis[prer] = 1;
		for (int crs : adj.get(prer)) {
			if (vis[crs] != 1) {
				if (dfs(adj, crs, pathVis, vis) == false)
					return false;
			}else if(pathVis[crs] == 1){
				return false;
			}

		}
		pathVis[prer] = 0;

		return true;
	}

}
