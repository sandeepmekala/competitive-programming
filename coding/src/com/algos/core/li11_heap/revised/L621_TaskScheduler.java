package  com.algos.core.li11_heap.revised;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class L621_TaskScheduler {

	public static void main(String[] args) {
		L621_TaskScheduler obj = new L621_TaskScheduler();

		char[] tasks = new char[] { 'A', 'A', 'A', 'B', 'B', 'B' };
		int n = 2;
		System.out.println(obj.leastInterval(tasks, n));
	}

	// Problem: https://leetcode.com/problems/task-scheduler/
	// Idea: We don't need to schedule the tasks but just need to find min time.
	// Find the freq's of each task so that remaining same task can be scheduled after t+n.
	// We will schedule most freq tasks first. Hence, insert all the freq in max pq to get max always.
	// For every time unit schedules one task and track the remaining tasks in separate q which can be scheduled after t+n.
	// For any time unit if any tasks from q can be loaded to pq, load them by comparing time.
	public int leastInterval(char[] tasks, int n) {
		HashMap<Character,Integer> map = new HashMap<>();
		for(char ch: tasks) 
			map.put(ch, map.getOrDefault(ch, 0)+1);
		
		Queue<Integer> pq = new PriorityQueue<>((t1,t2) -> t2 - t1);
		for(int freq: map.values()) 
			pq.add(freq);
		
		int time = 0;
		Queue<Schedule> q = new LinkedList<>();
		while(!pq.isEmpty() || !q.isEmpty()) {
			time++;
			if(!pq.isEmpty()) {
				int taskFreq = pq.remove();
				if(taskFreq>1) {
					q.add(new Schedule(taskFreq-1, time+n));
				}
			}
			
			while(!q.isEmpty() && q.peek().time <= time) {
				pq.add(q.remove().freq);
			}
		}
		
		return time;
	}

}
class Schedule{
	int freq;
	int time;
	Schedule(int val, int time ){
		this.freq = val;
		this.time = time;
	}
}
