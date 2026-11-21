// -------LEETCODE 1 : TWO SUM---------

import java.util.*;

public class LeetCode1{
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int toFind = target - nums[i];

            if(map.containsKey(toFind)){
                return new int[]{map.get(toFind), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}