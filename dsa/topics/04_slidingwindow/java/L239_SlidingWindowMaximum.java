import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class L239_SlidingWindowMaximum {

	public static void main(String[] args) {
		L239_SlidingWindowMaximum obj = new L239_SlidingWindowMaximum();

		int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
		int k = 3;
		int[] result = obj.maxSlidingWindow(nums, k);
		System.out.println(Arrays.toString(result));
	}

	// Problem: https://leetcode.com/problems/sliding-window-maximum/
	// Idea: Use, monotonically decreasing queue. Maintain the nums in decreasing order in queue.
	// 		first<-	5, 4, 3  <- last
	// Take the left most to take the max for that window.
	// Remove the left most if it goes out of window.
	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int[] ans = new int[n-k+1];

		int l=0, r=0;
		Deque<Integer> dq = new ArrayDeque<>();				// stores indices
		while(r<n) {
			while(!dq.isEmpty() && nums[dq.peekLast()] < nums[r])
				dq.removeLast();

			dq.add(r);					// add and remove one element. window size will be maintained.
			if(dq.peek() < l) {
				dq.remove();
			}

			if(r+1 >= k) {				// this condition to skip first indices like 0,1 etc.
				ans[l++] = nums[dq.peek()];
			}
			r++;
		}

		return ans;
	}

}
