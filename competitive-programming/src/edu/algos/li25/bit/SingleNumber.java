package edu.algos.li25.bit;

public class SingleNumber {

	public static void main(String[] args) {
		SingleNumber obj = new SingleNumber();
		System.out.println(obj.singleNumber(new int[] {2,2,1}));
	}
	
	public int singleNumber(int[] nums) {
        int xor = 0; 
		for(int num: nums){
            xor ^= num;
        }
		return xor;
    }

}
