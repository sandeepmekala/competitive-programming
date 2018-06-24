
public class StairchaseProblemDynamicProgramming {

	public static void main(String[] args) {
		System.out.println(stairchaseProblemDynamicProgramming(2));
		System.out.println(stairchaseXProblemDynamicProgramming(4, new int[]{1,3,5}));
	}
	private static int stairchaseProblemDynamicProgramming(int n){
		int numberOfWays[] = new int[n+1];
		numberOfWays[0] = 1;	//we need only last two numbers in array. So, we can save some space by using two varibles instead of array
		numberOfWays[1] = 1;
		
		for(int i=2; i<n+1;i++){
			numberOfWays[i] = numberOfWays[i-1] + numberOfWays[i-2];
		}
		return numberOfWays[n];
	}
	private static int stairchaseXProblemDynamicProgramming(int n, int x[]){
		int numberOfWays[] = new int[n+1];
		numberOfWays[0] = 1;	//we need only last two numbers in array. So, we can save some space by using two varibles instead of array
		
		for(int i=1; i<n+1;i++){
			int total = 0;
			for(int j=0; j<x.length;j++){
				if(i-x[j]>=0){
					total += numberOfWays[i-x[j]];
				}
			}
			numberOfWays[i] = total;
		}
		return numberOfWays[n];
	}
}
