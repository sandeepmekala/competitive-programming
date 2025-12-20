import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath_L787_CheapestFlightsWithinKStops {

    public static void main(String[] args) {
        ShortestPath_L787_CheapestFlightsWithinKStops obj = new ShortestPath_L787_CheapestFlightsWithinKStops();

        int n = 4;
        int[][] flights = new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0;
        int dst = 3;
        int k = 1;
        System.out.println(obj.findCheapestPrice(n, flights, src, dst, k));

        System.out.println(obj.cheapestFLight(n, flights, src, dst, k));
    }

    // Problem: https://leetcode.com/problems/cheapest-flights-within-k-stops/
    // Idea: The idea of running it for only k steps is hard to be implemented in
    // Dikstra.
    // It is easy to be implemented using Bellman Ford as bellman ford runs for n-1
    // steps.
    // We need to run bellman ford layer by layer by relaxing each layer eages in
    // each step. Hence, we use a temp dist array to store the relaxed distances for
    // that layer and will be used as input to next layer relaxation.
    // There will be k+1 edges between source and dest for k stops. Hence, we need
    // to run bellmanford for k+1 time to relax k+1 edges.
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);

        dist[src] = 0;
        for (int i = 0; i <= k; i++) { // for k stop, we need to relax verices, k+1 times.
            int[] temp = Arrays.copyOf(dist, n);
            for (int[] edge : flights) {
                int sr = edge[0], dt = edge[1], wt = edge[2];
                if (dist[sr] == INF)
                    continue;

                if (dist[sr] + wt < temp[dt]) {
                    temp[dt] = dist[sr] + wt;
                }
            }
            dist = Arrays.copyOf(temp, n);
        }

        return dist[dst] == INF ? -1 : dist[dst];
    }

    // The same can be solved using Dijkstra's algorithm also by prioratizing the k
    // over dist.
    // This will boils down to applying simple BFS level wise.
    public int cheapestFLight(int n, int flights[][], int src, int dst, int k) {
        ArrayList<ArrayList<FlightPair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        int m = flights.length;
        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new FlightPair(flights[i][1], flights[i][2]));
        }

        Queue<FlightTuple> q = new LinkedList<>();
        q.add(new FlightTuple(0, src, 0));    // {k, airport, cost}

        int[] dist = new int[n];
        Arrays.fill(dist, (int) (1e9));

        dist[src] = 0;
        while (!q.isEmpty()) {
            FlightTuple curr = q.remove();
            int stops = curr.stops, node = curr.node, cost = curr.cost;

            // We stop the process as soon as the limit for the stops reaches.
            if (stops > k)
                continue;

            for (FlightPair it : adj.get(node)) {
                int neigh = it.airport;
                int edgeWeight = it.cost;

                // We only update the queue if the new calculated dist is
                // less than the prev and the stops are also within limits
                if (cost + edgeWeight < dist[neigh] && stops <= k) {
                    dist[neigh] = cost + edgeWeight;
                    q.add(new FlightTuple(stops + 1, neigh, cost + edgeWeight));
                }
            }
        }
        if (dist[dst] == (int) (1e9))
            return -1;
        return dist[dst];
    }
}

class FlightPair {
    int airport;
    int cost;

    public FlightPair(int node, int cost) {
        this.airport = node;
        this.cost = cost;
    }
}

class FlightTuple {
    int stops, node, cost;

    FlightTuple(int stops, int airport, int cost) {
        this.stops = stops;
        this.node = airport;
        this.cost = cost;
    }
}
