package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 给定一个无向图graph，当这个图为二分图时返回true。

 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。

 graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。


 示例 1:
 输入: [[1,3], [0,2], [1,3], [0,2]]
 输出: true
 解释:
 无向图如下:
 0----1
 |    |
 |    |
 3----2
 我们可以将节点分成两组: {0, 2} 和 {1, 3}。

 示例 2:
 输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
 输出: false
 解释:
 无向图如下:
 0----1
 | \  |
 |  \ |
 3----2
 我们不能将节点分割成两个独立的子集。
 注意:

 graph 的长度范围为 [1, 100]。
 graph[i] 中的元素的范围为 [0, graph.length - 1]。
 graph[i] 不会包含 i 或者有重复的值。
 图是无向的: 如果j 在 graph[i]里边, 那么 i 也会在 graph[j]里边。
 */
public class Test_7_16__785 {

    public boolean isBipartite(int[][] graph) {
        // 定义 visited 数组，初始值为 0 表示未被访问，赋值为 1 或者 -1 表示两种不同的颜色。
        int[] visited = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        // 因为图中可能含有多个连通域，所以我们需要判断是否存在顶点未被访问，若存在则从它开始再进行一轮 bfs 染色。
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            // 每出队一个顶点，将其所有邻接点染成相反的颜色并入队。
            queue.offer(i);
            visited[i] = 1;
            while (!queue.isEmpty()) {
                int v = queue.poll();
                for (int w: graph[v]) {
                    // 如果当前顶点的某个邻接点已经被染过色了，且颜色和当前顶点相同，说明此无向图无法被正确染色，返回 false。
                    if (visited[w] == visited[v]) {
                        return false;
                    }
                    if (visited[w] == 0) {
                        visited[w] = -visited[v];
                        queue.offer(w);
                    }
                }
            }
        }

        return true;
    }

}
