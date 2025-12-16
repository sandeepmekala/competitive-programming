
import java.util.Arrays;

public class ShortestJobFirstCPUScheduling {
    public static void main(String[] args) {
        ShortestJobFirstCPUScheduling obj = new ShortestJobFirstCPUScheduling();
        int[] tasks = new int[]{4,3,7,1,2};
        System.out.println(obj.shortestJobFirst(tasks));
    }

    // Problem: https://www.geeksforgeeks.org/program-for-shortest-job-first-or-sjf-cpu-scheduling-set-1-non-preemptive/
    // Idea: Greedy: Sort the jobs based on task time. Pick the job with minimum burst time.
    // Time: O(nlogn)
    public double shortestJobFirst(int[] tasks) {
        int n = tasks.length;
        int totWaitTime = 0, waitTime = 0;
        Arrays.sort(tasks);
        for(int task: tasks){
            totWaitTime += waitTime;
            waitTime += task;
        }
        return totWaitTime/n;
    }
}
