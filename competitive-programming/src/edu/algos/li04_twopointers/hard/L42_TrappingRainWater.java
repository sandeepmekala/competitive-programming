package edu.algos.li04_twopointers.hard;

public class L42_TrappingRainWater {

	public static void main(String[] args) {
		L42_TrappingRainWater obj = new L42_TrappingRainWater();
		
		int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(obj.trap(height));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/trapping-rain-water/
	 * Idea: Track the maximum from left and right
	 * if maxl is minimum, means the water that gets logged will be at max will be height of maxl. use maxl to find the current position water logging maxl-height[i]
	 * similarly, update the water logging from the right if maxr is smaller then the maxl.
	 *  
	 * */
	public int trap(int[] height) {
        int sum = 0, n = height.length, maxl = height[0], maxr = height[n-1];
        int l=1, r=n-2;
        while(l<=r){
            if(maxl <= maxr){
                if(maxl-height[l] > 0){
                    sum += maxl-height[l];
                }
                maxl = Math.max(maxl, height[l]);
                l++;
            }else{
                if(maxr-height[r] > 0){
                    sum += maxr-height[r];
                }
                maxr = Math.max(maxr, height[r]);
                r--;
            }
        }
        
        return sum;
    }

}
