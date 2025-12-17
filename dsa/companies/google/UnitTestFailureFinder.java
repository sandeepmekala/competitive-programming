import java.util.Arrays;

public class UnitTestFailureFinder {

    // Mock of testRunner function
    public boolean testRunner(int[] testSet) {
        // Placeholder for actual testRunner implementation
        // This should return true if the tests pass and false if they fail.
        return true;
    }

    // Problem: https://leetcode.com/discuss/interview-question/4314794/GOOGLE-SDE-2-CODING-ROUND-1%3A-Find-the-in-compatible-pair-of-unit-tests/
    public int[] findFailingPair(int[] tests) {
        int n = tests.length;
        return findFailingPair(tests, 0, n - 1);
    }

    private int[] findFailingPair(int[] tests, int low, int high) {
        // Base case: if there are exactly two tests, return them as the failing pair
        if (high - low == 1) {
            return new int[] { tests[low], tests[high] };
        }

        int mid = (low + high) / 2;

        // Test the left half
        int[] leftHalf = Arrays.copyOfRange(tests, low, mid + 1);
        boolean leftResult = testRunner(leftHalf);

        // Test the right half
        int[] rightHalf = Arrays.copyOfRange(tests, mid + 1, high + 1);
        boolean rightResult = testRunner(rightHalf);

        if (!leftResult) {
            // If left half fails, the pair is within this half
            return findFailingPair(tests, low, mid);
        } else if (!rightResult) {
            // If right half fails, the pair is within this half
            return findFailingPair(tests, mid + 1, high);
        } else {
            // If both halves pass, the failing pair is across the halves
            // Test combining one element from each half
            // for (int i = low; i <= mid; i++) {
            //     for (int j = mid + 1; j <= high; j++) {
            //         if (!testRunner(new int[] { tests[i], tests[j] })) {
            //             return new int[] { tests[i], tests[j] };
            //         }
            //     }
            // }
            // Optimized version of the above commented code
            // for every ut in left half, check if it fails with complete right half. This finds one failing on left.
            // Now do BS on right half to find the other failing.
        }
        // In practice, we should never reach here if there's guaranteed to be a failing pair
        return new int[] {};
    }

    public static void main(String[] args) {
        UnitTestFailureFinder obj = new UnitTestFailureFinder();

        int[] tests = {1, 2, 3, 4, 5, 6, 7, 8}; // Example test cases
        int[] failingPair = obj.findFailingPair(tests);
        System.out.println("Failing pair: " + Arrays.toString(failingPair));
    }
}
