// ------------LeetCode 394 : Decode String----------------

// we will use here 2 stacks technique


import java.util.*;

public class LeetCode394 {
    public static String decodeString(String s){
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        int digit = 0;
        StringBuilder currString = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                digit = digit*10 + (ch-'0');
            }else if(ch == '['){
                countStack.push(digit);
                stringStack.push(currString);

                digit = 0;
                currString = new StringBuilder();
            }else if(ch == ']'){
                int repeat = countStack.pop();
                StringBuilder prevString = stringStack.pop();

                for(int j=0; j<repeat; j++){
                    prevString.append(currString);
                }

                currString = prevString;

            }else{
                currString.append(ch);
            }
        }

        return currString.toString();

    }
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }
}
