package com.algos.company.google;

public class SlidingWindow_BankTransactionMaxService {

    public static int maxTransactions(int initAmount, int[] transactions) {
        int maxServed = 0;
        int currBal = initAmount;
        int l = 0, r = 0, n = transactions.length;

        while (r < n) {
            currBal += transactions[r];

            // Adjust the start pointer if the balance goes negative
            while (currBal < 0 && l <= r) {
                currBal -= transactions[l];
                l++;
            }

            // Update the maximum number of transactions served
            maxServed = Math.max(maxServed, r - l + 1);
            r++;
        }

        return maxServed;
    }

    public static void main(String[] args) {
        int initialAmount = 1;
        int[] transactions = {1, -4, -1};
        System.out.println(maxTransactions(initialAmount, transactions)); // Output: 3
    }
}
