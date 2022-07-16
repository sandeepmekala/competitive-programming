package edu.algos.li11.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

public class SkylineDrawing {

	public static void main(String[] args) {
		SkylineDrawing skyline = new SkylineDrawing();
		int[][] buildings = { 
				{ 1, 3, 4 }, 
				{ 3, 4, 4 }, 
				{ 2, 6, 2 }, 
				{ 8, 11, 4 }, 
				{ 7, 9, 3 }, 
				{ 10, 11, 2 } 
				};
		ArrayList<int[]> resultPoints = skyline.getSkyline(buildings, buildings.length);
		resultPoints.forEach(point -> {System.out.println(Arrays.toString(point));});
	}

	private ArrayList<int[]> getSkyline(int[][] buildings, int length) {
		
		ArrayList<int[]> resultPoints = new ArrayList<int[]>(); 
		ArrayList<Point> points = new ArrayList<Point>();
		for (int i = 0; i < buildings.length; i++) {
			points.add(new Point(buildings[i][0], buildings[i][2], true));
			points.add(new Point(buildings[i][1], buildings[i][2], false));
		}
		Collections.sort(points);
		
		System.out.println(points);
		
		TreeMap<Integer, Integer> priorityQueue = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		priorityQueue.put(0, 1);
		
		
		for(Point point: points) {
			if(point.isStart) {
				int prevMaxHeight = priorityQueue.firstKey();
				priorityQueue.put(point.h, priorityQueue.getOrDefault(point.h, 0)+1);
				int newMaxHeight = priorityQueue.firstKey();
				if(newMaxHeight > prevMaxHeight){
					resultPoints.add(new int[] {point.x, newMaxHeight});
				}
			}else {
				int prevMaxHeight = priorityQueue.firstKey();
				if(priorityQueue.get(point.h) > 1) {
					priorityQueue.put(point.h, priorityQueue.get(point.h)-1);
				}else {
					priorityQueue.remove(point.h);
				}
				int newMaxHeight = priorityQueue.firstKey();
				if(newMaxHeight < prevMaxHeight){
					resultPoints.add(new int[] {point.x, newMaxHeight});
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
			if (this.isStart == o.isStart && this.isStart == true) { 		//	one with more height should come first
				return o.h - this.h;
			} else if (this.isStart == o.isStart && this.isStart == false) {// one with less height should come first
				return this.h - o.h;
			} else if (this.isStart) {										// else start should come first
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