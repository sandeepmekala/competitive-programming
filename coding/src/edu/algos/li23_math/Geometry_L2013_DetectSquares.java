package edu.algos.li23_math;

import java.util.ArrayList;
import java.util.List;

class Geometry_L2013_DetectSquares {
	public static void main(String args[]) {
		Geometry_L2013_DetectSquares obj = new Geometry_L2013_DetectSquares();

		obj.add(new int[] {3, 10});
		obj.add(new int[] {11, 2});
		obj.add(new int[] {3, 2});	
		System.out.println(obj.count(new int[] {11, 10}));
	}
	
	/*
	Problem: https://leetcode.com/problems/detect-squares/
	Idea: We try all points p3 which together with p1 form the diagonal of non-empty square, it means abs(p1.x-p3.x) == abs(p1.y-p3.y) && abs(p1.x-p3.x) > 0
	Since we have 2 points p1 and p3, we can form a square by computing the positions of 2 remain points p2, p4.
	p2 = (p1.x, p3.y)
	p4 = (p3.x, p1.y)
	*/ 
	int[][] cntPoints = new int[1001][1001];
    List<int[]> points = new ArrayList<>();

    public void add(int[] p) {
        cntPoints[p[0]][p[1]] += 1;
        points.add(p);
    }

    public int count(int[] p1) {
        int x1 = p1[0], y1 = p1[1];
		int count = 0;
        for (int[] p3 : points) {
            int x3 = p3[0], y3 = p3[1];
            if (Math.abs(x1-x3) == 0 || Math.abs(x1-x3) != Math.abs(y1-y3))
                continue; // Skip empty square or invalid square point!
            count += cntPoints[x1][y3] * cntPoints[x3][y1];
        }
        return count;
    }
}