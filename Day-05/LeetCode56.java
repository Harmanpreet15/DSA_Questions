// --------------LeetCode 56 : Merge Intervals-----------------


import java.util.*;

public class LeetCode56 {
    public static int[][] merge(int[][] intervals){
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        for(int[] interval : intervals){
            if(result.isEmpty() || result.get(result.size()-1)[1] < interval[0]){
                result.add(interval);
            }

            int[] previous = result.get(result.size()-1);
            previous[1] = Math.max(previous[1], interval[1]);
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
            {1,3},
            {2,6},
            {8,10},
            {15,18}
        };

        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
