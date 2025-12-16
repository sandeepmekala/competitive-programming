package li06_divandcon;

import java.util.Arrays;
import java.util.List;

public class Marge_L315_CountOfSmallerNumbersAfterSelf {

    public static void main(String[] args) {
		Marge_L315_CountOfSmallerNumbersAfterSelf obj = new Marge_L315_CountOfSmallerNumbersAfterSelf();
		int[] nums = { 5,2,6,1};

		System.out.println(obj.countSmaller(nums));
	}

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] count = new Integer[n];
        Integer[] originalIndex = new Integer[n];

        for (int i = 0; i < n; i++) {
            count[i] = 0;
            originalIndex[i] = i;
        }

        solve(0, n - 1, nums, count, originalIndex);
        return Arrays.asList(count);
    }

    private void solve(int low, int high, int[] nums, Integer[] count, Integer[] origIndex) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        solve(low, mid, nums, count, origIndex);
        solve(mid + 1, high, nums, count, origIndex);
        merge(nums, count, origIndex, low, mid, high);
    }

    private void merge(int[] nums, Integer[] count, Integer[] origIndex, int low, int mid, int high) {
        int ls = mid - low + 1;
        int rs = high - mid;
        Integer[] l = new Integer[ls];
        Integer[] r = new Integer[rs];

        for (int i = 0; i < ls; i++)
            l[i] = origIndex[low + i];

        for (int i = 0; i < rs; i++)
            r[i] = origIndex[mid + 1 + i];

        int left = 0, right = 0, k = low, cnt = 0;

        while (left < ls && right < rs) {
            if (nums[l[left]] <= nums[r[right]]) {
                origIndex[k] = l[left];
                count[l[left]] += cnt;
                left++;
            } else {
                origIndex[k] = r[right];
                cnt++;
                right++;
            }
            k++;
        }

        while (left < ls) {
            origIndex[k] = l[left];
            count[l[left]] += cnt;
            left++;
            k++;
        }

        while (right < rs) {
            origIndex[k] = r[right];
            right++;
            k++;
        }
    }
}
