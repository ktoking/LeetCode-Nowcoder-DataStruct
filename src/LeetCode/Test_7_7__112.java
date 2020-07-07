package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode1 {
      int val;
      TreeNode1 left;
      TreeNode1 right;
      TreeNode1(int x) { val = x; }
  }

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_7_7__112 {

    public static void main(String[] args) {

    }

    /**
     *  递归找值
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode1 root, int sum) {

        if(root==null) return false;

        if(root.left==null&&root.right==null){  //意思是当到达叶子节点的时候,判断每一步减到叶子节点剩下的值等不等于当前叶子节点的值
            return root.val==sum;
        }
        //向左向右递归找
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);

    }


    /**
     * 用两个栈,层次遍历,一个栈存当前根节点,另一个栈存相加的值,每次左右节点不为空的话,就在第一个栈加入左右节点,在另一个栈中加入从第一个栈中取出的上一个节点的值与当前左右节点的值加到第二个栈中
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum1(TreeNode1 root, int sum) {
        if(root==null) return false;
        Queue<TreeNode1> queue1=new LinkedList();
        Queue<Integer> queue2=new LinkedList();
        queue1.offer(root);
        queue2.offer(root.val);
        while (!queue1.isEmpty()){

            TreeNode1 now = queue1.poll();
            Integer temp = queue2.poll();

            if(now.left==null&&now.right==null){
                if(temp==sum){
                    return true;
                }
                continue;
            }
            if(now.left!=null){
                queue1.add(now.left);
                queue2.add(now.left.val+temp);
            }
            if(now.right!=null){
                queue1.add(now.right);
                queue2.add(now.right.val+temp);
            }

        }
        return false;
    }
}
