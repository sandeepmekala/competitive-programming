package edu.algos.li04.twopointers;

public class TrappingRainWater {

	public static void main(String[] args) {
		TrappingRainWater obj = new TrappingRainWater();
		
		int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(obj.trap(height));
	}
	
	/*
	 * Problem: find max units of rain water the gets logged in between the the histograms
	 * Concept: track the maximum from left and right
	 * if maxl is minimum, means the water that gets logged will be at max will be height of maxl. use maxl to find the current position water logging height(maxl-height[i])
	 * similarly, update the water logging on from the right if maxr is smaller then the maxl.
	 * 
	 * */
	public int trap(int[] height) {
        int l=0, r=height.length-1;
        int sum = 0, maxl = height[l], maxr = height[r];
        while(l<r){
            if(maxl <= maxr){
                l++;
                if(maxl-height[l] > 0){
                    sum += maxl-height[l];
                }
                maxl = Math.max(maxl, height[l]);
            }else{
                r--;
                if(maxr-height[r] > 0){
                    sum += maxr-height[r];
                }
                maxr = Math.max(maxr, height[r]);
            }
        }
        
        return sum;
    }

}
