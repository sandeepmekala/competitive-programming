package li05_binarysearch;

public class L1482_MinimumNumberofDaystoMakemBouquets {
    public static void main(String[] args) {
        L1482_MinimumNumberofDaystoMakemBouquets obj = new L1482_MinimumNumberofDaystoMakemBouquets();
        int[] bloomDay = {1,10,3,10,2};
        int m = 3, k = 1;
        System.out.println(obj.minDays(bloomDay, m, k));
    }

    // Problem: https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
    // Idea: BS on the range of min and max bloom day
    // Time: O(nlog(max-min))
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(n < ((long)m)*((long)k)) return -1;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int bday: bloomDay){
            min = Math.min(min, bday);
            max = Math.max(max, bday);
        }

        int low = min, high = max, ans = high;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canMake(bloomDay, mid, m, k)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    private boolean canMake(int[] bloomDay, int mid, int m, int k) {
        int cnt=0, bouq=0;
        for(int bday: bloomDay){
            if(bday <= mid){
                cnt++;
            }else{
                bouq += cnt/k;
                cnt=0;
            }
        }
        bouq += cnt/k;
        return bouq >= m;
    }
}
