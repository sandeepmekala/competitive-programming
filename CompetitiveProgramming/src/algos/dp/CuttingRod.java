package algos.dp;

public class CuttingRod {

	public static void main(String[] args) {
		int[] lens = new int[]{1,2,3,4};
		int[] profits = new int[] {2,5,7,8};
		int length = 5;
		System.out.println(cuttingRodTopDown(lens, profits, 3, length));
	}

	private static int cuttingRodTopDown(int[] lens, int[] profits, int i, int length) {
		if(i<0 || length < 0) {
			return 0;
		}else if(lens[i] > length) {
			return cuttingRodTopDown(lens, profits, i-1, length);
		}else {
			return Math.max(cuttingRodTopDown(lens, profits, i-1, length), profits[i]+cuttingRodTopDown(lens, profits, i, length-lens[i]));
		}
	}

}
