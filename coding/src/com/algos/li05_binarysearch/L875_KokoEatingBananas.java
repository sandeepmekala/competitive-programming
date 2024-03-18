package  com.algos.li05_binarysearch;

public class L875_KokoEatingBananas {

	public static void main(String[] args) {
		L875_KokoEatingBananas obj = new L875_KokoEatingBananas();
		
		int[] piles = new int[] {3,6,7,11};
		//int[] piles = new int[] {30,11,23,4,20};
		int h = 8;
		//int h = 5;
		System.out.println(obj.minEatingSpeed(piles, h));
	}

	// Problem: https://leetcode.com/problems/koko-eating-bananas/
	// Idea: In the worst case each pile can be eaten once. So maximum possible k is max(piles).
	// So do BS for range k=1 and k=max(piles) and reduce k as much as possible.
	public int minEatingSpeed(int[] piles, int h) {
		int left = 1, right = Integer.MIN_VALUE, res = -1;
		for(int pile: piles) {
			right = Math.max(right, pile);
		}
		
		while(left<=right) {
			int mid = (left+right)/2;
			int hr = getHours(piles, mid);
			if(hr <= h) {
				res = mid;
				right = mid-1;
			}else {
				left = mid+1;
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
