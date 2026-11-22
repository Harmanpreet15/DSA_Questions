// --------LEETCODE 152 : Maximum Product Subarray------------


// WE WILL USE KADANE'S ALGORITHM BUT INSTEAD OF MAINTAINING TWO VARIABLES WE USE 3 HERE
// maxProd, minProd, ans because neg neg become positive 

public class LeetCode152 {
    public static int maxProd(int[] nums){
        int maxProd = nums[0];
        int minProd = nums[0];
        int ans = nums[0];

        for(int i=1; i<nums.length; i++){
            int newMax = Math.max(nums[i], Math.max(nums[i]*maxProd, nums[i]*minProd));
            int newMin = Math.min(nums[i], Math.min(nums[i]*maxProd, nums[i]*minProd));

            maxProd = newMax;
            minProd = newMin;

            ans = Math.max(ans, maxProd);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProd(nums));
    }
}
