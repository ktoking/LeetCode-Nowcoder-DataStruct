package LeetCode.swordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
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
 * 返回：
 *
 * [3,9,20,15,7]
 *
 *
 * 提示：
 *
 * 节点总数 <= 1000
 */
public class Offer_8_18_32i {

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null) return new int[0];
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            list.add(poll.val);
            if(poll.left!=null){
                queue.offer(poll.left);
            }
            if(poll.right!=null){
                queue.offer(poll.right);
            }
        }
        int[] ints = list.stream().mapToInt(Integer::intValue).toArray();//steam流来转换为int数组
        return ints;
    }
}
