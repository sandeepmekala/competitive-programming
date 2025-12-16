
import java.util.Arrays;

public class DP_MaxDistanceWithFuelConstraints {

    public static int getMaxDistance(int[] speed, int capacity) {
        int n = speed.length;
        // Create a 2D DP array initialized with -1
        int[][] dp = new int[n][capacity + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        // Starting from 0th day with full fuel capacity
        return getMaxDistanceHelper(0, capacity, speed, capacity, dp);
    }

    private static int getMaxDistanceHelper(int day, int fuelLeft, int[] speed, int capacity, int[][] dp) {
        if (day == speed.length) return 0;
        if (dp[day][fuelLeft] != -1) return dp[day][fuelLeft];

        // Option 1: Skip the day to refuel
        int refuelOption = (fuelLeft < capacity) ? getMaxDistanceHelper(day + 1, fuelLeft + 1, speed, capacity, dp) : 0;

        // Option 2: Drive on this day if there's fuel left
        int driveOption = (fuelLeft > 0) ? speed[day] + getMaxDistanceHelper(day + 1, fuelLeft - 1, speed, capacity, dp) : 0;

        // Take the maximum of both options
        dp[day][fuelLeft] = Math.max(refuelOption, driveOption);

        return dp[day][fuelLeft];
    }

    public static void main(String[] args) {
        int[] speed = {5, 30, 0, 25, 0, 1, 9};
        int capacity = 3;
        System.out.println("Maximum distance: " + getMaxDistance(speed, capacity));
    }
}
