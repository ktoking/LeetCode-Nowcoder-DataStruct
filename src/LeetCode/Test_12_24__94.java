package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 */
public class Test_12_24__94 {

    /**
     * 非递归中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode temp=root;
        while (temp!=null||!stack.isEmpty()){
            if(temp!=null){
                stack.push(temp);
                temp=temp.left;
            }else {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                temp=pop.right;
            }
        }
        return list;
    }
}
