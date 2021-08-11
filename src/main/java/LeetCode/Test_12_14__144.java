package LeetCode;

import java.util.*;

/**
 *
 * 题目描述
 * 评论 (684)
 * 题解 (1.1k)
 * 提交记录
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 */
public class Test_12_14__144 {

    /**
     * 非递归前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        TreeNode temp=root;
        Stack<TreeNode> stack =new Stack<>();
        while (!stack.isEmpty()||temp!=null){
            if(temp!=null){
                list.add(temp.val);
                stack.push(temp);
                temp=temp.left;
            }else {
                TreeNode pop = stack.pop();
                temp=pop.right;
            }
        }
        return list;
    }
}
