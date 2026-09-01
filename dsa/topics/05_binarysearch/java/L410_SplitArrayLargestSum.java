import java.util.Collections;
import java.util.List;

public class L410_SplitArrayLargestSum {

	public static void main(String[] args) {
		L410_SplitArrayLargestSum obj = new L410_SplitArrayLargestSum();

		int[] nums = new int[] {25, 46, 28, 49, 24};
		System.out.println(obj.findPages(nums, 4));
	}

	// Problem: https://leetcode.com/problems/split-array-largest-sum/
    // Minimize the max pages allocated to k students
    // Minimize the max sum of array after splitting array into k parts
    // Idea: Apply BS on range max and sum.
    public int findPages(int[] nums, int m) {
        int n = nums.length;
        // book allocation impossible
        if (m > n)
            return -1;

        int max = Integer.MIN_VALUE, sum = 0;
        for(int num: nums){
            max = Math.max(max, num);
            sum += num;
        }

        int low = max, high = sum, ans = sum;
        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents(nums, mid);
            if (students <= m) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int countStudents(int[] nums, int pages) {
        int n = nums.length;
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if (pagesStudent + nums[i] <= pages) {
                pagesStudent += nums[i];
            } else {
                students++;
                pagesStudent = nums[i];
            }
        }

        return students;
    }
}
