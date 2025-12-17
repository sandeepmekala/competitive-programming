package li01_array.java;

import java.util.ArrayList;
import java.util.List;

public class L229_MajorityElementII {

	public static void main(String[] args) {
		L229_MajorityElementII obj = new L229_MajorityElementII();

		int[] nums = new int[] {2,1,1,3,1,4,5,6};
		System.out.println(obj.majorityElement(nums));
	}

    // Problem: https://leetcode.com/problems/majority-element-ii/description/
    // Idea: Use Moore's Voting algorithm
	public List<Integer> majorityElement(int[] nums) {
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;
        int cnt1 = 0, cnt2 = 0, n = nums.length;
        for(int num: nums){
        	if(num == el1){
                cnt1++;
            }else if(num == el2){
                cnt2++;
            }else if(cnt1 == 0){
                el1 = num;
                cnt1 = 1;
            }else if(cnt2 == 0){
                el2 = num;
                cnt2 = 1;
            }else{
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0; cnt2 = 0;
        for(int num: nums){
            if(num == el1) cnt1++;
            if(num == el2) cnt2++;
        }
        List<Integer> ans = new ArrayList<>();
        if(cnt1 > n/3) ans.add(el1);
        if(cnt2 > n/3) ans.add(el2);

        return ans;
    }
}
