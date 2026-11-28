// --------------LeetCode 739 : Daily Temperatures-----------------

// OPTIMAL APPROACH : Monotonic Stack
// We will use a stack, but instead of storing temperatures, we will store their indices (day numbers).


import java.util.*;

public class LeetCode739 {
    public static int[] dailyTemperature(int[] temperatures){
        int n = temperatures.length;
        int[] ans  = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int previousIndex = stack.pop();
                ans[previousIndex] = i-previousIndex;
            }
            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperature(temperatures)));
    }
}
