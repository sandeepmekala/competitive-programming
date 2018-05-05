import java.util.ArrayList;
import java.util.Hashtable;

public class NumberOfSubsetsWithSumDynamicProgramming {

	public static void main(String[] args) {
		int numbers[] = {2,4,6,10};
		Hashtable<String, Integer> mem = new Hashtable<String, Integer>();
		int sum  = 16;
		System.out.println(numberOfSubsetsWithSum(numbers, sum, numbers.length-1, mem));
	}
	private static int numberOfSubsetsWithSum(int numbers[], int sum, int index, Hashtable<String, Integer> mem){
		
		String key = sum+":"+index;
		if(mem.containsKey(key)){
			return mem.get(key);
		}
		
		int return_count;
		if(numbers.length == 0){
			return 0;
		}else if(sum == 0){
			return 1;
		}else if(sum < 0){
			return 0;
		}else if(index < 0){
			return 0;
		}else if(numbers[index] > sum){
			return_count = numberOfSubsetsWithSum(numbers, sum, index - 1, mem);
		}else{
			return_count = numberOfSubsetsWithSum(numbers, sum - numbers[index], index - 1, mem)+numberOfSubsetsWithSum(numbers, sum, index - 1, mem);
		}
		
		mem.put(key, return_count);
		return return_count;
	}
}
