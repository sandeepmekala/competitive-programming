package li01_array;

public class L287_FindTheDuplicateNumber {

	public static void main(String[] args) {
		L287_FindTheDuplicateNumber obj = new L287_FindTheDuplicateNumber();
		System.out.println(obj.findDuplicate(new int[] {1,3,4,2,2}));
	}

    /*  Problem: https://leetcode.com/problems/find-the-duplicate-number/
        Idea:
	 	    Step 1: Detect cycle using FCD.
	 	    Step 2: Place one pointer at head of LL | Another pointer should be at the point where fast and slow meet.
		    Step 3: Move 1st pointer and 2nd pointer by one step each.
		    Step 4: Both will meet again at entry point of cycle.
     */
	public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                break;
            }
        }

        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

}
