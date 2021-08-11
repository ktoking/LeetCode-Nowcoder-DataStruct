package LeetCode;

public class Test_5_10__236 {

    public static void main(String[] args) {
//        root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left==null&&right==null) return null;
        else if(left!=null&&right!=null) return root;
        else return left==null?right:left;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }
}
