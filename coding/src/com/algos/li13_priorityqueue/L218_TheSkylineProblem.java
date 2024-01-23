package  com.algos.li13_priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class L218_TheSkylineProblem {

	public static void main(String[] args) {
		L218_TheSkylineProblem skyline = new L218_TheSkylineProblem();
		int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		
		List<List<Integer>> resultPoints = skyline.getSkyline(buildings);
		resultPoints.forEach(point -> System.out.println(point));
	}

	// Problem: https://leetcode.com/problems/the-skyline-problem/
	// Idea: We are interested in point of x and h. Every building has 2 of those points at left hight and right hight. We are interested only in the top points as skyling tuches only those.
	// Start moving left to right, if you encounter a start point, push it to max q. If this changes max of q which mean that point should be in the result.
	// Similarly, if you encounter a end point, remmove it from the pq. If that changes max of q that point also need to be in the result.
	// Points should be sorted on the x
	// To handle some special cases in case x is same, we have to sort the points in hright.
	// We have to remove non max elements also from pq as and when we encounter them while moving left to right. Hence, we need to use treemap instead of pq as we need priority order also with constant removal of non max element.
	public List<List<Integer>> getSkyline(int[][] buildings) {
		ArrayList<Point> points = new ArrayList<Point>();
		for (int i = 0; i < buildings.length; i++) {
			points.add(new Point(buildings[i][0], buildings[i][2], true));
			points.add(new Point(buildings[i][1], buildings[i][2], false));
		}
		Collections.sort(points);
		
		TreeMap<Integer, Integer> priorityQueue = new TreeMap<Integer, Integer>((h1, h2) -> h2-h1);	
		priorityQueue.put(0, 1);		// As we need skyline to be touching ground at the end and it acts as prev hight.
		
		List<List<Integer>> resultPoints = new ArrayList<>(); 
		for(Point point: points) {
			if(point.isStart) {
				int prevMaxHeight = priorityQueue.firstKey();
				priorityQueue.put(point.h, priorityQueue.getOrDefault(point.h, 0)+1);	// adding that perticular building height
				int newMaxHeight = priorityQueue.firstKey();
				if(newMaxHeight > prevMaxHeight){
					resultPoints.add(new ArrayList<Integer>(Arrays.asList(point.x, point.h)) );	// we add the that point as it is.
				}
			}else {
				int prevMaxHeight = priorityQueue.firstKey();
				if(priorityQueue.get(point.h) > 1) {
					priorityQueue.put(point.h, priorityQueue.get(point.h)-1);		// removing that perticular building height
				}else {
					priorityQueue.remove(point.h);
				}
				int newMaxHeight = priorityQueue.firstKey();
				if(newMaxHeight < prevMaxHeight){
					resultPoints.add(new ArrayList<Integer>(Arrays.asList(point.x, newMaxHeight))); // we add point with new hight. Not that building height as we need next lower point.
				}
			}
		}
		
		return resultPoints;
	}

}

class Point implements Comparable<Point> {
	int x;
	int h;
	boolean isStart;

	public Point(int x, int y, boolean isStart) {
		this.x = x;
		this.h = y;
		this.isStart = isStart;
	}

	@Override
	public int compareTo(Point o) {

		if (this.x != o.x) {
			return this.x - o.x;
		} else {
			if (this.isStart == o.isStart && this.isStart == true) { 		//	When 2 building start overlap, one with more height should come first
				return o.h - this.h;
			} else if (this.isStart == o.isStart && this.isStart == false) {// When 2 building ends overlap, one with less height should come first
				return this.h - o.h;
			} else if (this.isStart) {										// When end of 1 buiding overlaps with start of next building. Start should come first.
				return -this.h;
			} else {
				return this.h;
			}
		}
	}

	public String toString() {
		return x + ":" + h + ":" + isStart;
	}
}