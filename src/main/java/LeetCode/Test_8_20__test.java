package LeetCode;

import java.util.*;

public class Test_8_20__test {
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        TreeNode treeNode1=new TreeNode(2);
        TreeNode treeNode2=new TreeNode(3);
        TreeNode treeNode3=new TreeNode(4);
        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode1.left=treeNode3;
        List<List<TreeNode>> lists = levelOrder(treeNode);
        System.out.println(levelOrder(treeNode));
    }

    /**
     * 二叉树层序遍历 相邻层逆序
     * @param root
     * @return
     */
    public static List<List<TreeNode>> levelOrder(TreeNode root){
        int i=0;
        if(root==null) return null;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        List<List<TreeNode>> lists=new ArrayList<>();
        while (!queue.isEmpty()){
            int size=queue.size();
            List<TreeNode> list=new ArrayList<>();
            while (size-->0){
                TreeNode poll = queue.poll();
                list.add(poll);
                if(poll.left!=null) queue.offer(poll.left);
                if(poll.right!=null) queue.offer(poll.right);
            }
            i++;
            if(i%2==0){
                Collections.reverse(list);
                lists.add(list);
            }else {
                lists.add(list);
            }
        }
        return lists;
    }
}
