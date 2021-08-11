package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * 通过次数95,132提交次数168,876
 */
public class Test_12_22__103 {

    /**
     * 利用头插法解决问题,层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        if(root==null) return lists;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            LinkedList<Integer> list=new LinkedList<>();
            while (size-->0){
                TreeNode poll = queue.poll();
                if(poll.left!=null) queue.offer(poll.left);
                if(poll.right!=null) queue.offer(poll.right);
                if(lists.size()%2==0){
                    list.add(poll.val);
                }else {
                    list.addFirst(poll.val);
                }

            }
            lists.add(list);
        }
        return lists;
    }


    /**
     * 层序遍历杀我
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        if(root==null) return lists;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            LinkedList<Integer> list=new LinkedList<>();
            while (size-->0){
                TreeNode poll = queue.poll();
                if(poll.left!=null) queue.offer(poll.left);
                if(poll.right!=null) queue.offer(poll.right);
                if(lists.size()%2==0){
                    list.add(poll.val);
                }else {
                    list.addFirst(poll.val);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
