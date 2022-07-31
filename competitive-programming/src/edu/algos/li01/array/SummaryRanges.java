package edu.algos.li01.array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static void main(String[] args) {
		SummaryRanges obj = new SummaryRanges();
		
		int[] nums = new int[] {0,1,2,4,5,7};
		System.out.println(obj.summaryRanges(nums));
	}
	
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
