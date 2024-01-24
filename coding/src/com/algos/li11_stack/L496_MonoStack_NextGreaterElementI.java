package  com.algos.li11_stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class L496_MonoStack_NextGreaterElementI {

	public static void main(String[] args) {
		L496_MonoStack_NextGreaterElementI obj = new L496_MonoStack_NextGreaterElementI();
		
		int[] nums1 = new int[] {4,1,2};
		int[] nums2 = new int[] {1,3,4,2};
		
		int[] result = obj.nextGreaterElement(nums1, nums2);
		System.out.println(Arrays.toString(result));
	}
	
    // Problem: https://leetcode.com/problems/next-greater-element-i/
    // Idea: Move right to left and build monotonically decreasing stack.
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=nums2.length-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums2[i]) 
                stack.pop();
            if(stack.isEmpty())
                map.put(nums2[i], -1);
            else
                map.put(nums2[i], stack.peek());

            stack.push(nums2[i]);
        }
        
        int[] result = new int[nums1.length];
        for(int i=0; i<nums1.length; i++)
            result[i] = map.get(nums1[i]);
        
        return result;
    }

}
