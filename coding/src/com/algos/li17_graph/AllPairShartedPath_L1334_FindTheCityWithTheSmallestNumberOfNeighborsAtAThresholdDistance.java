package  com.algos.li17_graph;

import java.util.Arrays;

public class AllPairShartedPath_L1334_FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
    public static void main(String[] args) {
        AllPairShartedPath_L1334_FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance obj = new AllPairShartedPath_L1334_FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance();

        int[][] edges = new int[][]{{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        System.out.println(obj.findTheCity(4, edges, 4));
    }

    // Problem: https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
    // Idea: Apply floyed warshal algo and find shortest path to all nodes.
    // Then count the cities whose distance id <= threshould for each city.
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int i=0; i<n; i++) 
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        for(int[] edge: edges){
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }
        for(int i=0;i<n; i++) 
            dist[i][i] = 0;

        for(int k=0; k<n; k++){   // floyd warshall
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE)
                        continue;

                    if(dist[i][k]+dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k]+dist[k][j];
                }
            }
        }

        int cityCnt = n, cityNo = -1;
        for(int city=0; city<n; city++){
            int count=0;
            for(int adjCity = 0; adjCity<n; adjCity++){
                if(dist[city][adjCity] <= distanceThreshold)
                    count++;
            }
            if(count<=cityCnt){
                cityCnt = count;
                cityNo = city;
            }
        }

        return cityNo;
    }
}
