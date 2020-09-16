package BUFFcode.WrittenTest.W58TongCheng;


import java.util.*;

public class Main1 {
    public static void main(String[] args) {

    }

    /**
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int firstMissingPositive (int[] nums) {
        Arrays.sort(nums);
        int val=1;
        for (int num : nums) {
            if(num==val){
                num+=1;
            }
        }
        return val;
    }

     class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
      }
    /**
     *
     * @param node TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> printNode (TreeNode node) {
        Queue<TreeNode> queue=new LinkedList<>();
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list=new ArrayList<>();
            while (size-->0){
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
