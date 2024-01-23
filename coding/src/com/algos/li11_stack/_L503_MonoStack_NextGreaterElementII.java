package  com.algos.li11_stack;

import java.util.Arrays;
import java.util.Stack;

public class _L503_MonoStack_NextGreaterElementII {
    public static void main(String[] args) {
        _L503_MonoStack_NextGreaterElementII obj = new _L503_MonoStack_NextGreaterElementII();

        int[] nums = new int[] { 1, 2, 3, 4, 3 };
        int[] nge = obj.nextGreaterElements(nums);
        System.out.println(Arrays.toString(nge));
    }

    // Problem: https://leetcode.com/problems/next-greater-element-ii/
    // Idea: Same as nge. To handle circular case paste same array to the right virtually.
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int nge[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (stack.isEmpty() == false && stack.peek() <= nums[i % n]) {
                stack.pop();
            }

            if (i < n) {
                if (stack.isEmpty())
                    nge[i] = -1;
                else
                    nge[i] = stack.peek();
            }

            stack.push(nums[i % n]);
        }
        return nge;
    }
}
