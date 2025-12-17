
public class L774_MinimizeMaxDistancetoGasStation {

    public static void main(String[] args) {
        L774_MinimizeMaxDistancetoGasStation obj = new L774_MinimizeMaxDistancetoGasStation();
        int[] stations = {1,2,3,4,5,6,7,8,9,10};
        int k = 9;
        System.out.println(obj.minmaxGasDist(stations, k));
    }

    // Problem: https://leetcode.ca/2018-01-12-774-Minimize-Max-Distance-to-Gas-Station/
    // Add k new gas stations. Minimize the max distance betweek stations.
    // Idea: We need to apply BS on the range (0, max distance between two stations)
    // Time: O(nlogn)
    public double minmaxGasDist(int[] stations, int k) {
        int n = stations.length;
        double low = 0, high = 0;
        for(int i=0; i<n-1; i++){   // max diff between two stations
            high = Math.max(high, stations[i+1] - stations[i]);
        }

        double ans = -1;
        while(high - low > 1e-6){
            double mid = (low + high)/2.0;
            int cnt = noOfStationsRequired(stations, mid);
            if(cnt <= k){
                ans = mid;
                high = mid;
            }else{
                low = mid;
            }
        }

        return ans;
    }

    private int noOfStationsRequired(int[] stations, double dist) {
        int n = stations.length;
        int cnt = 0;
        for(int i=0; i<n-1; i++){
            cnt += Math.ceil((stations[i+1] - stations[i])/dist) - 1;
        }
        return cnt;
    }
}
