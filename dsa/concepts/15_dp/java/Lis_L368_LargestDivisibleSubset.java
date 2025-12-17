
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lis_L368_LargestDivisibleSubset {
    public static void main(String[] args) {
        Lis_L368_LargestDivisibleSubset obj = new Lis_L368_LargestDivisibleSubset();

        int[] nums = new int[]{1,2,4,8};
        System.out.println(obj.largestDivisibleSubset(nums));
    }

    // Proble: https://leetcode.com/problems/largest-divisible-subset/
    // Idea: Sort the nums. Apply the logic of lis but check divisibility instead of increasibility.
    // Nums need to be sort to maintain the transitive divisibility property.
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] lds = new int[n];
        int[] parent = new int[n];
        for(int i=0; i<n; i++){
            lds[i] = 1;
            parent[i] = i;
        }
        int max = 0, maxInd = 0;
        for(int i=1; i<n; i++){
            for(int j=0;j<i; j++){
                if(nums[i]%nums[j] == 0){
                    if(lds[j]+1 > lds[i]){
                        lds[i] = 1+lds[j];
                        parent[i] = j;
                    }
                }
            }
            if(lds[i] > max){
                max = lds[i];
                maxInd = i;
            }
        }

        return getLds(nums, parent, maxInd);
    }

    private List<Integer> getLds(int[] nums, int[] parent, int largestInd) {
        List<Integer> lds = new ArrayList<>();
        while(largestInd != parent[largestInd]){
            lds.add(nums[largestInd]);
            largestInd = parent[largestInd];
        }
        lds.add(nums[largestInd]);
        Collections.reverse(lds);
        return lds;
    }
}
