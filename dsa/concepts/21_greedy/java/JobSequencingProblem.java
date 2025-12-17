import java.io.IOException;
import java.util.Arrays;

class JobSequencingProblem {
	public static void main(String[] args) {

		// size of array
		Job[] arr = new Job[4];
		arr[0] = new Job(1, 4, 20);
		arr[1] = new Job(2, 1, 10);
		arr[2] = new Job(3, 2, 40);
		arr[3] = new Job(4, 2, 30);

		JobSequencingProblem obJ = new JobSequencingProblem();

		// function call
		int[] res = obJ.schedule(arr, 4);
		System.out.println(res[0] + " " + res[1]); // count of jobs and max profit made

	}

	// Idea: Sort jobs by profit in descending order, then for each job find the latest free slot before its deadline
	// Delay the jobs as late as possible to leave first slots for other jobs
	// Time: O(n*max_deadline)
	public int[] schedule(Job arr[], int n) {
		Arrays.sort(arr, (j1, j2) -> (j2.profit - j1.profit));

		int maxi = 0;
		for (int i = 0; i < n; i++)
			maxi = Math.max(maxi, arr[i].deadline);

		int hash[] = new int[maxi + 1];
		Arrays.fill(hash, -1);

		int jobsCnt = 0, jobsProfit = 0;
		for (int i = 0; i < n; i++) {
			for (int j = arr[i].deadline; j >= 0; j--) {
				if (hash[j] == -1) { // Free slot found
					hash[j] = i;
					jobsCnt++;
					jobsProfit += arr[i].profit;
					break;
				}
			}
		}

		return new int[] { jobsCnt, jobsProfit };
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
