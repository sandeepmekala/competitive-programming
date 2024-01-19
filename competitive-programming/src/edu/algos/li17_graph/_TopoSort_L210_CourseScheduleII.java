package edu.algos.li17_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _TopoSort_L210_CourseScheduleII {

	public static void main(String[] args) {
		_TopoSort_L210_CourseScheduleII obj = new _TopoSort_L210_CourseScheduleII();
		int numCourses = 4;
		int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
		int[] result = obj.findOrder(numCourses, prerequisites);
		System.out.println(Arrays.toString(result));
	}
	
    // Problem: https://leetcode.com/problems/course-schedule-ii/
    // Idea: Find any reverse of Topological order.
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i=0; i<numCourses; i++)
            adjList.put(i, new ArrayList<Integer>());
        for(int[] prer: prerequisites){
            adjList.get(prer[0]).add(prer[1]);
        }
        
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> pathVis = new HashSet<>();
        ArrayList<Integer> cources = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            if(dfs(adjList, i, cources, visited, pathVis) == false)
                return new int[]{};
        }
        
        int[] result = new int[cources.size()];
        for(int i=0; i<cources.size(); i++){
            result[i] = cources.get(i);
        }
        return result;
    }
	
    private boolean dfs(HashMap<Integer, List<Integer>> adjList, int crs, ArrayList<Integer> cources, HashSet<Integer> visited,
			HashSet<Integer> pathVis) {
        visited.add(crs);
        pathVis.add(crs);
        for (int prer : adjList.get(crs)) {
            if (!visited.contains(prer)) {
                if (dfs(adjList, prer, cources, visited, pathVis) == false) {
                    return false;
                }
            }else if(pathVis.contains(prer)){
                return false;
            }
            
        }
        pathVis.remove(crs);
        cources.add(crs);        
        return true;
	}

}
