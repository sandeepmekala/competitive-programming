package  com.algos.li13_graph.revised;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class TopoSort_L210_CourseScheduleII {

	public static void main(String[] args) {
		TopoSort_L210_CourseScheduleII obj = new TopoSort_L210_CourseScheduleII();
		int numCourses = 4;
		int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
		int[] result = obj.findOrder(numCourses, prerequisites);
		System.out.println(Arrays.toString(result));
	}
	
    // Problem: https://leetcode.com/problems/course-schedule-ii/
    // Idea: Find any reverse of Topological order.
	public int[] findOrder(int n, int[][] prerequisites) {
    	List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<>());
		
		for (int[] prer : prerequisites) 	
			adj.get(prer[1]).add(prer[0]);		// [crs, prer] = prer->crs
		
		int[] vis = new int[n];
		int[] pathVis = new int[n];
        Stack<Integer> s = new Stack<>();
		for (int i = 0; i < n; i++) {
            if(vis[i] == 0){
                if (!dfs(adj, i, pathVis, vis, s))
                    return new int[]{};
            }
		}

        int[] result = new int[n];
        int i = 0;
        while(!s.isEmpty()){
            result[i++] = s.pop();
        }
		return result;
	}

	private boolean dfs(List<List<Integer>> adj, int crs, int[] pathVis,
			int[] vis, Stack<Integer> s) {
		vis[crs] = 1;
		pathVis[crs] = 1;
		for (int prer : adj.get(crs)) {
			if (vis[prer] == 0) {
				if (!dfs(adj, prer, pathVis, vis, s)) {
					return false;
				}
			}else if(pathVis[prer] == 1){
				return false;
			}
			
		}
		pathVis[crs] = 0;
        s.push(crs);
		return true;
	}

}
