package edu.algos.li04_twopointers.twopointers;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		ContainerWithMostWater obj = new ContainerWithMostWater();
		System.out.println(obj.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
	}

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
