package ds.matrix;

public class Basic {

	public static void main(String[] args) {
		// TODO 
		int[][] matrix = new int[3][4];
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				matrix[i][j] = (i+j);
			}
		}
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}	
			System.out.println();
		}
	}

}
