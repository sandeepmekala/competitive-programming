package  com.algos.li20_math.revised;

public class L258_AddDigits {

	public static void main(String[] args) {
		L258_AddDigits obj = new L258_AddDigits();
		
		System.out.println(obj.addDigits(123));
	}

	/*
	 * Problem: https://leetcode.com/problems/add-digits/
	 * Companies: Microsoft
	 * Idea: If a num is divisible by 9, then sum of its digits also will be devisible by 9.
	 * Final single digit number will be 1-9 after executing this algo.
	 * Hence, instead of summing digits, we can check num divisibility by 9.
	 * If it is divisible by 9, then single digit will be 9, else it will be remainder after deviding it by 9.
	 * 
	 * */
	public int addDigits(int num) {
        if(num == 0) return 0;
        
        if(num%9 == 0){
            return 9;
        }else{
            return num%9;
        } 
    }
	
	public int addDigits2(int num) {
        while(true){
            if(num < 10) return num;
            int sum = 0;
            while(num > 0){
                int reminder = num%10;
                sum += reminder;
                num = num/10;
            }
            num = sum;
        }
    }
}
