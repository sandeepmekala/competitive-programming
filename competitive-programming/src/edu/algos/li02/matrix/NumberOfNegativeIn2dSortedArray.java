package edu.algos.li02.matrix;

public class NumberOfNegativeIn2dSortedArray {

	public static void main(String[] args) {

		int numbers[][] = { 
				{ -3, -2, -1, 1 }, 
				{ -2, 2, 3, 4 }, 
				{ 4, 5, 7, 8 } 
				};
		System.out.println(optimalWay(numbers));

	}

	private static int optimalWay(int numbers[][]) {// O(n+m)

		int count = 0;
		int i = 0;
		int j = numbers[0].length - 1;
		while (j >= 0 && i < numbers.length) {
			if (numbers[i][j] > 0) {
				j--;
			} else {
				count += (j + 1);
				i++;
			}
		}
		return count;
	}

}