
import java.util.Arrays;

public class SearchRange {

	public static void main(String[] args) {
		SearchRange obj = new SearchRange();
		System.out.println(Arrays.toString(obj.searchRange(new int[] {5,7,7,8,8,10}, 8)));
	}

	 public int[] searchRange(int[] nums, int target) {
	        int[] result = new int[]{-1, -1};
	        bs(nums, result, target, 0, nums.length-1);
	        return result;
	    }

	    public void bs(int[] nums, int[] result, int target, int start, int end){
	        if(start <= end){
	            int mid = (start+end)/2;
	            if(nums[mid] ==  target){
	                if(mid < result[0] || result[0] == -1){
	                    result[0] = mid;
	                    bs(nums, result, target, 0, mid-1);
	                }
	                if(mid > result[1]  || result[1] == -1){
	                    result[1] = mid;
	                    bs(nums, result, target, mid+1, nums.length-1);
	                }

	            }else if(target < nums[mid]){
	                bs(nums, result, target, start, mid-1);
	            }else{
	                bs(nums, result, target, mid+1, end);
	            }
	        }
	    }
}
