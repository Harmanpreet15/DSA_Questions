// ---------LeetCode 11 : Container With Most Water------------

// Two Pointers + Greedy problem

public class LeetCode11 {
    public static int maxArea(int[] height){
        int left = 0;
        int right = height.length-1;

        int maxArea = Integer.MIN_VALUE;

        while(left < right){
            int width = right-left;
            int length = Math.min(height[right], height[left]);

            int area = width*length;

            maxArea = Math.max(area, maxArea);

            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }
        }

        return maxArea;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));

    }
}
