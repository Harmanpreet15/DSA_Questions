// ------------LeetCode 5 : Longest Palindromic Substring--------------


// We will use two pointer technique
// There are two case - 
// 1. odd palindrome : left, right = i
// 2. even palindrome : left = i, right = i+1


public class LeetCode5 {
    public static String longestPalindrome(String s){
        int start = 0;
        int maxLength = 0;

        for(int i=0; i<s.length(); i++){
            int left = i;
            int right = i;
            
            while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                if(right-left+1 > maxLength){
                    start = left;
                    maxLength = right-left+1;
                }

                left--;
                right++;
            }

            left = i;
            right = i+1;

            while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                if(right-left+1 > maxLength){
                    start = left;
                    maxLength = right-left+1;
                }

                left--;
                right++;
            }
        }

        return s.substring(start, start+maxLength);

    }
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));

    }
}
