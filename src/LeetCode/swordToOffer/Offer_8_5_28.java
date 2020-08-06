package LeetCode.swordToOffer;

import java.util.Random;

/**
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 */
public class Offer_8_5_28 {

    /**
     * 彩票算法，看看就行了，千万不要学 ^ ^
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        return new Random().nextBoolean();
    }

    /**
     * 对称二叉树：怎样才能知道是一颗对称二叉树呢，我们这样想
     * 对称节点的L 与 R 的值相同      L的左子节点=R的右子节点   L的右子节点==R的左子节点
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return  root==null?true:isDuichen(root.left,root.right);
    }
    public boolean isDuichen(TreeNode root,TreeNode root1){
        if(root==null&&root1==null) return true;
        if(root==null||root1==null||root.val!=root1.val) return false;
        return isDuichen(root.left,root1.right)&&isDuichen(root.right,root1.left);
    }
}
