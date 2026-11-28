// -------------------LeetCode 84 : Largest Rectangle in Histogram-----------------------

import java.util.*;

public class LeetCode84 {
    public static int largestRectangleArea(int[] heights){
        int n = heights.length;
        int maxArea = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<=n; i++){
            int currHeight = (i==n) ? 0 : heights[i];

            while(!stack.isEmpty() && heights[stack.peek()] >= currHeight){
                int poppedIndex = stack.pop();
                int height = heights[poppedIndex];
                int left;

                if(stack.isEmpty()){
                    left = -1;
                }else{
                    left = stack.peek();
                }

                int width = i-left-1;
                int area = width * height;

                maxArea = Math.max(area, maxArea);
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}
