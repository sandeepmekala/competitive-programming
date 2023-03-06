package edu.algos.li01_math;

import edu.algos.li00_model.Point;

public class Geometry_L836_OverlappingRectangles {

	public static void main(String[] args) {
		Geometry_L836_OverlappingRectangles obj = new Geometry_L836_OverlappingRectangles();

		int[] rec1 = new int[]{0,0,2,2};	// bottom left, top right
		int[] rec2 = new int[]{1,1,3,3};

		System.out.println(obj.isRectangleOverlap(rec1, rec2));
	}
	/*
	* Problem: https://leetcode.com/problems/rectangle-overlap/
	* Idea: It can be solved using line segment intersection concept. It this case there are 4 imaginary line segements of x and y coordinates of both the rectangles should overlap.
	* Given 2 segments (left1, right1), (left2, right2)
	* They overlap if, left1 < right2 && left2 < right1
	*			 ----------------(3, 3)
	*			 |				|	
	* 	 	-----|-------(2, 2)	|
	*	 	|	 -------|-------- r2		
	*	 	|	(1, 1)	|	
	*	 	------------- r1	
	* 		(0, 0)
	* 
	* 		0------------2
				 1--------------3
	* 
	*/

	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		return rec1[0] < rec2[2] && rec2[0] < rec1[2] && 
		rec1[1] < rec2[3] && rec2[1] < rec1[3];
	}
}
