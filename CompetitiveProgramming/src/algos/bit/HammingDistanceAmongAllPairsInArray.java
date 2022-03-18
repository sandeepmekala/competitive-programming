package algos.bit;

public class HammingDistanceAmongAllPairsInArray {

	public static void main(String[] args) {
		int[] numbers = new int[] {1,3,5};
		System.out.println(totalHammingDistance(numbers));
	}
	
	// we can get the hamming distance by doing xor
	// getting all pairs will lead to O(n*2)
	// if we look at all the bits at a perticular position, we can figure out the each 1 need to be paired with each o
	// i.e no. of 1's * no. of 0's 
	private static int totalHammingDistance(int[] numbers) {
		int count = 0; 
		for(int i=0; i<32; i++) {
			int noOfOnes = 0;	
			for(int j=0; j<numbers.length; j++) {
				if((numbers[j]&(1<<i))>0) {
					noOfOnes++;
				}
			}
			count += 2*(noOfOnes*(numbers.length-noOfOnes));
		}
		return count;
	}

}