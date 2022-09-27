package edu.algos.li08.greedy;

public class CanPlaceFlowers {

	public static void main(String[] args) {
		CanPlaceFlowers obj = new CanPlaceFlowers();

		int[] flowerbed = new int[] {1,0,0,0,0,1};
		System.out.println(obj.canPlaceFlowers(flowerbed, 2));
	}

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
