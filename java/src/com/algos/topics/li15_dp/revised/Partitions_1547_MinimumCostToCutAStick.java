package  com.algos.topics.li15_dp.revised;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Partitions_1547_MinimumCostToCutAStick {
    public static void main(String[] args) {
        Partitions_1547_MinimumCostToCutAStick obj = new Partitions_1547_MinimumCostToCutAStick();

        int n = 7;
        int [] cuts = new int[]{1,3,4,5};
        System.out.println(obj.minCost(n, cuts));
        System.out.println(obj.minCost2(n, cuts));
    }

    // Problem: https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
    // Idea: As we can partition at any index, we apply partition db technique to run k for all possible partion posisions.
    // For every cut we need previou upper cut and lower cut. Their difference gives the stick length.
    // For left most and right most cuts, there won't be their corresponding lower and hight cut values.
    // Hence, we insert 0 and stick lens as those are treated as initial cuts.
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        List<Integer> list = Arrays.stream(cuts).boxed().collect(Collectors.toList());
		list.add(0, 0);
		list.add(n);
        Collections.sort(list);

        int[][] costs = new int[c+2][c+2];
        for(int i=c; i>=1; i--){
            for(int j=1; j<=c; j++){
                if(i>j) continue;

                Integer min = Integer.MAX_VALUE;
                for(int k=i; k<=j; k++){
                    int cost = list.get(j+1)-list.get(i-1) +
                    costs[i][k-1] + costs[k+1][j];

                    min = Math.min(min, cost);
                }
                costs[i][j] = min;
            }
        }

        return costs[1][c];
    }

    public int minCost2(int n, int[] cuts) {
        int c = cuts.length;
        int[] cutsTemp = new int[c+2];
        cutsTemp[0] = 0;
        cutsTemp[c+1] = n;
        for(int i=0; i<c; i++)
            cutsTemp[i+1] = cuts[i];
        Arrays.sort(cutsTemp);

        return minCost2(1, c, cutsTemp);
    }

    private int minCost2(int i, int j, int[] cuts) {
        if(j<i)
            return 0;

        Integer min = Integer.MAX_VALUE;
        for(int k=i; k<=j; k++){
            int cost = cuts[j+1]-cuts[i-1] +
            minCost2(i, k-1, cuts) + minCost2(k+1, j, cuts);

            min = Math.min(min, cost);
        }
        return min;
    }
}
