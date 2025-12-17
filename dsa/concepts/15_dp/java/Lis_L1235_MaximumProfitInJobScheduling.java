
import java.util.Arrays;

import com.algos.topics.models.Job;

public class Lis_L1235_MaximumProfitInJobScheduling {

	public static void main(String[] args) {
		Lis_L1235_MaximumProfitInJobScheduling obj = new Lis_L1235_MaximumProfitInJobScheduling();

		int[] starts = new int[] {1,2,3,3};
		int[] ends = new int[] {3,4,5,6};
		int[] profits = new int[] {50,10,40,70};

		System.out.println(obj.jobScheduling(starts, ends, profits));
	}

	/*
	 * Problem: https://leetcode.com/problems/maximum-profit-in-job-scheduling/
	 * Idea: Use profits tabulation array for jobs
	 * If job j can be picked before ith job, update the profit of i.
	 * TODO
	 *
	 * */
	public int jobScheduling(int[] starts, int[] ends, int[] profits) {
		int n = starts.length;
		Job[] jobs = new Job[n];
		for(int i=0; i<starts.length; i++) {
			jobs[i] = new Job(starts[i], ends[i], profits[i]);
		}

		Arrays.sort(jobs, (j1, j2) -> j1.start-j2.start);

		int[] profit = new int[n];
		for(int i=0; i<n; i++)
			profit[i] = jobs[i].profit;

		int maxProfit = 0;
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(!(jobs[j].end > jobs[i].start && jobs[j].start < jobs[i].end)) {
					profit[i] = Math.max(profit[i], profit[j]+jobs[i].profit);
				}
			}
			if(profit[i] > maxProfit) {
				maxProfit = profit[i];
			}
		}
		return maxProfit;
	}
}
