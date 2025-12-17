import java.util.LinkedList;
import java.util.Queue;

public class ValidTournamentDraw {
    public static void main(String args[]) {
        Queue_ValidTournamentDraw obj = new Queue_ValidTournamentDraw();

        int[] nums1 = {1,8,4,5,3,6,2,7};
        int[] nums2 = {1,2,3,4};
        System.out.println(obj.isValid(nums1)); // valid
        System.out.println(obj.isValid(nums2)); // invalid
    }

    // Problem:
    // https://leetcode.com/discuss/interview-question/5004476/Google-L5-Round-1
    public boolean isValid(int nums[]) {
        int n = nums.length;

        if (n % 2 != 0)
            return false;

        Queue<Integer> q = new LinkedList<>();

        for (int num : nums) {
            q.add(num);
        }

        while (q.size() > 1) {
            int player1 = q.remove();
            int player2 = q.remove();

            if (player1 + player2 != n + 1)
                return false;

            q.add(Math.min(player1, player2));
        }

        return true;

    }
}
