package LeetCode;

import java.util.*;

/**
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * 通过次数72,045提交次数109,380
 */
public class Test_9_4__257 {
    /**
     * 先序遍历递归做法
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList<>();
        get(root,"",list);
        return list;
    }
    public void get(TreeNode root,String str,List<String> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(str + root.val);
        }
        get(root.left,  str+root.val + "->", list);
        get(root.right, str+root.val + "->", list);
    }

    /**
     * 非递归先序遍历做法
     * @param root
     * @return
     */
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String>list=new ArrayList<>();
        if(root==null) return list;
        Stack<TreeNode> stack=new Stack<>();
        Stack<String> stackStr=new Stack<>();
        stack.push(root);
        stackStr.push(root.val+"");
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            String popStr = stackStr.pop();
            if(pop.left==null&&pop.right==null){
                list.add(popStr);
                continue;
            }
            if(pop.right!=null) {
                stack.push(pop.right);
                stackStr.push(popStr+"->"+pop.right.val);
            }
            if(pop.left!=null){
                stack.push(pop.left);
                stackStr.push(popStr+"->"+pop.left.val);
            }
        }
        return list;
    }

    /**
     * BFS广度优先
     * @param root
     * @return
     */
    public List<String> binaryTreePaths12(TreeNode root) {
        List<String> list=new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> queue=new LinkedList<>();
        Queue<String> queueStr=new LinkedList<>();
        queue.offer(root);
        queueStr.offer(root.val+"");
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            String pollStr = queueStr.poll();
            if(poll.left==null&&poll.right==null){
                list.add(pollStr);
                continue;
            }
            if(poll.left!=null){
                queue.offer(poll.left);
                queueStr.offer(pollStr+"->"+poll.left.val);
            }
            if(poll.right!=null){
                queue.offer(poll.right);
                queueStr.offer(pollStr+"->"+poll.right.val);
            }
        }
        return list;
    }
}
