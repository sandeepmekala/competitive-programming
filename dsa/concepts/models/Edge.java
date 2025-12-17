package concepts.models;

public class Edge implements Comparable<Edge>{
	public int src;
	public int dest;
	public int weight;

	public Edge(int src, int dest){
		this.src = src;
		this.dest = dest;
	}

	public Edge(int src, int dest, int weight){
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge compareWithEdge) {
		return this.weight - compareWithEdge.weight;
	}

	public String toString() {
		return src+"->"+dest;
	}
}
