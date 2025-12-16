package li01_array;

public class L136_SingleNumber {

	public static void main(String[] args) {
		L136_SingleNumber obj = new L136_SingleNumber();

		System.out.println(obj.singleNumber(new int[] {2,2,1}));
	}

	// Problem: https://leetcode.com/problems/single-number/
	// Idea: xor all the nums. All the duplicate nums will get nullified leaving only unique num.
	public int singleNumber(int[] nums) {
        int xor = 0;
		for(int num: nums){
            xor ^= num;
        }
		return xor;
    }

}
