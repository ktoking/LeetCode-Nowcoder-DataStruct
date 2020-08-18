package LeetCode.swordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 *
 * 提示：
 *
 * 节点总数 <= 1000
 */
public class Offer_8_18_32ii {
    /**
     * 层序遍历，每次记录每一层的节点数
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        if(root==null) return lists;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            while (size-->0){
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left!=null) queue.offer(poll.left);
                if(poll.right!=null) queue.offer(poll.right);
            }
            lists.add(list);
        }
        return lists;
    }
}
