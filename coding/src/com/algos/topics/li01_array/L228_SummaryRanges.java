package  com.algos.topics.li01_array;

import java.util.ArrayList;
import java.util.List;

public class L228_SummaryRanges {

	public static void main(String[] args) {
		L228_SummaryRanges obj = new L228_SummaryRanges();

		int[] nums = new int[] {0,1,2,4,5,7};
		System.out.println(obj.summaryRanges(nums));
	}
	// Problem: https://leetcode.com/problems/summary-ranges/description/
    // Idea: Use two pointers to find the start and end of range.
	public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> result = new ArrayList<>();
        if(n == 0) return result;

        int start = nums[0];
        int end = nums[0];
        for(int i=1; i<n; i++){
            if(nums[i-1]+1 == nums[i]){
                end = nums[i];
            }else{
                if(start == end){
                    result.add(String.valueOf(start));
                }else{
                    result.add(start+"->"+end);
                }

                start = nums[i];
                end = nums[i];
            }
        }
        if(start == end){
            result.add(String.valueOf(start));
        }else{
            result.add(start+"->"+end);
        }

        return result;
    }

}
