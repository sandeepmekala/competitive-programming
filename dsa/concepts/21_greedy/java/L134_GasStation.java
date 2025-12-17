public class L134_GasStation {

	public static void main(String[] args) {
		L134_GasStation obj = new L134_GasStation();

		int[] gas =  {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		System.out.println(obj.canCompleteCircuit(gas, cost));
	}

	// Problem: https://leetcode.com/problems/gas-station/
	// Idea: Total available gas should >= needed gas to travel all the positions in circular passion. Otherwise there is not solution.
	// Find the gas that accumulates from starting from each position. If the accumulation is +ve track the starting index.
	// If we reach the end, means we have accumulated some gas that can be used to travel the initial positions as total gas is >= total cost.
	// If total becomes -ve, then reset total and index. This means from where ever we started, we don't have enough gas to complete circle.
	// This new position can't be on the left side of current position. If yes, we would have tracked position from there only.
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, n=gas.length;
        for(int i=0; i<n; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalGas < totalCost)
            return -1;

        int total = 0, index = -1;
        for(int i=0; i<n; i++){
            total += gas[i]-cost[i];
            if(total < 0){
                total = 0;
                index = -1;
                continue;
            }

            if(total >= 0 && index == -1){
                index = i;
            }
        }

        return index;
    }
}
