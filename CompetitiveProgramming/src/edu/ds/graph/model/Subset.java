package edu.ds.graph.model;

public class Subset {
	public int data;
	public int parent;
	public int rank;

	public Subset(int data, int parent, int rank) {
		this.data = data;
		this.parent = parent;
		this.rank = rank;
	}
}