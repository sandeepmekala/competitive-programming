
public class RowWithMaximumNumberof1s {

        public static void main(String[] args) {
            RowWithMaximumNumberof1s obj = new RowWithMaximumNumberof1s();
            int[][] mat = {
                    {0, 0, 0, 1},
                    {0, 1, 1, 1},
                    {1, 1, 1, 1},
                    {0, 0, 0, 0}
            };
            System.out.println(obj.rowWithMax1s(mat));
        }

        // Problem: https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1
        // Idea: Start from top right corner, if 1 is found, move left, else move down
        // Time: O(n+m)
        public int rowWithMax1s(int[][] mat) {
            int r = mat.length, c = mat[0].length;
            int max1s = 0, row = -1;
            for(int i=0; i<r; i++){
                int idx = lowerBound(mat[i], 1);
                if(c-idx > max1s){
                    max1s = c-idx;
                    row = i;
                }
            }

            return row;
        }

        private int lowerBound(int[] nums, int target) {
            int n = nums.length;
            int low = 0, high=n-1, res=n;
            while(low<=high){
                int mid = (low+high)/2;
                if(nums[mid] >= target){
                    res = mid;
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }

            return res;
        }
}
