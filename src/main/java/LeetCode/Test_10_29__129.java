package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 129. 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 */
public class Test_10_29__129 {
    /**
     * 二叉树层次遍历解决
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        Queue<String> queueStr=new LinkedList<>();
        queue.offer(root);
        queueStr.offer(root.val+"");
        List<String> list=new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            String intstr = queueStr.poll();
            if(poll.left==null&&poll.right==null){
                list.add(intstr);
                continue;
            }
            if(poll.left!=null){
                queue.offer(poll.left);
                queueStr.offer(intstr+poll.left.val);
            }
            if(poll.right!=null){
                queue.offer(poll.right);
                queueStr.offer(intstr+poll.right.val);
            }
        }
        int count=0;
        for (String s : list) {
            count+=Integer.parseInt(s);
        }
        return count;
    }

    /**
     * 递归来做这件事,首先考虑先序遍历,隐含回溯 ->这边类似于力扣257
     */
    int sum=0;
    public int sumNumbers1(TreeNode root) {
        get(0,root);
        return sum;
    }
    public void get(int val,TreeNode temp){
        if(temp==null) return;
        int k=val*10+temp.val;
        if(temp.left==null&&temp.right==null){
            sum+=k;
        }
        get(k,temp.left);
        get(k,temp.right);
    }
}
