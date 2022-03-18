package algos.dp;

import java.util.Arrays;
import java.util.Comparator;

public class WeightedJobScheduling {

	public static void main(String[] args) {
		Job[] jobs = new Job[] {
				new Job(1,3,5),
				new Job(2,5,6),
				new Job(4,6,5),
				new Job(6,7,4),
				new Job(5,8,11),
				new Job(7,9,2)
		};
		System.out.println(maxProfit(jobs, jobs.length));
	}

	private static int maxProfit(Job[] jobs, int n) {
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

	private static boolean isOverlap(Job job1, Job job2) {
		return job1.end > job2.start;
	}
}
class Job{
	int start;
	int end;
	int profit;
	Job(int start, int end, int profit) {
		this.start = start;
		this.end = end;
		this.profit = profit;
	}
}