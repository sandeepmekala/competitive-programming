package  com.algos.topics.li01_array.revised;

public class L169_MajorityElement {

	public static void main(String[] args) {
		L169_MajorityElement obj = new L169_MajorityElement();

		int[] nums = new int[] {3,2,3};
		System.out.println(obj.majorityElement(nums));
	}

    // Problem: https://leetcode.com/problems/majority-element/
    // Idea: Moore's Voting algorithm
    public int majorityElement(int[] nums) {
        int el1 = -1, cnt = 0;
        for(int num: nums){
            if(num == el1){
                cnt++;
            } else if(cnt == 0){
                el1 = num;
                cnt = 1;
            } else{
                cnt--;
            }
        }

        // no need to check for majority element as problem guarantees
        // that majority element always exists
        int cnt1 = 0;
        for(int num: nums){
            if(num == el1)
                cnt1++;
        }
        if(cnt1 > nums.length/2)
            return el1;
        return -1;
    }

}
