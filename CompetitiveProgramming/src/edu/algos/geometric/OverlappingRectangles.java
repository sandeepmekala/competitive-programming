package edu.algos.geometric;

public class OverlappingRectangles {

	public static void main(String[] args) {
		Point1 l1 = new Point1(0, 10);	// top-left 
		Point1 r1 = new Point1(10, 0);	// bottom right
		Point1 l2 = new Point1(5, 5);
		Point1 r2 = new Point1(15, 0);

		System.out.println(isOverlapping(l1, r1, l2, r2));
	}
	
	// To check if a point is in rectangle. we need to compare it with all other point of other rectangle.
	// Instead we can check the cases where they don't overlap and return false.
	// For rest of the cases it returns true.
	private static boolean isOverlapping(Point1 l1, Point1 r1, Point1 l2, Point1 r2){
		if(l2.x > r1.x || l1.x > r2.x)
			return false;
		if(r1.y > l2.y || r2.y > l1.y)
			return false;
		return true;
	}

}
class Point {
	public int x;
	public int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
