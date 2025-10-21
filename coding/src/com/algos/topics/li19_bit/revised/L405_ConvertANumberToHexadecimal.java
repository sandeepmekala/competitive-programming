package  com.algos.topics.li19_bit.revised;

public class L405_ConvertANumberToHexadecimal {

	public static void main(String[] args) {
		L405_ConvertANumberToHexadecimal obj = new L405_ConvertANumberToHexadecimal();

		System.out.println(obj.toHex(26));
        System.out.println(obj.toHex(-26));

        System.out.println(Integer.toBinaryString(-26));
        System.out.println(Integer.toBinaryString((-26>>2)));   // fills 1 at msb to keep it negative
        System.out.println(Integer.toBinaryString((-26>>>2)));  // fills 0 at msb and makes num positive.
	}

	/*
	 * Problem: https://leetcode.com/problems/convert-a-number-to-hexadecimal/
	 * Companies: Facebook
     * Idea: Take a rem by dividing 15 and get corresponding rem chars.
     * As num be negative use n!=0 as while condition
     * Use >>> instead of >> as we need to convert lsb bits also.
	 * */
	public String toHex(int num) {
        if(num == 0) return "0";

        StringBuffer sb = new StringBuffer();
        while(num != 0){
            int rem = num&15;   // or num%16
            if(rem < 10) sb.append(String.valueOf(rem));
            else sb.append((char)('a'+rem-10));

            num >>>= 4; //or num/16
        }

        return sb.reverse().toString();
    }

}
