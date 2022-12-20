package edu.algos.li13_priorityqueue_heap.heap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

	public static void main(String[] args) {
		TaskScheduler obj = new TaskScheduler();

		char[] tasks = new char[] { 'A', 'A', 'A', 'B', 'B', 'B' };
		int n = 2;
		System.out.println(obj.leastInterval(tasks, n));
	}

	public int leastInterval(char[] tasks, int n) {
		int time = 0;
		
		HashMap<Character,Integer> map = new HashMap<>();
		for(char ch: tasks) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
		for(int freq: map.values()) {
			pq.add(freq);
		}
		
		Queue<Pair> q = new LinkedList<>();
		while(!pq.isEmpty() || !q.isEmpty()) {
			time++;
			if(!pq.isEmpty()) {
				int taskFreq = pq.remove();
				if(taskFreq>1) {
					q.add(new Pair(taskFreq-1, time+n));
				}
			}
			
			while(!q.isEmpty() && q.peek().time <= time) {
				pq.add(q.remove().val);
			}
		}
		
		return time;
	}

}
class Pair{
	int val;
	int time;
	Pair(int val, int time ){
		this.val = val;
		this.time = time;
	}
}
