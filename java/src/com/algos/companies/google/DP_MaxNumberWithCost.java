package com.algos.companies.google;

public class DP_MaxNumberWithCost {
    String maxNumber = "";

    public static void main(String[] args) {
        // Cost for digits 9 to 1
        int[] cost = { 2, 3, 4, 1, 7, 8, 2, 3, 4 };
        int budget = 15;
        DP_MaxNumberWithCost maxNumberWithCost = new DP_MaxNumberWithCost();
        maxNumberWithCost.findMaxNumberWithCost(cost, budget);
        System.out.println(maxNumberWithCost.maxNumber);
    }

    public void findMaxNumberWithCost(int[] cost, int budget) {
        StringBuilder currentNumber = new StringBuilder();
        buildNumber(cost, currentNumber, 0, budget);
    }

    private void buildNumber(int[] cost, StringBuilder currentNumber, int digitIndex, int remainingBudget) {
        if (digitIndex == cost.length || remainingBudget == 0) {
            if (currentNumber.length() > maxNumber.length()) {
                maxNumber = currentNumber.toString();
            }
            return;
        }

        if (cost[digitIndex] > remainingBudget) {
            buildNumber(cost, currentNumber, digitIndex + 1, remainingBudget);
        } else {
            currentNumber.append(9 - digitIndex);
            buildNumber(cost, currentNumber, digitIndex, remainingBudget - cost[digitIndex]);
            currentNumber.deleteCharAt(currentNumber.length() - 1);
            buildNumber(cost, currentNumber, digitIndex + 1, remainingBudget);
        }
    }
}
