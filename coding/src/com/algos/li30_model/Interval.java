package  com.algos.li30_model;

public class Interval {
	public int start, end, pos;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public Interval(int start, int end, int pos) {
		this.start = start;
		this.end = end;
		this.pos = pos;
	}
}