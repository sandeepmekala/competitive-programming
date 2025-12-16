
import java.util.Arrays;

public class Bfs_L661_ImageSmoother {

	public static void main(String[] args) {
		Bfs_L661_ImageSmoother obj = new Bfs_L661_ImageSmoother();

		int[][] img = new int[][]{
			{100,200,100},
			{200,50,200},
			{100,200,100}
			};

		int[][] result = obj.imageSmoother(img);
		for(int[] row: result) {
			System.out.println(Arrays.toString(row));
		}

	}

	/*
	 * Problem: https://leetcode.com/problems/image-smoother/
     * Idea: Run 3 loops, 2 for matrix one inner loop over 8 directions to calculate sum and count of cells to calculate avg.
	 * TODO
     * */
	public int[][] imageSmoother(int[][] img) {
        int m=img.length, n=img[0].length;

        int[][] directions = new int[][]{{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,0}, {0,1}, {1,-1}, {1,0}, {1,1}};
        int[][] result = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int sum=0, count=0;
                for(int[] dir: directions){
                    int ni = i+dir[0], nj = j+dir[1];
                    if(ni>=0 && ni<m && nj>=0 && nj<n){
                        sum += img[ni][nj];
                        count ++;
                    }
                }

                result[i][j] = sum/count;
            }
        }

        return result;
    }

}
