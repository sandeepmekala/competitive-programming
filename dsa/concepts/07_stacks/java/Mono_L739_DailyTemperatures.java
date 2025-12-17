
import java.util.Arrays;
import java.util.Stack;

public class Mono_L739_DailyTemperatures {

	public static void main(String[] args) {
		Mono_L739_DailyTemperatures obj = new Mono_L739_DailyTemperatures();

		System.out.println(Arrays.toString(obj.dailyTemperatures(new int[] {73,74,75,71,69,72,76,73})));
	}

    // Problem: https://leetcode.com/problems/daily-temperatures/
    // Idea: Same as nge. Go right to left and build monotonically decreasing stack.
	public int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temps[stack.peek()] <= temps[i]) {
                stack.pop();
            }

            if (stack.isEmpty())
                nge[i] = 0;
            else
                nge[i] = stack.peek()-i;

            stack.push(i);
        }

        return nge;
    }
}
