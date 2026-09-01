public class L371_SumOfTwoIntegers {

    public static void main(String[] args) {
        L371_SumOfTwoIntegers obj = new L371_SumOfTwoIntegers();

        System.out.println(obj.getSum(1, 2));
        System.out.println(obj.getDiff(1, 2));
    }

    // Problem: https://leetcode.com/problems/sum-of-two-integers/
    // Idea: In binary addition, for 1,0 0,1 0,0 1,1 the sum will be 1,1,0,0. This we can get using xor.
    // But 1,1 case generates a carry which needs to be added to next bit sum.
    // When both are 1, the carry need to be 1. Hence use & to generate carry.
    // But the carry need to be added to next bit. Hence right shift it by one bit.
    // Repeate is until carry becomes 0.
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;          // sum
            b = carry << 1;     // carry after shifting
        }

        return a;
    }

    public int getDiff(int a, int b) {
        while (b != 0) {
            int carry = (~a) & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
