package  com.algos.li05_binarysearch.revised;

public class KThElementOfTwoSortedArrays {
    public static void main(String args[]) {
        KThElementOfTwoSortedArrays obj = new KThElementOfTwoSortedArrays();

        int nums1[] = { 2, 3, 6, 7, 9 };
        int nums2[] = { 1, 4, 8, 10 };
        int m = nums1.length;
        int n = nums2.length;
        int k = 5;
        System.out.println(obj.kthelement(nums1, nums2, m, n, k));
    }

    public int kthelement(int[] nums1, int[] nums2, int n1, int n2, int k) {
        if (n1 > n2) 
            return kthelement(nums2, nums1, n2, n1, k);

        int low = Math.max(0, k - n2), high = Math.min(k, n1);
        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = k - mid1;                // not mid-cut1 but k-cut1
            int l1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int l2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int r1 = mid1 == n2 ? Integer.MAX_VALUE : nums1[mid1];
            int r2 = mid2 == n1 ? Integer.MAX_VALUE : nums2[mid2];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return -1;
    }
}
