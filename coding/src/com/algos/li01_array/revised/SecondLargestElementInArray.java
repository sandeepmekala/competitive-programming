package com.algos.li01_array.revised;

public class SecondLargestElementInArray {
    
        public static void main(String[] args) {
            SecondLargestElementInArray obj = new SecondLargestElementInArray();
            int[] arr = { 12, 35, 1, 10, 34, 1 };

            System.out.println(obj.findSecondLargest(arr));
        }
        
        // Problem: Find the second largest element in an array
        public int findSecondLargest(int[] nums){
            int n = nums.length;
            int first = Integer.MIN_VALUE;
            int second = Integer.MIN_VALUE;
            for(int i=0; i<n; i++){
                if(nums[i] > first){
                    second = first;
                    first = nums[i];
                }else if(nums[i] > second && nums[i] != first){
                    second = nums[i];
                }
            }
            return second;
        }
}
