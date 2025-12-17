
public class Partitions_L887_SuperEggDrop {
	// Problem: https://leetcode.com/problems/super-egg-drop/
	public int superEggDrop(int eggs, int floors){
        int dp[][] = new int[eggs+1][floors+1];
        for(int i=0; i <= floors; i++)
            dp[1][i] = i;

        for(int e = 2; e <= eggs; e++){
            for(int f = 1; f <=floors; f++){
                int min = Integer.MAX_VALUE;
                for(int k = 1; k<=f ; k++){
                    int moves = 1 + Math.max(dp[e-1][k-1], dp[e][f-k]);
                    if(moves < min){
                        min = moves;
                    }
                }
                dp[e][f] = min;
            }
        }
        return dp[eggs][floors];
    }

    public int calculateRecursive(int eggs, int floors){
        if(eggs == 1)
            return floors;
        if(floors == 0)
            return 0;

        int min = (int)1e9;
        for(int k=1; k <= floors; k++){
            int moves = 1 + Math.max(calculateRecursive(eggs-1, k-1), calculateRecursive(eggs, floors-k));
            if(moves < min){
                min = moves;
            }
        }
        return min;
    }

    public static void main(String args[]){
        Partitions_L887_SuperEggDrop ed = new Partitions_L887_SuperEggDrop();

        int r = ed.superEggDrop(2,6);
        System.out.println(r);
    }

}
