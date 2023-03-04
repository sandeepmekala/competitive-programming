package edu.algos.li17_graph.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _DetectCycle_L207_CourseSchedule {

	public static void main(String[] args) {
		_DetectCycle_L207_CourseSchedule obj = new _DetectCycle_L207_CourseSchedule();

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
			adjList.put(i, new ArrayList<Integer>());
		}
		for (int[] prer : prerequisites) {
			adjList.get(prer[0]).add(prer[1]);
		}
		
		HashSet<Integer> visited = new HashSet<>();
		HashSet<Integer> pathVis = new HashSet<>();
		for (int i = 0; i < numCourses; i++) {
			if (dfs(adjList, i, pathVis, visited) == false)
				return false;
		}
		return true;
	}

	private boolean dfs(HashMap<Integer, List<Integer>> adjList, int crs, HashSet<Integer> pathVis,
			HashSet<Integer> visited) {
		visited.add(crs);
		pathVis.add(crs);
		for (int prer : adjList.get(crs)) {
			if (!visited.contains(prer)) {
				if (dfs(adjList, prer, pathVis, visited) == false) {
					return false;
				}
			}else if(pathVis.contains(prer)){
				return false;
			}
			
		}
		pathVis.remove(crs);
		return true;
	}

}
