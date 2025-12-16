package  com.algos.topics.li20_math.revised;

public class L7_ReverseInteger {

	public static void main(String[] args) {
		L7_ReverseInteger obj = new L7_ReverseInteger();
		System.out.println(obj.reverse(123));
		System.out.println(obj.reverse(-123));
	}

    // Problem: https://leetcode.com/problems/reverse-integer/
    // Idea: Before right shifting res, check if multiplying it by 10 goes our of bound.
    // res*10 > INT_MAX
    // res > INT_MAX/10
	public int reverse(int x) {
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;

        int res = 0;
        while(x != 0){          // != 0 to handle negative nums also
            if(res > MAX/10)
                return 0;
            if(res < MIN/10)
                return 0;

            res = res*10;
            res = res + x%10;
            x = x/10;
        }
        return res;
    }
}
