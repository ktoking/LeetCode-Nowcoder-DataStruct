package LeetCode.swordToOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 *
 * 提示：
 *
 * 节点总数 <= 10000
 * 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
 */
public class Offer_9_9_34 {
    /**
     * 回溯大法,每层去加,回溯去找路径,稍微与回溯模板不同,这次处理list数据放在上面,最后都移除掉
     */
    List<List<Integer>> lists=new ArrayList<>();
    int sum;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum=sum;
        huisu(new ArrayList<>(),0,root);
        return lists;
    }
    public void huisu(List<Integer> list,int cur,TreeNode root){
       if(root==null) return;
       list.add(root.val);
       cur+=root.val;
       if(cur==sum&&root.left==null&&root.right==null){
           lists.add(new ArrayList<>(list));
       }
       huisu(list,cur,root.left);
       huisu(list,cur,root.right);
       list.remove(list.size()-1);
    }


}
