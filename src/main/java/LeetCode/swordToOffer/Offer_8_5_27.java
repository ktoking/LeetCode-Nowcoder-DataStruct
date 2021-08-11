package LeetCode.swordToOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 */
public class Offer_8_5_27 {

    /**
     * 非递归
     * 镜像二叉树，首先我们利用二叉树的层序遍历方法，利用队列来进行记录需要交换的根节点，让后逐一将根节点的子节点交换
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null) return null;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (queue.size()>0){
            TreeNode poll = queue.poll();
            if(poll.left!=null) queue.offer(poll.left);
            if(poll.right!=null) queue.offer(poll.right);
            TreeNode treeNode=poll.left;
            poll.left=poll.right;
            poll.right=treeNode;
        }
        return root;
    }

    /**
     * 递归解法 类似二叉树后序遍历
     * 首先递归获取到当前根节点的两个子节点，然后当前根节点交换子节点
     * @param root
     * @return
     */
    public TreeNode mirrorTree1(TreeNode root) {
        if(root==null) return null;
        TreeNode left=mirrorTree(root.left);
        TreeNode right=mirrorTree(root.right);
        root.left=right;
        root.right=left;
        return root;
    }
}
