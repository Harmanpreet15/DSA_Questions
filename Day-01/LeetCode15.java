// -----------LEETCODE 15 : 3SUM ---------------

// Sorting + Two Pointers
// IMP POINT - Main thing is to handle the duplicates properly


import java.util.*;

public class LeetCode15 {
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i+1;
            int right = nums.length-1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;

                    while(left < right && nums[left] == nums[left-1]){
                        left++;
                    }

                    while(right > left && nums[right] == nums[right+1]){
                        right--;
                    }
                }else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}


// Complexity: Sorting takes O(n log n), and the two-pointer search takes O(n²)
// Overall: O(n²) time and O(1) auxiliary space excluding sorting and the output.