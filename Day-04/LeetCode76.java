// ----------------LeetCode 76 : Minimum Window Substring--------------------

public class LeetCode76 {
    public static String minWindow(String s, String t){
        if(s.length() < t.length()){
            return "";
        }

        int[] need = new int[128];
        int[] window = new int[128];

        for(char ch : t.toCharArray()){
            need[ch]++;
        }

        int required = 0;

        for(int i=0; i<128; i++){
            if(need[i] > 0){
                required++;
            }
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        int formed = 0;

        for(int right=0; right<s.length(); right++){
            char ch = s.charAt(right);
            window[ch]++;

            if(need[ch] > 0 && window[ch] == need[ch]){
                formed++;
            }

            while(required == formed){
                if(right-left+1 < minLen){
                    minLen = right-left+1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                window[leftChar]--;

                if(need[leftChar] > 0 && window[leftChar] < need[leftChar]){
                    formed--;
                }

                left++;
            }
        }

        if(minLen == Integer.MAX_VALUE){
            return "";
        }

        return s.substring(start, start+minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
