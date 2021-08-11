package LeetCode.swordToOffer;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *
 *
 * 限制：
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 */
public class offer_11_3_54 {
    /**
     * 通过中序遍历二叉搜索树,先右子树后左子树来递增的拿到序列,第k大就是第几次遍历
     */
    int ans=0,time=0;
    public int kthLargest(TreeNode root, int k) {
        get(root,k);
        return ans;
    }
    public void get(TreeNode root,int k){
        if(root.right!=null) get(root.right,k);
        if(++time==k){
            ans=root.val;
            return;
        }
        if(root.left!=null) get(root.left,k);
    }
}
