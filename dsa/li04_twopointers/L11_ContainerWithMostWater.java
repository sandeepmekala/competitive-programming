package li04_twopointers;

public class L11_ContainerWithMostWater {

	public static void main(String[] args) {
		L11_ContainerWithMostWater obj = new L11_ContainerWithMostWater();
		System.out.println(obj.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
	}

	// Problem: https://leetcode.com/problems/container-with-most-water/
	// Idea: Move ptrs from both side. Find the max height bar from both sides and its area. Skip smaller bar. Track Max area.
	public int maxArea(int[] height) {
		int maxArea = 0;
		int l = 0, r = height.length-1;
		while(l < r) {
			int min = Math.min(height[l], height[r]);
			int area = (r-l)*min;
			maxArea =  Math.max(maxArea, area);
			if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
		}

        return maxArea;
	}

}
