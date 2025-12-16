
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInAnArrayProblem {

        public static void main(String[] args) {
            LeadersInAnArrayProblem obj = new LeadersInAnArrayProblem();
            int[] arr = { 16, 17, 4, 3, 5, 2 };
            System.out.println(obj.printLeaders(arr));
        }

        // Problem: https://www.geeksforgeeks.org/leaders-in-an-array/
        // Idea: Traverse from right to left. If num is greater than max till now, then print it.
        public List<Integer> printLeaders(int[] nums){
            int max = Integer.MIN_VALUE;
            int n = nums.length;
            List<Integer> result = new ArrayList<>();
            for(int i=n-1; i>=0; i--){
                if(nums[i] > max){
                    max = nums[i];
                    result.add(nums[i]);
                }
            }

            Collections.sort(result);
            return result;
        }
}
