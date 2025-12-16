
import java.util.ArrayList;
import java.util.List;

public class BinarySearch_SparseBitArray {

    // Mocked API method for demonstration; replace with actual API call.
    boolean query(int l, int r, int[] array) {
        for (int i = l; i <= r; i++) {
            if (array[i] == 1) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> findOnes(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        if (!query(0, n - 1, nums))
            return result;

        int i = 0;
        while (i < n && query(i, n - 1, nums)) {
            int l = i;
            int r = n - 1;
            int ans = -1;

            while (l <= r) {
                int mid = (l + r) / 2;
                if (query(l, mid, nums)) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            if (ans != -1)
                result.add(ans);

            i = ans + 1;
        }

        return result;
    }

    public List<Integer> getPosition(int[] nums) {
        List<Integer> result = new ArrayList<>();
        getPositionHelper(nums, 0, nums.length - 1, result);
        return result;
    }

    private void getPositionHelper(int[] nums, int low, int high, List<Integer> result) {
        if (low == high) {
            if (nums[low] == 1)
                result.add(low);
            return;
        }
        int mid = low + (high - low) / 2;
        if (query(low, mid, nums)) // Discard the half if from left to mid if there isn't a single 1.
            getPositionHelper(nums, low, mid, result);
        if (query(mid + 1, high, nums)) // Discard the half if from mid +1 to right there isn't a single 1.
            getPositionHelper(nums, mid + 1, high, result);
    }

    public static void main(String[] args) {
        BinarySearch_SparseBitArray obj = new BinarySearch_SparseBitArray();
        // Example sparse bit array
        int[] array = { 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1 };
        System.out.println(obj.findOnes(array));
        System.out.println(obj.getPosition(array));
    }
}
