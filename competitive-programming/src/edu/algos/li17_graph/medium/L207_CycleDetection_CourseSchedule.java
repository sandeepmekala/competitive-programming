package edu.algos.li17_graph.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class L207_CycleDetection_CourseSchedule {

	public static void main(String[] args) {
		L207_CycleDetection_CourseSchedule obj = new L207_CycleDetection_CourseSchedule();

		int numCourses = 3;
		// int[][] prerequisites = new int[][] {{1,0}}; //true
		// int[][] prerequisites = new int[][] { { 1, 0 }, { 0, 1 } };
		int[][] prerequisites = new int[][] { { 1, 0 }, { 2, 0 } };
		System.out.println(obj.canFinish(numCourses, prerequisites));
	}

	// Problem: https://leetcode.com/problems/course-schedule/
	// Idea: It forms directed graph with edge crs->prer. 
	// Detect cyclic dependecy to check if there is a deadlock to finish the cources.
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		HashMap<Integer, List<Integer>> adjList = new HashMap<>();
		for (int i = 0; i < numCourses; i++) {
			if (!adjList.containsKey(i)) {
				adjList.put(i, new ArrayList<Integer>());
			}
		}
		for (int[] prer : prerequisites) {
			adjList.get(prer[0]).add(prer[1]);
		}
		
		HashSet<Integer> exploring = new HashSet<>();
		HashSet<Integer> visited = new HashSet<>();
		for (int i = 0; i < numCourses; i++) {
			if (!dfs(adjList, i, exploring, visited)) {
				return false;
			}
		}

		return true;
	}

	private boolean dfs(HashMap<Integer, List<Integer>> adjList, int crs, HashSet<Integer> exploring,
			HashSet<Integer> visited) {
		if (exploring.contains(crs)) {
			return false;
		}

		if (!visited.contains(crs)) {
			visited.add(crs);
			exploring.add(crs);
			for (int prer : adjList.get(crs)) {
				if (!dfs(adjList, prer, exploring, visited)) {
					return false;
				}
			}
			exploring.remove(crs);
		}
		return true;
	}

}
