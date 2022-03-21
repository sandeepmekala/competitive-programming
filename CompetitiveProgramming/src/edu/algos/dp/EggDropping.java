package edu.algos.dp;

public class EggDropping {
	// https://www.youtube.com/watch?v=3hcaVyX00_4&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=12
	public static void main(String[] args) {
		int floors = 2;
		int eggs = 1;
		System.out.println(eggDroppingTopDown(eggs, floors));
	}

	private static int eggDroppingTopDown(int eggs, int floors) {
		if(eggs <= 0 || floors <= 0){
			return 0;
		}
		if(eggs > floors) {
			return eggDroppingTopDown(floors-1, eggs-1);
		}else {
			int min = Integer.MAX_VALUE;
			for(int k=1; k<floors; k++) {
				int temp = Math.max(eggDroppingTopDown(eggs-1, k-1), eggDroppingTopDown(eggs, floors-k));
				min = 1+Math.min(min, temp);
			}
			return min;
		}
	}

}
