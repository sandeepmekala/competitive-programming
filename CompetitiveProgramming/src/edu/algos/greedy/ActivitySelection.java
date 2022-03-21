package edu.algos.greedy;

import java.util.ArrayList;
import java.util.Comparator;

public class ActivitySelection {

	public static void main(String[] args) {
		int start[] = { 1, 3, 0, 5, 8, 5 };
		int finish[] = { 2, 4, 6, 7, 9, 9 };
		int n = start.length;
		ArrayList<Activity> activities = new ArrayList<Activity>();
		activities.add(new Activity(5,9));
		activities.add(new Activity(1,2));
		activities.add(new Activity(3,4));
		activities.add(new Activity(0,6));
		activities.add(new Activity(5,7));
		activities.add(new Activity(8,9));
		
		printMaxActivities(activities);
	}
	
	//concept: sort the activities based on finish time and start pickining activities if start of that activity >= end time of previous activity
	private static void printMaxActivities(ArrayList<Activity> activities) {
		activities.sort(new Comparator<Activity>(){

			@Override
			public int compare(Activity o1, Activity o2) {
				if(o1.getEnd() > o2.getEnd()) {
					return 1;
				}else if(o1.getEnd() < o2.getEnd()) {
					return -1;
				}
				return 0;
			}
			
		});
		
		Activity prev = activities.get(0);
		prev.print();
		for(Activity activity: activities) {
			if(activity.getStart() >= prev.getEnd()) {
				activity.print();
				prev = activity;
			}
		}
	}

}
class Activity{
	private int start;
	private int end;
	
	Activity(int start, int end){
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	public String toString() {
		return this.start+" : "+this.end;
	}
	public void print() {
		System.out.println(toString());
	}
}