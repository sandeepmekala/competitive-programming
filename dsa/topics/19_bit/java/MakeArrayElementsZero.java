public class MakeArrayElementsZero {

	public static void main(String[] args) {
		MakeArrayElementsZero obj = new MakeArrayElementsZero();

		int[] nums = new int[] {3,5,6};
		System.out.println(obj.makeArrayEmelentsZero(nums));
	}

	// Idea: Numbers can be paired and XoR can be applied.
	// xor will be canceling all the even number of 1's.
	// So we should make sure there are even 1's at each bit position to achieve this.
	public boolean makeArrayEmelentsZero(int[] nums) {
		for(int i=0; i<32; i++) {
			int bitCount = 0;
			for(int j=0; j<nums.length; j++) {
				if(((nums[j]>>i)&1) == 1)
					bitCount++;
			}
			if(bitCount%2 != 0) {
				return false;
			}
		}
		return true;
	}

}
