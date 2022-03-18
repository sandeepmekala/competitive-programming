package algos.dp;

import java.util.Arrays;

public class MatrixMaxSubsquareOf1AsSides {

	public static void main(String[] args) {
		int[][] input = new int[][] {
			{0,0,0,0,1},
			{1,0,1,1,1},
			{1,0,1,0,1},
			{1,1,1,1,1},
			{0,0,1,1,1}
		};
		System.out.println(maxLenSquare(input, input.length));
	}

	private static int maxLenSquare(int[][] input, int n) {
		int max = 0;
		Point[][] mem = new Point[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				mem[i][j] = new Point();
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i == 0 && j == 0) {
					if(input[i][j] == 1) {
						mem[i][j].h = mem[i][j].v = 1;
					}
				}else if(i == 0){
					if(input[i][j] == 1) {
						mem[i][j].h = mem[i][j-1].h+1;
						mem[i][j].v = 1;
					}
				}else if(j == 0){
					if(input[i][j] == 1) {
						mem[i][j].v = mem[i-1][j].v+1;
						mem[i][j].h = 1;
					}
				}else if(input[i][j] == 1){
					mem[i][j].h = mem[i][j-1].h+1;
					mem[i][j].v = mem[i-1][j].v+1;
				}
			}
		}
		for(int i=n-1; i>=0; i--) {
			for(int j=n-1; j>=0; j--) {
				int min = min(mem[i][j]);
				if(max < min) { 
					for(int k=min-1; k>0; k--) {
						Point bl = mem[i][j-k];
						Point tr = mem[i-k][j];	
						if(bl.v >= k+1 && tr.h >= k+1) {
							max = Math.max(max, k+1);
							break;
						}
					}
				}
			}
		}	
		return max;
	}
	private static int min(Point p) {
		return p.h < p.v? p.h:p.v;
	}
}
class Point{
	public int h=0,v=0;
	
	public String toString() {
		return "("+h+","+v+")";
	}
}