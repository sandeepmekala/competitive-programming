package edu.algos.geometric;

import java.util.ArrayList;
import java.util.List;

import edu.algos.model.Point;

class ConvexHullJarvicAlgo {

	public static void main(String[] args) {
		ConvexHullJarvicAlgo obj = new ConvexHullJarvicAlgo();

		Point Point1s[] = new Point[7];
		Point1s[0] = new Point(0, 3);
		Point1s[1] = new Point(2, 3);
		Point1s[2] = new Point(1, 1);
		Point1s[3] = new Point(2, 1);
		Point1s[4] = new Point(3, 0);
		Point1s[5] = new Point(0, 0);
		Point1s[6] = new Point(3, 3);

		int n = Point1s.length;
		obj.convexHull(Point1s, n);

	}
	
	public void convexHull(Point Point[], int n) {
		GeometricUtil util = new GeometricUtil();
		
		// There must be at least 3 Point1s
		if (n < 3)
			return;

		List<Point> hull = new ArrayList<Point>();

		// Find the leftmost Point1
		int start = 0;
		for (int i = 1; i < n; i++)
			if (Point[i].x < Point[start].x)
				start = i;

		// Start from leftmost Point, keep moving
		// counterclockwise until reach the start Point
		// again. This loop runs O(h) times where h is
		// number of Points in result or output.
		int current = start, next;
		do {
			hull.add(Point[current]);

			// Search for a Point 'q' such that
			// orientation(p, q, x) is counterclockwise
			// for all Points 'x'.
			next = (current + 1) % n;
			for (int i = 0; i < n; i++) {
				// If i is more counterclockwise than current q, then update q
				if (util.orientation(Point[current], Point[i], Point[next]) == -1)
					next = i;
			}

			current = next;

		} while (current != start); 

		for (Point temp : hull)
			System.out.println("(" + temp.x + ", " + temp.y + ")");
	}

}