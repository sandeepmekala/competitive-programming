public class L414_ThirdMaximumNumber {

	public static void main(String[] args) {
		L414_ThirdMaximumNumber obj = new L414_ThirdMaximumNumber();

		int[] nums = new int[] {-2147483648,-2147483648,-2147483648,-2147483648,1,1,1};
		System.out.println(obj.thirdMax(nums));
	}

	/*
	 * Problem: https://leetcode.com/problems/third-maximum-number/
     * Idea: Swap max -> secMax, secMax -> thirdMax
	 * */
	public int thirdMax(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        Integer max = null, secondMax = null, thirdMax = null;
        for(Integer num: nums){
            if(num.equals(max) || num.equals(secondMax) || num.equals(thirdMax)) continue;

            if(max == null || num > max){
                thirdMax = secondMax;   //n
                secondMax = max;        //-1
                max = num;              //1
            }else if(secondMax == null || num > secondMax){
                thirdMax = secondMax;
                secondMax = num;
            }else if(thirdMax == null || num > thirdMax){
                thirdMax = num;
            }
        }

        if(thirdMax != null ) return thirdMax;
        return max;
    }
}
