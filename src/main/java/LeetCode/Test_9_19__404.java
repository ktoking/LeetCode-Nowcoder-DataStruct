package LeetCode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 */
public class Test_9_19__404 {
    /**
     * 递归来做(只考虑三件事情,不要深入递归)
     * 1.递归结束条件
     * 2.在这个条件下做什么(当前题目做只有左节点不为空且左节点为叶子节点)
     * 3.递归的范围是什么(当前题目考虑左节点,那就要考虑左子树跟右子树的和加上当前条件限制下的值)
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        int res=0;
        if(root.left!=null&&root.left.left==null&&root.left.right==null){
            res+=root.left.val;
        }
        return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right)+res;
    }

    /**
     * 层次遍历,一样的条件
     * @param root
     * @return
     */
    public int sumOfLeftLeaves1(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int res=0;
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll.left!=null) queue.offer(poll.left);
            if(poll.right!=null) queue.offer(poll.right);
            if(poll.left!=null&&poll.left.left==null&&poll.left.right==null){
                res+=poll.left.val;
            }
        }
        return res;
    }
}
