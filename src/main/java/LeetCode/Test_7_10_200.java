package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_7_10_200 {


    /**
     * 广度优先,利用一个队列,找到为1的岛屿就将它的横纵坐标插入队列中,然后不断循环广度优先将周围岛屿标记为0
     * @param grid
     * @return
     */
    public int numIslandsBfs(char[][] grid) {
        if(grid==null||grid.length==0){  //合理性校验
            return 0;
        }
        Queue<Integer> queue=new LinkedList<>(); //队列存取元素
        int count=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1'){  //遍历二维数组每一个元素,当有1的时候,我们将岛屿数量++,并且进入广度优先搜索
                    count++;        //找到岛屿就+1
                    grid[i][j]='0'; //并且将当前岛屿标记为0
                    queue.offer(i); //将当前岛屿的横纵坐标插入到队列中
                    queue.offer(j);
                    while (!queue.isEmpty()){ //当队列不为空时,一直广度优先搜索
                         Integer row = queue.poll();
                         Integer col = queue.poll();

                         if(row-1>=0&&grid[row-1][col]=='1'){ //当取出来的横坐标左边的元素>=时,以下分表代表判断当前元素的上左下右,广度遍历
                             queue.offer(row-1);
                             queue.offer(col);
                             grid[row-1][col]='0';
                         }
                        if(col-1>=0&&grid[row][col-1]=='1'){
                            queue.offer(row);
                            queue.offer(col-1);
                            grid[row][col-1]='0';
                        }
                        if(row+1<grid.length&&grid[row+1][col]=='1'){
                            queue.offer(row+1);
                            queue.offer(col);
                            grid[row+1][col]='0';
                        }
                        if(col+1<grid[0].length&&grid[row][col+1]=='1'){
                            queue.offer(row);
                            queue.offer(col+1);
                            grid[row][col+1]='0';
                        }
                    }
                 }
             }
        }
        return count;
    }



    /**
     * 深度优先dfs算法,将有1的连接起来的1的区域标为0
     * @param grid
     * @param r
     * @param c
     */
    public void dfs(char[][] grid,int r,int c){
        int gr=grid.length;
        int gc=grid[0].length;

        if(r<0||c<0||r>=gr||c>=gc|| grid[r][c]=='0'){  //如果 当前坐标小于0或大于数组边界 或者等于0,就立即返回
            return;
        }
        grid[r][c] = '0';   //走过的就标记为0
        dfs(grid,r,c-1); //之后四步,上左下右全部遍历一遍
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c+1);
    }
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0)  //合理性校验
            return 0;
        int count=0;
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1'){  //遍历二维数组每一个元素,当有1的时候,我们将岛屿数量++,并且进入深度优先搜索
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }






}
