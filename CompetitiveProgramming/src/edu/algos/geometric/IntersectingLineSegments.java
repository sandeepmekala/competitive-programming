package edu.algos.geometric;

import edu.algos.geometric.model.Point;

class IntersectingLineSegments {

	public static void main(String[] args) {
		IntersectingLineSegments obj = new IntersectingLineSegments();
		
		Point p1 = new Point(1, 1);
		Point q1 = new Point(10, 1);
		Point p2 = new Point(1, 2);
		Point q2 = new Point(10, 2);
		System.out.println(obj.doIntersect(p1, q1, p2, q2));

		p1 = new Point(10, 1);
		q1 = new Point(0, 10);
		p2 = new Point(0, 0);
		q2 = new Point(10, 10);
		System.out.println(obj.doIntersect(p1, q1, p2, q2));

		p1 = new Point(-5, -5);
		q1 = new Point(0, 0);
		p2 = new Point(1, 1);
		q2 = new Point(10, 10);
		System.out.println(obj.doIntersect(p1, q1, p2, q2));
	}
	
	boolean doIntersect(Point p1, Point q1, Point p2, Point q2) {
		GeometricUtil util = new GeometricUtil();
		
		// Find the four orientations needed for general and
		// special cases
		int o1 = util.orientation(p1, q1, p2);
		int o2 = util.orientation(p1, q1, q2);
		int o3 = util.orientation(p2, q2, p1);
		int o4 = util.orientation(p2, q2, q1);

		// General case
		if (o1 != o2 && o3 != o4)
			return true;

		// Special Cases
		// p1, q1 and p2 are collinear and p2 lies on segment p1q1
		if (util.onSegment(p1, p2, q1))
			return true;

		// p1, q1 and q2 are collinear and q2 lies on segment p1q1
		if (util.onSegment(p1, q2, q1))
			return true;

		// p2, q2 and p1 are collinear and p1 lies on segment p2q2
		if (util.onSegment(p2, p1, q2))
			return true;

		// p2, q2 and q1 are collinear and q1 lies on segment p2q2
		if (util.onSegment(p2, q1, q2))
			return true;

		return false; // Doesn't fall in any of the above cases
	}

}