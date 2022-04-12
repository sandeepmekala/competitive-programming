package edu.algos.dp;
import java.util.Hashtable;

public class Algo033_SubsetsWithGivenSumTotalWays {

	public static void main(String[] args) {
		int numbers[] = {2,4,6,10};
		Hashtable<String, Integer> mem = new Hashtable<String, Integer>();
		int sum  = 16;
		System.out.println(numberOfSubsetsWithSumTopDown(numbers, sum, numbers.length-1, mem));
		
		System.out.println(numberOfSubsetsWithSumRec(numbers, sum, numbers.length-1));
	}
	
	// n and sum are defining the state
	// O(n*sum)
	private static int numberOfSubsetsWithSumTopDown(int numbers[], int sum, int index, Hashtable<String, Integer> mem){
		
		String key = sum+":"+index;
		if(mem.containsKey(key)){
			return mem.get(key);
		}
		
		int return_count;
		if(sum == 0){
			return 1;
		}else if(numbers.length == 0 || sum < 0 || index < 0){
			return 0;
		}else{
			return_count = numberOfSubsetsWithSumTopDown(numbers, sum - numbers[index], index-1, mem)+numberOfSubsetsWithSumTopDown(numbers, sum, index-1, mem);
		}
		
		mem.put(key, return_count);
		return return_count;
	}
	
	private static int numberOfSubsetsWithSumRec(int numbers[], int sum, int index){
		
		if(sum == 0){
			return 1;
		}else if(numbers.length == 0 || sum < 0 || index < 0){
			return 0;
		}else{
			return numberOfSubsetsWithSumRec(numbers, sum - numbers[index], index-1)+numberOfSubsetsWithSumRec(numbers, sum, index-1);
		}
	}
}
