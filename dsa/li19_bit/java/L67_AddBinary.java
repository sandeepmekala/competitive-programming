
public class L67_AddBinary {

	public static void main(String[] args) {
		L67_AddBinary obj = new L67_AddBinary();

		String a = "1010";
		String b = "1011";
		System.out.println(obj.addBinary(a, b));
	}

	/*
	 * Problem: https://leetcode.com/problems/add-binary/
	 * Idea: You can use normal number addition technique of num1, num2 and carry.
     * You can shift right the sum to get new carry.
	 * */
	public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int carry = 0, i=a.length()-1, j=b.length()-1;
        while(i>=0 || j>=0 || carry != 0){
            int num1 = i>=0? a.charAt(i--) - '0' : 0;
            int num2 = j>=0? b.charAt(j--) - '0' : 0;
            int sum = num1+num2+carry;

            if((sum&1) > 0) sb.append('1');
            else sb.append('0');

            carry = sum>>1;     // point
        }

        return sb.reverse().toString();
    }
}
