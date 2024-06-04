package  com.algos.core.li07_stack.revised;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Mono_L496_NextGreaterElementI {

	public static void main(String[] args) {
		Mono_L496_NextGreaterElementI obj = new Mono_L496_NextGreaterElementI();
		
		int[] nums1 = new int[] {4,1,2};
		int[] nums2 = new int[] {1,3,4,2};
		
		int[] result = obj.nextGreaterElement(nums1, nums2);
		System.out.println(Arrays.toString(result));
	}
	
    // Problem: https://leetcode.com/problems/next-greater-element-i/
    // Idea: Move right to left and build monotonically decreasing stack.
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n2 = nums2.length;
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=n2-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums2[i]) 
                stack.pop();
            if(stack.isEmpty())
                map.put(nums2[i], -1);
            else
                map.put(nums2[i], stack.peek());

            stack.push(nums2[i]);
        }
        
        int n1 = nums1.length;
        int[] result = new int[n1];
        for(int i=0; i<n1; i++)
            result[i] = map.get(nums1[i]);
        
        return result;
    }

}
