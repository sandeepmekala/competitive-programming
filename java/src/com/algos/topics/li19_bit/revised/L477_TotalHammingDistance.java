package  com.algos.topics.li19_bit.revised;

public class L477_TotalHammingDistance {

	public static void main(String[] args) {
		L477_TotalHammingDistance obj = new L477_TotalHammingDistance();

		int[] numbers = new int[] {4,14,2};
		System.out.println(obj.totalHammingDistance(numbers));
	}

	// Problem: https://leetcode.com/problems/total-hamming-distance/
	// Idea: We can get the hamming distance by doing xor. Getting all pairs will lead to O(n^2).
	// If we look at all the bits at a particular position, we can figure out the each 1 need to be paired with each 0.
	// I.e no. of 1's * no. of 0's.
	public int totalHammingDistance(int[] nums) {
		int count = 0, n = nums.length;
		for(int i=0; i<32; i++) {
			int noOfOnes = 0;
			for(int j=0; j<n; j++) {
				if(((nums[j]>>i)&1) == 1)
					noOfOnes++;
			}
			int numOfZeros = n - noOfOnes;
			count += noOfOnes*numOfZeros;
		}
		return count;
	}

}
