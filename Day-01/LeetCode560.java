// -----------LeetCode 560 : Subarray Sum Equals K------------

// BRUTE FORCE : simply double loop and when you find the subarray , increase the COUNT
// OPTIMAL APPROACH : Prefix Sum + HashMap


import java.util.*;

public class LeetCode560 {
    public static int subarraysum(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int sum = 0;
        int count = 0;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            int remaining = sum - k;

            if(map.containsKey(remaining)){
                count += map.get(remaining);
            }

            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 3;

        System.out.println(subarraysum(nums, k));
    }
}
