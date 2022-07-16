package edu.algos.li06.binarysearch;

public class KokoEatingBananas {

	public static void main(String[] args) {
		KokoEatingBananas obj = new KokoEatingBananas();
		
		//int[] piles = new int[] {3,6,7,11};
		int[] piles = new int[] {30,11,23,4,20};
		//int h = 8;
		int h = 5;
		System.out.println(obj.minEatingSpeed(piles, h));
	}

	public int minEatingSpeed(int[] piles, int h) {
		int start = 1, end = Integer.MIN_VALUE, res = -1;
		for(int pile: piles) {
			end = Math.max(end, pile);
		}
		
		while(start<=end) {
			int mid = (start+end)/2;
			int hr = getHours(piles, mid);
			if(hr <= h) {
				res = mid;
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		
		return res;
	}

	private int getHours(int[] piles, int mid) {
		int hours = 0;
		for(int pile: piles) {
			hours += Math.ceil((pile*1.0)/mid);
		}
		return hours;
	}

}
