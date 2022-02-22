package ds.graphs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
 
// This class represents a directed graph using adjacency list
// representation
class DirectedGraph
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists
 
    // Constructor
    DirectedGraph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
    void print() {
    	for(int i=0; i<V; i++) {
    		for(int j=0; j<adj[i].size(); j++) {
    			System.out.println(i+" -> "+adj[i].get(j));
    		}
    	}
    }
 
    // prints BFS traversal from a given source s
    void BFS(int current)
    {	// time complexity O(V+E)
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];
 
        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<Integer>();
 
        queue.add(current);
 
        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            current = queue.remove();
            visited[current] = true;
            System.out.print(current+" ");
 
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for(int i=0; i<adj[current].size(); i++)
            {
                int child = adj[current].get(i);
                if (!visited[child])
                {
                    queue.add(child);
                }
            }
        }
    }
 
    private void DFS(int current) {
    	// time complexity O(V+E)
    	boolean[] visited = new boolean[V];
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.push(current);
    	
    	while(!stack.isEmpty()) {
    		
    		current = stack.pop();
    		visited[current] = true;
    		System.out.print(current+" ");
    		
    		for(int i=0; i<adj[current].size(); i++) {
    			Integer child = adj[current].get(i);
    			if(!visited[child]) {
    				stack.push(child);
    			}
    		}
    	}
    }
    
    private boolean isCyclic(int current) {
    	// time complexity O(V+E)
    	boolean[] visited = new boolean[V];
    	boolean[] inStack = new boolean[V];
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.push(current);
    	inStack[current] = true;
    	
    	while(!stack.isEmpty()) {
    		
    		current = stack.pop();
    		visited[current] = true;
    		
    		boolean noChildsToVisite = true;
    		for(int i=0; i<adj[current].size(); i++) {
    			Integer child = adj[current].get(i);
    			if(inStack[child] || current == child) {
    				return true;
    			}
    			if(!visited[child]) {
    				stack.push(child);
    				
    				inStack[current] = true;
    				noChildsToVisite = false;
    			}
    		}
    		if(noChildsToVisite) {
    			inStack[current] = false;
    		}
    	}
    	return false;
    }
    // Driver method to
    public static void main(String args[])
    {
    	// -> represented by adjacency matrix and adjacency list
    	// -> in adjacency matrix representation, adding new edge, checking whether edge exist takes O(1) time but addjust new vertex takes O(v^2)
    	
        DirectedGraph g = new DirectedGraph(4);
 
        g.addEdge(0, 1);
        //g.addEdge(0, 2);
        //g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        g.print();
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        g.BFS(2);
        System.out.println();
        g.DFS(2);
        
        System.out.println("Is cyclic: "+g.isCyclic(2));
    }
}
// This code is contributed by Aakash Hasija