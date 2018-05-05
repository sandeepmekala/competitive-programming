import java.util.Arrays;

public class NumberOfNegativeIn2DsortedArray {

	public static void main(String[] args) {

		int numbers[][] = {{-3,-2,-1,1},{-2,2,3,4},{4,5,7,8}};
		System.out.println(optimalWay(numbers));

	}
	private static int bruteForceWay(int numbers[][]){
		int count = 0;
		for(int i=0; i<numbers.length; i++){
			for(int j=0; j < numbers[i].length ;j++ ){
				if(numbers[i][j] < 0)
					count++;
			}
		}
		return count;
	}
	
	private static int betterThenBruteForceWay(int numbers[][]){
		int count = 0;
		for(int i=0; i<numbers.length; i++){
			for(int j=0; j < numbers[i].length ;j++ ){
				if(numbers[i][j] > 0)
					break;
				count++;
			}
		}
		return count;
	}
	private static int optimalWay(int numbers[][]){//O(n+m)
		
		int count = 0;
		int i = 0;
		int j = numbers[0].length-1;		
		while(j >= 0 && i < numbers.length ){
			if(numbers[i][j] > 0){
				j--;
			}else{
				count += (j+1);
				i++;
			}
		}
		return count;
	}
	
	private static int niceWay(int numbers[][]){
		int count = 0;
		for(int i=0; i<numbers.length; i++){
			String row = Arrays.toString(numbers[i]);
			if(row.contains("-")){
				String[] nums = row.split("-");
				count += nums.length-1;
			}			
		}
		return count;
	}

}