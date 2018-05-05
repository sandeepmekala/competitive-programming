import java.util.Arrays;

public class RandomlyReorderArray {

	public static void main(String[] args) {
		int values[] = {1,0,3,9,2};
		System.out.println(Arrays.toString(randomlyReorderArray(values)));
	}
	private static int[] randomlyReorderArray(int[] values){
		
		for(int i=values.length-1; i>=0; i--){
			double rand = Math.random();
			int randInd = (int) ((i-1)*Math.floor(rand));
			 int temp = values[i];
			 values[i] = values[randInd];
			 values[randInd] = temp;
		}
		return values;
	}
}