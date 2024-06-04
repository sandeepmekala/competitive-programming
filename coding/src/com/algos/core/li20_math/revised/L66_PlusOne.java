package  com.algos.core.li20_math.revised;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L66_PlusOne {

	public static void main(String[] args) {
		L66_PlusOne obj = new L66_PlusOne();
		System.out.println(Arrays.toString(obj.plusOne(new int[] {1,2,3})));
	}

	// Problem: https://leetcode.com/problems/plus-one/
    // Idea: In 999 case carry could propagate from right to left. Hence, process right to left.
	public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int carry = 1, n=digits.length;
        for(int i=n-1; i>=0; i--){
            int sum = carry+digits[i];
            list.add(sum%10);
            carry = sum/10;
        }
        if(carry > 0)
            list.add(carry);
        
        Collections.reverse(list);
        return list.stream().mapToInt(i->i).toArray();
    }
}
