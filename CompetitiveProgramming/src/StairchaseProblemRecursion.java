
public class StairchaseProblemRecursion {

	public static void main(String[] args) {
		System.out.println(stairchaseProblemRecursion(4));
		System.out.println(stairchaseXProblemRecursion(4, new int[]{1,3,5}));

	}
	private static int stairchaseProblemRecursion(int n){
		if(n == 0 || n == 1){
			return 1;
		}
		return stairchaseProblemRecursion(n-1)+stairchaseProblemRecursion(n-2);
	} 
	private static int stairchaseXProblemRecursion(int n, int[] x){
		if(n == 0){
			return 1;
		}
		int total = 0;
		for(int i=0; i<x.length; i++){
			if(n-x[i] >= 0){
				total += stairchaseXProblemRecursion(n-x[i], x);
			}
		}
		return total;
	} 
}
