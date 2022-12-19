package edu.algos.li20_dp1;

import java.util.Arrays;
import java.util.Comparator;

import edu.algos.li00_model.Job;

public class Dp15WeightedJobScheduling {

	public static void main(String[] args) {
		Dp15WeightedJobScheduling obj = new Dp15WeightedJobScheduling();
		
		int[] starts = new int[] {1,2,3,3};
		int[] ends = new int[] {3,4,5,6};
		int[] profits = new int[] {50,10,40,70};
		
		System.out.println(obj.jobScheduling(starts, ends, profits));
	}

	/*
	 * Idea: use profits tabulation array for jobs
	 * if job j can be picked before ith job, update the profit of i.
	 * 
	 * 
	 * 
	 * 
	 * */
	public int jobScheduling(int[] starts, int[] ends, int[] profits) {
		int n = starts.length;
		Job[] jobs = new Job[n];
		for(int i=0; i<starts.length; i++) {
			jobs[i] = new Job(starts[i], ends[i], profits[i]);
		}
		
		Arrays.sort(jobs, (j1, j2) -> j1.end-j2.end);
		
		int[] profit = new int[n];
		for(int i=0; i<n; i++) {
			profit[i] = jobs[i].profit;
		}
		
		int maxProfit = 0;
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(!isOverlap(jobs[j], jobs[i])) {
					profit[i] = Math.max(profit[i], profit[j]+jobs[i].profit);
				}
			}
			if(profit[i] > maxProfit) {
				maxProfit = profit[i];
			}
		}
		return maxProfit;
	}

	private boolean isOverlap(Job job1, Job job2) {
		return job1.end > job2.start;
	}
}