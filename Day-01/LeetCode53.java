// ----------- LEETCODE 53 : MAXIMUM SUBARRAY------------

// Array + Kadane's Algorithm

// Kadane's Algorithm – 
// We maintain two variables:
// - currentSum: Maximum subarray sum ending at the current position.
// - maxSum: Maximum subarray sum found so far.

public class LeetCode53 {
    public static int maxSubArray(int[] nums){
        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i=1; i<nums.length; i++){
            currentSum = Math.max(currentSum+nums[i], nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
