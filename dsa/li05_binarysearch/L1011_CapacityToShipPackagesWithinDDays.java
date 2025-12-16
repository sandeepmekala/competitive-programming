package li05_binarysearch;

public class L1011_CapacityToShipPackagesWithinDDays {

    public static void main(String[] args) {
        L1011_CapacityToShipPackagesWithinDDays obj = new L1011_CapacityToShipPackagesWithinDDays();
        System.out.println(obj.shipWithinDays(new int[] {1,2,3,4,5,6,7,8,9,10}, 5));
    }

    // Problem: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
    // Idea: Simple BS on range max(weights) to sum(weights)
    // Time: O(nlogn)
    public int shipWithinDays(int[] weights, int D) {
        int max = Integer.MIN_VALUE, sum = 0;
        for(int wt: weights){
            max = Math.max(max, wt);
            sum += wt;
        }

        int low = max, high = sum, ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;

            int days = findMinDays(weights, mid);
            if(days <= D){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }

    private int findMinDays(int[] weights, int mid) {
        int days = 1, load = 0;
        for(int wt: weights){
            if(load + wt > mid){
                days++;
                load = 0;
            }
            load += wt;
        }
        return days;
    }
}
