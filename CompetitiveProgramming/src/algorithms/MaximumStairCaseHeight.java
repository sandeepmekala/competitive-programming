package algorithms;

import java.util.Scanner;

public class MaximumStairCaseHeight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfTests = sc.nextInt();
		for (int i = 0; i < numberOfTests; i++) {
			int j = 1;
			String arr[] = {};
			int number = sc.nextInt();
			while (true) {
				int value = (j * (j + 1)) / 2;
				if (value > number) {
					System.out.println(j - 1);
					break;
				}
				j++;
			}
		}
	}

}
