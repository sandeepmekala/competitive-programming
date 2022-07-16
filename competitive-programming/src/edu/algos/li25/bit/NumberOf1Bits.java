	package edu.algos.li25.bit;

public class NumberOf1Bits {

	public static void main(String[] args) {
		NumberOf1Bits obj = new NumberOf1Bits();
		System.out.println(obj.hammingWeight(3));
	}
	
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
