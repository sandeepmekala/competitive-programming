package  com.algos.li05_binarysearch.revised;

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
		int low = 1, high = Integer.MIN_VALUE, ans = -1;
		for(int pile: piles) 
			high = Math.max(high, pile);
		
		while(low<=high) {
			int mid = (low+high)/2;
			int hours = getHours(piles, mid);
			if(hours <= h) {
				ans = mid;
				high = mid-1;
			}else {
				low = mid+1;
			}
		}
		
		return ans;
	}

	private int getHours(int[] piles, int mid) {
		int hours = 0;
		for(int pile: piles) {
			hours += Math.ceil((pile*1.0)/mid);
		}
		return hours;
	}

}
