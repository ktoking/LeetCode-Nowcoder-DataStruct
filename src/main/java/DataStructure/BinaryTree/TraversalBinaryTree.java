package DataStructure.BinaryTree;

import java.util.Stack;
import java.util.TreeMap;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val){
        this.val=val;
    }
}
public class TraversalBinaryTree {
    public static void main(String[] args) {

    }

    /**
     * 二叉树前序遍历(递归)
     * @param root
     */
    public void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "->");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }
    /**
     * 二叉树非递归前序遍历
     * @param root
     */
    public void preOrderTraverse1NotDiGui(TreeNode root) {
        if(root==null) return;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode temp=root;
        while (temp!=null||!stack.isEmpty()){
            if(temp!=null){
                System.out.print(temp.val+ "->");
                stack.push(temp);
                temp=temp.left;
            }else {
                TreeNode right=stack.pop();
                temp=right.right;
            }
        }
    }

    /**
     * 二叉树中序遍历(递归)
     * @param root
     */
    public void inOrderTraverse(TreeNode root) {
        if (root != null) {
            inOrderTraverse(root.left);
            System.out.print(root.val + "->");
            inOrderTraverse(root.right);
        }
    }
    /**
     * 二叉树非递归中序遍历
     * @param root
     */
    public void inOrderTraverseNotDiGui(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode temp=root;
        while (temp!=null||!stack.isEmpty()){
            if(temp!=null){
                stack.push(temp);
                temp=temp.left;
            }else {
                TreeNode pop = stack.pop();
                System.out.print(pop.val+ "->");
                stack.push(pop.right);
            }
        }
    }

    /**
     * 二叉树后序遍历(递归)
     * @param root
     */
    public void postOrderTraverse(TreeNode root) {
        if (root != null) {
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            System.out.print(root.val + "->");
        }
    }
    /**
     * 二叉树后序遍历双栈法非递归
     * @param root
     */
    public void postOrderTraverseNotDiGui(TreeNode root) {
        if(root!=null){
            Stack<TreeNode> stack1=new Stack<>();
            Stack<TreeNode> stack2=new Stack<>();
            stack1.push(root);
            while (!stack1.isEmpty()){
                root=stack1.pop();
                stack2.push(root);
                if(root.left!=null) stack1.push(root.left);
                if(root.right!=null) stack1.push(root.right);
            }
            while (!stack2.isEmpty()){
                System.out.print(stack2.pop()+"->");
            }
        }
    }
}
