public class Test{

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		int[][] arr2d = new int[][]{{1,2},{3,4}};
		int sum = 0;
		for(int i=0; i<arr2d.length; i++) {
			for(int j=0; j<arr2d.length; j++) {
				sum += arr2d[i][j];
				System.out.print(arr2d[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
		System.out.println("sum :"+sum);
	}

}