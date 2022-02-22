package algos;

public class OverlappingRectangles {

	public static void main(String[] args) {
		Point l1 = new Point(0, 10);
		Point r1 = new Point(10, 0);
		Point l2 = new Point(5, 5);
		Point r2 = new Point(15, 0);

		System.out.println(isOverlapping(l1, r1, l2, r2));
	}
	private static boolean isOverlapping(Point l1, Point r1, Point l2, Point r2){
		if(r1.x > l2.x || r2.x > l1.x)
			return false;
		if(r1.y > l2.y || r2.y > l1.y)
			return false;
		return true;
	}

}
class Point {
	public static int x;
	public static int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
