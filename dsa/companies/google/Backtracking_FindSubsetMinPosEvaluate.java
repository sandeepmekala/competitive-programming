
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Backtracking_FindSubsetMinPosEvaluate {

    // Problem: https://leetcode.com/discuss/interview-question/4948927/Google-or-SDE2-or-Phone-Screen
    // Idea: Backtracking
    private boolean helper(List<Double> a, int target) {
        if (a.size() == 1) {
            return Math.abs(a.get(0) - target) < 1e-6;
        }

        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                List<Double> d = new ArrayList<>();

                for (int k = 0, index = 0; k < a.size(); k++) {
                    if (k != i && k != j) {
                        d.add(a.get(k));
                    }
                }
                // Perform and store results of operations
                List<Double> results = new ArrayList<>(Arrays.asList(a.get(i) * a.get(j), a.get(i) + a.get(j), a.get(i) - a.get(j), a.get(j) - a.get(i)));
                if (a.get(j) != 0) results.add(a.get(i) / a.get(j));
                if (a.get(i) != 0) results.add(a.get(j) / a.get(i));

                for (Double num : results) {
                    d.add(num);
                    if(helper(d, target))
                        return true;
                    d.remove(d.size() - 1);
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        List<Double> nums2 = new ArrayList<>(Arrays.asList(1.0, 2.0));
        List<Double> nums = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0));

        Backtracking_FindSubsetMinPosEvaluate obj = new Backtracking_FindSubsetMinPosEvaluate();
        for (int i = 1; i <= 6561; i++) { // 9^4
            if (!obj.helper(nums, i)) {
                System.out.println(i);// Output: 4
                break;
            }
        }
    }
}
