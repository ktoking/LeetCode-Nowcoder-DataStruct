package LeetCode.D2024;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kaiyi.wang
 * @ClassName Test_12_04__695.java
 * @Description
 * @createTime 2024/12/04
 */
public class Test_12_04__695 {

    //查找最大的连通面积 dfs
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        return 1 + dfs(grid, r - 1, c) + dfs(grid, r + 1, c) + dfs(grid, r, c - 1) + dfs(grid, r, c + 1);
    }


    // bfs
    public int maxAreaOfIsland1(int[][] grid) {
        if (grid == null || grid.length == 0) {  //合理性校验
            return 0;
        }
        int maxArea = 0;
        Queue<Pair<Integer, Integer>> queue = new LinkedList();
        int[][] moveIndexArray = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int count = 0;
                if (grid[i][j] == 1) {
                    queue.offer(new Pair<>(i, j));
                    while (!queue.isEmpty()) {
                        Pair<Integer, Integer> poll = queue.poll();
                        Integer r = poll.getKey();
                        Integer c = poll.getValue();

                        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
                            continue;
                        }
                        count++;
                        grid[r][c] = 0;
                        for (int[] moveIndex : moveIndexArray) {
                            queue.offer(new Pair<>(r + moveIndex[0], c + moveIndex[1]));
                        }
                    }
                }
                maxArea = Math.max(maxArea, count);
            }
        }
        return maxArea;
    }


}
