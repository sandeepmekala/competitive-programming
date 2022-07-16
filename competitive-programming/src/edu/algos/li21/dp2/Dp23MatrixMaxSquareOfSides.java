package edu.algos.li21.dp2;

public class Dp23MatrixMaxSquareOfSides {

	public static void main(String[] args) {
		Dp23MatrixMaxSquareOfSides obj = new Dp23MatrixMaxSquareOfSides();
		int[][] input = new int[][] {
			{0,0,0,0,1},
			{1,0,1,1,1},
			{1,0,1,0,1},
			{1,1,1,1,1},
			{0,0,1,1,1}
		};
		System.out.println(obj.maxLenSquare(input, input.length));
	}

	/*
	 * Concept: Store a point in matrix to track the horizontal and vertical distance of 1's that has been seen till now. 
	 * 
	 * 
	 * */
	private int maxLenSquare(int[][] input, int n) {
		int max = Integer.MIN_VALUE;
		Point[][] mem = new Point[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				mem[i][j] = new Point(0, 0);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (input[i][j] == 1) {
					if (i == 0 && j == 0) {
						mem[i][j].h = mem[i][j].v = 1;
					} else if (i == 0) {
						mem[i][j].h = mem[i][j - 1].h + 1;
						mem[i][j].v = 1;
					} else if (j == 0) {
						mem[i][j].h = 1;
						mem[i][j].v = mem[i - 1][j].v + 1;
					} else {
						mem[i][j].h = mem[i][j - 1].h + 1;
						mem[i][j].v = mem[i - 1][j].v + 1;
					}
				}
			}
		}
		for(int i=n-1; i>=0; i--) {
			for(int j=n-1; j>=0; j--) {
				int min = min(mem[i][j]);
				if(min > max) { 
					for(int k=min-1; k>0; k--) {
						Point bottomLeft = mem[i][j-k];
						Point topRight = mem[i-k][j];	
						if(bottomLeft.v >= k+1 && topRight.h >= k+1) {
							max = Math.max(max, k+1);
							break;
						}
					}
				}
			}
		}	
		return max;
	}
	
	private int min(Point p) {
		return p.h < p.v? p.h:p.v;
	}
}
class Point{
	public int h,v;
	
	public Point(int h, int v) {
		this.h = h;
		this.v = v;
	}

	public String toString() {
		return "("+h+","+v+")";
	}
}