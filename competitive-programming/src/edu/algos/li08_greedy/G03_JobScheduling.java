package edu.algos.li08_greedy;

import java.io.IOException;
import java.util.Arrays;

class G03_JobScheduling {
	public static void main(String[] args) throws IOException {

		// size of array
		Job[] arr = new Job[4];
		arr[0] = new Job(1, 4, 20);
		arr[1] = new Job(2, 1, 10);
		arr[2] = new Job(3, 2, 40);
		arr[3] = new Job(4, 2, 30);

		G03_JobScheduling obJ = new G03_JobScheduling();

		// function call
		int[] res = obJ.schedule(arr, 4);
		System.out.println(res[0] + " " + res[1]); // count of jobs and max profit made

	}

	public int[] schedule(Job arr[], int n) {
		Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

		int maxi = 0;
		for (int i = 0; i < n; i++) {
			maxi = Math.max(maxi, arr[i].deadline);
		}

		int result[] = new int[maxi + 1];
		Arrays.fill(result, -1);

		int countJobs = 0, jobProfit = 0;
		for (int i = 0; i < n; i++) {
			for (int j = arr[i].deadline; j > 0; j--) {
				if (result[j] == -1) { // Free slot found
					result[j] = i;
					countJobs++;
					jobProfit += arr[i].profit;
					break;
				}
			}
		}

		return new int[] { countJobs, jobProfit };
	}
}

class Job {
	int id, profit, deadline;

	Job(int id, int deadline, int profit) {
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}
}