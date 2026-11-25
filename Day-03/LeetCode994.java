// LeetCode 994 : Rotting Oranges-----------------

import java.util.*;

public class LeetCode994 {

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int fresh= 0;
        int minutes = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int[][] directions = {
            {-1, 0}, 
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while(!q.isEmpty() && fresh > 0){
            int size = q.size();

            for(int i=0; i<size; i++){
                int[] current = q.poll();
            
                int row = current[0];
                int col = current[1];

                for(int[] dir : directions){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        fresh--;

                        q.offer(new int[]{newRow, newCol});
                    }
                }
            }
            minutes++;

        }

        return fresh == 0 ? minutes : -1;
    }

    public static void main(String[] args) {

        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        System.out.println(orangesRotting(grid));
    }
}
