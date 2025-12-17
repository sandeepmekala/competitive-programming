public class L1101_TheEarliestMomentWhenEveryoneBecomeFriends {
    public static void main(String[] args) {
        UnionFind_L1101_TheEarliestMomentWhenEveryoneBecomeFriends obj = new UnionFind_L1101_TheEarliestMomentWhenEveryoneBecomeFriends();

        // [t, x, y] => x and y become friends at time t
        int[][] logs = new int[][]{
            {0,2,0},
            {1,0,1},
            {3,0,3},
            {4,1,2},
            {7,3,1}};
        System.out.println(obj.earliestAcq(logs, 4));
    }

    // Problem: https://leetcode.ca/2018-12-05-1101-The-Earliest-Moment-When-Everyone-Become-Friends/
    // Time: O(nlogn)
    // Follow-up:
    // Two types of logs
    // Add Friend - A and B become friends
    // Remove Friend - If A and B are friends, unfriend them
    public int earliestAcq(int[][] logs, int n) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        int count = n;
        for (int[] log : logs) {
            int p1 = findParent(parent, log[1]);
            int p2 = findParent(parent, log[2]);
            if (p1 != p2) {
                parent[p1] = p2;
                count--;
            }
            if (count == 1) {
                return log[0];
            }
        }
        return -1;
    }

    private int findParent(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = findParent(parent, parent[i]);
        }
        return parent[i];
    }
}
