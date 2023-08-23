package LeetCode;

import io.swagger.models.auth.In;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 */

class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
public class Test_10_22__429 {
    /**
     * 多叉树的层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> lists=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            while (size-->0){
                Node poll = queue.poll();
                list.add(poll.val);
                if(poll.children!=null){
                    for (int i = 0; i < poll.children.size(); i++) {
                        queue.offer(poll.children.get(i));
                    }
                }
            }
            lists.add(list);
        }
        return lists;
    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            while (size-->0){
                Node poll = queue.poll();
                list.add(poll.val);
                if(poll.children!=null||poll.children.size()>0){
                    for (Node child : poll.children) {
                        queue.add(child);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> levelOrder2(Node root) {
       List<List<Integer>> res=new ArrayList<>();
       if(root==null) return res;
       Queue<Node> queue=new LinkedList<>();
       queue.offer(root);
       while (!queue.isEmpty()){
           List<Integer> list=new ArrayList<>();
           int size=queue.size();
           while (size-->0){
               Node poll = queue.poll();
               if(!CollectionUtils.isEmpty(poll.children)){
                   for (Node child : poll.children) {
                       queue.offer(child);
                   }
               }
               list.add(poll.val);
           }
           res.add(list);
       }
       return res;
    }




}
