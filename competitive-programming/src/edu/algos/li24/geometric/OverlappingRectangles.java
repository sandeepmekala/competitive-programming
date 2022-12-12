package edu.algos.li24.geometric;

import edu.algos.li00_model.Point;

public class OverlappingRectangles {

	public static void main(String[] args) {
		Point l1 = new Point(0, 10);	// top-left 
		Point r1 = new Point(10, 0);	// bottom right
		Point l2 = new Point(5, 5);
		Point r2 = new Point(15, 0);

		System.out.println(isOverlapping(l1, r1, l2, r2));
	}
	
	// To check if a point is in rectangle. we need to compare it with all other point of other rectangle.
	// Instead we can check the cases where they don't overlap and return false.
	// For rest of the cases it returns true.
	private static boolean isOverlapping(Point l1, Point r1, Point l2, Point r2){
		/*	
		 * 	-------------	  (l2.x)-------------
		 * 	|			|			|			|
		 * 	|			|			|			|
		 * 	-------------(r1.x)		-------------
		 * 
		 * 	-------------	  (l1.x)-------------
		 * 	|			|			|			|
		 * 	|			|			|			|
		 * 	-------------(r2.x)		-------------
		 * 
		 * */
		if(l2.x > r1.x || l1.x > r2.x)
			return false;
		if(r2.y > l1.y || r1.y > l2.y)	// mirror of above case for y. rectangles are upside down.
			return false;
		return true;
	}

}
