package edu.algos.li08.greedy;

public class GasStation {

	public static void main(String[] args) {
		GasStation obj = new GasStation();
		
		int[] gas = new int[] {1,2,3,4,5};
		int[] cost = new int[] {3,4,5,1,2};
		System.out.println(obj.canCompleteCircuit(gas, cost));
	}

	/*
	 * Problem: each position has some gas and needed gas to move to next position. find the start index from where	we can travel all the positions in circular order.
	 * Concept: total available gas should >= needed gas to travel all the positions in circular passion. otherwise there is not solution.
	 * find the gas that accumulates from starting from each position. If the accumulation is +vs track the starting index.
	 * if we reach the end, means we have accumulated some gas that can be used to travel the initial positions.
	 * if total becomes -ve, then reset total and index. this means from where ever we started, we don't have enough gas to complete circle.
	 * this new position can't be on the left side of current position, if yes, we would have tracked position from there only. So, it will be on the right side of current position which we will find if total become +ve again.
	 * 
	 * */
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, n=gas.length;
        for(int i=0; i<n; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        
        if(totalGas < totalCost){
            return -1;
        }
        
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
