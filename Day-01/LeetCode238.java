// -----------238. Product of Array Except Self-------------

import java.util.*;

public class LeetCode238 {
    public static int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] res = new int[n];

        int prefix = 1;
        for(int i=0; i<n; i++){
            res[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for(int i=n-1; i>=0; i--){
            res[i] *= suffix;
            suffix *= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}


// Why do we update after multiplying?
// ---Because the question says exclude the current element.