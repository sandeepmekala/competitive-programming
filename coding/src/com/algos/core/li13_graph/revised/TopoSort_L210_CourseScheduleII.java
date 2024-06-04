package com.algos.core.li13_graph.revised;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopoSort_L210_CourseScheduleII {

	public static void main(String[] args) {
		TopoSort_L210_CourseScheduleII obj = new TopoSort_L210_CourseScheduleII();
		int numCourses = 4;
		int[][] prerequisites = new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		int[] result = obj.findOrder(numCourses, prerequisites);
		System.out.println(Arrays.toString(result));
	}

	// Problem: https://leetcode.com/problems/course-schedule-ii/
	// Idea: Find any Topological order.
	public int[] findOrder(int n, int[][] prerequisites) {
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<>());

		for (int[] prer : prerequisites)
			adj.get(prer[1]).add(prer[0]); // (crs, prer) = prer->crs

		int[] vis = new int[n];
		int[] pathVis = new int[n];
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (vis[i] != 1) {
				if (!dfs(adj, i, pathVis, vis, s))
					return new int[] {};
			}
		}

		int[] result = new int[n];
		int i = 0;
		while (!s.isEmpty()) {
			result[i++] = s.pop();
		}
		return result;
	}

	private boolean dfs(List<List<Integer>> adj, int prer, int[] pathVis,
			int[] vis, Stack<Integer> st) {
		vis[prer] = 1;
		pathVis[prer] = 1;
		for (int crs : adj.get(prer)) {
			if (vis[crs] != 1) {
				if (!dfs(adj, crs, pathVis, vis, st)) {
					return false;
				}
			} else if (pathVis[crs] == 1) {
				return false;
			}

		}
		pathVis[prer] = 0;
		st.push(prer);
		return true;
	}

}
