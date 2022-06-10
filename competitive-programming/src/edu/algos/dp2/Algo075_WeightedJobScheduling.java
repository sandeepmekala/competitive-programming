package edu.algos.dp2;

import java.util.Arrays;
import java.util.Comparator;

import edu.algos.model.Job;

public class Algo075_WeightedJobScheduling {

	public static void main(String[] args) {
		Algo075_WeightedJobScheduling obj = new Algo075_WeightedJobScheduling();
		Job[] jobs = new Job[] {
				new Job(1,3,5),
				new Job(2,5,6),
				new Job(4,6,5),
				new Job(6,7,4),
				new Job(5,8,11),
				new Job(7,9,2)
		};
		System.out.println(obj.maxProfit(jobs, jobs.length));
	}

	/*
	 * Concept: use profits tabulation array for jobs
	 * if job j can be picked before ith job. update the profit of i.
	 * 
	 * 
	 * 
	 * 
	 * */
	private int maxProfit(Job[] jobs, int n) {
		int maxProfit = 0;
		Arrays.sort(jobs, new Comparator<Job>() {
			
			public int compare(Job j1, Job j2) {
				return j1.end-j2.end;
			}
		});
		int[] profit = new int[n];
		for(int i=0; i<n; i++) {
			profit[i] = jobs[i].profit;
		}
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