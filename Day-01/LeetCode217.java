// -------------217. Contains Duplicate-------------

// One straightforward approach is to use two nested loops
// - Pick one element, compare it with every other element
// - If you find the same element, return true else false
// But this takes O(n^2) time.

// WE USE HASHSET HERE - A HashSet is a data structure in Java that stores only unique elements.


import java.util.*;

public class LeetCode217 {
    public static boolean containsDuplicate(int[] nums){
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            if(!set.add(num)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));

    }
}



// we can also write like -

// if(set.contains(num)){
//     return true;
// }
// set.add(nums);

// but above one is the most optimal one
