package LeetCode;

/**
 * 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 *
 * 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
 */
public class Test_9_21__538 {
    /**
     * 反中序遍历即可
     */
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        reverse(root);
        return root;
    }
    public void reverse(TreeNode root) {
        if(root==null) return;
        reverse(root.right);
        sum+=root.val;
        root.val=sum;
        reverse(root.left);
    }
}
