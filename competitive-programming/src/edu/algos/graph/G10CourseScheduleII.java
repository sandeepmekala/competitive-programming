package edu.algos.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class G10CourseScheduleII {

	public static void main(String[] args) {
		G10CourseScheduleII obj = new G10CourseScheduleII();
		int numCourses = 4;
		int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
		int[] result = obj.findOrder(numCourses, prerequisites);
		System.out.println(Arrays.toString(result));
	}
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjlist = new HashMap<>();
        for(int i=0; i<numCourses; i++){
            adjlist.put(i, new ArrayList<Integer>());
        }
        for(int[] prer: prerequisites){
            adjlist.get(prer[0]).add(prer[1]);
        }
        
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> exploring = new HashSet<>();
        ArrayList<Integer> cources = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            if(!dfs(adjlist, i, cources, visited, exploring)){
                return new int[]{};
            }
        }
        
        int[] result = new int[cources.size()];
        for(int i=0; i<cources.size(); i++){
            result[i] = cources.get(i);
        }
        return result;
    }
	private boolean dfs(HashMap<Integer, List<Integer>> adjlist, int current, ArrayList<Integer> cources, HashSet<Integer> visited,
			HashSet<Integer> exploring) {
        if(exploring.contains(current)){
            return false;
        }
        
		if(!visited.contains(current)){
            visited.add(current);
            exploring.add(current);
            for(int neigh: adjlist.get(current)){
                if(!dfs(adjlist, neigh, cources, visited, exploring)){
                    return false;
                }
            }
            exploring.remove(current);
            cources.add(current);
        }
        
        return true;
	}

}
