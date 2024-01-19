package edu.algos.li25_greedy;

public class L605_CanPlaceFlowers {

	public static void main(String[] args) {
		L605_CanPlaceFlowers obj = new L605_CanPlaceFlowers();

		int[] flowerbed = new int[] {1,0,0,0,0,1};
		System.out.println(obj.canPlaceFlowers(flowerbed, 2));
	}

	// Problem: https://leetcode.com/problems/can-place-flowers/
	// Idea: Just skip the cell if i, i-1, i+1 positions contains 1
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] == 1) continue;
			if (i>0 && flowerbed[i - 1] == 1)  continue;
            if (i<flowerbed.length-1 && flowerbed[i + 1] == 1)  continue;

			flowerbed[i] = 1;
			n--;
		}

		return n <= 0;
	}

}
