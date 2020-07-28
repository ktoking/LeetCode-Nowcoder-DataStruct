package LeetCode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_7_28__104 {

    /**
     * DFS
     * 递归寻找最大深度,从左子树与右子树找出最大深度就行了
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;

        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    /**
     * 广度优先BFS
     * 广度优先必用队列
     * 首先记住当前队列的长度,然后用一个循环将当前队列队头不断出队,左右节点不断入队,当循环结束后,这一层的节点就被遍历完了,队列中的元素就是下一层队列的节点了,然后继续重复上一步操作直到队列为空,每一层计数+1即可
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        int count=0;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            while (size>0){
               TreeNode node = queue.poll();
               if(node.left!=null){
                   queue.offer(node.left);
               }
               if(node.right!=null){
                   queue.offer(node.right);
               }
               size--;
           }
           count++;
        }
        return count;
    }

}
