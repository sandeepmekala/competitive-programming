package edu.algos.li04_twopointers.medium;

public class L11_ContainerWithMostWater {

	public static void main(String[] args) {
		L11_ContainerWithMostWater obj = new L11_ContainerWithMostWater();
		System.out.println(obj.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
	}

	// Problem: https://leetcode.com/problems/container-with-most-water/
	// Idea: Move ptrs from both side. Find the max height bar from both sides and its area. Skip smaller bar. Track Max area.
	public int maxArea(int[] height) {
		int maxArea = 0;
		int i=0, j=height.length-1;
		while(i<j) {
			int min = Math.min(height[i], height[j]);
			int area = (j-i)*min;
			maxArea =  Math.max(maxArea, area);
			if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
		}
        
        return maxArea;
	}

}
