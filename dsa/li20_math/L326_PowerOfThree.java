package li20_math;

public class L326_PowerOfThree {

	public static void main(String[] args) {
		L326_PowerOfThree obj = new L326_PowerOfThree();

		System.out.println(obj.isPowerOfThree(45));
	}

	/*
	 * Problem: https://leetcode.com/problems/power-of-three/
	 * Idea: Divid the n in while loop until it becomes 1, if it doesn't become 1 return false.
	 * */
	public boolean isPowerOfThree(int n) {
        while(n > 0  && n%3 == 0){
            n = n/3;
        }

        return n == 1;
    }

}
