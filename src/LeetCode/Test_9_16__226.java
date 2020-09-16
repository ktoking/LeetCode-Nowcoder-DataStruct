package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 */
public class Test_9_16__226 {

    /**
     * 反转二叉树,前序遍历
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode temp=root.right;    // 保存右子树
        root.right=invertTree(root.left);  // 交换左右子树的位置
        root.left=invertTree(temp.right);
        return root;
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root) {
        if(root==null){
            return null;
        }
        invertTree1(root.left); // 递归找到左节点
        TreeNode temp=root.right; // 保存右节点
        root.right=root.left;
        root.left=temp;
       // 递归找到右节点 继续交换 : 因为此时左右节点已经交换了,所以此时的右节点为root.left
        invertTree(root.left);
        return  root;
    }

    /**
     * 后序遍历
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if(root==null) return null;
        TreeNode left=invertTree2(root.left); //递归找到左节点
        TreeNode right=invertTree2(root.right);//递归找到右节点
        root.left=right; //交换,从下往上
        root.right=left;
        return root;
    }

    /**
     * 层次遍历,直接交换就行了
     * @param root
     * @return
     */
    public TreeNode invertTree3(TreeNode root) {
        if(root==null) return null;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll.left!=null){queue.offer(poll.left);}
            if(poll.right!=null){queue.offer(poll.right);}
            TreeNode left1=poll.left;
            poll.left=poll.right;
            poll.right=left1;
        }
        return root;
    }
}
