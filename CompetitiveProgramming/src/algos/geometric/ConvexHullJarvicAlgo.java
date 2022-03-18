package algos.geometric;

// Java program to find convex hull of a set of Point1s. Refer
// https://www.geeksforgeeks.org/orientation-3-ordered-Point1s/
// for explanation of orientation()
import java.util.*;

class Point1 {
	int x, y;

	Point1(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class ConvexHullJarvicAlgo {

	// To find orientation of ordered triplet (p, q, r).
	// The function returns following values
	// 0 --> p, q and r are collinear
	// 1 --> Clockwise
	// -1 --> Counterclockwise
	public static int orientation(Point1 p, Point1 q, Point1 r) {
		int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

		if (val == 0)
			return 0; // collinear
		return (val > 0) ? 1 : -1; // clock or counterclock wise
	}

	// Prints convex hull of a set of n Point1s.
	public static void convexHull(Point1 Point1[], int n) {
		// There must be at least 3 Point1s
		if (n < 3)
			return;

		Vector<Point1> hull = new Vector<Point1>();

		// Find the leftmost Point1
		int start = 0;
		for (int i = 1; i < n; i++)
			if (Point1[i].x < Point1[start].x)
				start = i;

		// Start from leftmost Point1, keep moving
		// counterclockwise until reach the start Point1
		// again. This loop runs O(h) times where h is
		// number of Point1s in result or output.
		int current = start, next;
		do {
			// Add current Point to result
			hull.add(Point1[current]);

			// Search for a Point 'q' such that
			// orientation(p, q, x) is counterclockwise
			// for all Point1s 'x'. The idea is to keep
			// track of last visited most counterclock-
			// wise Point in q. If any Point 'i' is more
			// counterclock-wise than q, then update q.
			next = (current + 1) % n;

			for (int i = 0; i < n; i++) {
				// If i is more counterclockwise than
				// current q, then update q
				if (orientation(Point1[current], Point1[i], Point1[next]) == -1)
					next = i;
			}

			// Now q is the most counterclockwise with
			// respect to p. Set p as q for next iteration,
			// so that q is added to result 'hull'
			current = next;

		} while (current != start); // While we don't come to first
		// Point1

		// Print Result
		for (Point1 temp : hull)
			System.out.println("(" + temp.x + ", " + temp.y + ")");
	}

	/* Driver program to test above function */
	public static void main(String[] args) {

		Point1 Point1s[] = new Point1[7];
		Point1s[0] = new Point1(0, 3);
		Point1s[1] = new Point1(2, 3);
		Point1s[2] = new Point1(1, 1);
		Point1s[3] = new Point1(2, 1);
		Point1s[4] = new Point1(3, 0);
		Point1s[5] = new Point1(0, 0);
		Point1s[6] = new Point1(3, 3);

		int n = Point1s.length;
		convexHull(Point1s, n);

	}
}

// This code is contributed by Arnav Kr. Mandal.
