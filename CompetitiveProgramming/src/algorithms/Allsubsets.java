package algorithms;
import java.util.Arrays;
import java.util.HashSet;

public class Allsubsets {

	public static void main(String[] args) {
		int[] set = new int[]{1,2};
		allsubsets(set, new int[]{-1, -1}, 0);
	}
	private static void allsubsets(int set[], int subset[], int index){
		if(index == set.length){
			System.out.println(Arrays.toString(subset));
		}else{
			allsubsets(set, Arrays.copyOf(subset, subset.length), index+1);
			subset[index] = set[index];
			allsubsets(set, Arrays.copyOf(subset, subset.length), index+1);
		}
	}
}