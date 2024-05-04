	package  com.algos.li19_bit.revised;

public class L191_NumberOf1Bits {

	public static void main(String[] args) {
		L191_NumberOf1Bits obj = new L191_NumberOf1Bits();

		System.out.println(obj.hammingWeight(3));
	}
	
    // Problem: https://leetcode.com/problems/number-of-1-bits/
    // Idea: Loop through 32 bits and check whether it is set or not.
    public int hammingWeight(int n) {
        int count = 0;
        for(int i=0; i<32; i++){
            if(((n>>i)&1) > 0){
                count++;
            }
        }
        return count;
    }

}
