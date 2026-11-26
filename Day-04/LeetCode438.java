// -----------LeetCode 438 : Find All Anagrams in a String--------------

// WE USE FIXED SIZE SLIDING WINDOW HERE 


import java.util.*;

public class LeetCode438 {
    public static List<Integer> findAnagrams(String s, String p){
        List<Integer> res = new ArrayList<>();

        if(s.length() < p.length()){
            return res;
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for(char ch : p.toCharArray()){
            pCount[ch - 'a']++;
        }

        int k = p.length();

        for(int i=0; i<s.length(); i++){
            sCount[s.charAt(i) - 'a']++;

            if(i >= k){
                sCount[s.charAt(i-k) - 'a']--;
            }

            if(Arrays.equals(sCount, pCount)){
                res.add(i-k+1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
    }
}
