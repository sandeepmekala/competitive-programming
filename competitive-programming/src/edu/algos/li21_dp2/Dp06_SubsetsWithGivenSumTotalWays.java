package edu.algos.li21_dp2;
import java.util.Hashtable;

public class Dp06_SubsetsWithGivenSumTotalWays {

	public static void main(String[] args) {
		Dp06_SubsetsWithGivenSumTotalWays obj = new Dp06_SubsetsWithGivenSumTotalWays();
		
		int numbers[] = {2,4,6,10};
		Hashtable<String, Integer> mem = new Hashtable<String, Integer>();
		
		int sum  = 16;
		System.out.println(obj.numberOfSubsetsWithSumTopDown(numbers, sum, numbers.length-1, mem));
		System.out.println(obj.numberOfSubsetsWithSumRec(numbers, sum, numbers.length-1));
	}
	
	// n and sum are defining the state
	// O(n*sum)
	private int numberOfSubsetsWithSumTopDown(int numbers[], int sum, int index, Hashtable<String, Integer> mem){
		
		String key = sum+":"+index;
		if(mem.containsKey(key)){
			return mem.get(key);
		}
		
		if(sum == 0){
			return 1;
		}else if(numbers.length == 0 || sum < 0 || index < 0){
			return 0;
		}else{
			int return_count = numberOfSubsetsWithSumTopDown(numbers, sum - numbers[index], index-1, mem)+
					numberOfSubsetsWithSumTopDown(numbers, sum, index-1, mem);
			mem.put(key, return_count);
		}
		
		return mem.get(key);
	}
	
	private int numberOfSubsetsWithSumRec(int numbers[], int sum, int index){
		
		if(sum == 0){
			return 1;
		}else if(numbers.length == 0 || sum < 0 || index < 0){
			return 0;
		}else{
			return numberOfSubsetsWithSumRec(numbers, sum - numbers[index], index-1)+numberOfSubsetsWithSumRec(numbers, sum, index-1);
		}
	}
}
