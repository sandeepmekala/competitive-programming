package edu.algos.li01_math;

import edu.algos.li00_model.Point;

public class Geometry_G00_GeometricUtil {
	// Problem: https://www.geeksforgeeks.org/orientation-3-ordered-points/
	// To find orientation of ordered triplet (p, q, r).
	// slop(p1, p2) = (y2-y1)/(x2-x1);
	// The function returns following values
	// 0 --> p, q and r are collinear
	// 1 --> Clockwise
	// -1 --> Counterclockwise
	public int orientation(Point p, Point q, Point r) {
		int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y); //slope formula derivation

		if (val == 0)
			return 0; // collinear
		return (val > 0) ? 1 : -1; // clock or counterclock wise
	}

	public int orientation(int[] p, int[] q, int[] r) {
		int val = (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]); //slope formula derivation
	
		if (val == 0)
			return 0; // collinear
		return (val > 0) ? 1 : -1; // clock or counterclock wise
	}
	
	// Given three collinear points p, q, r, the function checks if
	// point q lies on line segment 'pr'
	public boolean onSegment(Point p, Point q, Point r) {
		if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) && 
				q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y) &&
						orientation(p, q, r) == 0)
			return true;

		return false;
	}
}
