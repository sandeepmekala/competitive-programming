package concepts.models;

public class Subset {
	public int val;
	public int parent;
	public int rank;
	public int size;

	public Subset(int val, int parent, int rank) {
		this.val = val;
		this.parent = parent;
		this.rank = rank;
	}
	public Subset(int val, int parent, int rank, int size) {
		this.val = val;
		this.parent = parent;
		this.size = size;
	}
}
