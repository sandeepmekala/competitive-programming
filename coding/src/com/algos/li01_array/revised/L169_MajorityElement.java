package  com.algos.li01_array.revised;

public class L169_MajorityElement {

	public static void main(String[] args) {
		L169_MajorityElement obj = new L169_MajorityElement();
		
		int[] nums = new int[] {3,2,3};
		System.out.println(obj.majorityElement(nums));
	}

    // Problem: https://leetcode.com/problems/majority-element/
    // Idea: Moore's Voting algorithm
    public int majorityElement(int[] nums) {
        int major = -1, cnt = 0;
        for(int num: nums){
            if(num == major){
                cnt++;
            } else if(cnt == 0){
                major = num;
                cnt++;
            } else{
                cnt--;
            }
        }

        return major;
    }    
    
}
