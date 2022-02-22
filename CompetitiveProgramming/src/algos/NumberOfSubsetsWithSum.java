package algos;

public class NumberOfSubsetsWithSum {

	public static void main(String[] args) {
		int numbers[] = {2,4,6,10};
		int sum  = 16;
		System.out.println(numberOfSubsetsWithSum(numbers, sum, numbers.length-1));
		System.out.println(numberOfSubsetsWithSum2(numbers, sum, 0));
	}
	private static int numberOfSubsetsWithSum(int numbers[], int sum, int index){
		
		if(numbers.length == 0){
			return 0;
		}else if(sum == 0){
			return 1;
		}else if(sum < 0){
			return 0;
		}else if(index < 0){
			return 0;
		}else if(numbers[index] > sum){
			return numberOfSubsetsWithSum(numbers, sum, index - 1);
		}else{
			return numberOfSubsetsWithSum(numbers, sum - numbers[index], index - 1)+numberOfSubsetsWithSum(numbers, sum, index - 1);
		}
	}
	private static int numberOfSubsetsWithSum2(int numbers[], int sum, int index){
		if(numbers.length == 0){
			return 0;
		}else if(sum < 0){
			return 0;
		}else if(sum == 0){
			return 1;
		}else if(index >= numbers.length){
			return 0;
		}else if(numbers[index] > sum){
			return numberOfSubsetsWithSum2(numbers, sum, index+1);
		}else{
			return numberOfSubsetsWithSum2(numbers, sum - numbers[index], index+1)+numberOfSubsetsWithSum2(numbers, sum, index+1);
		}
	}
}
